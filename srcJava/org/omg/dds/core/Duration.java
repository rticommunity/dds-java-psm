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
public interface Duration extends Value<Duration, ModifiableDuration>
{
    // -----------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------

    // --- Data access: ------------------------------------------------------

    /**
     * Convert this Duration to a quantity of nanoseconds.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public long toNanos();

    /**
     * Truncate this Duration to a whole-number quantity of microseconds.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public long toMicros();

    /**
     * Truncate this Duration to a whole-number quantity of milliseconds.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public long toMillis();

    /**
     * Truncate this Duration to a whole-number quantity of seconds.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public long toSeconds();

    /**
     * Truncate this Duration to a whole-number quantity of minutes.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public long toMinutes();

    /**
     * Truncate this Duration to a whole-number quantity of hours.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public long toHours();

    /**
     * Truncate this Duration to a whole-number quantity of days.
     * 
     * An infinite duration will be reported as {@link Long#MAX_VALUE}.
     */
    public long toDays();


    // --- Query: ------------------------------------------------------------

    /**
     * Report whether this duration lasts no time at all. The result of this
     * method is equivalent to the following:
     * 
     * <code>d.toNanos() == 0;</code>
     */
    public boolean isZero();

    /**
     * Report whether this duration lasts forever. The result of this method
     * is equivalent to the following:
     * 
     * <code>d.toNanos() == Long.MAX_VALUE;</code>
     */
    public boolean isInfinite();
}
