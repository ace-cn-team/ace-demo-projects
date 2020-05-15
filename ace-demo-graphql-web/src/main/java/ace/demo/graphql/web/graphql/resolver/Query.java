package ace.demo.graphql.web.graphql.resolver;

import ace.demo.graphql.web.graphql.type.Author;
import ace.demo.graphql.web.graphql.type.Book;
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
    List<Book> allBookList = new ArrayList<>();
    List<Author> allAuthorList = new ArrayList<>();

    public Query() {
        allBookList.add(Book.builder()
                .id("book1")
                .name("book1")
                .pageCount(1)
                .build());
        allBookList.add(Book.builder()
                .id("2")
                .name("2")
                .pageCount(2)
                .build());


        allAuthorList.add(Author.builder()
                .firstName("author1")
                .lastName("author1")
                .id("1")
                .build());

        allAuthorList.add(Author.builder()
                .firstName("author2")
                .lastName("author2")
                .id("2")
                .build());
    }


    public Book bookById(String id) {
        return allBookList.get(0);
    }

}
