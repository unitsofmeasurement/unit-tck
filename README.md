unit-tck
========
JSR 385 Technology Compatibility Kit (TCK) 

[![Download](https://api.bintray.com/packages/unitsofmeasurement/maven/tech.units%3Aunit-tck/images/download.svg)](https://bintray.com/unitsofmeasurement/maven/tech.units%3Aunit-tck/_latestVersion)
[![Circle CI](https://circleci.com/gh/unitsofmeasurement/unit-tck.svg?style=svg)](https://circleci.com/gh/unitsofmeasurement/unit-tck)
[![Stability: Active](https://masterminds.github.io/stability/active.svg)](https://masterminds.github.io/stability/active.html)
[![License](http://img.shields.io/badge/license-BSD3-blue.svg?style=flat-square)](http://opensource.org/licenses/BSD-3-Clause)

The current module contains the technology compatibility kit of JSR 385.

To setup the TCK with your implementation you must follow the following steps:

 1. Create a new Maven project. You could also use compatible alternatives like Gradle.
 2. Add this TCK and your implementation as dependency.
 3. Implement a class of type tech.units.tck.TestSetup, read the Javadoc, what 
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
-Dtech.units.tck.verbose=yes/no
```
To toggle the `verbose` option of the TCK for extended test output. The default is `false`. And you normally won't need to set this unless you require detailed analysis or issue resolution.

---
**NOTE**

Starting with release **1.1** the groupId of this Parent POM changes from a "virtual" domain **tec.units** to **tech.units**. Laying the ground for the 2.x releases.

---
