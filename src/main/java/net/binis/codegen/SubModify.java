/*Generated code by Binis' code generator.*/
package net.binis.codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 Binis Belev
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import net.binis.codegen.spring.query.*;
import net.binis.codegen.intf.Taggable;
import net.binis.codegen.enums.TestEnum;
import net.binis.codegen.creator.EntityCreator;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.annotation.processing.Generated;
import java.util.Optional;
import java.util.List;
import java.time.OffsetDateTime;

@Generated(value = "SubModifyPrototype", comments = "SubModifyImpl")
public interface SubModify extends Base, Taggable {

    static SubModify create() {
        return EntityCreator.create(SubModify.class, "net.binis.codegen.SubModifyImpl");
    }

    static QueryStarter<SubModify, SubModify.QuerySelect<SubModify>, QueryAggregateOperation<QueryOperationFields<SubModify.QueryAggregate<Number, SubModify.QuerySelect<Number>>>>, QueryFieldsStart<SubModify, SubModify.QuerySelect<SubModify>>> find() {
        return (QueryStarter) EntityCreator.create(SubModify.QuerySelect.class, "net.binis.codegen.SubModifyImpl");
    }

    double getSubAmount();

    String getSubtitle();

    void setSubAmount(double subAmount);

    void setSubtitle(String subtitle);

    <T> void setTag(T tag);

    SubModify.Modify with();

    interface EmbeddedModify<T> extends SubModify.Fields<SubModify.EmbeddedModify<T>> {

        EmbeddedCodeCollection<EmbeddedModify<T>, SubModify, T> and();
    }

    interface Fields<T> extends Base.Fields<T> {

        T subAmount(double subAmount);

        T subtitle(String subtitle);

        T tag(Object tag);
    }

    interface Modify extends SubModify.Fields<SubModify.Modify> {

        SubModify done();
    }

    interface QueryAggregate<QR, QA> extends QueryExecute<QR>, QueryAggregator<QA, QueryAggregateOperation<QueryOperationFields<SubModify.QueryAggregate<SubModify, SubModify.QuerySelect<Number>>>>> {
    }

    interface QueryFields<QR> extends QueryScript<QR>, SubModify.Fields<QR> {
    }

    interface QueryFieldsStart<QR, QS> extends QueryExecute<QR>, QueryWhere<QS>, QueryOperationFields<QueryFieldsStart<QR, QS>> {
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

    interface QueryOperationFields<QR> extends QueryScript<QR> {

        QR date();

        QR id();

        QR subAmount();

        QR subtitle();

        QR type();
    }

    interface QueryOrder<QR> extends QueryOperationFields<QueryOrderOperation<SubModify.QueryOrder<QR>, QR>>, QueryExecute<QR>, QueryScript<QueryOrderOperation<SubModify.QueryOrder<QR>, QR>> {
    }

    interface QuerySelect<QR> extends QueryExecute<QR>, QueryModifiers<SubModify.QueryName<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>>, SubModify.QueryFields<QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>>, SubModify.QueryFuncs<QuerySelectOperation<SubModify.QuerySelect<QR>, SubModify.QueryOrder<QR>, QR>>, QueryOrderStart<QueryOperationFields<QueryOrderOperation<SubModify.QueryOrder<QR>, QR>>>, QueryBracket<QuerySelect<QR>> {
    }
}
