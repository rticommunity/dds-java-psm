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

package org.omg.dds.type;


public enum TypeKind
{
    // -----------------------------------------------------------------------
    // Enumerated Constants
    // -----------------------------------------------------------------------

    /** sentinel indicating "null" value */
    NO_TYPE         (Values.NO_TYPE_VALUE),
    BOOLEAN_TYPE    (Values.BOOLEAN_TYPE_VALUE),
    BYTE_TYPE       (Values.BYTE_TYPE_VALUE),
    INT_16_TYPE     (Values.INT_16_TYPE_VALUE),
    UINT_16_TYPE    (Values.UINT_16_TYPE_VALUE),
    INT_32_TYPE     (Values.INT_32_TYPE_VALUE),
    UINT_32_TYPE    (Values.UINT_32_TYPE_VALUE),
    INT_64_TYPE     (Values.INT_64_TYPE_VALUE),
    UINT_64_TYPE    (Values.UINT_64_TYPE_VALUE),
    FLOAT_32_TYPE   (Values.FLOAT_32_TYPE_VALUE),
    FLOAT_64_TYPE   (Values.FLOAT_64_TYPE_VALUE),
    FLOAT_128_TYPE  (Values.FLOAT_128_TYPE_VALUE),
    CHAR_8_TYPE     (Values.CHAR_8_TYPE_VALUE),
    CHAR_32_TYPE    (Values.CHAR_32_TYPE_VALUE),

    ENUMERATION_TYPE(Values.ENUMERATION_TYPE_VALUE),
    BITSET_TYPE     (Values.BITSET_TYPE_VALUE),
    ALIAS_TYPE      (Values.ALIAS_TYPE_VALUE),

    ARRAY_TYPE      (Values.ARRAY_TYPE_VALUE),
    SEQUENCE_TYPE   (Values.SEQUENCE_TYPE_VALUE),
    STRING_TYPE     (Values.STRING_TYPE_VALUE),
    MAP_TYPE        (Values.MAP_TYPE_VALUE),

    UNION_TYPE      (Values.UNION_TYPE_VALUE),
    STRUCTURE_TYPE  (Values.STRUCTURE_TYPE_VALUE),
    ANNOTATION_TYPE (Values.ANNOTATION_TYPE_VALUE),
    ;



    // -----------------------------------------------------------------------
    // Compile-TIme Constants
    // -----------------------------------------------------------------------

    public static final class Values {
        /** sentinel indicating "null" value */
        public static final short NO_TYPE_VALUE          =  0;
        public static final short BOOLEAN_TYPE_VALUE     =  1;
        public static final short BYTE_TYPE_VALUE        =  2;
        public static final short INT_16_TYPE_VALUE      =  3;
        public static final short UINT_16_TYPE_VALUE     =  4;
        public static final short INT_32_TYPE_VALUE      =  5;
        public static final short UINT_32_TYPE_VALUE     =  6;
        public static final short INT_64_TYPE_VALUE      =  7;
        public static final short UINT_64_TYPE_VALUE     =  8;
        public static final short FLOAT_32_TYPE_VALUE    =  9;
        public static final short FLOAT_64_TYPE_VALUE    = 10;
        public static final short FLOAT_128_TYPE_VALUE   = 11;
        public static final short CHAR_8_TYPE_VALUE      = 12;
        public static final short CHAR_32_TYPE_VALUE     = 13;

        public static final short ENUMERATION_TYPE_VALUE = 14;
        public static final short BITSET_TYPE_VALUE      = 15;
        public static final short ALIAS_TYPE_VALUE       = 16;

        public static final short ARRAY_TYPE_VALUE       = 17;
        public static final short SEQUENCE_TYPE_VALUE    = 18;
        public static final short STRING_TYPE_VALUE      = 19;
        public static final short MAP_TYPE_VALUE         = 20;

        public static final short UNION_TYPE_VALUE       = 21;
        public static final short STRUCTURE_TYPE_VALUE   = 22;
        public static final short ANNOTATION_TYPE_VALUE  = 23;
    }


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
