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
package tec.units.tck.tests.quantity;

import static tec.units.tck.TCKRunner.SPEC_ID;
import static tec.units.tck.TCKRunner.SPEC_VERSION;

import javax.measure.Quantity;
import javax.measure.Unit;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import tec.units.tck.TCKSetup;
import tec.units.tck.util.TestUtils;

/**
 * Tests for The Quantity Interface
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @author Almas Shaikh
 * @version 1.0, August 16, 2016
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class QuantityInterfaceTest {
    private static final String SECTION = "4.4.1";
    
    /**
     * Test that Quantity implementations override equals.
     */
    @SpecAssertion(section = SECTION, id = "441-A1")
    @Test(groups = {"core"}, description = SECTION + " Ensure registered Quantity classes override equals.")
    public void testQuantityEquals() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section " + SECTION, type, "equals", true);
        }
    }

    /**
     * Test that Quantity implementations override getUnit.
     */
    @SpecAssertion(section = SECTION, id = "441-A2")
    @Test(groups = {"core"}, description = "4.4.1 Ensure registered Quantity classes implement getUnit.")
    public void testQuantityGetUnit() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1", type, "getUnit");
        }
    }

    /**
     * Test that Quantity implementations override getValue.
     */
    @SpecAssertion(section = "4.4.1", id = "441-A3")
    @Test(groups = {"core"}, description = "4.4.1 Ensure registered Quantity classes implement getValue.")
    public void testQuantityGetValue() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1", type, "getValue");
        }
    }

    /**
     * Test that Quantity implementations override hashCode.
     */
    @SpecAssertion(section = SECTION, id = "441-A4")
    @Test(groups = {"core"}, description = "4.4.1 Ensure registered Quantity classes override hashCode.")
    public void testQuantityHashcode() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1", type, "hashCode");
        }
    }

    /**
     * Test that Quantity implementations override asType method.
     */
    @SpecAssertion(section = SECTION, id = "441-A5")
    @Test(groups = {"core"}, description = "4.4.1 Ensure registered Quantity classes implement asType method.")
    public void testQuantityCastAsType() {
        for (Class type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1.1", type, Quantity.class, "asType", Class.class);
        }
    }

    /**
     * Test that Quantity implementations override add.
     */
    @SpecAssertion(section = "4.4.1.1", id = "4411-A1")
    @Test(groups = {"core"}, description = "4.4.1.1 Ensure registered Quantity classes implement add.")
    public void testQuantityOp1Add() {
        for (Class type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1.1", type, Quantity.class, "add", Quantity.class);
        }
    }

    /**
     * Test that Quantity implementations override multiply.
     */
    @SpecAssertion(section = "4.4.1.2", id = "4412-A1")
    @Test(groups = {"core"}, description = "4.4.1.2 Ensure registered Quantity classes implement multiply.")
    public void testQuantityOp2Multiply() {
        for (Class type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1.2", type, Quantity.class, "multiply", Quantity.class);
        }
    }

    /**
     * Test that Quantity implementations override divide.
     */
    @SpecAssertion(section = "4.4.1.2", id = "4412-A2")
    @Test(groups = {"core"}, description = "4.4.1.2 Ensure registered Quantity classes implement divide.")
    public void testQuantityOp2Divide() {
        for (Class type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1.2", type, Quantity.class, "divide", Quantity.class);
        }
    }

    /**
     * Test that Quantity implementations override multiply with number as argument.
     */
    @SpecAssertion(section = "4.4.1.1", id = "4411-A4")
    @Test(groups = {"core"}, description = "4.4.1.1 Ensure registered Quantity classes implement multiply by number.")
    public void testQuantityOp1MultiplyByNumber() {
        for (Class type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1.1", type, Quantity.class, "multiply", Number.class);
        }
    }

    /**
     * Test that Quantity implementations override divide with number as argument.
     */
    @SpecAssertion(section = "4.4.1.1", id = "4411-A5")
    @Test(groups = {"core"}, description = "4.4.1.1 Ensure registered Quantity classes implement divide by number.")
    public void testQuantityOp1DivideByNumber() {
        for (Class type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1.1", type, Quantity.class, "divide", Number.class);
        }
    }

    /**
     * Test that Quantity implementations override subtract.
     */
    @SpecAssertion(section = "4.4.1.1", id = "4411-A6")
    @Test(groups = {"core"}, description = "4.4.1.1 Ensure registered Quantity classes implement subtract.")
    public void testQuantityOp1Subtract() {
        for (Class type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1.1", type, Quantity.class, "subtract", Quantity.class);
        }
    }

    /**
     * Test that Quantity implementations override to method.
     */
    @SpecAssertion(section = "4.4.1.2", id = "4412-A3")
    @Test(groups = {"core"}, description = "4.4.1.2 Ensure registered Quantity classes implement to method.")
    public void testQuantityOp2To() {
        for (Class type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1.2", type, Quantity.class, "to", Unit.class);
        }
    }

    /**
     * Test that Quantity implementations override getUnit.
     */
    @SpecAssertion(section = "4.4.1.3", id = "441-A8")
    @Test(groups = {"core"}, description = "4.4.1.3 Ensure registered Quantity classes implement inverse method.")
    public void testQuantityOp3Inverse() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod("Section 4.4.1.3", type, "inverse");
        }
    }
}
