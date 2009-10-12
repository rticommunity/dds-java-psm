/* Copyright (c) 2009, Real-Time Innovations, Inc.
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

package org.omg.dds.spi;

import org.omg.dds.builtin.BuiltinTopicKey;
import org.omg.dds.builtin.ParticipantBuiltinTopicData;
import org.omg.dds.builtin.PublicationBuiltinTopicData;
import org.omg.dds.builtin.SubscriptionBuiltinTopicData;
import org.omg.dds.builtin.TopicBuiltinTopicData;
import org.omg.dds.infrastructure.qos.DeadlineQosPolicy;
import org.omg.dds.infrastructure.qos.DestinationOrderQosPolicy;
import org.omg.dds.infrastructure.qos.DurabilityQosPolicy;
import org.omg.dds.infrastructure.qos.DurabilityServiceQosPolicy;
import org.omg.dds.infrastructure.qos.GroupDataQosPolicy;
import org.omg.dds.infrastructure.qos.HistoryQosPolicy;
import org.omg.dds.infrastructure.qos.LatencyBudgetQosPolicy;
import org.omg.dds.infrastructure.qos.LifespanQosPolicy;
import org.omg.dds.infrastructure.qos.LivelinessQosPolicy;
import org.omg.dds.infrastructure.qos.OwnershipQosPolicy;
import org.omg.dds.infrastructure.qos.OwnershipStrengthQosPolicy;
import org.omg.dds.infrastructure.qos.PartitionQosPolicy;
import org.omg.dds.infrastructure.qos.PresentationQosPolicy;
import org.omg.dds.infrastructure.qos.ReliabilityQosPolicy;
import org.omg.dds.infrastructure.qos.ResourceLimitsQosPolicy;
import org.omg.dds.infrastructure.qos.TimeBasedFilterQosPolicy;
import org.omg.dds.infrastructure.qos.TopicDataQosPolicy;
import org.omg.dds.infrastructure.qos.TransportPriorityQosPolicy;
import org.omg.dds.infrastructure.qos.UserDataQosPolicy;


/**
 * An implementation-provided factory for classes pertaining to the built-in
 * topic data types.
 */
public interface BuiltinTopicDataFactory {
    // --- Built-in topic key: -----------------------------------------------

    public BuiltinTopicKey createBuiltinTopicKey();

    public BuiltinTopicKey createBuiltinTopicKey(int[] value);


    // --- Participant built-in topic data: ----------------------------------

    public ParticipantBuiltinTopicData createParticipantBuiltinTopicData();

    public ParticipantBuiltinTopicData createParticipantBuiltinTopicData(
            BuiltinTopicKey key, UserDataQosPolicy userData);


    // --- Publication built-in topic data: ----------------------------------

    public PublicationBuiltinTopicData createPublicationBuiltinTopicData();

    public PublicationBuiltinTopicData createPublicationBuiltinTopicData(
            BuiltinTopicKey key,
            BuiltinTopicKey participantKey,
            String topicName,
            String typeName,
            DurabilityQosPolicy durability,
            DurabilityServiceQosPolicy durabilityService,
            DeadlineQosPolicy deadline,
            LatencyBudgetQosPolicy latencyBudget,
            LivelinessQosPolicy liveliness,
            ReliabilityQosPolicy reliability,
            LifespanQosPolicy lifespan,
            UserDataQosPolicy userData,
            OwnershipQosPolicy ownership,
            OwnershipStrengthQosPolicy ownershipStrength,
            DestinationOrderQosPolicy destinationOrder,
            PresentationQosPolicy presentation,
            PartitionQosPolicy partition,
            TopicDataQosPolicy topicData,
            GroupDataQosPolicy groupData);


    // --- Subscription built-in topic data: ---------------------------------

    public SubscriptionBuiltinTopicData createSubscriptionBuiltinTopicData();

    public SubscriptionBuiltinTopicData createSubscriptionBuiltinTopicData(
            BuiltinTopicKey key,
            BuiltinTopicKey participantKey,
            String topicName,
            String typeName,
            DurabilityQosPolicy durability,
            DeadlineQosPolicy deadline,
            LatencyBudgetQosPolicy latencyBudget,
            LivelinessQosPolicy liveliness,
            ReliabilityQosPolicy reliability,
            OwnershipQosPolicy ownership,
            DestinationOrderQosPolicy destinationOrder,
            UserDataQosPolicy userData,
            TimeBasedFilterQosPolicy timeBasedFilter,
            PresentationQosPolicy presentation,
            PartitionQosPolicy partition,
            TopicDataQosPolicy topicData,
            GroupDataQosPolicy groupData);


    // --- Topic built-in topic data: ----------------------------------------

    public TopicBuiltinTopicData createTopicBuiltinTopicData();

    public TopicBuiltinTopicData createTopicBuiltinTopicData(
            BuiltinTopicKey key,
            String name,
            String typeName,
            DurabilityQosPolicy durability,
            DurabilityServiceQosPolicy durabilityService,
            DeadlineQosPolicy deadline,
            LatencyBudgetQosPolicy latencyBudget,
            LivelinessQosPolicy liveliness,
            ReliabilityQosPolicy reliability,
            TransportPriorityQosPolicy transportPriority,
            LifespanQosPolicy lifespan,
            DestinationOrderQosPolicy destinationOrder,
            HistoryQosPolicy history,
            ResourceLimitsQosPolicy resourceLimits,
            OwnershipQosPolicy ownership,
            TopicDataQosPolicy topicDdata);

}
