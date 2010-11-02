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

package org.omg.dds.core.policy;

import org.omg.dds.core.Value;
import org.omg.dds.type.Extensibility;
import org.omg.dds.type.Nested;


/**
 * An interface implemented by all QoS policies.
 */
@Extensibility(Extensibility.Kind.EXTENSIBLE_EXTENSIBILITY)
@Nested
public interface QosPolicy<UNMOD_SELF extends QosPolicy<UNMOD_SELF, MOD_SELF>,
                           MOD_SELF extends UNMOD_SELF>
extends Value<UNMOD_SELF, MOD_SELF> {
    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    public Id getId();



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------
    
    public static enum Id {
        // --- Policies: -----------------------------------------------------
        INVALID                 ("", 0),
        USER_DATA               ("UserData", 1),
        DURABILITY              ("Durability", 2),
        PRESENTATION            ("Presentation", 3),
        DEADLINE                ("Deadline", 4),
        LATENCY_BUDGET          ("LatencyBudget", 5),
        OWNERSHIP               ("Ownership", 6),
        OWNERSHIP_STRENGTH      ("OwnershipStrength", 7),
        LIVELINESS              ("Liveliness", 8),
        TIME_BASED_FILTER       ("TimeBasedFilter", 9),
        PARTITION               ("Partition", 10),
        RELIABILITY             ("Reliability", 11),
        DESTINATION_ORDER       ("DestinationOrder", 12),
        HISTORY                 ("History", 13),
        RESOURCE_LIMITS         ("ResourceLimits", 14),
        ENTITY_FACTORY          ("EntityFactory", 15),
        WRITER_DATA_LIFECYCLE   ("WriterDataLifecycle", 16),
        READER_DATA_LIFECYCLE   ("ReaderDataLifecycle", 17),
        TOPIC_DATA              ("TopicData", 18),
        GROUP_DATA              ("GroupData", 19),
        TRANSPORT_PRIORITY      ("TransportPriority", 20),
        LIFESPAN                ("Lifespan", 21),
        DURABILITY_SERVICE      ("DurabilityService", 22),
        DATA_REPRESENTATION     ("DataRepresentation", 23),
        TYPE_CONSISTENCY_ENFORCEMENT    ("TypeConsistencyEnforcement", 24),
        ;


        // --- Constants: ----------------------------------------------------
        public final int value;
        public final String policyName;


        // --- Object Life Cycle: --------------------------------------------
        private Id(String enumName, int value) {
            this.policyName = enumName;
            this.value = value;
        }
    }

}
