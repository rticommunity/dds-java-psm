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

import org.omg.dds.core.Bootstrap;
import org.omg.dds.core.DDSObject;
import org.omg.dds.core.status.Status;


public abstract class DomainParticipantFactory implements DDSObject
{
    // -----------------------------------------------------------------------
    // Singleton Access
    // -----------------------------------------------------------------------

    /**
     * @param bootstrap Identifies the Service instance to which the
     *                  object will belong.
     */
    public static DomainParticipantFactory getInstance(Bootstrap bootstrap) {
        return bootstrap.getSPI().getParticipantFactory();
    }



    // -----------------------------------------------------------------------
    // Instance Methods
    // -----------------------------------------------------------------------

    /**
     * Create a new participant in the domain with ID 0 having default QoS
     * and no listener.
     */
    public abstract DomainParticipant createParticipant();
    public abstract DomainParticipant createParticipant(
            int domainId);
    public abstract DomainParticipant createParticipant(
            int domainId,
            DomainParticipantQos qos,
            DomainParticipantListener listener,
            Collection<Status.Kind> status);
    public abstract DomainParticipant createParticipant(
            int domainId,
            String qosLibraryName,
            String qosProfileName,
            DomainParticipantListener listener,
            Collection<Status.Kind> status);

    public abstract DomainParticipant lookupParticipant(int domainId);

    public abstract DomainParticipantFactoryQos getQos();
    public abstract void setQos(DomainParticipantFactoryQos qos);

    public abstract DomainParticipantQos getDefaultParticipantQos();
    public abstract void setDefaultParticipantQos(DomainParticipantQos qos);
    public abstract void setDefaultParticipantQos(
            String qosLibraryName,
            String qosProfileName);

}
