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

package org.omg.dds.core.status;

import org.omg.dds.pub.DataWriter;
import org.omg.dds.sub.DataReader;
import org.omg.dds.topic.Topic;


/**
 * The {@link DataWriter} has found a {@link DataReader} that matches the
 * {@link Topic} and has compatible QoS, or has ceased to be matched with a
 * DataReader that was previously considered to be matched.
 *
 * @param <TYPE>    The data type of the source {@link DataWriter}.
 * 
 * @see PublicationMatchedStatus
 * @see SubscriptionMatchedEvent
 */
public abstract class PublicationMatchedEvent<TYPE>
extends StatusChangedEvent<PublicationMatchedEvent<TYPE>, DataWriter<TYPE>> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 8113337178850115142L;



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    public abstract PublicationMatchedStatus getStatus();


    // --- Object Life Cycle: ------------------------------------------------

    protected PublicationMatchedEvent(DataWriter<TYPE> source) {
        super(source);
    }
}
