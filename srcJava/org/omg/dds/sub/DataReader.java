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

package org.omg.dds.sub;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.omg.dds.core.DomainEntity;
import org.omg.dds.core.Duration;
import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.NotEnabledException;
import org.omg.dds.core.PreconditionNotMetException;
import org.omg.dds.core.modifiable.ModifiableInstanceHandle;
import org.omg.dds.core.policy.DurabilityQosPolicy;
import org.omg.dds.core.policy.HistoryQosPolicy;
import org.omg.dds.core.status.LivelinessChangedStatus;
import org.omg.dds.core.status.RequestedDeadlineMissedStatus;
import org.omg.dds.core.status.RequestedIncompatibleQosStatus;
import org.omg.dds.core.status.SampleLostStatus;
import org.omg.dds.core.status.SampleRejectedStatus;
import org.omg.dds.core.status.SubscriptionMatchedStatus;
import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.topic.ContentFilteredTopic;
import org.omg.dds.topic.MultiTopic;
import org.omg.dds.topic.PublicationBuiltinTopicData;
import org.omg.dds.topic.Topic;
import org.omg.dds.topic.TopicDescription;


/**
 * A DataReader allows the application (1) to declare the data it wishes to
 * receive (i.e., make a subscription) and (2) to access the data received by
 * the attached {@link Subscriber}.
 * 
 * A DataReader refers to exactly one {@link TopicDescription} (either a
 * {@link Topic}, a {@link ContentFilteredTopic}, or a {@link MultiTopic})
 * that identifies the data to be read. The subscription has a unique
 * resulting type. The data reader may give access to several instances of
 * the resulting type, which can be distinguished from each other by their
 * keys.
 * 
 * All operations except for the inherited operations
 * {@link #setQos(org.omg.dds.core.EntityQos)}, {@link #getQos()},
 * {@link #setListener(java.util.EventListener)}, {@link #getListener()},
 * {@link #enable()}, {@link #getStatusCondition()}, and {@link #close()} may
 * fail with the exception {@link NotEnabledException}.
 * 
 * All sample-accessing operations, namely all variants of {@link #read()} or
 * {@link #take()}, may fail with the exception
 * {@link PreconditionNotMetException}.
 * 
 * <b>Access to the Data</b>
 * 
 * Data is made available to the application by the following operations on
 * DataReader objects: {@link #read()}, {@link #take()}, and the other methods
 * beginning with those prefixes.. The general semantics of the "read"
 * operations is that the application only gets access to the corresponding
 * data; the data remains the middleware's responsibility and can be read
 * again. The semantics of the "take" operations is that the application
 * takes full responsibility for the data; that data will no longer be
 * accessible to the DataReader. Consequently, it is possible for a
 * DataReader to access the same sample multiple times but only if all
 * previous accesses were read operations.
 * 
 * Each of these operations returns an ordered collection of {@link Sample}s
 * (data values and associated meta-information). Each data value represents
 * an atom of data information (i.e., a value for one instance). This
 * collection may contain samples related to the same or different instances
 * (identified by the key). Multiple samples can refer to the same instance
 * if the settings of the {@link HistoryQosPolicy} allow for it.
 * 
 * @param <TYPE>    The concrete type of the data to be read.
 */
public interface DataReader<TYPE>
extends DomainEntity<DataReader<TYPE>,
                     Subscriber,
                     DataReaderListener<TYPE>,
                     DataReaderQos> {
    /**
     * Cast this data reader to the given type, or throw an exception if
     * the cast fails.
     * 
     * @param <OTHER>   The type of the data subscribed to by this reader,
     *                  according to the caller.
     * @return          this data reader
     * @throws          ClassCastException if the cast fails
     */
    public <OTHER> DataReader<OTHER> cast();

    public ReadCondition<TYPE> createReadCondition();

    /**
     * This operation creates a ReadCondition. The returned ReadCondition
     * will be attached and belong to the DataReader.
     * 
     * @param   sampleStates    The returned condition will only trigger on
     *          samples with one of these sample states.
     * @param   viewStates      The returned condition will only trigger on
     *          samples with one of these view states.
     * @param   instanceStates  The returned condition will only trigger on
     *          samples with one of these instance states.
     */
    public ReadCondition<TYPE> createReadCondition(
            Collection<SampleState> sampleStates,
            Collection<ViewState> viewStates,
            Collection<InstanceState> instanceStates);

    /**
     * This operation creates a QueryCondition. The returned QueryCondition
     * will be attached and belong to the DataReader. It will trigger on any
     * sample state, view state, or instance state.
     * 
     * @param   queryExpression The returned condition will only trigger on
     *          samples that pass this content-based filter expression.
     * @param   queryParameters A set of parameter values for the
     *          queryExpression.
     *
     * @see     #createQueryCondition(Collection, Collection, Collection, String, List)
     */
    public QueryCondition<TYPE> createQueryCondition(
            String queryExpression,
            List<String> queryParameters);

    /**
     * This operation creates a QueryCondition. The returned QueryCondition
     * will be attached and belong to the DataReader.
     * 
     * @param   sampleStates    The returned condition will only trigger on
     *          samples with one of these sample states.
     * @param   viewStates      The returned condition will only trigger on
     *          samples with one of these view states.
     * @param   instanceStates  The returned condition will only trigger on
     *          samples with one of these instance states.
     * @param   queryExpression The returned condition will only trigger on
     *          samples that pass this content-based filter expression.
     * @param   queryParameters A set of parameter values for the
     *          queryExpression.
     *
     * @see     #createQueryCondition(String, List)
     */
    public QueryCondition<TYPE> createQueryCondition(
            Collection<SampleState> sampleStates,
            Collection<ViewState> viewStates,
            Collection<InstanceState> instanceStates,
            String queryExpression,
            List<String> queryParameters);

    /**
     * This operation closes all the entities that were created by means of
     * the "create" operations on the DataReader. That is, it closes all
     * contained ReadCondition and QueryCondition objects.
     * 
     * @throws  PreconditionNotMetException     if the any of the contained
     *          entities is in a state where it cannot be closed.
     */
    public void closeContainedEntities();

    /**
     * @return  the TopicDescription associated with the DataReader. This is
     *          the same TopicDescription that was used to create the
     *          DataReader.
     */
    public TopicDescription<TYPE> getTopicDescription();

    /**
     * This operation allows access to the SAMPLE_REJECTED communication
     * status.
     * 
     * @param   status  a container, into which this method places it result.
     * @return  the input status, as a convenience to facilitate chaining.
     * 
     * @see     org.omg.dds.core.status
     */
    public SampleRejectedStatus<TYPE> getSampleRejectedStatus(
            SampleRejectedStatus<TYPE> status);

    /**
     * This operation allows access to the LIVELINESS_CHANGED communication
     * status.
     * 
     * @param   status  a container, into which this method places it result.
     * @return  the input status, as a convenience to facilitate chaining.
     * 
     * @see     org.omg.dds.core.status
     */
    public LivelinessChangedStatus<TYPE> getLivelinessChangedStatus(
            LivelinessChangedStatus<TYPE> status);

    /**
     * This operation allows access to the REQUESTED_DEADLINE_MISSED
     * communication status.
     * 
     * @param   status  a container, into which this method places it result.
     * @return  the input status, as a convenience to facilitate chaining.
     * 
     * @see     org.omg.dds.core.status
     */
    public RequestedDeadlineMissedStatus<TYPE>
    getRequestedDeadlineMissedStatus(
            RequestedDeadlineMissedStatus<TYPE> status);

    /**
     * This operation allows access to the REQUESTED_INCOMPATIBLE_QOS
     * communication status.
     * 
     * @param   status  a container, into which this method places it result.
     * @return  the input status, as a convenience to facilitate chaining.
     * 
     * @see     org.omg.dds.core.status
     */
    public RequestedIncompatibleQosStatus<TYPE>
    getRequestedIncompatibleQosStatus(
            RequestedIncompatibleQosStatus<TYPE> status);

    /**
     * This operation allows access to the SUBSCRIPTION_MATCHED communication
     * status. 
     * 
     * @param   status  a container, into which this method places it result.
     * @return  the input status, as a convenience to facilitate chaining.
     * 
     * @see     org.omg.dds.core.status
     */
    public SubscriptionMatchedStatus<TYPE> getSubscriptionMatchedStatus(
            SubscriptionMatchedStatus<TYPE> status);

    /**
     * This operation allows access to the SAMPLE_LOST communication status.
     * 
     * @param   status  a container, into which this method places its
     *          result.
     * @return  the input status, as a convenience to facilitate chaining.
     * 
     * @see     org.omg.dds.core.status
     */
    public SampleLostStatus<TYPE> getSampleLostStatus(
            SampleLostStatus<TYPE> status);

    /**
     * This operation is intended only for DataReader entities for which
     * {@link DurabilityQosPolicy#getKind()} is not
     * {@link DurabilityQosPolicy.Kind#VOLATILE}.
     * 
     * As soon as an application enables a non-VOLATILE DataReader it will
     * start receiving both "historical" data, i.e., the data that was
     * written prior to the time the DataReader joined the domain, as well as
     * any new data written by the DataWriter entities. There are situations
     * where the application logic may require the application to wait until
     * all "historical" data is received. This is the purpose of this
     * operation.
     * 
     * The operation blocks the calling thread until either all "historical"
     * data is received, or else the duration specified by the max_Wait
     * parameter elapses, whichever happens first.
     * 
     * @throws  TimeoutException        if maxWait elapsed before all the
     *          data was received.
     * 
     * @see     #waitForHistoricalData(long, TimeUnit)
     */
    public void waitForHistoricalData(Duration maxWait)
    throws TimeoutException;

    /**
     * This operation is intended only for DataReader entities for which
     * {@link DurabilityQosPolicy#getKind()} is not
     * {@link DurabilityQosPolicy.Kind#VOLATILE}.
     * 
     * As soon as an application enables a non-VOLATILE DataReader it will
     * start receiving both "historical" data, i.e., the data that was
     * written prior to the time the DataReader joined the domain, as well as
     * any new data written by the DataWriter entities. There are situations
     * where the application logic may require the application to wait until
     * all "historical" data is received. This is the purpose of this
     * operation.
     * 
     * The operation blocks the calling thread until either all "historical"
     * data is received, or else the duration specified by the max_Wait
     * parameter elapses, whichever happens first.
     * 
     * @throws  TimeoutException        if maxWait elapsed before all the
     *          data was received.
     * 
     * @see     #waitForHistoricalData(Duration)
     */
    public void waitForHistoricalData(long maxWait, TimeUnit unit)
    throws TimeoutException;

    /**
     * This operation retrieves the list of publications currently
     * "associated" with the DataReader; that is, publications that have a
     * matching {@link Topic} and compatible QoS that the application has not
     * indicated should be "ignored" by means of
     * {@link DomainParticipant#ignorePublication(InstanceHandle)}.
     * 
     * The handles returned in the 'publicationHandles' list are the ones
     * that are used by the DDS implementation to locally identify the
     * corresponding matched DataWriter entities. These handles match the
     * ones that appear in {@link Sample#getInstanceHandle()} when reading
     * the "DCPSPublications" built-in topic.
     * 
     * The operation may fail if the infrastructure does not locally maintain
     * the connectivity information.
     * 
     * @param   publicationHandles      a container, into which this method
     *          will place its result.
     * 
     * @return  publicationHandles, as a convenience to facilitate chaining.
     * 
     * @see     #getMatchedPublicationData(PublicationBuiltinTopicData, InstanceHandle)
     */
    public Collection<InstanceHandle> getMatchedPublications(
            Collection<InstanceHandle> publicationHandles);

    /**
     * This operation retrieves information on a publication that is
     * currently "associated" with the DataReader; that is, a publication
     * with a matching {@link Topic} and compatible QoS that the application
     * has not indicated should be "ignored" by means of
     * {@link DomainParticipant#ignorePublication(InstanceHandle)}.
     * 
     * The operation {@link #getMatchedPublications(Collection)} can be used
     * to find the publications that are currently matched with the
     * DataReader.
     * 
     * @param   publicationData         a container, into which this method
     *          will place its result.
     * @param   publicationHandle       a handle to the publication, the
     *          data of which is to be retrieved.
     * 
     * @return  subscriptionData, as a convenience to facilitate chaining.
     * 
     * @throws  IllegalArgumentException        if the publicationHandle does
     *          not correspond to a publication currently associated with the
     *          DataReader.
     * @throws  UnsupportedOperationException   if the infrastructure does
     *          not hold the information necessary to fill in the
     *          publicationData.
     *
     * @see     #getMatchedPublications(Collection)
     */
    public PublicationBuiltinTopicData getMatchedPublicationData(
            PublicationBuiltinTopicData publicationData,
            InstanceHandle publicationHandle);


    // --- Type-specific interface: ------------------------------------------

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> read();
    public Sample.Iterator<TYPE> read(
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void read(
            List<Sample<TYPE>> samples);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void read(
            List<Sample<TYPE>> samples,
            int maxSamples,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> take();
    public Sample.Iterator<TYPE> take(
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void take(
            List<Sample<TYPE>> samples);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void take(
            List<Sample<TYPE>> samples,
            int maxSamples,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> read(
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void read(
            List<Sample<TYPE>> samples,
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void read(
            List<Sample<TYPE>> samples,
            int maxSamples,
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> take(
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void take(
            List<Sample<TYPE>> samples,
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void take(
            List<Sample<TYPE>> samples,
            int maxSamples,
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  true if data was read or false if no data was available.
     */
    public boolean readNext(
            Sample<TYPE> sample);

    /**
     * @return  true if data was taken or false if no data was available.
     */
    public boolean takeNext(
            Sample<TYPE> sample);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> read(
            InstanceHandle handle);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> read(
            InstanceHandle handle,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void read(
            List<Sample<TYPE>> samples,
            InstanceHandle handle);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void read(
            List<Sample<TYPE>> samples,
            InstanceHandle handle,
            int maxSamples,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> take(
            InstanceHandle handle);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> take(
            InstanceHandle handle,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void take(
            List<Sample<TYPE>> samples,
            InstanceHandle handle);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void take(
            List<Sample<TYPE>> samples,
            InstanceHandle handle,
            int maxSamples,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> readNext(
            InstanceHandle previousHandle);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> readNext(
            InstanceHandle previousHandle,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void readNext(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void readNext(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            int maxSamples,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> takeNext(
            InstanceHandle previousHandle);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> takeNext(
            InstanceHandle previousHandle,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void takeNext(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void takeNext(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            int maxSamples,
            Collection<SampleState> sampleStates, 
            Collection<ViewState> viewStates, 
            Collection<InstanceState> instanceStates);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> readNext(
            InstanceHandle previousHandle,
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void readNext(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void readNext(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            int maxSamples,
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * @return  a non-null unmodifiable iterator over loaned samples.
     */
    public Sample.Iterator<TYPE> takeNext(
            InstanceHandle previousHandle,
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void takeNext(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            ReadCondition<TYPE> condition);

    /**
     * TODO: Add JavaDoc.
     * 
     * Copy samples into the provided collection, overwriting any samples that
     * might already be present.
     */
    public void takeNext(
            List<Sample<TYPE>> samples,
            InstanceHandle previousHandle,
            int maxSamples,
            ReadCondition<TYPE> condition);

    /**
     * This operation can be used to retrieve the instance key that
     * corresponds to an instance handle. The operation will only fill the
     * fields that form the key inside the keyHolder instance.
     * 
     * @param   keyHolder       a container, into which this method shall
     *          place its result.
     * @param   handle          a handle indicating the instance whose value
     *          this method should get.
     *
     * @return  keyHolder, as a convenience to facilitate chaining.
     * 
     * @throws  IllegalArgumentException        if the {@link InstanceHandle}
     *          does not correspond to an existing data object known to the
     *          DataReader. If the implementation is not able to check
     *          invalid handles, then the result in this situation is
     *          unspecified.
     */
    public TYPE getKeyValue(
            TYPE keyHolder, 
            InstanceHandle handle);

    /**
     * This operation takes as a parameter an instance and returns a handle
     * that can be used in subsequent operations that accept an instance
     * handle as an argument. The instance parameter is only used for the
     * purpose of examining the fields that define the key.
     * 
     * This operation does not register the instance in question. If the
     * instance has not been previously registered, or if for any other
     * reason the Service is unable to provide an instance handle, the
     * Service will return a nil handle.
     * 
     * @param   handle  a container, into which this method shall place its
     *          result.
     * @param   keyHolder       a sample of the instance whose handle this
     *          method should look up.
     *
     * @return  handle, as a convenience to facilitate chaining.
     */
    public ModifiableInstanceHandle lookupInstance(
            ModifiableInstanceHandle handle,
            TYPE keyHolder);
}
