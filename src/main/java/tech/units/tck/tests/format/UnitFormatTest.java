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
package tech.units.tck.tests.format;

import static tech.units.tck.TCKRunner.SECTION_PREFIX;
import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;
import static tech.units.tck.util.TestGroups.FORMAT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.testng.Assert.assertNotNull;
import static tech.units.tck.util.TestUtils.MSG_NO_TCK_CONFIG;
import static tech.units.tck.util.TestUtils.testHasPublicMethod;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import tech.units.tck.TCKSetup;

/**
 * Tests for UnitFormat
 * @version 2.3, October 4, 2023
 * @since 1.0
 * @author  <a href="mailto:werner@units.tech">Werner Keil</a>
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class UnitFormatTest {
	private static final String SECTION_NUM = "4.5";
	
    /**
     * Ensure at least one UnitFormat implementation
     * is available/registered.
     */
    @SpecAssertion(section = SECTION_NUM, id = "45-A1")
    @Test(groups = { FORMAT }, description = SECTION_NUM + " Ensure at least one UnitFormat implementation is available/registered.")
    public void testEnsureGotUnitFormat() {
        assertNotNull(TCKSetup.getConfiguration(), MSG_NO_TCK_CONFIG);        
        assertThat("No UnitFormat implementation found.", TCKSetup.getConfiguration().getUnitFormats4Test(), is(not(empty())));
    }
    
    /**
     * Ensure the format() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM, id = "45-A2")
    @Test(groups = { FORMAT }, description = SECTION_NUM + " Ensure the format() operation is implemented.")
    public void testUnitFormatFormat() {
        for (UnitFormat format : TCKSetup.getConfiguration().getUnitFormats4Test()) {
        	Class<?> type = format.getClass();
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, false, String.class, "format", Unit.class);
        }
    }
    
    /**
     * Ensure the appendable format() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM, id = "45-A3")
    @Test(groups = { FORMAT }, description = SECTION_NUM + " Ensure the appendable format() operation is implemented.")
    public void testUnitFormatFormatAppendable() {
        for (UnitFormat format : TCKSetup.getConfiguration().getUnitFormats4Test()) {
        	Class<?> type = format.getClass();
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, false, Appendable.class, "format", Unit.class, Appendable.class);
        }
    }
    
    /**
     * Ensure the isLocaleSensitive() method is implemented.
     */
    @SpecAssertion(section = SECTION_NUM, id = "45-A4")
    @Test(groups = { FORMAT }, description = SECTION_NUM + " Ensure the isLocaleSensitive() method is implemented.")
    public void testUnitFormatFormatIsLocalSensitive() {
        for (UnitFormat format : TCKSetup.getConfiguration().getUnitFormats4Test()) {
        	Class<?> type = format.getClass();
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, "isLocaleSensitive", false);
        }
    }
    
    /**
     * Ensure the label() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM, id = "45-A5")
    @Test(groups = { FORMAT }, description = SECTION_NUM + " Ensure the label() operation is implemented.")
    public void testUnitFormatLabel() {
        for (UnitFormat format : TCKSetup.getConfiguration().getUnitFormats4Test()) {
        	Class<?> type = format.getClass();
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, "label", true);
        }
    }
    
    /**
     * Ensure the parse() operation is implemented.
     */
    @SpecAssertion(section = SECTION_NUM, id = "45-A6")
    @Test(groups = { FORMAT }, description = SECTION_NUM + " Ensure the parse() operation is implemented.")
    public void testUnitFormatParse() {
        for (UnitFormat format : TCKSetup.getConfiguration().getUnitFormats4Test()) {
        	Class<?> type = format.getClass();
            testHasPublicMethod(SECTION_PREFIX + SECTION_NUM, type, "parse", true);
        }
    }
}
