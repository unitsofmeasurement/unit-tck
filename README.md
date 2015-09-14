unit-tck
========
JSR 363 Technology Compatibility Kit (TCK) 

[![Circle CI](https://circleci.com/gh/unitsofmeasurement/unit-tck.svg?style=svg)](https://circleci.com/gh/unitsofmeasurement/unit-tck)
[![Build Status](https://drone.io/github.com/unitsofmeasurement/unit-tck/status.png)](https://drone.io/github.com/unitsofmeasurement/unit-tck/latest)
[![License](http://img.shields.io/badge/license-BSD3-blue.svg?style=flat-square)](http://opensource.org/licenses/BSD-3-Clause)

The current module contains the technical compatibility kit of JSR 363.

To setup the TCK with your implementation you must follow the following steps:

 1. Create a new Maven project. You could also use compatible alternatives like Gradle.
 2. Add this TCK and your implementation as dependency.
 3. Implement a class of type tec.units.tck.TestSetup, read the Javadoc, what 
  you must provide with this class.
  
## Running
To execute the TCK, simply execute
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
-Dtec.units.tck.profile=<profile>
```
you may select one of the following **profiles**: 
- minimal
- format
- base_quantity
- quantity
- spi
- full
The `full` profile is default whenever you don't explicitly pass a profile.

### Other System Properties
In addition to profiles, the following system properties allow you to override default behavior and storage locations of the TCK:
```
-Dtec.units.tck.outputDir=<output directory>
```
To override the default output directory
```
-Dtec.units.tck.reportFile=<file name>
```
To override the default TCK report file
```
-Dtec.units.tck.verbose=yes/no
```
To toggle the `verbose` option of the TCK for extended test output. The default is `false`. And you normally won't need to set this unless you do detailed analysis or issue resolution.
