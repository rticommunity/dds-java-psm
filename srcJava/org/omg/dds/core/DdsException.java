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

package org.omg.dds.core;


/**
 * DDS PIM "return codes" are mostly mapped to subclasses of this exception.
 * 
 * - RETCODE_ERROR:         This class.
 * 
 * - RETCODE_OK:            Normal return; not mapped to anything.
 * - RETCODE_NO_DATA:       A status attached to a normal return; not
 *                          represented as an exception.
 * 
 * - RETCODE_BAD_PARAMETER: java.lang.InvalidArgumentException
 *                          (no new class required)
 * - RETCODE_TIMEOUT:       java.util.concurrent.TimeoutException
 *                          TODO: Is this the right choice?
 *                          (no new class required)
 * - RETCODE_UNSUPPORTED:   java.util.UnsupportedOperationException
 *                          (no new class required)
 * 
 * - IllegalDdsStateException extends java.lang.IllegalStateException
 * - RETCODE_ALREADY_DELETED:      AlreadyDeletedException
 *                                 (extends IllegalDdsStateException)
 * - RETCODE_ILLEGAL_OPERATION:    IllegalOperationException
 *                                 (extends IllegalDdsStateException)
 * - RETCODE_NOT_ENABLED:          NotEnabledException
 *                                 (extends IllegalDdsStateException)
 * - RETCODE_PRECONDITION_NOT_MET: PreconditionNotMetException
 *                                 (extends IllegalDdsStateException)
 *
 * - RETCODE_IMMUTABLE_POLICY:     ImmutablePolicyException
 *                                 (extends DdsException)
 * - RETCODE_INCONSISTENT_POLICY:  InconsistentPolicyException
 *                                 (extends DdsException)
 * - RETCODE_OUT_OF_RESOURCES:     OutOfResourcesException
 *                                 (extends DdsException)
 */
public class DdsException extends RuntimeException implements DdsObject {
    // -----------------------------------------------------------------------
    // Private Fields
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 1147344098842712819L;

    private final Context _parent;



    // -----------------------------------------------------------------------
    // Public Methods
    // -----------------------------------------------------------------------

    // --- Object Lifecycle: -------------------------------------------------

    public DdsException(Context parent) {
        checkForNull(parent);
        _parent = parent;
    }

    public DdsException(Context parent, String message) {
        super(message);
        checkForNull(parent);
        _parent = parent;
    }

    public DdsException(Context parent, Throwable cause) {
        super(cause);
        checkForNull(parent);
        _parent = parent;
    }

    public DdsException(Context parent, String message, Throwable cause) {
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
