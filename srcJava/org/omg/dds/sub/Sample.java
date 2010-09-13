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
 * ARE DISCLAIMED. IN NO EVENT SHALL A COPYRIGHT HOLDER OR CONTRIBUTOR BE
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

import org.omg.dds.core.ModifiableInstanceHandle;
import org.omg.dds.core.ModifiableTime;
import org.omg.dds.core.ModifiableValue;


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
