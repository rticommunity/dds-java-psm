/* Copyright 2011, Object Management Group, Inc.
 * Copyright 2011, PrismTech, Inc.
 * Copyright 2011, Real-Time Innovations, Inc.
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

package org.omg.dds.core.policy;


/**
 * This interface is implemented by QoS policies that enforce a Request/Offer
 * contract between publications and subscriptions -- that is, for which the
 * level of service offered by the publication is greater than or equal to
 * that requested by the subscription.
 * 
 * Details of this contract are provided in each of the implementing types.
 */
public interface RequestedOffered<SELF>
{
    /**
     * Use the object returned by this method to evaluate the Request/Offer
     * relationship with another instance of this policy. If <code>this</code>
     * policy were to be offered by a {@link org.omg.dds.pub.DataWriter} (or
     * {@link org.omg.dds.pub.Publisher}), and the other policy provided to
     * {@link Comparable#compareTo(Object)} were to be requested by a
     * {@link org.omg.dds.sub.DataReader} (or
     * {@link org.omg.dds.sub.Subscriber}), that method will indicate whether
     * the policy offered is less than (i.e. not compatible with), equal to
     * (i.e. compatible with), or greater than (i.e. compatible with) the
     * policy requested.
     * 
     * @return  a {@link Comparable} object capable of evaluating the
     *          Request/Offer relationship between two instances of this QoS
     *          policy.
     */
    public Comparable<SELF> offer();
}
