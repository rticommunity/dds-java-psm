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

package org.omg.dds.sub;

import java.util.EventListener;

import org.omg.dds.core.status.DataAvailableEvent;
import org.omg.dds.core.status.DataOnReadersEvent;
import org.omg.dds.core.status.LivelinessChangedEvent;
import org.omg.dds.core.status.RequestedDeadlineMissedEvent;
import org.omg.dds.core.status.RequestedIncompatibleQosEvent;
import org.omg.dds.core.status.SampleLostEvent;
import org.omg.dds.core.status.SampleRejectedEvent;
import org.omg.dds.core.status.SubscriptionMatchedEvent;


/**
 * Since a {@link org.omg.dds.sub.Subscriber} is a kind of {@link org.omg.dds.core.Entity}, it has the ability
 * to have an associated listener. In this case, the associated listener must
 * be of concrete type SubscriberListener.
 */
public interface SubscriberListener extends EventListener {
    public void onRequestedDeadlineMissed(
            RequestedDeadlineMissedEvent<?> status);

    public void onRequestedIncompatibleQos(
            RequestedIncompatibleQosEvent<?> status);

    public void onSampleRejected(SampleRejectedEvent<?> status);

    public void onLivelinessChanged(LivelinessChangedEvent<?> status);

    public void onDataAvailable(DataAvailableEvent<?> status);

    public void onSubscriptionMatched(SubscriptionMatchedEvent<?> status);

    public void onSampleLost(SampleLostEvent<?> status);

    public void onDataOnReaders(DataOnReadersEvent status);
}
