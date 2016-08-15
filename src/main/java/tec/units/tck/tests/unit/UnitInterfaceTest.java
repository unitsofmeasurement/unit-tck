/*
 * Units of Measurement TCK for Java 
 * Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided with
 * the distribution.
 * 
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tec.units.tck.tests.unit;

import static tec.units.tck.TCKRunner.SPEC_ID;
import static tec.units.tck.TCKRunner.SPEC_VERSION;
import javax.measure.Unit;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;
import tec.units.tck.TCKSetup;
import tec.units.tck.util.TestUtils;

/**
 * Testing the Unit Interface
 *
 * @author Werner Keil
 * @author Almas Shaikh
 * @version 1.0, August 16, 2016
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class UnitInterfaceTest {

    /**
     * Test that Unit implementations override equals.
     */
    @SpecAssertion(section = "4.2.1", id = "421-A1")
    @Test(groups = {"core"}, description = "4.2.1 Ensure registered Unit classes override equals.")
    public void testEquals() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1", type, "equals", true);
        }
    }

    /**
     * Test that Unit implementations contain getters
     */
    @SpecAssertion(section = "4.2.1", id = "421-A2")
    @Test(groups = {"core"}, description = "4.2.1 Ensure registered Unit classes implement getDimension.")
    public void testGetDimension() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1", type, "getDimension");
        }
    }

    /**
     * Test that Unit implementations contain getSystemUnit
     */
    @SpecAssertion(section = "4.2.1", id = "421-A3")
    @Test(groups = {"core"}, description = "4.2.1 Ensure registered Unit classes implement getSystemUnit.")
    public void testGetSystemUnit() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1", type, "getSystemUnit");
        }
    }

    /**
     * Test that Unit implementations contain getBaseUnits
     */
    @SpecAssertion(section = "4.2.1", id = "421-A4")
    @Test(groups = {"core"}, description = "4.2.1 Ensure registered Unit classes implement getBaseUnits.")
    public void testGetBaseUnits() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1", type, "getBaseUnits");
        }
    }

    /**
     * Test that Unit implementations contain getters
     */
    @SuppressWarnings({"rawtypes"})
    @SpecAssertion(section = "4.2.1", id = "421-A5")
    @Test(groups = {"core"}, description = "4.2.1 Ensure registered Unit classes implement getName.")
    public void testGetName() {
        for (Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1", type, "getName");
        }
    }

    /**
     * Test that Unit implementations contain getters
     */
    @SuppressWarnings({"rawtypes"})
    @SpecAssertion(section = "4.2.1", id = "421-A6")
    @Test(groups = {"core"}, description = "4.2.1 Ensure registered Unit classes implement getSymbol.")
    public void testGetSymbol() {
        for (Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1", type, "getSymbol");
        }
    }

    /**
     * Test that Unit implementations override hashCode.
     */
    @SpecAssertion(section = "4.2.1", id = "421-A7")
    @Test(groups = {"core"}, description = "4.2.1 Ensure registered Unit classes override hashCode.")
    public void testHashcode() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1", type, "hashCode");
        }
    }

    /**
     * Test that Unit implementations override toString.
     */
    @SpecAssertion(section = "4.2.1", id = "421-A8")
    @Test(groups = {"core"}, description = "4.2.1 Ensure registered Unit classes override toString.")
    public void testToString() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1", type, "toString");
        }
    }

    /**
     * Ensure the shift() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42121-A1")
    @Test(groups = {"core"}, description = "4.2.1.2.1 Ensure the shift() operation is implemented.")
    public void testUnit42121Shift() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.2", type, "shift", true);
        }
    }

    /**
     * Ensure the multiply() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42121-A2")
    @Test(groups = {"core"}, description = "4.2.1.2.1 Ensure the multiply() operation is implemented.")
    public void testUnit42121Multiply() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.2.1", type, Unit.class, "multiply", Unit.class);
        }
    } 

    /**
     * Ensure the divide() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42121-A3")
    @Test(groups = {"core"}, description = "4.2.1.2.1 Ensure the divide() operation is implemented.")
    public void testUnit42121Divide() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.4", type, Unit.class, "divide", Unit.class);
        }
    }

    /**
     * Ensure the multiply() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42121-A4")
    @Test(groups = {"core"}, description = "4.2.1.2.1 Ensure the multiply(double) operation is implemented.")
    public void testUnit42121MultiplyByDouble() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.3", type, Unit.class, "multiply", double.class);
        }
    }
    
    /**
     * Ensure the divide() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42121-A5")
    @Test(groups = {"core"}, description = "4.2.1.2.1 Ensure the divide(double) operation is implemented.")
    public void testUnit42121DivideByDouble() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.2.1", type, Unit.class, "divide", double.class);
        }
    }

    /**
     * Ensure the alternate() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42121-A6")
    @Test(groups = {"core"}, description = "4.2.1.2.1 Ensure the alternate() operation is implemented.")
    public void testUnit42121Alternate() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.2.1", type, "alternate", true);
        }
    }
    
    /**
     * Ensure the pow() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42122-A1")
    @Test(groups = {"core"}, description = "4.2.1.2.2 Ensure the pow() operation is implemented.")
    public void testUnit42122Pow() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.2.2", type, "pow", true);
        }
    }
    
    /**
     * Ensure the root() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42122-A2")
    @Test(groups = {"core"}, description = "4.2.1.2.2 Ensure the root() operation is implemented.")
    public void testUnit42122Root() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.2.2", type, "root", true);
        }
    }

    /**
     * Ensure the transform() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42122-A3")
    @Test(groups = {"core"}, description = "4.2.1.2.2 Ensure the transform() operation is implemented.")
    public void testUnit42122Transform() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.2.2", type, "transform", true);
        }
    }
    
    /**
     * Ensure the inverse() operation is implemented.
     */
    @SpecAssertion(section = "4.2.1.2", id = "42123-A1")
    @Test(groups = {"core"}, description = "4.2.1.2.3 Ensure the inverse() operation is implemented.")
    public void testUnit42123Inverse() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.1.2.3", type, "inverse", false);
        }
    }

    /**
     * Ensure the isCompatible() operation is implemented.
     */
    @SpecAssertion(section = "4.2.2", id = "422-A1")
    @Test(groups = {"core"}, description = "4.2.2 Ensure the isCompatible() operation is implemented.")
    public void testUnit422IsCompatible() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.3", type, "isCompatible", true);
        }
    }

    /**
     * Ensure the asType() operation is implemented.
     */
    @SpecAssertion(section = "4.2.2", id = "422-A2")
    @Test(groups = {"core"}, description = "4.2.2 Ensure the asType() operation is implemented.")
    public void testUnit423AsType() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.2", type, "asType", true);
        }
    }
    
    /**
     * Ensure the getConverterTo() operation is implemented.
     */
    @SpecAssertion(section = "4.2.3", id = "423-A1")
    @Test(groups = {"core"}, description = "4.2.3 Ensure the getConverterTo() operation is implemented.")
    public void testUnit423GetConverterTo() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.3", type, "getConverterTo", true);
        }
    }

    /**
     * Ensure the getConverterToAny() operation is implemented.
     */
    @SpecAssertion(section = "4.2.3", id = "423-A2")
    @Test(groups = {"core"}, description = "4.2.3 Ensure the getConverterToAny() operation is implemented.")
    public void testUnit423GetConverterToAny() {
        for (@SuppressWarnings("rawtypes")
        Class type : TCKSetup.getConfiguration().getUnitClasses()) {
            TestUtils.testHasPublicMethod("Section 4.2.3", type, "getConverterToAny", true);
        }
    }
}
