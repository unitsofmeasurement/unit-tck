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
package tec.units.tck.tests;

import static tec.units.tck.TCKRunner.SPEC_ID;
import static tec.units.tck.TCKRunner.SPEC_VERSION;

import javax.measure.UnitConverter;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import tec.units.tck.TCKSetup;
import tec.units.tck.util.TestUtils;

/**
 * Tests for Unit Conversion
 *
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 */
@SpecVersion(spec = SPEC_ID, version =  SPEC_VERSION)
public class UnitConversionTest {

    /**
     * Ensure at least one UnitConverter implementation
     * is available/registered.
     */
    @SpecAssertion(section = "4.2.3", id = "423-A1")
    @Test(groups = { "core" }, description = "4.2.3 Ensure at least one javax.measure.UnitConverter implementation is available/registered.")
    public void testEnsureGotConverters() {
        AssertJUnit.assertTrue("TCK Configuration not available.", TCKSetup.getConfiguration() != null);
        AssertJUnit.assertFalse(TCKSetup.getConfiguration().getUnitConverters4Test().isEmpty());
    }
      
    /**
     * Test that UnitConverter implementations override equals.
     */
    @SpecAssertion(section = "4.2.3", id = "423-A2")
    @Test(groups = { "core" }, description = "4.2.3 Ensure registered UnitConverter classes override equals.")
    public void testUnitConverterEquals() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
        	Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod("Section 4.2.3", type, boolean.class, "equals", Object.class);
        }
    }
       
    /**
     * Test that UnitConverter implementations override hashCode.
     */
    @SpecAssertion(section = "4.2.3", id = "423-A3")
    @Test(groups = { "core" }, description = "4.2.3 Ensure registered UnitConverter classes override hashCode.")
    public void testUnitConverterHashcode() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
        	Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod("Section 4.2.3", type, int.class, "hashCode");
        }
    }
    
    /**
     * Ensure the inverse() method is implemented.
     */
    @SpecAssertion(section = "4.2.3", id = "423-A4")
    @Test(groups = { "core" }, description = "4.2.3 Ensure the inverse() method is implemented.")
    public void testUnitConverterInvert() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
        	Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod("Section 4.2.3", type, "inverse");
        }
    }
    
    /**
     * Ensure the isIdentity() operation is implemented.
     */
    @SpecAssertion(section = "4.2.3", id = "423-A5")
    @Test(groups = { "core" }, description = "4.2.3 Ensure the isIdentity() method is implemented.")
    public void testUnitConverterIsIdentity() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
        	Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod("Section 4.2.3", type, "isIdentity");
        }
    }
    
    /**
     * Ensure the isLinear() operation is implemented.
     */
    @SpecAssertion(section = "4.2.3", id = "423-A6")
    @Test(groups = { "core" }, description = "4.2.3 Ensure the isLinear() method is implemented.")
    public void testUnitConverterIsLinear() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
        	Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod("Section 4.2.3", type, "isLinear");
        }
    }
}
