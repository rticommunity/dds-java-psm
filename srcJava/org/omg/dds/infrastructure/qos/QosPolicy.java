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

import org.omg.dds.spi.QosPolicyFactory;
import org.omg.dds.spi.ServiceImpl;
import org.omg.dds.util.ExtensibleEnum;
import org.omg.dds.util.ValueType;


/**
 * An interface implemented by all QoS policies.
 */
public interface QosPolicy<SELF extends QosPolicy<SELF>>
extends ValueType<SELF> {
    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    public Id<SELF> getId();



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------
    
    public static abstract class Id<POLICY extends QosPolicy<POLICY>>
    extends ExtensibleEnum<Id<POLICY>> {
        // --- Constants: ----------------------------------------------------
        private static final long serialVersionUID = -6419631365648412883L;


        // --- Object Lifecycle: ---------------------------------------------
        protected Id(String enumName, int ordinal) {
            super(enumName, ordinal);
        }

        private static <POLICY extends QosPolicy<POLICY>> Id<POLICY> create(
                String enumName,
                int ordinal,
                String policyName,
                int value) {
            QosPolicyFactory factory =
                ServiceImpl.getInstance().getQosPolicyFactory();
            Id<POLICY> id = factory.createQosPolicyId(
                    enumName, ordinal, policyName, value);
            assert id != null;
            return id;
        }


        // --- Methods: ------------------------------------------------------

        public abstract int getValue();

        public abstract String getPolicyName();
        
        public abstract Class<POLICY> getPolicyClass();


        // --- Policies: -----------------------------------------------------
        public static final Id<InvalidQosPolicy> INVALID = create(
                "INVALID", 0, "", 0);

        public static final Id<UserDataQosPolicy> USER_DATA = create(
                "USER_DATA", 1, "UserData", 1);

        public static final Id<DurabilityQosPolicy> DURABILITY = create(
                "DURABILITY", 2, "Durability", 2);

        public static final Id<PresentationQosPolicy> PRESENTATION = create(
                "PRESENTATION", 3, "Presentation", 3);

        public static final Id<DeadlineQosPolicy> DEADLINE = create(
                "DEADLINE", 4, "Deadline", 4);

        public static final Id<LatencyBudgetQosPolicy> LATENCY_BUDGET =
            create("LATENCY_BUDGET", 5, "LatencyBudget", 5);

        public static final Id<OwnershipQosPolicy> OWNERSHIP = create(
                "OWNERSHIP", 6, "Ownership", 6);

        public static final Id<OwnershipStrengthQosPolicy>
        OWNERSHIP_STRENGTH = create(
                "OWNERSHIP_STRENGTH", 7, "OwnershipStrength", 7);

        public static final Id<LivelinessQosPolicy> LIVELINESS = create(
                "LIVELINESS", 8, "Liveliness", 8);

        public static final Id<TimeBasedFilterQosPolicy> TIME_BASED_FILTER =
            create("TIME_BASED_FILTER", 9, "TimeBasedFilter", 9);

        public static final Id<PartitionQosPolicy> PARTITION = create(
                "PARTITION", 10, "Partition", 10);

        public static final Id<ReliabilityQosPolicy> RELIABILITY = create(
                "RELIABILITY", 11, "Reliability", 11);

        public static final Id<DestinationOrderQosPolicy> DESTINATION_ORDER =
            create("DESTINATION_ORDER", 12, "DestinationOrder", 12);

        public static final Id<HistoryQosPolicy> HISTORY = create(
                "HISTORY", 13, "History", 13);

        public static final Id<ResourceLimitsQosPolicy> RESOURCE_LIMITS =
            create("RESOURCE_LIMITS", 14, "ResourceLimits", 14);

        public static final Id<EntityFactoryQosPolicy> ENTITY_FACTORY =
            create("ENTITY_FACTORY", 15, "EntityFactory", 15);

        public static final Id<WriterDataLifecycleQosPolicy>
        WRITER_DATA_LIFECYCLE = create(
                "WRITER_DATA_LIFECYCLE", 16, "WriterDataLifecycle", 16);

        public static final Id<ReaderDataLifecycleQosPolicy>
        READER_DATA_LIFECYCLE = create(
                "READER_DATA_LIFECYCLE", 17, "ReaderDataLifecycle", 17);

        public static final Id<TopicDataQosPolicy> TOPIC_DATA = create(
                "TOPIC_DATA", 18, "TopicData", 18);

        public static final Id<GroupDataQosPolicy> GROUP_DATA = create(
                "GROUP_DATA", 19, "GroupData", 19);

        public static final Id<TransportPriorityQosPolicy>
        TRANSPORT_PRIORITY = create(
                "TRANSPORT_PRIORITY", 20, "TransportPriority", 20);

        public static final Id<LifespanQosPolicy> LIFESPAN = create(
                "LIFESPAN", 21, "Lifespan", 21);

        public static final Id<DurabilityServiceQosPolicy>
        DURABILITY_SERVICE = create(
                "DURABILITY_SERVICE", 22, "DurabilityService", 22);


        // --- Types: --------------------------------------------------------
        private interface InvalidQosPolicy
        extends QosPolicy<InvalidQosPolicy> {
            // empty
        }
    }

}
