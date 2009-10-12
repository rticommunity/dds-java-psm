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

package org.omg.dds.infrastructure;

import org.omg.dds.spi.ServiceImpl;
import org.omg.dds.spi.SimpleDataFactory;
import org.omg.dds.util.ValueType;


public abstract class InstanceHandle implements ValueType<InstanceHandle> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -250106199311205036L;

    public static final InstanceHandle NIL = create();



    // -----------------------------------------------------------------------
    // Object Lifecycle
    // -----------------------------------------------------------------------

    /**
     * Construct a new nil handle.
     */
    public static InstanceHandle create() {
        SimpleDataFactory factory =
            ServiceImpl.getInstance().getSimpleDataFactory();
        InstanceHandle handle = factory.createInstanceHandle();
        assert handle != null;
        return handle;
    }


    protected InstanceHandle() {
        // empty
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    public abstract boolean isNil();

    @Override
    public abstract InstanceHandle clone();

}
