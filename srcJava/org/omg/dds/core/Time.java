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

package org.omg.dds.core;

import org.omg.dds.type.annotation.Extensibility;
import org.omg.dds.type.annotation.Nested;


@Extensibility(Extensibility.Kind.FINAL_EXTENSIBILITY)
@Nested
public interface Time extends Value<Time, ModifiableTime>
{
    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- Data access: ------------------------------------------------------

    /**
     * Convert this Time to a quantity of nanoseconds.
     * 
     * An invalid time will be reported as a negative value.
     */
    public long toNanos();

    /**
     * Truncate this Time to a whole-number quantity of microseconds.
     * 
     * An invalid time will be reported as a negative value.
     */
    public long toMicros();

    /**
     * Truncate this Time to a whole-number quantity of milliseconds.
     * 
     * An invalid time will be reported as a negative value.
     */
    public long toMillis();

    /**
     * Truncate this Time to a whole-number quantity of seconds.
     * 
     * An invalid time will be reported as a negative value.
     */
    public long toSeconds();

    /**
     * Truncate this Time to a whole-number quantity of minutes.
     * 
     * An invalid time will be reported as a negative value.
     */
    public long toMinutes();

    /**
     * Truncate this Time to a whole-number quantity of hours.
     * 
     * An invalid time will be reported as a negative value.
     */
    public long toHours();

    /**
     * Truncate this Time to a whole-number quantity of days.
     * 
     * An invalid time will be reported as a negative value.
     */
    public long toDays();


    // --- Query: ------------------------------------------------------------

    /**
     * @return  whether this time represents a meaningful instant in time.
     */
    public boolean isValid();

}
