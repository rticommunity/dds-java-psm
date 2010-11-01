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
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.omg.dds.core.Duration;
import org.omg.dds.core.Entity;
import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.ModifiableTime;
import org.omg.dds.core.Status;
import org.omg.dds.domain.discovery.ParticipantBuiltinTopicData;
import org.omg.dds.domain.discovery.TopicBuiltinTopicData;
import org.omg.dds.pub.Publisher;
import org.omg.dds.pub.PublisherListener;
import org.omg.dds.pub.PublisherQos;
import org.omg.dds.sub.Subscriber;
import org.omg.dds.sub.SubscriberListener;
import org.omg.dds.sub.SubscriberQos;
import org.omg.dds.topic.ContentFilteredTopic;
import org.omg.dds.topic.MultiTopic;
import org.omg.dds.topic.Topic;
import org.omg.dds.topic.TopicDescription;
import org.omg.dds.topic.TopicListener;
import org.omg.dds.topic.TopicQos;
import org.omg.dds.type.TypeSupport;


public interface DomainParticipant
extends Entity<DomainParticipant,
               DomainParticipantListener,
               DomainParticipantQos> {
    public Publisher createPublisher();
    public Publisher createPublisher(
            PublisherQos qos,
            PublisherListener listener,
            Collection<Status.Kind> status);
    public Publisher createPublisher(
            String qosLibraryName,
            String qosProfileName,
            PublisherListener listener,
            Collection<Status.Kind> status);

    public Subscriber createSubscriber();
    public Subscriber createSubscriber(
            SubscriberQos qos,
            SubscriberListener listener,
            Collection<Status.Kind> status);
    public Subscriber createSubscriber(
            String qosLibraryName,
            String qosProfileName,
            SubscriberListener listener,
            Collection<Status.Kind> status);

    public Subscriber getBuiltinSubscriber();


    // --- Create Topic with implicit TypeSupport: ---------------------------

    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<TYPE> type);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<TYPE> type,
            TopicQos qos,
            TopicListener<TYPE> listener,
            Collection<Status.Kind> status);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<TYPE> type,
            String qosLibraryName,
            String qosProfileName,
            TopicListener<TYPE> listener,
            Collection<Status.Kind> status);


    // --- Create Topic with explicit TypeSupport: ---------------------------

    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            TypeSupport<TYPE> type);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            TypeSupport<TYPE> type,
            TopicQos qos,
            TopicListener<TYPE> listener,
            Collection<Status.Kind> status);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            TypeSupport<TYPE> type,
            String qosLibraryName,
            String qosProfileName,
            TopicListener<TYPE> listener,
            Collection<Status.Kind> status);


    // --- Other operations: -------------------------------------------------

    public <TYPE> Topic<TYPE> findTopic(
            String topicName,
            Duration timeout) throws TimeoutException;
    public <TYPE> Topic<TYPE> findTopic(
            String topicName,
            long timeout,
            TimeUnit unit)
            throws TimeoutException;
    public <TYPE> TopicDescription<TYPE> lookupTopicDescription(String name);

    public <TYPE> ContentFilteredTopic<TYPE> createContentFilteredTopic(
            String name,
            Topic<? extends TYPE> relatedTopic,
            String filterExpression,
            List<String> expressionParameters);

    public <TYPE> MultiTopic<TYPE> createMultiTopic(
            String name,
            String typeName,
            String subscriptionExpression,
            List<String> expressionParameters);

    public void closeContainedEntities();

    public void ignoreParticipant(InstanceHandle handle);
    public void ignoreTopic(InstanceHandle handle);
    public void ignorePublication(InstanceHandle handle);
    public void ignoreSubscription(InstanceHandle handle);

    public int getDomainId();

    public void assertLiveliness();

    public PublisherQos getDefaultPublisherQos();
    public void setDefaultPublisherQos(PublisherQos qos);
    public void setDefaultPublisherQos(
            String qosLibraryName,
            String qosProfileName);

    public SubscriberQos getDefaultSubscriberQos();
    public void setDefaultSubscriberQos(SubscriberQos qos);
    public void setDefaultSubscriberQos(
            String qosLibraryName,
            String qosProfileName);

    public TopicQos getDefaultTopicQos();
    public void setDefaultTopicQos(TopicQos qos);
    public void setDefaultTopicQos(
            String qosLibraryName,
            String qosProfileName);

    public Collection<InstanceHandle> getDiscoveredParticipants(
            Collection<InstanceHandle> participantHandles);
    public ParticipantBuiltinTopicData getDiscoveredParticipantData(
            ParticipantBuiltinTopicData participantData,
            InstanceHandle participantHandle);

    public Collection<InstanceHandle> getDiscoveredTopics(
            Collection<InstanceHandle> topicHandles);
    public TopicBuiltinTopicData getDiscoveredTopicData(
            TopicBuiltinTopicData topicData,
            InstanceHandle topicHandle);

    public boolean containsEntity(InstanceHandle handle);

    public ModifiableTime getCurrentTime(ModifiableTime currentTime);
}
