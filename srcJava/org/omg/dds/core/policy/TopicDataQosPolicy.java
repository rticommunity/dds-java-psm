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

package org.omg.dds.core.policy;

import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.sub.DataReader;
import org.omg.dds.topic.Topic;


/**
 * User data not known by the middleware, but distributed by means of
 * built-in topics. The default value is an empty (zero-sized) sequence.
 * 
 * <b>Concerns:</b> {@link Topic}
 * 
 * <b>RxO:</b> No
 * 
 * <b>Changeable:</b> Yes
 * 
 * The purpose of this QoS is to allow the application to attach additional
 * information to the created {@link Topic}s such that when a remote
 * application discovers their existence it can examine the information and
 * use it in an application-defined way. In combination with the listeners on
 * the {@link DataReader} and {@link DataWriter} as well as by means of
 * operations such as
 * {@link DomainParticipant#ignoreTopic(org.omg.dds.core.InstanceHandle)},
 * these QoS can assist an application to extend the provided QoS.
 */
public interface TopicDataQosPolicy extends QosPolicy
{
    /**
     * Copy the data into the given array, starting at the index at the given
     * offset.
     * 
     * @return  The total number of bytes in the data, independent of the
     *          number of bytes copied. Callers can use this result to
     *          determine if the output array is long enough or, if it is
     *          long enough, what range within it contains valid data.
     */
    public int getValue(byte[] value, int offset);

    /**
     * @return  the length of the <code>value</code> property.
     */
    public int getLength();


    // --- Modification: -----------------------------------------------------

    /**
     * Copy this policy and override the value of the property.
     * 
     * @return  a new policy
     */
    public TopicDataQosPolicy withValue(byte value[], int offset, int length);
}
