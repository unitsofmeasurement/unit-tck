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
package tech.units.tck;

import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceLoader;

import jakarta.inject.Singleton;
import tech.units.tck.util.ServiceConfiguration;


/**
 * Test setup used by the JSR 385 TCK.
 *
 * @author <a href="mailto:werner@units.tech">Werner Keil</a>
 * @version 2.1, July 7, 2019
 */
@Singleton
public final class TCKSetup {
    /**
     * Configuration provided by the library to test. This is initially null and initialized when first needed,
     * either by explicit initialization by the implementer or by discovery using service loader.
     */
    private static ServiceConfiguration testConfig;

    /**
     * Whether {@link #testConfig} has been initialized. We use a flag instead of testing whether {@link #testConfig}
     * is non-null because we want to detect if {@link #getConfiguration()} has been invoked before initialization,
     * even if no configuration was found. The intent is to detect the cases where the initialization would be done
     * too late, after the tests already started.
     */
    private static boolean initialized;

    /**
     * Do not allow instantiation of this class.
     */
    private TCKSetup() {
    }

    /**
     * Initializes the TCK for testing a library described by the given configuration.
     * This method can be invoked at most once. If the TCK is already initialized, either by previous invocation
     * of this method or by a call to {@link #getConfiguration()}, then {@link IllegalStateException} is thrown.
     * The reason for that is because the TCK tests may have already started, and we do not want to change the
     * library in the middle of those tests.
     *
     * <p>Invoking this method is optional. If this method is not invoked, then an attempt to discover
     * the configuration will be done using {@link ServiceLoader}. This method is useful when the TCK
     * are integrated in a project as a JUnit or TestNG test case.</p>
     *
     * <p>Invoking this method many times with the same {@code ServiceConfiguration} instance has no effect.</p>
     *
     * @param  config  information about the unit library to test.
     * @throws IllegalStateException if the TCK has already been initialized.
     */
    public static synchronized void initialize(final ServiceConfiguration config) throws IllegalStateException {
        if (testConfig != Objects.requireNonNull(config)) {
            if (initialized) {
                throw new IllegalStateException("TCKSetup is already initialized.");
            }
            testConfig = config;
            initialized = true;
        }
    }

    /**
     * Returns information about the unit library to test. If {@link #initialize(ServiceConfiguration)} has been
     * successfully invoked before this method, then {@code getConfiguration()} returns the value that was given
     * to {@code initialize(…)}. Otherwise this method uses {@link ServiceLoader} for searching the first configuration
     * found on the classpath. Note that if there is more than one configuration on the classpath, which one is first
     * may not be well determined.
     *
     * @return information about the unit library to test.
     * @throws IllegalStateException if the TCK has not been {@linkplain #initialize(ServiceConfiguration) initialized}
     *         and no {@link ServiceConfiguration} is found by {@link ServiceLoader}.
     */
    public static synchronized ServiceConfiguration getConfiguration() throws IllegalStateException {
        if (testConfig == null) {
            Iterator<ServiceConfiguration> it = ServiceLoader.load(ServiceConfiguration.class).iterator();
            if (!it.hasNext()) {
                throw new IllegalStateException("No implementation of "
                                        + ServiceConfiguration.class.getName()
                                        + " is registered with the ServiceLoader.");
            }
            testConfig = it.next();
            initialized = true;
        }
        return testConfig;
    }
}
