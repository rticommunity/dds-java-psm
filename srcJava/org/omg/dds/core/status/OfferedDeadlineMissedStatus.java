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
import org.omg.dds.core.modifiable.ModifiableInstanceHandle;
import org.omg.dds.core.policy.DeadlineQosPolicy;
import org.omg.dds.pub.DataWriter;


/**
 * The deadline that the {@link DataWriter} has committed through its
 * {@link DeadlineQosPolicy} was not respected for a specific instance.
 *
 * @param <TYPE>    The data type of the source {@link DataWriter}.
 * 
 * @see RequestedDeadlineMissedStatus
 */
public abstract class OfferedDeadlineMissedStatus<TYPE>
extends Status<OfferedDeadlineMissedStatus<TYPE>, DataWriter<TYPE>> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 7958557115889148585L;



    // -----------------------------------------------------------------------
    // Object Life Cycle
    // -----------------------------------------------------------------------

    /**
     * @param bootstrap Identifies the Service instance to which the new
     *                  object will belong.
     */
    public static <TYPE> OfferedDeadlineMissedStatus<TYPE>
    newOfferedDeadlineMissedStatus(Bootstrap bootstrap) {
        return bootstrap.getSPI().newOfferedDeadlineMissedStatus();
    }


    // -----------------------------------------------------------------------

    protected OfferedDeadlineMissedStatus(DataWriter<TYPE> source) {
        super(source);
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * Total cumulative number of offered deadline periods elapsed during
     * which a DataWriter failed to provide data. Missed deadlines
     * accumulate; that is, each deadline period the totalCount will be
     * incremented by one.
     */
    public abstract int getTotalCount();

    /**
     * The change in totalCount since the last time the listener was called
     * or the status was read.
     */
    public abstract int getTotalCountChange();

    /**
     * Handle to the last instance in the {@link DataWriter} for which an
     * offered deadline was missed.
     */
    public abstract ModifiableInstanceHandle getLastInstanceHandle();

}
