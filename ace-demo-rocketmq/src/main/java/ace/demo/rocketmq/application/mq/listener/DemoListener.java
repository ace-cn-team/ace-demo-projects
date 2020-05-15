package ace.demo.rocketmq.application.mq.listener;

import ace.demo.rocketmq.application.DemoMessage;
import ace.demo.rocketmq.application.mq.topic.DemoTopicEnum;
import ace.fw.mq.consumer.MQListener;
import ace.fw.mq.enums.MQResponseEnum;
import ace.fw.mq.model.MessageContext;
import ace.fw.mq.model.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/4/11 17:18
 * @description
 */
@Slf4j
@Component
public class DemoListener implements MQListener<DemoMessage> {
    public static boolean isReceiveMsg = false;

    @Override
    public Topic getSubscribeTopic() {
        return DemoTopicEnum.DEMO;
    }

    @Override
    public MQResponseEnum consume(MessageContext messageContext) {
        log.info(messageContext.toString());
        isReceiveMsg = true;
        return MQResponseEnum.CommitMessage;
    }
}
