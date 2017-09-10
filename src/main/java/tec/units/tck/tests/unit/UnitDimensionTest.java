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
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
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
package tec.units.tck.tests.unit;

import static tec.units.tck.TCKRunner.SPEC_ID;
import static tec.units.tck.TCKRunner.SPEC_VERSION;

import java.util.Map;

import javax.measure.Dimension;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import tec.units.tck.TCKSetup;
import tec.units.tck.util.TestUtils;

/**
 * Unit Dimension Tests
 *
 * @author Werner Keil
 * @author Almas Shaikh
 * @version 1.0, August 16, 2016
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class UnitDimensionTest {
    private static final String SECTION = "4.2.4";
    
    /**
     * Test that Dimension implementations override equals.
     */
    @SpecAssertion(section = SECTION, id = "424-A1")
    @Test(groups = {"core"}, description = SECTION + " Ensure registered Dimension classes override equals.")
    public void testUnitEquals() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getDimensionClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, boolean.class, "equals", Object.class);
        }
    }

    /**
     * Test that Dimension implementations override hashCode.
     */
    @SpecAssertion(section = SECTION, id = "424-A2")
    @Test(groups = {"core"}, description = SECTION + " Ensure registered Dimension classes override hashCode.")
    public void testUnitHashcode() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getDimensionClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, int.class, "hashCode");
        }
    }

    /**
     * Test that Dimension implementations override multiply.
     */
    @SpecAssertion(section = SECTION, id = "424-A3")
    @Test(groups = {"core"}, description = SECTION + " Ensure registered Dimension classes override multiply.")
    public void testUnitMultiply() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getDimensionClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, Dimension.class, "multiply", Dimension.class);
        }
    }

    /**
     * Test that Dimension implementations override divide.
     */
    @SpecAssertion(section = SECTION, id = "424-A4")
    @Test(groups = {"core"}, description = SECTION + " Ensure registered Dimension classes override divide.")
    public void testUnitDivide() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getDimensionClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, Dimension.class, "divide", Dimension.class);
        }
    }

    /**
     * Test that Dimension implementations override root.
     */
    @SpecAssertion(section = SECTION, id = "424-A5")
    @Test(groups = {"core"}, description = SECTION + " Ensure registered Dimension classes override root.")
    public void testUnitRoot() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getDimensionClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, Dimension.class, "root", int.class);
        }
    }

    /**
     * Test that Dimension implementations override pow.
     */
    @SpecAssertion(section = SECTION, id = "424-A6")
    @Test(groups = {"core"}, description = SECTION + " Ensure registered Dimension classes override pow.")
    public void testUnitPow() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getDimensionClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, Dimension.class, "pow", int.class);
        }
    }

    /**
     * Test that Dimension implementations override getBaseDimensions.
     */
    @SpecAssertion(section = SECTION, id = "424-A7")
    @Test(groups = {"core"}, description = SECTION + " Ensure registered Dimension classes override getBaseDimensions.")
    public void testUnitGetProductDimensions() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getDimensionClasses()) {
            TestUtils.testHasPublicMethod("Section "+ SECTION, type, Map.class, "getBaseDimensions");
        }
    }
}
