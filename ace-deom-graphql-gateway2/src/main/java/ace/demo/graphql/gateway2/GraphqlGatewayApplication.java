package ace.demo.graphql.gateway2;

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
public class GraphqlGatewayApplication {


    public static void main(String[] args) {
        try {
            SpringApplication.run(GraphqlGatewayApplication.class, args);
        } catch (Exception ex) {
            log.error("1", ex);
        }
    }
}
