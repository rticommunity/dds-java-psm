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

package org.omg.dds.infrastructure;

import java.util.EventObject;
import java.util.Set;

import org.omg.dds.publication.LivelinessLostStatus;
import org.omg.dds.publication.OfferedDeadlineMissedStatus;
import org.omg.dds.publication.OfferedIncompatibleQosStatus;
import org.omg.dds.publication.PublicationMatchedStatus;
import org.omg.dds.spi.ServiceImpl;
import org.omg.dds.spi.StatusFactory;
import org.omg.dds.subscription.DataReader;
import org.omg.dds.subscription.DataReaderListener;
import org.omg.dds.subscription.LivelinessChangedStatus;
import org.omg.dds.subscription.RequestedDeadlineMissedStatus;
import org.omg.dds.subscription.RequestedIncompatibleQosStatus;
import org.omg.dds.subscription.SampleLostStatus;
import org.omg.dds.subscription.SampleRejectedStatus;
import org.omg.dds.subscription.Subscriber;
import org.omg.dds.subscription.SubscriptionMatchedStatus;
import org.omg.dds.topic.InconsistentTopicStatus;
import org.omg.dds.util.ExtensibleEnum;
import org.omg.dds.util.ValueType;


/**
 * An interface implemented by all status types.
 */
public abstract class Status<SELF extends Status<SELF, SOURCE>,
                             SOURCE extends Entity<SOURCE, ?, ?>>
extends EventObject
implements ValueType<SELF> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -1690742728528299945L;



    // -----------------------------------------------------------------------
    // Object Lifecycle
    // -----------------------------------------------------------------------

    protected Status(SOURCE source) {
        super(source);
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- API: --------------------------------------------------------------

    public abstract Kind<SELF> getKind();


    @Override
    public abstract SOURCE getSource();


    @Override
    public abstract SELF clone();


    // --- SPI: --------------------------------------------------------------

    protected void setSource(SOURCE source) {
        super.source = source;
    }



    // -----------------------------------------------------------------------
    // Types
    // -----------------------------------------------------------------------
    
    public static abstract class Kind<STATUS extends Status<STATUS, ?>>
    extends ExtensibleEnum<Kind<STATUS>> {
        // --- Constants: ----------------------------------------------------
        private static final long serialVersionUID = -2016048328073479200L;


        // --- Object Lifecycle: ---------------------------------------------
        protected Kind(String enumName, int ordinal) {
            super(enumName, ordinal);
        }

        private static <STATUS extends Status<STATUS, ?>> Kind<STATUS>
        create(String enumName, int ordinal, int value) {
            StatusFactory factory =
                ServiceImpl.getInstance().getStatusFactory();
            Kind<STATUS> kind = factory.createStatusKind(
                    enumName, ordinal, value);
            assert kind != null;
            return kind;
        }

        private static Set<Kind<?>> createStatusKindSetAll() {
            StatusFactory factory =
                ServiceImpl.getInstance().getStatusFactory();
            Set<Kind<?>> status = factory.createStatusKindSetAll();
            assert status != null;
            return status;
        }

        private static Set<Kind<?>> createStatusKindSetNone() {
            StatusFactory factory =
                ServiceImpl.getInstance().getStatusFactory();
            Set<Kind<?>> status = factory.createStatusKindSetNone();
            assert status != null;
            return status;
        }


        // --- Methods: ------------------------------------------------------
        public abstract int getValue();
        
        public abstract Class<STATUS> getStatusClass();


        // --- Kinds: --------------------------------------------------------
        public static final Set<Kind<?>> ALL = createStatusKindSetAll();

        public static final Set<Kind<?>> NONE = createStatusKindSetNone();

        public static final Kind<InconsistentTopicStatus>
        INCONSISTENT_TOPIC = create("INCONSISTENT_TOPIC", 0, 0x0001 << 0);

        public static final Kind<OfferedDeadlineMissedStatus>
        OFFERED_DEADLINE_MISSED = create(
                "OFFERED_DEADLINE_MISSED", 1, 0x0001 << 1);

        public static final Kind<RequestedDeadlineMissedStatus>
        REQUESTED_DEADLINE_MISSED = create(
                "REQUESTED_DEADLINE_MISSED", 2, 0x0001 << 2);

        public static final Kind<OfferedIncompatibleQosStatus>
        OFFERED_INCOMPATIBLE_QOS = create(
                "OFFERED_INCOMPATIBLE_QOS", 3, 0x0001 << 5);

        public static final Kind<RequestedIncompatibleQosStatus>
        REQUESTED_INCOMPATIBLE_QOS = create(
                "REQUESTED_INCOMPATIBLE_QOS", 4, 0x0001 << 6);

        public static final Kind<SampleLostStatus>
        SAMPLE_LOST = create("SAMPLE_LOST", 5, 0x0001 << 7);

        public static final Kind<SampleRejectedStatus>
        SAMPLE_REJECTED = create("SAMPLE_REJECTED", 6, 0x0001 << 8);

        public static final Kind<DataAvailableStatus<Subscriber>>
        DATA_ON_READERS = create("DATA_ON_READERS", 7, 0x0001 << 9);

        public static final Kind<DataAvailableStatus<DataReader<?>>>
        DATA_AVAILABLE = create("DATA_AVAILABLE", 8, 0x0001 << 10);

        public static final Kind<LivelinessLostStatus>
        LIVELINESS_LOST = create("LIVELINESS_LOST", 9, 0x0001 << 11);

        public static final Kind<LivelinessChangedStatus>
        LIVELINESS_CHANGED = create("LIVELINESS_CHANGED", 10, 0x0001 << 12);

        public static final Kind<PublicationMatchedStatus>
        PUBLICATION_MATCHED = create("PUBLICATION_MATCHED", 11, 0x0001 << 13);

        public static final Kind<SubscriptionMatchedStatus>
        SUBSCRIPTION_MATCHED = create(
                "SUBSCRIPTION_MATCHED", 12, 0x0001 << 14);


        // --- Types: --------------------------------------------------------
        /**
         * There is no real status class corresponding to the DATA_AVAILABLE
         * status, but Status.Kind needs to be parameterized with something.
         * This class serves as a place holder. It cannot be instantiated.
         */
        @SuppressWarnings("serial")
        private static abstract class DataAvailableStatus
            <SOURCE extends DomainEntity<SOURCE,
                                         ?,
                                         ? extends DataReaderListener,
                                         ?>>
        extends Status<DataAvailableStatus<SOURCE>, SOURCE> {
            private DataAvailableStatus(SOURCE source) {
                super(source);
            }

            @Override
            public abstract DataAvailableStatus<SOURCE> clone();
        }
    }

}
