/*
 * Units of Measurement TCK
 * Copyright © 2005-2023, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tech.units.tck.util;

import tech.uom.lib.common.function.DescriptionSupplier;

/**
 * TestNG groups and profiles used in the JSR 385 TCK.
 * 
 * @author <a href="mailto:werner@units.tech">Werner Keil</a>
 * @author <a href="mailto:thodoris.bais@gmail.com">Teo Bais</a>
 * @version 2.4, July 7, 2023
 * @since 1.0
 */
public final class TestGroups {
    // String constants
    /** Core group */ public static final String CORE = "core";
    /** Format group */ public static final String FORMAT = "format";
    /** Base Quantity group */ public static final String BASE_QUANTITY = "base_quantity";
    /** Derived Quantity group */ public static final String DERIVED_QUANTITY = "derived_quantity";
    /** SPI group */ public static final String SPI = "spi";

    /**
     * Minimal groups
     */
    private static final String[] MINIMAL_GROUPS = { CORE };

    /**
     * Format groups
     */
    private static final String[] FORMAT_GROUPS = { CORE, FORMAT };

    /**
     * Base Quantity groups
     */
    private static final String[] BASE_QUANTITY_GROUPS = { CORE, BASE_QUANTITY };

    /**
     * Quantity groups
     */
    private static final String[] QUANTITY_GROUPS = { CORE, BASE_QUANTITY, DERIVED_QUANTITY };

    /**
     * Quantity groups and Format
     */
    private static final String[] QUANTITY_GROUPS_AND_FORMAT = { CORE, FORMAT, BASE_QUANTITY, DERIVED_QUANTITY };

    /**
     * SPI groups
     */
    private static final String[] SPI_GROUPS = { CORE, FORMAT, SPI };

	/**
	 * All groups
	 */
	private static final String[] ALL_GROUPS = { CORE, FORMAT, BASE_QUANTITY, DERIVED_QUANTITY, SPI };

    /**
     * Profiles used in the JSR 385 TCK.
     *
     * Some of the most common profiles (used by {@link tech.units.tck.TCKRunner}) are:
     * <ul>
     * <li>{@link #MINIMAL} - used to include tests for the core elements of the API. These tests are <b>mandatory</b> for every implementation.</li>
     * <li>{@link #FORMAT} - formatting tests used to include tests for elements in <code>javax.measure.format</code>.</li>
     * <li>{@link #FULL} - All tests in the JSR 385 TCK.</li>
     * </ul>
     *
     * @author Werner Keil
     * @version 2.0
     * @since 1.0
     */
    public enum Profile implements DescriptionSupplier {
        /** Minimal Profile */ MINIMAL("Minimal", MINIMAL_GROUPS), //
        /** Format Profile */ FORMAT("Format", FORMAT_GROUPS), //
        /** Base Quantity Profile */ BASE_QUANTITY("Base Quantity", BASE_QUANTITY_GROUPS), //
        /** Quantity Profile */ QUANTITY("Quantity", QUANTITY_GROUPS), //
        /** Quantity/Format Profile */ QUANTITY_FORMAT("Quantity and Format", QUANTITY_GROUPS_AND_FORMAT), //
        /** SPI Profile */ SPI("SPI", SPI_GROUPS), //
        /** Full Profile */ FULL("Full", ALL_GROUPS, true);

        private final String description;
        private final boolean isDefault;
        private final String[] groups;

        private Profile(String description, String[] groups, boolean isDefault) {
            this.description = description;
            this.groups = groups;
            this.isDefault = isDefault;
        }

        private Profile(String description, String[] groups) {
            this(description, groups, false);
        }

        /*
         * (non-Javadoc)
         * 
         * @see DescriptionSupplier
         */
        public String getDescription() {
            return description;
        }

        /**
         * Returns the test groups
         * @return test groups
         */
        public String[] getGroups() { return groups; }

        /**
         * Returns true for the default profile
         * @return true for the default profile
         */
        public boolean isDefault() {
            return isDefault;
        }
    }
}
