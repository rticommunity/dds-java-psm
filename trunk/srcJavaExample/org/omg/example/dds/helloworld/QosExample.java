/* Copyright (c) 2009-2010, Real-Time Innovations, Inc.
 * Copyright (c) 2010, Object Management Group, Inc.
 * Copyright (c) 2010, PrismTech, Inc.
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
 * - Neither the names of the above copyright holders nor the names of their
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL A COPYRIGHT HOLDER OR CONTRIBUTOR BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.omg.example.dds.helloworld;

import org.omg.dds.core.Context;
import org.omg.dds.core.policy.EntityFactoryQosPolicy;
import org.omg.dds.core.policy.ModifiableEntityFactoryQosPolicy;
import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.domain.DomainParticipantQos;
import org.omg.dds.domain.ModifiableDomainParticipantQos;


public final class QosExample {
    public static void main(String[] args) {
        Context ctx = Context.createInstance();
        DomainParticipant dp =
            ctx.getParticipantFactory().createParticipant();

        // Get unmodifiable QoS for inspection:
        DomainParticipantQos dpqUnmod = dp.getQos();
        EntityFactoryQosPolicy polUnmod = dpqUnmod.getEntityFactory();
        System.out.println(polUnmod);

        // Set QoS:
        ModifiableDomainParticipantQos dpqMod = dpqUnmod.modify();
        ModifiableEntityFactoryQosPolicy polMod = dpqMod.getEntityFactory();
        polMod.setAutoEnableCreatedEntities(false);
        dp.setQos(dpqMod);

        // Concise version:
        dpqMod = dp.getQos().modify();
        dpqMod.getEntityFactory().setAutoEnableCreatedEntities(false);
        dp.setQos(dpqMod);

        // Restore QoS to default:
        dp.setQos(ctx.getParticipantFactory().getDefaultParticipantQos());
    }


    private QosExample() {
        // do nothing
    }
}
