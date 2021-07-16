package codegen;

import net.binis.codegen.SubImpl;
import net.binis.codegen.TestImpl;
import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseTest;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static net.binis.codegen.mock.CodeGenMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryEnrichTest extends BaseTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    public void enrichQuery() {
        //testSingle("enrich/enrichQuery.java", "enrich/enrichQuery-0.java", "enrich/enrichQuery-1.java");
        testMulti(List.of(
                Triple.of("enrich/enrichQuerySub.java", "enrich/enrichQuerySub-0.java", "enrich/enrichQuerySub-1.java"),
                Triple.of("enrich/enrichQuery.java", "enrich/enrichQuery-0.java", "enrich/enrichQuery-1.java")
        ), "./src/main/java/net/binis/codegen");
    }

    @Test
    public void enrichQueryModifier() {
        testMulti(List.of(
                Triple.of("enrich/enrichQueryModifySub.java", "enrich/enrichQueryModifySub-0.java", "enrich/enrichQueryModifySub-1.java"),
                Triple.of("enrich/enrichQueryModify.java", "enrich/enrichQueryModify-0.java", "enrich/enrichQueryModify-1.java")
        ));
    }


    @Test
    public void enrichQueryTest() {
        mockContext();
        mockCreate(TestImpl.class);
        mockCreate(SubImpl.class);

        checkQuery("from net.binis.codegen.Sub u where (subAmount = ?1)", List.of(5.9),
                () -> net.binis.codegen.Sub.find().by().subAmount(5.9).get());

        checkQuery("from net.binis.codegen.Test u where (parent.parent.parent.title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().parent().parent().parent().title().equal("asd").get());

        checkQuery("from net.binis.codegen.Test u where (title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (title = ?1) order by  title", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().title("asd").order().title().get());

        checkQuery("from net.binis.codegen.Test u where (title = ?1) order by  title asc", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().title("asd").order().title().asc().get());

        checkQuery("from net.binis.codegen.Test u where (title = ?1) order by  title asc, title desc", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().title("asd").order().title().asc().title().desc().get());

        checkQuery("from net.binis.codegen.Test u  order by  title", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().order().title().get());

        checkQuery("from net.binis.codegen.Test u  order by  title asc, amount desc", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().order().title().asc().amount().desc().get());

        checkQuery("from net.binis.codegen.Test u where not  (u.title like ?1)", List.of("%asd"),
                () -> net.binis.codegen.Test.find().by().not().title().like("%asd").get());

        checkQuery("select count(*) from net.binis.codegen.Test u ", Collections.emptyList(), 0L,
                () -> net.binis.codegen.Test.find().by().count());

        checkQuery("from net.binis.codegen.Test u where (parent.title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (parent.title = ?1) or  (title = ?2)", List.of("asd", "asd"),
                () -> net.binis.codegen.Test.find().by().parent().title("asd").or().title().equal("asd").get());

        checkQuery("from net.binis.codegen.Test u where (sub.subtitle = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().sub().subtitle("asd").get());

        checkQuery("from net.binis.codegen.Test u where (parent.sub.subtitle = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().parent().sub().subtitle("asd").get());

        checkQuery("from net.binis.codegen.Test u where (parent.parent.sub.subtitle = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().parent().parent().sub().subtitle().equal("asd").get());

        checkQuery("from net.binis.codegen.Test u where (parent is null)", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().parent(null).get());

        checkQuery("from net.binis.codegen.Test u where (lower(u.title) like ?1)", List.of("%asd"),
                () -> net.binis.codegen.Test.find().by().lower().title().like("%asd").get());

        checkQuery("from net.binis.codegen.Test u where (lower(u.title) = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().lower().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (lower(u.parent.parent.title) = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().lower().parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (substr(u.parent.parent.title, ?1) = ?2)", List.of(5, "asd"),
                () -> net.binis.codegen.Test.find().by().substring(5).parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (substr(u.parent.parent.title, ?1, ?2) = ?3)", List.of(5, 10, "asd"),
                () -> net.binis.codegen.Test.find().by().substring(5, 10).parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (trim(u.parent.parent.title) = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().by().trim().parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (replace(u.parent.parent.title, ?1, ?2) = ?3)", List.of("some", "someother", "asd"),
                () -> net.binis.codegen.Test.find().by().replace("some", "someother").parent().parent().title("asd").get());

        checkQuery("from net.binis.codegen.Test u where (length(parent.parent.title) > ?1)", List.of(5L),
                () -> net.binis.codegen.Test.find().by().parent().parent().title().length().greater(5L).get());

        checkQuery("from net.binis.codegen.Test u where (title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().query("from net.binis.codegen.Test u where (title = ?1)").params(List.of("asd")).get());

        checkQuery("from net.binis.codegen.Test u where (title = ?1)", List.of("asd"),
                () -> net.binis.codegen.Test.find().query("from net.binis.codegen.Test u where (title = ?1)").param("asd").get());

        checkQuery("from net.binis.codegen.Test u  order by  title ", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().order().script("title").get());

        checkQuery("from net.binis.codegen.Test u where length(title) > 5  and  (amount > 10)  order by  title ", Collections.emptyList(),
                () -> net.binis.codegen.Test.find().by().script("length(title) > 5").and().amount().script("> 10").order().script("title").get());

        checkQuery("from net.binis.codegen.Test u where (amount = ?1) and  (length(parent.parent.title) > ?2)", List.of(5.0, 5L),
                () -> net.binis.codegen.Test.find().by(true, query -> query.amount(5).and()).parent().parent().title().length().greater(5L).get());

        checkQuery("from net.binis.codegen.Test u where (length(parent.parent.title) > ?1)", List.of(5L),
                () -> net.binis.codegen.Test.find().by(false, query -> query.amount(5).and()).parent().parent().title().length().greater(5L).get());

        checkQuery("from net.binis.codegen.Test u where (length(parent.parent.title) > ?1) and  (amount = ?2)", List.of(5L, 5.0),
                () -> net.binis.codegen.Test.find().by().parent().parent().title().length().greater(5L)
                        ._if(true, query -> query.and().amount(5))
                        ._else(query -> query.and().amount(6))
                        .get());

        checkQuery("from net.binis.codegen.Test u where (length(parent.parent.title) > ?1) and  (amount = ?2)", List.of(5L, 6.0),
                () -> net.binis.codegen.Test.find().by().parent().parent().title().length().greater(5L)._if(false, query -> query.and().amount(5))._else(query -> query.and().amount(6)).get());

        checkQuery("select avg(subAmount),avg(subtitle) from net.binis.codegen.Sub u where (subAmount = ?1)", List.of(5.0),
                () -> net.binis.codegen.Sub.find().aggregate().avg().subAmount().and().avg().subtitle().where().subAmount(5).get());

//        net.binis.codegen.Test.find().by().parent().title("asd").top(5L);
//
//        net.binis.codegen.Test.find().query("from user").get();
//
//        net.binis.codegen.Test.find().nativeQuery("from user").get();

     }

     private void checkQuery(String expected, List<Object> params, Runnable query) {
         checkQuery(expected, params, null, query);
     }

    private void checkQuery(String expected, List<Object> params, Object result, Runnable query) {
        mockQueryProcessor((q, p) -> {
            assertEquals(expected, q);
            assertEquals(params.size(), p.size());
            for (int i = 0; i < params.size(); i++) {
                assertEquals(params.get(i), p.get(i));
            }
            return result;
        });
        query.run();
    }

}