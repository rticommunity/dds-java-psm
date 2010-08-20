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

package org.omg.dds.infrastructure.qos;

import org.omg.dds.spi.QosPolicyFactory;
import org.omg.dds.spi.ServiceImpl;
import org.omg.dds.util.ExtensibleEnum;


/**
 * DDS/OwnershipQosPolicy.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from dds_rtf2_dcps.idl
 * Wednesday, September 16, 2009 9:06:02 AM CDT
 */
public interface OwnershipQosPolicy extends QosPolicy<OwnershipQosPolicy> {
    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * @param kind the kind to set
     */
    public void setKind(Kind kind);

    /**
     * @return the kind
     */
    public Kind getKind();



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    public static class Kind extends ExtensibleEnum<Kind> {
        // --- Constants: ----------------------------------------------------
        private static final long serialVersionUID = 706074579513740206L;

        // --- Kinds: --------------------------------------------------------
        public static final Kind SHARED = create("SHARED", 0);

        public static final Kind EXCLUSIVE = create("EXCLUSIVE", 1);

        // --- Object Lifecycle: ---------------------------------------------
        protected Kind(String name, int ordinal) {
            super(name, ordinal);
        }
        
        private static Kind create(String name, int ordinal) {
            QosPolicyFactory factory =
                ServiceImpl.getInstance().getQosPolicyFactory();
            Kind kind = factory.createOwnershipQosPolicyKind(name, ordinal);
            assert kind != null;
            return kind;
        }
    }

}
