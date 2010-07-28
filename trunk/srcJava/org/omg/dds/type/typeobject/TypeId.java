/* Copyright (c) 2009-2010, Real-Time Innovations, Inc.
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

package org.omg.dds.type.typeobject;


/**
 * Every type has an ID. Those of the primitive types are predefined.
 */
public final class TypeId {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    public static final int NO_TYPE_ID         = TypeKind.NO_TYPE.value;
    public static final int BOOLEAN_TYPE_ID    = TypeKind.BOOLEAN_TYPE.value;
    public static final int BYTE_TYPE_ID       = TypeKind.BYTE_TYPE.value;
    public static final int INT_16_TYPE_ID     = TypeKind.INT_16_TYPE.value;
    public static final int UINT_16_TYPE_ID    = TypeKind.UINT_16_TYPE.value;
    public static final int INT_32_TYPE_ID     = TypeKind.INT_32_TYPE.value;
    public static final int UINT_32_TYPE_ID    = TypeKind.UINT_32_TYPE.value;
    public static final int INT_64_TYPE_ID     = TypeKind.INT_64_TYPE.value;
    public static final int UINT_64_TYPE_ID    = TypeKind.UINT_64_TYPE.value;
    public static final int FLOAT_32_TYPE_ID   = TypeKind.FLOAT_32_TYPE.value;
    public static final int FLOAT_64_TYPE_ID   = TypeKind.FLOAT_64_TYPE.value;
    public static final int FLOAT_128_TYPE_ID  = TypeKind.FLOAT_128_TYPE.value;
    public static final int CHAR_8_TYPE_ID     = TypeKind.CHAR_8_TYPE.value;
    public static final int CHAR_32_TYPE_ID    = TypeKind.CHAR_32_TYPE.value;



    // -----------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------

    private TypeId() {
        // empty
    }
}