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
import static tech.units.tck.TCKRunner.SECTION_PREFIX;
import static tech.units.tck.util.TestGroups.CORE;
import static tech.units.tck.util.TestUtils.testHasPublicMethod;

import javax.measure.Prefix;
import javax.measure.Unit;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import tech.units.tck.TCKSetup;

/**
 * Testing the Unit Interface
 *
 * @author <a href="mailto:werner@units.tech">Werner Keil</a>
 * @author Almas Shaikh
 * @version 2.1, November 15, 2020
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class UnitInterfaceTest {
	private static final String SECTION_NUM1 = "4.2.1";	
	private static final String SECTION_NUM2 = "4.2.1.2";
	
    /**
     * Test that Unit implementations override equals.
     */
    @SpecAssertion(section = SECTION_NUM1, id = "421-A1")
    @Test(groups = { CORE }, description = SECTION_NUM1 + " Ensure registered Unit classes override equals.")
    public void testEquals() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM1, type, "equals", true);
        }
    }

    /**
     * Test that Unit implementations contain getters
     */
    @SpecAssertion(section = SECTION_NUM1, id = "421-A2")
    @Test(groups = { CORE }, description = SECTION_NUM1 + " Ensure registered Unit classes implement getDimension.")
    public void testGetDimension() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM1, type, "getDimension");
        }
    }

    /**
     * Test that Unit implementations contain getSystemUnit
     */
    @SpecAssertion(section = SECTION_NUM1, id = "421-A3")
    @Test(groups = { CORE }, description = SECTION_NUM1 + " Ensure registered Unit classes implement getSystemUnit.")
    public void testGetSystemUnit() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM1, type, "getSystemUnit");
        }
    }

    /**
     * Test that Unit implementations contain getBaseUnits
     */
    @SpecAssertion(section = SECTION_NUM1, id = "421-A4")
    @Test(groups = { CORE }, description = SECTION_NUM1 + "Ensure registered Unit classes implement getBaseUnits.")
    public void testGetBaseUnits() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM1, type, "getBaseUnits");
        }
    }

    /**
     * Test that Unit implementations contain getters
     */
    @SuppressWarnings({"rawtypes"})
    @SpecAssertion(section = SECTION_NUM1, id = "421-A5")
    @Test(groups = { CORE }, description = SECTION_NUM1 + "Ensure registered Unit classes implement getName.")
    public void testGetName() {
        for (Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM1, type, "getName");
        }
    }

    /**
     * Test that Unit implementations contain getters
     */
    @SuppressWarnings({"rawtypes"})
    @SpecAssertion(section = SECTION_NUM1, id = "421-A6")
    @Test(groups = { CORE }, description = SECTION_NUM1 + "Ensure registered Unit classes implement getSymbol.")
    public void testGetSymbol() {
        for (Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM1, type, "getSymbol");
        }
    }

    /**
     * Test that Unit implementations override hashCode.
     */
    @SpecAssertion(section = SECTION_NUM1, id = "421-A7")
    @Test(groups = { CORE }, description = SECTION_NUM1 + "Ensure registered Unit classes override hashCode.")
    public void testHashcode() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM1, type, "hashCode");
        }
    }
    
    /**
     * Test that Unit implementations implement isEquivalentTo.
     */
    @SpecAssertion(section = SECTION_NUM1, id = "421-A8")
    @Test(groups = { CORE }, description = SECTION_NUM1 + " Ensure registered Unit classes implement isEquivalentTo.")
    public void testIsEquivalentTo() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
        	testHasPublicMethod(SECTION_PREFIX + SECTION_NUM1, type, "isEquivalentTo", true);
        }
    }    
    
    /**
     * Test that Unit implementations override toString.
     */
    @SpecAssertion(section = SECTION_NUM1, id = "421-A9")
    @Test(groups = { CORE }, description = SECTION_NUM1 + "Ensure registered Unit classes override toString.")
    public void testToString() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM1, type, "toString");
        }
    }

    /**
     * Ensure the alternate() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42121-A1")
    @Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the alternate() operation is implemented.")
    public void testUnit42121A1_Alternate() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, "alternate", true);
        }
    }
    
    /**
     * Ensure the divide(Unit) operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42121-A2")
    @Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the divide(Unit) operation is implemented.")
    public void testUnit42121A2_Divide() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, Unit.class, "divide", Unit.class);
        }
    }
    
    /**
     * Ensure the divide(double) operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42121-A3")
    @Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the divide(double) operation is implemented.")
    public void testUnit42121A3_DivideByDouble() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, Unit.class, "divide", double.class);
        }
    }

	/**
	 * Ensure the divide(Number) operation is implemented.
	 */
	@SpecAssertion(section = SECTION_NUM2, id = "42121-A4")
	@Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the divide(Number) operation is implemented.")
	public void testUnit42121A4_DivideByNumber() {
		for (@SuppressWarnings("rawtypes")
			Class type : TCKSetup.getConfiguration().getUnitClasses()) {
			testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, Unit.class, "divide", Number.class);
		}
	}
    
    /**
     * Ensure the multiply() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42121-A5")
    @Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the multiply() operation is implemented.")
    public void testUnit42121A5_Multiply() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, Unit.class, "multiply", Unit.class);
        }
    } 

    /**
     * Ensure the multiply(double) operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42121-A6")
    @Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the multiply(double) operation is implemented.")
    public void testUnit42121A6_MultiplyByDouble() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, Unit.class, "multiply", double.class);
        }
    }

	/**
	 * Ensure the multiply(Number) operation is implemented.
	 */
	@SpecAssertion(section = SECTION_NUM2, id = "42121-A7")
	@Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the multiply(Number) operation is implemented.")
	public void testUnit42121A7_MultiplyByNumber() {
		for (@SuppressWarnings("rawtypes")
			Class type : TCKSetup.getConfiguration().getUnitClasses()) {
			testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, Unit.class, "multiply", Number.class);
		}
	}
    
    /**
     * Ensure the prefix() operation is implemented.
     * @since 2.0
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42121-A8")
    @Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the prefix() operation is implemented.")
    public void testUnit42121A8_Prefix() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, false, Unit.class, "prefix", Prefix.class);
        }
    }
    
    /**
     * Ensure the shift() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42121-A9")
    @Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the shift(double) operation is implemented.")
    public void testUnit42121A9_ShiftByDouble() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
			testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, Unit.class, "shift", double.class);
        }
    }

	/**
	 * Ensure the shift(Number) operation is implemented.
	 */
	@SpecAssertion(section = SECTION_NUM2, id = "42121-A10")
	@Test(groups = { CORE }, description = "4.2.1.2.1 Ensure the shift(Number) operation is implemented.")
	public void testUnit42121A10_ShiftByNumber() {
		for (@SuppressWarnings("rawtypes")
			Class type : TCKSetup.getConfiguration().getUnitClasses()) {
			testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.1", type, Unit.class, "shift", Number.class);
		}
	}
      
    /**
     * Ensure the pow() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42122-A1")
    @Test(groups = { CORE }, description = "4.2.1.2.2 Ensure the pow() operation is implemented.")
    public void testUnit42122Pow() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.2", type, "pow", true);
        }
    }
    
    /**
     * Ensure the root() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42122-A2")
    @Test(groups = { CORE }, description = "4.2.1.2.2 Ensure the root() operation is implemented.")
    public void testUnit42122Root() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.2", type, "root", true);
        }
    }

    /**
     * Ensure the transform() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42122-A3")
    @Test(groups = { CORE }, description = "4.2.1.2.2 Ensure the transform() operation is implemented.")
    public void testUnit42122Transform() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.2", type, "transform", true);
        }
    }
    
    /**
     * Ensure the inverse() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42123-A1")
    @Test(groups = { CORE }, description = "4.2.1.2.3 Ensure the inverse() operation is implemented.")
    public void testUnit42123Inverse() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.3", type, "inverse", false);
        }
    }

    /**
     * Ensure the isCompatible() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42124-A1")
    @Test(groups = { CORE }, description = SECTION_NUM1 + "Ensure the isCompatible() operation is implemented.")
    public void testUnit4221IsCompatible() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.4", type, "isCompatible", true);
        }
    }

    /**
     * Ensure the asType() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42124-A2")
    @Test(groups = { CORE }, description = SECTION_NUM1 + "Ensure the asType() operation is implemented.")
    public void testUnit4222AsType() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.4", type, "asType", true);
        }
    }
    
    /**
     * Ensure the getConverterTo() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42124-A3")
    @Test(groups = { CORE }, description = SECTION_NUM1 + "Ensure the getConverterTo() operation is implemented.")
    public void testUnit4223GetConverterTo() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.4", type, "getConverterTo", true);
        }
    }

    /**
     * Ensure the getConverterToAny() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM2, id = "42124-A4")
    @Test(groups = { CORE }, description = SECTION_NUM1 + "Ensure the getConverterToAny() operation is implemented.")
    public void testUnit4224GetConverterToAny() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            testHasPublicMethod(SECTION_PREFIX + "4.2.1.2.4", type, "getConverterToAny", true);
        }
    }
}
