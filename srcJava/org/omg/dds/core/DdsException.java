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
public abstract class DdsException
extends RuntimeException implements DdsObject {
    // -----------------------------------------------------------------------
    // Private Fields
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 3593139144678443696L;



    // -----------------------------------------------------------------------
    // Public Methods
    // -----------------------------------------------------------------------

    // --- From DdsObject: ---------------------------------------------------

    public abstract Context getContext();



    // -----------------------------------------------------------------------
    // Protected Methods
    // -----------------------------------------------------------------------

    // --- Object Life Cycle: ------------------------------------------------

    protected DdsException() {
        super();
    }

    protected DdsException(String message) {
        super(message);
    }

    protected DdsException(Throwable cause) {
        super(cause);
    }

    protected DdsException(String message, Throwable cause) {
        super(message, cause);
    }
}
