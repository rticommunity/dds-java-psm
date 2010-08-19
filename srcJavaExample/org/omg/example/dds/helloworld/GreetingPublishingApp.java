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
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.omg.example.dds.helloworld;

import java.util.concurrent.TimeoutException;

import org.omg.dds.core.Context;
import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.pub.Publisher;
import org.omg.dds.topic.Topic;


public class GreetingPublishingApp {
    public static void main(String[] args) {
        Context ctx = Context.createInstance();
        DomainParticipant dp =
            ctx.getParticipantFactory().createParticipant();

        // Implicitly create TypeSupport and register type:
        Topic<Greeting> tp = dp.createTopic("My Topic", Greeting.class);
        // OR explicitly create TypeSupport, registered with default name:
        // Topic<Greeting> tp = dp.createTopic(
        //         "My Topic",
        //         ctx.createTypeSupport(Greeting.class));
        // OR explicitly create TypeSupport, registered with custom name:
        // Topic<Greeting> tp = dp.createTopic(
        //         "My Topic",
        //         ctx.createTypeSupport(Greeting.class, "MyType"));

        Publisher pub = dp.createPublisher();
        DataWriter<Greeting> dw = pub.createDataWriter(tp);

        try {
            dw.write(new Greeting("Hello, World"));
        } catch (TimeoutException tx) {
            /* XXX: This is how the Java-SE-standard classes indicate timeout.
             * Do we want to follow the same model, and force people to handle
             * this condition? Or do we want to define our own (unchecked)
             * timeout exception?
             * 
             * ON ONE HAND: Writing may not block, depending on QoS and
             * network conditions. Handling this exception here is annoying.
             * 
             * ON THE OTHER HAND: Users may not have a full understanding of
             * whether a given invocation is likely to block or not. If they
             * get it wrong, the result could be bad. We can help by forcing
             * them to think about this.
             */
            tx.printStackTrace();
        }

        dp.close();
    }


    private GreetingPublishingApp() {
        // do nothing
    }
}
