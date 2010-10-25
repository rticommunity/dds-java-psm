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

package org.omg.dds.topic;

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
import org.omg.dds.core.policy.ModifiableReliabilityQosPolicy;
import org.omg.dds.core.policy.ModifiableResourceLimitsQosPolicy;
import org.omg.dds.core.policy.ModifiableTopicDataQosPolicy;
import org.omg.dds.core.policy.ModifiableTransportPriorityQosPolicy;
import org.omg.dds.core.policy.ModifiableTypeConsistencyEnforcementQosPolicy;
import org.omg.dds.core.policy.OwnershipQosPolicy;
import org.omg.dds.core.policy.ReliabilityQosPolicy;
import org.omg.dds.core.policy.ResourceLimitsQosPolicy;
import org.omg.dds.core.policy.TopicDataQosPolicy;
import org.omg.dds.core.policy.TransportPriorityQosPolicy;
import org.omg.dds.core.policy.TypeConsistencyEnforcementQosPolicy;


public interface ModifiableTopicQos
extends TopicQos, ModifiableEntityQos<TopicQos, ModifiableTopicQos>
{
    /**
     * @param topicData the topicData to set
     */
    public void setTopicData(TopicDataQosPolicy topicData);

    /**
     * @return the topicData
     */
    public ModifiableTopicDataQosPolicy getTopicData();

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
     * @param ownership the ownership to set
     */
    public void setOwnership(OwnershipQosPolicy ownership);

    /**
     * @return the ownership
     */
    public ModifiableOwnershipQosPolicy getOwnership();

    public ModifiableDataRepresentationQosPolicy getRepresentation();

    public void setRepresentation(DataRepresentationQosPolicy representation);

    public ModifiableTypeConsistencyEnforcementQosPolicy getTypeConsistency();

    public void setTypeConsistency(
            TypeConsistencyEnforcementQosPolicy typeConsistency);
}
