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

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import javax.measure.Dimension;
import javax.measure.Unit;

import tec.units.tck.TCKSetup;

/**
 * Test class for base quantities.
 */
@SpecVersion(spec = "JSR 363", version = "0.8.0")
public class SupportedQuantiesTest {

	// ************************ 4.5 Supported Quantities
	// ************************

	/**
	 * Access a QuantityFactory for each registered type.
	 */
	@Test(groups = { "base_quantity" }, description = "4.5 Ensure all SI Base Quantities are used by an implementation")
	@SpecAssertion(section = "4.5", id = "45-A1")
	public void testContainsBaseDimensions() {
		final Collection<Dimension> baseDimensions = TCKSetup.getConfiguration().getBaseDimensions();
		final Map<Dimension, Unit<?>> foundUnits = new HashMap<>();
		assertEquals("Section 4.5: Number of SI Base Dimensions does not match", 7, baseDimensions.size());
		final Collection<? extends Unit<?>> units = TCKSetup.getConfiguration().getUnits4Test();
		for (Unit<?> unit : units) {
			System.out.println(unit + " (" + unit.getClass() + ")");
			Dimension dim = unit.getDimension();
			System.out.println(dim);
			if (baseDimensions.contains(dim)) {
				foundUnits.put(dim, unit);
			}
		}
		for (Dimension dim : baseDimensions) {
			Unit<?> unit = foundUnits.get(dim);
			assertNotNull("Section 4.5: SI Base Dimension " + dim + " not found", unit);
		}
	}
	
	/**
	 * Access a QuantityFactory for each registered type.
	 */
	@Test(groups = { "base_quantity", "derived_quantity" }, description = "4.5 Ensure all Supported Quantities are used by an implementation")
	@SpecAssertion(section = "4.5", id = "45-A2")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testContainsQuantities() {
		final Collection<Class> quantityTypes = TCKSetup.getConfiguration().getSupportedQuantityTypes();
		for (Class c : quantityTypes) {
			Unit unit = TCKSetup.getConfiguration().getUnit4Type(c);
			assertNotNull("Section 4.5: Quantity type " + c + " not found", unit);
		}
	}

}
