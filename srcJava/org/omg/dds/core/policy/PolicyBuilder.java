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

package org.omg.dds.core.policy;

import org.omg.dds.pub.PublisherQos;
import org.omg.dds.pub.DataWriterQos;
import org.omg.dds.sub.SubscriberQos;
import org.omg.dds.sub.DataReaderQos;
import org.omg.dds.topic.TopicQos;
import org.omg.dds.core.DDSObject;
import org.omg.dds.domain.DomainParticipantQos;
import org.omg.dds.domain.DomainParticipantFactoryQos;

public abstract class PolicyBuilder implements DDSObject {

	/**
	 * This operation loads a policy builder class that implements the {@link PolicyBuilder} interface.  
	 * @param policyBuilderClassName the name of the policy builder class. 
	 * @param classLoader custom class loader if any.
	 * @return A instance of the policy builder class.
	 * @throws IllegalAccessException See {@link java.lang.ClassLoader}
	 * @throws ClassNotFoundException {@link java.lang.ClassLoader}
	 * @throws InstantiationException {@link java.lang.ClassLoader}
	 */
	
	public static PolicyBuilder load (java.lang.String policyBuilderClassName, java.lang.ClassLoader classLoader) 
			throws IllegalAccessException, ClassNotFoundException, InstantiationException 
	{
		if (classLoader == null) {
			classLoader = PolicyBuilder.class.getClassLoader();
		}
		
        return (PolicyBuilder) classLoader.loadClass(policyBuilderClassName).newInstance();
	}

	/**
	 * This operation loads a policy builder class that implements the {@link PolicyBuilder} interface.  
	 * @param policyBuilderClassName the name of the policy builder class. 
	 * @return A instance of the policy builder class.
	 * @throws IllegalAccessException See {@link java.lang.ClassLoader}
	 * @throws ClassNotFoundException {@link java.lang.ClassLoader}
	 * @throws InstantiationException {@link java.lang.ClassLoader}
	 */

	public static PolicyBuilder load (java.lang.String policyBuilderClassName) 
			throws IllegalAccessException, ClassNotFoundException, InstantiationException 
	{
        return (PolicyBuilder) PolicyBuilder.class.getClassLoader().loadClass(policyBuilderClassName).newInstance();
	}
	
	public abstract DomainParticipantFactoryQos getDomainParticipantFactoryQos(String libraryName, String profileName);
	
	public abstract DomainParticipantQos getDomainParticipantQos(String libraryName, String profileName);
	
	public abstract TopicQos getTopicQos(String libraryName, String profileName);
	
	public abstract SubscriberQos getSubscriberQos(String libraryName, String profileName);
	
	public abstract PublisherQos getPublisherQos(String libraryName, String profileName);
	
	public abstract DataReaderQos getDataReaderQos(String libraryName, String profileName);
	
	public abstract DataWriterQos getDataWriterQos(String libraryName, String profileName);
}
