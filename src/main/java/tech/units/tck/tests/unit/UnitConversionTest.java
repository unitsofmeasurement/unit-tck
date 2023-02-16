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
package tech.units.tck.tests.unit;

import static tech.units.tck.TCKRunner.SECTION_PREFIX;
import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;
import static tech.units.tck.util.TestGroups.CORE;
import java.util.List;
import javax.measure.UnitConverter;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import tech.units.tck.TCKSetup;
import tech.units.tck.util.TestUtils;

/**
 * Tests for Unit Conversion
 *
 * @author Werner Keil
 * @author Almas Shaikh
 * @version 2.0, November 15, 2020
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class UnitConversionTest {
    private static final String SECTION = "4.2.3";
    
    /**
     * Ensure at least one UnitConverter implementation is available/registered.
     */
    @SpecAssertion(section = SECTION, id = "423-A1")
    @Test(groups = { CORE }, description = SECTION + " Ensure at least one UnitConverter implementation is available/registered.")
    public void testEnsureGotConverters() {
        AssertJUnit.assertTrue("TCK Configuration not available.", TCKSetup.getConfiguration() != null);
        AssertJUnit.assertFalse(TCKSetup.getConfiguration().getUnitConverters4Test().isEmpty());
    }

    /**
     * Test that UnitConverter implementations override equals.
     */
    @SpecAssertion(section = SECTION, id = "423-A2")
    @Test(groups = { CORE }, description = SECTION + " Ensure registered UnitConverter classes override equals.")
    public void testUnitConverterEquals() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
            Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION, type, "equals", true);
        }
    }

    /**
     * Test that UnitConverter implementations override hashCode.
     */
    @SpecAssertion(section = SECTION, id = "423-A3")
    @Test(groups = { CORE }, description = SECTION + " Ensure registered UnitConverter classes override hashCode.")
    public void testUnitConverterHashcode() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
            Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION, type, "hashCode");
        }
    }

    /**
     * Ensure the inverse() method is implemented.
     */
    @SpecAssertion(section = SECTION, id = "423-A4")
    @Test(groups = { CORE }, description = SECTION + " Ensure the inverse() method is implemented.")
    public void testUnitConverterInvert() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
            Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION, type, "inverse");
        }
    }

    /**
     * Ensure the isIdentity() operation is implemented.
     */
    @SpecAssertion(section = SECTION, id = "423-A5")
    @Test(groups = { CORE }, description = SECTION + " Ensure the isIdentity() method is implemented.")
    public void testUnitConverterIsIdentity() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
            Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION, type, "isIdentity");
        }
    }

    /**
     * Ensure the isLinear() operation is implemented.
     */
    @SpecAssertion(section = SECTION, id = "423-A6")
    @Test(groups = { CORE }, description = SECTION + " Ensure the isLinear() method is implemented.")
    public void testUnitConverterIsLinear() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
            Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION, type, "isLinear");
        }
    }

    /**
     * Ensure the convert() operation is implemented.
     */
    @SpecAssertion(section = SECTION, id = "423-A7")
    @Test(groups = { CORE }, description = SECTION + " Ensure the convert() method is implemented.")
    public void testUnitConverterConvert() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
            Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION, type, Number.class, "convert", Number.class);
        }
    }

    /**
     * Ensure the convert() operation is implemented.
     */
    @SpecAssertion(section = SECTION, id = "423-A8")
    @Test(groups = { CORE }, description = SECTION + " Ensure the convert() method is implemented.")
    public void testUnitConverterConvertWithDouble() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
            Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION, type, double.class, "convert", double.class);
        }
    }

    /**
     * Ensure the concatenate() operation is implemented.
     */
    @SpecAssertion(section = SECTION, id = "423-A9")
    @Test(groups = { CORE }, description = SECTION + " Ensure the concatenate() method is implemented.")
    public void testUnitConverterConcatenate() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
            Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION, type, UnitConverter.class, "concatenate", UnitConverter.class);
        }
    }

    /**
     * Ensure the getConversionSteps() operation is implemented.
     */
    @SpecAssertion(section = SECTION, id = "423-A10")
    @Test(groups = { CORE }, description = SECTION + " Ensure the getConversionSteps() method is implemented.")
    public void testUnitConverterGetConversionSteps() {
        for (UnitConverter converter : TCKSetup.getConfiguration().getUnitConverters4Test()) {
            Class<?> type = converter.getClass();
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION, type, List.class, "getConversionSteps");
        }
    }
}
