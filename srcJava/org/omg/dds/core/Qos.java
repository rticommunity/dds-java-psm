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

import java.util.Map;

import org.omg.dds.core.policy.QosPolicy;


/**
 * A base interface for all entity QoS types.
 */
public interface Qos<UNMOD_SELF extends Qos<UNMOD_SELF, MOD_SELF>,
                     MOD_SELF extends UNMOD_SELF>
extends ValueType<UNMOD_SELF, MOD_SELF>, Map<QosPolicy.Id, QosPolicy<?, ?>> {
    /**
     * @return  a reference to the corresponding policy in this
     *          <code>Qos</code>. The returned object is not a copy; changes
     *          to the returned object will be reflected in subsequent
     *          accesses.
     *
     * @see Map#get(Object)
     */
    public <POLICY extends QosPolicy<POLICY, ?>> POLICY get(QosPolicy.Id id);

    /**
     * @throws  UnsupportedOperationException   if this <code>Qos</code> is
     *          not a <code>ModifiableQos</code>.
     */
    public QosPolicy<?, ?> put(QosPolicy.Id key, QosPolicy<?, ?> value);

    /**
     * @throws  UnsupportedOperationException   always: the <tt>remove</tt>
     *          operation is not supported by this map.
     */
    public QosPolicy<?, ?> remove(Object key);

    /**
     * @throws  UnsupportedOperationException   always: the <tt>clear</tt>
     *          operation is not supported by this map.
     */
    public void clear();

}
