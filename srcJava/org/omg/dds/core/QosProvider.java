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

import org.omg.dds.pub.PublisherQos;
import org.omg.dds.pub.DataWriterQos;
import org.omg.dds.sub.SubscriberQos;
import org.omg.dds.sub.DataReaderQos;
import org.omg.dds.topic.TopicQos;
import org.omg.dds.core.DDSObject;
import org.omg.dds.domain.DomainParticipantQos;
import org.omg.dds.domain.DomainParticipantFactoryQos;

public abstract interface QosProvider extends DDSObject {

	/**
	 * Get default domain paricipant QoS 
	 * @return Default domain participant QoS defined in the uri passed to 
	 *         the { @link ServiceEnvironement.newQosProvider} method. 
	 */
	
	public DomainParticipantFactoryQos getDomainParticipantFactoryQos();

	/**
	 * Get the first domain paricipant QoS with identifier that matches the id.
	 * @param id The identifier of the domain participant QoS of interest  
	 * @return Domain participant QoS  
	 */

	public DomainParticipantFactoryQos getDomainParticipantFactoryQos(String id);
	
	public DomainParticipantQos getDomainParticipantQos();
	public DomainParticipantQos getDomainParticipantQos(String id);
	
	public TopicQos getTopicQos();
	public TopicQos getTopicQos(String id);
	
	public SubscriberQos getSubscriberQos();
	public SubscriberQos getSubscriberQos(String id);
	
	public PublisherQos getPublisherQos();
	public PublisherQos getPublisherQos(String id);
	
	public DataReaderQos getDataReaderQos();
	public DataReaderQos getDataReaderQos(String id);
	
	public DataWriterQos getDataWriterQos();
	public DataWriterQos getDataWriterQos(String id);
}
