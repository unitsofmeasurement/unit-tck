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
package tech.units.tck.tests.spi;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import static tech.units.tck.TCKRunner.SECTION_PREFIX;
import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;
import static tech.units.tck.util.TestGroups.SPI;
import static org.testng.AssertJUnit.assertFalse;

import java.util.List;

import javax.measure.spi.ServiceProvider;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

/**
 * Test class for {@link ServiceProvider}.
 * @author Werner Keil
 * @version 2.0, August 31, 2023
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class ServiceProviderTest {
    private static final String SECTION_NUM = "5.3";
    private static final String DESCRIPTION = SECTION_NUM + " Service Provider";

    // ************************ 5.3 Service Provider
    // ************************
    /**
     * Access available service providers.
     */
    @Test(groups = { SPI }, description = DESCRIPTION)
    @SpecAssertion(section = SECTION_NUM, id = "53-A1")
    public void testAvailable() {
	List<ServiceProvider> spa = ServiceProvider.available();
        assertNotNull(spa, SECTION_PREFIX + SECTION_NUM + ": available ServiceProviders is null");
    }
    
    /**
     * Available service providers not empty.
     */
    @Test(groups = { SPI }, description = DESCRIPTION)
    @SpecAssertion(section = SECTION_NUM, id = "53-A2")
    public void testAvailableNotEmpty() {
	List<ServiceProvider> spa = ServiceProvider.available();
        assertNotNull(spa, SECTION_PREFIX + SECTION_NUM + ": available ServiceProviders is null");
        assertFalse(SECTION_PREFIX + SECTION_NUM + ": No available ServiceProviders found", spa.isEmpty());
    }
    
    // ************************ 5.3 Service Provider
    // ************************
    /**
     * Access current ServiceProvider.
     */
    @Test(groups = { SPI }, description = DESCRIPTION)
    @SpecAssertion(section = SECTION_NUM, id = "53-A3")
    public void testCurrent() {
	ServiceProvider sp = ServiceProvider.current();
        assertNotNull(sp, SECTION_PREFIX + SECTION_NUM + ": No current ServiceProvider found");
    }
    
    // ************************ 5.3 Service Provider
    // ************************
    /**
     * Access a ServiceProvider priority.
     */
    @Test(groups = { SPI }, description = DESCRIPTION)
    @SpecAssertion(section = SECTION_NUM, id = "53-A4")
    public void testPriority() {
	final ServiceProvider sp = ServiceProvider.current();
	assertTrue((sp.getPriority() >= Integer.MIN_VALUE && sp.getPriority() <= Integer.MAX_VALUE), 
			SECTION_PREFIX + SECTION_NUM + ": Priority should be a valid int");
    }
}
