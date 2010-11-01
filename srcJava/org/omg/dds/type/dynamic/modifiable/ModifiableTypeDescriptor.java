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

package org.omg.dds.type.dynamic.modifiable;

import org.omg.dds.core.modifiable.ModifiableValue;
import org.omg.dds.type.TypeKind;
import org.omg.dds.type.dynamic.DynamicType;
import org.omg.dds.type.dynamic.TypeDescriptor;


public interface ModifiableTypeDescriptor
extends TypeDescriptor,
        ModifiableValue<TypeDescriptor, ModifiableTypeDescriptor>
{
    /**
     * @param kind the kind to set
     */
    public void setKind(TypeKind kind);

    /**
     * @param name the name to set
     */
    public void setName(String name);

    /**
     * @param baseType the baseType to set
     */
    public void setBaseType(DynamicType baseType);

    /**
     * @param discriminatorType the discriminatorType to set
     */
    public void setDiscriminatorType(DynamicType discriminatorType);

    /**
     * @param bound the bound to set
     */
    public void setBound(int... bound);

    /**
     * @param elementType the elementType to set
     */
    public void setElementType(DynamicType elementType);

    /**
     * @param keyElementType the keyElementType to set
     */
    public void setKeyElementType(DynamicType keyElementType);
}
