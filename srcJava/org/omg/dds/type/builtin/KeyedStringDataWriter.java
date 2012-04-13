/* Copyright 2010, Object Management Group, Inc.
 * Copyright 2010, PrismTech, Inc.
 * Copyright 2010, Real-Time Innovations, Inc.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omg.dds.type.builtin;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.ModifiableInstanceHandle;
import org.omg.dds.core.Time;
import org.omg.dds.pub.DataWriter;


public interface KeyedStringDataWriter extends DataWriter<KeyedString> 
{
    /**
     * @see     DataWriter#registerInstance(Object)
     */
    public InstanceHandle registerInstance(String key)
    throws TimeoutException;

    /**
     * @see     DataWriter#registerInstance(Object, Time)
     */
    public InstanceHandle registerInstance(String key, Time sourceTimestamp)
    throws TimeoutException;

    /**
     * @see     DataWriter#registerInstance(Object, long, TimeUnit)
     */
    public InstanceHandle registerInstance(
            String key, long sourceTimestamp, TimeUnit unit)
    throws TimeoutException;

    /**
     * @see     DataWriter#unregisterInstance(InstanceHandle, Object)
     */
    public void unregisterInstance(String key) throws TimeoutException;

    /**
     * @see     DataWriter#unregisterInstance(InstanceHandle, Object, Time)
     */
    public void unregisterInstance(String key, Time sourceTimestamp)
    throws TimeoutException;

    /**
     * @see     DataWriter#unregisterInstance(InstanceHandle, Object, long, TimeUnit)
     */
    public void unregisterInstance(
            String key, long sourceTimestamp, TimeUnit unit)
    throws TimeoutException;

    /**
     * @see     DataWriter#write(Object)
     */
    public void write(String key, String str) throws TimeoutException;

    /**
     * @see     DataWriter#write(Object, Time)
     */
    public void write(
            String key,
            String str,
            Time sourceTimestamp)
    throws TimeoutException;

    /**
     * @see     DataWriter#write(Object, long, TimeUnit)
     */
    public void write(
            String key,
            String str,
            long sourceTimestamp,
            TimeUnit unit)
    throws TimeoutException;

    /**
     * @see     DataWriter#dispose(InstanceHandle, Object)
     */
    public void dispose(String key) throws TimeoutException;

    /**
     * @see     DataWriter#dispose(InstanceHandle, Object, Time)
     */
    public void dispose(String key, Time sourceTimestamp)
    throws TimeoutException;

    /**
     * @see     DataWriter#dispose(InstanceHandle, Object, long, TimeUnit)
     */
    public void dispose(String key, long sourceTimestamp, TimeUnit unit)
    throws TimeoutException;

    /**
     * @see     DataWriter#getKeyValue(Object, InstanceHandle)
     */
    public StringBuilder getKeyValue(StringBuilder key, InstanceHandle handle);

    /**
     * @see     #lookupInstance(String)
     * @see     DataWriter#lookupInstance(ModifiableInstanceHandle, Object)
     */
    public ModifiableInstanceHandle lookupInstance(
            ModifiableInstanceHandle handle, String key);

    /**
     * @see     #lookupInstance(ModifiableInstanceHandle, String)
     * @see     DataWriter#lookupInstance(Object)
     */
    public InstanceHandle lookupInstance(String key);
}
