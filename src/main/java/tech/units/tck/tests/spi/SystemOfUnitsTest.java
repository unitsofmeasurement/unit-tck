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
package tech.units.tck.tests.spi;

import static org.testng.AssertJUnit.assertNotNull;
import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;

import java.util.Set;

import javax.measure.Dimension;
import javax.measure.Unit;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnits;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import tech.units.tck.util.TestUtils;

/**
 * Tests for SystemOfUnits
 *
 * @author <a href="mailto:werner@units.tech">Werner Keil</a>
 * @version 1.1, January 16, 2019
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class SystemOfUnitsTest {
    private static final String SECTION = "5.2";

    /**
     * Ensure at least one SystemOfUnits implementation exists.
     */
    @SpecAssertion(section = SECTION, id = "52-A1")
    @Test(groups = { "spi" }, description = SECTION
	    + " Ensure a SystemOfUnits implementation exists for every ServiceProvider")
    public void testEnsureGotSystemOfUnits() {
    	for (ServiceProvider provider : ServiceProvider.available()) {
    	    assertNotNull("Section " + SECTION + ": ServiceProvider is null",
    		    provider);
    	    AssertJUnit.assertNotNull("SystemOfUnits is null for " + provider,
    		    provider.getSystemOfUnitsService()
    			    .getAvailableSystemsOfUnits());
    	    AssertJUnit.assertFalse("SystemOfUnits not found in " + provider,
    		    provider.getSystemOfUnitsService()
    			    .getAvailableSystemsOfUnits().isEmpty());
    	}
    }

    /**
     * Ensure the getName() method is implemented.
     */
    @SpecAssertion(section = SECTION, id = "52-A2")
    @Test(groups = { "spi" }, description = SECTION
	    + " Ensure the getName() method is implemented.")
    public void testSystemOfUnitsGetName() {
    	for (SystemOfUnits suo : ServiceProvider.current()
    		.getSystemOfUnitsService().getAvailableSystemsOfUnits()) {
    	    Class<?> type = suo.getClass();
    	    TestUtils
    		    .testHasPublicMethod("Section " + SECTION, type, "getName");
    	}
    }

    /**
     * Ensure the getUnit() method is implemented.
     */
    @SpecAssertion(section = SECTION, id = "52-A3")
    @Test(groups = { "spi" }, description = SECTION
	    + " Ensure the getUnit() method is implemented.")
    public void testSystemOfUnitsGetUnit() {
    	for (SystemOfUnits suo : ServiceProvider.current()
    		.getSystemOfUnitsService().getAvailableSystemsOfUnits()) {
    	    Class<?> type = suo.getClass();
    	    TestUtils.testHasPublicMethod("Section " + SECTION, type, true,
    		    Unit.class, "getUnit", Class.class);
    	}
    }
    
    /**
     * Ensure the getUnit() method is implemented.
     * @since 2.0
     */
    @SpecAssertion(section = SECTION, id = "52-A4")
    @Test(groups = { "spi" }, description = SECTION
        + " Ensure the getUnit() method is implemented.")
    public void testSystemOfUnitsGetUnitForString() {
        for (SystemOfUnits suo : ServiceProvider.current()
            .getSystemOfUnitsService().getAvailableSystemsOfUnits()) {
            Class<?> type = suo.getClass();
            TestUtils.testHasPublicMethod("Section " + SECTION, type, true,
                Unit.class, "getUnit", String.class);
        }
    }

    /**
     * Ensure the getUnits() method is implemented.
     */
    @SpecAssertion(section = SECTION, id = "52-A5")
    @Test(groups = { "spi" }, description = SECTION
	    + " Ensure the getUnits() method is implemented.")
    public void testSystemOfUnitsGetUnits() {
    	for (SystemOfUnits suo : ServiceProvider.current()
    		.getSystemOfUnitsService().getAvailableSystemsOfUnits()) {
    	    Class<?> type = suo.getClass();
    	    TestUtils.testHasPublicMethod("Section " + SECTION, type,
    		    "getUnits");
    	}
    }

    /**
     * Ensure the getUnits() method is implemented.
     */
    @SpecAssertion(section = SECTION, id = "52-A6")
    @Test(groups = { "spi" }, description = "5.2 Ensure the getUnits() method is implemented.")
    public void testSystemOfUnitsGetUnitsForDimension() {
    	for (SystemOfUnits suo : ServiceProvider.current()
    		.getSystemOfUnitsService().getAvailableSystemsOfUnits()) {
    	    Class<?> type = suo.getClass();
    	    TestUtils.testHasPublicMethod("Section 5.2", type, true, Set.class,
    		    "getUnits", Dimension.class);
    	}
    }
}
