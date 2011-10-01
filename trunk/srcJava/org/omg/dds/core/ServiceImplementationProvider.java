/* Copyright 2010, Object Management Group, Inc.
 * Copyright 2010, PrismTech, Inc.
 * Copyright 2010, Real-Time Innovations, Inc.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omg.dds.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.omg.dds.core.modifiable.ModifiableDuration;
import org.omg.dds.core.modifiable.ModifiableInstanceHandle;
import org.omg.dds.core.modifiable.ModifiableTime;
import org.omg.dds.core.status.InconsistentTopicStatus;
import org.omg.dds.core.status.LivelinessChangedStatus;
import org.omg.dds.core.status.LivelinessLostStatus;
import org.omg.dds.core.status.OfferedDeadlineMissedStatus;
import org.omg.dds.core.status.OfferedIncompatibleQosStatus;
import org.omg.dds.core.status.PublicationMatchedStatus;
import org.omg.dds.core.status.RequestedDeadlineMissedStatus;
import org.omg.dds.core.status.RequestedIncompatibleQosStatus;
import org.omg.dds.core.status.SampleLostStatus;
import org.omg.dds.core.status.SampleRejectedStatus;
import org.omg.dds.core.status.Status;
import org.omg.dds.core.status.SubscriptionMatchedStatus;
import org.omg.dds.domain.DomainParticipantFactory;
import org.omg.dds.type.TypeSupport;
import org.omg.dds.type.dynamic.DynamicTypeFactory;


/**
 * DDS implementations are rooted in this class, a concrete subclass
 * of which can be instantiated based on a system property.
 * 
 * All public concrete and abstract methods of this class are reentrant. The
 * reentrancy of any new methods that may be defined by subclasses is
 * unspecified.
 */
public class ServiceImplementationProvider {
    // -----------------------------------------------------------------------
    // Public Fields
    // -----------------------------------------------------------------------

    public static final String IMPLEMENTATION_CLASS_NAME_PROPERTY =
        "org.omg.dds.serviceClassName";



    // -----------------------------------------------------------------------
    // Private Fields
    // -----------------------------------------------------------------------

    private static final String ERROR_STRING =
        "Unable to load OMG DDS implementation. ";


    private static volatile ServiceImplementation _defaultImpl = null;

    private static final ThreadLocal<ServiceImplementation> _implPerThread =
            new ThreadLocal<ServiceImplementation>();



    // -----------------------------------------------------------------------
    // Public Methods
    // -----------------------------------------------------------------------

    /**
     * Get the {@link ServiceImplementation} instance that should be used for
     * creating new objects in the current context. First, check whether a
     * thread-specific instance has been set for the current thread. If so,
     * return it. If not, get the global current instance.
     * 
     * @return  the current {@link ServiceImplementation}. This method will
     *          never return null.
     * 
     * @see     #setCurrentPerThread(ServiceImplementation)
     * @see     #setDefault(ServiceImplementation)
     */
    public static ServiceImplementation getCurrent()
    {
        /* This method is not synchronized. However, synchronization would
         * prevent arbitrary ordering between gets and sets, and interleaving
         * will not corrupt state.
         */
        ServiceImplementation current = _implPerThread.get();
        if (current == null) {
            /* Assign to local variable to avoid race condition in which
             * default is changed or cleared after being checked and before
             * being used.
             */
            current = _defaultImpl;
            if (current == null) {
                _defaultImpl = createDefaultInstance();
            }
        }
        assert current != null;
        return current;
    }


    public static void setCurrentPerThread(ServiceImplementation newCurrent)
    {
        if (newCurrent == null) {
            _implPerThread.remove();
        } else {
            _implPerThread.set(newCurrent);
        }
    }


    public static void setDefault(ServiceImplementation newDefault)
    {
        _defaultImpl = newDefault;
    }


    // -----------------------------------------------------------------------

    /**
     * Create and return a new instance of a concrete implementation of this
     * class with the given environment. This method is equivalent to calling:
     * 
     * <code>
     * createInstance(IMPLEMENTATION_CLASS_NAME_PROPERTY, environment);
     * </code>
     * 
     * @see     #createDefaultInstance()
     * @see     #createInstance(String, Map)
     * @see     #IMPLEMENTATION_CLASS_NAME_PROPERTY
     */
    public static ServiceImplementation createInstance(
            Map<String,
            Object> environment)
    {
        return createInstance(
                IMPLEMENTATION_CLASS_NAME_PROPERTY, environment);
    }


    /**
     * Look up the system property identified by the given string and load,
     * then instantiate, the ServiceImplementation implementation class
     * identified by its value. The class must be accessible and have a
     * public constructor.
     * 
     * The public constructors of the implementation class will first be
     * searched for one accepting a single argument of type {@link Map}. If
     * one is found, it will be called with the <code>environment</code> map
     * provided to this method as its argument. If no such constructor is
     * found, a no-argument constructor will be used instead, and the
     * provided <code>environment</code>, if any, will be ignored. If the
     * implementation class provides no public constructor with either of
     * these signatures, an exception will be thrown.
     * 
     * By default, the class loader for the <code>ServiceImplementation</code>
     * class will be used to load the indicated class. If this class loader
     * is null -- for instance, if it is the bootstrap class loader -- then
     * the system class loader will be used in its place. If it is also null,
     * a <code>ServiceConfigurationException</code> will be thrown.
     * 
     * Neither the class loader nor the loaded class will be cached between
     * invocations of this method. As a result, execution of this method is
     * expected to be relatively expensive. However, as any DDS object can
     * provide a reference to its creating ServiceImplementation via
     * {@link DDSObject#getImplementation()}, executions of this method are
     * also expected to be rare.
     * 
     * @param   implClassNameProperty       The name of a system property,
     *          the value of which will be taken as the name of a
     *          ServiceImplementation implementation class to load.
     * @param   environment                 A collection of name-value pairs
     *          to be provided to the concrete ServiceImplementation
     *          subclass. If that class does not provide a constructor that
     *          can accept this environment, the environment will be ignored.
     *          This argument may be null; a null environment shall be
     *          considered equivalent to an empty map.
     * 
     * @return  A non-null ServiceImplementation.
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
     *          not a ServiceImplementation or that doesn't have a no-argument
     *          constructor).
     * @throws  ServiceInitializationException  If the class was found but
     *          could not be initialized and/or instantiated because of an
     *          error that occurred within its implementation.
     * 
     * @see     #createDefaultInstance()
     * @see     DDSObject#getImplementation()
     * @see     System#getProperty(String)
     * @see     Class#getClassLoader()
     * @see     ClassLoader#getSystemClassLoader()
     * @see     ClassLoader#loadClass(String)
     */
    public static ServiceImplementation createInstance(
            String implClassNameProperty,
            Map<String,
            Object> environment)
    {
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

        try {
            // --- Load implementation class --- //
            /* IMPORTANT: Load class with ClassLoader.loadClass, not with
             * Class.forName. The latter provides insufficient control over
             * the class loader used and also caches class references in
             * undesirable ways, both of which can cause problems in
             * container environments such as OSGi.
             */
            ClassLoader classLoader =
                    ServiceImplementationProvider.class.getClassLoader();
            if (classLoader == null) {
                /* The class loader is the bootstrap class loader, which
                 * is not directly accessible. Substitute the system
                 * class loader.
                 */
                classLoader = ClassLoader.getSystemClassLoader();
                if (classLoader == null) {
                    throw new ServiceConfigurationException(
                        ERROR_STRING +
                            "Incorrect system class loader configuration.");
                }
            }
            Class<?> ctxClass = classLoader.loadClass(className);

            // --- Instantiate new object --- //
            try {
                // First, try a constructor that will accept the environment.
                Constructor<?> ctor = ctxClass.getConstructor(Map.class);
                return (ServiceImplementation) ctor.newInstance(environment);
            } catch (NoSuchMethodException nsmx) {
                /* No Map constructor found; try a no-argument constructor
                 * instead.
                 * 
                 * Get the constructor and call it explicitly rather than
                 * calling Class.newInstance(). The latter propagates all
                 * exceptions, even checked ones, complicating error handling
                 * for us and the user.
                 */
                Constructor<?> ctor = ctxClass.getConstructor(
                        (Class<?>[]) null);
                return (ServiceImplementation) ctor.newInstance(
                        (Object[]) null);
            }

            // --- Initialization problems --- //
        } catch (ExceptionInInitializerError initx) {
            // Presumably thrown by ClassLoader.loadClass, but not documented.
            // Thrown by Constructor.newInstance.
            throw new ServiceInitializationException(
                    ERROR_STRING + "Error during static initialization.",
                    initx.getCause());
        } catch (InvocationTargetException itx) {
            // Thrown by Constructor.newInstance
            throw new ServiceInitializationException(
                    ERROR_STRING + "Error during object initialization.",
                    itx.getCause());

            // --- Configuration problems --- //
        } catch (IllegalStateException isx) {
            // Thrown by ClassLoader.getSystemClassLoader.
            throw new ServiceConfigurationException(ERROR_STRING, isx);
        } catch (ClassNotFoundException cnfx) {
            // Thrown by ClassLoader.loadClass.
            throw new ServiceConfigurationException(
                    ERROR_STRING + className + " was not found.",
                    cnfx);
        } catch (LinkageError linkx) {
            // Presumably thrown by ClassLoader.loadClass, but not documented.
            throw new ServiceConfigurationException(
                    ERROR_STRING + className + " could not be loaded.",
                    linkx);
        } catch (NoSuchMethodException nsmx) {
            // Thrown by Class.getConstructor: no no-argument constructor
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
            // Thrown by ClassLoader.getSystemClassLoader.
            // Thrown by Class.getConstructor.
            throw new ServiceConfigurationException(
                    ERROR_STRING + "Prevented by security manager.", sx);
        } catch (ClassCastException ccx) {
            // Thrown by type cast
            throw new ServiceConfigurationException(
                    ERROR_STRING + className +
                        " is not a ServiceImplementation.", ccx);

            // --- Implementation problems --- //
        } catch (IllegalArgumentException argx) {
            /* Thrown by Constructor.newInstance to indicate that formal
             * parameters and provided arguments are not compatible. Since
             * the constructor doesn't take any arguments, and we didn't
             * provide any, we shouldn't be able to get here.
             */
            throw new AssertionError(argx);
        }
        /* If any other RuntimeException or Error gets thrown above, it's
         * either a bug in the implementation of this method or an
         * undocumented behavior of the Java standard library. In either
         * case, there's not much we can do about it, so let the exception
         * propagate up the call stack as-is.
         */
    }



    // -----------------------------------------------------------------------
    // Private Methods
    // -----------------------------------------------------------------------

    /**
     * Create and return a new instance of a concrete implementation of this
     * class. This method is equivalent to calling:
     * 
     * <code>createInstance((Map) null);</code>
     * 
     * @see     #createInstance(Map)
     * @see     #createInstance(String, Map)
     * @see     #IMPLEMENTATION_CLASS_NAME_PROPERTY
     */
    private static ServiceImplementation createDefaultInstance()
    {
        return createInstance(null);
    }


    // --- Object Life Cycle: ------------------------------------------------

    private ServiceImplementationProvider()
    {
        // prevent construction
    }



    // -----------------------------------------------------------------------
    // Service-Provider Interface
    // -----------------------------------------------------------------------

    /**
     * This interface is for the use of the DDS implementation, not of DDS
     * applications. It simplifies the creation of objects of certain types in
     * the DDS API.
     */
    public static interface ServiceImplementation {
        // --- Singleton factories: ------------------------------------------

        public abstract DomainParticipantFactory getParticipantFactory();

        public abstract DynamicTypeFactory getTypeFactory();


        // --- Types: --------------------------------------------------------

        /**
         * Create a new {@link TypeSupport} object for the given physical
         * type. The Service will register this type under the given name
         * with any participant with which the <code>TypeSupport</code> is
         * used.
         * 
         * @param <TYPE>    The physical type of all samples read or written
         *                  by any {@link org.omg.dds.sub.DataReader} or
         *                  {@link org.omg.dds.pub.DataWriter} typed by the
         *                  resulting <code>TypeSupport</code>.
         * @param type      The physical type of all samples read or written
         *                  by any {@link org.omg.dds.sub.DataReader} or
         *                  {@link org.omg.dds.pub.DataWriter} typed by the
         *                  resulting <code>TypeSupport</code>.
         * @param registeredName    The logical name under which this type
         *                  will be registered with any
         *                  {@link org.omg.dds.domain.DomainParticipant}
         *                  with which the resulting
         *                  <code>TypeSupport</code> is used.
         * @return          A new <code>TypeSupport</code> object, which can
         *                  subsequently be used to create one or more
         *                  {@link org.omg.dds.topic.Topic}s.
         */
        public abstract <TYPE> TypeSupport<TYPE> newTypeSupport(
                Class<TYPE> type, String registeredName);


        // --- Time & Duration: ----------------------------------------------

        /**
         * Construct a {@link Duration} of the given magnitude.
         * 
         * A duration of magnitude {@link Long#MAX_VALUE} indicates an
         * infinite duration, regardless of the units specified.
         */
        public abstract ModifiableDuration newDuration(
                long duration, TimeUnit unit);

        /**
         * @return      A {@link Duration} of infinite length.
         */
        public abstract Duration infiniteDuration();

        /**
         * @return      A {@link Duration} of zero length.
         */
        public abstract Duration zeroDuration();

        /**
         * Construct a specific instant in time.
         * 
         * Negative values are considered invalid and will result in the
         * construction of a time <code>t</code> such that:
         * 
         * <code>t.isValid() == false</code>
         */
        public abstract ModifiableTime newTime(long time, TimeUnit units);

        /**
         * @return      A {@link Time} that is not valid.
         */
        public abstract Time invalidTime();


        // --- Instance handle: ----------------------------------------------

        public abstract ModifiableInstanceHandle newInstanceHandle();

        public abstract InstanceHandle nilHandle();


        // --- Conditions & WaitSet: -----------------------------------------

        public abstract GuardCondition newGuardCondition();

        public abstract WaitSet newWaitSet();


        // --- Status: -------------------------------------------------------

        public abstract Set<Class<? extends Status<?>>> allStatusKinds();

        public abstract Set<Class<? extends Status<?>>> noStatusKinds();

        public abstract LivelinessLostStatus newLivelinessLostStatus();

        public abstract OfferedDeadlineMissedStatus
        newOfferedDeadlineMissedStatus();

        public abstract OfferedIncompatibleQosStatus
        newOfferedIncompatibleQosStatus();

        public abstract PublicationMatchedStatus
        newPublicationMatchedStatus();

        public abstract LivelinessChangedStatus newLivelinessChangedStatus();

        public abstract RequestedDeadlineMissedStatus
        newRequestedDeadlineMissedStatus();

        public abstract RequestedIncompatibleQosStatus
        newRequestedIncompatibleQosStatus();

        public abstract SampleLostStatus newSampleLostStatus();

        public abstract SampleRejectedStatus newSampleRejectedStatus();

        public abstract SubscriptionMatchedStatus
        newSubscriptionMatchedStatus();

        public abstract InconsistentTopicStatus newInconsistentTopicStatus();
    }
}