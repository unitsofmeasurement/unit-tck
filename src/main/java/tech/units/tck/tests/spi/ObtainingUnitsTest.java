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
package tech.units.tck.tests.spi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static tech.units.tck.TCKRunner.SECTION_PREFIX;
import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnits;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

/**
 * Test class for obtaining units.
 * @author Werner Keil
 * @version 2.0, August 31, 2023
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class ObtainingUnitsTest {
    private static final String SECTION_NUM1 = "5.5.1";
    private static final String SECTION_NUM2 = "5.5.2";
    
    // ************************ 5.5 Obtaining Unit Instances
    // ************************
    /**
     * Access a SystemOfUnits for each registered unit.
     */
    @SuppressWarnings("rawtypes")
    @Test(groups = { "spi" }, description = SECTION_NUM1
	    + " Units Obtained from Unit Systems")
    @SpecAssertion(section = SECTION_NUM1, id = "551-A1")
    public void testGetUnitsFromSystemOfUnits() {
		for (SystemOfUnits sou : ServiceProvider.current()
			.getSystemOfUnitsService().getAvailableSystemsOfUnits()) {
		    for (Unit u : sou.getUnits()) {
		    	assertNotNull(u, SECTION_PREFIX + SECTION_NUM1 + ": A Unit is missing from " + sou.getName());
		    }
		}
    }    
    
    /**
     * Try parsing the symbol for each registered unit.
     */
    @SuppressWarnings("rawtypes")
    @Test(groups = { "spi" }, description = SECTION_NUM2
	    + " Units Obtained by Symbol Parsing")
    @SpecAssertion(section = SECTION_NUM2, id = "552-A1")
    public void testGetUnitsFromUnitString() {
	final UnitFormat format = ServiceProvider.current().getFormatService().getUnitFormat();
//		System.out.println("Fmt: " + format.toString()); XXX For debugging, comment in if necessary
		for (SystemOfUnits sou : ServiceProvider.current()
			.getSystemOfUnitsService().getAvailableSystemsOfUnits()) {
//			int i = 1;
		    for (Unit u : sou.getUnits()) {
		    	assertNotNull(u, SECTION_PREFIX + SECTION_NUM2 + ": A Unit is missing from " + sou.getName());
				if (u.getSymbol() != null) {
				    String s = u.toString();
//				    System.out.println("S " + i + ": " + s + "(" + u.getSymbol() + ")");
				    Unit p = format.parse(s);
				    assertEquals(u, p, SECTION_PREFIX + SECTION_NUM2 + ": Unit could not be parsed for '" + s + "'");
//				    i++;
				}
		    }
		}
    }
}
