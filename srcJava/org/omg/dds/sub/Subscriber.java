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
import java.util.Set;

import org.omg.dds.core.DDSObject;
import org.omg.dds.core.DomainEntity;
import org.omg.dds.core.InconsistentPolicyException;
import org.omg.dds.core.NotEnabledException;
import org.omg.dds.core.PreconditionNotMetException;
import org.omg.dds.core.policy.PresentationQosPolicy;
import org.omg.dds.core.status.DataAvailableStatus;
import org.omg.dds.core.status.Status;
import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.sub.modifiable.ModifiableDataReaderQos;
import org.omg.dds.topic.Topic;
import org.omg.dds.topic.TopicDescription;
import org.omg.dds.topic.TopicQos;
import org.omg.dds.type.builtin.BytesDataReader;
import org.omg.dds.type.builtin.KeyedBytes;
import org.omg.dds.type.builtin.KeyedBytesDataReader;
import org.omg.dds.type.builtin.KeyedString;
import org.omg.dds.type.builtin.KeyedStringDataReader;
import org.omg.dds.type.builtin.StringDataReader;


/**
 * A Subscriber is the object responsible for the actual reception of the
 * data resulting from its subscriptions.
 * 
 * A Subscriber acts on the behalf of one or several {@link DataReader}
 * objects that are related to it. When it receives data (from the other
 * parts of the system), it builds the list of concerned DataReader objects,
 * and then indicates to the application that data is available, through its
 * listener or by enabling related conditions. The application can access the
 * list of concerned DataReader objects through the operation
 * {@link #getDataReaders(Collection)} and then access the data available
 * through operations on the DataReaders.
 * 
 * All operations except for the inherited operations
 * {@link #setQos(SubscriberQos)}, {@link #getQos()},
 * {@link #setListener(SubscriberListener)}, {@link #getListener()},
 * {@link #enable()}, {@link #getStatusCondition()}, and
 * {@link #createDataReader(TopicDescription)} may fail with the exception
 * {@link NotEnabledException}.
 */
public interface Subscriber
extends DomainEntity<Subscriber,
                     DomainParticipant,
                     SubscriberListener,
                     SubscriberQos>
{
    // --- Create (any) DataReader: ------------------------------------------

    /**
     * This operation creates a {@link DataReader}. The returned DataReader
     * will be attached and belong to the Subscriber.
     * 
     * Note that a common application pattern to construct the QoS for the
     * DataReader is to:
     * 
     * <ul>
     *     <li>Retrieve the QoS policies on the associated {@link Topic} by
     *         means of {@link Topic#getQos()}.</li>
     *     <li>Retrieve the default DataReader QoS by means of
     *         {@link #getDefaultDataReaderQos()}.
     *     <li>Combine those two QoS policies and selectively modify policies
     *         as desired.</li>
     *     <li>Use the resulting QoS policies to construct the DataReader.
     * </ul>
     * 
     * The {@link TopicDescription} passed to this operation must have been
     * created from the same {@link DomainParticipant} that was used to
     * create this Subscriber. If the TopicDescription was created from a
     * different DomainParticipant, the operation will fail.
     * 
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic);

    /**
     * This operation creates a {@link DataReader}. The returned DataReader
     * will be attached and belong to the Subscriber.
     * 
     * Note that a common application pattern to construct the QoS for the
     * DataReader is to:
     * 
     * <ul>
     *     <li>Retrieve the QoS policies on the associated {@link Topic} by
     *         means of {@link Topic#getQos()}.</li>
     *     <li>Retrieve the default DataReader QoS by means of
     *         {@link #getDefaultDataReaderQos()}.
     *     <li>Combine those two QoS policies and selectively modify policies
     *         as desired.</li>
     *     <li>Use the resulting QoS policies to construct the DataReader.
     * </ul>
     * 
     * The {@link TopicDescription} passed to this operation must have been
     * created from the same {@link DomainParticipant} that was used to
     * create this Subscriber. If the TopicDescription was created from a
     * different DomainParticipant, the operation will fail.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     *
     * @see     #createDataReader(TopicDescription)
     */
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic,
            DataReaderQos qos,
            DataReaderListener<TYPE> listener,
            Collection<Class<? extends Status<?>>> statuses);

    /**
     * Create a new data reader.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     *
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic,
            String qosLibraryName,
            String qosProfileName,
            DataReaderListener<TYPE> listener,
            Collection<Class<? extends Status<?>>> statuses);


    // --- Create DataReader of built-in bytes type: -------------------------

    /**
     * Create a new data reader for this built-in type.
     * 
     * @see     #createDataReader(TopicDescription)
     */
    public BytesDataReader createBytesDataReader(
            TopicDescription<byte[]> topic);

    /**
     * Create a new data reader for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public BytesDataReader createBytesDataReader(
            TopicDescription<byte[]> topic,
            DataReaderQos qos,
            DataReaderListener<byte[]> listener,
            Collection<Class<? extends Status<?>>> statuses);

    /**
     * Create a new data reader for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public BytesDataReader createBytesDataReader(
            TopicDescription<byte[]> topic,
            String qosLibraryName,
            String qosProfileName,
            DataReaderListener<byte[]> listener,
            Collection<Class<? extends Status<?>>> statuses);


    // --- Create DataReader of built-in KeyedBytes type: --------------------

    /**
     * Create a new data reader for this built-in type.
     * 
     * @see     #createDataReader(TopicDescription)
     */
    public KeyedBytesDataReader createKeyedBytesDataReader(
            TopicDescription<KeyedBytes> topic);

    /**
     * Create a new data reader for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public KeyedBytesDataReader createKeyedBytesDataReader(
            TopicDescription<KeyedBytes> topic,
            DataReaderQos qos,
            DataReaderListener<KeyedBytes> listener,
            Collection<Class<? extends Status<?>>> statuses);

    /**
     * Create a new data reader for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public KeyedBytesDataReader createKeyedBytesDataReader(
            TopicDescription<KeyedBytes> topic,
            String qosLibraryName,
            String qosProfileName,
            DataReaderListener<KeyedBytes> listener,
            Collection<Class<? extends Status<?>>> statuses);


    // --- Create DataReader of built-in string type: ------------------------

    /**
     * Create a new data reader for this built-in type.
     * 
     * @see     #createDataReader(TopicDescription)
     */
    public StringDataReader createStringDataReader(
            TopicDescription<String> topic);

    /**
     * Create a new data reader for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public StringDataReader createStringDataReader(
            TopicDescription<String> topic,
            DataReaderQos qos,
            DataReaderListener<String> listener,
            Collection<Class<? extends Status<?>>> statuses);

    /**
     * Create a new data reader for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public StringDataReader createStringDataReader(
            TopicDescription<String> topic,
            String qosLibraryName,
            String qosProfileName,
            DataReaderListener<String> listener,
            Collection<Class<? extends Status<?>>> statuses);


    // --- Create DataReader of built-in KeyedString type: -------------------

    /**
     * Create a new data reader for this built-in type.
     * 
     * @see     #createDataReader(TopicDescription)
     */
    public KeyedStringDataReader createKeyedStringDataReader(
            TopicDescription<KeyedString> topic);

    /**
     * Create a new data reader for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public KeyedStringDataReader createKeyedStringDataReader(
            TopicDescription<KeyedString> topic,
            DataReaderQos qos,
            DataReaderListener<KeyedString> listener,
            Collection<Class<? extends Status<?>>> statuses);

    /**
     * Create a new data reader for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataReader(TopicDescription, DataReaderQos, DataReaderListener, Collection)
     */
    public KeyedStringDataReader createKeyedStringDataReader(
            TopicDescription<KeyedString> topic,
            String qosLibraryName,
            String qosProfileName,
            DataReaderListener<KeyedString> listener,
            Collection<Class<? extends Status<?>>> statuses);


    // --- Lookup operations: ------------------------------------------------

    /**
     * This operation retrieves a previously-created DataReader belonging to
     * the Subscriber that is attached to a {@link Topic} with a matching
     * topicName. If no such DataReader exists, the operation will return
     * null.
     * 
     * If multiple DataReaders attached to the Subscriber satisfy this
     * condition, then the operation will return one of them. It is not
     * specified which one.
     * 
     * The use of this operation on the built-in Subscriber allows access to
     * the built-in DataReader entities for the built-in topics.
     * 
     * @see     DomainParticipant#getBuiltinSubscriber()
     */
    public <TYPE> DataReader<TYPE> lookupDataReader(String topicName);

    /**
     * This operation retrieves a previously-created DataReader belonging to
     * the Subscriber that is attached to the given {@link TopicDescription}.
     * If no such DataReader exists, the operation will return null.
     * 
     * If multiple DataReaders attached to the Subscriber satisfy this
     * condition, then the operation will return one of them. It is not
     * specified which one.
     * 
     * The use of this operation on the built-in Subscriber allows access to
     * the built-in DataReader entities for the built-in topics.
     * 
     * @see     DomainParticipant#getBuiltinSubscriber()
     */
    public <TYPE> DataReader<TYPE> lookupDataReader(
            TopicDescription<TYPE> topicName);

    /**
     * Look up a DataReader for the given built-in data type.
     * 
     * @throws  ClassCastException      if a DataReader exists on the given
     *          TopicDescription but is of a different type.
     *
     * @see     #lookupDataReader(TopicDescription)
     */
    public BytesDataReader lookupBytesDataReader(
            TopicDescription<byte[]> topic);

    /**
     * Look up a DataReader for the given built-in data type.
     * 
     * @throws  ClassCastException      if a DataReader exists on the given
     *          TopicDescription but is of a different type.
     *
     * @see     #lookupDataReader(TopicDescription)
     */
    public KeyedBytesDataReader lookupKeyedBytesDataReader(
            TopicDescription<KeyedBytes> topic);

    /**
     * Look up a DataReader for the given built-in data type.
     * 
     * @throws  ClassCastException      if a DataReader exists on the given
     *          TopicDescription but is of a different type.
     *
     * @see     #lookupDataReader(TopicDescription)
     */
    public StringDataReader lookupStringDataReader(
            TopicDescription<String> topic);

    /**
     * Look up a DataReader for the given built-in data type.
     * 
     * @throws  ClassCastException      if a DataReader exists on the given
     *          TopicDescription but is of a different type.
     *
     * @see     #lookupDataReader(TopicDescription)
     */
    public KeyedStringDataReader lookupKeyedStringDataReader(
            TopicDescription<KeyedString> topic);


    // --- Other operations: -------------------------------------------------

    /**
     * This operation closes all the entities that were created by means of
     * the "create" operations on the Subscriber. That is, it closes all
     * contained {@link DataReader} objects. This pattern is applied
     * recursively. In this manner the operation on the Subscriber will end
     * up closing all the entities recursively contained in the Subscriber,
     * that is also the {@link QueryCondition} and {@link ReadCondition}
     * objects belonging to the contained DataReaders.
     * 
     * @throws  PreconditionNotMetException     if any of the contained
     *          entities is in a state where it cannot be closed. This will
     *          occur, for example, if a contained DataReader cannot be
     *          closed because the application has called a
     *          {@link DataReader#read()} or {@link DataReader#take()}
     *          operation and has not called the corresponding
     *          {@link Sample.Iterator#returnLoan()} operation to return the
     *          loaned samples.
     */
    public void closeContainedEntities();

    /**
     * This operation is equivalent to calling
     * {@link #getDataReaders(Collection, Collection, Collection, Collection)}
     * with any sample state
     * ({@link SampleState#anySampleStateSet(org.omg.dds.core.Bootstrap)}),
     * any view state
     * ({@link ViewState#anyViewStateSet(org.omg.dds.core.Bootstrap)}), and
     * any instance state
     * ({@link InstanceState#anyInstanceStateSet(org.omg.dds.core.Bootstrap)}).
     * 
     * @param   readers         a container, into which this method will place
     *          its result.
     * 
     * @return  readers, as a convenience to facilitate chaining.
     * 
     * @throws  PreconditionNotMetException     if the Subscriber has
     *          {@link PresentationQosPolicy#getAccessScope()} set to
     *          {@link PresentationQosPolicy.AccessScopeKind#GROUP} and this
     *          operation is not invoked inside a {@link #beginAccess()}/
     *          {@link #endAccess()} block.
     * 
     * @see     #getDataReaders(Collection, Collection, Collection, Collection)
     * @see     #beginAccess()
     * @see     #endAccess()
     * @see     PresentationQosPolicy
     */
    public Collection<DataReader<?>> getDataReaders(
            Collection<DataReader<?>> readers);

    /**
     * This operation allows the application to access the {@link DataReader}
     * objects that contain samples with the specified sampleStates,
     * viewStates, and instanceStates.
     * 
     * If the {@link PresentationQosPolicy} of the Subscriber has
     * {@link PresentationQosPolicy#getAccessScope()} set to
     * {@link PresentationQosPolicy.AccessScopeKind#GROUP}, this operation
     * should only be invoked inside a {@link #beginAccess()}/
     * {@link #endAccess()} block. Otherwise it will fail with
     * {@link PreconditionNotMetException}.
     * 
     * Depending on the setting of the {@link PresentationQosPolicy}, the
     * returned collection of DataReader objects may be a 'set' containing
     * each DataReader at most once in no specified order, or a 'list'
     * containing each DataReader one or more times in a specific order.
     * (This refers to the semantics of the collection; the concrete type of
     * the collection may or may not implement {@link Set} or {@link List}).
     * 
     * <ol>
     *     <li>If {@link PresentationQosPolicy#getAccessScope()} is
     *         {@link PresentationQosPolicy.AccessScopeKind#INSTANCE} or
     *         {@link PresentationQosPolicy.AccessScopeKind#TOPIC}, the
     *         returned collection is a 'set'.</li>
     *     <li>If {@link PresentationQosPolicy#getAccessScope()} is
     *         {@link PresentationQosPolicy.AccessScopeKind#GROUP} and
     *         {@link PresentationQosPolicy#isOrderedAccess()} is true, then
     *         the returned collection is a 'list'.</li>
     * </ol>
     * 
     * This difference is due to the fact that, in the second situation it
     * is required to access samples belonging to different DataReader
     * objects in a particular order. In this case, the application should
     * process each DataReader in the same order it appears in the 'list' and
     * read or take exactly one sample from each DataReader.
     * 
     * @param   readers         a container, into which this method will place
     *          its result.
     * @param   sampleStates    a DataReader will only be placed into the
     *          readers collection if it has data available with one of these
     *          sample states.
     * @param viewStates        a DataReader will only be placed into the
     *          readers collection if it has data available with one of these
     *          view states.
     * @param instanceStates    a DataReader will only be placed into the
     *          readers collection if it has data available with one of these
     *          instance states.
     * 
     * @return  readers, as a convenience to facilitate chaining.
     * 
     * @throws  PreconditionNotMetException     if the Subscriber has
     *          {@link PresentationQosPolicy#getAccessScope()} set to
     *          {@link PresentationQosPolicy.AccessScopeKind#GROUP} and this
     *          operation is not invoked inside a {@link #beginAccess()}/
     *          {@link #endAccess()} block.
     * 
     * @see     #getDataReaders(Collection)
     * @see     #beginAccess()
     * @see     #endAccess()
     * @see     PresentationQosPolicy
     */
    public Collection<DataReader<?>> getDataReaders(
            Collection<DataReader<?>> readers,
            ReaderState readerState);

    /**
     * This operation invokes the operation
     * {@link DataReaderListener#onDataAvailable(org.omg.dds.core.status.DataAvailableStatus)}
     * on the DataReaderListener objects attached to contained DataReader
     * entities with a {@link DataAvailableStatus} that is considered
     * changed.
     * 
     * This operation is typically invoked from
     * {@link SubscriberListener#onDataOnReaders(org.omg.dds.core.status.DataOnReadersStatus)}.
     * That way the SubscriberListener can delegate to the DataReaderListener
     * objects the handling of the data.
     */
    public void notifyDataReaders();

    /**
     * This operation indicates that the application is about to access the
     * data samples in any of the {@link DataReader} objects attached to the
     * Subscriber.
     * 
     * The application is required to use this operation only if the
     * {@link PresentationQosPolicy} of the Subscriber has 
     * {@link PresentationQosPolicy#getAccessScope()} equal to
     * {@link PresentationQosPolicy.AccessScopeKind#GROUP}.
     * 
     * In the aforementioned case, the operation must be called prior to
     * calling any of the sample-accessing operations, namely:
     * {@link #getDataReaders(Collection)}, {@link DataReader#read()},
     * {@link DataReader#take()}, or their overloads. Otherwise the
     * sample-accessing operations will fail with
     * {@link PreconditionNotMetException}. Once the application has
     * finished accessing the data samples it must call {@link #endAccess()}.
     * 
     * It is not required for the application to call {@link #beginAccess()}/
     * {@link #endAccess()} if the {@link PresentationQosPolicy} has the
     * access scope set to something other than 'GROUP'. Calling these
     * methods in this case is not considered an error and has no effect.
     * 
     * The calls to {@link #beginAccess()}/{@link #endAccess()} may be
     * nested. In that case, the application must call {@link #endAccess()}
     * as many times as it called beginAccess.
     * 
     * @see     #endAccess()
     * @see     PresentationQosPolicy
     */
    public void beginAccess();

    /**
     * Indicates that the application has finished accessing the data samples
     * in {@link DataReader} objects managed by the Subscriber.
     * 
     * This operation must be used to 'close' a corresponding
     * {@link #beginAccess()}.
     * 
     * After calling endAccess the application should no longer access any of
     * the Sample (including corresponding data) elements returned from the
     * sample-accessing operations.
     * 
     * @throws  PreconditionNotMetException     if this call does not close a
     *          previous call to {@link #beginAccess()}.
     * 
     * @see     #beginAccess()
     */
    public void endAccess();

    /**
     * This operation retrieves the default value of the DataReader QoS, that
     * is, the QoS policies which will be used for newly created
     * {@link DataReader} entities in the case where the QoS policies are
     * defaulted in the {@link #createDataReader(TopicDescription)}
     * operation.
     * 
     * The values retrieved will match the set of values specified on the
     * last successful call to
     * {@link #setDefaultDataReaderQos(DataReaderQos)}, or else, if the call
     * was never made, the default values identified by the DDS
     * specification.
     * 
     * @see     #setDefaultDataReaderQos(DataReaderQos)
     */
    public DataReaderQos getDefaultDataReaderQos();

    /**
     * This operation sets a default value of the DataReader QoS policies,
     * which will be used for newly created {@link DataReader} entities in
     * the case where the QoS policies are defaulted in the
     * {@link #createDataReader(TopicDescription)} operation.
     * 
     * @throws  InconsistentPolicyException     if the resulting policies are
     *          not self consistent. In this case, this operation will have
     *          no effect.
     *
     * @see     #getDefaultDataReaderQos()
     */
    public void setDefaultDataReaderQos(DataReaderQos qos);

    /**
     * @see     #setDefaultDataReaderQos(DataReaderQos)
     */
    public void setDefaultDataReaderQos(
            String qosLibraryName,
            String qosProfileName);

    /**
     * This operation copies the policies in the {@link TopicQos} to the
     * corresponding policies in the {@link DataReaderQos} (replacing values
     * in the latter, if present).
     * 
     * This is a "convenience" operation most useful in combination with the
     * operations {@link #getDefaultDataReaderQos()} and
     * {@link Topic#getQos()}. The operation can be used to merge the
     * DataReader default QoS policies with the corresponding ones on the
     * Topic. The resulting QoS can then be used to create a new DataReader
     * or set its QoS.
     * 
     * This operation does not check the resulting QoS for consistency. This
     * is because the 'merged' QoS may not be the final one, as the
     * application can still modify some policies prior to applying the
     * policies to the DataReader.
     * 
     * @param   dst     the QoS, the policies of which will be overwritten.
     * @param   src     the source for the new policies to be copied.
     * 
     * @return  dst, as a convenience to facilitate chaining.
     */
    public ModifiableDataReaderQos copyFromTopicQos(
            ModifiableDataReaderQos dst, TopicQos src);


    // --- ReaderState: ------------------------------------------------------

    /**
     * Create and return a new modifiable {@link ReaderState} object. This
     * object will be initialized with no sample states, no instance states,
     * and no view states.
     * 
     * This method shall never return null.
     * 
     * @return  a new {@link ReaderState} object.
     */
    public ReaderState createReaderState();


    /**
     * A ReaderState encapsulates sets of sample states, view states, and
     * instance states as a convenience.
     * 
     * Instances of ReaderState may be unmodifiable, in which case methods
     * that would change them shall throw
     * {@link UnsupportedOperationException}.
     */
    public static interface ReaderState extends DDSObject, Cloneable {
        // --- Accessors: ----------------------------------------------------

        /**
         * Get the current set of sample states. The resulting unmodifiable
         * collection may be empty, but it shall never be null.
         * 
         * @return      the current set of sample states.
         */
        public Set<SampleState> getSampleStates();

        /**
         * Get the current set of view states. The resulting unmodifiable
         * collection may be empty, but it shall never be null.
         * 
         * @return      the current set of view states.
         */
        public Set<ViewState> getViewStates();

        /**
         * Get the current set of instance states. The resulting unmodifiable
         * collection may be empty, but it shall never be null.
         * 
         * @return      the current set of instance states.
         */
        public Set<InstanceState> getInstanceStates();


        // --- Mutators: -----------------------------------------------------

        /**
         * Add the given {@link SampleState} to this ReaderState.
         * 
         * @param state the state to add.
         * 
         * @return      this
         * 
         * @throws      UnsupportedOperationException   if this ReaderState
         *                                              is unmodifiable.
         */
        public ReaderState with(SampleState state);

        /**
         * Add the given {@link ViewState} to this ReaderState.
         * 
         * @param state the state to add.
         * 
         * @return      this
         * 
         * @throws      UnsupportedOperationException   if this ReaderState
         *                                              is unmodifiable.
         */
        public ReaderState with(ViewState state);

        /**
         * Add the given {@link InstanceState} to this ReaderState.
         * 
         * @param state the state to add.
         * 
         * @return      this
         * 
         * @throws      UnsupportedOperationException   if this ReaderState
         *                                              is unmodifiable.
         */
        public ReaderState with(InstanceState state);

        /**
         * Add all {@link SampleState} values to this ReaderState.
         * 
         * @return      this
         * 
         * @throws      UnsupportedOperationException   if this ReaderState
         *                                              is unmodifiable.
         */
        public ReaderState withAnySampleState();

        /**
         * Add all {@link ViewState} values to this ReaderState.
         * 
         * @return      this
         * 
         * @throws      UnsupportedOperationException   if this ReaderState
         *                                              is unmodifiable.
         */
        public ReaderState withAnyViewState();

        /**
         * Add all {@link InstanceState} values to this ReaderState.
         * 
         * @return      this
         * 
         * @throws      UnsupportedOperationException   if this ReaderState
         *                                              is unmodifiable.
         */
        public ReaderState withAnyInstanceState();

        /**
         * Add {@link InstanceState#NOT_ALIVE_DISPOSED} and
         * {@link InstanceState#NOT_ALIVE_NO_WRITERS} to this ReaderState.
         * 
         * @return      this
         * 
         * @throws      UnsupportedOperationException   if this ReaderState
         *                                              is unmodifiable.
         */
        public ReaderState withNotAliveInstanceStates();


        // --- From Object: --------------------------------------------------

        public ReaderState clone();

        public boolean equals(Object other);

        public int hashCode();
    }
}
