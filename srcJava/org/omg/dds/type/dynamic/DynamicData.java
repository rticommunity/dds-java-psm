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

package org.omg.dds.type.dynamic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.List;

import org.omg.dds.core.DdsObject;


public interface DynamicData extends DdsObject, Cloneable
{
    public DynamicType getType();

    public List<MemberDescriptor> getDescriptors();
    public void setDescriptor(int idx, MemberDescriptor value);

    public void clearAllValues();
    public void clearNonkeyValues();
    public void clearValue(String name);
    public void clearValueById(int id);
    public void clearValueAtIndex(int index);

    public DynamicData loanValue(String name);
    public DynamicData loanValueById(int id);
    public DynamicData loanValueAtIndex(int index);
    public void returnLoanedValue(DynamicData value);

    public int getInt32Value(String name);
    public void setInt32Value(String name, int value);

    public long getUint32Value(String name);
    public int getUint32ValueOverflow(String name);
    public void setUint32Value(String name, long value);
    public void setUint32ValueOverflow(String name, int value);

    public short getInt16Value(String name);
    public void setInt16Value(String name, short value);

    public int getUint16Value(String name);
    public short getUint16ValueOverflow(String name);
    public void setUint16Value(String name, int value);
    public void setUint16ValueOverflow(String name, short value);

    public long getInt64Value(String name);
    public void setInt64Value(String name, long value);

    public BigInteger getUint64Value(String name);
    public long getUint64ValueOverflow(String name);
    public void setUint64Value(String name, BigInteger value);
    public void setUint64ValueOverflow(String name, long value);

    public float getFloat32Value(String name);
    public void setFloat32Value(String name, float value);

    public double getFloat64Value(String name);
    public void setFloat64Value(String name, double value);

    public BigDecimal getFloat128Value(String name);
    public double getFloat128ValueOverflow(String name);
    public void setFloat128Value(String name, BigDecimal value);
    public void setFloat128ValueOverflow(String name, double value);

    public char getChar8Value(String name);
    public void setChar8Value(String name, char value);

    public int getChar32Value(String name);
    public void setChar32Value(String name, char value);
    public void setChar32Value(String name, int value);

    public byte getByteValue(String name);
    public void setByteValue(String name, byte value);

    public boolean getBooleanValue(String name);
    public void setBooleanValue(String name, boolean value);

    public String getStringValue(String name);
    public void setStringValue(String name, CharSequence value);
    public String getWstringValue(String name);
    public void setWstringValue(String name, CharSequence value);

    public DynamicData getComplexValue(DynamicData value, String name);
    public void setComplexValue(String name, DynamicData value);

    public int getInt32ArrayValue(
            int[] value, int offset, int length, String name);
    public void setInt32ArrayValue(
            String name, int[] value, int offset, int length);
    public void setInt32ArrayValue(String name, int... value);

    public int getUint32ArrayValue(
            long[] value, int offset, int length, String name);
    public int getUint32ArrayValueOverflow(
            int[] value, int offset, int length, String name);
    public void setUint32ArrayValue(
            String name, long[] value, int offset, int length);
    public void setUint32ArrayValueOverflow(
            String name, int[] value, int offset, int length);
    public void setUint32ArrayValue(String name, long... value);
    public void setUint32ArrayValueOverflow(String name, int... value);

    public int getInt16ArrayValue(
            short[] value, int offset, int length, String name);
    public void setInt16ArrayValue(
            String name, short[] value, int offset, int length);
    public void setInt16ArrayValue(String name, short... value);

    public int getUint16ArrayValue(
            int[] value, int offset, int length, String name);
    public int getUint16ArrayValueOverflow(
            short[] value, int offset, int length, String name);
    public void setUint16ArrayValue(
            String name, int[] value, int offset, int length);
    public void setUint16ArrayValueOverflow(
            String name, short[] value, int offset, int length);
    public void setUint16ArrayValue(String name, int... value);
    public void setUint16ArrayValueOverflow(String name, short... value);

    public int getInt64ArrayValue(
            long[] value, int offset, int length, String name);
    public void setInt64ArrayValue(
            String name, long[] value, int offset, int length);
    public void setInt64ArrayValue(
            String name, long... value);

    public int getUint64ArrayValue(
            BigInteger[] value, int offset, int length, String name);
    public int getUint64ArrayValueOverflow(
            long[] value, int offset, int length, String name);
    public void setUint64ArrayValue(
            String name, BigInteger[] value, int offset, int length);
    public void setUint64ArrayValueOverflow(
            String name, long[] value, int offset, int length);
    public void setUint64ArrayValueOverflow(String name, long... value);

    public int getFloat32ArrayValue(
            float[] value, int offset, int length, String name);
    public void setFloat32ArrayValue(
            String name, float[] value, int offset, int length);
    public void setFloat32ArrayValue(String name, float... value);

    public int getFloat64ArrayValue(
            double[] value, int offset, int length, String name);
    public void setFloat64ArrayValue(
            String name, double[] value, int offset, int length);
    public void setFloat64ArrayValue(String name, double... value);

    public int getFloat128ArrayValue(
            BigDecimal[] value, int offset, int length, String name);
    public int getFloat128ArrayValueOverflow(
            double[] value, int offset, int length, String name);
    public void setFloat128ArrayValue(
            String name, BigDecimal[] value, int offset, int length);
    public void setFloat128ArrayValueOverflow(
            String name, double[] value, int offset, int length);
    public void setFloat128ArrayValueOverflow(String name, double... value);

    public int getChar8ArrayValue(
            char[] value, int offset, int length, String name);
    public void setChar8ArrayValue(
            String name, char[] value, int offset, int length);
    public void setChar8ArrayValue(String name, char... value);

    public int getChar32ArrayValue(
            int[] value, int offset, int length, String name);
    public void setChar32ArrayValue(
            String name, char[] value, int offset, int length);
    public void setChar32ArrayValue(String name, char... value);
    public void setChar32ArrayValue(
            String name, int[] value, int offset, int length);
    public void setChar32ArrayValue(String name, int... value);

    public int getByteArrayValue(
            byte[] value, int offset, int length, String name);
    public void setByteArrayValue(
            String name, byte[] value, int offset, int length);

    public int getBooleanArrayValue(
            boolean[] value, int offset, int length, String name);
    public void setBooleanArrayValue(
            String name, boolean[] value, int offset, int length);
    public void setBooleanArrayValue(String name, boolean... value);

    public int getStringArrayValue(
            String[] value, int offset, int length, String name);
    public void setStringArrayValue(
            String name, String[] value, int offset, int length);
    public void setStringArrayValue(String name, String... value);

    public int getWstringArrayValue(
            String[] value, int offset, int length, String name);
    public void setWstringArrayValue(
            String name, String[] value, int offset, int length);
    public void setWstringArrayValue(String name, String... value);

    public IntBuffer getInt32SeqValue(IntBuffer value, String name);
    public void setInt32SeqValue(String name, IntBuffer value);

    public LongBuffer getUint32SeqValue(LongBuffer value, String name);
    public IntBuffer getUint32SeqValueOverflow(
            IntBuffer value, String name);
    public void setUint32SeqValue(String name, LongBuffer value);
    public void setUint32SeqValueOverflow(String name, IntBuffer value);

    public ShortBuffer getInt16SeqValue(ShortBuffer value, String name);
    public void setInt16SeqValue(String name, ShortBuffer value);

    public IntBuffer getUint16SeqValue(IntBuffer value, String name);
    public ShortBuffer getUint16SeqValueOverflow(
            ShortBuffer value, String name);
    public void setUint16SeqValue(String name, IntBuffer value);
    public void setUint16SeqValueOverflow(String name, ShortBuffer value);

    public LongBuffer getInt64SeqValue(LongBuffer value, String name);
    public void setInt64SeqValue(String name, LongBuffer value);

    public List<BigInteger> getUint64SeqValue(
            List<BigInteger> value, String name);
    public LongBuffer getUint64SeqValueOverflow(
            LongBuffer value, String name);
    public void setUint64SeqValue(String name, List<BigInteger> value);
    public void setUint64SeqValueOverflow(String name, LongBuffer value);

    public FloatBuffer getFloat32SeqValue(FloatBuffer value, String name);
    public void setFloat32SeqValue(String name, FloatBuffer value);

    public DoubleBuffer getFloat64SeqValue(DoubleBuffer value, String name);
    public void setFloat64SeqValue(String name, DoubleBuffer value);

    public List<BigDecimal> getFloat128SeqValue(
            List<BigDecimal> value, String name);
    public DoubleBuffer getFloat128SeqValueOverflow(
            DoubleBuffer value, String name);
    public void setFloat128SeqValue(String name, List<BigDecimal> value);
    public void setFloat128SeqValueOverflow(String name, DoubleBuffer value);

    public StringBuilder getChar8SeqValue(StringBuilder value, String name);
    public void setChar8SeqValue(String name, CharSequence value);

    public StringBuilder getChar32SeqValue(StringBuilder value, String name);
    public void setChar32SeqValue(String name, CharSequence value);

    public ByteBuffer getByteSeqValue(ByteBuffer value, String name);
    public void setByteSeqValue(String name, ByteBuffer value);

    public List<Boolean> getBooleanSeqValue(List<Boolean> value, String name);
    public void setBooleanSeqValue(String name, List<Boolean> value);

    public List<String> getStringSeqValue(List<String> value, String name);
    public void setStringSeqValue(String name, List<String> value);

    public List<String> getWstringSeqValue(List<String> value, String name);
    public void setWstringSeqValue(String name, List<String> value);

    public int getInt32ValueById(int id);
    public void setInt32ValueById(int id, int value);

    public long getUint32ValueById(int id);
    public int getUint32ValueByIdOverflow(int id);
    public void setUint32ValueById(int id, long value);
    public void setUint32ValueByIdOverflow(int id, int value);

    public short getInt16ValueById(int id);
    public void setInt16ValueById(int id, short value);

    public int getUint16ValueById(int id);
    public short getUint16ValueByIdOverflow(int id);
    public void setUint16ValueById(int id, int value);
    public void setUint16ValueByIdOverflow(int id, short value);

    public long getInt64ValueById(int id);
    public void setInt64ValueById(int id, long value);

    public BigInteger getUint64ValueById(int id);
    public long getUint64ValueByIdOverflow(int id);
    public void setUint64ValueById(int id, BigInteger value);
    public void setUint64ValueByIdOverflow(int id, long value);

    public float getFloat32ValueById(int id);
    public void setFloat32ValueById(int id, float value);

    public double getFloat64ValueById(int id);
    public void setFloat64ValueById(int id, double value);

    public BigDecimal getFloat128ValueById(int id);
    public double getFloat128ValueByIdOverflow(int id);
    public void setFloat128ValueById(int id, BigDecimal value);
    public void setFloat128ValueByIdOverflow(int id, double value);

    public char getChar8ValueById(int id);
    public void setChar8ValueById(int id, char value);

    public int getChar32ValueById(int id);
    public void setChar32ValueById(int id, char value);
    public void setChar32ValueById(int id, int value);

    public byte getByteValueById(int id);
    public void setByteValueById(int id, byte value);

    public boolean getBooleanValueById(int id);
    public void setBooleanValueById(int id, boolean value);

    public String getStringValueById(int id);
    public void setStringValueById(int id, CharSequence value);

    public String getWstringValueById(int id);
    public void setWstringValueById(int id, CharSequence value);

    public DynamicData getComplexValueById(DynamicData value, int id);
    public void setComplexValueById(int id, DynamicData value);

    public int getInt32ArrayValueById(
            int[] value, int offset, int length, int id);
    public void setInt32ArrayValueById(
            int id, int[] value, int offset, int length);
    public void setInt32ArrayValueById(int id, int... value);

    public int getUint32ArrayValueById(
            long[] value, int offset, int length, int id);
    public int getUint32ArrayValueByIdOverflow(
            int[] value, int offset, int length, int id);
    public void setUint32ArrayValueById(
            int id, long[] value, int offset, int length);
    public void setUint32ArrayValueByIdOverflow(
            int id, int[] value, int offset, int length);
    public void setUint32ArrayValueById(int id, long... value);
    public void setUint32ArrayValueByIdOverflow(int id, int... value);

    public int getInt16ArrayValueById(
            short[] value, int offset, int length, int id);
    public void setInt16ArrayValueById(
            int id, short[] value, int offset, int length);
    public void setInt16ArrayValueById(int id, short... value);

    public int getUint16ArrayValueById(
            int[] value, int offset, int length, int id);
    public int getUint16ArrayValueByIdOverflow(
            short[] value, int offset, int length, int id);
    public void setUint16ArrayValueById(
            int id, int[] value, int offset, int length);
    public void setUint16ArrayValueByIdOverflow(
            int id, short[] value, int offset, int length);
    public void setUint16ArrayValueById(int id, int... value);
    public void setUint16ArrayValueByIdOverflow(int id, short... value);

    public int getInt64ArrayValueById(
            long[] value, int offset, int length, int id);
    public void setInt64ArrayValueById(
            int id, long[] value, int offset, int length);
    public void setInt64ArrayValueById(int id, long... value);

    public int getUint64ArrayValueById(
            BigInteger[] value, int offset, int length, int id);
    public int getUint64ArrayValueByIdOverflow(
            long[] value, int offset, int length, int id);
    public void setUint64ArrayValueById(
            int id, BigInteger[] value, int offset, int length);
    public void setUint64ArrayValueByIdOverflow(
            int id, long[] value, int offset, int length);
    public void setUint64ArrayValueByIdOverflow(int id, long... value);

    public int getFloat32ArrayValueById(
            float[] value, int offset, int length, int id);
    public void setFloat32ArrayValueById(
            int id, float[] value, int offset, int length);

    public int getFloat64ArrayValueById(
            double[] value, int offset, int length, int id);
    public void setFloat64ArrayValueById(
            int id, double[] value, int offset, int length);

    public int getFloat128ArrayValueById(
            double[] value, int offset, int length, int id);
    public int getFloat128ArrayValueByIdOverflow(
            BigDecimal[] value, int offset, int length, int id);
    public void setFloat128ArrayValueById(
            int id, BigDecimal[] value, int offset, int length);
    public void setFloat128ArrayValueByIdOverflow(
            int id, double[] value, int offset, int length);
    public void setFloat128ArrayValueByIdOverflow(int id, double... value);

    public int getChar8ArrayValueById(
            char[] value, int offset, int length, int id);
    public void setChar8ArrayValueById(
            int id, char[] value, int offset, int length);

    public int getChar32ArrayValueById(
            int[] value, int offset, int length, int id);
    public void setChar32ArrayValueById(
            int id, char[] value, int offset, int length);
    public void setChar32ArrayValueById(
            int id, int[] value, int offset, int length);
    public void setChar32ArrayValueById(int id, char... value);
    public void setChar32ArrayValueById(int id, int... value);

    public int getByteArrayValueById(
            byte[] value, int offset, int length, int id);
    public void setByteArrayValueById(
            int id, byte[] value, int offset, int length);

    public int getBooleanArrayValueById(
            boolean[] value, int offset, int length, int id);
    public void setBooleanArrayValueById(
            int id, boolean[] value, int offset, int length);

    public int getStringArrayValueById(
            String[] value, int offset, int length, int id);
    public void setStringArrayValueById(
            int id, String[] value, int offset, int length);

    public int getWstringArrayValueById(
            String[] value, int offset, int length, int id);
    public void setWstringArrayValueById(
            int id, String[] value, int offset, int length);

    public IntBuffer getInt32SeqValueById(IntBuffer value, int id);
    public void setInt32SeqValueById(int id, IntBuffer value);

    public LongBuffer getUint32SeqValueById(IntBuffer value, int id);
    public IntBuffer getUint32SeqValueByIdOverflow(IntBuffer value, int id);
    public void setUint32SeqValueById(int id, LongBuffer value);
    public void setUint32SeqValueByIdOverflow(int id, IntBuffer value);

    public ShortBuffer getInt16SeqValueById(ShortBuffer value, int id);
    public void setInt16SeqValueById(int id, ShortBuffer value);

    public IntBuffer getUint16SeqValueById(IntBuffer value, int id);
    public ShortBuffer getUint16SeqValueByIdOverflow(
            ShortBuffer value, int id);
    public void setUint16SeqValueById(int id, IntBuffer value);
    public void setUint16SeqValueByIdOverflow(int id, ShortBuffer value);

    public LongBuffer getInt64SeqValueById(LongBuffer value, int id);
    public void setInt64SeqValueById(int id, LongBuffer value);

    public List<BigInteger> getUint64SeqValueById(
            List<BigInteger> value, int id);
    public LongBuffer getUint64SeqValueByIdOverflow(LongBuffer value, int id);
    public void setUint64SeqValueById(int id, List<BigInteger> value);
    public void setUint64SeqValueByIdOverfow(int id, LongBuffer value);

    public FloatBuffer getFloat32SeqValueById(FloatBuffer value, int id);
    public void setFloat32SeqValueById(int id, FloatBuffer value);

    public DoubleBuffer getFloat64SeqValueById(DoubleBuffer value, int id);
    public void setFloat64SeqValueById(int id, DoubleBuffer value);

    public List<BigDecimal> getFloat128SeqValueById(
            List<BigDecimal> value, int id);
    public DoubleBuffer getFloat128SeqValueByIdOverflow(
            DoubleBuffer value, int id);
    public void setFloat128SeqValueById(int id, List<BigDecimal> value);
    public void setFloat128SeqValueByIdOverflow(int id, DoubleBuffer value);

    public StringBuilder getChar8SeqValueById(StringBuilder value, int id);
    public void setChar8SeqValueById(int id, CharSequence value);

    public StringBuilder getChar32SeqValueById(StringBuilder value, int id);
    public void setChar32SeqValueById(int id, CharSequence value);

    public ByteBuffer getByteSeqValueById(ByteBuffer value, int id);
    public void setByteSeqValueById(int id, ByteBuffer value);

    public void getBooleanSeqValueById(List<Boolean> value, int id);
    public void setBooleanSeqValueById(int id, List<Boolean> value);

    public void getStringSeqValueById(List<String> value, int id);
    public void setStringSeqValueById(int id, List<String> value);

    public void getWstringSeqValueById(List<String> value, int id);
    public void setWstringSeqValueById(int id, List<String> value);

    public int getInt32ValueAtIndex(int index);
    public void setInt32ValueAtIndex(int index, int value);

    public long getUint32ValueAtIndex(int index);
    public int getUint32ValueAtIndexOverflow(int index);
    public void setUint32ValueAtIndex(int index, long value);
    public void setUint32ValueAtIndexOverflow(int index, int value);

    public short getInt16ValueAtIndex(int index);
    public void setInt16ValueAtIndex(int index, short value);

    public int getUint16ValueAtIndex(int index);
    public short getUint16ValueAtIndexOverflow(int index);
    public void setUint16ValueAtIndex(int index, int value);
    public void setUint16ValueAtIndexOverflow(int index, short value);

    public long getInt64ValueAtIndex(int index);
    public void setInt64ValueAtIndex(int index, long value);

    public BigInteger getUint64ValueAtIndex(int index);
    public long getUint64ValueAtIndexOverflow(int index);
    public void setUint64ValueAtIndex(int index, BigInteger value);
    public void setUint64ValueAtIndexOverflow(int index, long value);

    public float getFloat32ValueAtIndex(int index);
    public void setFloat32ValueAtIndex(int index, float value);

    public double getFloat64ValueAtIndex(int index);
    public void setFloat64ValueAtIndex(int index, double value);

    public BigDecimal getFloat128ValueAtIndex(int index);
    public double getFloat128ValueAtIndexOverflow(int index);
    public void setFloat128ValueAtIndex(int index, BigDecimal value);
    public void setFloat128ValueAtIndexOverflow(int index, double value);

    public char getChar8ValueAtIndex(int index);
    public void setChar8ValueAtIndex(int index, char value);

    public int getChar32ValueAtIndex(int index);
    public void setChar32ValueAtIndex(int index, char value);
    public void setChar32ValueAtIndex(int index, int value);

    public byte getByteValueAtIndex(int index);
    public void setByteValueAtIndex(int index, byte value);

    public boolean getBooleanValueAtIndex(int index);
    public void setBooleanValueAtIndex(int index, boolean value);

    public String getStringValueAtIndex(int index);
    public void setStringValueAtIndex(int index, String value);

    public String getWstringValueAtIndex(int index);
    public void setWstringValueAtIndex(int index, String value);

    public int getInt32ArrayValueAtIndex(
            int[] value, int offset, int length, int index);
    public void setInt32ArrayValueAtIndex(
            int index, int[] value, int offset, int length);
    public void setInt32ArrayValueAtIndex(int index, int... value);

    public int getUint32ArrayValueAtIndex(
            int[] value, int offset, int length, int index);
    public void setUint32ArrayValueAtIndex(
            int index, int[] value, int offset, int length);
    public void setUint32ArrayValueAtIndex(int index, int... value);

    public int getInt16ArrayValueAtIndex(
            short[] value, int offset, int length, int index);
    public void setInt16ArrayValueAtIndex(
            int index, short[] value, int offset, int length);

    public int getUint16ArrayValueAtIndex(
            int[] value, int offset, int length, int index);
    public int getUint16ArrayValueAtIndexOverflow(
            short[] value, int offset, int length, int index);
    public void setUint16ArrayValueAtIndex(
            int index, int[] value, int offset, int length);
    public void setUint16ArrayValueAtIndexOverflow(
            int index, short[] value, int offset, int length);
    public void setUint16ArrayValueAtIndex(int index, int... value);
    public void setUint16ArrayValueAtIndexOverflow(int index, short... value);

    public int getInt64ArrayValueAtIndex(
            long[] value, int offset, int length, int index);
    public void setInt64ArrayValueAtIndex(
            int index, long[] value, int offset, int length);

    public int getUint64ArrayValueAtIndex(
            BigInteger[] value, int offset, int length, int index);
    public int getUint64ArrayValueAtIndexOverflow(
            long[] value, int offset, int length, int index);
    public void setUint64ArrayValueAtIndex(
            int index, BigInteger[] value, int offset, int length);
    public void setUint64ArrayValueAtIndexOverflow(
            int index, long[] value, int offset, int length);
    public void setUint64ArrayValueAtIndexOverflow(int index, long... value);

    public int getFloat32ArrayValueAtIndex(
            float[] value, int offset, int length, int index);
    public void setFloat32ArrayValueAtIndex(
            int index, float[] value, int offset, int length);

    public int getFloat64ArrayValueAtIndex(
            double[] value, int offset, int length, int index);
    public void setFloat64ArrayValueAtIndex(
            int index, double[] value, int offset, int length);

    public int getFloat128ArrayValueAtIndex(
            BigDecimal[] value, int offset, int length, int index);
    public int getFloat128ArrayValueAtIndexOverflow(
            double[] value, int offset, int length, int index);
    public void setFloat128ArrayValueAtIndex(
            int index, BigDecimal[] value, int offset, int length);
    public void setFloat128ArrayValueAtIndexOverflow(
            int index, double[] value, int offset, int length);
    public void setFloat128ArrayValueAtIndexOverflow(
            int index, double... value);

    public int getChar8ArrayValueAtIndex(
            char[] value, int offset, int length, int index);
    public void setChar8ArrayValueAtIndex(
            int index, char[] value, int offset, int length);
    public void setChar8ArrayValueAtIndex(int index, char... value);

    public int getChar32ArrayValueAtIndex(
            int[] value, int offset, int length, int index);
    public void setChar32ArrayValueAtIndex(
            int index, char[] value, int offset, int length);
    public void setChar32ArrayValueAtIndex(
            int index, int[] value, int offset, int length);
    public void setChar32ArrayValueAtIndex(int index, char... value);
    public void setChar32ArrayValueAtIndex(int index, int... value);

    public int getByteArrayValueAtIndex(
            byte[] value, int offset, int length, int index);
    public void setByteArrayValueAtIndex(
            int index, byte[] value, int offset, int length);

    public int getBooleanArrayValueAtIndex(
            boolean[] value, int offset, int length, int index);
    public void setBooleanArrayValueAtIndex(
            int index, boolean[] value, int offset, int length);
    public void setBooleanArrayValueAtIndex(int index, boolean... value);

    public int getStringArrayValueAtIndex(
            String[] value, int offset, int length, int index);
    public void setStringArrayValueAtIndex(
            int index, String[] value, int offset, int length);
    public void setStringArrayValueAtIndex(int index, String... value);

    public int getWstringArrayValueAtIndex(
            String[] value, int offset, int length, int index);
    public void setWstringArrayValueAtIndex(
            int index, String[] value, int offset, int length);
    public void setWstringArrayValueAtIndex(int index, String... value);

    public IntBuffer getInt32SeqValueAtIndex(IntBuffer value, int index);
    public void setInt32SeqValueAtIndex(int index, IntBuffer value);

    public LongBuffer getUint32SeqValueAtIndex(LongBuffer value, int index);
    public IntBuffer getUint32SeqValueAtIndexOverflow(
            IntBuffer value, int index);
    public void setUint32SeqValueAtIndex(int index, LongBuffer value);
    public void setUint32SeqValueAtIndexOverflow(int index, IntBuffer value);

    public ShortBuffer getInt16SeqValueAtIndex(ShortBuffer value, int index);
    public void setInt16SeqValueAtIndex(int index, ShortBuffer value);

    public IntBuffer getUint16SeqValueAtIndex(IntBuffer value, int index);
    public ShortBuffer getUint16SeqValueAtIndexOverflow(
            ShortBuffer value, int index);
    public void setUint16SeqValueAtIndex(int index, IntBuffer value);
    public void setUint16SeqValueAtIndexOverflow(
            int index, ShortBuffer value);

    public LongBuffer getInt64SeqValueAtIndex(LongBuffer value, int index);
    public void setInt64SeqValueAtIndex(int index, LongBuffer value);

    public List<BigInteger> getUint64SeqValueAtIndex(
            List<BigInteger> value, int index);
    public LongBuffer getUint64SeqValueAtIndexOverflow(
            LongBuffer value, int index);
    public void setUint64SeqValueAtIndex(int index, List<BigInteger> value);
    public void setUint64SeqValueAtIndexOverflow(int index, LongBuffer value);

    public FloatBuffer getFloat32SeqValueAtIndex(
            FloatBuffer value, int index);
    public void setFloat32SeqValueAtIndex(int index, FloatBuffer value);

    public DoubleBuffer getFloat64SeqValueAtIndex(
            DoubleBuffer value, int index);
    public void setFloat64SeqValueAtIndex(int index, DoubleBuffer value);

    public List<BigDecimal> getFloat128SeqValueAtIndex(
            List<BigDecimal> value, int index);
    public DoubleBuffer getFloat128SeqValueAtIndexOverflow(
            DoubleBuffer value, int index);
    public void setFloat128SeqValueAtIndex(int index, List<BigDecimal> value);
    public void setFloat128SeqValueAtIndexOverflow(
            int index, DoubleBuffer value);

    public StringBuilder getChar8SeqValueAtIndex(
            StringBuilder value, int index);
    public void setChar8SeqValueAtIndex(int index, CharSequence value);

    public StringBuilder getChar32SeqValueAtIndex(
            StringBuilder value, int index);
    public void setChar32SeqValueAtIndex(int index, CharSequence value);

    public ByteBuffer getByteSeqValueAtIndex(ByteBuffer value, int index);
    public void setByteSeqValueAtIndex(int index, ByteBuffer value);

    public void getBooleanSeqValueAtIndex(List<Boolean> value, int index);
    public void setBooleanSeqValueAtIndex(int index, List<Boolean> value);

    public void getStringSeqValueAtIndex(List<String> value, int index);
    public void setStringSeqValueAtIndex(int index, List<String> value);

    public void getWstringSeqValueAtIndex(List<String> value, int index);
    public void setWstringSeqValueAtIndex(int index, List<String> value);

    public DynamicData clone();
}
