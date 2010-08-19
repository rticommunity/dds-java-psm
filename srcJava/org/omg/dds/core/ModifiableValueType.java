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


/**
 * A value type that supports modification.
 * 
 * @param <UNMOD_SELF>  The unmodifiable supertype of this interface.
 * @param <MOD_SELF>    This interface.
 */
public interface ModifiableValueType
<UNMOD_SELF extends ValueType<UNMOD_SELF, MOD_SELF>,
 MOD_SELF extends UNMOD_SELF>
extends ValueType<UNMOD_SELF, MOD_SELF> {
    /**
     * Overwrite this object's state with the contents of the given object.
     * 
     * @return  this
     */
    public MOD_SELF copyFrom(UNMOD_SELF other);

    /**
     * If this value type has an unmodifiable counterpart class, return a new
     * object of that class containing a copy of the state of this object. If
     * not return null.
     * 
     * Calling this method is optional in general; because modifiable
     * interfaces extend "unmodifiable" ones, the former can typically be
     * used wherever the latter is required.
     * 
     * @return  a new unmodifiable copy of this object or null.
     */
    public UNMOD_SELF finishModification();


    // --- From ValueType: ---------------------------------------------------

    public MOD_SELF clone();
}
