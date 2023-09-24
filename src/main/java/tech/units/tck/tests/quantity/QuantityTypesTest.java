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
package tech.units.tck.tests.quantity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import tech.units.tck.TCKSetup;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * Test class for quantities
 * @author Werner Keil
 * @version 2.0, August 31, 2023
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class QuantityTypesTest {
	private static final Logger logger = LoggerFactory.getLogger(QuantityTypesTest.class);
	
	// ************************ 4.4 Supported Quantities
	// ************************
	private static final String SECTION_NUM = "4.4";

	/**
	 * Check if all SI Base Quantities are used.
	 */
	@Test(groups = { "base_quantity" }, description = SECTION_NUM + " Ensure all SI Base Quantities are used by an implementation")
	@SpecAssertion(section = SECTION_NUM, id = "44-A1")
	public void testContainsBaseDimensions() {
		final Collection<Dimension> baseDimensions = TCKSetup.getConfiguration().getBaseDimensions();
		final Map<Dimension, Unit<?>> foundUnits = new HashMap<>();
		assertEquals(7, baseDimensions.size(), "Section " + SECTION_NUM + ": Number of SI Base Dimensions does not match");
		final Collection<? extends Unit<?>> units = TCKSetup.getConfiguration().getUnits4Test();
		for (Unit<?> unit : units) {
			Dimension dim = unit.getDimension();
			logger.debug(unit + "D: "+ dim  + " (" + unit.getClass() + ")");
			if (baseDimensions.contains(dim)) {
				foundUnits.put(dim, unit);
			}
		}
		for (Dimension dimension : baseDimensions) {
			final Unit<?> unit = foundUnits.get(dimension);
			assertNotNull(unit, "Section " + SECTION_NUM + ": SI Base Dimension " + dimension + " not found");
		}
	}
	
	/**
	 * Ensure all Supported Quantities are used by an implementation.
	 */
	@Test(groups = { "derived_quantity" }, description = SECTION_NUM + " Ensure all Supported Quantities are used by an implementation")
	@SpecAssertion(section = SECTION_NUM, id = "44-A2")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testContainsQuantities() {
		final Collection<Class<? extends Quantity>> quantityTypes = TCKSetup.getConfiguration().getSupportedQuantityTypes();
		for (Class c : quantityTypes) {
			final Unit unit = TCKSetup.getConfiguration().getUnit4Type(c);
			assertNotNull(unit, "Section " + SECTION_NUM + ": Quantity type " + c + " not found");
		}
	}
}
