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

import java.util.Collection;
import java.util.concurrent.TimeoutException;

import org.omg.dds.core.DomainEntity;
import org.omg.dds.core.Duration;
import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.ModifiableInstanceHandle;
import org.omg.dds.core.Time;
import org.omg.dds.domain.discovery.SubscriptionBuiltinTopicData;
import org.omg.dds.topic.Topic;


public interface DataWriter<TYPE>
extends DomainEntity<DataWriter<TYPE>,
                     Publisher,
                     DataWriterListener<TYPE>,
                     DataWriterQos> {
    /**
     * @return  the type parameter if this object's class.
     */
    public Class<TYPE> getType();

    /**
     * Cast this data writer to the given type, or throw an exception if
     * the cast fails.
     * 
     * @param <OTHER>   The type of the data published by this writer,
     *                  according to the caller.
     * @return          this data writer
     * @throws          ClassCastException if the cast fails
     */
    public <OTHER> DataWriter<OTHER> cast();

    public Topic<TYPE> getTopic();

    public void waitForAcknowledgments(Duration maxWait)
    throws TimeoutException;

    public void waitForAcknowledgments(long maxWaitMillis)
    throws TimeoutException;

    public LivelinessLostStatus<TYPE> getLivelinessLostStatus(
            LivelinessLostStatus<TYPE> status);

    public OfferedDeadlineMissedStatus<TYPE> getOfferedDeadlineMissedStatus(
            OfferedDeadlineMissedStatus<TYPE> status);

    public OfferedIncompatibleQosStatus<TYPE> getOfferedIncompatibleQosStatus(
            OfferedIncompatibleQosStatus<TYPE> status);

    public PublicationMatchedStatus<TYPE> getPublicationMatchedStatus(
            PublicationMatchedStatus<TYPE> status);

    public void assertLiveliness();

    public Collection<InstanceHandle> getMatchedSubscriptions(
            Collection<InstanceHandle> subscriptionHandles);
    public SubscriptionBuiltinTopicData getMatchedSubscriptionData(
            SubscriptionBuiltinTopicData subscriptionData,
            InstanceHandle subscriptionHandle);


    // --- Type-specific interface: ------------------------------------------
    public InstanceHandle registerInstance(
            TYPE instanceData) throws TimeoutException;
    public InstanceHandle registerInstance(
            TYPE instanceData, 
            Time sourceTimestamp) throws TimeoutException;
    public InstanceHandle registerInstance(
            TYPE instanceData, 
            long sourceTimestampMillis) throws TimeoutException;

    public void unregisterInstance(
            InstanceHandle handle) throws TimeoutException;
    public void unregisterInstance(
            InstanceHandle handle, 
            TYPE instanceData) throws TimeoutException;
    public void unregisterInstance(
            InstanceHandle handle, 
            TYPE instanceData,
            Time sourceTimestamp) throws TimeoutException;
    public void unregisterInstance(
            InstanceHandle handle, 
            TYPE instanceData,
            long sourceTimestampMillis) throws TimeoutException;

    public void write(
            TYPE instanceData) throws TimeoutException;
    public void write(
            TYPE instanceData, 
            Time sourceTimestamp) throws TimeoutException;
    public void write(
            TYPE instanceData, 
            long sourceTimestampMillis) throws TimeoutException;
    public void write(
            TYPE instanceData, 
            InstanceHandle handle) throws TimeoutException;
    public void write(
            TYPE instanceData, 
            InstanceHandle handle,
            Time sourceTimestamp) throws TimeoutException;
    public void write(
            TYPE instanceData, 
            InstanceHandle handle,
            long sourceTimestampMillis) throws TimeoutException;

    public void dispose(
            InstanceHandle instanceHandle) throws TimeoutException;
    public void dispose(
            InstanceHandle instanceHandle, 
            TYPE instanceData) throws TimeoutException;
    public void dispose(
            InstanceHandle instanceHandle, 
            TYPE instanceData,
            Time sourceTimestamp) throws TimeoutException;
    public void dispose(
            InstanceHandle instanceHandle, 
            TYPE instanceData,
            long sourceTimestampMillis) throws TimeoutException;

    public TYPE getKeyValue(
            TYPE keyHolder, 
            InstanceHandle handle);

    public ModifiableInstanceHandle lookupInstance(
            ModifiableInstanceHandle handle,
            TYPE keyHolder);
}
