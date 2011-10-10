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

package org.omg.dds.core.status;

import org.omg.dds.core.ServiceEnvironment;
import org.omg.dds.core.modifiable.ModifiableInstanceHandle;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.sub.DataReader;
import org.omg.dds.topic.Topic;


/**
 * The {@link DataReader} has found a {@link DataWriter} that matches the
 * {@link Topic} and has compatible QoS, or has ceased to be matched with a
 * DataWriter that was previously considered to be matched.
 *
 * @see SubscriptionMatchedEvent
 * @see PublicationMatchedStatus
 */
public abstract class SubscriptionMatchedStatus
extends Status<SubscriptionMatchedStatus> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 8269669800428084585L;



    // -----------------------------------------------------------------------
    // Object Life Cycle
    // -----------------------------------------------------------------------

    /**
     * @param env       Identifies the Service instance to which the new
     *                  object will belong.
     */
    public static SubscriptionMatchedStatus newSubscriptionMatchedStatus(
            ServiceEnvironment env)
    {
        return env.getSPI().newSubscriptionMatchedStatus();
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * Total cumulative count the concerned {@link DataReader} discovered a
     * "match" with a {@link DataWriter}. That is, it found a DataWriter for
     * the same {@link Topic} with a requested QoS that is compatible with
     * that offered by the DataReader.
     */
    public abstract int getTotalCount();

    /**
     * The change in totalCount since the last time the listener was called
     * or the status was read.
     */
    public abstract int getTotalCountChange();

    /**
     * The number of {@link DataWriter}s currently matched to the concerned
     * {@link DataReader}.
     */
    public abstract int getCurrentCount();

    /**
     * The change in currentCount since the last time the listener was called
     * or the status was read.
     */
    public abstract int getCurrentCountChange();

    /**
     * Handle to the last {@link DataWriter} that matched the
     * {@link DataReader}, causing the status to change.
     */
    public abstract ModifiableInstanceHandle getLastPublicationHandle();

}
