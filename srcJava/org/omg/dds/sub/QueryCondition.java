/* Copyright 2010, Object Management Group, Inc.
 * Copyright 2010, PrismTech, Inc.
 * Copyright 2010, Real-Time Innovations, Inc.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omg.dds.sub;

import java.util.List;


/**
 * QueryCondition objects are specialized {@link ReadCondition} objects that
 * allow the application to also specify a filter on the locally available
 * data.
 * 
 * The query (queryExpression) is similar to an SQL WHERE clause can be
 * parameterized by arguments that are dynamically changeable by the
 * {@link #setQueryParameters(List)} operation.
 * 
 * This feature is optional. In the cases where it is not supported, the
 * {@link DataReader#createQueryCondition(String, List)} will return null.
 * 
 * @param <TYPE>    The concrete type of the data that can be read using the
 *                  the {@link DataReader} that created this QueryCondition.
 */
public interface QueryCondition<TYPE> extends ReadCondition<TYPE> {
    public String getQueryExpression();

    /**
     * @return  an unmodifiable list of the current query parameters.
     */
    public List<String> getQueryParameters();

    public void setQueryParameters(List<String> queryParameters);
}
