/*
 * Units of Measurement TCK
 * Copyright © 2005-2017, Jean-Marie Dautelle, Werner Keil, V2COM.
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
package tec.units.tck.tests.spi;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertFalse;
import static tec.units.tck.TCKRunner.SPEC_ID;
import static tec.units.tck.TCKRunner.SPEC_VERSION;

import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnitsService;
import javax.measure.spi.UnitFormatService;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

/**
 * Test class for Services.
 * @author Werner Keil
 * @version 1.0, August 16, 2016
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class ServicesTest {
    private static final String SECTION = "5.4";
    private static final String DESCRIPTION = SECTION + " Services";

    // ************************ 5.4 Services
    // ************************
    /**
     * Access available UnitFormatServices.
     */
    @Test(groups = {"spi"}, description = DESCRIPTION)
    @SpecAssertion(section = SECTION, id = "54-A1")
    public void testFormatService() {
	for (ServiceProvider provider : ServiceProvider.available()) {
	    assertNotNull("Section " + SECTION + ": ServiceProvider is null", provider);
	    UnitFormatService service = provider.getUnitFormatService();
	    assertNotNull("Section " + SECTION + ": UnitFormatService is null", service);
	}
    }
    
    // ************************ 5.4 Services
    // ************************
    /**
     * Access default UnitFormats in UnitFormatServices.
     */
    @Test(groups = {"spi"}, description = DESCRIPTION)
    @SpecAssertion(section = SECTION, id = "54-A2")
    public void testFormatServiceDefaultFormat() {
	for (ServiceProvider provider : ServiceProvider.available()) {
	    assertNotNull("Section " + SECTION + ": ServiceProvider is null", provider);
	    UnitFormatService service = provider.getUnitFormatService();
	    assertNotNull("Section " + SECTION + ": UnitFormatService is null", service);
	    assertNotNull("Section " + SECTION + ": Default UnitFormat is null", service.getUnitFormat());
	    assertNotNull("Section " + SECTION + ": Available UnitFormat names are null", service.getAvailableFormatNames());
	    assertFalse("Section " + SECTION + " No available UnitFormat names found", service.getAvailableFormatNames().isEmpty());
	}
    }
    
    // ************************ 5.4 Services
    // ************************
    /**
     * Access available UnitFormats in UnitFormatServices.
     */
    @Test(groups = {"spi"}, description = DESCRIPTION)
    @SpecAssertion(section = SECTION, id = "54-A3")
    public void testFormatServiceAvailableFormats() {
	for (ServiceProvider provider : ServiceProvider.available()) {
	    assertNotNull("Section " + SECTION + ": ServiceProvider is null", provider);
	    UnitFormatService service = provider.getUnitFormatService();
	    assertNotNull("Section " + SECTION + ": UnitFormatService is null", service);
	    assertNotNull("Section " + SECTION + ": Available UnitFormat names are null", service.getAvailableFormatNames());
	    assertFalse("Section " + SECTION + " No available UnitFormat names found", service.getAvailableFormatNames().isEmpty());
	}
    }
    
    // ************************ 5.4 Services
    // ************************
    /**
     * Access available SystemOfUnitsServices.
     */
    @Test(groups = {"spi"}, description = DESCRIPTION)
    @SpecAssertion(section = SECTION, id = "54-A4")
    public void testSystemOfUnitsService() {
	for (ServiceProvider provider : ServiceProvider.available()) {
	    assertNotNull("Section " + SECTION + ": ServiceProvider is null", provider);
	    SystemOfUnitsService service = provider.getSystemOfUnitsService();
	    assertNotNull("Section " + SECTION + ": SystemOfUnitsService is null", service);
	}
    }
    
    // ************************ 5.4 Services
    // ************************
    /**
     * Access default SystemOfUnits in SystemOfUnitsService.
     */
    @Test(groups = {"spi"}, description = DESCRIPTION)
    @SpecAssertion(section = SECTION, id = "54-A5")
    public void testSystemOfUnitsServiceDefaultSystem() {
	for (ServiceProvider provider : ServiceProvider.available()) {
	    assertNotNull("Section " + SECTION + ": ServiceProvider is null", provider);
	    SystemOfUnitsService service = provider.getSystemOfUnitsService();
	    assertNotNull("Section " + SECTION + ": SystemOfUnitsService is null", service);
	    assertNotNull("Section " + SECTION + ": Default SystemOfUnits is null", service.getSystemOfUnits());
	}
    }
    
    // ************************ 5.4 Services
    // ************************
    /**
     * Access available Systems OfUnits in SystemOfUnitsService.
     */
    @Test(groups = {"spi"}, description = DESCRIPTION)
    @SpecAssertion(section = SECTION, id = "54-A6")
    public void testSystemOfUnitsServiceAvailableSystems() {
	for (ServiceProvider provider : ServiceProvider.available()) {
	    assertNotNull("Section " + SECTION + ": ServiceProvider is null", provider);
	    SystemOfUnitsService service = provider.getSystemOfUnitsService();
	    assertNotNull("Section " + SECTION + ": SystemOfUnitsService is null", service);
	    assertNotNull("Section " + SECTION + ": Available SystemOfUnits are null", service.getAvailableSystemsOfUnits());
	    assertFalse("Section " + SECTION + " No available SystemOfUnits found", service.getAvailableSystemsOfUnits().isEmpty());
	}
    }
}
