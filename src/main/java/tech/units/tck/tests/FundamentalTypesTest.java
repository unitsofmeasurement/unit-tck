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
package tech.units.tck.tests;

import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import tech.units.tck.TCKSetup;

/**
 * Tests for Fundamental Types
 *
 * @author  <a href="mailto:werner@units.tech">Werner Keil</a>
 * @version 1.2, July 11, 2018
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class FundamentalTypesTest {

    /**
     * Ensure at least one Unit implementation
     * is available/registered.
     */
    @SpecAssertion(section = "4.1", id = "41-A1")
    @Test(groups = { "core" }, description = "4.1 Ensure at least one Unit implementation is available/registered.")
    public void testEnsureGotUnit() {
        AssertJUnit.assertTrue("TCK Configuration not available.", TCKSetup.getConfiguration() != null);
        AssertJUnit.assertTrue(!TCKSetup.getConfiguration().getUnitClasses().isEmpty());
    }
    
    /**
     * Ensure at least one Dimension implementation
     * is available/registered.
     */
    @SpecAssertion(section = "4.1", id = "41-A2")
    @Test(groups = { "core" }, description = "4.1 Ensure at least one Dimension implementation is available/registered.")
    public void testEnsureHasDimension() {
        AssertJUnit.assertTrue("TCK Configuration not available.", TCKSetup.getConfiguration() != null);
        AssertJUnit.assertTrue(!TCKSetup.getConfiguration().getDimensionClasses().isEmpty());
    }
    
    /**
     * Ensure at least one Prefix implementation
     * is available/registered.
     */
    @SpecAssertion(section = "4.1", id = "41-A3")
    @Test(groups = { "core" }, description = "4.1 Ensure at least one Prefix implementation is available/registered.")
    public void testEnsureHasPrefix() {
        AssertJUnit.assertTrue("TCK Configuration not available.", TCKSetup.getConfiguration() != null);
        AssertJUnit.assertTrue(!TCKSetup.getConfiguration().getPrefixClasses().isEmpty());
        AssertJUnit.assertTrue(TCKSetup.getConfiguration().getPrefixClasses().size() >= 2); // The 2 API prefixes must be there
    }
    
    /**
     * Ensure at least one Quantity implementation
     * is available/registered.
     */
    @SpecAssertion(section = "4.1", id = "41-A4")
    @Test(groups = { "core" }, description = "4.1 Ensure at least one Quantity implementation is available/registered.")
    public void testEnsureHasQuantity() {
        AssertJUnit.assertTrue("TCK Configuration not available.", TCKSetup.getConfiguration() != null);
        AssertJUnit.assertTrue(!TCKSetup.getConfiguration().getQuantityClasses().isEmpty());
    }
}
