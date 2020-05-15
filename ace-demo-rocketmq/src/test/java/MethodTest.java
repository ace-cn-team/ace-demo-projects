import ace.fw.mq.rocketmq.impl.consumer.MQConsumerImpl;
import ace.fw.mq.rocketmq.property.RocketMQAutoConfigureProperty;
import ace.fw.mq.rocketmq.property.RocketMQConsumerProperty;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/4/10 16:11
 * @description
 */

public class MethodTest {

    @Test
    public void a() {

        String mqListenerBeanName = "a";

        Predicate<Map.Entry<String, String>> filter1 = p -> StringUtils.equalsIgnoreCase(p.getKey(), mqListenerBeanName);
        Predicate<Map.Entry<String, String>> filter2 = p -> StringUtils.equalsIgnoreCase(p.getValue(), mqListenerBeanName);
        Map.Entry<String, String> data1 = new AbstractMap.SimpleEntry<>("a", "b");
        System.out.println(filter1.or(filter2).test(data1));

        Map.Entry<String, String> data2 = new AbstractMap.SimpleEntry<>("b", "a");
        System.out.println(filter1.or(filter2).test(data2));

        Map.Entry<String, String> data3 = new AbstractMap.SimpleEntry<>("a", "a");
        System.out.println(filter1.or(filter2).test(data3));

        Map.Entry<String, String> data4 = new AbstractMap.SimpleEntry<>("b", "b");
        System.out.println(filter1.or(filter2).test(data4));
    }

    @Test
    public void k() {
        Map<String, RocketMQConsumerProperty> mqConsumerPropertyMap = new HashMap<>();
        mqConsumerPropertyMap.put("test", RocketMQConsumerProperty.builder()
                .beanName("demoListener")
                .build());
        RocketMQAutoConfigureProperty rocketMQAutoConfigureProperty = RocketMQAutoConfigureProperty.builder()
                .mqConsumer(mqConsumerPropertyMap)
                .build();
        String mqListenerBeanName = "demoListener";
        Predicate<Map.Entry<String, RocketMQConsumerProperty>> propertyMapKeyFilter = p -> StringUtils.equalsIgnoreCase(p.getKey(), mqListenerBeanName);
        Predicate<Map.Entry<String, RocketMQConsumerProperty>> propertyBeanNameFilter = p -> StringUtils.equalsIgnoreCase(p.getValue().getBeanName(), mqListenerBeanName);

        List<Map.Entry<String, RocketMQConsumerProperty>> properties = rocketMQAutoConfigureProperty
                .getMqConsumer()
                .entrySet()
                .stream()
                .filter(p -> propertyMapKeyFilter.or(propertyBeanNameFilter).test(p))
                .collect(Collectors.toList());
        if (properties.size() == 0) {
            System.out.println("failure null");
        }
        if (properties.size() > 2) {
            String msg = String.format("[bean name:%s] mq listener config must be one,but find more than one", mqListenerBeanName);
            throw new RuntimeException(msg);
        }
        System.out.println("success");
    }
}
