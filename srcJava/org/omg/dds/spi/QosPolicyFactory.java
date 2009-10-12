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

import org.omg.dds.infrastructure.Entity;
import org.omg.dds.infrastructure.Status;
import org.omg.dds.infrastructure.qos.DestinationOrderQosPolicy;
import org.omg.dds.infrastructure.qos.DurabilityQosPolicy;
import org.omg.dds.infrastructure.qos.HistoryQosPolicy;
import org.omg.dds.infrastructure.qos.LivelinessQosPolicy;
import org.omg.dds.infrastructure.qos.OwnershipQosPolicy;
import org.omg.dds.infrastructure.qos.PresentationQosPolicy;
import org.omg.dds.infrastructure.qos.QosPolicy;
import org.omg.dds.infrastructure.qos.ReliabilityQosPolicy;


/**
 * An implementation-provided factory for classes pertaining to {@link Entity}
 * {@link Status}.
 */
public interface QosPolicyFactory {
    public DestinationOrderQosPolicy.Kind createDestinationOrderQosPolicyKind(
            String name, int ordinal);

    public <POLICY extends QosPolicy<POLICY>> QosPolicy.Id<POLICY>
    createQosPolicyId(
            String enumName, int ordinal, String policyName, int value);

    public DurabilityQosPolicy.Kind createDurabilityQosPolicyKind(
            String name, int ordinal);

    public HistoryQosPolicy.Kind createHistoryQosPolicyKind(
            String name, int ordinal);

    public LivelinessQosPolicy.Kind createLivelinessQosPolicyKind(
            String name, int ordinal);

    public OwnershipQosPolicy.Kind createOwnershipQosPolicyKind(
            String name, int ordinal);

    public PresentationQosPolicy.AccessScopeKind
    createPresentationQosPolicyAccessScopeKind(String name, int ordinal);

    public ReliabilityQosPolicy.Kind createReliabilityQosPolicyKind(
            String name, int ordinal);

}
