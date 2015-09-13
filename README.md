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