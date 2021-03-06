# Examples of usage openapi-generator with templates modifying

## Project stack:

+ Java
+ JUnit5
+ Restassured

## Preparation:
Install `openapi-generator-cli`, for example:
```
npm install @openapitools/openapi-generator-cli -g
```

Other variants of installation you can find [here](https://openapi-generator.tech/docs/installation/)

## Templates modifying:
### Retrieving templates:
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

### What we want to change:
Let's add spring support for tests.
For this we need modify `api_test.mustache` template.

To do this all that we need just copy this template from `out` directory and paste
to [src/main/resources/templates](src/main/resources/templates) directory (it can be changed in pom.xml)

### Let's check it out:
To check the result just run:
```
mvn clean compile
```
and then look at `target/generated-sources/openapi/backend/src/test/java` directory.

This is first generated test template :)

Let's [copy it in our project](src/test/java/com/example/generated/UserControllerApiTest.java) and will add some assertions.

p.s. For IDEA indexing this directory you need mark this directory as `Generated sources root`    
p.s.s. More information you can find in [documentation](https://openapi-generator.tech/docs/templating/#retrieving-templates)
