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

package org.omg.dds.type.typeobject;

import org.omg.dds.type.annotation.Extensibility;
import org.omg.dds.type.annotation.ID;
import org.omg.dds.type.annotation.Nested;


@Extensibility(Extensibility.Kind.MUTABLE_EXTENSIBILITY)
@Nested
public interface AliasType extends Type
{
    // -----------------------------------------------------------------------
    // Properties
    // -----------------------------------------------------------------------

    @ID(MemberId.BASE_TYPE_ALIASTYPE_MEMBER_ID)
    public int getBaseType();

    public void setBaseType(int newBaseTypeId);



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    public static final class MemberId
    {
        // --- Constants: ----------------------------------------------------
        public static final int BASE_TYPE_ALIASTYPE_MEMBER_ID = 100;

        // --- Constructor: --------------------------------------------------
        private MemberId() {
            // empty
        }
    }
}