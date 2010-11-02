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

import java.util.concurrent.TimeUnit;

import org.omg.dds.core.modifiable.ModifiableTime;
import org.omg.dds.type.Extensibility;
import org.omg.dds.type.Nested;


@Extensibility(Extensibility.Kind.FINAL_EXTENSIBILITY)
@Nested
public abstract class Time implements Value<Time, ModifiableTime>
{
    // -----------------------------------------------------------------------
    // Private Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = -132361141453190372L;



    // -----------------------------------------------------------------------
    // Factory Methods
    // -----------------------------------------------------------------------

    /**
     * Construct a specific instant in time.
     * 
     * Negative values are considered invalid and will result in the
     * construction of a time <code>t</code> such that:
     * 
     * <code>t.isValid() == false</code>
     * 
     * @param bootstrap Identifies the Service instance to which the new
     *                  object will belong.
     */
    public static ModifiableTime newTime(
            long time, TimeUnit units, Bootstrap bootstrap) {
        return bootstrap.getSPI().newTime(time, units);
    }


    /**
     * @param bootstrap Identifies the Service instance to which the
     *                  object will belong.
     *                  
     * @return      An unmodifiable {@link Time} that is not valid.
     */
    public static Time invalidTime(Bootstrap bootstrap) {
        return bootstrap.getSPI().invalidTime();
    }



    // -----------------------------------------------------------------------
    // Instance Methods
    // -----------------------------------------------------------------------

    // --- Data access: ------------------------------------------------------

    /**
     * Convert this Time to a quantity of nanoseconds.
     * 
     * An invalid time will be reported as a negative value.
     */
    public abstract long toNanos();

    /**
     * Truncate this Time to a whole-number quantity of microseconds.
     * 
     * An invalid time will be reported as a negative value.
     */
    public abstract long toMicros();

    /**
     * Truncate this Time to a whole-number quantity of milliseconds.
     * 
     * An invalid time will be reported as a negative value.
     */
    public abstract long toMillis();

    /**
     * Truncate this Time to a whole-number quantity of seconds.
     * 
     * An invalid time will be reported as a negative value.
     */
    public abstract long toSeconds();

    /**
     * Truncate this Time to a whole-number quantity of minutes.
     * 
     * An invalid time will be reported as a negative value.
     */
    public abstract long toMinutes();

    /**
     * Truncate this Time to a whole-number quantity of hours.
     * 
     * An invalid time will be reported as a negative value.
     */
    public abstract long toHours();

    /**
     * Truncate this Time to a whole-number quantity of days.
     * 
     * An invalid time will be reported as a negative value.
     */
    public abstract long toDays();


    // --- Query: ------------------------------------------------------------

    /**
     * @return  whether this time represents a meaningful instant in time.
     */
    public abstract boolean isValid();


    // --- From Object: ------------------------------------------------------

    @Override
    public abstract Time clone();
}
