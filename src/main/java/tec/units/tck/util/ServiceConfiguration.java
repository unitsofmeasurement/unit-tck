/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2014, Jean-Marie Dautelle, Werner Keil, V2COM.
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
package tec.units.tck.util;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import java.util.Collection;
import java.util.ServiceLoader;

/**
 * Libraries that implement this JSR and want to be tested with this TCK must implement this
 * interface and register it using the {@link ServiceLoader}.
 *
 * @author Werner Keil
 */
public interface ServiceConfiguration{

    /**
     * Return a collection with all {@link Quantity} classes that are implemented. The list
     * must not be empty and should contain <b>every</b> amount class implemented.<p>
     * This enables the TCK to check in addition to the basic implementation compliance, if
     * according {@link MonetaryAmountFactoryProviderSpi} are registered/available correctly.
     *
     * @return a collection with all implemented amount classes, not null.
     */
    Collection<Class> getQuantityClasses();

    /**
     * List a collection of {@link Unit} implementation.<p>
     * This enables the TCK to check the basic implementation compliance.
     *
     * @return a collection with Unit implementations to be tested.
     */
    Collection<Class> getUnitClasses();


    /**
     * This method allows to let instances of UnitConverter to be tested for requirements and recommendations.
     *
     * @return the list of operators to be checked, not null. It is allowed to return an empty list here, which will
     * disable TCK tests for UnitConverter instances.
     */
    Collection<UnitConverter> getUnitConverters4Test();

}
