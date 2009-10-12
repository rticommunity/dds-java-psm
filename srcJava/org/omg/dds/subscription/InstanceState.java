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

package org.omg.dds.subscription;

import java.util.Set;

import org.omg.dds.spi.LifecycleStateFactory;
import org.omg.dds.spi.ServiceImpl;
import org.omg.dds.util.ExtensibleEnum;


public abstract class InstanceState extends ExtensibleEnum<InstanceState> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 5526467917118587389L;



    // -----------------------------------------------------------------------
    // Object Lifecycle
    // -----------------------------------------------------------------------

    protected InstanceState(String enumName, int ordinal) {
        super(enumName, ordinal);
    }

    private static InstanceState create(
            String enumName, int ordinal, int value) {
        LifecycleStateFactory factory =
            ServiceImpl.getInstance().getLifecycleStateFactory();
        InstanceState state = factory.createInstanceState(
                enumName, ordinal, value);
        assert state != null;
        return state;
    }

    private static Set<InstanceState> createNotAliveStateSet() {
        LifecycleStateFactory factory =
            ServiceImpl.getInstance().getLifecycleStateFactory();
        Set<InstanceState> set = factory.createNotAliveInstanceStateSet();
        assert set != null;
        return set;
    }

    private static Set<InstanceState> createAnyStateSet() {
        LifecycleStateFactory factory =
            ServiceImpl.getInstance().getLifecycleStateFactory();
        Set<InstanceState> set = factory.createAnyInstanceStateSet();
        assert set != null;
        return set;
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    public abstract int getValue();



    // -----------------------------------------------------------------------
    // States
    // -----------------------------------------------------------------------

    public static final InstanceState ALIVE = create("ALIVE", 0, 0x0001 << 0);

    public static final InstanceState NOT_ALIVE_DISPOSED = create(
            "NOT_ALIVE_DISPOSED", 1, 0x0001 << 1);

    public static final InstanceState NOT_ALIVE_NO_WRITERS = create(
            "NOT_ALIVE_NO_WRITERS", 2, 0x0001 << 2);

    public static final Set<InstanceState> NOT_ALIVE =
        createNotAliveStateSet();

    public static final Set<InstanceState> ANY = createAnyStateSet();

}
