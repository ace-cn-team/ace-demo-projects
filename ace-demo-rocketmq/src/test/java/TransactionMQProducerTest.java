import ace.demo.rocketmq.application.DemoMessage;
import ace.demo.rocketmq.application.DemoRocketMQApplication;
import ace.demo.rocketmq.application.biz.DemoBiz;
import ace.demo.rocketmq.application.biz.DemoTransactionBiz;
import ace.demo.rocketmq.application.mq.checker.DemoTransactionChecker;
import ace.demo.rocketmq.application.mq.listener.DemoTransactionListener;
import ace.demo.rocketmq.application.mq.topic.DemoTransTopicEnum;
import ace.fw.mq.model.TransactionMessage;
import ace.fw.mq.producer.TransactionMQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/4/10 16:11
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoRocketMQApplication.class})
@TestPropertySource("classpath:application.properties")
public class TransactionMQProducerTest {
    @Autowired
    private TransactionMQProducer<DemoMessage, String> transactionMQProducer;
    @Autowired
    private DemoTransactionBiz demoTransactionBiz;
    @Autowired
    private DemoTransactionChecker demoTransactionChecker;
    @Autowired
    private DemoTransactionListener demoTransactionListener;
    @Autowired
    private DemoBiz demoBiz;

    @Test
    public void sendAndListenMessage() {
        Assert.notNull(demoTransactionBiz);
        Assert.notNull(demoTransactionChecker);
        int sendMsgTotalCount = 10;
        for (int i = 0; i < sendMsgTotalCount; i++) {
            TransactionMessage<DemoMessage> message = TransactionMessage.<DemoMessage>builder()

                    .body(DemoMessage
                            .builder()
                            .key("key2")
                            .value(1)
                            .subMessage(
                                    DemoMessage
                                            .builder()
                                            .key("key2")
                                            .value(2)
                                            .build()
                            )
                            .build())
                    .tags(Arrays.asList("tag1", "tag2"))
                    .topic(DemoTransTopicEnum.DEMO)
                    .build();
            Assert.state(transactionMQProducer.send(message, "123").getSuccess(), "发送失败");
        }
        int listenCount = 0;
        while (DemoTransactionListener.receiveCount.get() < sendMsgTotalCount) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listenCount++;
            if (listenCount > 1000) {
                throw new RuntimeException("没有收到信息");
            }
        }
    }

}
