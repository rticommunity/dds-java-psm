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

import org.omg.dds.core.policy.QosPolicy;


public interface ModifiableEntityQos<UNMOD_SELF extends EntityQos<UNMOD_SELF,
                                                                  MOD_SELF>,
                                     MOD_SELF extends UNMOD_SELF>
extends EntityQos<UNMOD_SELF, MOD_SELF>, ModifiableValue<UNMOD_SELF, MOD_SELF>
{
    /**
     * Overwrite the value of the indicated policy with the given new value.
     * Subsequent calls to {@link #get(Object)} may return the given object
     * or a copy of it.
     * 
     * @return  the previous value of the indicated policy if that policy
     *          applies to this <code>EntityQos</code>'s {@link Entity} or
     *          <code>null</code> otherwise. If the returned object is not
     *          <code>null</code>, changes to it will <em>not</em> be
     *          reflected by subsequent calls to {@link #get(Object)}.
     * @throws  NullPointerException    if the given key or value is
     *                                  <code>null</code>.
     */
    public <POLICY extends QosPolicy<POLICY, ?>> POLICY put(
            QosPolicy.Id key, POLICY value);
}
