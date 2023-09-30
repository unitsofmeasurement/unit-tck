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

import static java.lang.reflect.Modifier.PUBLIC;
import static org.reflections.ReflectionUtils.getAllMethods;
import static org.reflections.ReflectionUtils.withModifier;
import static org.reflections.ReflectionUtils.withName;
import static org.reflections.ReflectionUtils.withParametersCount;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import jakarta.inject.Singleton;
import tech.units.tck.TCKValidationException;

import javax.measure.spi.*;

/**
 * Test utilities used in the JSR 385 TCK.
 *
 * @author <a href="mailto:werner@units.tech">Werner Keil</a>
 * @version 2.6, September 30, 2023
 * @since 1.0
 */
@Singleton
public class TestUtils {

    /**
     * Name of the system property to pass the desired profile
     */
    public static final String SYS_PROPERTY_PROFILE = "tech.units.tck.profile";

    /**
     * Name of the system property to override the default output directory
     */
    public static final String SYS_PROPERTY_OUTPUT_DIR = "tech.units.tck.outputDir";

    /**
     * Name of the system property to override the default report file
     */
    public static final String SYS_PROPERTY_REPORT_FILE = "tech.units.tck.reportFile";

    /**
     * Name of the system property to set the <code>verbose</code> flag
     */
    public static final String SYS_PROPERTY_VERBOSE = "tech.units.tck.verbose";

    /**
     * Number of binary prefixes
     */
    public static final int NUM_OF_BINARY_PREFIXES = 8;
    
    /**
     * Number of metric (SI) prefixes
     */
    public static final int NUM_OF_METRIC_PREFIXES = 24;
    
    private static final StringBuilder warnings = new StringBuilder();

    /**
     * This class should not be instantiated
     */
    private TestUtils() {
    }

    static Number createNumberWithPrecision(QuantityFactory<?> f, int precision) {
        if (precision == 0) {
            precision = new Random().nextInt(100);
        }
        StringBuilder b = new StringBuilder(precision + 1);
        for (int i = 0; i < precision; i++) {
            b.append(String.valueOf(i % 10));
        }
        return Double.valueOf(b.toString());
    }

    static Number createNumberWithScale(QuantityFactory<?> f, int scale) {
        StringBuilder b = new StringBuilder(scale + 2);
        b.append("9.");
        for (int i = 0; i < scale; i++) {
            b.append(String.valueOf(i % 10));
        }
        return Double.valueOf(b.toString());
    }

    /**
     * Tests the given object being serializable.
     *
     * @param section
     *            the section of the spec under test
     * @param type
     *            the type to be checked.
     * @throws TCKValidationException
     *             if the test fails.
     */
    public static void testSerializable(String section, Class<?> type) {
        if (!Serializable.class.isAssignableFrom(type)) {
            throw new TCKValidationException(section + ": Class must be serializable: " + type.getName());
        }
    }

    /**
     * Tests the given class being serializable.
     *
     * @param section
     *            the section of the spec under test
     * @param type
     *            the type to be checked.
     * @throws TCKValidationException
     *             if test fails.
     */
    public static void testImmutable(String section, Class<?> type) {
    	System.out.println("Testing Immutability...");
//        try {
//            MutabilityAssert.assertInstancesOf(type, MutabilityMatchers.areImmutable(),
//                    AllowedReason.provided(Dimension.class, Quantity.class, Unit.class, UnitConverter.class).areAlsoImmutable(),
//                    AllowedReason.allowingForSubclassing(), AllowedReason.allowingNonFinalFields());
//        } catch (Exception e) {
//            throw new TCKValidationException(section + ": Class is not immutable: " + type.getName(), e);
//        }
    }

    /**
     * Tests the given object being (effectively) serializable by serializing it.
     *
     * @param section
     *            the section of the spec under test
     * @param o
     *            the object to be checked.
     * @throws TCKValidationException
     *             if test fails.
     */
    public static void testSerializable(String section, Object o) {
        if (!(o instanceof Serializable)) {
            throw new TCKValidationException(section + ": Class must be serializable: " + o.getClass().getName());
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new ByteArrayOutputStream())) {
            oos.writeObject(o);
        } catch (Exception e) {
            throw new TCKValidationException("Class should be serializable, but serialization failed: " + o.getClass().getName(), e);
        }
    }

    /**
     * Tests the given class implements a given interface.
     *
     * @param section
     *            the section of the spec under test
     * @param type
     *            the type to be checked.
     * @param iface
     *            the interface to be checked for.
     * Triggers Assert#fail
     *             if test fails.
     */
    public static void testImplementsInterface(String section, Class<?> type, Class<?> iface) {
        for (Class<?> ifa : type.getInterfaces()) {
            if (ifa.equals(iface)) {
                return;
            }
        }
        fail(section + ": Class must implement " + iface.getName() + ", but does not: " + type.getName());
    }

    /**
     * Tests if the given type is comparable.
     *
     * @param section
     *            the section of the spec under test
     * @param type
     *            the type to be checked.
     */
    public static void testComparable(String section, Class<?> type) {
        testImplementsInterface(section, type, Comparable.class);
    }

    /**
     *
     * @param section the section of the specification
     * @param type the type to be checked.
     * @param returnType the expected return type
     * @param name the name of the method
     * @param paramTypes the types of parameters if available
     */
    public static void testHasPublicMethod(String section, Class<?> type, Class<?> returnType, String name, Class<?>... paramTypes) {
        Class<?> current = type;
        while (current != null) {
            for (Method m : current.getDeclaredMethods()) {
                if (returnType.equals(m.getReturnType()) && m.getName().equals(name) && ((m.getModifiers() & PUBLIC) != 0)
                        && Arrays.equals(m.getParameterTypes(), paramTypes)) {
                    return;
                }
            }
            current = current.getSuperclass();
        }
        throw new TCKValidationException(section + ": Class must implement method " + name + '(' + Arrays.toString(paramTypes) + "): "
                + returnType.getName() + ", but does not: " + type.getName());
    }

    @SuppressWarnings("rawtypes")
	private static final List<Class> PRIMITIVE_CLASSES = Collections
            .unmodifiableList(Arrays.asList(new Class[] { Object.class, Number.class, Enum.class }));

    /**
     *
     * @param section the section of the specification
     * @param type the data type
     * @param trySuperclassFirst if tht super class if available should be tested first
     * @param returnType the expected return type
     * @param name the name of the method
     * @param paramTypes types of parameters
     */
    public static void testHasPublicMethod(String section, Class<?> type, boolean trySuperclassFirst, Class<?> returnType, String name,
            Class<?>... paramTypes) {
        if (trySuperclassFirst && type.getSuperclass() != null) {
            if (PRIMITIVE_CLASSES.contains(type.getSuperclass())) {
                testHasPublicMethod(section, type, returnType, name, paramTypes);
            } else {
                testHasPublicMethod(section, type.getSuperclass(), returnType, name, paramTypes);
            }
        } else {
            testHasPublicMethod(section, type, returnType, name, paramTypes);
        }
    }

    /**
     * Tests if the given type has a public method with the given signature.
     *
     * @param section
     *            the section of the spec under test
     * @param type
     *            the type to be checked.
     * @param name
     *            the method name
     * @param hasParameters
     *            the method has parameters.
     * @throws TCKValidationException
     *             if test fails.
     */
    @SuppressWarnings({ "unchecked" })
    public static void testHasPublicMethod(String section, Class<?> type, String name, boolean hasParameters) {
        Set<Method> getters;
        if (hasParameters) {
            getters = getAllMethods(type, withModifier(PUBLIC), withName(name));
        } else {
            getters = getAllMethods(type, withModifier(PUBLIC), withName(name), withParametersCount(0));
        }
        assertNotNull(getters);
        assertTrue(getters.size() >= 1); // interface plus at least one implementation
    }

    /**
     * @param section the section of the specification
     * @param type the data type
     * @param name the name of the method
     */
    public static void testHasPublicMethod(String section, Class<?> type, String name) {
        testHasPublicMethod(section, type, name, false);
    }

    /**
     * Tests if the given type has a public static method with the given signature.
     *
     * @param section
     *            the section of the spec under test
     * @param type
     *            the type to be checked.
     * @param returnType
     *            the method return type.
     * @param name
     *            the method name
     * @param paramTypes
     *            the parameter types.
     * @throws TCKValidationException
     *             if test fails.
     */
    @SuppressWarnings("rawtypes")
    static void testHasPublicStaticMethod(String section, Class type, Class returnType, String name, Class... paramTypes) {
        Class current = type;
        while (current != null) {
            for (Method m : current.getDeclaredMethods()) {
                if (returnType.equals(returnType) && m.getName().equals(name) && ((m.getModifiers() & PUBLIC) != 0)
                        && ((m.getModifiers() & Modifier.STATIC) != 0) && Arrays.equals(m.getParameterTypes(), paramTypes)) {
                    return;
                }
            }
            current = current.getSuperclass();
        }
        throw new TCKValidationException(section + ": Class must implement method " + name + '(' + Arrays.toString(paramTypes) + "): "
                + returnType.getName() + ", but does not: " + type.getName());
    }

    /**
     * Tests if the given type has not a public method with the given signature.
     *
     * @param section
     *            the section of the spec under test
     * @param type
     *            the type to be checked.
     * @param returnType
     *            the method return type.
     * @param name
     *            the method name
     * @param paramTypes
     *            the parameter types.
     * @throws TCKValidationException
     *             if test fails.
     */
    @SuppressWarnings("rawtypes")
	public static void testHasNotPublicMethod(String section, Class<?> type, Class<?> returnType, String name, Class<?>... paramTypes) {
        Class current = type;
        while (current != null) {
            for (Method m : current.getDeclaredMethods()) {
                if (returnType.equals(returnType) && m.getName().equals(name) && Arrays.equals(m.getParameterTypes(), paramTypes)) {
                    throw new TCKValidationException(section + ": Class must NOT implement method " + name + '(' + Arrays.toString(paramTypes) + "): "
                            + returnType.getName() + ", but does: " + type.getName());
                }
            }
            current = current.getSuperclass();
        }
    }

    /**
     * Checks the returned value, when calling a given method.
     *
     * @param section
     *            the section of the spec under test
     * @param value
     *            the expected value
     * @param methodName
     *            the target method name
     * @param instance
     *            the instance to call
     * @throws NoSuchMethodException if no method with the given name exists.
     * @throws SecurityException if a security problem occurs.
     * @throws IllegalAccessException if the method may not be called, e.g. due to security constraints.
     * @throws IllegalArgumentException if a wrong or inappropriate argument was provided.
     * @throws InvocationTargetException if an exception thrown by an invoked method or constructor.
     * @throws TCKValidationException
     *             if test fails.
     */
    public static void assertValue(String section, Object value, String methodName, Object instance)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        final Method m = instance.getClass().getDeclaredMethod(methodName);
        assertEquals(m.invoke(instance), value, section + ": " + m.getName() + '(' + instance + ") returned invalid value:");
    }

    static boolean testHasPublicStaticMethodOpt(String section, @SuppressWarnings("rawtypes") Class type, @SuppressWarnings("rawtypes") Class returnType, String methodName, @SuppressWarnings("rawtypes") Class... paramTypes) {
        try {
            testHasPublicStaticMethod(section, type, returnType, methodName, paramTypes);
            return true;
        } catch (Exception e) {
            warnings.append(section).append(": Recommendation failed: Missing method [public static ").append(methodName).append('(')
                    .append(Arrays.toString(paramTypes)).append("):").append(returnType.getName()).append("] on: ").append(type.getName())
                    .append("\n");
            return false;
        }
    }

    /**
     * Test for immutability (optional recommendation), writes a warning if not given.
     *
     * @param section
     *            the section of the spec under test
     * @param type
     *            the type to be checked.
     * @return true, if the instance is probably immutable.
     */
    public static boolean testImmutableOpt(String section, @SuppressWarnings("rawtypes") Class type) {
        try {
            testImmutable(section, type);
            return true;
        } catch (Exception e) {
            warnings.append(section).append(": Recommendation failed: Class should be immutable: ").append(type.getName()).append(", details: ")
                    .append(e.getMessage()).append("\n");
            return false;
        }
    }

    /**
     * Test for serializable (optional recommendation), writes a warning if not given.
     *
     * @param section
     *            the section of the spec under test
     * @param type
     *            the type to be checked.
     * @return true, if the type is probably serializable.
     */
    public static boolean testSerializableOpt(String section, @SuppressWarnings("rawtypes") Class type) {
        try {
            testSerializable(section, type);
            return true;
        } catch (Exception e) {
            warnings.append(section).append(": Recommendation failed: Class should be serializable: ").append(type.getName()).append(", details: ")
                    .append(e.getMessage()).append("\n");
            return false;
        }
    }

    /**
     * Test for serializable (optional recommendation), writes a warning if not given.
     *
     * @param section
     *            the section of the spec under test
     * @param instance
     *            the object to be checked.
     * @return true, if the instance is probably serializable.
     */
    public static boolean testSerializableOpt(String section, Object instance) {
        try {
            testSerializable(section, instance);
            return true;
        } catch (Exception e) {
            warnings.append(section).append(": Recommendation failed: Class is serializable, but serialization failed: ")
                    .append(instance.getClass().getName()).append("\n");
            return false;
        }
    }

    static void resetWarnings() {
        warnings.setLength(0);
    }

    static String getWarnings() {
        return warnings.toString();
    }
}
