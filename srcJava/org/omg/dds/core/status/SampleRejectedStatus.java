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

import org.omg.dds.core.InstanceHandle;



/**
 * A (received) sample has been rejected.
 * 
 * @see org.omg.dds.core.event.SampleRejectedEvent
 */
public abstract class SampleRejectedStatus extends Status
{
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -612709680820262641L;



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * Total cumulative count of samples rejected by the {@link org.omg.dds.sub.DataReader}.
     */
    public abstract int getTotalCount();

    /**
     * The incremental number of samples rejected since the last time the
     * listener was called or the status was read.
     */
    public abstract int getTotalCountChange();

    /**
     * Reason for rejecting the last sample rejected. If no samples have been
     * rejected, the reason is the special value {@link Kind#NOT_REJECTED}.
     */
    public abstract Kind getLastReason();

    /**
     * Handle to the instance being updated by the last sample that was
     * rejected.
     */
    public abstract InstanceHandle getLastInstanceHandle();



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    public static enum Kind {
        NOT_REJECTED,
        REJECTED_BY_INSTANCES_LIMIT,
        REJECTED_BY_SAMPLES_LIMIT,
        REJECTED_BY_SAMPLES_PER_INSTANCE_LIMIT
    }

}
