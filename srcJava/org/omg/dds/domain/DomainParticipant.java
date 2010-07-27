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

import java.util.Collection;
import java.util.List;
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
            PublisherQos qos);
    public Publisher createPublisher(
            PublisherQos qos,
            PublisherListener listener);
    public Publisher createPublisher(
            PublisherQos qos,
            PublisherListener listener,
            Collection<Status.Kind> status);
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
            Collection<Status.Kind> status);

    public Subscriber createSubscriber();
    public Subscriber createSubscriber(
            SubscriberQos qos);
    public Subscriber createSubscriber(
            SubscriberQos qos,
            SubscriberListener listener);
    public Subscriber createSubscriber(
            SubscriberQos qos,
            SubscriberListener listener,
            Collection<Status.Kind> status);
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
            Collection<Status.Kind> status);

    public Subscriber getBuiltinSubscriber();


    // --- Create Topic with implicit TypeSupport: ---------------------------

    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<TYPE> type);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<TYPE> type,
            TopicQos qos);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<TYPE> type,
            TopicQos qos,
            TopicListener<TYPE> listener);
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
            String qosProfileName);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            Class<TYPE> type,
            String qosLibraryName,
            String qosProfileName,
            TopicListener<TYPE> listener);
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
            TopicQos qos);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            TypeSupport<TYPE> type,
            TopicQos qos,
            TopicListener<TYPE> listener);
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
            String qosProfileName);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            TypeSupport<TYPE> type,
            String qosLibraryName,
            String qosProfileName,
            TopicListener<TYPE> listener);
    public <TYPE> Topic<TYPE> createTopic(
            String topicName,
            TypeSupport<TYPE> type,
            String qosLibraryName,
            String qosProfileName,
            TopicListener<TYPE> listener,
            Collection<Status.Kind> status);


    // --- Other operations: -------------------------------------------------

    // TODO: How do we constrain the Topic's type parameter?
    public <TYPE> Topic<TYPE> findTopic(
            String topicName,
            Duration timeout) throws TimeoutException;
    public <TYPE> Topic<TYPE> findTopic(
            String topicName,
            long millis) throws TimeoutException;
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

    public void getDiscoveredParticipants(
            Collection<InstanceHandle> participantHandles);
    public void getDiscoveredParticipantData(
            ParticipantBuiltinTopicData participantData,
            InstanceHandle participantHandle);

    public void getDiscoveredTopics(Collection<InstanceHandle> topicHandles);
    public void getDiscoveredTopicData(
            TopicBuiltinTopicData topicData,
            InstanceHandle topicHandle);

    public boolean containsEntity(InstanceHandle handle);

    public void getCurrentTime(ModifiableTime currentTime);
}
