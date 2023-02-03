unit-tck
========
JSR 385 Technology Compatibility Kit (TCK) 

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/tech.units/unit-tck/badge.svg)](https://maven-badges.herokuapp.com/maven-central/tech.units/unit-tck)
[![javadoc](https://javadoc.io/badge2/tech.units/unit-tck/2.1.1/javadoc.svg)](https://javadoc.io/doc/tech.units/unit-tck/2.1.1)
[![Circle CI](https://circleci.com/gh/unitsofmeasurement/unit-tck.svg?style=svg)](https://circleci.com/gh/unitsofmeasurement/unit-tck)
[![Stability: Active](https://masterminds.github.io/stability/active.svg)](https://masterminds.github.io/stability/active.html)
[![License](http://img.shields.io/badge/license-BSD3-blue.svg?style=flat-square)](http://opensource.org/licenses/BSD-3-Clause)

The current module contains the technology compatibility kit of JSR 385.
The tests can be executed either as a separated project,
or integrated with the test suite of the implementation.


# Test in a separated Maven project

To setup the TCK with your implementation you must follow the following steps:

 1. Create a new Maven project. You could also use compatible alternatives like Gradle.
 2. Add this TCK and your implementation as dependency.
 3. Implement a class of type `tech.units.tck.util.ServiceConfiguration`, read the Javadoc, what 
  you must provide with this class.
  
## Running
To run the TCK, simply execute
```
mvn clean test
```       
 1. Go to target - where you can find your TCK test results.
   
For help on using the TCK you may execute
```
mvn exec:java
```
This will only print instructions, to run the TCK you need to execute it through TestNG.

To get version information you may execute
```
mvn exec:java -Pversion
```

### Profiles
When running the TCK (`mvn test`) by calling the system property
```
-Dtech.units.tck.profile=<profile>
```
you may select one of the following **profiles**: 
- MINIMAL
- FORMAT
- BASE_QUANTITY
- QUANTITY
- QUANTITY_FORMAT
- SPI
- FULL

The `Full` profile is default whenever you don't explicitly pass a profile.
You may pass the profile name in either case, `TCKRunner` will automatically convert them to UPPERCASE before parsing the name of the profile.

### Other System Properties
In addition to profiles, the following system properties allow you to override default behavior and storage locations of the TCK:
```
-Dtech.units.tck.outputDir=<output directory>
```
To override the default output directory
```
-Dtech.units.tck.reportFile=<file name>
```
To override the default TCK report file
```
-Dtech.units.tck.verbose=true/false
```
To toggle the `verbose` option of the TCK for extended test output. The default is `false`. And you normally won't need to set this unless you require detailed analysis or issue resolution.


# Integrate with implementation tests

For running the TCK as part of an implementation build process,
it may not be convenient to use the `ServiceLoader` mechanism.
For example it is not always easy to amend the project `module-info`
with a `provides tech.units.tck.…` clause only during the tests.
Instead, the class implementing the `tech.units.tck.util.ServiceConfiguration` interface
can be declared by a call to `TCKSetup.initialize(ServiceConfiguration)`.
Steps are:

1. Add this TCK as a project dependency with `<scope>test</scope>`.
2. Add a test class implementing `tech.units.tck.util.ServiceConfiguration`.
3. Add a test method like below:

```java
import tech.units.tck.TCKSetup;
import tech.units.tck.TCKRunner;

public class MyTest implements ServiceConfiguration {
    @Test
    public void runTCK() {
        TCKSetup.initialize(this);
        final TCKRunner runner = new TCKRunner();
        int result = runner.run(System.in, System.out, System.err);
        assertEquals("Some TCK tests failed.", 0, result);
    }
}
```

After above steps, the TCK become part of the project test suite
and is run every time that the project is built.
