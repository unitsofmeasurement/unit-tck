/*
 * Units of Measurement TCK
 * Copyright © 2005-2017, Jean-Marie Dautelle, Werner Keil, V2COM.
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

import java.util.ServiceLoader;

import javax.inject.Singleton;

import tech.units.tck.util.ServiceConfiguration;

/**
 * Test setup used by the JSR 385 TCK.
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1, July 11, 2018
 */
@Singleton
public final class TCKSetup {

	private static ServiceConfiguration TEST_CONFIG = loadConfiguration();

	private TCKSetup() {
	}

	private static ServiceConfiguration loadConfiguration() {
		try {
			return ServiceLoader.load(ServiceConfiguration.class).iterator()
					.next();
		} catch (Exception e) {
			throw new IllegalStateException("No valid implementation of "
						+ ServiceConfiguration.class.getName()
						+ " is registered with the ServiceLoader.");
		}
	}

	public static final ServiceConfiguration getConfiguration() {
		return TEST_CONFIG;
	}

}
