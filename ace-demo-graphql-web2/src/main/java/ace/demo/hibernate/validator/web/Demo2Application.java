package ace.demo.hibernate.validator.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/26 15:16
 * @description
 */
@Slf4j
@SpringBootApplication
public class Demo2Application {


    public static void main(String[] args) {
        try {
            SpringApplication.run(Demo2Application.class, args);
        } catch (Exception ex) {
            log.error("1", ex);
        }
    }
}
