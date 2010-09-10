/* Copyright (c) 2009-2010, Real-Time Innovations, Inc.
 * Copyright (c) 2010, Object Management Group, Inc.
 * Copyright (c) 2010, PrismTech, Inc.
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
 * - Neither the names of the above copyright holders nor the names of their
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

package org.omg.dds.pub;

import org.omg.dds.core.ModifiableEntityQos;
import org.omg.dds.core.policy.DataRepresentationQosPolicy;
import org.omg.dds.core.policy.DeadlineQosPolicy;
import org.omg.dds.core.policy.DestinationOrderQosPolicy;
import org.omg.dds.core.policy.DurabilityQosPolicy;
import org.omg.dds.core.policy.DurabilityServiceQosPolicy;
import org.omg.dds.core.policy.HistoryQosPolicy;
import org.omg.dds.core.policy.LatencyBudgetQosPolicy;
import org.omg.dds.core.policy.LifespanQosPolicy;
import org.omg.dds.core.policy.LivelinessQosPolicy;
import org.omg.dds.core.policy.ModifiableDataRepresentationQosPolicy;
import org.omg.dds.core.policy.ModifiableDeadlineQosPolicy;
import org.omg.dds.core.policy.ModifiableDestinationOrderQosPolicy;
import org.omg.dds.core.policy.ModifiableDurabilityQosPolicy;
import org.omg.dds.core.policy.ModifiableDurabilityServiceQosPolicy;
import org.omg.dds.core.policy.ModifiableHistoryQosPolicy;
import org.omg.dds.core.policy.ModifiableLatencyBudgetQosPolicy;
import org.omg.dds.core.policy.ModifiableLifespanQosPolicy;
import org.omg.dds.core.policy.ModifiableLivelinessQosPolicy;
import org.omg.dds.core.policy.ModifiableOwnershipQosPolicy;
import org.omg.dds.core.policy.ModifiableOwnershipStrengthQosPolicy;
import org.omg.dds.core.policy.ModifiableReliabilityQosPolicy;
import org.omg.dds.core.policy.ModifiableResourceLimitsQosPolicy;
import org.omg.dds.core.policy.ModifiableTransportPriorityQosPolicy;
import org.omg.dds.core.policy.ModifiableTypeConsistencyEnforcementQosPolicy;
import org.omg.dds.core.policy.ModifiableUserDataQosPolicy;
import org.omg.dds.core.policy.ModifiableWriterDataLifecycleQosPolicy;
import org.omg.dds.core.policy.OwnershipQosPolicy;
import org.omg.dds.core.policy.OwnershipStrengthQosPolicy;
import org.omg.dds.core.policy.ReliabilityQosPolicy;
import org.omg.dds.core.policy.ResourceLimitsQosPolicy;
import org.omg.dds.core.policy.TransportPriorityQosPolicy;
import org.omg.dds.core.policy.TypeConsistencyEnforcementQosPolicy;
import org.omg.dds.core.policy.UserDataQosPolicy;
import org.omg.dds.core.policy.WriterDataLifecycleQosPolicy;
import org.omg.dds.topic.TopicQos;


public interface ModifiableDataWriterQos
extends DataWriterQos,
        ModifiableEntityQos<DataWriterQos, ModifiableDataWriterQos>
{
    /**
     * @param durability the durability to set
     */
    public void setDurability(DurabilityQosPolicy durability);

    /**
     * @return the durability
     */
    public ModifiableDurabilityQosPolicy getDurability();

    /**
     * @param durabilityService the durabilityService to set
     */
    public void setDurabilityService(
            DurabilityServiceQosPolicy durabilityService);

    /**
     * @return the durabilityService
     */
    public ModifiableDurabilityServiceQosPolicy getDurabilityService();

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(DeadlineQosPolicy deadline);

    /**
     * @return the deadline
     */
    public ModifiableDeadlineQosPolicy getDeadline();

    /**
     * @param latencyBudget the latencyBudget to set
     */
    public void setLatencyBudget(LatencyBudgetQosPolicy latencyBudget);

    /**
     * @return the latencyBudget
     */
    public ModifiableLatencyBudgetQosPolicy getLatencyBudget();

    /**
     * @param liveliness the liveliness to set
     */
    public void setLiveliness(LivelinessQosPolicy liveliness);

    /**
     * @return the liveliness
     */
    public ModifiableLivelinessQosPolicy getLiveliness();

    /**
     * @param reliability the reliability to set
     */
    public void setReliability(ReliabilityQosPolicy reliability);

    /**
     * @return the reliability
     */
    public ModifiableReliabilityQosPolicy getReliability();

    /**
     * @param destinationOrder the destinationOrder to set
     */
    public void setDestinationOrder(
            DestinationOrderQosPolicy destinationOrder);

    /**
     * @return the destinationOrder
     */
    public ModifiableDestinationOrderQosPolicy getDestinationOrder();

    /**
     * @param history the history to set
     */
    public void setHistory(HistoryQosPolicy history);

    /**
     * @return the history
     */
    public ModifiableHistoryQosPolicy getHistory();

    /**
     * @param resourceLimits the resourceLimits to set
     */
    public void setResourceLimits(ResourceLimitsQosPolicy resourceLimits);

    /**
     * @return the resourceLimits
     */
    public ModifiableResourceLimitsQosPolicy getResourceLimits();

    /**
     * @param transportPriority the transportPriority to set
     */
    public void setTransportPriority(
            TransportPriorityQosPolicy transportPriority);

    /**
     * @return the transportPriority
     */
    public ModifiableTransportPriorityQosPolicy getTransportPriority();

    /**
     * @param lifespan the lifespan to set
     */
    public void setLifespan(LifespanQosPolicy lifespan);

    /**
     * @return the lifespan
     */
    public ModifiableLifespanQosPolicy getLifespan();

    /**
     * @param userData the userData to set
     */
    public void setUserData(UserDataQosPolicy userData);

    /**
     * @return the userData
     */
    public ModifiableUserDataQosPolicy getUserData();

    /**
     * @param ownership the ownership to set
     */
    public void setOwnership(OwnershipQosPolicy ownership);

    /**
     * @return the ownership
     */
    public ModifiableOwnershipQosPolicy getOwnership();

    /**
     * @param ownershipStrength the ownershipStrength to set
     */
    public void setOwnershipStrength(
            OwnershipStrengthQosPolicy ownershipStrength);

    /**
     * @return the ownershipStrength
     */
    public ModifiableOwnershipStrengthQosPolicy getOwnershipStrength();

    /**
     * @param writerDataLifecycle the writerDataLifecycle to set
     */
    public void setWriterDataLifecycle(
            WriterDataLifecycleQosPolicy writerDataLifecycle);

    /**
     * @return the writerDataLifecycle
     */
    public ModifiableWriterDataLifecycleQosPolicy getWriterDataLifecycle();

    public ModifiableDataRepresentationQosPolicy getRepresentation();

    public void setRepresentation(DataRepresentationQosPolicy representation);

    public ModifiableTypeConsistencyEnforcementQosPolicy getTypeConsistency();

    public void setTypeConsistency(
            TypeConsistencyEnforcementQosPolicy typeConsistency);

    public ModifiableDataWriterQos copyFrom(TopicQos src);
}
