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
 * ARE DISCLAIMED. IN NO EVENT SHALL A COPYRIGHT HOLDER OR CONTRIBUTOR BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.omg.dds.type.dynamic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.List;

import org.omg.dds.core.DDSObject;


public interface DynamicData extends DDSObject, Cloneable
{
    public DynamicType getType();

    /**
     * Modifying an element of the given list modifies the descriptor of this
     * DynamicData object, not a copy. Adding to or removing from the list
     * is not allowed.
     */
    public List<MemberDescriptor> getDescriptors();

    int getMemberIdByName(String name);
    int getMemberIdAtIndex(int index);


    public void clearAllValues();
    public void clearNonkeyValues();
    public void clearValue(int id);


    public DynamicData loanValue(int id);
    public void returnLoanedValue(DynamicData value);


    public int getInt32Value(int id);
    public void setInt32Value(int id, int value);

    public short getInt16Value(int id);
    public void setInt16Value(int id, short value);

    public long getInt64Value(int id);
    public void setInt64Value(int id, long value);

    public BigInteger getBigIntegerValue(int id);
    public void setBigIntegerValue(int id, BigInteger value);

    public float getFloat32Value(int id);
    public void setFloat32Value(int id, float value);

    public double getFloat64Value(int id);
    public void setFloat64Value(int id, double value);

    public BigDecimal getBigDecimalValue(int id);
    public void setBigDecimalValue(int id, BigDecimal value);

    public char getCharValue(int id);
    public void setCharValue(int id, char value);

    public byte getByteValue(int id);
    public void setByteValue(int id, byte value);

    public boolean getBooleanValue(int id);
    public void setBooleanValue(int id, boolean value);

    public String getStringValue(int id);
    public void setStringValue(int id, CharSequence value);

    public DynamicData getComplexValue(DynamicData value, int id);
    public void setComplexValue(int id, DynamicData value);


    public int getInt32Values(
            int[] value, int offset, int length, int id);
    public IntBuffer getInt32Values(IntBuffer value, int id);
    public void setInt32Values(
            int id, int[] value, int offset, int length);
    public void setInt32Values(int id, int... value);
    public void setInt32Values(int id, IntBuffer value);

    public int getInt16Values(
            short[] value, int offset, int length, int id);
    public ShortBuffer getInt16Values(ShortBuffer value, int id);
    public void setInt16Values(
            int id, short[] value, int offset, int length);
    public void setInt16Values(int id, short... value);
    public void setInt16Values(int id, ShortBuffer value);

    public int getInt64Values(
            long[] value, int offset, int length, int id);
    public LongBuffer getInt64Values(LongBuffer value, int id);
    public void setInt64Values(
            int id, long[] value, int offset, int length);
    public void setInt64Values(int id, long... value);
    public void setInt64Values(int id, LongBuffer value);

    public int getBigIntegerValues(
            BigInteger[] value, int offset, int length, int id);
    public List<BigInteger> getBigIntegerValues(
            List<BigInteger> value, int id);
    public void setBigIntegerValues(
            int id, BigInteger[] value, int offset, int length);
    public void setBigIntegerValues(int id, List<BigInteger> value);

    public int getFloat32Values(
            float[] value, int offset, int length, int id);
    public FloatBuffer getFloat32Values(FloatBuffer value, int id);
    public void setFloat32Values(
            int id, float[] value, int offset, int length);
    public void setFloat32Values(int id, FloatBuffer value);

    public int getFloat64Values(
            double[] value, int offset, int length, int id);
    public DoubleBuffer getFloat64Values(DoubleBuffer value, int id);
    public void setFloat64Values(
            int id, double[] value, int offset, int length);
    public void setFloat64Values(int id, DoubleBuffer value);

    public int getBigDecimalValues(
            BigDecimal[] value, int offset, int length, int id);
    public List<BigDecimal> getBigDecimalValues(
            List<BigDecimal> value, int id);
    public void setBigDecimalValues(
            int id, BigDecimal[] value, int offset, int length);
    public void setBigDecimalValues(int id, List<BigDecimal> value);

    public int getCharValues(
            char[] value, int offset, int length, int id);
    public StringBuilder getCharValues(StringBuilder value, int id);
    public CharBuffer getCharValues(CharBuffer value, int id);
    public void setCharValues(
            int id, char[] value, int offset, int length);
    public void setCharValues(int id, CharSequence value);

    public int getByteValues(
            byte[] value, int offset, int length, int id);
    public ByteBuffer getByteValues(ByteBuffer value, int id);
    public void setByteValues(
            int id, byte[] value, int offset, int length);
    public void setByteValues(int id, ByteBuffer value);

    public int getBooleanValues(
            boolean[] value, int offset, int length, int id);
    public void getBooleanValues(List<Boolean> value, int id);
    public void setBooleanValues(
            int id, boolean[] value, int offset, int length);
    public void setBooleanValues(int id, List<Boolean> value);

    public int getStringValues(
            String[] value, int offset, int length, int id);
    public void getStringValues(List<String> value, int id);
    public void setStringValues(
            int id, String[] value, int offset, int length);
    public void setStringValues(int id, List<String> value);


    public DynamicData clone();
}
