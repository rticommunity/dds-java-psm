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

package org.omg.dds.infrastructure;

import org.omg.dds.spi.ServiceImpl;
import org.omg.dds.util.ValueType;


/**
 * DDS/Time.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from dds_rtf2_dcps.idl
 * Wednesday, September 16, 2009 9:06:02 AM CDT
 */
public abstract class Time implements ValueType<Time> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 3413932502170894467L;

    public static final int INVALID_SEC = -1;
    public static final int INVALID_NSEC = -1;



    // -----------------------------------------------------------------------
    // Object Lifecycle
    // -----------------------------------------------------------------------

    /**
     * Create and return a new Time representing the current time.
     */
    public static Time now() {
        Time time = ServiceImpl.getInstance().getSimpleDataFactory().now();
        assert time != null;
        return time;
    }
    
    
    public static Time create(long millis) {
        Time time =
            ServiceImpl.getInstance().getSimpleDataFactory().createTime(
                    millis);
        assert time != null;
        return time;
    }
    
    
    public static Time create(int sec, int nanosec) {
        Time time =
            ServiceImpl.getInstance().getSimpleDataFactory().createTime(
                sec, nanosec);
        assert time != null;
        return time;
    }
    
    
    public static Time create(Time src) {
        Time time =
            ServiceImpl.getInstance().getSimpleDataFactory().createTime(src);
        assert time != null;
        return time;
    }
    
    
    protected Time() {
        // empty
    }


    @Override
    public abstract Time clone();



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- Data access: ------------------------------------------------------

    /**
     * @param sec the sec to set
     */
    public abstract void setSec(int sec);

    /**
     * @return the sec
     */
    public abstract int getSec();

    /**
     * @param nanosec the nanosec to set
     */
    public abstract void setNanosec(int nanosec);

    /**
     * @return the nanosec
     */
    public abstract int getNanosec();


    // --- Manipulation: -----------------------------------------------------

    public abstract void add(Duration duration);

    public abstract void addSec(int sec);

    public abstract void addNanosec(int nanosec);

    public abstract void addMillis(long millis);


    // --- Conversion: -------------------------------------------------------

    /**
     * Set the time to the given number of milliseconds.
     */
    public abstract void fromMillis(long millis);

    /**
     * @return  the number of milliseconds corresponding to this time,
     *          rounded or truncated to a whole number.
     */
    public abstract long toMillis();

}