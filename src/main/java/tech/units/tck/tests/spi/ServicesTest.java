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

import static org.testng.AssertJUnit.assertNotNull;
import static tech.units.tck.TCKRunner.SECTION_PREFIX;
import static tech.units.tck.TCKRunner.SPEC_ID;
import static tech.units.tck.TCKRunner.SPEC_VERSION;
import static tech.units.tck.util.TestGroups.SPI;
import static javax.measure.spi.FormatService.FormatType.UNIT_FORMAT;
import static javax.measure.spi.FormatService.FormatType.QUANTITY_FORMAT;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import javax.measure.BinaryPrefix;
import javax.measure.MetricPrefix;
import javax.measure.spi.FormatService;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnitsService;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

/**
 * Test class for Services.
 * 
 * @author Werner Keil
 * @version 2.1, November 15, 2020
 * @since 1.0
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class ServicesTest {
	private static final String SECTION_NUM = "5.4";
	private static final String DESCRIPTION = SECTION_NUM + " Services";

	// ************************ 5.4 Services
	// ************************
	/**
	 * Access available FormatServices.
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A01")
	public void testFormatService() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			FormatService service = provider.getFormatService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": FormatService is null", service);
		}
	}

	// ************************ 5.4 Services
	// ************************
	/**
	 * Access available QuantityFormats in FormatServices.
	 * @since 2.1
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A02")
	public void testFormatServiceQuantityFormatsAvailable() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			FormatService service = provider.getFormatService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": FormatService is null", service);
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Available QuantityFormat names are null",
					service.getAvailableFormatNames(QUANTITY_FORMAT));
			assertFalse(SECTION_PREFIX + SECTION_NUM + " No available QuantityFormat names found",
					service.getAvailableFormatNames(QUANTITY_FORMAT).isEmpty());
		}
	}
	
	// ************************ 5.4 Services
	// ************************
	/**
	 * Access default QuantityFormat in FormatServices.
	 * @since 2.1
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A03")
	public void testFormatServiceQuantityFormatsDefault() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			FormatService service = provider.getFormatService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": FormatService is null", service);
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Default QuantityFormat is null", service.getUnitFormat());
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Available QuantityFormat names are null",
					service.getAvailableFormatNames(QUANTITY_FORMAT));
			assertFalse(SECTION_PREFIX + SECTION_NUM + " No available QuantityFormat names found",
					service.getAvailableFormatNames(QUANTITY_FORMAT).isEmpty());
		}
	}

	// ************************ 5.4 Services
	// ************************
	/**
	 * Access available UnitFormats in FormatServices.
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A04")
	public void testFormatServiceUnitFormatsAvailable() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			FormatService service = provider.getFormatService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": FormatService is null", service);
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Available UnitFormat names are null",
					service.getAvailableFormatNames(UNIT_FORMAT));
			assertFalse(SECTION_PREFIX + SECTION_NUM + " No available UnitFormat names found",
					service.getAvailableFormatNames(UNIT_FORMAT).isEmpty());
		}
	}
	
	// ************************ 5.4 Services
	// ************************
	/**
	 * Access default UnitFormats in FormatServices.
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A05")
	public void testFormatServiceUnitFormatsDefault() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			FormatService service = provider.getFormatService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": FormatService is null", service);
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Default UnitFormat is null", service.getUnitFormat());
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Available UnitFormat names are null",
					service.getAvailableFormatNames(UNIT_FORMAT));
			assertFalse(SECTION_PREFIX + SECTION_NUM + " No available UnitFormat names found",
					service.getAvailableFormatNames(UNIT_FORMAT).isEmpty());
		}
	}

	// ************************ 5.4 Services
	// ************************
	/**
	 * Access available SystemOfUnitsServices.
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A06")
	public void testSystemOfUnitsService() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			SystemOfUnitsService service = provider.getSystemOfUnitsService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": SystemOfUnitsService is null", service);
		}
	}

	// ************************ 5.4 Services
	// ************************
	/**
	 * Access default SystemOfUnits in SystemOfUnitsService.
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A07")
	public void testSystemOfUnitsServiceDefaultSystem() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			SystemOfUnitsService service = provider.getSystemOfUnitsService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": SystemOfUnitsService is null", service);
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Default SystemOfUnits is null", service.getSystemOfUnits());
		}
	}

	// ************************ 5.4 Services
	// ************************
	/**
	 * Access available Systems OfUnits in SystemOfUnitsService.
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A08")
	public void testSystemOfUnitsServiceAvailableSystems() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			SystemOfUnitsService service = provider.getSystemOfUnitsService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": SystemOfUnitsService is null", service);
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Available SystemOfUnits are null",
					service.getAvailableSystemsOfUnits());
			assertFalse(SECTION_PREFIX + SECTION_NUM + " No available SystemOfUnits found",
					service.getAvailableSystemsOfUnits().isEmpty());
		}
	}

	/**
	 * Access Binary Prefixes in SystemOfUnitsService.
	 * @since 2.0
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A09")
	public void testSystemOfUnitsServicePrefixBinary() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			final SystemOfUnitsService service = provider.getSystemOfUnitsService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": SystemOfUnitsService is null", service);
			Set<BinaryPrefix> prefixes = service.getPrefixes(BinaryPrefix.class);
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Binary Prefixes are null", prefixes);
			assertFalse(SECTION_PREFIX + SECTION_NUM + " No Binary Prefixes found", prefixes.isEmpty());
			assertEquals(8, prefixes.size(), SECTION_PREFIX + SECTION_NUM + " Wrong Number of Binary Prefixes");
		}
	}
	
	/**
	 * Access Metric Prefixes in SystemOfUnitsService.
	 * @since 2.0
	 */
	@Test(groups = { SPI }, description = DESCRIPTION)
	@SpecAssertion(section = SECTION_NUM, id = "54-A10")
	public void testSystemOfUnitsServicePrefixMetric() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": ServiceProvider is null", provider);
			final SystemOfUnitsService service = provider.getSystemOfUnitsService();
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": SystemOfUnitsService is null", service);
			Set<MetricPrefix> prefixes = service.getPrefixes(MetricPrefix.class);
			assertNotNull(SECTION_PREFIX + SECTION_NUM + ": Metric Prefixes are null", prefixes);
			assertFalse(SECTION_PREFIX + SECTION_NUM + " No Metric Prefixes found", prefixes.isEmpty());
			assertEquals(20, prefixes.size(), SECTION_PREFIX + SECTION_NUM + " Wrong Number of Metric Prefixes");
		}
	}
}
