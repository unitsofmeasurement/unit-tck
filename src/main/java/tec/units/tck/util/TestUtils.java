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
package tec.units.tck.util;

import org.mutabilitydetector.unittesting.AllowedReason;
import org.mutabilitydetector.unittesting.MutabilityAssert;
import org.mutabilitydetector.unittesting.MutabilityMatchers;
import org.testng.Assert;

import tec.units.tck.TCKValidationException;

import javax.measure.*;
import javax.measure.spi.*;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;

/**
 * Test utilities used in the JSR 363 TCK.
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 */
public class TestUtils {

	/**
	 * Name of the system property to pass the desired profile
	 */
	public static final String SYS_PROPERTY_PROFILE = "tec.units.tck.profile";

	/**
	 * Name of the system property to override the default output directory
	 */
	public static final String SYS_PROPERTY_OUTPUT_DIR = "tec.units.tck.outputDir";

	/**
	 * Name of the system property to override the default report file
	 */
	public static final String SYS_PROPERTY_REPORT_FILE = "tec.units.tck.reportFile";

	/**
	 * Name of the system property to set the <code>verbose</code> flag
	 */
	public static final String SYS_PROPERTY_VERBOSE = "tec.units.tck.verbose";

	private static final StringBuilder warnings = new StringBuilder();

	private TestUtils() {
	}

	public static Number createNumberWithPrecision(QuantityFactory f,
			int precision) {
		if (precision == 0) {
			precision = new Random().nextInt(100);
		}
		StringBuilder b = new StringBuilder(precision + 1);
		for (int i = 0; i < precision; i++) {
			b.append(String.valueOf(i % 10));
		}
		return new Double(b.toString());
	}

	public static Number createNumberWithScale(QuantityFactory f, int scale) {
		StringBuilder b = new StringBuilder(scale + 2);
		b.append("9.");
		for (int i = 0; i < scale; i++) {
			b.append(String.valueOf(i % 10));
		}
		return new Double(b.toString());
	}

	public static void testSerializable(String section, Class c) {
		if (!Serializable.class.isAssignableFrom(c)) {
			throw new TCKValidationException(section
					+ ": Class must be serializable: " + c.getName());
		}
	}

	public static void testImmutable(String section, Class c) {
		try {
			MutabilityAssert
					.assertInstancesOf(
							c,
							MutabilityMatchers.areImmutable(),
							AllowedReason.provided(Dimension.class,
									Quantity.class, Unit.class,
									UnitConverter.class).areAlsoImmutable(),
							AllowedReason.allowingForSubclassing(),
							AllowedReason.allowingNonFinalFields());
		} catch (Exception e) {
			throw new TCKValidationException(section
					+ ": Class is not immutable: " + c.getName(), e);
		}
	}

	public static void testSerializable(String section, Object o) {
		if (!(o instanceof Serializable)) {
			throw new TCKValidationException(section
					+ ": Class must be serializable: " + o.getClass().getName());
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new ByteArrayOutputStream())) {
			oos.writeObject(o);
		} catch (Exception e) {
			throw new TCKValidationException(
					"Class must be serializable, but serialization failed: "
							+ o.getClass().getName(), e);
		}
	}

	public static void testImplementsInterface(String section, Class type,
			Class iface) {
		for (Class ifa : type.getInterfaces()) {
			if (ifa.equals(iface)) {
				return;
			}
		}
		Assert.fail(section + ": Class must implement " + iface.getName()
				+ ", but does not: " + type.getName());
	}

	public static void testComparable(String section, Class type) {
		testImplementsInterface(section, type, Comparable.class);
	}

	public static void testHasPublicMethod(String section, Class type,
			Class returnType, String name, Class... paramTypes) {
		Class current = type;
		while (current != null) {
			for (Method m : current.getDeclaredMethods()) {
				if (returnType.equals(returnType) && m.getName().equals(name)
						&& ((m.getModifiers() & Modifier.PUBLIC) != 0)
						&& Arrays.equals(m.getParameterTypes(), paramTypes)) {
					return;
				}
			}
			current = current.getSuperclass();
		}
		throw new TCKValidationException(section
				+ ": Class must implement method " + name + '('
				+ Arrays.toString(paramTypes) + "): " + returnType.getName()
				+ ", but does not: " + type.getName());
	}

	public static void testHasPublicMethod(String section, boolean superclassFirst, Class type,
			Class returnType, String name, Class... paramTypes) {
		if (superclassFirst) {
			testHasPublicMethod(section, type.getSuperclass(), returnType, name, paramTypes);
		} else {
			testHasPublicMethod(section, type, returnType, name, paramTypes);
		}
	}

	public static void testHasPublicStaticMethod(String section, Class type,
			Class returnType, String name, Class... paramTypes) {
		Class current = type;
		while (current != null) {
			for (Method m : current.getDeclaredMethods()) {
				if (returnType.equals(returnType) && m.getName().equals(name)
						&& ((m.getModifiers() & Modifier.PUBLIC) != 0)
						&& ((m.getModifiers() & Modifier.STATIC) != 0)
						&& Arrays.equals(m.getParameterTypes(), paramTypes)) {
					return;
				}
			}
			current = current.getSuperclass();
		}
		throw new TCKValidationException(section
				+ ": Class must implement method " + name + '('
				+ Arrays.toString(paramTypes) + "): " + returnType.getName()
				+ ", but does not: " + type.getName());
	}

	public static void testHasNotPublicMethod(String section, Class type,
			Class returnType, String name, Class... paramTypes) {
		Class current = type;
		while (current != null) {
			for (Method m : current.getDeclaredMethods()) {
				if (returnType.equals(returnType) && m.getName().equals(name)
						&& Arrays.equals(m.getParameterTypes(), paramTypes)) {
					throw new TCKValidationException(section
							+ ": Class must NOT implement method " + name + '('
							+ Arrays.toString(paramTypes) + "): "
							+ returnType.getName() + ", but does: "
							+ type.getName());
				}
			}
			current = current.getSuperclass();
		}
	}

	public static void assertValue(String section, Object value,
			String methodName, Object instance) throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method m = instance.getClass().getDeclaredMethod(methodName);
		Assert.assertEquals(value, m.invoke(instance),
				section + ": " + m.getName() + '(' + instance
						+ ") returned invalid value:");
	}

	public static boolean testHasPublicStaticMethodOpt(String section,
			Class type, Class returnType, String methodName,
			Class... paramTypes) {
		try {
			testHasPublicStaticMethod(section, type, returnType, methodName,
					paramTypes);
			return true;
		} catch (Exception e) {
			warnings.append(section)
					.append(": Recommendation failed: Missing method [public static ")
					.append(methodName).append('(')
					.append(Arrays.toString(paramTypes)).append("):")
					.append(returnType.getName()).append("] on: ")
					.append(type.getName()).append("\n");
			return false;
		}
	}

	public static boolean testImmutableOpt(String section, Class type) {
		try {
			testImmutable(section, type);
			return true;
		} catch (Exception e) {
			warnings.append(section)
					.append(": Recommendation failed: Class should be immutable: ")
					.append(type.getName()).append(", details: ")
					.append(e.getMessage()).append("\n");
			return false;
		}
	}

	public static boolean testSerializableOpt(String section, Class type) {
		try {
			testSerializable(section, type);
			return true;
		} catch (Exception e) {
			warnings.append(section)
					.append(": Recommendation failed: Class should be serializable: ")
					.append(type.getName()).append(", details: ")
					.append(e.getMessage()).append("\n");
			return false;
		}
	}

	public static boolean testSerializableOpt(String section, Object instance) {
		try {
			testSerializable(section, instance);
			return true;
		} catch (Exception e) {
			warnings.append(section)
					.append(": Recommendation failed: Class is serializable, but serialization failed: ")
					.append(instance.getClass().getName()).append("\n");
			return false;
		}
	}

	public static void resetWarnings() {
		warnings.setLength(0);
	}

	public static String getWarnings() {
		return warnings.toString();
	}
}
