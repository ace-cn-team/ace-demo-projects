package ace.demo.rocketmq.application;

import ace.fw.mq.rocketmq.property.RocketMQAutoConfigureProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/4/10 15:35
 * @description
 */
@SpringBootApplication
public class DemoRocketMQApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoRocketMQApplication.class, args);
    }
}