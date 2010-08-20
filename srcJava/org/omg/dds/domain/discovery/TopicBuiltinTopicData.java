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

package org.omg.dds.domain.discovery;

import java.util.List;

import org.omg.dds.core.ModifiableValueType;
import org.omg.dds.core.policy.DataRepresentationQosPolicy;
import org.omg.dds.core.policy.DeadlineQosPolicy;
import org.omg.dds.core.policy.DestinationOrderQosPolicy;
import org.omg.dds.core.policy.DurabilityQosPolicy;
import org.omg.dds.core.policy.DurabilityServiceQosPolicy;
import org.omg.dds.core.policy.HistoryQosPolicy;
import org.omg.dds.core.policy.LatencyBudgetQosPolicy;
import org.omg.dds.core.policy.LifespanQosPolicy;
import org.omg.dds.core.policy.LivelinessQosPolicy;
import org.omg.dds.core.policy.OwnershipQosPolicy;
import org.omg.dds.core.policy.ReliabilityQosPolicy;
import org.omg.dds.core.policy.ResourceLimitsQosPolicy;
import org.omg.dds.core.policy.TopicDataQosPolicy;
import org.omg.dds.core.policy.TransportPriorityQosPolicy;
import org.omg.dds.core.policy.TypeConsistencyEnforcementQosPolicy;
import org.omg.dds.type.annotation.Extensibility;
import org.omg.dds.type.annotation.ID;
import org.omg.dds.type.annotation.Key;
import org.omg.dds.type.annotation.Optional;
import org.omg.dds.type.typeobject.TypeObject;


@Extensibility(Extensibility.Kind.MUTABLE_EXTENSIBILITY)
public interface TopicBuiltinTopicData
extends ModifiableValueType<TopicBuiltinTopicData, TopicBuiltinTopicData>
{
    @ID(0x005A) @Key
    public BuiltinTopicKey getKey();

    /**
     * @return the name
     */
    @ID(0x0005)
    public String getName();

    /**
     * @return the typeName
     */
    @ID(0x0007)
    public String getTypeName();

    @ID(0x0075) @Optional
    public List<String> getEquivalentTypeName();

    @ID(0x0076) @Optional
    public List<String> getBaseTypeName();

    @ID(0x0072) @Optional
    public TypeObject getType();

    /**
     * @return the durability
     */
    @ID(0x001D)
    public DurabilityQosPolicy getDurability();

    /**
     * @return the durabilityService
     */
    @ID(0x001E)
    public DurabilityServiceQosPolicy getDurabilityService();

    /**
     * @return the deadline
     */
    @ID(0x0023)
    public DeadlineQosPolicy getDeadline();

    /**
     * @return the latencyBudget
     */
    @ID(0x0027)
    public LatencyBudgetQosPolicy getLatencyBudget();

    /**
     * @return the liveliness
     */
    @ID(0x001B)
    public LivelinessQosPolicy getLiveliness();

    /**
     * @return the reliability
     */
    @ID(0x001A)
    public ReliabilityQosPolicy getReliability();

    /**
     * @return the transportPriority
     */
    @ID(0x0049)
    public TransportPriorityQosPolicy getTransportPriority();

    /**
     * @return the lifespan
     */
    @ID(0x002B)
    public LifespanQosPolicy getLifespan();

    /**
     * @return the destinationOrder
     */
    @ID(0x0025)
    public DestinationOrderQosPolicy getDestinationOrder();

    /**
     * @return the history
     */
    @ID(0x0040)
    public HistoryQosPolicy getHistory();

    /**
     * @return the resourceLimits
     */
    @ID(0x0041)
    public ResourceLimitsQosPolicy getResourceLimits();

    /**
     * @return the ownership
     */
    @ID(0x001F)
    public OwnershipQosPolicy getOwnership();

    /**
     * @return the topicData
     */
    @ID(0x002E)
    public TopicDataQosPolicy getTopicData();

    @ID(0x0073)
    public DataRepresentationQosPolicy getRepresentation();

    @ID(0x0074)
    public TypeConsistencyEnforcementQosPolicy getTypeConsistency();
}
