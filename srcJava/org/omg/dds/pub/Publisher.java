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

package org.omg.dds.pub;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.omg.dds.core.DomainEntity;
import org.omg.dds.core.Duration;
import org.omg.dds.core.InconsistentPolicyException;
import org.omg.dds.core.NotEnabledException;
import org.omg.dds.core.PreconditionNotMetException;
import org.omg.dds.core.status.Status;
import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.sub.DataReader;
import org.omg.dds.topic.Topic;
import org.omg.dds.topic.TopicQos;
import org.omg.dds.type.builtin.BytesDataWriter;
import org.omg.dds.type.builtin.KeyedBytes;
import org.omg.dds.type.builtin.KeyedBytesDataWriter;
import org.omg.dds.type.builtin.KeyedString;
import org.omg.dds.type.builtin.KeyedStringDataWriter;
import org.omg.dds.type.builtin.StringDataWriter;


/**
 * A Publisher is the object responsible for the actual dissemination of
 * publications.
 * 
 * The Publisher acts on the behalf of one or several {@link DataWriter}
 * objects that belong to it. When it is informed of a change to the data
 * associated with one of its DataWriter objects, it decides when it is
 * appropriate to actually send the data-update message. In making this
 * decision, it considers any extra information that goes with the data
 * (time stamp, writer, etc.) as well as the QoS of the Publisher and the
 * DataWriter.
 * 
 * All operations except for {@link #setQos(PublisherQos)}, {@link #getQos()},
 * {@link #setListener(PublisherListener)}, {@link #getListener()},
 * {@link #enable()}, {@link #getStatusCondition()},
 * {@link #createDataWriter(Topic)}, and {@link Publisher#close()} may fail
 * with the exception {@link NotEnabledException}.
 */
public interface Publisher
extends DomainEntity<Publisher,
                     DomainParticipant,
                     PublisherListener,
                     PublisherQos>
{
    // --- Create (any) DataWriter: ------------------------------------------

    /**
     * This operation creates a DataWriter. The returned DataWriter will be
     * attached and belongs to the Publisher.
     * 
     * Note that a common application pattern to construct the QoS for the
     * DataWriter is to:
     * 
     * <ul>
     *     <li>Retrieve the QoS policies on the associated {@link Topic} by
     *         means of {@link Topic#getQos()}.</li>
     *     <li>Retrieve the default DataWriter QoS by means of
     *         {@link Publisher#getDefaultDataWriterQos()}.</li>
     *     <li>Combine those two QoS policies and selectively modify policies
     *         as desired -- see
     *         {@link #copyFromTopicQos(DataWriterQos, TopicQos)}.</li>
     *     <li>Use the resulting QoS policies to construct the DataWriter.
     *         </li>
     * </ul>
     * 
     * The {@link Topic} passed to this operation must have been created from
     * the same {@link DomainParticipant} that was used to create this
     * Publisher. If the Topic was created from a different
     * DomainParticipant, the operation will fail.
     * 
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public <TYPE> DataWriter<TYPE> createDataWriter(
            Topic<TYPE> topic);

    /**
     * This operation creates a DataWriter. The returned DataWriter will be
     * attached and belongs to the Publisher.
     * 
     * Note that a common application pattern to construct the QoS for the
     * DataWriter is to:
     * 
     * <ul>
     *     <li>Retrieve the QoS policies on the associated {@link Topic} by
     *         means of {@link Topic#getQos()}.</li>
     *     <li>Retrieve the default DataWriter QoS by means of
     *         {@link Publisher#getDefaultDataWriterQos()}.</li>
     *     <li>Combine those two QoS policies and selectively modify policies
     *         as desired -- see
     *         {@link #copyFromTopicQos(DataWriterQos, TopicQos)}.</li>
     *     <li>Use the resulting QoS policies to construct the DataWriter.
     *         </li>
     * </ul>
     * 
     * The {@link Topic} passed to this operation must have been created from
     * the same {@link DomainParticipant} that was used to create this
     * Publisher. If the Topic was created from a different
     * DomainParticipant, the operation will fail.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     *
     * @see     #createDataWriter(Topic)
     */
    public <TYPE> DataWriter<TYPE> createDataWriter(
            Topic<TYPE> topic,
            DataWriterQos qos,
            DataWriterListener<TYPE> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);

    /**
     * Create a new data writer.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     *
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public <TYPE> DataWriter<TYPE> createDataWriter(
            Topic<TYPE> topic,
            String qosLibraryName,
            String qosProfileName,
            DataWriterListener<TYPE> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);


    // --- Create DataWriter for built-in bytes type: ------------------------

    /**
     * Create a new data writer for this built-in type.
     * 
     * @see     #createDataWriter(Topic)
     */
    public BytesDataWriter createBytesDataWriter(
            Topic<byte[]> topic);

    /**
     * Create a new data writer for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public BytesDataWriter createBytesDataWriter(
            Topic<byte[]> topic,
            DataWriterQos qos,
            DataWriterListener<byte[]> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);

    /**
     * Create a new data writer for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public BytesDataWriter createBytesDataWriter(
            Topic<byte[]> topic,
            String qosLibraryName,
            String qosProfileName,
            DataWriterListener<byte[]> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);


    // --- Create DataWriter for built-in KeyedBytes type: -------------------

    /**
     * Create a new data writer for this built-in type.
     * 
     * @see     #createDataWriter(Topic)
     */
    public KeyedBytesDataWriter createKeyedBytesDataWriter(
            Topic<KeyedBytes> topic);

    /**
     * Create a new data writer for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public KeyedBytesDataWriter createKeyedBytesDataWriter(
            Topic<KeyedBytes> topic,
            DataWriterQos qos,
            DataWriterListener<KeyedBytes> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);

    /**
     * Create a new data writer for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public KeyedBytesDataWriter createKeyedBytesDataWriter(
            Topic<KeyedBytes> topic,
            String qosLibraryName,
            String qosProfileName,
            DataWriterListener<KeyedBytes> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);


    // --- Create DataWriter for built-in string type: -----------------------

    /**
     * Create a new data writer for this built-in type.
     * 
     * @see     #createDataWriter(Topic)
     */
    public StringDataWriter createStringDataWriter(
            Topic<String> topic);

    /**
     * Create a new data writer for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public StringDataWriter createStringDataWriter(
            Topic<String> topic,
            DataWriterQos qos,
            DataWriterListener<String> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);

    /**
     * Create a new data writer for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public StringDataWriter createStringDataWriter(
            Topic<String> topic,
            String qosLibraryName,
            String qosProfileName,
            DataWriterListener<String> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);


    // --- Create DataWriter for built-in KeyedString type: ------------------

    /**
     * Create a new data writer for this built-in type.
     * 
     * @see     #createDataWriter(Topic)
     */
    public KeyedStringDataWriter createKeyedStringDataWriter(
            Topic<KeyedString> topic);

    /**
     * Create a new data writer for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public KeyedStringDataWriter createKeyedStringDataWriter(
            Topic<KeyedString> topic,
            DataWriterQos qos,
            DataWriterListener<KeyedString> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);

    /**
     * Create a new data writer for this built-in type.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     * 
     * @see     #createDataWriter(Topic, DataWriterQos, DataWriterListener, Collection)
     */
    public KeyedStringDataWriter createKeyedStringDataWriter(
            Topic<KeyedString> topic,
            String qosLibraryName,
            String qosProfileName,
            DataWriterListener<KeyedString> listener,
            Collection<Class<? extends Status<?, ?>>> statuses);


    // --- Lookup operations: ------------------------------------------------

    /**
     * This operation retrieves a previously created {@link DataWriter}
     * belonging to the Publisher that is attached to a {@link Topic} with a
     * matching name. If no such DataWriter exists, the operation will return
     * null.
     * 
     * If multiple DataWriters attached to the Publisher satisfy this
     * condition, then the operation will return one of them. It is not
     * specified which one.
     * 
     * @see     #lookupDataWriter(Topic)
     */
    public <TYPE> DataWriter<TYPE> lookupDataWriter(String topicName);

    /**
     * This operation retrieves a previously created {@link DataWriter}
     * belonging to the Publisher that is attached to the given
     * {@link Topic}. If no such DataWriter exists, the operation will return
     * null.
     * 
     * If multiple DataWriters attached to the Publisher satisfy this
     * condition, then the operation will return one of them. It is not
     * specified which one.
     * 
     * @see     #lookupDataWriter(String)
     */
    public <TYPE> DataWriter<TYPE> lookupDataWriter(Topic<TYPE> topic);

    /**
     * Look up a DataWriter for the given built-in data type.
     * 
     * @throws  ClassCastException      if a DataWriter exists on the given
     *          Topic but is of a different type.
     *
     * @see     #lookupDataWriter(Topic)
     */
    public BytesDataWriter lookupBytesDataWriter(Topic<byte[]> topic);

    /**
     * Look up a DataWriter for the given built-in data type.
     * 
     * @throws  ClassCastException      if a DataWriter exists on the given
     *          Topic but is of a different type.
     *
     * @see     #lookupDataWriter(Topic)
     */
    public KeyedBytesDataWriter lookupKeyedBytesDataWriter(
            Topic<KeyedBytes> topic);

    /**
     * Look up a DataWriter for the given built-in data type.
     * 
     * @throws  ClassCastException      if a DataWriter exists on the given
     *          Topic but is of a different type.
     *
     * @see     #lookupDataWriter(Topic)
     */
    public StringDataWriter lookupStringDataWriter(Topic<String> topic);

    /**
     * Look up a DataWriter for the given built-in data type.
     * 
     * @throws  ClassCastException      if a DataWriter exists on the given
     *          Topic but is of a different type.
     *
     * @see     #lookupDataWriter(Topic)
     */
    public KeyedStringDataWriter lookupKeyedStringDataWriter(
            Topic<KeyedString> topic);


    // --- Other operations: -------------------------------------------------

    /**
     * This operation closes all the entities that were created by means of
     * the "create" operations on the Publisher. That is, it closes all
     * contained {@link DataWriter} objects.
     * 
     * @throws  PreconditionNotMetException     if the any of the contained
     *          entities is in a state where it cannot be deleted.
     */
    public void closeContainedEntities();

    /**
     * This operation indicates to the Service that the application is about
     * to make multiple modifications using DataWriter objects belonging to
     * the Publisher.
     * 
     * It is a hint to the Service so it can optimize its performance by
     * e.g., holding the dissemination of the modifications and then batching
     * them.
     * 
     * It is not required that the Service use this hint in any way.
     * 
     * The use of this operation must be matched by a corresponding call to
     * {@link #resumePublications()} indicating that the set of modifications
     * has completed. If the Publisher is deleted before
     * {@link #resumePublications()} is called, any suspended updates yet to
     * be published will be discarded.
     * 
     * @see     #resumePublications()
     */
    public void suspendPublications();

    /**
     * This operation indicates to the Service that the application has
     * completed the multiple changes initiated by the previous
     * {@link #suspendPublications()}. This is a hint to the Service that can
     * be used by a Service implementation to e.g., batch all the
     * modifications made since the {@link #suspendPublications()}.
     *
     * @throws  PreconditionNotMetException     if the call to this method
     *          does not match a previous call to
     *          {@link #suspendPublications()}.
     * 
     * @see     #suspendPublications()
     */
    public void resumePublications();

    /**
     * This operation requests that the application will begin a 'coherent
     * set' of modifications using {@link DataWriter} objects attached to the
     * Publisher. The 'coherent set' will be completed by a matching call to
     * {@link #endCoherentChanges()}.
     * 
     * A 'coherent set' is a set of modifications that must be propagated in
     * such a way that they are interpreted at the receivers' side as a
     * consistent set of modifications; that is, the receiver will only be
     * able to access the data after all the modifications in the set are
     * available at the receiver end.
     * 
     * A connectivity change may occur in the middle of a set of coherent
     * changes; for example, the set of partitions used by the Publisher or
     * one of its Subscribers may change, a late-joining DataReader may
     * appear on the network, or a communication failure may occur. In the
     * event that such a change prevents an entity from receiving the entire
     * set of coherent changes, that entity must behave as if it had
     * received none of the set.
     * 
     * These calls can be nested. In that case, the coherent set terminates
     * only with the last call to {@link #endCoherentChanges()}.
     * 
     * The support for 'coherent changes' enables a publishing application to
     * change the value of several data instances that could belong to the
     * same or different topics and have those changes be seen 'atomically'
     * by the readers. This is useful in cases where the values are
     * interrelated. For example, if there are two data instances
     * representing the 'altitude' and 'velocity vector' of the same aircraft
     * and both are changed, it may be useful to communicate those values in
     * a way the reader can see both together; otherwise, it may e.g.,
     * erroneously interpret that the aircraft is on a collision course.
     * 
     * @see     #endCoherentChanges()
     */
    public void beginCoherentChanges();

    /**
     * This operation terminates the 'coherent set' initiated by the matching
     * call to {@link #beginCoherentChanges()}.
     * 
     * @throws  PreconditionNotMetException     if there is no matching call
     *          to {@link #beginCoherentChanges()}.
     * 
     * @see     #beginCoherentChanges()
     */
    public void endCoherentChanges();

    /**
     * This operation blocks the calling thread until either all data
     * written by the reliable {@link DataWriter} entities is acknowledged by
     * all matched reliable {@link DataReader} entities, or else the duration
     * specified elapses, whichever happens first.
     * 
     * @throws  TimeoutException        if maxWait elapsed before all the
     *          data was acknowledged.
     */
    public void waitForAcknowledgments(Duration maxWait)
    throws TimeoutException;

    /**
     * This operation blocks the calling thread until either all data
     * written by the reliable {@link DataWriter} entities is acknowledged by
     * all matched reliable {@link DataReader} entities, or else the duration
     * specified elapses, whichever happens first.
     * 
     * @throws  TimeoutException        if maxWait elapsed before all the
     *          data was acknowledged.
     */
    public void waitForAcknowledgments(long maxWait, TimeUnit unit)
    throws TimeoutException;

    /**
     * This operation retrieves the default value of the DataWriter QoS, that
     * is, the QoS policies which will be used for newly created
     * {@link DataWriter} entities in the case where the QoS policies are
     * defaulted in the {@link #createDataWriter(Topic)} operation.
     * 
     * The values retrieved will match the set of values specified on the
     * last successful call to
     * {@link #setDefaultDataWriterQos(DataWriterQos)}, or else, if the call
     * was never made, the default values identified by the DDS
     * specification.
     * 
     * @see     #setDefaultDataWriterQos(DataWriterQos)
     */
    public DataWriterQos getDefaultDataWriterQos();

    /**
     * This operation sets a default value of the DataWriter QoS policies,
     * which will be used for newly created {@link DataWriter} entities in
     * the case where the QoS policies are defaulted in the
     * {@link #createDataWriter(Topic)} operation.
     * 
     * @throws  InconsistentPolicyException     if the resulting policies are
     *          not self consistent; if they are not, the operation will have
     *          no effect.
     *
     * @see     #getDefaultDataWriterQos()
     */
    public void setDefaultDataWriterQos(DataWriterQos qos);

    /**
     * @see     #setDefaultDataWriterQos(DataWriterQos)
     */
    public void setDefaultDataWriterQos(
            String qosLibraryName,
            String qosProfileName);

    /**
     * This operation copies the policies in the {@link Topic} QoS to the
     * corresponding policies in the {@link DataWriter} QoS (replacing values
     * in the DataWriter QoS, if present).
     * 
     * This is a "convenience" operation most useful in combination with the
     * operations {@link #getDefaultDataWriterQos()} and
     * {@link Topic#getQos()}. The operation can be used to merge the
     * DataWriter default QoS policies with the corresponding ones on the
     * Topic. The resulting QoS can then be used to create a new DataWriter
     * or set its QoS.
     * 
     * This operation does not check the resulting DatWriter QoS for
     * consistency. This is because the 'merged' QoS may not be the final
     * one, as the application can still modify some policies prior to
     * applying the policies to the DataWriter.
     * 
     * @param dst   the QoS whose policies are to be overwritten.
     * @param src   the QoS from which the policies are to be taken.
     */
    public void copyFromTopicQos(DataWriterQos dst, TopicQos src);
}
