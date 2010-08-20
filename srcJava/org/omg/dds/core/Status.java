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

package org.omg.dds.core;

import java.util.EventObject;


/**
 * An interface implemented by all status types.
 */
public abstract class Status<SELF extends Status<SELF, SOURCE>,
                             SOURCE extends Entity<SOURCE, ?, ?>>
extends EventObject
implements ModifiableValue<SELF, SELF> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -1690742728528299945L;



    // -----------------------------------------------------------------------
    // Object Life Cycle
    // -----------------------------------------------------------------------

    protected Status(SOURCE source) {
        super(source);
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- API: --------------------------------------------------------------

    public abstract Kind getKind();


    @Override
    public abstract SOURCE getSource();


    @Override
    public abstract SELF clone();


    // --- SPI: --------------------------------------------------------------

    protected void setSource(SOURCE source) {
        super.source = source;
    }



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------
    
    public static enum Kind {
        // --- Kinds: --------------------------------------------------------
        INCONSISTENT_TOPIC          (0x0001 << 0),
        OFFERED_DEADLINE_MISSED     (0x0001 << 1),
        REQUESTED_DEADLINE_MISSED   (0x0001 << 2),
        OFFERED_INCOMPATIBLE_QOS    (0x0001 << 5),
        REQUESTED_INCOMPATIBLE_QOS  (0x0001 << 6),
        SAMPLE_LOST                 (0x0001 << 7),
        SAMPLE_REJECTED             (0x0001 << 8),
        DATA_ON_READERS             (0x0001 << 9),
        DATA_AVAILABLE              (0x0001 << 10),
        LIVELINESS_LOST             (0x0001 << 11),
        LIVELINESS_CHANGED          (0x0001 << 12),
        PUBLICATION_MATCHED         (0x0001 << 13),
        SUBSCRIPTION_MATCHED        (0x0001 << 14);


        // --- Constants: ----------------------------------------------------
        public final long value;


        // --- Object Life Cycle: --------------------------------------------
        private Kind(long value) {
            this.value = value;
        }
    }

}
