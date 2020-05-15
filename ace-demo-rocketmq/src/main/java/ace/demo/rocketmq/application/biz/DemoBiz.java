package ace.demo.rocketmq.application.biz;

import ace.demo.rocketmq.application.DemoMessage;
import ace.fw.mq.enums.TransactionStatusEnum;
import ace.fw.mq.model.MessageContext;
import ace.fw.mq.model.TransactionMessage;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/4/14 10:57
 * @description
 */
@Component
@Slf4j
public class DemoBiz {
    @Autowired
    private DemoTransactionBiz demoTransactionBiz;

    public TransactionStatusEnum checkLocalTransaction(MessageContext<DemoMessage> messageContext) {

        log.info("checkLocalTransaction");
        log.info(JSON.toJSONString(messageContext));
        int status = RandomUtils.nextInt(1, 100);
        if (status > 90) {
            log.info("trans event success");
            return TransactionStatusEnum.COMMIT_TRANSACTION;
        } else if (status > 60) {
            log.info("trans event rollback");
            return TransactionStatusEnum.ROLLBACK_TRANSACTION;
        } else {
            log.info("trans event unknown");
            return TransactionStatusEnum.UNKNOWN;
        }
    }
}
