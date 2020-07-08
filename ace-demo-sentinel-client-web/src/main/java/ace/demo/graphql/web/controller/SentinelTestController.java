package ace.account.base.api.web.application.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/8 13:43
 * @description
 */
@RestController
@Validated
public class SentinelTestController {

    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }
}
