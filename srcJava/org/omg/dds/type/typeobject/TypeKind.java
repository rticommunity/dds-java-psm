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


public enum TypeKind {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    NO_TYPE         ((short)  0), // sentinel indicating "null" value
    BOOLEAN_TYPE    ((short)  1),
    BYTE_TYPE       ((short)  2),
    INT_16_TYPE     ((short)  3),
    UINT_16_TYPE    ((short)  4),
    INT_32_TYPE     ((short)  5),
    UINT_32_TYPE    ((short)  6),
    INT_64_TYPE     ((short)  7),
    UINT_64_TYPE    ((short)  8),
    FLOAT_32_TYPE   ((short)  9),
    FLOAT_64_TYPE   ((short) 10),
    FLOAT_128_TYPE  ((short) 11),
    CHAR_8_TYPE     ((short) 12),
    CHAR_32_TYPE    ((short) 13),

    ENUMERATION_TYPE((short) 14),
    BITSET_TYPE     ((short) 15),
    ALIAS_TYPE      ((short) 16),

    ARRAY_TYPE      ((short) 17),
    SEQUENCE_TYPE   ((short) 18),
    STRING_TYPE     ((short) 19),
    MAP_TYPE        ((short) 20),

    UNION_TYPE      ((short) 21),
    STRUCTURE_TYPE  ((short) 22),
    ANNOTATION_TYPE ((short) 23),
    ;



    // -----------------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------------

    public final short value;



    // -----------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------

    private TypeKind(short value) {
        this.value = value;
    }
}

