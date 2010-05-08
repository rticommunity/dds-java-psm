/* Copyright (c) 2009, Real-Time Innovations, Inc.
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

import java.util.ListIterator;

import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.Time;
import org.omg.dds.core.ValueType;


public interface Sample<TYPE> extends ValueType<Sample<TYPE>> {
    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- Sample data: ------------------------------------------------------
    /**
     * @return  the data associated with this sample.
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

    public Time getSourceTimestamp();

    public InstanceHandle getInstanceHandle();

    public InstanceHandle getPublicationHandle();

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

    /**
     * @return the dataValid
     */
    public boolean isDataValid();



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    public static interface Iterator<IT_DATA>
    extends ListIterator<Sample<IT_DATA>> {
        /**
         * The samples provided by this iterator have been loaned from a
         * middleware pool; return that loan now.
         * 
         * If this method is never called, the loan will be returned when this
         * iterator is finalized. However, finalization could take some time,
         * or might never happen, so applications are strongly advised not to
         * rely on it: {@link DataReader} resources could be exhausted.
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
