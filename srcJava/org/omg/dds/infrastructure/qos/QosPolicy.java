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

package org.omg.dds.infrastructure.qos;

import org.omg.dds.infrastructure.ValueType;


/**
 * An interface implemented by all QoS policies.
 */
public interface QosPolicy<SELF extends QosPolicy<SELF>>
extends ValueType<SELF> {
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
        DURABILITY_SERVICE      ("DurabilityService", 22);


        // --- Constants: ----------------------------------------------------
        public final int value;
        public final String policyName;


        // --- Object Lifecycle: ---------------------------------------------
        private Id(String enumName, int value) {
            this. policyName = enumName;
            this.value = value;
        }
    }

}
