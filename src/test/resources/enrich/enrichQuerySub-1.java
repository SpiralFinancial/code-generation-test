/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.query.*;
import net.binis.codegen.creator.EntityCreator;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;

@Generated(value = "SubPrototype", comments = "SubImpl")
public interface Sub {

    static QueryStarter<Sub, Sub.QuerySelect<Sub>, QueryAggregateOperation<QueryOperationFields<Sub.QueryAggregate<Number, Sub.QuerySelect<Number>>>>, QueryFieldsStart<Sub, Sub.QuerySelect<Sub>>> find() {
        return (QueryStarter) EntityCreator.create(Sub.QuerySelect.class, "net.binis.codegen.SubImpl");
    }

    double getSubAmount();

    String getSubtitle();

    void setSubAmount(double subAmount);

    void setSubtitle(String subtitle);

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<Sub.QueryAggregate<Sub, Sub.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR> {

        QR subAmount(double subAmount);

        QR subtitle(String subtitle);
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
    }

    interface QueryFuncs<QR> {

        QueryFunctions<Double, QR> subAmount();

        QueryFunctions<String, QR> subtitle();
    }

    interface QueryName<QS, QO, QR> extends Sub.QueryFields<QuerySelectOperation<QS, QO, QR>>, Sub.QueryFuncs<QuerySelectOperation<QS, QO, QR>> {
    }

    interface QueryOperationFields<QR> extends QueryScript<QR> {

        QR subAmount();

        QR subtitle();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<Sub.QueryOrder<QR>, QR>>, QueryExecute<QR>, QueryScript<QueryOrderOperation<Sub.QueryOrder<QR>, QR>> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<Sub.QueryName<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>>, Sub.QueryFields<QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>>, Sub.QueryFuncs<QuerySelectOperation<Sub.QuerySelect<QR>, Sub.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<Sub.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
    }
}
