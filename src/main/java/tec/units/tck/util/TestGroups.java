/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tec.units.tck.util;

import static tec.units.tck.util.TestGroups.Group.*;
import tec.uom.lib.common.function.DescriptionSupplier;

/**
 * TestNG groups and profiles used in the JSR 363 TCK.
 *
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 */
public final class TestGroups {

    /**
     * TestNG groups used in the JSR 363 TCK.
     *
     * The most important groups (used by {@link TCKRunner}) are:
     * <ul>
     * <li>{@link #core} - used to include tests for the core elements of the API. These tests are <b>mandatory</b> in every
     * profile.</li>
     * <li>{@link #format} - formatting tests used to include elements in {@linkplain javax.measure.format}.</li>
     * <li>{@link #base_quantity} - tests to include <b>base quantities</b> in {@linkplain javax.measure.quantity}.</li>
     * <li>{@link #quantity} - tests to include other quantities in {@linkplain javax.measure.quantity}.</li>
     * <li>{@link #spi} - tests to include SPI elements in {@linkplain javax.measure.spi}.</li>
     * </ul>
     *
     * @author Werner Keil
     */
    public enum Group {
        core, format, base_quantity, derived_quantity, spi
    }

    /**
     * Minimal groups
     */
    private static final Group[] MINIMAL_GROUPS = {core};

    /**
     * Format groups
     */
    private static final Group[] FORMAT_GROUPS = {core, format};
    
    /**
     * Base Quantity groups
     */
    private static final Group[] BASE_QUANTITY_GROUPS = {core, base_quantity};
    
    /**
     * Quantity groups
     */
    private static final Group[] QUANTITY_GROUPS = {core, base_quantity, derived_quantity};
    
    /**
     * SPI groups
     */
    private static final Group[] SPI_GROUPS = {core, format, spi};

    /**
     * Profiles used in the JSR 363 TCK.
     *
     * The most profiles (used by {@link TCKRunner}) are:
     * <ul>
     * <li>{@link #minimal} - used to include tests for the core elements of the API. These tests are <b>mandatory</b> for every
     * implementation.</li>
     * <li>{@link #format} - formatting tests used to include tests for elements in {@linkplain javax.measure.format}.</li>
     * </ul>
     *
     * @author Werner Keil
     */
    public enum Profile implements DescriptionSupplier {
        minimal("Minimal", MINIMAL_GROUPS, false), format("Format", FORMAT_GROUPS, false), 
        base_quantity("Base Quantity", BASE_QUANTITY_GROUPS, false), quantity("Quantity", QUANTITY_GROUPS, false),
        spi("SPI", SPI_GROUPS, false), full("Full", Group.values(), true);

        private final String description;
        private final Group[] groups;
        private final boolean isDefault;
        
        private Profile(String description, Group[] groups, boolean isDefault) {
            this.description = description;
            this.groups = groups;
            this.isDefault = isDefault;
        }
        
		@Override
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
