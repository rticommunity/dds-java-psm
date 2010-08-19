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

package org.omg.dds.type.builtin;

import java.util.concurrent.TimeoutException;

import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.ModifiableInstanceHandle;
import org.omg.dds.core.Time;
import org.omg.dds.pub.DataWriter;


public interface KeyedStringDataWriter extends DataWriter<KeyedString> 
{
    public InstanceHandle registerInstance(String key)
    throws TimeoutException;

    public InstanceHandle registerInstance(String key, Time sourceTimestamp)
    throws TimeoutException;

    public void unregisterInstance(String key) throws TimeoutException;

    public void unregisterInstance(String key, Time sourceTimestamp)
    throws TimeoutException;

    public void write(String key, String str) throws TimeoutException;

    public void write(String key, String str, InstanceHandle handle)
    throws TimeoutException;

    public void write(
            String key,
            String str,
            InstanceHandle handle,
            Time sourceTimestamp)
    throws TimeoutException;

    public void dispose(String key) throws TimeoutException;

    public void dispose(String key, Time sourceTimestamp)
    throws TimeoutException;

    public StringBuilder getKeyValue(StringBuilder key, InstanceHandle handle);

    public ModifiableInstanceHandle lookupInstance(
            ModifiableInstanceHandle handle, String key);
}
