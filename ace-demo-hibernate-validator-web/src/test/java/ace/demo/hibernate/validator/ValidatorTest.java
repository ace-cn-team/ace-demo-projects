package ace.demo.hibernate.validator;

import ace.demo.hibernate.validator.web.HibernateValidatorApplication;
import ace.demo.hibernate.validator.web.model.bo.ValueBo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.parameternameprovider.ParanamerParameterNameProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/22 10:24
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateValidatorApplication.class)
public class ValidatorTest {
    @Autowired
    private Validator validator;

    @Test
    public void testValidator() {
        ValueBo valueBo = ValueBo.builder()
                .integer1(0)
                .build();
        Set<ConstraintViolation<ValueBo>> violations = validator.validate(valueBo);
        int k = 0;
    }
}
