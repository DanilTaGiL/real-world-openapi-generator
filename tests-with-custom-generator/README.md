# Examples of usage openapi-generator with custom generator

## Project stack:

+ Java
+ JUnit5
+ Restassured
+ Custom openapi-generator

## Preparation:
Install `openapi-generator-cli`, for example:
```
npm install @openapitools/openapi-generator-cli -g
```

Other variants of installation you can find [here](https://openapi-generator.tech/docs/installation/)

## Custom generator usage:

// TODO

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
