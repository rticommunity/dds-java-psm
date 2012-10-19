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

package org.omg.dds.type;

import org.omg.dds.core.DDSObject;


/**
 * TypeSupport is an abstract interface that has to be specialized for each
 * concrete type that will be used by the application to publish and/or
 * subscribe to data over DDS.
 * 
 * @param <TYPE>    The type to be supported for publication and/or
 *                  subscription.
 */
public abstract class TypeSupport<TYPE> implements DDSObject
{
    // -----------------------------------------------------------------------
    // Instance Methods
    // -----------------------------------------------------------------------

    /**
     * @return  a new object of the type supported by this TypeSupport.
     */
    public abstract TYPE newData();

    /**
     * @return  the class of the type supported by this TypeSupport.
     */
    public abstract Class<TYPE> getType();

    /**
     * @return  the registered name for the data type represented by the
     *          TypeSupport.
     */
    public abstract String getTypeName();
}
