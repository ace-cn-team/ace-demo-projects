import ace.demo.rocketmq.application.DemoMessage;
import ace.demo.rocketmq.application.DemoRocketMQApplication;
import ace.demo.rocketmq.application.mq.listener.DemoListener;
import ace.demo.rocketmq.application.mq.topic.DemoTopicEnum;
import ace.fw.mq.model.Message;
import ace.fw.mq.model.Topic;
import ace.fw.mq.producer.MQProducer;
import ace.fw.mq.rocketmq.property.RocketMQAutoConfigureProperty;
import ace.fw.mq.rocketmq.property.RocketMQConsumerProperty;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/4/10 16:11
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoRocketMQApplication.class})
@TestPropertySource("classpath:application.properties")
public class MQProducerTest {
    @Autowired
    @Qualifier("test")
    private MQProducer mqProducer;

    @Test
    public void send() {


        Message message = Message
                .builder()
                .body("test-body")
                .tags(Arrays.asList("tag1", "tag2"))
                .topic(new Topic() {
                    @Override
                    public String getCode() {
                        return "BenchmarkTest";
                    }

                    @Override
                    public String getDesc() {
                        return "test测试";
                    }
                };)
                .build();


        Assert.state(mqProducer.send(message).getSuccess(), "发送失败");
    }

    @Test
    public void sendAndListenMessage() {
        Message message = Message
                .builder()
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
                .topic(DemoTopicEnum.DEMO)
                .build();
        Assert.state(mqProducer.send(message).getSuccess(), "发送失败");

        int listenCount = 0;
        while (DemoListener.isReceiveMsg == false) {
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
