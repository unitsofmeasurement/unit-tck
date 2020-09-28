/*
 * Units of Measurement TCK
 * Copyright © 2005-2020, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
package tech.units.tck.tests.unit;

import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import tech.units.tck.TCKSetup;
import tech.units.tck.util.TestUtils;

/**
 * Tests for Unit Conversion
 *
 * @author Werner Keil
 * @version 1.2, July 7, 2019
 * @since 2.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class PrefixInterfaceTest {
    private static final String SECTION = "4.2.4";
    
    /**
     * Test that Dimension implementations override equals.
     */
    @SuppressWarnings("deprecation")
	@SpecAssertion(section = SECTION, id = "424-A1")
    @Test(groups = {"core"}, description = SECTION + " Ensure supported Prefix classes override equals.")
    public void testEquals() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getPrefixClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, boolean.class, "equals", Object.class);
        }
    }

    /**
     * Test that Dimension implementations override hashCode.
     */
    @SuppressWarnings("deprecation")
	@SpecAssertion(section = SECTION, id = "424-A2")
    @Test(groups = {"core"}, description = SECTION + " Ensure supported Prefix classes override hashCode.")
    public void testHashcode() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getPrefixClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, int.class, "hashCode");
        }
    }

	/**
	 * Test that Prefix implementations override getName.
	 */
	@SpecAssertion(section = SECTION, id = "424-A3")
	@Test(groups = { "core" }, description = SECTION + " Ensure supported Prefix implementations override getName.")
	public void testGetName() {
		for (@SuppressWarnings("rawtypes")
		Class type : TCKSetup.getConfiguration().getPrefixClasses()) {
			TestUtils.testHasPublicMethod("Section " + SECTION, type, "getName", true);
		}
	}
	
	/**
	 * Test that Prefix implementations override getSymbol.
	 */
	@SpecAssertion(section = SECTION, id = "424-A4")
	@Test(groups = { "core" }, description = SECTION + " Ensure supported Prefix implementations override getSymbol.")
	public void testGetSymbol() {
		for (@SuppressWarnings("rawtypes")
		Class type : TCKSetup.getConfiguration().getPrefixClasses()) {
			TestUtils.testHasPublicMethod("Section " + SECTION, type, "getSymbol", true);
		}
	}

    /**
     * Test that Prefix implementations override getValue.
     */
    @SuppressWarnings("deprecation")
	@SpecAssertion(section = SECTION, id = "424-A5")
    @Test(groups = {"core"}, description = SECTION + " Ensure supported Prefix implementations override getValue.")
    public void testGetValue() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getPrefixClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, Number.class, "getValue");
        }
    }
    
    /**
     * Test that Prefix implementations override getExponent.
     */
    @SuppressWarnings("deprecation")
	@SpecAssertion(section = SECTION, id = "424-A6")
    @Test(groups = {"core"}, description = SECTION + " Ensure supported Prefix implementations override getExponent.")
    public void testGetXponent() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getPrefixClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, int.class, "getExponent");
        }
    }
}
