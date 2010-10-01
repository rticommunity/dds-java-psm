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

package org.omg.dds.core;

import org.omg.dds.core.policy.QosPolicy;
import org.omg.dds.sub.DataReader;


/**
 * DDS recognizes a number of ways in which an operation may return, which
 * are mapped to exceptions in the following way:
 * 
 * <table border="1" cellspacing="0" cellpadding="2">
 * <tr><th>Return</th><th>Description</th><th>Exception</th></tr>
 * <tr>
 *     <td>OK</td>
 *     <td>Normal, successful return.</td>
 *     <td>(<em>none</em>)</td>
 * </tr>
 * <tr>
 *     <td>NO_DATA</td>
 *     <td>Normal, successful return from a data access method such as
 *         {@link DataReader#take()}, but no data was available.
 *     </td>
 *     <td>(<em>none</em>)</td>
 * </tr>
 * <tr>
 *     <td>TIMEOUT</td>
 *     <td>Blocking operation failed to complete within the specified timeout
 *         duration.
 *     </td>
 *     <td>{@link java.util.concurrent.TimeoutException}</td>
 * </tr>
 * <tr>
 *     <td>BAD_PARAMETER</td>
 *     <td>An argument passed to a method was out of range or had a value
 *         that was otherwise illegal.
 *     </td>
 *     <td>{@link java.lang.IllegalArgumentException}</td>
 * </tr>
 * <tr>
 *     <td>UNSUPPORTED</td>
 *     <td>The method is not supported by this DDS implementation.
 *     </td>
 *     <td>{@link java.lang.UnsupportedOperationException}</td>
 * </tr>
 * <tr>
 *     <td>NOT_ENABLED</td>
 *     <td>The {@link Entity} has not yet been enabled for communication.</td>
 *     <td>{@link NotEnabledException}</td>
 * </tr>
 * <tr>
 *     <td>ALREADY_DELETED</td>
 *     <td>The object on which the method is invoked has already been closed.
 *     </td>
 *     <td>{@link AlreadyClosedException}</td>
 * </tr>
 * <tr>
 *     <td>ILLEGAL_OPERATION</td>
 *     <td>The method cannot be invoked in the current calling context (e.g.
 *         from within a listener callback).
 *     </td>
 *     <td>{@link IllegalOperationException}</td>
 * </tr>
 * <tr>
 *     <td>PRECONDITION_NOT_MET</td>
 *     <td>The object is not in the proper state to invoke the method.</td>
 *     <td>{@link PreconditionNotMetException}</td>
 * </tr>
 * <tr>
 *     <td>IMMUTABLE_POLICY</td>
 *     <td>An attempt was made to change a {@link QosPolicy} that cannot be
 *         changed.</td>
 *     <td>{@link ImmutablePolicyException}</td>
 * </tr>
 * <tr>
 *     <td>INCONSISTENT_POLICY</td>
 *     <td>Two or more {@link QosPolicy} property values have been specified
 *         that are inconsistent with one another.
 *     </td>
 *     <td>{@link ImmutablePolicyException}</td>
 * </tr>
 * <tr>
 *     <td>OUT_OF_RESOURCES</td>
 *     <td>An internal resource of the DDS implementation has been exhausted,
 *         preventing the successful completion of the method.
 *     </td>
 *     <td>{@link OutOfResourcesException}</td>
 * </tr>
 * <tr>
 *     <td>ERROR</td>
 *     <td>The method failed to complete successfully for another reason.</td>
 *     <td>{@link DDSException} (this class)</td>
 * </tr>
 * </table>
 */
public abstract class DDSException
extends RuntimeException implements DDSObject {
    // -----------------------------------------------------------------------
    // Private Fields
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -7560788483511488746L;



    // -----------------------------------------------------------------------
    // Protected Methods
    // -----------------------------------------------------------------------

    // --- Object Life Cycle: ------------------------------------------------

    protected DDSException() {
        super();
    }

    protected DDSException(String message) {
        super(message);
    }

    protected DDSException(Throwable cause) {
        super(cause);
    }

    protected DDSException(String message, Throwable cause) {
        super(message, cause);
    }
}
