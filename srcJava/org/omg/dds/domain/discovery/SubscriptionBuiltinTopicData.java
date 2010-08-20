/* Copyright (c) 2009-2010, Real-Time Innovations, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * - Neither the name of Real-Time Innovations, Inc. nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.omg.dds.domain.discovery;

import org.omg.dds.core.ValueType;
import org.omg.dds.core.policy.DeadlineQosPolicy;
import org.omg.dds.core.policy.DestinationOrderQosPolicy;
import org.omg.dds.core.policy.DurabilityQosPolicy;
import org.omg.dds.core.policy.GroupDataQosPolicy;
import org.omg.dds.core.policy.LatencyBudgetQosPolicy;
import org.omg.dds.core.policy.LivelinessQosPolicy;
import org.omg.dds.core.policy.OwnershipQosPolicy;
import org.omg.dds.core.policy.PartitionQosPolicy;
import org.omg.dds.core.policy.PresentationQosPolicy;
import org.omg.dds.core.policy.ReliabilityQosPolicy;
import org.omg.dds.core.policy.TimeBasedFilterQosPolicy;
import org.omg.dds.core.policy.TopicDataQosPolicy;
import org.omg.dds.core.policy.UserDataQosPolicy;


public interface SubscriptionBuiltinTopicData
extends ValueType<SubscriptionBuiltinTopicData> {
    /**
     * @return the key
     */
    public BuiltinTopicKey getKey();

    /**
     * @return the participantKey
     */
    public BuiltinTopicKey getParticipantKey();

    /**
     * @return the topicName
     */
    public String getTopicName();

    /**
     * @return the typeName
     */
    public String getTypeName();

    /**
     * @return the durability
     */
    public DurabilityQosPolicy getDurability();

    /**
     * @return the deadline
     */
    public DeadlineQosPolicy getDeadline();

    /**
     * @return the latencyBudget
     */
    public LatencyBudgetQosPolicy getLatencyBudget();

    /**
     * @return the liveliness
     */
    public LivelinessQosPolicy getLiveliness();

    /**
     * @return the reliability
     */
    public ReliabilityQosPolicy getReliability();

    /**
     * @return the ownership
     */
    public OwnershipQosPolicy getOwnership();

    /**
     * @return the destinationOrder
     */
    public DestinationOrderQosPolicy getDestinationOrder();

    /**
     * @return the userData
     */
    public UserDataQosPolicy getUserData();

    /**
     * @return the timeBasedFilter
     */
    public TimeBasedFilterQosPolicy getTimeBasedFilter();

    /**
     * @return the presentation
     */
    public PresentationQosPolicy getPresentation();

    /**
     * @return the partition
     */
    public PartitionQosPolicy getPartition();

    /**
     * @return the topicData
     */
    public TopicDataQosPolicy getTopicData();

    /**
     * @return the groupData
     */
    public GroupDataQosPolicy getGroupData();

}
