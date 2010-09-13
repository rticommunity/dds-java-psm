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
 * - Neither the names of the above copyright holders nor the names of their
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL A COPYRIGHT HOLDER OR CONTRIBUTOR BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT(INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.omg.dds.type.typeobject;

import org.omg.dds.core.ModifiableValue;
import org.omg.dds.type.TypeKind;
import org.omg.dds.type.annotation.BitBound;
import org.omg.dds.type.annotation.Extensibility;
import org.omg.dds.type.annotation.Nested;
import org.omg.dds.type.annotation.Value;


@Extensibility(Extensibility.Kind.MUTABLE_EXTENSIBILITY)
@Nested
public interface TypeLibraryElement
extends ModifiableValue<TypeLibraryElement, TypeLibraryElement>
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

    @BitBound(16)
    public static enum Kind
    {
        // --- Constants: ----------------------------------------------------
        @Value(TypeKind.Values.ALIAS_TYPE_VALUE)
        ALIAS_TYPE_ELEMENT      (TypeKind.ALIAS_TYPE.value),

        @Value(TypeKind.Values.ANNOTATION_TYPE_VALUE)
        ANNOTATION_TYPE_ELEMENT (TypeKind.ANNOTATION_TYPE.value),

        @Value(TypeKind.Values.ARRAY_TYPE_VALUE)
        ARRAY_TYPE_ELEMENT      (TypeKind.ARRAY_TYPE.value),

        @Value(TypeKind.Values.BITSET_TYPE_VALUE)
        BITSET_TYPE_ELEMENT     (TypeKind.BITSET_TYPE.value),

        @Value(TypeKind.Values.ENUMERATION_TYPE_VALUE)
        ENUMERATION_TYPE_ELEMENT(TypeKind.ENUMERATION_TYPE.value),

        @Value(TypeKind.Values.MAP_TYPE_VALUE)
        MAP_TYPE_ELEMENT        (TypeKind.MAP_TYPE.value),

        @Value(TypeKind.Values.SEQUENCE_TYPE_VALUE)
        SEQUENCE_TYPE_ELEMENT   (TypeKind.SEQUENCE_TYPE.value),

        @Value(TypeKind.Values.STRING_TYPE_VALUE)
        STRING_TYPE_ELEMENT     (TypeKind.STRING_TYPE.value),

        @Value(TypeKind.Values.STRUCTURE_TYPE_VALUE)
        STRUCTURE_TYPE_ELEMENT  (TypeKind.STRUCTURE_TYPE.value),

        @Value(TypeKind.Values.UNION_TYPE_VALUE)
        UNION_TYPE_ELEMENT      (TypeKind.UNION_TYPE.value),

        @Value(TypeKind.Values.UNION_TYPE_VALUE + 1)
        MODULE_ELEMENT      ((short) (TypeKind.UNION_TYPE.value + 1)),
        ;


        // --- Fields: -------------------------------------------------------
        public final short value;


        // --- Constructor: --------------------------------------------------
        private Kind(short value) {
            this.value = value;
        }
    }
}
