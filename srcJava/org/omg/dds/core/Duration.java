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


public interface Duration extends ValueType<Duration> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    public static final int INFINITE_SEC = Integer.MAX_VALUE;
    public static final int INFINITE_NSEC = Integer.MAX_VALUE;

    public static final int ZERO_SEC = 0;
    public static final int ZERO_NSEC = 0;



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- Data access: ------------------------------------------------------

    /**
     * @param sec the sec to set
     */
    public void setSec(int sec);

    /**
     * @return the sec
     */
    public int getSec();

    /**
     * @param nanosec the nanosec to set
     */
    public void setNanosec(int nanosec);

    /**
     * @return the nanosec
     */
    public int getNanosec();


    // --- Manipulation: -----------------------------------------------------

    public void add(Duration duration);

    public void addSec(int sec);

    public void addNanosec(int nanosec);

    public void addMillis(long millis);


    // --- Conversion: -------------------------------------------------------

    /**
     * Round or truncate this Duration to a whole number of milliseconds.
     */
    public long toMillis();

    public long toNanosec();

    public void fromMillis(long millis);

    public void fromNanosec(long nanosec);

}