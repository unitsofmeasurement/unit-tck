package tec.units.tck.util;

import static tec.units.tck.util.TestGroups.Group.*;

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
	 * <li>{@link #core} - used to include tests for the core elements of the
	 * API. These tests are <b>mandatory</b> in every profile.</li>
	 * <li>{@link #format} - formatting tests used to include tests for elements
	 * in {@linkplain javax.measure.format}.</li>
	 * </ul>
	 *
	 * @author Werner Keil
	 */
	public enum Group {
		core, format, quantity, spi
	}

	/**
     * Full profile (default if none is given)
     */
	public static final String FULL = "full";
	
	/**
     * Minimal profile
     */
	public static final String MINIMAL = "minimal";
	
	/**
     * Minimal groups
     */
    public static final Group[] MINIMAL_GROUPS = { core };
    
    /**
     * Format profile
     */
    public static final String FORMAT = "format";
    
    /**
     * Format groups
     */
    public static final Group[] FORMAT_GROUPS = { core, format };
    
    /** 
     * Name of the system property to give the desired profile 
     */
    public static final String SYS_PROPERTY_PROFILE = "tec.units.tck.profile";
}