package ace.demo.mapstruct;

import ace.demo.mapstruct.converter.VoConverter;
import ace.demo.mapstruct.model.Voa;
import ace.demo.mapstruct.model.Vob;
import ace.fw.json.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/23 15:25
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapStructApplication.class)
public class TestMapStruct {
    @Autowired
    private VoConverter voConverter;

    @Test
    public void test() {
        Vob vob = Vob.builder()
                .a("a")
                .build();
        Voa voa = voConverter.toVoa(vob);

        log.info(JsonUtils.toJson(voa));
    }
}
