package ace.demo.rocketmq.application.mq.topic;

import ace.fw.mq.model.Topic;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/4/11 17:21
 * @description
 */
public enum DemoTopicEnum implements Topic {
    DEMO("test", "test测试");

    @Getter
    private String code;
    @Getter
    private String desc;

    DemoTopicEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
