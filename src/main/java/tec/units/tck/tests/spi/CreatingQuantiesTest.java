/*
 * Unit-API - Units of Measurement API for Java Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner
 * Keil, V2COM.
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
package tec.units.tck.tests.spi;

import static org.testng.AssertJUnit.assertNotNull;
import static tec.units.tck.TCKRunner.SPEC_ID;
import static tec.units.tck.TCKRunner.SPEC_VERSION;

import java.util.Set;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.spi.QuantityFactory;
import javax.measure.spi.QuantityFactoryService;
import javax.measure.spi.ServiceProvider;

import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.reflections.Reflections;
import org.testng.annotations.Test;

import tec.units.tck.util.TestUtils;

/**
 * Test class for creating new quantities.
 */
@SpecVersion(spec = SPEC_ID, version = SPEC_VERSION)
public class CreatingQuantiesTest {

    private static final String MEASURE_PACKAGE = "javax.measure";

    // ************************ 5.5 Obtaining Quantity Instances
    // ************************
    /**
     * Access a QuantityFactory for each registered type.
     */
    @Test(groups = {"spi"}, description = "5.5.1 Quantities Obtained from a factory")
    @SpecAssertion(section = "5.5.1", id = "551-A1")
    public void testAccessToQuantityFactory() {
        QuantityFactoryService service = ServiceProvider.getDefault().getQuantityFactoryService();
        Reflections reflections = new Reflections(MEASURE_PACKAGE);
        Set<Class<? extends Quantity>> subTypes = reflections.getSubTypesOf(Quantity.class);
        for (Class clazz : subTypes) {
            QuantityFactory<?> factory = service.getQuantityFactory(clazz);
            assertNotNull("Section 5.5.1: No QuantityFactory available for " + clazz.getSimpleName(), factory);
        }
    }

    /**
     * Check a QuantityFactory for each registered type has create method.
     */
    @Test(groups = {"spi"}, description = "5.5.1 Quantities Obtained from a factory has create method")
    @SpecAssertion(section = "5.5.1", id = "551-A2")
    public void testAccessToQuantityFactoryCreate() {
        QuantityFactoryService service = ServiceProvider.getDefault().getQuantityFactoryService();
        Reflections reflections = new Reflections(MEASURE_PACKAGE);
        Set<Class<? extends Quantity>> subTypes = reflections.getSubTypesOf(Quantity.class);
        for (Class clazz : subTypes) {
            QuantityFactory<?> factory = service.getQuantityFactory(clazz);
            TestUtils.testHasPublicMethod("Section 5.5.1", factory.getClass(), Quantity.class, "create", Number.class, Unit.class);
        }
    }

    /**
     * Check a QuantityFactory for each registered type has getSystemUnit method.
     */
    @Test(groups = {"spi"}, description = "5.5.1 Quantities Obtained from a factory has getSystemUnit method")
    @SpecAssertion(section = "5.5.1", id = "551-A3")
    public void testAccessToQuantityFactoryGetSystemUnit() {
        QuantityFactoryService service = ServiceProvider.getDefault().getQuantityFactoryService();
        Reflections reflections = new Reflections(MEASURE_PACKAGE);
        Set<Class<? extends Quantity>> subTypes = reflections.getSubTypesOf(Quantity.class);
        for (Class clazz : subTypes) {
            QuantityFactory<?> factory = service.getQuantityFactory(clazz);
            TestUtils.testHasPublicMethod("Section 5.5.1", factory.getClass(), Unit.class, "getSystemUnit");
        }
    }
}
