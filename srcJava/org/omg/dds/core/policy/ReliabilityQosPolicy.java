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

import org.omg.dds.core.Duration;
import org.omg.dds.core.policy.modifiable.ModifiableReliabilityQosPolicy;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.sub.DataReader;
import org.omg.dds.topic.Topic;


/**
 * This policy indicates the level of reliability requested by a
 * {@link DataReader} or offered by a {@link DataWriter}. These levels are
 * ordered, {@link Kind#BEST_EFFORT} being lower than {@link Kind#RELIABLE}.
 * A DataWriter offering a level is implicitly offering all levels below.
 * 
 * <b>Concerns:</b> {@link Topic}, {@link DataReader}, {@link DataWriter}
 * 
 * <b>RxO:</b> Yes
 * 
 * <b>Changeable:</b> No
 * 
 * The setting of this policy has a dependency on the setting of the
 * {@link ResourceLimitsQosPolicy}. In case the RELIABILITY kind is set to
 * RELIABLE the {@link DataWriter#write(Object)} operation may block if the
 * modification would cause data to be lost or else cause one of the limits
 * specified in the RESOURCE_LIMITS to be exceeded. Under these circumstances,
 * the RELIABILITY maxBlockingTime configures the maximum duration the write
 * operation may block.
 * 
 * If the RELIABILITY kind is set to RELIABLE, data samples originating from
 * a single DataWriter cannot be made available to the DataReader if there
 * are previous data samples that have not been received yet due to a
 * communication error. In other words, the service will repair the error and
 * retransmit data samples as needed in order to reconstruct a correct
 * snapshot of the DataWriter history before it is accessible by the
 * DataReader.
 * 
 * If the RELIABILITY kind is set to BEST_EFFORT, the service will not
 * retransmit missing data samples. However, for data samples originating
 * from any one DataWriter the service will ensure they are stored in the
 * DataReader history in the same order they originated in the DataWriter. In
 * other words, the DataReader may miss some data samples but it will never
 * see the value of a data object change from a newer value to an older value.
 * 
 * The value offered is considered compatible with the value requested if and
 * only if the inequality "offered kind &gt;= requested kind" evaluates to
 * true. For the purposes of this inequality, the values of RELIABILITY kind
 * are considered ordered such that BEST_EFFORT &lt; RELIABLE.
 * 
 * @see ResourceLimitsQosPolicy
 */
public interface ReliabilityQosPolicy
extends QosPolicy<ReliabilityQosPolicy, ModifiableReliabilityQosPolicy>,
        RequestedOffered<ReliabilityQosPolicy>
{
    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * @return the kind
     */
    public Kind getKind();

    public Duration getMaxBlockingTime();



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    public enum Kind {
        /**
         * Indicates that it is acceptable to not retry propagation of any
         * samples. Presumably new values for the samples are generated often
         * enough that it is not necessary to re-send or acknowledge any
         * samples. This is the default value for {@link DataReader}s and
         * {@link Topic}s.
         */
        BEST_EFFORT,

        /**
         * Specifies the Service will attempt to deliver all samples in its
         * history. Missed samples may be retried. In steady-state (no
         * modifications communicated via the {@link DataWriter}) the
         * middleware guarantees that all samples in the DataWriter history
         * will eventually be delivered to all the {@link DataReader} objects.
         * Outside steady state the {@link HistoryQosPolicy} and
         * {@link ResourceLimitsQosPolicy} will determine how samples become
         * part of the history and whether samples can be discarded from it.
         * This is the default value for DataWriters.
         */
        RELIABLE
    }

}
