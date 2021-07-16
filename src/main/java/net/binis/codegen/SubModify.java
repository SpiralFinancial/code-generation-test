/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

public interface SubModify extends Base {

    static QueryStarter<SubModify, SubModify.QuerySelect<SubModify>, QueryAggregateOperation<QueryOperationFields<SubModify.QueryAggregate<Number, SubModify.QuerySelect<Number>>>>> find() {
        return (QueryStarter) EntityCreator.create(SubModify.QuerySelect.class);
    }

    double getSubAmount();

    String getSubtitle();

    void setSubAmount(double subAmount);

    void setSubtitle(String subtitle);

    SubModify.Modify with();

    interface EmbeddedModify<T> extends SubModify.Fields<SubModify.EmbeddedModify<T>> {

        EmbeddedCodeCollection<EmbeddedModify<T>, SubModify, T> and();
    }

    interface Fields<T> extends Base.Fields<T> {

        T subAmount(double subAmount);

        T subtitle(String subtitle);
    }

    interface Modify extends SubModify.Fields<SubModify.Modify> {

        SubModify done();
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<SubModify.QueryAggregate<SubModify, SubModify.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, SubModify.Fields<QR> {
    }

    interface QueryFuncs<QR> {

        QueryFunctions<OffsetDateTime, QR> date();

        QueryFunctions<Long, QR> id();

        QueryFunctions<Double, QR> subAmount();

        QueryFunctions<String, QR> subtitle();

        QueryFunctions<TestEnum, QR> type();
    }

    interface QueryName<QS, QO, QR> extends SubModify.QueryFields<QuerySelectOperation<QS, QO, QR>>, SubModify.QueryFuncs<QuerySelectOperation<QS, QO, QR>> {
    }

    interface QueryOperationFields<QR> {

        QR date();

        QR id();

        QR subAmount();

        QR subtitle();

        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<SubModify.QueryOrder<QR>, QR>>, QueryExecute<QR>, QueryScript<QueryOrderOperation<SubModify.QueryOrder<QR>, QR>> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>>, SubModify.QueryFields<QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>>, SubModify.QueryFuncs<QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>> {

        SubModify.QueryOrder<QR> order();
    }
}