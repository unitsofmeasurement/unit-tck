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
package tech.units.tck.tests;

import static org.testng.AssertJUnit.*;
import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;
import static tech.units.tck.TCKSetup.*;
import static tech.units.tck.util.TestGroups.CORE;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import java.util.Collection;

/**
 * Tests the ServiceConfiguration
 * @author Werner Keil
 * @version 1.2, November 15, 2020
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class TCKSetupTest{

	private static final String SECTION_NUM = "0";
	
    @SpecAssertion(
            section = SECTION_NUM,
            id = "Setup",
            note = "Tests that a TestConfiguration is registered with the JDK ServiceLoader.")
    @Test(groups = { CORE }, description = "TCK Setup: ensure TCK Configuration is registered and available.")
    public void testTestSetup(){
        assertTrue("TCK Configuration not available.", getConfiguration() != null);
        assertNotNull(getConfiguration());
    }

    @SpecAssertion(
            section = SECTION_NUM,
            id = "Setup",
            note = "Checks that TestConfiguration.getQuantityClasses() returns a non empty collection of quantity " +
                    "implementations")
    @Test(groups = { CORE }, description = "Checks that Quantity classes are registered for testing.")
    public void testQuantityConfiguration(){
        @SuppressWarnings("rawtypes")
	Collection<Class> quantityClasses = getConfiguration().getQuantityClasses();
        assertNotNull("TCK Test Configuration quantity classes are null.", quantityClasses);
        assertFalse("TCK Test Configuration quantity classes is empty.", quantityClasses.isEmpty());
    }
}
