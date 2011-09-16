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

import org.omg.dds.core.Entity;
import org.omg.dds.core.Value;


/**
 * The status of an Entity changed.
 * 
 * @see Status
 */
public abstract class StatusChangedEvent<
    SELF extends StatusChangedEvent<SELF, SOURCE>,
    SOURCE extends Entity<SOURCE, ?, ?>>
extends EventObject
implements Value<SELF, SELF> {
    // -----------------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -6417894245684012290L;



    // -----------------------------------------------------------------------
    // Object Life Cycle
    // -----------------------------------------------------------------------

    protected StatusChangedEvent(SOURCE source) {
        super(source);
    }



    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- API: --------------------------------------------------------------

    @Override
    public abstract SOURCE getSource();


    @Override
    public abstract SELF clone();


    // --- SPI: --------------------------------------------------------------

    protected void setSource(SOURCE source) {
        super.source = source;
    }
}
