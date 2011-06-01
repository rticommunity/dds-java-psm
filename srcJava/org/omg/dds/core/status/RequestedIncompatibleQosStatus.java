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

import java.util.Set;

import org.omg.dds.core.Bootstrap;
import org.omg.dds.core.policy.QosPolicy;
import org.omg.dds.core.policy.QosPolicyCount;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.sub.DataReader;
import org.omg.dds.topic.Topic;


/**
 * A {@link QosPolicy} value was incompatible with what is offered.
 *
 * @param <TYPE>    The data type of the source {@link DataReader}.
 * 
 * @see OfferedIncompatibleQosStatus
 */
public abstract class RequestedIncompatibleQosStatus<TYPE>
extends Status<RequestedIncompatibleQosStatus<TYPE>, DataReader<TYPE>> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 4709309312402183531L;



    // -----------------------------------------------------------------------
    // Object Life Cycle
    // -----------------------------------------------------------------------

    /**
     * @param bootstrap Identifies the Service instance to which the new
     *                  object will belong.
     */
    public static <TYPE> RequestedIncompatibleQosStatus<TYPE>
    newRequestedIncompatibleQosStatus(Bootstrap bootstrap) {
        return bootstrap.getSPI().newRequestedIncompatibleQosStatus();
    }


    // -----------------------------------------------------------------------

    protected RequestedIncompatibleQosStatus(DataReader<TYPE> source) {
        super(source);
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * Total cumulative number of times the concerned {@link DataReader}
     * discovered a {@link DataWriter} for the same {@link Topic} with an
     * offered QoS that was incompatible with that requested by the
     * DataReader.
     */
    public abstract int getTotalCount();

    /**
     * The change in totalCount since the last time the listener was called
     * or the status was read.
     */
    public abstract int getTotalCountChange();

    /**
     * The {@link org.omg.dds.core.policy.QosPolicy.Id} of one of the
     * policies that was found to be incompatible the last time an
     * incompatibility was detected.
     */
    public abstract QosPolicy.Id getLastPolicyId();

    /**
     * A list containing for each policy the total number of times that the
     * concerned {@link DataReader} discovered a {@link DataWriter} for the
     * same {@link Topic} with an offered QoS that is incompatible with that
     * requested by the DataReader.
     * 
     * @return  an unmodifiable set.
     */
    public abstract Set<QosPolicyCount> getPolicies();

}
