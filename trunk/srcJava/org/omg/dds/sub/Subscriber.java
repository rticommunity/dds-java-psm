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

package org.omg.dds.sub;

import java.util.Set;

import org.omg.dds.core.DomainEntity;
import org.omg.dds.core.Status;
import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.topic.TopicDescription;
import org.omg.dds.topic.TopicQos;


public interface Subscriber
extends DomainEntity<Subscriber,
                     DomainParticipant,
                     SubscriberListener,
                     SubscriberQos> {
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic);
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic,
            DataReaderQos qos);
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic,
            DataReaderQos qos,
            DataReaderListener listener);
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic,
            DataReaderQos qos,
            DataReaderListener listener,
            Set<Status.Kind> statuses);
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic,
            String qosLibraryName,
            String qosProfileName);
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic,
            String qosLibraryName,
            String qosProfileName,
            DataReaderListener listener);
    public <TYPE> DataReader<TYPE> createDataReader(
            TopicDescription<TYPE> topic,
            String qosLibraryName,
            String qosProfileName,
            DataReaderListener listener,
            Set<Status.Kind> statuses);

    public void closeContainedEntities();

    public <TYPE> DataReader<TYPE> lookupDataReader(String topicName);
    public <TYPE> DataReader<TYPE> lookupDataReader(
            TopicDescription<TYPE> topicName);

    public void getDataReaders(
            Set<DataReader<?>> readers);
    public void getDataReaders(
            Set<DataReader<?>> readers,
            Set<SampleState> sampleStates,
            Set<ViewState> viewStates,
            Set<InstanceState> instanceStates);

    public void notifyDataReaders();

    public void beginAccess();
    public void endAccess();

    public void cloneDefaultDataReaderQos(DataReaderQos qos);
    public void getDefaultDataReaderQos(DataReaderQos qos);
    public void setDefaultDataReaderQos(DataReaderQos qos);
    public void setDefaultDataReaderQos(
            String qosLibraryName,
            String qosProfileName);

    public void copyFromTopicQos(DataReaderQos dst, TopicQos src);
}
