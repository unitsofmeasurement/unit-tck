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
package tech.units.tck.tests.quantity;

import static tech.units.tck.TCKRunner.SECTION_PREFIX;
import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;
import static tech.units.tck.util.TestGroups.CORE;

import javax.measure.Quantity;
import javax.measure.Unit;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import tech.units.tck.TCKSetup;
import tech.units.tck.util.TestUtils;

/**
 * Tests for The Quantity Interface
 *
 * @author <a href="mailto:werner@units.tech">Werner Keil</a>
 * @author Almas Shaikh
 * @version 2.0, November 15, 2020
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class QuantityInterfaceTest {
    private static final String SECTION_NUM = "4.3.1";
    
    /**
     * Test that Quantity implementations override asType method.
     */
    @SpecAssertion(section = SECTION_NUM, id = "431-A1")
    @Test(groups = { CORE }, description = SECTION_NUM + " Ensure registered Quantity classes implement asType method.")
    public void testQuantityCastAsType() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, false, Quantity.class, "asType", Class.class);
        }
    }
    /**
     * Test that Quantity implementations override equals.
     */
    @SpecAssertion(section = SECTION_NUM, id = "431-A2")
    @Test(groups = { CORE }, description = SECTION_NUM + " Ensure registered Quantity classes override equals.")
    public void testQuantityEquals() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX +  SECTION_NUM, type, "equals", true);
        }
    }
    
    /**
     * Test that Quantity implementations override getScale.
     */
    @SpecAssertion(section = SECTION_NUM, id = "431-A3")
    @Test(groups = { CORE }, description = SECTION_NUM + " Ensure registered Quantity classes implement getScale method.")
    public void testQuantityGetScale() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, "getScale");
        }
    }


    /**
     * Test that Quantity implementations override getUnit.
     */
    @SpecAssertion(section = SECTION_NUM, id = "431-A4")
    @Test(groups = { CORE }, description = SECTION_NUM + " Ensure registered Quantity classes implement getUnit.")
    public void testQuantityGetUnit() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, "getUnit");
        }
    }

    /**
     * Test that Quantity implementations override getValue.
     */
    @SpecAssertion(section = SECTION_NUM, id = "431-A5")
    @Test(groups = { CORE }, description = SECTION_NUM + " Ensure registered Quantity classes implement getValue.")
    public void testQuantityGetValue() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, "getValue");
        }
    }

    /**
     * Test that Quantity implementations override hashCode.
     */
    @SpecAssertion(section = SECTION_NUM, id = "431-A6")
    @Test(groups = { CORE }, description = SECTION_NUM + " Ensure registered Quantity classes override hashCode.")
    public void testQuantityHashCode() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, "hashCode");
        }
    }
    
    /**
     * Test that Quantity implementations override to method.
     */
    @SpecAssertion(section = SECTION_NUM, id = "431-A7")
    @Test(groups = { CORE }, description = SECTION_NUM + " Ensure registered Quantity classes implement isEquivalentTo method.")
    public void testQuantityIsEquivalentTo() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
        	TestUtils.testHasPublicMethod(SECTION_PREFIX +  SECTION_NUM, type, "isEquivalentTo", true);
        }
    }
    
    /**
     * Test that Quantity implementations override inverse.
     */
    @SpecAssertion(section = SECTION_NUM, id = "431-A8")
    @Test(groups = { CORE }, description = SECTION_NUM + " Ensure registered Quantity classes implement inverse method.")
    public void testQuantityOp0Inverse() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX +  SECTION_NUM, type, "inverse");
        }
    }
    
    /**
     * Test that Quantity implementations override add.
     */
    @SpecAssertion(section = "4.3.1.1", id = "4311-A1")
    @Test(groups = { CORE }, description = "4.3.1.1 Ensure registered Quantity classes implement add.")
    public void testQuantityOp1Add() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + "4.3.1.1", type, Quantity.class, "add", Quantity.class);
        }
    }

    /**
     * Test that Quantity implementations override multiply with number as argument.
     */
    @SpecAssertion(section = "4.3.1.1", id = "4311-A4")
    @Test(groups = { CORE }, description = "4.3.1.1 Ensure registered Quantity classes implement multiply by number.")
    public void testQuantityOp1MultiplyByNumber() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + "4.3.1.1", type, Quantity.class, "multiply", Number.class);
        }
    }

    /**
     * Test that Quantity implementations override divide with number as argument.
     */
    @SpecAssertion(section = "4.3.1.1", id = "4311-A5")
    @Test(groups = { CORE }, description = "4.3.1.1 Ensure registered Quantity classes implement divide by number.")
    public void testQuantityOp1DivideByNumber() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + "4.3.1.1", type, Quantity.class, "divide", Number.class);
        }
    }

    /**
     * Test that Quantity implementations override subtract.
     */
    @SpecAssertion(section = "4.3.1.1", id = "4311-A6")
    @Test(groups = { CORE }, description = "4.3.1.1 Ensure registered Quantity classes implement subtract.")
    public void testQuantityOp1Subtract() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + "4.3.1.1", type, Quantity.class, "subtract", Quantity.class);
        }
    }

    /**
     * Test that Quantity implementations override divide.
     */
    @SpecAssertion(section = "4.3.1.2", id = "4312-A1")
    @Test(groups = { CORE }, description = "4.3.1.2 Ensure registered Quantity classes implement divide.")
    public void testQuantityOp2Divide() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + "4.3.1.2", type, Quantity.class, "divide", Quantity.class);
        }
    }

    /**
     * Test that Quantity implementations override multiply.
     */
    @SpecAssertion(section = "4.3.1.2", id = "4312-A2")
    @Test(groups = { CORE }, description = "4.3.1.2 Ensure registered Quantity classes implement multiply.")
    public void testQuantityOp2Multiply() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX + "4.3.1.2", type, Quantity.class, "multiply", Quantity.class);
        }
    }
    
    /**
     * Test that Quantity implementations override to method.
     */
    @SpecAssertion(section = SECTION_NUM, id = "431-A9")
    @Test(groups = { CORE }, description = SECTION_NUM + " Ensure registered Quantity classes implement to method.")
    public void testQuantityOp0To() {
        for (Class<?> type : TCKSetup.getConfiguration().getQuantityClasses()) {
            TestUtils.testHasPublicMethod(SECTION_PREFIX +  SECTION_NUM, type, Quantity.class, "to", Unit.class);
        }
    }        
}
