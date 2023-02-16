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
package tech.units.tck.util;

import static tech.units.indriya.unit.UnitDimension.*;

import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.NumberDelimiterQuantityFormat;
import tech.units.indriya.format.SimpleQuantityFormat;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.function.AddConverter;
import tech.units.indriya.function.ExpConverter;
import tech.units.indriya.function.LogConverter;
import tech.units.indriya.function.MultiplyConverter;
import tech.units.indriya.quantity.NumberQuantity;
import tech.units.indriya.unit.UnitDimension;
import tech.units.indriya.unit.Units;
import javax.measure.*;
import javax.measure.format.QuantityFormat;
import javax.measure.format.UnitFormat;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnits;
import javax.measure.spi.SystemOfUnitsService;

import org.reflections.Reflections;

import java.util.*;

/**
 * Created by Werner Keil on 21.12.2014.
 * 
 * @author Werner Keil
 * @author Muhammed Almas
 * @version 2.0, September 28, 2020
 * @since 1.0
 */
public final class TCKTestConfiguration implements ServiceConfiguration {

	@SuppressWarnings("rawtypes")
	public Collection<Class> getQuantityClasses() {
		return Arrays.asList(new Class[] { NumberQuantity.class });
	}

	@SuppressWarnings("rawtypes")
	public Collection<Class> getUnitClasses() {
		try {
			return Arrays.asList(new Class[] { Class
					.forName("tech.units.indriya.unit.BaseUnit") });
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Unit class not loadable");
		}
	}

	public Collection<? extends Unit<?>> getUnits4Test() {
		SystemOfUnitsService service = ServiceProvider.current().getSystemOfUnitsService();
		SystemOfUnits sou = service.getSystemOfUnits();
		return sou.getUnits();
	}

	public Collection<UnitConverter> getUnitConverters4Test() {
		return Arrays.asList(new UnitConverter[] { new AddConverter(1),
				new ExpConverter(1), new LogConverter(1), MultiplyConverter.of(0d), 
				MultiplyConverter.ofRational(2, 1), MultiplyConverter.ofPiExponent(10),
				MultiplyConverter.ofTenExponent(2) });
	}

	public Collection<UnitFormat> getUnitFormats4Test() {
		return Arrays
				.asList(new UnitFormat[] { SimpleUnitFormat.getInstance(), EBNFUnitFormat.getInstance() });
	}

	@SuppressWarnings("rawtypes")
	public Collection<Class> getDimensionClasses() {
		return Arrays.asList(new Class[] { UnitDimension.class });
	}
	
	@SuppressWarnings("rawtypes")
	public Collection<Class> getPrefixClasses() {
		return Arrays.asList(new Class[] { MetricPrefix.class, BinaryPrefix.class });
	}

	public Collection<Dimension> getBaseDimensions() {
		return Arrays.asList(new Dimension[] { AMOUNT_OF_SUBSTANCE,
				ELECTRIC_CURRENT, LENGTH, LUMINOUS_INTENSITY, MASS,
				TEMPERATURE, TIME });
	}

	@SuppressWarnings("rawtypes")
	public Collection<Class<? extends Quantity>> getSupportedQuantityTypes() {
		Reflections reflections = new Reflections("javax.measure");
		Set<Class<? extends Quantity>> subTypes = reflections
				.getSubTypesOf(Quantity.class);
		return subTypes;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Unit getUnit4Type(Class quantityType) {
		return Units.getInstance().getUnit(quantityType);
	}

    @Override
    public Collection<QuantityFormat> getQuantityFormats4Test() {
        return Arrays
                .asList(new QuantityFormat[] { SimpleQuantityFormat.getInstance(), NumberDelimiterQuantityFormat.getInstance() });

    }
}