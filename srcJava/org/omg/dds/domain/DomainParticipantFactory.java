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

package org.omg.dds.domain;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.omg.dds.core.DDSObject;
import org.omg.dds.core.Duration;
import org.omg.dds.core.Entity;
import org.omg.dds.core.GuardCondition;
import org.omg.dds.core.InconsistentPolicyException;
import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.ModifiableInstanceHandle;
import org.omg.dds.core.ModifiableTime;
import org.omg.dds.core.QosProvider;
import org.omg.dds.core.ServiceEnvironment;
import org.omg.dds.core.Time;
import org.omg.dds.core.WaitSet;
import org.omg.dds.core.policy.PolicyFactory;
import org.omg.dds.core.status.Status;
import org.omg.dds.type.TypeSupport;
import org.omg.dds.type.dynamic.DynamicTypeFactory;


/**
 * The sole purpose of this class is to allow the creation and destruction of
 * {@link DomainParticipant} objects. DomainParticipantFactory itself has no
 * factory. It is a pre-existing per-{@link ServiceEnvironment} singleton
 * object that can be accessed by means of the
 * {@link #getInstance(ServiceEnvironment)} operation.
 */
public abstract class DomainParticipantFactory implements DDSObject
{
    // -----------------------------------------------------------------------
    // Singleton Access
    // -----------------------------------------------------------------------

    /**
     * This operation returns the per-ServiceEnvironment
     * DomainParticipantFactory singleton. The operation is idempotent, that
     * is, it can be called multiple times without side effects, and each
     * time it will return a DomainParticipantFactory instance that is equal
     * to the previous results.
     * 
     * @param env       Identifies the Service instance to which the
     *                  object will belong.
     */
    public static DomainParticipantFactory getInstance(ServiceEnvironment env)
    {
        return env.getSPI().getParticipantFactory();
    }



    // -----------------------------------------------------------------------
    // Instance Methods
    // -----------------------------------------------------------------------

    /**
     * Create a new participant in the domain with ID 0 having default QoS
     * and no listener.
     * 
     * @see     #createParticipant(int)
     * @see     #createParticipant(int, DomainParticipantQos, DomainParticipantListener, Collection)
     */
    public abstract DomainParticipant createParticipant();

    /**
     * This operation creates a new DomainParticipant object. The
     * DomainParticipant signifies that the calling application intends to
     * join the domain identified by the domainId argument.
     * 
     * @see     #createParticipant()
     * @see     #createParticipant(int, DomainParticipantQos, DomainParticipantListener, Collection)
     */
    public abstract DomainParticipant createParticipant(
            int domainId);

    /**
     * This operation creates a new DomainParticipant object having default
     * QoS and no listener. The DomainParticipant signifies that the calling
     * application intends to join the domain identified by the domainId
     * argument.
     * 
     * @param statuses  Of which status changes the listener should be
     *                  notified. A null collection signifies all status
     *                  changes.
     *
     * @throws  InconsistentPolicyException     if the specified QoS policies
     *          are not consistent.
     *
     * @see     #createParticipant()
     * @see     #createParticipant(int)
     */
    public abstract DomainParticipant createParticipant(
            int domainId,
            DomainParticipantQos qos,
            DomainParticipantListener listener,
            Collection<Class<? extends Status>> statuses);

    /**
     * This operation retrieves a previously created DomainParticipant
     * belonging to specified domain ID. If no such DomainParticipant exists,
     * the operation will return null.
     * 
     * If multiple DomainParticipant entities belonging to that domain ID
     * exist, then the operation will return one of them. It is not specified
     * which one.
     */
    public abstract DomainParticipant lookupParticipant(int domainId);

    /**
     * This operation returns the value of the DomainParticipantFactory QoS
     * policies.
     * 
     * @see     #setQos(DomainParticipantFactoryQos)
     */
    public abstract DomainParticipantFactoryQos getQos();

    /**
     * This operation sets the value of the DomainParticipantFactory QoS
     * policies. These policies control the behavior of the object, a factory
     * for entities.
     * 
     * Note that despite having QoS, the DomainParticipantFactory is not an
     * {@link Entity}.
     * 
     * @throws  InconsistentPolicyException     if the resulting policies are
     *          not self consistent; in that case, the operation will have no
     *          effect.
     *
     * @see     #getQos()
     */
    public abstract void setQos(DomainParticipantFactoryQos qos);

    /**
     * This operation retrieves the default value of the DomainParticipant
     * QoS, that is, the QoS policies which will be used for newly created
     * {@link DomainParticipant} entities in the case where the QoS policies
     * are defaulted in the {@link #createParticipant()} operation.
     * 
     * The values retrieved will match the set of values specified on the
     * last successful call to
     * {@link #setDefaultParticipantQos(DomainParticipantQos)}, or else, if
     * the call was never made, the default values identified by the DDS
     * specification.
     * 
     * @see     #setDefaultParticipantQos(DomainParticipantQos)
     */
    public abstract DomainParticipantQos getDefaultParticipantQos();

    /**
     * This operation sets a default value of the DomainParticipant QoS
     * policies which will be used for newly created
     * {@link DomainParticipant} entities in the case where the QoS policies
     * are defaulted in the {@link #createParticipant()} operation.
     * 
     * @throws  InconsistentPolicyException     if the resulting policies are
     *          not self consistent; in that case, the operation will have no
     *          effect.
     *
     * @see     #getDefaultParticipantQos()
     */
    
    public abstract void setDefaultParticipantQos(DomainParticipantQos qos);
    
    /**
     * Create a new TypeSupport object for the given physical type.
     * 
     * @return A DynamicTypeFactory instance
     */
    public abstract DynamicTypeFactory getDynamicTypeFactory();
    
    /**
     * Create a new WaitSet.
     * @return A new WaitSet.
     */
    
    public abstract WaitSet createWaitSet();

    /**
     * Create a new Guard condition
     * @return A new GuardCondition
     */
    public abstract GuardCondition createGuardCondition();

    /**
     * Create a new TypeSupport object for the given physical type.
     * 
     * @see #createTypeSupport(Class, String)
     */
    public abstract <TYPE> TypeSupport<TYPE> createTypeSupport(Class<TYPE> type);
    
    /**
     * Create a new TypeSupport object for the given physical type.
     * The Service will register this type under the given name with any
     * participant with which the TypeSupport is used.
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
     * 
     * @return          A new <code>TypeSupport</code> object, which can
     *                  subsequently be used to create one or more
     *                  {@link org.omg.dds.topic.Topic}s.
     * 
     * @see #createTypeSupport(Class)
     */
    public abstract <TYPE> TypeSupport<TYPE> createTypeSupport(
            Class<TYPE> type,
            String registeredName);
    
    /**
     * Construct a specific instant in time.
     * 
     * Negative values are considered invalid and will result in the
     * construction of a time <code>t</code> such that:
     * 
     * @see     org.omg.dds.core.Time#isValid()
     */
    public abstract ModifiableTime createTime(long time, TimeUnit units);

    /**
     * @return      An unmodifiable {@link Time} that is not valid.
     */
    public abstract Time invalidTime();

    /**
     * Construct a time duration of the given magnitude.
     * 
     * A duration of magnitude {@link Long#MAX_VALUE} indicates an infinite
     * duration, regardless of the units specified.
     * 
     * @see     org.omg.dds.core.Duration#isInfinite()
     * @see     #infiniteDuration()
     */
    public abstract Duration createDuration(
            long duration,
            TimeUnit unit);

    /**
     * @return  An unmodifiable {@link Duration} of infinite length.
     */
    public abstract Duration infiniteDuration();

    /**
     * @return  A {@link Duration} of zero length.
     */
    public abstract Duration zeroDuration();

    /**
     * 
     * @return A modifiable instance handle.
     */
    public abstract ModifiableInstanceHandle createInstanceHandle();

    /**
     * @return  An unmodifiable nil instance handle.
     */
    public abstract InstanceHandle nilHandle();
    
    /**
     * 
     * @return Create a new policy  factory
     */
    public abstract PolicyFactory createPolicyFactory();	
    
    /**
     * 
     * @param uri The source of Qos configuration file
     * @param profile The name of the profile in the file specified by uri.
     * @return A new QoSProvider
     */
    public abstract QosProvider createQosProvider(String uri, String profile);	
}
