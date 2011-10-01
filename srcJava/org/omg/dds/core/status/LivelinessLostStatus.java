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

import org.omg.dds.core.Bootstrap;
import org.omg.dds.core.policy.LivelinessQosPolicy;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.sub.DataReader;


/**
 * The liveliness that the {@link DataWriter} has committed through its
 * {@link LivelinessQosPolicy} was not respected; thus {@link DataReader}
 * entities will consider the DataWriter as no longer "active."
 *
 * @param <TYPE>    The data type of the source {@link DataWriter}.
 * 
 * @see SubscriptionMatchedStatus
 */
public abstract class LivelinessLostStatus<TYPE>
extends Status<LivelinessLostStatus<TYPE>, DataWriter<TYPE>> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -3741038559289576020L;



    // -----------------------------------------------------------------------
    // Object Life Cycle
    // -----------------------------------------------------------------------

    /**
     * @param bootstrap Identifies the Service instance to which the new
     *                  object will belong.
     */
    public static <TYPE> LivelinessLostStatus<TYPE>
    newLivelinessLostStatus(Bootstrap bootstrap) {
        return bootstrap.getSPI().newLivelinessLostStatus();
    }


    // -----------------------------------------------------------------------

    protected LivelinessLostStatus(DataWriter<TYPE> source) {
        super(source);
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * Total cumulative number of times that a previously-alive
     * {@link DataWriter} became not alive due to a failure to actively
     * signal its liveliness within its offered liveliness period. This count
     * does not change when an already not alive DataWriter simply remains
     * not alive for another liveliness period.
     */
    public abstract int getTotalCount();

    /**
     * The change in totalCount since the last time the listener was called
     * or the status was read.
     */
    public abstract int getTotalCountChange();

}
