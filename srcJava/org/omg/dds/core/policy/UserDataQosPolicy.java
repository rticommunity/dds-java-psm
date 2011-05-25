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

import org.omg.dds.core.Entity;
import org.omg.dds.core.policy.modifiable.ModifiableUserDataQosPolicy;
import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.sub.DataReader;


/**
 * User data not known by the middleware, but distributed by means of
 * built-in topics. The default value is an empty (zero-sized) sequence.
 * 
 * <b>Concerns:</b> {@link DomainParticipant}, {@link DataReader},
 *                 {@link DataWriter}
 * 
 * <b>RxO:</b> No
 * 
 * <b>Changeable:</b> Yes
 * 
 * The purpose of this QoS is to allow the application to attach additional
 * information to the created {@link Entity} objects such that when a remote
 * application discovers their existence it can access that information and
 * use it for its own purposes. One possible use of this QoS is to attach
 * security credentials or some other information that can be used by the
 * remote application to authenticate the source. In combination with
 * operations such as
 * {@link DomainParticipant#ignoreParticipant(org.omg.dds.core.InstanceHandle)},
 * {@link DomainParticipant#ignorePublication(org.omg.dds.core.InstanceHandle)},
 * {@link DomainParticipant#ignoreSubscription(org.omg.dds.core.InstanceHandle)},
 * and
 * {@link DomainParticipant#ignoreTopic(org.omg.dds.core.InstanceHandle)}
 * these QoS can assist an application to define and enforce its own security
 * policies. The use of this QoS is not limited to security, rather it offers
 * a simple, yet flexible extensibility mechanism.
 */
public interface UserDataQosPolicy
extends QosPolicy<UserDataQosPolicy, ModifiableUserDataQosPolicy> {
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
}
