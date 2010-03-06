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

package org.omg.dds.core.qos;

import java.util.Map;

import org.omg.dds.core.Entity;
import org.omg.dds.core.ValueType;


/**
 * An abstract base interface for all entity QoS types.
 */
public interface Qos<SELF extends Qos<SELF>>
extends ValueType<SELF>, Map<QosPolicy.Id, QosPolicy<?>> {
    /**
     * @return  a reference to the corresponding policy in this
     *          <code>Qos</code>. The returned object is not a copy; changes
     *          to the returned object will be reflected in subsequent
     *          accesses.
     *
     * @see Map#get(Object)
     */
    public <POLICY extends QosPolicy<POLICY>> POLICY get(QosPolicy.Id id);

    /**
     * Overwrite the value of the indicated policy with the given new value.
     * Subsequent calls to {@link #get(Object)} may return the given object
     * or a copy of it.
     * 
     * @return  the previous value of the indicated policy if that policy
     *          applies to this <code>Qos</code>'s {@link Entity} or
     *          <code>null</code> otherwise. If the returned object is not
     *          <code>null</code>, changes to it will <em>not</em> be
     *          reflected by subsequent calls to {@link #get(Object)}.
     * @throws  NullPointerException    if the given key or value is
     *                                  <code>null</code>.
     */
    public <POLICY extends QosPolicy<POLICY>> POLICY put(
            QosPolicy.Id key, POLICY value);

    /**
     * @throws  UnsupportedOperationException   always: the <tt>remove</tt>
     *          operation is not supported by this map.
     */
    public QosPolicy<?> remove(Object key);

    /**
     * @throws  UnsupportedOperationException   always: the <tt>clear</tt>
     *          operation is not supported by this map.
     */
    public void clear();

}
