/*
 * Units of Measurement TCK
 * Copyright © 2005-2019, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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

import static tech.units.tck.util.TestGroups.Group.*;

import tech.uom.lib.common.function.DescriptionSupplier;
import tech.uom.lib.common.function.Identifiable;

/**
 * TestNG groups and profiles used in the JSR 385 TCK.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 2.0, February 21, 2019
 * @since 1.0
 */
public final class TestGroups {
    // String constants
    public static final String CORE = "core";
    public static final String FORMAT = "format";
    public static final String BASE_QUANTITY = "base_quantity";
    public static final String DERIVED_QUANTITY = "derived_quantity";
    public static final String SPI = "spi";
    
    /**
     * TestNG groups used in the JSR 385 TCK.
     *
     * The most important groups (used by {@link TCKRunner}) are:
     * <ul>
     * <li>{@link #Core} - used to include tests for the core elements of the API. These tests are <b>mandatory</b> in every profile.</li>
     * <li>{@link #Format} - formatting tests used to include elements in <tt>javax.measure.format</tt>.</li>
     * <li>{@link #Base_Quantity} - tests to include <b>base quantities</b> in <tt>javax.measure.quantity</tt>.</li>
     * <li>{@link #Derived_Quantity} - tests to include other quantities in <tt>javax.measure.quantity</tt>.</li>
     * <li>{@link #Spi} - tests to include SPI elements in <tt>javax.measure.spi</tt>.</li>
     * </ul>
     *
     * @author Werner Keil
     * @version 1.2
     * @since 1.0
     * @deprecated While the Profile enum is useful and vital, this enum feels redundant and could better be replaced by the String constants (cause those work in TestNG annotations) 
     */
    public enum Group implements Identifiable<String> {
        Core(CORE), Format(FORMAT), Base_Quantity(BASE_QUANTITY), Derived_Quantity(DERIVED_QUANTITY), Spi(SPI);
        
        private final String id;
        
        private Group(String id) {
            this.id = id;
        }

        @Override
        /**
         * @since 2.0
         */
        public String getId() {
            return id;
        }
    }

    /**
     * Minimal groups
     */
    private static final Group[] MINIMAL_GROUPS = { Core };

    /**
     * Format groups
     */
    private static final Group[] FORMAT_GROUPS = { Core, Format };

    /**
     * Base Quantity groups
     */
    private static final Group[] BASE_QUANTITY_GROUPS = { Core, Base_Quantity };

    /**
     * Quantity groups
     */
    private static final Group[] QUANTITY_GROUPS = { Core, Base_Quantity, Derived_Quantity };

    /**
     * Quantity groups and Format
     */
    private static final Group[] QUANTITY_GROUPS_AND_FORMAT = { Core, Format, Base_Quantity, Derived_Quantity };

    /**
     * SPI groups
     */
    private static final Group[] SPI_GROUPS = { Core, Format, Spi };

    /**
     * Profiles used in the JSR 385 TCK.
     *
     * Some of the most common profiles (used by {@link TCKRunner}) are:
     * <ul>
     * <li>{@link #MINIMAL} - used to include tests for the core elements of the API. These tests are <b>mandatory</b> for every implementation.</li>
     * <li>{@link #FORMAT} - formatting tests used to include tests for elements in <tt>javax.measure.format</tt>.</li>
     * <li>{@link #FULL} - All tests in the JSR 385 TCK.</li>
     * </ul>
     *
     * @author Werner Keil
     * @version 1.1
     * @since 1.0
     */
    public enum Profile implements DescriptionSupplier {
        MINIMAL("Minimal", MINIMAL_GROUPS), //
        FORMAT("Format", FORMAT_GROUPS), //
        BASE_QUANTITY("Base Quantity", BASE_QUANTITY_GROUPS), //
        QUANTITY("Quantity", QUANTITY_GROUPS), //
        QUANTITY_FORMAT("Quantity and Format", QUANTITY_GROUPS_AND_FORMAT), //
        SPI("SPI", SPI_GROUPS, false), //
        FULL("Full", Group.values(), true);

        private final String description;
        private final Group[] groups;
        private final boolean isDefault;

        private Profile(String description, Group[] groups, boolean isDefault) {
            this.description = description;
            this.groups = groups;
            this.isDefault = isDefault;
        }

        private Profile(String description, Group[] groups) {
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

        public Group[] getGroups() {
            return groups;
        }

        public boolean isDefault() {
            return isDefault;
        }
    }
}
