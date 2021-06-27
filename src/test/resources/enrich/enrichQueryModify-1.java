/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.CodeList;
import java.util.Optional;
import java.util.List;

public interface Test {

    static QueryStarter<Test, Test.QuerySelect<Test>> find() {
        return (QueryStarter) EntityCreator.create(Test.QuerySelect.class);
    }

    double getAmount();

    List<Long> getItems();

    Test getParent();

    Sub getSub();

    String getTitle();

    void setAmount(double amount);

    void setItems(List<Long> items);

    void setParent(Test parent);

    void setSub(Sub sub);

    void setTitle(String title);

    Test.Modify with();

    interface Fields<T> {

        T amount(double amount);

        T parent(Test parent);

        T sub(Sub sub);

        T title(String title);
    }

    interface Modify extends Test.Fields<Test.Modify> {

        Test done();

        Modify items(List<Long> items);

        CodeList<Long, Modify> items();
    }

    interface QueryFields<QR> extends QueryScript<QR>, Test.Fields<QR> {

        QR items(Long in);
    }

    interface QueryFuncs<QR> {

        QueryFunctions<Double, QR> amount();

        QueryFunctions<String, QR> title();
    }

    interface QueryName<QS, QO, QR> extends Test.QueryFields<QuerySelectOperation<QS, QO, QR>>, Test.QueryFuncs<QuerySelectOperation<QS, QO, QR>> {

        Test.QueryName<QS, QO, QR> parent();

        Sub.QueryName<QS, QO, QR> sub();
    }

    interface QueryOrder<QR> extends QueryExecute<QR>, QueryScript<QueryOrderOperation<Test.QueryOrder<QR>, QR>> {

        QueryOrderOperation<Test.QueryOrder<QR>, QR> amount();

        QueryOrderOperation<Test.QueryOrder<QR>, QR> parent();

        QueryOrderOperation<Test.QueryOrder<QR>, QR> sub();

        QueryOrderOperation<Test.QueryOrder<QR>, QR> title();
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFields<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>>, Test.QueryFuncs<QuerySelectOperation<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR>> {

        Test.QueryOrder<QR> order();

        Test.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> parent();

        Sub.QueryName<Test.QuerySelect<QR>, Test.QueryOrder<QR>, QR> sub();
    }
}
