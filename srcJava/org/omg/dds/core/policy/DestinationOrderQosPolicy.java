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

import org.omg.dds.core.policy.modifiable.ModifiableDestinationOrderQosPolicy;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.pub.Publisher;
import org.omg.dds.sub.DataReader;
import org.omg.dds.sub.Subscriber;
import org.omg.dds.topic.Topic;


/**
 * Controls the criteria used to determine the logical order among changes
 * made by {@link Publisher} entities to the same instance of data (i.e.,
 * matching Topic and key). The default kind is
 * {@link DestinationOrderQosPolicy.Kind#BY_RECEPTION_TIMESTAMP}.
 * 
 * <b>Concerns:</b> {@link Topic}, {@link DataReader}, {@link DataWriter}
 * 
 * <b>RxO:</b> Yes
 * 
 * <b>Changeable:</b> No
 * 
 * This policy controls how each subscriber resolves the final value of a
 * data instance that is written by multiple DataWriter objects (which may be
 * associated with different Publisher objects) running on different nodes.
 * 
 * The setting {@link Kind#BY_RECEPTION_TIMESTAMP} indicates that, assuming
 * the {@link OwnershipQosPolicy} allows it, the latest received value for
 * the instance should be the one whose value is kept. This is the default
 * value.
 * 
 * The setting {@link Kind#BY_SOURCE_TIMESTAMP} indicates that, assuming the
 * {@link OwnershipQosPolicy} allows it, a time stamp placed at the source
 * should be used. This is the only setting that, in the case of concurrent
 * same-strength DataWriter objects updating the same instance, ensures all
 * subscribers will end up with the same final value for the instance. The
 * mechanism to set the source time stamp is middleware dependent.
 * 
 * The value offered is considered compatible with the value requested if and
 * only if the inequality "offered kind &gt;= requested kind" evaluates to
 * true. For the purposes of this inequality, the values of DESTINATION_ORDER
 * kind are considered ordered such that BY_RECEPTION_TIMESTAMP &lt;
 * BY_SOURCE_TIMESTAMP.
 * 
 * @see OwnershipQosPolicy
 */
public interface DestinationOrderQosPolicy
extends QosPolicy<DestinationOrderQosPolicy,
                  ModifiableDestinationOrderQosPolicy>,
        RequestedOffered<DestinationOrderQosPolicy>
{
    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * @return the kind
     */
    public Kind getKind();



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    public enum Kind {
        /**
         * Indicates that data is ordered based on the reception time at each
         * {@link Subscriber}. Since each subscriber may receive the data at
         * different times there is no guaranteed that the changes will be
         * seen in the same order. Consequently, it is possible for each
         * subscriber to end up with a different final value for the data.
         */
        BY_RECEPTION_TIMESTAMP,

        /**
         * Indicates that data is ordered based on a time stamp placed at the
         * source (by the Service or by the application). In any case this
         * guarantees a consistent final value for the data in all
         * subscribers.
         */
        BY_SOURCE_TIMESTAMP
    }

}
