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

import java.util.Set;

import org.omg.dds.domain.DomainParticipantFactory;
import org.omg.dds.domain.discovery.BuiltinTopicKey;
import org.omg.dds.domain.discovery.ParticipantBuiltinTopicData;
import org.omg.dds.domain.discovery.PublicationBuiltinTopicData;
import org.omg.dds.domain.discovery.SubscriptionBuiltinTopicData;
import org.omg.dds.domain.discovery.TopicBuiltinTopicData;
import org.omg.dds.pub.LivelinessLostStatus;
import org.omg.dds.pub.OfferedDeadlineMissedStatus;
import org.omg.dds.pub.OfferedIncompatibleQosStatus;
import org.omg.dds.pub.PublicationMatchedStatus;
import org.omg.dds.sub.InstanceState;
import org.omg.dds.sub.LivelinessChangedStatus;
import org.omg.dds.sub.RequestedDeadlineMissedStatus;
import org.omg.dds.sub.RequestedIncompatibleQosStatus;
import org.omg.dds.sub.SampleLostStatus;
import org.omg.dds.sub.SampleRejectedStatus;
import org.omg.dds.sub.SampleState;
import org.omg.dds.sub.SubscriptionMatchedStatus;
import org.omg.dds.sub.ViewState;
import org.omg.dds.topic.InconsistentTopicStatus;


/**
 * DDS implementations are rooted in this class, a singleton implementation
 * of which is instantiated based on a system property.
 */
public abstract class Context implements DdsObject {
    // -----------------------------------------------------------------------
    // Public Fields
    // -----------------------------------------------------------------------

    public static final String IMPLEMENTATION_CLASS_NAME_PROPERTY =
        "org.omg.dds.serviceClassName";



    // -----------------------------------------------------------------------
    // Private Fields
    // -----------------------------------------------------------------------

    /* TODO: Refactor this string into the subclass with an abstract method.
     * We should not constrain the implementation to use English error
     * messages or format errors in a certain way.
     */
    private static final String ERROR_STRING =
        "Unable to load OMG DDS implementation";



    // -----------------------------------------------------------------------
    // Object Lifecycle
    // -----------------------------------------------------------------------

    public static Context getInstance() {
        return getInstance(IMPLEMENTATION_CLASS_NAME_PROPERTY);
    }


    public static Context getInstance(String implClassNameProperty) {
        // --- Get implementation class name --- //
        String className = System.getProperty(implClassNameProperty);
        if (className == null || className.length() == 0) {
            // no implementation class name specified
            throw new ServiceNotFoundException(
                    ERROR_STRING + ". Please set " +
                        implClassNameProperty + " property.");
        }

        // --- Load implementation class --- //
        Context impl = null;
        try {
            impl = Context.class.cast(Class.forName(className));
            assert impl != null;
        } catch (ClassNotFoundException cnfx) {
            throw new ServiceNotFoundException(
                    ERROR_STRING + ": class " + className +
                        " could not be loaded",
                    cnfx);
        } catch (ClassCastException ccx) {
            throw new ServiceNotFoundException(
                    ERROR_STRING + ": class " + className +
                        " does not extend " + Context.class.getName(),
                    ccx);
        }
        return impl;
    }


    protected Context() {
        // empty
    }



    // -----------------------------------------------------------------------
    // Factory Methods
    // -----------------------------------------------------------------------

    // --- Entities: ---------------------------------------------------------

    public abstract DomainParticipantFactory getParticipantFactory();


    // --- Time: -------------------------------------------------------------

    public abstract Duration createDuration();

    public abstract Duration createDuration(int sec, int nanosec);

    public abstract Time now();

    public abstract Time createTime(long millis);

    public abstract Time createTime(int sec, int nanosec);


    // --- Instance handle: --------------------------------------------------

    public abstract InstanceHandle getNilHandle();

    public abstract InstanceHandle createInstanceHandle();


    // --- Conditions & WaitSet: ---------------------------------------------

    public abstract GuardCondition createGuardCondition();

    public abstract WaitSet createWaitSet();


    // --- Built-in topics: --------------------------------------------------

    public abstract BuiltinTopicKey createBuiltinTopicKey();

    public abstract BuiltinTopicKey createBuiltinTopicKey(int[] value);

    public abstract
    ParticipantBuiltinTopicData createParticipantBuiltinTopicData();

    public abstract
    PublicationBuiltinTopicData createPublicationBuiltinTopicData();

    public abstract
    SubscriptionBuiltinTopicData createSubscriptionBuiltinTopicData();

    public abstract TopicBuiltinTopicData createTopicBuiltinTopicData();


    // --- Status: -----------------------------------------------------------

    public abstract Set<Status.Kind> getAllStatusKindSet();

    public abstract Set<Status.Kind> getNoneStatusKindSet();

    public abstract LivelinessLostStatus createLivelinessLostStatus();

    public abstract
    OfferedDeadlineMissedStatus createOfferedDeadlineMissedStatus();

    public abstract
    OfferedIncompatibleQosStatus createOfferedIncompatibleQosStatus();

    public abstract PublicationMatchedStatus createPublicationMatchedStatus();

    public abstract LivelinessChangedStatus createLivelinessChangedStatus();

    public abstract
    RequestedDeadlineMissedStatus createRequestedDeadlineMissedStatus();

    public abstract 
    RequestedIncompatibleQosStatus createRequestedIncompatibleQosStatus();

    public abstract SampleLostStatus createSampleLostStatus();

    public abstract SampleRejectedStatus createSampleRejectedStatus();

    public abstract
    SampleRejectedStatus.Kind createSampleRejectedStatusKind();

    public abstract
    SubscriptionMatchedStatus createSubscriptionMatchedStatus();

    public abstract
    InconsistentTopicStatus createInconsistentTopicStatus();


    // --- Sample & Instance Lifecycle: --------------------------------------

    public abstract Set<InstanceState> getAnyInstanceStateSet();

    public abstract Set<InstanceState> getNotAliveInstanceStateSet();

    public abstract Set<SampleState> getAnySampleStateSet();

    public abstract Set<ViewState> getAnyViewStateSet();



    // -----------------------------------------------------------------------
    // Other Methods
    // -----------------------------------------------------------------------

    // --- From DdsObject: ---------------------------------------------------

    public final Context getContext() {
        return this;
    }

}
