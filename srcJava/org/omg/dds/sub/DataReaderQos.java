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

package org.omg.dds.sub;

import org.omg.dds.core.Qos;
import org.omg.dds.core.policy.DeadlineQosPolicy;
import org.omg.dds.core.policy.DestinationOrderQosPolicy;
import org.omg.dds.core.policy.DurabilityQosPolicy;
import org.omg.dds.core.policy.HistoryQosPolicy;
import org.omg.dds.core.policy.LatencyBudgetQosPolicy;
import org.omg.dds.core.policy.LivelinessQosPolicy;
import org.omg.dds.core.policy.OwnershipQosPolicy;
import org.omg.dds.core.policy.ReaderDataLifecycleQosPolicy;
import org.omg.dds.core.policy.ResourceLimitsQosPolicy;
import org.omg.dds.core.policy.TimeBasedFilterQosPolicy;
import org.omg.dds.core.policy.UserDataQosPolicy;
import org.omg.dds.topic.TopicQos;


public interface DataReaderQos extends Qos<DataReaderQos> {
    /**
     * @param durability the durability to set
     */
    public void setDurability(DurabilityQosPolicy durability);

    /**
     * @return the durability
     */
    public DurabilityQosPolicy getDurability();

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(DeadlineQosPolicy deadline);

    /**
     * @return the deadline
     */
    public DeadlineQosPolicy getDeadline();

    /**
     * @param latencyBudget the latencyBudget to set
     */
    public void setLatencyBudget(LatencyBudgetQosPolicy latencyBudget);

    /**
     * @return the latencyBudget
     */
    public LatencyBudgetQosPolicy getLatencyBudget();

    /**
     * @param liveliness the liveliness to set
     */
    public void setLiveliness(LivelinessQosPolicy liveliness);

    /**
     * @return the liveliness
     */
    public LivelinessQosPolicy getLiveliness();

    /**
     * @param destinationOrder the destinationOrder to set
     */
    public void setDestinationOrder(
            DestinationOrderQosPolicy destinationOrder);

    /**
     * @return the destinationOrder
     */
    public DestinationOrderQosPolicy getDestinationOrder();

    /**
     * @param history the history to set
     */
    public void setHistory(HistoryQosPolicy history);

    /**
     * @return the history
     */
    public HistoryQosPolicy getHistory();

    /**
     * @param resourceLimits the resourceLimits to set
     */
    public void setResourceLimits(ResourceLimitsQosPolicy resourceLimits);

    /**
     * @return the resourceLimits
     */
    public ResourceLimitsQosPolicy getResourceLimits();

    /**
     * @param userData the userData to set
     */
    public void setUserData(UserDataQosPolicy userData);

    /**
     * @return the userData
     */
    public UserDataQosPolicy getUserData();

    /**
     * @param ownership the ownership to set
     */
    public void setOwnership(OwnershipQosPolicy ownership);

    /**
     * @return the ownership
     */
    public OwnershipQosPolicy getOwnership();

    /**
     * @param timeBasedFilter the timeBasedFilter to set
     */
    public void setTimeBasedFilter(TimeBasedFilterQosPolicy timeBasedFilter);

    /**
     * @return the timeBasedFilter
     */
    public TimeBasedFilterQosPolicy getTimeBasedFilter();

    /**
     * @param readerDataLifecycle the readerDataLifecycle to set
     */
    public void setReaderDataLifecycle(
            ReaderDataLifecycleQosPolicy readerDataLifecycle);

    /**
     * @return the readerDataLifecycle
     */
    public ReaderDataLifecycleQosPolicy getReaderDataLifecycle();

    public DataReaderQos copyFrom(TopicQos src);
}
