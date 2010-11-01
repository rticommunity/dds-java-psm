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

import java.util.EventObject;
import java.util.Set;

import org.omg.dds.core.Bootstrap;
import org.omg.dds.core.Entity;
import org.omg.dds.core.ModifiableValue;


/**
 * An interface implemented by all status types.
 */
public abstract class Status<SELF extends Status<SELF, SOURCE>,
                             SOURCE extends Entity<SOURCE, ?, ?>>
extends EventObject
implements ModifiableValue<SELF, SELF> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 1989817719529565165L;



    // -----------------------------------------------------------------------
    // Object Life Cycle
    // -----------------------------------------------------------------------

    /**
     * @param bootstrap Identifies the Service instance to which the
     *                  object will belong.
     */
    public static Set<Status.Kind> allStatusKinds(Bootstrap bootstrap) {
        return bootstrap.getSPI().allStatusKinds();
    }


    /**
     * @param bootstrap Identifies the Service instance to which the
     *                  object will belong.
     */
    public static Set<Status.Kind> noStatusKinds(Bootstrap bootstrap) {
        return bootstrap.getSPI().noStatusKinds();
    }


    // -----------------------------------------------------------------------

    protected Status(SOURCE source) {
        super(source);
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- API: --------------------------------------------------------------

    public abstract Kind getKind();


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
    
    public static enum Kind {
        // --- Kinds: --------------------------------------------------------
        INCONSISTENT_TOPIC          (0x0001 << 0),
        OFFERED_DEADLINE_MISSED     (0x0001 << 1),
        REQUESTED_DEADLINE_MISSED   (0x0001 << 2),
        OFFERED_INCOMPATIBLE_QOS    (0x0001 << 5),
        REQUESTED_INCOMPATIBLE_QOS  (0x0001 << 6),
        SAMPLE_LOST                 (0x0001 << 7),
        SAMPLE_REJECTED             (0x0001 << 8),
        DATA_ON_READERS             (0x0001 << 9),
        DATA_AVAILABLE              (0x0001 << 10),
        LIVELINESS_LOST             (0x0001 << 11),
        LIVELINESS_CHANGED          (0x0001 << 12),
        PUBLICATION_MATCHED         (0x0001 << 13),
        SUBSCRIPTION_MATCHED        (0x0001 << 14);


        // --- Constants: ----------------------------------------------------
        public final long value;


        // --- Object Life Cycle: --------------------------------------------
        private Kind(long value) {
            this.value = value;
        }
    }

}
