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

import org.omg.dds.pub.DataWriter;
import org.omg.dds.pub.DataWriterListener;
import org.omg.dds.pub.Publisher;
import org.omg.dds.sub.DataReader;
import org.omg.dds.sub.DataReaderListener;
import org.omg.dds.sub.Subscriber;


/**
 * User data not known by the middleware, but distributed by means of
 * built-in topics. The default value is an empty (zero-sized) sequence.
 * 
 * <b>Concerns:</b> {@link Publisher}, {@link Subscriber}
 * 
 * <b>RxO:</b> No
 * 
 * <b>Changeable:</b> Yes
 * 
 * The purpose of this QoS is to allow the application to attach additional
 * information to the created {@link Publisher} or {@link Subscriber}. The
 * value of the GROUP_DATA is available to the application on the
 * {@link DataReader} and {@link DataWriter} entities and is propagated by
 * means of the built-in topics.
 * 
 * This QoS can be used by an application combination with the
 * {@link DataReaderListener} and {@link DataWriterListener} to implement
 * matching policies similar to those of the {@link PartitionQosPolicy}
 * except the decision can be made based on an application-defined policy.
 */
public interface GroupDataQosPolicy extends QosPolicy
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
    public GroupDataQosPolicy withValue(byte value[], int offset, int length);
}
