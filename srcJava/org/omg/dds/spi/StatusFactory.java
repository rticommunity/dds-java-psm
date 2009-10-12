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

package org.omg.dds.spi;

import java.util.Set;

import org.omg.dds.infrastructure.Entity;
import org.omg.dds.infrastructure.Status;
import org.omg.dds.infrastructure.Status.Kind;
import org.omg.dds.publication.LivelinessLostStatus;
import org.omg.dds.publication.OfferedDeadlineMissedStatus;
import org.omg.dds.publication.OfferedIncompatibleQosStatus;
import org.omg.dds.publication.PublicationMatchedStatus;
import org.omg.dds.subscription.LivelinessChangedStatus;
import org.omg.dds.subscription.RequestedDeadlineMissedStatus;
import org.omg.dds.subscription.RequestedIncompatibleQosStatus;
import org.omg.dds.subscription.SampleLostStatus;
import org.omg.dds.subscription.SampleRejectedStatus;
import org.omg.dds.subscription.SubscriptionMatchedStatus;
import org.omg.dds.topic.InconsistentTopicStatus;


/**
 * An implementation-provided factory for classes pertaining to {@link Entity}
 * {@link Status}.
 */
public interface StatusFactory {
    // --- Base type: --------------------------------------------------------

    public <STATUS extends Status<STATUS, ?>> Status.Kind<STATUS>
    createStatusKind(String enumName, int ordinal, int value);

    public Set<Kind<?>> createStatusKindSetAll();

    public Set<Kind<?>> createStatusKindSetNone();

    
    // --- Publication statuses: ---------------------------------------------

    public LivelinessLostStatus createLivelinessLostStatus();

    public OfferedDeadlineMissedStatus createOfferedDeadlineMissedStatus();

    public OfferedIncompatibleQosStatus createOfferedIncompatibleQosStatus();

    public PublicationMatchedStatus createPublicationMatchedStatus();


    // --- Subscription statuses: --------------------------------------------

    public LivelinessChangedStatus createLivelinessChangedStatus();

    public RequestedDeadlineMissedStatus
    createRequestedDeadlineMissedStatus();

    public RequestedIncompatibleQosStatus
    createRequestedIncompatibleQosStatus();

    public SampleLostStatus createSampleLostStatus();

    public SampleRejectedStatus createSampleRejectedStatus();

    public SampleRejectedStatus.Kind createSampleRejectedStatusKind();

    public SubscriptionMatchedStatus createSubscriptionMatchedStatus();

    public InconsistentTopicStatus createInconsistentTopicStatus();

}
