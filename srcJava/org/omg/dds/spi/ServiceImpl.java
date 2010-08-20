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

package org.omg.dds.spi;

import org.omg.dds.domain.DomainParticipantFactory;


/**
 * DDS implementations are rooted in this class, a singleton implementation
 * of which is instantiated based on a system property.
 * 
 * TODO: Can we modify the design to allow multiple DDS implementations to
 *       coexist within the same class loader? It may be hard, since the DDS
 *       API has a lot of entry points.
 *
 * TODO: Can we avoid requiring static state? That can cause problems for
 *       certain managed applications.
 */
public abstract class ServiceImpl {
    // -----------------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------------

    /**
     * The only implementation of this class. The singleton is assigned at
     * class load time rather than lazily the first time
     * {@link #getInstance()} is called in order to avoid potentially thread
     * safety concerns.
     */
    private static final ServiceImpl _singleton;

    static {
        final String IMPLEMENTATION_CLASS_NAME =
            "org.omg.dds.serviceClassName";
        final String ERROR_STRING = "Unable to load OMG DDS implementation";

        // --- Get implementation class name --- //
        String className = System.getProperty(IMPLEMENTATION_CLASS_NAME);
        if (className == null || className.length() == 0) {
            // no implementation class name specified
            throw new ServiceNotFoundException(
                    ERROR_STRING + ". Please set " +
                        IMPLEMENTATION_CLASS_NAME + " property.");
        }

        // --- Load implementation class --- //
        try {
            ServiceImpl impl = ServiceImpl.class.cast(
                    Class.forName(className));
            assert impl != null;
            _singleton = impl;
        } catch (ClassNotFoundException cnfx) {
            throw new ServiceNotFoundException(
                    ERROR_STRING + ": class " + className +
                        " could not be loaded",
                    cnfx);
        } catch (ClassCastException ccx) {
            throw new ServiceNotFoundException(
                    ERROR_STRING + ": class " + className +
                        " does not extend " + ServiceImpl.class.getName(),
                    ccx);
        }
    }



    // -----------------------------------------------------------------------
    // Object Lifecycle
    // -----------------------------------------------------------------------

    public static ServiceImpl getInstance() {
        return _singleton;
    }


    protected ServiceImpl() {
        // empty
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    public abstract DomainParticipantFactory getParticipantFactory();

    public abstract SimpleDataFactory getSimpleDataFactory();

    public abstract ConditionFactory getConditionFactory();

    public abstract BuiltinTopicDataFactory getBuiltinTopicDataFactory();
    
    public abstract StatusFactory getStatusFactory();
    
    public abstract QosPolicyFactory getQosPolicyFactory();

    public abstract LifecycleStateFactory getLifecycleStateFactory();

    public abstract ExtensibleEnumFactory getExtensibleEnumFactory();

}
