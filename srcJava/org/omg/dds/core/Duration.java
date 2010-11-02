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

import org.omg.dds.core.modifiable.ModifiableDuration;
import org.omg.dds.type.Extensibility;
import org.omg.dds.type.Nested;


@Extensibility(Extensibility.Kind.FINAL_EXTENSIBILITY)
@Nested
public abstract class Duration implements Value<Duration, ModifiableDuration>
{
    // -----------------------------------------------------------------------
    // Private Constants
    // -----------------------------------------------------------------------

    private static final long serialVersionUID = 6926514364942353575L;



    // -----------------------------------------------------------------------
    // Factory Methods
    // -----------------------------------------------------------------------

    /**
     * Construct a time duration of the given magnitude.
     * 
     * A duration of magnitude {@link Long#MAX_VALUE} indicates an infinite
     * duration, regardless of the units specified.
     * 
     * @param bootstrap Identifies the Service instance to which the new
     *                  object will belong.
     */
    public static ModifiableDuration newDuration(
            long duration, TimeUnit unit, Bootstrap bootstrap) {
        return bootstrap.getSPI().newDuration(duration, unit);
    }


    /**
     * @param bootstrap Identifies the Service instance to which the
     *                  object will belong.
     * 
     * @return  An unmodifiable {@link Duration} of infinite length.
     */
    public static Duration infiniteDuration(Bootstrap bootstrap) {
        return bootstrap.getSPI().infiniteDuration();
    }


    /**
     * @param bootstrap Identifies the Service instance to which the
     *                  object will belong.
     * 
     * @return  A {@link Duration} of zero length.
     */
    public static Duration zeroDuration(Bootstrap bootstrap) {
        return bootstrap.getSPI().zeroDuration();
    }



    // -----------------------------------------------------------------------
    // Instance Methods
    // -----------------------------------------------------------------------

    // --- Data access: ------------------------------------------------------

    /**
     * Convert this Duration to a quantity of nanoseconds.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public abstract long toNanos();

    /**
     * Truncate this Duration to a whole-number quantity of microseconds.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public abstract long toMicros();

    /**
     * Truncate this Duration to a whole-number quantity of milliseconds.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public abstract long toMillis();

    /**
     * Truncate this Duration to a whole-number quantity of seconds.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public abstract long toSeconds();

    /**
     * Truncate this Duration to a whole-number quantity of minutes.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public abstract long toMinutes();

    /**
     * Truncate this Duration to a whole-number quantity of hours.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public abstract long toHours();

    /**
     * Truncate this Duration to a whole-number quantity of days.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public abstract long toDays();


    // --- Query: ------------------------------------------------------------

    /**
     * Report whether this duration lasts no time at all. The result of this
     * method is equivalent to the following:
     * 
     * <code>d.toNanos() == 0;</code>
     */
    public abstract boolean isZero();

    /**
     * Report whether this duration lasts forever. The result of this method
     * is equivalent to the following:
     * 
     * <code>d.toNanos() == Long.MAX_VALUE;</code>
     */
    public abstract boolean isInfinite();


    // --- From Object: ------------------------------------------------------

    @Override
    public abstract Duration clone();
}
