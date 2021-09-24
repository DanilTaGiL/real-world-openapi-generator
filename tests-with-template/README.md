#Examples of usage openapi-generator with templates modifying

##Project stack:

+ Java
+ JUnit5
+ Restassured

##Preparation:
You should install `openapi-generator-cli`, for example:
```
npm install @openapitools/openapi-generator-cli -g
```

##Templates modifying:
###Retrieving templates:
First of all you need retrieve templates of generator that you use.
You can do it by simple command:
```
openapi-generator-cli author template -g <GENERATOR_NAME> --library <LIBRARY_NAME>
```
In our case we use Java generator with additional library rest-assured:
```
openapi-generator-cli author template -g java --library rest-assured
```
Result of execution will be a directory `out`, that contain all templates of used generator

###What we want to change:
At first we want add spring support for tests.
For this we need modify `api_test.mustache` template.

To do this all that we need just copy this template from `out` directory and paste
to `src/main/resources/templates` directory (it can be changed in pom.xml)

###Let's check it out:
To check the result just run:
```
mvn clean compile
```
and then look at `target/generated-sources/openapi/backend/src/main/java` directory

p.s. for IDEA indexing this directory you need mark this directory as `Generated sources root`