# Examples of usage openapi-generator with custom generator creation

## Preparation:
Install `openapi-generator-cli`, for example:
```
npm install @openapitools/openapi-generator-cli -g
```

Other variants of installation you can find [here](https://openapi-generator.tech/docs/installation/)

## Custom generator creation:
### For new generator template generation execute next command:

```
openapi-generator-cli meta -o <OUT_DIRECTORY> -n <NEW_GENERATOR_NAME> -p <PACKAGE_NAME>
```

In our case command will look like this:
```
openapi-generator-cli meta -o custom-generator -n simple-java-spring -p com.example.generator
```

### What we want to change:
Let's add spring support for tests.

And we begin from [SimpleJavaSpringGenerator.java](src/main/java/com/example/generator/SimpleJavaSpringGenerator.java).
By default it contain a lot of code, but we will remove all that we will not use.

First step - add required file templates in [templates directory](src/main/resources/simple-java-spring).
We will use
[Java](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator/src/main/resources/Java) + 
[RestAssured](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator/src/main/resources/Java/libraries/rest-assured)
generator templates as reference, and it will:

+ models:
  + model.mustache
  + modelEnum.mustache
  + modelInnerEnum.mustache
  + pojo.mustache
+ api:
  + api.mustache
+ support files:
  + config_restassured.mustache

### How to use:
Just run:
```
mvn clean install
```
After command execution you can find `.jar` file in `target` directory.
And this is .jar will push in your local maven repository.

And in other projects you can add dependency with this generator, like that:
```
<dependency>
    <groupId>com.example</groupId>
    <artifactId>simple-java-spring-openapi-generator</artifactId>
    <version>1.0.0</version>
</dependency>
```
