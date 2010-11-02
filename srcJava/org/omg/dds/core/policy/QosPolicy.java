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

import org.omg.dds.core.Bootstrap;
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
    
    public static abstract class Id {
        // --- Factory Methods: ----------------------------------------------
        /**
         * Get the QoS policy ID for the given QoS policy class.
         * 
         * @param bootstrap Identifies the Service instance to which the
         *                  object will belong.
         */
        public static Id getId(
                Class<? extends QosPolicy<?, ?>> policyClass,
                Bootstrap bootstrap) {
            return bootstrap.getSPI().getQosPolicyId(policyClass);
        }

        // --- Instance Methods: ---------------------------------------------
        public abstract int getPolicyIdValue();

        public abstract String getPolicyName();
    }

}
