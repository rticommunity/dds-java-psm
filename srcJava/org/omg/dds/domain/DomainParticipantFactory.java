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

import org.omg.dds.core.DDSObject;
import org.omg.dds.core.Status;


public interface DomainParticipantFactory extends DDSObject {
    /**
     * Create a new participant in the domain with ID 0 having default QoS
     * and no listener.
     */
    public DomainParticipant createParticipant();
    public DomainParticipant createParticipant(
            int domainId);
    public DomainParticipant createParticipant(
            int domainId,
            DomainParticipantQos qos);
    public DomainParticipant createParticipant(
            int domainId,
            DomainParticipantQos qos,
            DomainParticipantListener listener);
    public DomainParticipant createParticipant(
            int domainId,
            DomainParticipantQos qos,
            DomainParticipantListener listener,
            Collection<Status.Kind> status);
    public DomainParticipant createParticipant(
            int domainId,
            String qosLibraryName,
            String qosProfileName);
    public DomainParticipant createParticipant(
            int domainId,
            String qosLibraryName,
            String qosProfileName,
            DomainParticipantListener listener);
    public DomainParticipant createParticipant(
            int domainId,
            String qosLibraryName,
            String qosProfileName,
            DomainParticipantListener listener,
            Collection<Status.Kind> status);

    public DomainParticipant lookupParticipant(int domainId);

    public DomainParticipantFactoryQos getQos();
    public void setQos(DomainParticipantFactoryQos qos);

    public DomainParticipantQos getDefaultParticipantQos();
    public void setDefaultParticipantQos(DomainParticipantQos qos);
    public void setDefaultParticipantQos(
            String qosLibraryName,
            String qosProfileName);

}
