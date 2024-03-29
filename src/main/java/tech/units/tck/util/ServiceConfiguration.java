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

import javax.measure.*;
import javax.measure.format.QuantityFormat;
import javax.measure.format.UnitFormat;

import java.util.Arrays;
import java.util.Collection;
import java.util.ServiceLoader;

/**
 * Libraries that implement this JSR and want to be tested with this TCK must implement this
 * interface and register it using the {@link ServiceLoader}.
 *
 * @author Werner Keil
 * @version 2.1, December 5, 2022
 * @since 1.0
 */
public interface ServiceConfiguration{

    /**
     * Return a collection with all {@link Quantity} classes that are implemented. The list
     * must not be empty and should contain <b>every</b> quantity class implemented.<p>
     * This enables the TCK to check in addition to the basic implementation compliance, if
     * according {@code ServiceProvider} is registered/available.
     *
     * @return a collection with all implemented amount classes, not null.
     */
    @SuppressWarnings("rawtypes")
    Collection<Class> getQuantityClasses();

    /**
     * List a collection of {@link Unit} implementations.<p>
     * This enables the TCK to check the basic implementation compliance.
     *
     * @return a collection with Unit implementations to be tested.
     */
    @SuppressWarnings("rawtypes")
    Collection<Class> getUnitClasses();

    /**
     * List a collection of {@link Dimension} implementations.<p>
     * This enables the TCK to check the basic implementation compliance.
     *
     * @return a collection with {@link Dimension} implementations to be tested.
     */
    @SuppressWarnings("rawtypes")
    Collection<Class> getDimensionClasses();

    /**
     * List a collection of {@link Prefix} implementations.<p>
     * This enables the TCK to check the basic implementation compliance.
     *
     * @return a collection with {@link Prefix} implementations to be tested.
     * @since 2.0
     */
    @SuppressWarnings("rawtypes")
    default Collection<Class> getPrefixClasses() {
		return Arrays.asList(new Class[] { BinaryPrefix.class, MetricPrefix.class });
	}

    /**
     * Return a collection with all supported {@link Quantity} types. The list
     * must not return <code>null</code>, but could be empty in certain profiles.
     *
     * @return the list of quantity types to be checked, not <code>null</code>.
     * It is allowed to return an empty list here, which will return a collection with all implemented quantity classes, not null.
     */
    @SuppressWarnings("rawtypes")
    Collection<Class<? extends Quantity>> getSupportedQuantityTypes();

    /**
     * Returns a matching unit for the specified quantity type.
     * This is a "helper method" to avoid direct references to {@code SystemOfUnits} or implementations in profiles without SPI.
     *
     * @param <Q>
     *            the compile-time quantity type.
     * @param quantityType
     *            the quantity type.
     * @return the unit for the specified quantity.
     */
    public <Q extends Quantity<Q>> Unit<Q> getUnit4Type(Class<Q> quantityType);

    /**
     * This method allows instances of Unit to be tested for requirements and recommendations.
     *
     * @return the list of units to be checked, not null. It is allowed to return an empty list here, which will
     * disable certain TCK tests, e.g. if the result isn't needed by a particular profile.
     */
    Collection<? extends Unit<?>> getUnits4Test();

    /**
     * This method returns the base dimensions to be tested for requirements and recommendations.
     *
     * @return the list of base dimensions to be checked, not null. It is allowed to return an empty list here, which will
     * disable certain TCK tests, e.g. if the result isn't needed by a particular profile.
     */
    Collection<Dimension> getBaseDimensions();

    /**
     * This method allows instances of UnitConverter to be tested for requirements and recommendations.
     *
     * @return the list of unit converters to be checked, not null. It is allowed to return an empty list here, which will
     * disable TCK tests for UnitConverter instances.
     */
    Collection<UnitConverter> getUnitConverters4Test();

    /**
     * This method allows instances of UnitFormat to be tested for requirements and recommendations.
     *
     * @return the list of unit converters to be checked, not null. It is allowed to return an empty list here, which will
     * disable certain TCK tests, e.g. if the result isn't needed by a particular profile.
     */
    Collection<UnitFormat> getUnitFormats4Test();

    /**
     * This method allows instances of QuantityFormat to be tested for requirements and recommendations.
     *
     * @return the list of unit converters to be checked, not null. It is allowed to return an empty list here, which will
     * disable certain TCK tests, e.g. if the result isn't needed by a particular profile.
     * @since 2.0
     */
    Collection<QuantityFormat> getQuantityFormats4Test();
}
