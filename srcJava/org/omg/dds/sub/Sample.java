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

import java.util.ListIterator;

import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.modifiable.ModifiableInstanceHandle;
import org.omg.dds.core.modifiable.ModifiableTime;
import org.omg.dds.core.modifiable.ModifiableValue;
import org.omg.dds.pub.DataWriter;


/**
 * A Sample represents an atom of data information (i.e., one value for one
 * instance) as returned by a {@link DataReader}'s read or take operations.
 * It consists of two parts: the Data ({@link #getData()}) and the "Sample
 * Info" (the remainder of the methods defined by this interface).
 * 
 * <b>Interpretation of the Sample Info</b>
 * 
 * In addition to the data value itself, the Sample contains information
 * pertaining to it:
 * 
 * <ul>
 *      <li>The sampleState ({@link #getSampleState()}) of the Data value
 *          (i.e., if the sample has already been {@link SampleState#READ} or
 *          {@link SampleState#NOT_READ} by that same {@link DataReader}).
 *          </li>
 *      <li>The viewState ({@link #getViewState()}) of the related instance
 *          (i.e., if the current generation of the instance is
 *          {@link ViewState#NEW} or {@link ViewState#NOT_NEW} for that
 *          DataReader).</li>
 *      <li>The instanceState ({@link #getInstanceState()}) of the related
 *          instance (i.e., if the instance is {@link InstanceState#ALIVE},
 *          {@link InstanceState#NOT_ALIVE_DISPOSED}, or
 *          {@link InstanceState#NOT_ALIVE_NO_WRITERS}).</li>
 *      <li>The "valid data" flag, corresponding to whether {@link #getData()}
 *          return a non-null value. Some samples do not contain data, instead
 *          indicating only a change on the instanceState of the corresponding
 *          instance.</li>
 *      <li>The values of disposedGenerationCount
 *          ({@link #getDisposedGenerationCount()}) and
 *          noWritersGenerationCount ({@link #getNoWritersGenerationCount()})
 *          for the related instance at the time the sample was received.
 *          These counters indicate the number of times the instance had
 *          become ALIVE (with instanceState = {@link InstanceState#ALIVE})
 *          at the time the sample was received.</li>
 *      <li>The sampleRank ({@link #getSampleRank()}) and generationRank
 *          ({@link #getGenerationRank()}) of the sample within the returned
 *          sequence. These ranks provide a preview of the samples that
 *          follow within the sequence returned by the
 *          {@link DataReader#read()} or {@link DataReader#take()}
 *          operations.</li>
 *      <li>The absoluteGenerationRank ({@link #getAbsoluteGenerationRank()})
 *          of the sample within the DataReader. This rank provides a preview
 *          of what is available within the DataReader.</li>
 *      <li>The sourceTimestamp ({@link #getSourceTimestamp()}) of the sample.
 *          This is the time stamp provided by the {@link DataWriter} at the
 *          time the sample was produced.</li>
 *      <li>The instanceHandle ({@link #getInstanceHandle()}) that identifies
 *          locally the corresponding instance.</li>
 *      <li>The publicationHandle ({@link #getPublicationHandle()}) that
 *          identifies locally the {@link DataWriter} that modified the
 *          instance. The publicationHandle is the same {@link InstanceHandle}
 *          that is returned by the operation
 *          {@link DataReader#getMatchedPublications(java.util.Collection)}
 *          on the DataReader and can also be used as a parameter to the
 *          operation
 *          {@link DataReader#getMatchedPublicationData(org.omg.dds.topic.PublicationBuiltinTopicData, InstanceHandle)}.</li>
 * </ul>
 * 
 * @param <TYPE>    The concrete type of the data encapsulated by this Sample.
 */
public interface Sample<TYPE>
extends ModifiableValue<Sample<TYPE>, Sample<TYPE>> {
    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- Sample data: ------------------------------------------------------
    /**
     * @return  the data associated with this sample. This method will return
     *          null if this sample contains no valid data.
     */
    public TYPE getData();


    // --- Sample meta-data: -------------------------------------------------
    /**
     * @return the sampleState
     */
    public SampleState getSampleState();

    /**
     * @return the viewState
     */
    public ViewState getViewState();

    /**
     * @return the instanceState
     */
    public InstanceState getInstanceState();

    public ModifiableTime getSourceTimestamp();

    public ModifiableInstanceHandle getInstanceHandle();

    public ModifiableInstanceHandle getPublicationHandle();

    /**
     * @return the disposedGenerationCount
     */
    public int getDisposedGenerationCount();

    /**
     * @return the noWritersGenerationCount
     */
    public int getNoWritersGenerationCount();

    /**
     * @return the sampleRank
     */
    public int getSampleRank();

    /**
     * @return the generationRank
     */
    public int getGenerationRank();

    /**
     * @return the absoluteGenerationRank
     */
    public int getAbsoluteGenerationRank();



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    public static interface Iterator<IT_DATA>
    extends ListIterator<Sample<IT_DATA>> {
        /**
         * The samples provided by this iterator have been loaned from a
         * pool maintained by the Service; return that loan now.
         */
        public void returnLoan();

        // --- From ListIterator: --------------------------------------------
        /**
         * @exception UnsupportedOperationException always.
         */
        public void remove();

        /**
         * @exception UnsupportedOperationException always.
         */
        public void set(Sample<IT_DATA> o);

        /**
         * @exception UnsupportedOperationException always.
         */
        public void add(Sample<IT_DATA> o);
    }

}
