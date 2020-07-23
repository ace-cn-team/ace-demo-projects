package ace.demo.mapstruct.converter;

import ace.demo.mapstruct.model.Voa;
import ace.demo.mapstruct.model.Vob;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/23 15:25
 * @description
 */
@Mapper(componentModel = "spring")
public interface VoConverter {

    Voa toVoa(Vob vob);
}
