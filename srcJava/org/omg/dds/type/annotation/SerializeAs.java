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

package org.omg.dds.type.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.omg.dds.type.TypeKind;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {
        ElementType.TYPE,       // for specifying structure vs. union
        ElementType.FIELD,      // for primitives, collections, etc.
        ElementType.METHOD      // JavaBean property: like field, but doc only
    })
public @interface SerializeAs {
    public TypeKind value();

    /**
     * The type of the elements to be stored in a collection (string,
     * sequence, or map) or TypeKind.NO_TYPE if this annotation is not applied
     * to a collection.
     * 
     * If this annotation is applied to a map, it indicates the type of the
     * map's "value" elements. 
     */
    public TypeKind collectionElementKind() default TypeKind.NO_TYPE;

    /**
     * The type of the "key" elements to be stored in a map or
     * TypeKind.NO_TYPE if this annotation is not applied to a map.
     */
    public TypeKind mapKeyElementKind() default TypeKind.NO_TYPE;

    /**
     * The collection's or bit set's bound(s), if any, if this annotation is
     * applied to a collection or bit set, or an empty array if not.
     * 
     * Strings, sequences, and maps have a bound with a single value; an
     * empty array indicates an unbounded collection. Bit sets have a
     * mandatory bound of a single value. Arrays may be multidimensional;
     * each element of the array corresponds to one of these dimensions.
     */
    public long[] bound() default { /* empty */ };
}
