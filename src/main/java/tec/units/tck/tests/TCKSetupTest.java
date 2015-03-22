/**
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
package tec.units.tck.tests;

import static tec.units.tck.TCKSetup.*;
import static org.testng.AssertJUnit.*;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import java.util.Collection;

@SpecVersion(spec = "JSR 363", version = "0.8.0")
public class TCKSetupTest{

    @SpecAssertion(
            section = "0",
            id = "Setup",
            note = "Tests that a TestConfiguration is registered with the JDK ServiceLoader.")
    @Test(description = "TCK Setup: ensure TCK Configuration is registered and available.")
    public void testTestSetup(){
        assertTrue("TCK Configuration not available.", getTestConfiguration() != null);
        assertNotNull(getTestConfiguration());
    }

    @SpecAssertion(
            section = "0",
            id = "Setup",
            note = "Checks that TestConfiguration.getQuantityClasses() returns a non empty collection of quantity " +
                    "implementations")
    @Test(description = "TChecks that Quantity classes are registered for testing.")
    public void testQuantityConfiguration(){
        @SuppressWarnings("rawtypes")
		Collection<Class> amountClasses = getTestConfiguration().getQuantityClasses();
        assertNotNull("TCK Test Configuration quantity classes are null.", amountClasses);
        assertFalse("TCK Test Configuration quantity classes is empty.", amountClasses.isEmpty());
    }
}
