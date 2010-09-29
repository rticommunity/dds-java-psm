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

import java.util.concurrent.TimeoutException;

import org.omg.dds.core.Context;
import org.omg.dds.core.InstanceHandle;
import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.sub.DataAvailableStatus;
import org.omg.dds.sub.DataReader;
import org.omg.dds.sub.DataReaderAdapter;
import org.omg.dds.sub.DataReaderListener;
import org.omg.dds.sub.Sample;
import org.omg.dds.sub.Subscriber;
import org.omg.dds.topic.Topic;


public class GreetingSubscribingApp {
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

        Subscriber sub = dp.createSubscriber();
        DataReaderListener<Greeting> ls = new MyListener();
        DataReader<Greeting> dr = sub.createDataReader(
                tp,
                sub.getDefaultDataReaderQos(),
                ls);

        try {
            dr.waitForHistoricalData(
                    ctx.createDuration(10, 0)); // wait up to 10 seconds
        } catch (TimeoutException tx) {
            /* XXX: This is how the Java-SE-standard classes indicate timeout.
             * Do we want to follow the same model, and force people to handle
             * this condition? Or do we want to define our own (unchecked)
             * timeout exception?
             * 
             * ON ONE HAND: This may not block, depending on QoS and
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


    private GreetingSubscribingApp() {
        // do nothing
    }



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------

    private static class MyListener extends DataReaderAdapter<Greeting>
    {
        @Override
        public void onDataAvailable(DataAvailableStatus<Greeting> status)
        {
            DataReader<Greeting> dr = status.getSource();
            Sample.Iterator<Greeting> it = dr.take();
            while (it.hasNext()) {
                Sample<Greeting> smp = it.next();
                // SampleInfo stuff is built into Sample:
                InstanceHandle inst = smp.getInstanceHandle();
                // Data accessible from Sample; null if invalid:
                Greeting dt = smp.getData();
                // ...
            }
        }
    }
}
