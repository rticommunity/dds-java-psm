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

package org.omg.dds.domain.discovery;

import java.util.List;

import org.omg.dds.core.ModifiableValue;
import org.omg.dds.core.policy.DataRepresentationQosPolicy;
import org.omg.dds.core.policy.DeadlineQosPolicy;
import org.omg.dds.core.policy.DestinationOrderQosPolicy;
import org.omg.dds.core.policy.DurabilityQosPolicy;
import org.omg.dds.core.policy.DurabilityServiceQosPolicy;
import org.omg.dds.core.policy.GroupDataQosPolicy;
import org.omg.dds.core.policy.LatencyBudgetQosPolicy;
import org.omg.dds.core.policy.LifespanQosPolicy;
import org.omg.dds.core.policy.LivelinessQosPolicy;
import org.omg.dds.core.policy.OwnershipQosPolicy;
import org.omg.dds.core.policy.OwnershipStrengthQosPolicy;
import org.omg.dds.core.policy.PartitionQosPolicy;
import org.omg.dds.core.policy.PresentationQosPolicy;
import org.omg.dds.core.policy.ReliabilityQosPolicy;
import org.omg.dds.core.policy.TopicDataQosPolicy;
import org.omg.dds.core.policy.TypeConsistencyEnforcementQosPolicy;
import org.omg.dds.core.policy.UserDataQosPolicy;
import org.omg.dds.type.annotation.Extensibility;
import org.omg.dds.type.annotation.ID;
import org.omg.dds.type.annotation.Key;
import org.omg.dds.type.annotation.Optional;
import org.omg.dds.type.typeobject.TypeObject;


@Extensibility(Extensibility.Kind.MUTABLE_EXTENSIBILITY)
public interface PublicationBuiltinTopicData
extends ModifiableValue<PublicationBuiltinTopicData,
                            PublicationBuiltinTopicData>
{
    @ID(0x005A) @Key
    public BuiltinTopicKey getKey();

    /**
     * @return the participantKey
     */
    @ID(0x0050)
    public BuiltinTopicKey getParticipantKey();

    /**
     * @return the topicName
     */
    @ID(0x0005)
    public String getTopicName();

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
     * @return the lifespan
     */
    @ID(0x002B)
    public LifespanQosPolicy getLifespan();

    /**
     * @return the userData
     */
    @ID(0x002C)
    public UserDataQosPolicy getUserData();

    /**
     * @return the ownership
     */
    @ID(0x001F)
    public OwnershipQosPolicy getOwnership();

    /**
     * @return the ownershipStrength
     */
    @ID(0x0006)
    public OwnershipStrengthQosPolicy getOwnershipStrength();

    /**
     * @return the destinationOrder
     */
    @ID(0x0025)
    public DestinationOrderQosPolicy getDestinationOrder();

    /**
     * @return the presentation
     */
    @ID(0x0021)
    public PresentationQosPolicy getPresentation();

    /**
     * @return the partition
     */
    @ID(0x0029)
    public PartitionQosPolicy getPartition();

    /**
     * @return the topicData
     */
    @ID(0x002E)
    public TopicDataQosPolicy getTopicData();

    /**
     * @return the groupData
     */
    @ID(0x002D)
    public GroupDataQosPolicy getGroupData();

    @ID(0x0073)
    public DataRepresentationQosPolicy getRepresentation();

    @ID(0x0074)
    public TypeConsistencyEnforcementQosPolicy getTypeConsistency();
}
