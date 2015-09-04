package tec.units.tck.util;

import static tec.units.tck.util.TestGroups.Group.*;
import tec.uom.lib.common.function.DescriptionSupplier;

/**
 * TestNG group profiles used in the JSR 363 TCK.
 *
 * The most important profiles (used by {@link TCKRunner}) are:
 * <ul>
 * <li>{@link #MINIMAL} - includes only the mandatory core tests.</li>
 * <li>{@link #FORMAT} - includes core and formatting tests.</li>
 * </ul>
 *
 * @author Werner Keil
 */
public final class TestGroups {

    /**
     * TestNG groups used in the JSR 363 TCK.
     *
     * The most important groups (used by {@link TCKRunner}) are:
     * <ul>
     * <li>{@link #core} - used to include tests for the core elements of the API. These tests are <b>mandatory</b> in every
     * profile.</li>
     * <li>{@link #format} - formatting tests used to include tests for elements in {@linkplain javax.measure.format}.</li>
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
        minimal("Minimal", MINIMAL_GROUPS), format("Format", FORMAT_GROUPS), base_quantity("Base Quantity", BASE_QUANTITY_GROUPS), 
        quantity("Quantity", QUANTITY_GROUPS), spi("SPI", SPI_GROUPS), full("Full", Group.values());

        private final String description;

        private final Group[] groups;
        
        private Profile(String description, Group[] groups) {
            this.description = description;
            this.groups = groups;
        }
        
        public Group[] getGroups() {
            return groups;
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
    }
}
