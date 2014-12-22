unit-tck
========

JSR 363 Technology Compatibility Kit (TCK) 

The current module contains the technical compatibility kit of JSR 363.

To setup the TCK with your implementation you must follow the following steps:

1) Create a new maven project.
2) Add this TCK and your implementation as dependency.
3) Implement a class of type tec.units.tck.TestSetup, read the Javadoc, what 
  you must provide with this class.
  
To execute the TCK, simply execute
  
mvn clean test site
       
5) Go to target/site - there you will find your TCK test results.
   