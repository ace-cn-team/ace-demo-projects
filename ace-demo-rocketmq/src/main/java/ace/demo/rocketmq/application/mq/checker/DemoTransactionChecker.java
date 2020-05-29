package ace.demo.rocketmq.application.mq.checker;

import ace.demo.rocketmq.application.DemoMessage;
import ace.demo.rocketmq.application.biz.DemoTransactionBiz;
import ace.fw.mq.enums.*;
import ace.fw.mq.model.MessageContext;
import ace.fw.mq.model.TransactionMessage;
import ace.fw.mq.producer.TransactionMQChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/4/14 10:54
 * @description
 */
@Component
public class DemoTransactionChecker implements TransactionMQChecker<DemoMessage, String> {
    @Autowired
    public DemoTransactionBiz demoTransactionBiz;

    @Override
    public TransactionStatusEnum executeLocalTransaction(TransactionMessage<DemoMessage> message, String arg) {

        return demoTransactionBiz.executeLocalTransaction(message, arg);

    }

    @Override
    public TransactionStatusEnum checkLocalTransaction(MessageContext<DemoMessage> messageContext) {
        return demoTransactionBiz.checkLocalTransaction(messageContext);

    }
}
