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

package org.omg.dds.topic;

import org.omg.dds.core.DomainEntity;
import org.omg.dds.core.NotEnabledException;
import org.omg.dds.core.StatusCondition;
import org.omg.dds.core.status.InconsistentTopicStatus;
import org.omg.dds.domain.DomainParticipant;
import org.omg.dds.pub.DataWriter;


/**
 * Topic is the most basic description of the data to be published and
 * subscribed.
 * 
 * A Topic is identified by its name, which must be unique in the whole
 * Domain.
 * 
 * Topic is the only {@link TopicDescription} that can be used for
 * publications and therefore associated to a {@link DataWriter}. All
 * operations except for the inherited operations
 * {@link #setQos(org.omg.dds.core.EntityQos)},
 * {@link #getQos()}, {@link #setListener(java.util.EventListener)},
 * {@link #getListener()}, {@link #enable()}, {@link #getStatusCondition()},
 * and {@link #close()} may fail with the exception
 * {@link NotEnabledException}.
 *
 * @param <TYPE>    The concrete type of the data that will be published and/
 *                  or subscribed by the readers and writers that use this
 *                  topic.
 */
public interface Topic<TYPE>
extends TopicDescription<TYPE>, DomainEntity<Topic<TYPE>,
                                             DomainParticipant,
                                             TopicListener<TYPE>,
                                             TopicQos> {
    /**
     * This method allows the application to retrieve the
     * {@link InconsistentTopicStatus} of the Topic.
     * 
     * Each {@link DomainEntity} has a set of relevant communication
     * statuses. A change of status causes the corresponding Listener to be
     * invoked and can also be monitored by means of the associated
     * {@link StatusCondition}.
     * 
     * @see     TopicListener
     * @see     StatusCondition
     */
    public InconsistentTopicStatus<TYPE> getInconsistentTopicStatus(
            InconsistentTopicStatus<TYPE> status);
}
