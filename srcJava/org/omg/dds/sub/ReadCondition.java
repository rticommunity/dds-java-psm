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

import java.util.Set;

import org.omg.dds.core.Condition;
import org.omg.dds.core.WaitSet;


/**
 * ReadCondition objects are conditions specifically dedicated to read
 * operations and attached to one {@link DataReader}.
 * 
 * ReadCondition objects allow an application to specify the data samples it
 * is interested in by specifying the desired sample states, view states,
 * and instance states. (See the parameter definitions for
 * {@link DataReader#read(java.util.Collection, java.util.Collection, java.util.Collection)}
 * and
 * {@link DataReader#take(java.util.Collection, java.util.Collection, java.util.Collection)}.)
 * This allows the middleware to enable the condition only when suitable
 * information is available. They are to be used in conjunction with a
 * {@link WaitSet} as normal conditions. More than one ReadCondition may be
 * attached to the same DataReader.
 * 
 * @param <TYPE>    The concrete type of the data that can be read using the
 *                  the {@link DataReader} that created this ReadCondition.
 */
public interface ReadCondition<TYPE>
extends Condition {
    /**
     * @return  an unmodifiable set.
     */
    public Set<SampleState> getSampleStates();

    /**
     * @return  an unmodifiable set.
     */
    public Set<ViewState> getViewStates();

    /**
     * @return  an unmodifiable set.
     */
    public Set<InstanceState> getInstanceStates();

    public DataReader<TYPE> getDataReader();

    /**
     * Reclaim any resources associated with this condition.
     */
    public void close();
}
