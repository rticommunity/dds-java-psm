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
import org.omg.dds.topic.Topic;


/**
 * A sample has been lost (never received).
 *
 * @see SampleLostEvent
 */
public abstract class SampleLostStatus extends Status<SampleLostStatus> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 6522885693257415947L;



    // -----------------------------------------------------------------------
    // Object Life Cycle
    // -----------------------------------------------------------------------

    /**
     * @param bootstrap Identifies the Service instance to which the new
     *                  object will belong.
     */
    public static SampleLostStatus newSampleLostStatus(Bootstrap bootstrap)
    {
        return bootstrap.getSPI().newSampleLostStatus();
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * Total cumulative count of all samples lost across all instances of
     * data published under the {@link Topic}.
     */
    public abstract int getTotalCount();

    /**
     * The incremental number of samples lost since the last time the
     * listener was called or the status was read.
     */
    public abstract int getTotalCountChange();

}