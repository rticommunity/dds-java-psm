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

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.omg.dds.core.DomainEntity;
import org.omg.dds.core.Duration;
import org.omg.dds.core.InstanceHandle;
import org.omg.dds.domain.discovery.PublicationBuiltinTopicData;
import org.omg.dds.topic.TopicDescription;


public interface DataReader<TYPE>
extends DomainEntity<DataReader<TYPE>,
                     Subscriber,
                     DataReaderListener,
                     DataReaderQos> {
    /**
     * @return  the type parameter if this object's class.
     */
    public Class<TYPE> getType();

    public ReadCondition<TYPE> createReadCondition();
    public ReadCondition<TYPE> createReadCondition(
            Set<SampleState> sampleStates,
            Set<ViewState> viewStates,
            Set<InstanceState> instanceStates);

    public QueryCondition<TYPE> createQueryCondition(
            String queryExpression,
            List<String> queryParameters);
    public QueryCondition<TYPE> createQueryCondition(
            String queryExpression,
            String... queryParameters);
    public QueryCondition<TYPE> createQueryCondition(
            Set<SampleState> sampleStates,
            Set<ViewState> viewStates,
            Set<InstanceState> instanceStates,
            String queryExpression,
            List<String> queryParameters);
    public QueryCondition<TYPE> createQueryCondition(
            Set<SampleState> sampleStates,
            Set<ViewState> viewStates,
            Set<InstanceState> instanceStates,
            String queryExpression,
            String... queryParameters);

    public void closeContainedEntities();

    public TopicDescription<TYPE> getTopicDescription();

    public void getSampleRejectedStatus(SampleRejectedStatus<TYPE> status);

    public void getLivelinessChangedStatus(
            LivelinessChangedStatus<TYPE> status);

    public void getRequestedDeadlineMissedStatus(
            RequestedDeadlineMissedStatus<TYPE> status);

    public void getRequestedIncompatibleQosStatus(
            RequestedIncompatibleQosStatus<TYPE> status);

    public void getSubscriptionMatchedStatus(
            SubscriptionMatchedStatus<TYPE> status);

    public void getSampleLostStatus(SampleLostStatus<TYPE> status);

    public void waitForHistoricalData(Duration maxWait)
    throws TimeoutException;

    public void waitForHistoricalData(long maxWaitMillis)
    throws TimeoutException;

    public void getMatchedPublications(
            Set<InstanceHandle> publication_handles);
    public void getMatchedPublicationData(
            PublicationBuiltinTopicData publicationData,
            InstanceHandle publicationHandle);


    // --- Type-specific interface: ------------------------------------------

    /**
     * Create and return a new Sample of the same type as may be accessed by
     * this DataReader.
     * 
     * Applications may use this method, for example, to preallocate samples
     * to be overwritten by the <code>read</code> and/or <code>take</code>
     * methods of this interface.
     * 
     * @see #read(List)
     * @see #take(List)
     */
    public Sample<TYPE> createSample();

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> read();
    public Sample.Iterator<TYPE> read(
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    /**
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void read(
            List<Sample<TYPE>> samples);
    public void read(
            List<Sample<TYPE>> samples,
            int maxSamples,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> take();
    public Sample.Iterator<TYPE> take(
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    public void take(
            List<Sample<TYPE>> samples);
    public void take(
            List<Sample<TYPE>> samples,
            int maxSamples,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> read(
            ReadCondition<TYPE> condition);

    public void read(
            List<Sample<TYPE>> samples,
            ReadCondition<TYPE> condition);
    public void read(
            List<Sample<TYPE>> samples,
            int maxSamples,
            ReadCondition<TYPE> condition);

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> take(
            ReadCondition<TYPE> condition);

    public void take(
            List<Sample<TYPE>> samples,
            ReadCondition<TYPE> condition);
    public void take(
            List<Sample<TYPE>> samples,
            int maxSamples,
            ReadCondition<TYPE> condition);

    /**
     * @return  true if data was read or false if no data was available.
     */
    public boolean read_next(
            Sample<TYPE> sample);

    /**
     * @return  true if data was taken or false if no data was available.
     */
    public boolean take_next(
            Sample<TYPE> sample);

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> read(
            InstanceHandle handle);
    public Sample.Iterator<TYPE> read(
            InstanceHandle handle,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    public void read(
            List<Sample<TYPE>> samples,
            InstanceHandle handle);
    public void read(
            List<Sample<TYPE>> samples,
            InstanceHandle handle,
            int maxSamples,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> take(
            InstanceHandle handle);
    public Sample.Iterator<TYPE> take(
            InstanceHandle handle,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    public void take(
            List<Sample<TYPE>> samples,
            InstanceHandle handle);
    public void take(
            List<Sample<TYPE>> samples,
            InstanceHandle handle,
            int maxSamples,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> read_next(
            InstanceHandle previousHandle);
    public Sample.Iterator<TYPE> read_next(
            InstanceHandle previousHandle,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    public void read_next(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle);
    public void read_next(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            int maxSamples,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> take_next(
            InstanceHandle previousHandle);
    public Sample.Iterator<TYPE> take_next(
            InstanceHandle previousHandle,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    public void take_next(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle);
    public void take_next(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            int maxSamples,
            Set<SampleState> sampleStates, 
            Set<ViewState> viewStates, 
            Set<InstanceState> instanceStates);

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> read_next(
            InstanceHandle previousHandle,
            ReadCondition<TYPE> condition);

    public void read_next(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            ReadCondition<TYPE> condition);
    public void read_next(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            int maxSamples,
            ReadCondition<TYPE> condition);

    /**
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> take_next(
            InstanceHandle previousHandle,
            ReadCondition<TYPE> condition);

    public void take_next(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            ReadCondition<TYPE> condition);
    public void take_next(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            int maxSamples,
            ReadCondition<TYPE> condition);

    public void getKeyValue(
            TYPE key_holder, 
            InstanceHandle handle);

    public InstanceHandle lookupInstance(
            TYPE key_holder);
}
