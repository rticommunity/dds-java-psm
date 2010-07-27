/* Copyright(c) 2009-2010, Real-Time Innovations, Inc.
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
 * CONSEQUENTIAL DAMAGES(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT(INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.omg.dds.type.typeobject;

import org.omg.dds.core.ModifiableValueType;


public interface TypeLibraryElement
extends ModifiableValueType<TypeLibraryElement, TypeLibraryElement>
{
    // -----------------------------------------------------------------------
    // Properties
    // -----------------------------------------------------------------------

    public Kind discriminator();

    public AliasType getAliasType();

    public void setAliasType(AliasType value);


    public AnnotationType annotationType();

    public void annotationType(AnnotationType value);


    public ArrayType arrayType();

    public void arrayType(ArrayType value);


    public BitSetType bitsetType();

    public void bitsetType(BitSetType value);


    public EnumerationType enumerationType();

    public void enumerationType(EnumerationType value);


    public MapType mapType();

    public void mapType(MapType value);


    public SequenceType sequenceType();

    public void sequenceType(SequenceType value);


    public StringType stringType();

    public void stringType(StringType value);


    public StructureType structureType();

    public void structureType(StructureType value);


    public UnionType unionType();

    public void unionType(UnionType value);


    public Module module();

    public void module(Module value);



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    public enum Kind
    {
        // --- Constants: ----------------------------------------------------
        ALIAS_TYPE_ELEMENT      ((short)  0),
        ANNOTATION_TYPE_ELEMENT ((short)  1),
        ARRAY_TYPE_ELEMENT      ((short)  2),
        BITSET_TYPE_ELEMENT     ((short)  3),
        ENUMERATION_TYPE_ELEMENT((short)  4),
        MAP_TYPE_ELEMENT        ((short)  5),
        SEQUENCE_TYPE_ELEMENT   ((short)  6),
        STRING_TYPE_ELEMENT     ((short)  7),
        STRUCTURE_TYPE_ELEMENT  ((short)  8),
        UNION_TYPE_ELEMENT      ((short)  9),
        MODULE_ELEMENT          ((short) 10),
        ;


        // --- Fields: -------------------------------------------------------
        public final short value;


        // --- Constructor: --------------------------------------------------
        private Kind(short value) {
            this.value = value;
        }
    }
}
