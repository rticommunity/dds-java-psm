/* Copyright (c) 2009-2010, Real-Time Innovations, Inc.
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

package org.omg.dds.domain;

import java.util.List;
import java.util.Set;

import org.omg.dds.core.Duration;
import org.omg.dds.core.Entity;
import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.Status;
import org.omg.dds.core.Time;
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


public interface DomainParticipant
extends Entity<DomainParticipant,
               DomainParticipantListener,
               DomainParticipantQos> {
    public Publisher createPublisher();
    public Publisher createPublisher(
            PublisherQos qos);
    public Publisher createPublisher(
            PublisherQos qos,
            PublisherListener listener);
    public Publisher createPublisher(
            PublisherQos qos,
            PublisherListener listener,
            Set<Status.Kind> status);
    public Publisher createPublisher(
            String qosLibraryName,
            String qosProfileName);
    public Publisher createPublisher(
            String qosLibraryName,
            String qosProfileName,
            PublisherListener listener);
    public Publisher createPublisher(
            String qosLibraryName,
            String qosProfileName,
            PublisherListener listener,
            Set<Status.Kind> status);

    public Subscriber createSubscriber();
    public Subscriber createSubscriber(
            SubscriberQos qos);
    public Subscriber createSubscriber(
            SubscriberQos qos,
            SubscriberListener listener);
    public Subscriber createSubscriber(
            SubscriberQos qos,
            SubscriberListener listener,
            Set<Status.Kind> status);
    public Subscriber createSubscriber(
            String qosLibraryName,
            String qosProfileName);
    public Subscriber createSubscriber(
            String qosLibraryName,
            String qosProfileName,
            SubscriberListener listener);
    public Subscriber createSubscriber(
            String qosLibraryName,
            String qosProfileName,
            SubscriberListener listener,
            Set<Status.Kind> status);

    public Subscriber getBuiltinSubscriber();

    // TODO: How do we constrain the Topic's type parameter?
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            String typeName);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            String typeName,
            TopicQos qos);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            String typeName,
            TopicQos qos,
            TopicListener listener);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            String typeName,
            TopicQos qos,
            TopicListener listener,
            Set<Status.Kind> status);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            String typeName,
            String qosLibraryName,
            String qosProfileName);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            String typeName,
            String qosLibraryName,
            String qosProfileName,
            TopicListener listener);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            String typeName,
            String qosLibraryName,
            String qosProfileName,
            TopicListener listener,
            Set<Status.Kind> status);

    /**
     * Implicitly register the given type, if necessary, under its fully
     * qualified name and then create a topic of that type.
     */
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<? super TYPE> type);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<? super TYPE> type,
            TopicQos qos);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<? super TYPE> type,
            TopicQos qos,
            TopicListener listener);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<? super TYPE> type,
            TopicQos qos,
            TopicListener listener,
            Set<Status.Kind> status);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<? super TYPE> type,
            String qosLibraryName,
            String qosProfileName);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<? super TYPE> type,
            String qosLibraryName,
            String qosProfileName,
            TopicListener listener);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<? super TYPE> type,
            String qosLibraryName,
            String qosProfileName,
            TopicListener listener,
            Set<Status.Kind> status);

    // TODO: How do we constrain the Topic's type parameter?
    public <TYPE> Topic<TYPE> findTopic(
            String topicName,
            Duration timeout);
    public <TYPE> Topic<TYPE> findTopic(
            String topicName,
            long millis);
    public <TYPE> TopicDescription<TYPE> lookupTopicDescription(String name);

    public <TYPE> ContentFilteredTopic<TYPE> createContentFilteredTopic(
            String name,
            Topic<? extends TYPE> relatedTopic,
            String filterExpression,
            List<String> expressionParameters);
    public <TYPE> ContentFilteredTopic<TYPE> createContentFilteredTopic(
            String name,
            Topic<? extends TYPE> relatedTopic,
            String filterExpression,
            String... expressionParameters);

    public <TYPE> MultiTopic<TYPE> createMultiTopic(
            String name,
            String typeName,
            String subscriptionExpression,
            List<String> expressionParameters);
    public <TYPE> MultiTopic<TYPE> createMultiTopic(
            String name,
            String typeName,
            String subscriptionExpression,
            String... expressionParameters);

    public void closeContainedEntities();

    public void ignoreParticipant(InstanceHandle handle);
    public void ignoreTopic(InstanceHandle handle);
    public void ignorePublication(InstanceHandle handle);
    public void ignoreSubscription(InstanceHandle handle);

    public int getDomainId();

    public void assertLiveliness();

    public PublisherQos cloneDefaultPublisherQos();
    public void getDefaultPublisherQos(PublisherQos qos);
    public void setDefaultPublisherQos(PublisherQos qos);
    public void setDefaultPublisherQos(
            String qosLibraryName,
            String qosProfileName);

    public SubscriberQos cloneDefaultSubscriberQos();
    public void getDefaultSubscriberQos(SubscriberQos qos);
    public void setDefaultSubscriberQos(SubscriberQos qos);
    public void setDefaultSubscriberQos(
            String qosLibraryName,
            String qosProfileName);

    public TopicQos cloneDefaultTopicQos();
    public void getDefaultTopicQos(TopicQos qos);
    public void setDefaultTopicQos(TopicQos qos);
    public void setDefaultTopicQos(
            String qosLibraryName,
            String qosProfileName);

    public void getDiscoveredParticipants(
            List<InstanceHandle> participantHandles);
    public ParticipantBuiltinTopicData cloneDiscoveredParticipantData(
            InstanceHandle participantHandle);
    public void getDiscoveredParticipantData(
            ParticipantBuiltinTopicData participantData,
            InstanceHandle participantHandle);

    public void getDiscoveredTopics(List<InstanceHandle> topicHandles);
    public TopicBuiltinTopicData cloneDiscoveredTopicData(
            InstanceHandle topicHandle);
    public void getDiscoveredTopicData(
            TopicBuiltinTopicData topicData,
            InstanceHandle topicHandle);

    public boolean containsEntity(InstanceHandle handle);

    public void getCurrentTime(Time currentTime);
}
