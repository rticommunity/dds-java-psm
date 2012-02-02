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

import org.omg.dds.core.InstanceHandle;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.sub.DataReader;
import org.omg.dds.topic.Topic;


/**
 * The liveliness of one or more {@link DataWriter}s that were writing
 * instances read through the {@link DataReader} has changed. Some
 * DataWriter(s) have become "active" or "inactive."
 *
 * @see LivelinessChangedEvent
 * @see LivelinessLostStatus
 */
public abstract class LivelinessChangedStatus extends Status
{
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -8771335633962700621L;



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    /**
     * The total number of currently active {@link DataWriter}s that write
     * the Topic read by the {@link DataReader}. This count increases when a
     * newly matched DataWriter asserts its liveliness for the first time or
     * when a DataWriter previously considered to be not alive reasserts its
     * liveliness. The count decreases when a DataWriter considered alive
     * fails to assert its liveliness and becomes not alive, whether because
     * it was deleted normally or for some other reason.
     */
    public abstract int getAliveCount();

    /**
     * The total count of currently {@link DataWriter}s that write the
     * {@link Topic} read by the {@link DataReader} that are no longer
     * asserting their liveliness. This count increases when a DataWriter
     * considered alive fails to assert its liveliness and becomes not alive
     * for some reason other than the normal deletion of that DataWriter.
     * It decreases when a previously not alive DataWriter either reasserts
     * its liveliness or is deleted normally.
     */
    public abstract int getNotAliveCount();

    /**
     * The change in the aliveCount since the last time the listener was
     * called or the status was read.
     */
    public abstract int getAliveCountChange();

    /**
     * The change in the notAliveCount since the last time the listener was
     * called or the status was read.
     */
    public abstract int getNotAliveCountChange();

    /**
     * Handle to the last {@link DataWriter} whose change in liveliness
     * caused this status to change.
     */
    public abstract InstanceHandle getLastPublicationHandle();
}
