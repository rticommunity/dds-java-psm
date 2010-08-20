/* Copyright (c) 2009, Real-Time Innovations, Inc.
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

package org.omg.dds.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

import org.omg.dds.spi.ExtensibleEnumFactory;
import org.omg.dds.spi.ExtensibleEnumImpl;
import org.omg.dds.spi.ServiceImpl;


/**
 * A parallel to {@link java.lang.Enum} that allows enumerated types to be
 * extended.
 */
public abstract class ExtensibleEnum<SELF>
implements Comparable<ExtensibleEnum<SELF>>, Serializable {
    // -----------------------------------------------------------------------
    // Private Fields
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -4793776301537672379L;

    private transient final ExtensibleEnumImpl<SELF> _impl;



    // -----------------------------------------------------------------------
    // Public Methods
    // -----------------------------------------------------------------------

    /**
     * Returns the ordinal of this enumeration constant (its position in its
     * enum declaration, where the initial constant is assigned an ordinal of
     * zero). Most programmers will have no use for this method.
     * 
     * @see java.lang.Enum#ordinal()
     */
    public final int ordinal() {
        return _impl.ordinal(this);
    }


    /**
     * Returns the name of this enum constant, exactly as declared in its
     * enum declaration. <b>Most programmers should use the
     * {@link #toString()} method in preference to this one, as the
     * <code>toString</code> method may return a more user-friendly name.</b>
     * This method is designed primarily for use in specialized situations
     * where correctness depends on getting the exact name, which will not
     * vary from release to release.
     * 
     * @see java.lang.Enum#name()
     */
    public final String name() {
        return _impl.name(this);
    }


    // --- From Comparable: --------------------------------------------------

    /**
     * Compares this enum with the specified object for order. Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object. Enum constants
     * are only comparable to other enum constants of the same enum type. The
     * natural order implemented by this method is the order in which the
     * constants are declared.
     * 
     *  @see java.lang.Enum#compareTo(Enum)
     */
    public final int compareTo(ExtensibleEnum<SELF> obj) {
        return _impl.compareTo(obj, obj._impl, this);
    }


    // --- From Object: ------------------------------------------------------

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration. This method may be overridden.
     * 
     * @see java.lang.Enum#toString()
     */
    public String toString() {
        return _impl.toString(this);
    }


    /**
     * Returns true if the specified object is equal to this enum constant.
     * 
     * @see java.lang.Enum#equals(Object)
     */
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }


    /**
     * Returns a hash code for this enum constant. 
     * 
     * @see java.lang.Enum#hashCode()
     */
    public final int hashCode() {
        return _impl.hashCode(this);
    }


    /**
     * Returns the enum constant of the specified enum type with the
     * specified name. The name must match exactly an identifier used to
     * declare an enum constant in this type.
     * 
     * @see java.lang.Enum#valueOf(Class, String)
     */
    public static <T> ExtensibleEnum<T> valueOf(
            Class<? extends ExtensibleEnum<T>> enumType, String name) {
        ExtensibleEnum<T> value =
            ServiceImpl.getInstance().getExtensibleEnumFactory().valueOf(
                    enumType, name);
        assert value != null;
        return value;
    }



    // -----------------------------------------------------------------------
    // Protected Methods
    // -----------------------------------------------------------------------

    // --- Constructors: -----------------------------------------------------

    protected ExtensibleEnum(String name, int ordinal) {
        ExtensibleEnumFactory factory =
            ServiceImpl.getInstance().getExtensibleEnumFactory();
        _impl = factory.createExtenibleEnumImpl(name, ordinal, this);
        assert _impl != null;
    }


    // --- From Object: ------------------------------------------------------

    /**
     * Enumerated constants can never be cloned.
     * 
     * @see java.lang.Object#clone()
     * @see java.lang.Enum#clone()
     */
    @Override
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("enums cannot be cloned");
    }


    /**
     * Enumerated constants can never be finalized.
     * 
     * @see java.lang.Object#finalize()
     * @see java.lang.Enum#finalize()
     */
    @Override
    protected final void finalize() throws Throwable {
        super.finalize();
    }



    // -----------------------------------------------------------------------
    // Private Methods
    // -----------------------------------------------------------------------

    // --- Serialization support: --------------------------------------------

    private void writeObject(ObjectOutputStream out) throws IOException {
        _impl.writeObject(out, this);
    }


    private void readObject(ObjectInputStream in)
    throws IOException, ClassNotFoundException {
        _impl.readObject(in, this);
    }


    @SuppressWarnings("unused")
    private void readObjectNoData() throws ObjectStreamException {
        _impl.readObjectNoData(this);
    }

    private Object readResolve() throws ObjectStreamException {
        return _impl.readResolve(this);
    }

}
