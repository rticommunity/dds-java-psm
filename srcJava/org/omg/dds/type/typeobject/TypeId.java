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

package org.omg.dds.type.typeobject;

import org.omg.dds.type.TypeKind;


/**
 * Every type has an ID. Those of the primitive types are predefined.
 */
public final class TypeId {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    public static final int NO_TYPE_ID =
        TypeKind.Values.NO_TYPE_VALUE;
    public static final int BOOLEAN_TYPE_ID =
        TypeKind.Values.BOOLEAN_TYPE_VALUE;
    public static final int BYTE_TYPE_ID =
        TypeKind.Values.BYTE_TYPE_VALUE;
    public static final int INT_16_TYPE_ID =
        TypeKind.Values.INT_16_TYPE_VALUE;
    public static final int UINT_16_TYPE_ID =
        TypeKind.Values.UINT_16_TYPE_VALUE;
    public static final int INT_32_TYPE_ID =
        TypeKind.Values.INT_32_TYPE_VALUE;
    public static final int UINT_32_TYPE_ID =
        TypeKind.Values.UINT_32_TYPE_VALUE;
    public static final int INT_64_TYPE_ID =
        TypeKind.Values.INT_64_TYPE_VALUE;
    public static final int UINT_64_TYPE_ID =
        TypeKind.Values.UINT_64_TYPE_VALUE;
    public static final int FLOAT_32_TYPE_ID =
        TypeKind.Values.FLOAT_32_TYPE_VALUE;
    public static final int FLOAT_64_TYPE_ID =
        TypeKind.Values.FLOAT_64_TYPE_VALUE;
    public static final int FLOAT_128_TYPE_ID =
        TypeKind.Values.FLOAT_128_TYPE_VALUE;
    public static final int CHAR_8_TYPE_ID =
        TypeKind.Values.CHAR_8_TYPE_VALUE;
    public static final int CHAR_32_TYPE_ID =
        TypeKind.Values.CHAR_32_TYPE_VALUE;



    // -----------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------

    private TypeId() {
        // empty
    }
}
