package ace.demo.rocketmq.application.mq.listener;

import ace.demo.rocketmq.application.DemoMessage;
import ace.demo.rocketmq.application.biz.DemoTransactionBiz;
import ace.demo.rocketmq.application.mq.topic.DemoTopicEnum;
import ace.demo.rocketmq.application.mq.topic.DemoTransTopicEnum;
import ace.fw.mq.consumer.MQListener;
import ace.fw.mq.enums.MQResponseEnum;
import ace.fw.mq.model.MessageContext;
import ace.fw.mq.model.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/4/11 17:18
 * @description
 */
@Slf4j
@Component
public class DemoTransactionListener implements MQListener<DemoMessage> {
    public static AtomicInteger receiveCount = new AtomicInteger(0);
    @Autowired
    public DemoTransactionBiz demoTransactionBiz;
    @Override
    public Topic getSubscribeTopic() {
        return DemoTransTopicEnum.DEMO;
    }

    @Override
    public MQResponseEnum consume(MessageContext messageContext) {
        log.info(messageContext.toString());
        receiveCount.addAndGet(1);
        return MQResponseEnum.CommitMessage;
    }
}
