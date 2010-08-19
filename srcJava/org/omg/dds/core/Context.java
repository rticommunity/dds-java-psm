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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import org.omg.dds.type.TypeSupport;
import org.omg.dds.type.dynamic.DynamicDataFactory;
import org.omg.dds.type.dynamic.DynamicTypeFactory;


/**
 * DDS implementations are rooted in this class, a concrete subclass
 * of which can be instantiated based on a system property.
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
        "Unable to load OMG DDS implementation. ";



    // -----------------------------------------------------------------------
    // Object Life Cycle
    // -----------------------------------------------------------------------

    /**
     * Create and return a new instance of a concrete implementation of this
     * class. This method is equivalent to calling:
     * 
     * <code>createInstance(IMPLEMENTATION_CLASS_NAME_PROPERTY);</code>
     * 
     * @see     #createInstance(String)
     * @see     #IMPLEMENTATION_CLASS_NAME_PROPERTY
     */
    public static Context createInstance() {
        return createInstance(IMPLEMENTATION_CLASS_NAME_PROPERTY);
    }


    /**
     * Look up the system property identified by the given string and load,
     * then instantiate, the Context implementation class identified by its
     * value. The class must be accessible and have a public no-argument
     * constructor.
     * 
     * @param   implClassNameProperty       The name of a system property,
     *          the value of which will be taken as the name of a Context
     *          implementation class to load.
     * 
     * @return  A non-null Context.
     * 
     * @throws  NullPointerException        If the given property name is
     *          null.
     * @throws  IllegalArgumentException    If the given property name
     *          is the empty string.
     * @throws  ServiceConfigurationException   If the class could not be
     *          loaded because of an issue with the the invocation of this
     *          method or the configuration of the runtime environment. For
     *          example, the class may not be on the class path, it may
     *          require a native library that is not available, or an
     *          inappropriate class may have been requested (e.g. one that is
     *          not a Context or that doesn't have a no-argument constructor).
     * @throws  ServiceInitializationException  If the class was found but
     *          could not be initialized and/or instantiated because of an
     *          error that occurred within its implementation.
     * 
     * @see     #createInstance()
     * @see     System#getProperty(String)
     */
    public static Context createInstance(String implClassNameProperty) {
        // --- Get implementation class name --- //
        /* System.getProperty checks the implClassNameProperty argument as
         * described in the specification for this method and throws
         * NullPointerException or IllegalArgumentException if necessary.
         */
        String className = System.getProperty(implClassNameProperty);
        if (className == null || className.length() == 0) {
            // no implementation class name specified
            throw new ServiceConfigurationException(
                    ERROR_STRING + "Please set " +
                        implClassNameProperty + " property.");
        }

        // --- Load implementation class --- //
        try {
            Class<?> ctxClass = Class.forName(className);
            /* Get the constructor and call it explicitly rather than calling
             * Class.newInstance(). The latter propagates all exceptions,
             * event checked ones, complicating error handling for us and
             * the user.
             */
            Constructor<?> ctor = ctxClass.getConstructor((Class<?>[]) null);
            return (Context) ctor.newInstance((Object[]) null);

            // --- Initialization problems --- //
        } catch (ExceptionInInitializerError initx) {
            // Thrown by Class.forName (or possibly Constructor.newInstance)
            throw new ServiceInitializationException(
                    ERROR_STRING + "Error during static initialization.",
                    initx.getCause());
        } catch (InvocationTargetException itx) {
            // Thrown by Constructor.newInstance
            throw new ServiceInitializationException(
                    ERROR_STRING + "Error during object initialization.",
                    itx.getCause());

            // --- Configuration problems --- //
        } catch (ClassNotFoundException cnfx) {
            // Thrown by Class.forName
            throw new ServiceConfigurationException(
                    ERROR_STRING + className + " was not found.",
                    cnfx);
        } catch (LinkageError linkx) {
            // Thrown by Class.forName
            throw new ServiceConfigurationException(
                    ERROR_STRING + className + " could not be loaded.",
                    linkx);
        } catch (NoSuchMethodException nsmx) {
            // Thrown by Class.getConstructor
            throw new ServiceConfigurationException(
                    ERROR_STRING + className +
                        " has no appropriate constructor.",
                    nsmx);
        } catch (IllegalAccessException iax) {
            // Thrown by Constructor.newInstance
            throw new ServiceConfigurationException(
                    ERROR_STRING + className +
                        " has no appropriate constructor.",
                    iax);
        } catch (InstantiationException ix) {
            // Thrown by Constructor.newInstance
            throw new ServiceConfigurationException(
                    ERROR_STRING + className + " could not be instantiated.",
                    ix);
        } catch (SecurityException sx) {
            // Thrown by Class.getConstructor
            throw new ServiceConfigurationException(
                    ERROR_STRING + "Prevented by security manager.", sx);
        } catch (ClassCastException ccx) {
            // Thrown by type cast
            throw new ServiceConfigurationException(
                    ERROR_STRING + className + " is not a Context.", ccx);

            // --- Implementation problems --- //
        } catch (IllegalArgumentException argx) {
            /* Thrown by Constructor.newInstance to indicate that formal
             * parameters and provided arguments are not compatible. Since
             * the constructor doesn't take any arguments, and we didn't
             * provide any, we shouldn't be able to get here.
             */
            throw new AssertionError(argx);
        }
    }


    protected Context() {
        // empty
    }



    // -----------------------------------------------------------------------
    // Factory Methods
    // -----------------------------------------------------------------------

    // --- Singleton factories: ----------------------------------------------

    public abstract DomainParticipantFactory getParticipantFactory();

    public abstract DynamicTypeFactory getTypeFactory();

    public abstract DynamicDataFactory getDataFactory();


    // --- Types: ------------------------------------------------------------

    /**
     * Create a new {@link TypeSupport} object for the given physical type.
     * This method is equivalent to:
     * 
     * <code>createTypeSupport(type, type.getClass().getName())</code>
     */
    public abstract <TYPE> TypeSupport<TYPE> createTypeSupport(
            Class<TYPE> type);

    /**
     * Create a new {@link TypeSupport} object for the given physical type.
     * The Service will register this type under the given name with any
     * participant with which the <code>TypeSupport</code> is used.
     * 
     * @param <TYPE>    The physical type of all samples read or written by
     *                  any {@link org.omg.dds.sub.DataReader} or
     *                  {@link org.omg.dds.pub.DataWriter} typed by the
     *                  resulting <code>TypeSupport</code>.
     * @param type      The physical type of all samples read or written by
     *                  any {@link org.omg.dds.sub.DataReader} or
     *                  {@link org.omg.dds.pub.DataWriter} typed by the
     *                  resulting <code>TypeSupport</code>.
     * @param registeredName    The logical name under which this type will
     *                          be registered with any
     *                          {@link org.omg.dds.domain.DomainParticipant}
     *                          with which the resulting
     *                          <code>TypeSupport</code> is used.
     * @return          A new <code>TypeSupport</code> object, which can
     *                  subsequently be used to create one or more
     *                  {@link org.omg.dds.topic.Topic}s.
     * 
     * @see #createTypeSupport(Class)
     */
    public abstract <TYPE> TypeSupport<TYPE> createTypeSupport(
            Class<TYPE> type, String registeredName);


    // --- Time: -------------------------------------------------------------

    public abstract ModifiableDuration createDuration();

    public abstract ModifiableDuration createDuration(int sec, int nanosec);

    public abstract ModifiableTime createTime(long millis);

    public abstract ModifiableTime createTime(int sec, int nanosec);


    // --- Instance handle: --------------------------------------------------

    public abstract InstanceHandle getNilHandle();

    public abstract ModifiableInstanceHandle createInstanceHandle();


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

    public abstract <TYPE>
    LivelinessLostStatus<TYPE> createLivelinessLostStatus();

    public abstract <TYPE>
    OfferedDeadlineMissedStatus<TYPE> createOfferedDeadlineMissedStatus();

    public abstract <TYPE>
    OfferedIncompatibleQosStatus<TYPE> createOfferedIncompatibleQosStatus();

    public abstract <TYPE>
    PublicationMatchedStatus<TYPE> createPublicationMatchedStatus();

    public abstract <TYPE>
    LivelinessChangedStatus<TYPE> createLivelinessChangedStatus();

    public abstract <TYPE>
    RequestedDeadlineMissedStatus<TYPE> createRequestedDeadlineMissedStatus();

    public abstract <TYPE>
    RequestedIncompatibleQosStatus<TYPE> createRequestedIncompatibleQosStatus();

    public abstract <TYPE> SampleLostStatus<TYPE> createSampleLostStatus();

    public abstract <TYPE>
    SampleRejectedStatus<TYPE> createSampleRejectedStatus();

    public abstract <TYPE>
    SubscriptionMatchedStatus<TYPE> createSubscriptionMatchedStatus();

    public abstract <TYPE>
    InconsistentTopicStatus<TYPE> createInconsistentTopicStatus();


    // --- Sample & Instance Life Cycle: -------------------------------------

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
