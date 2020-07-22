package ace.demo.hibernate.validator.web.graphql.resolver;

import ace.demo.hibernate.validator.web.graphql.type.Human;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/26 16:12
 * @description
 */
@Component
public class Query implements GraphQLQueryResolver {

    List<Human> allHumanList = new ArrayList<>();

    public Query() {

        allHumanList.add(Human.builder()
                .firstName("author1")
                .lastName("author1")
                .id("1")
                .build());

        allHumanList.add(Human.builder()
                .firstName("author2")
                .lastName("author2")
                .id("2")
                .build());
    }


    public Human getHumanById(String id) {
        return allHumanList.get(0);
    }


}
