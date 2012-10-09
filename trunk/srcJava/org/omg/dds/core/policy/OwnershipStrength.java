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
import org.omg.dds.topic.Topic;


/**
 * [optional] Specifies the value of the "strength" used to arbitrate among
 * multiple {@link DataWriter} objects that attempt to modify the same
 * instance of a data object (identified by {@link Topic} + key). This policy
 * only applies if the {@link Ownership#getKind()} is
 * {@link Ownership.Kind#EXCLUSIVE}. The default value of the
 * ownership strength is zero.
 * 
 * <b>Concerns:</b> {@link DataWriter}
 * 
 * <b>RxO:</b> N/A
 * 
 * <b>Changeable:</b> Yes
 * 
 * @see Ownership
 */
public interface OwnershipStrength extends QosPolicy.ForDataWriter
{
    /**
     * @return the value
     */
    public int getValue();


    // --- Modification: -----------------------------------------------------

    /**
     * Copy this policy and override the value of the property.
     * 
     * @return  a new policy
     */
    public OwnershipStrength withValue(int value);
}
