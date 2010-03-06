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

package org.omg.dds.core;


/**
 * A superclass for all DDS exceptions that indicate that an operation was
 * invoked at an invalid time or when the target object is in an invalid
 * state. 
 */
public class IllegalDdsStateException
extends IllegalStateException implements DdsObject {
    // -----------------------------------------------------------------------
    // Private Fields
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 7024035503599957879L;

    private final Context _parent;



    // -----------------------------------------------------------------------
    // Public Methods
    // -----------------------------------------------------------------------

    // --- Object Lifecycle: -------------------------------------------------

    public IllegalDdsStateException(Context parent) {
        checkForNull(parent);
        _parent = parent;
    }

    public IllegalDdsStateException(Context parent, String s) {
        super(s);
        checkForNull(parent);
        _parent = parent;
    }

    public IllegalDdsStateException(Context parent, Throwable cause) {
        super(cause);
        checkForNull(parent);
        _parent = parent;
    }

    public IllegalDdsStateException(Context parent,
                                    String message,
                                    Throwable cause) {
        super(message, cause);
        checkForNull(parent);
        _parent = parent;
    }


    // --- From DdsObject: ---------------------------------------------------

    public Context getContext() {
        assert _parent != null;
        return _parent;
    }



    // -----------------------------------------------------------------------
    // Private Methods
    // -----------------------------------------------------------------------

    private static void checkForNull(Context parent) {
        if (parent == null) {
            throw new IllegalArgumentException("null Context");
        }
    }

}
