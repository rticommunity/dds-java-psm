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

package org.omg.dds.builtin;

import org.omg.dds.core.ValueType;
import org.omg.dds.core.qos.DeadlineQosPolicy;
import org.omg.dds.core.qos.DestinationOrderQosPolicy;
import org.omg.dds.core.qos.DurabilityQosPolicy;
import org.omg.dds.core.qos.GroupDataQosPolicy;
import org.omg.dds.core.qos.LatencyBudgetQosPolicy;
import org.omg.dds.core.qos.LivelinessQosPolicy;
import org.omg.dds.core.qos.OwnershipQosPolicy;
import org.omg.dds.core.qos.PartitionQosPolicy;
import org.omg.dds.core.qos.PresentationQosPolicy;
import org.omg.dds.core.qos.ReliabilityQosPolicy;
import org.omg.dds.core.qos.TimeBasedFilterQosPolicy;
import org.omg.dds.core.qos.TopicDataQosPolicy;
import org.omg.dds.core.qos.UserDataQosPolicy;


/**
 * DDS/SubscriptionBuiltinTopicData.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from dds_rtf2_dcps.idl
 * Wednesday, September 16, 2009 9:06:02 AM CDT
 */
public interface SubscriptionBuiltinTopicData
extends ValueType<SubscriptionBuiltinTopicData> {
    /**
     * @param key the key to set
     */
    public abstract void setKey(BuiltinTopicKey key);

    /**
     * @return the key
     */
    public abstract BuiltinTopicKey getKey();

    /**
     * @param participantKey the participantKey to set
     */
    public abstract void setParticipantKey(BuiltinTopicKey participantKey);

    /**
     * @return the participantKey
     */
    public abstract BuiltinTopicKey getParticipantKey();

    /**
     * @param topicName the topicName to set
     */
    public abstract void setTopicName(String topicName);

    /**
     * @return the topicName
     */
    public abstract String getTopicName();

    /**
     * @param typeName the typeName to set
     */
    public abstract void setTypeName(String typeName);

    /**
     * @return the typeName
     */
    public abstract String getTypeName();

    /**
     * @param durability the durability to set
     */
    public abstract void setDurability(DurabilityQosPolicy durability);

    /**
     * @return the durability
     */
    public abstract DurabilityQosPolicy getDurability();

    /**
     * @param deadline the deadline to set
     */
    public abstract void setDeadline(DeadlineQosPolicy deadline);

    /**
     * @return the deadline
     */
    public abstract DeadlineQosPolicy getDeadline();

    /**
     * @param latencyBudget the latencyBudget to set
     */
    public abstract void setLatencyBudget(
            LatencyBudgetQosPolicy latencyBudget);

    /**
     * @return the latencyBudget
     */
    public abstract LatencyBudgetQosPolicy getLatencyBudget();

    /**
     * @param liveliness the liveliness to set
     */
    public abstract void setLiveliness(LivelinessQosPolicy liveliness);

    /**
     * @return the liveliness
     */
    public abstract LivelinessQosPolicy getLiveliness();

    /**
     * @param reliability the reliability to set
     */
    public abstract void setReliability(ReliabilityQosPolicy reliability);

    /**
     * @return the reliability
     */
    public abstract ReliabilityQosPolicy getReliability();

    /**
     * @param ownership the ownership to set
     */
    public abstract void setOwnership(OwnershipQosPolicy ownership);

    /**
     * @return the ownership
     */
    public abstract OwnershipQosPolicy getOwnership();

    /**
     * @param destinationOrder the destinationOrder to set
     */
    public abstract void setDestinationOrder(
            DestinationOrderQosPolicy destinationOrder);

    /**
     * @return the destinationOrder
     */
    public abstract DestinationOrderQosPolicy getDestinationOrder();

    /**
     * @param userData the userData to set
     */
    public abstract void setUserData(UserDataQosPolicy userData);

    /**
     * @return the userData
     */
    public abstract UserDataQosPolicy getUserData();

    /**
     * @param timeBasedFilter the timeBasedFilter to set
     */
    public abstract void setTimeBasedFilter(
            TimeBasedFilterQosPolicy timeBasedFilter);

    /**
     * @return the timeBasedFilter
     */
    public abstract TimeBasedFilterQosPolicy getTimeBasedFilter();

    /**
     * @param presentation the presentation to set
     */
    public abstract void setPresentation(PresentationQosPolicy presentation);

    /**
     * @return the presentation
     */
    public abstract PresentationQosPolicy getPresentation();

    /**
     * @param partition the partition to set
     */
    public abstract void setPartition(PartitionQosPolicy partition);

    /**
     * @return the partition
     */
    public abstract PartitionQosPolicy getPartition();

    /**
     * @param topicData the topicData to set
     */
    public abstract void setTopicData(TopicDataQosPolicy topicData);

    /**
     * @return the topicData
     */
    public abstract TopicDataQosPolicy getTopicData();

    /**
     * @param groupData the groupData to set
     */
    public abstract void setGroupData(GroupDataQosPolicy groupData);

    /**
     * @return the groupData
     */
    public abstract GroupDataQosPolicy getGroupData();

} // class SubscriptionBuiltinTopicData
