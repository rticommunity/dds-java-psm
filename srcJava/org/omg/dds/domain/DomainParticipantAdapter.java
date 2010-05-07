/* Copyright (c) 2009, Real-Time Innovations, Inc.
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

import org.omg.dds.pub.DataWriter;
import org.omg.dds.pub.LivelinessLostStatus;
import org.omg.dds.pub.OfferedDeadlineMissedStatus;
import org.omg.dds.pub.OfferedIncompatibleQosStatus;
import org.omg.dds.pub.PublicationMatchedStatus;
import org.omg.dds.sub.DataReader;
import org.omg.dds.sub.LivelinessChangedStatus;
import org.omg.dds.sub.RequestedDeadlineMissedStatus;
import org.omg.dds.sub.RequestedIncompatibleQosStatus;
import org.omg.dds.sub.SampleLostStatus;
import org.omg.dds.sub.SampleRejectedStatus;
import org.omg.dds.sub.Subscriber;
import org.omg.dds.sub.SubscriptionMatchedStatus;
import org.omg.dds.topic.InconsistentTopicStatus;
import org.omg.dds.topic.Topic;


public class DomainParticipantAdapter implements DomainParticipantListener
{
    public <TYPE> void onInconsistentTopic(
            Topic<TYPE> the_topic,
            InconsistentTopicStatus status)
    {
        // empty
    }

    public <TYPE, DW extends DataWriter<TYPE>> void onLivelinessLost(
            DW writer,
            LivelinessLostStatus status)
    {
        // empty
    }

    public <TYPE, DW extends DataWriter<TYPE>> void onOfferedDeadlineMissed(
            DW writer,
            OfferedDeadlineMissedStatus status)
    {
        // empty
    }

    public <TYPE, DW extends DataWriter<TYPE>> void onOfferedIncompatibleQos(
            DW writer,
            OfferedIncompatibleQosStatus status)
    {
        // empty
    }

    public <TYPE, DW extends DataWriter<TYPE>> void onPublicationMatched(
            DW writer,
            PublicationMatchedStatus status)
    {
        // empty
    }

    public void onDataOnReaders(Subscriber subscriber)
    {
        // empty
    }

    public <TYPE> void onDataAvailable(DataReader<TYPE> reader)
    {
        // empty
    }

    public <TYPE> void onLivelinessChanged(
            DataReader<TYPE> reader,
            LivelinessChangedStatus status)
    {
        // empty
    }

    public <TYPE> void onRequestedDeadlineMissed(
            DataReader<TYPE> reader,
            RequestedDeadlineMissedStatus status)
    {
        // empty
    }

    public <TYPE> void onRequestedIncompatibleQos(
            DataReader<TYPE> reader,
            RequestedIncompatibleQosStatus status)
    {
        // empty
    }

    public <TYPE> void onSampleLost(
            DataReader<TYPE> reader,
            SampleLostStatus status)
    {
        // empty
    }

    public <TYPE> void onSampleRejected(
            DataReader<TYPE> reader,
            SampleRejectedStatus status)
    {
        // empty
    }

    public <TYPE> void onSubscriptionMatched(
            DataReader<TYPE> reader,
            SubscriptionMatchedStatus status)
    {
        // empty
    }
}
