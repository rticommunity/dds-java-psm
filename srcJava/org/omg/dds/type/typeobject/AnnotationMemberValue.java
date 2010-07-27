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

import org.omg.dds.core.ModifiableValueType;


/* Literal value of an annotation member: either the default value in its
 * definition or the value applied in its usage.
 */
//@Extensibility(EXTENSIBLE_EXTENSIBILITY)
//@Nested
public interface AnnotationMemberValue
extends ModifiableValueType<AnnotationMemberValue, AnnotationMemberValue>
{
    public TypeKind discriminator();


    public boolean booleanValue();

    public void booleanValue(boolean value);


    public byte byteValue();

    public void byteValue(byte value);


    public short int16Value();

    public void int16Value(short value);


    public short uint16Value();

    public void uint16Value(short value);


    public int int32Value();

    public void int32Value(int value);


    public int uint32Value();

    public void uint32Value(int value);


    public long int64Value();

    public abstract void int64Value(long value);


    public long uint64Value();

    public void uint64Value(long value);


    public float float32Value();

    public void float32Value(float value);


    public double float64Value();

    public void float64Value(double value);

    /* FIXME:
    case FLOAT128_TYPE:
        long double float128Value;
     */

    public char characterValue();

    public void characterValue(char value);


    public char wide_characterValue();

    public void wide_characterValue(char value);


    public int enumerationValue();

    public void enumerationValue(int value);


    public String stringValue();

    public void stringValue(String value);
}
