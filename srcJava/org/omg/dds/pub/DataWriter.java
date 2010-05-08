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

package org.omg.dds.pub;

import java.util.Set;

import org.omg.dds.core.DomainEntity;
import org.omg.dds.core.Duration;
import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.Time;
import org.omg.dds.domain.discovery.SubscriptionBuiltinTopicData;
import org.omg.dds.topic.Topic;


public interface DataWriter<TYPE>
extends DomainEntity<DataWriter<TYPE>,
                     Publisher,
                     DataWriterListener,
                     DataWriterQos> {
    public Topic<TYPE> getTopic();

    public void waitForAcknowledgments(Duration maxWait);
    public void waitForAcknowledgments(long maxWaitMillis);

    public void getLivelinessLostStatus(LivelinessLostStatus<TYPE> status);

    public void getOfferedDeadlineMissedStatus(
            OfferedDeadlineMissedStatus<TYPE> status);

    public void getOfferedIncompatibleQosStatus(
            OfferedIncompatibleQosStatus<TYPE> status);

    public void getPublicationMatchedStatus(
            PublicationMatchedStatus<TYPE> status);

    public void assertLiveliness();

    public void getMatchedSubscriptions(
            Set<InstanceHandle> subscriptionHandles);
    public void getMatchedSubscriptionData(
            SubscriptionBuiltinTopicData subscriptionData,
            InstanceHandle subscriptionHandle);


    // --- Type-specific interface: ------------------------------------------
    public InstanceHandle registerInstance(
            TYPE instanceData);
    public InstanceHandle registerInstance(
            TYPE instanceData, 
            Time sourceTimestamp);
    public InstanceHandle registerInstance(
            TYPE instanceData, 
            long sourceTimestampMillis);

    public void unregisterInstance(
            InstanceHandle handle);
    public void unregisterInstance(
            InstanceHandle handle, 
            TYPE instanceData);
    public void unregisterInstance(
            InstanceHandle handle, 
            TYPE instanceData,
            Time sourceTimestamp);
    public void unregisterInstance(
            InstanceHandle handle, 
            TYPE instanceData,
            long sourceTimestampMillis);

    public void write(
            TYPE instanceData);
    public void write(
            TYPE instanceData, 
            InstanceHandle handle);
    public void write(
            TYPE instanceData, 
            InstanceHandle handle,
            Time sourceTimestamp);
    public void write(
            TYPE instanceData, 
            InstanceHandle handle,
            long sourceTimestampMillis);

    public void dispose(
            InstanceHandle instanceHandle);
    public void dispose(
            InstanceHandle instanceHandle, 
            TYPE instanceData);
    public void dispose(
            InstanceHandle instanceHandle, 
            TYPE instanceData,
            Time sourceTimestamp);
    public void dispose(
            InstanceHandle instanceHandle, 
            TYPE instanceData,
            long sourceTimestampMillis);

    public void getKeyValue(
            TYPE keyHolder, 
            InstanceHandle handle);
    public void lookupInstance(
            InstanceHandle handle,
            TYPE keyHolder);
}
