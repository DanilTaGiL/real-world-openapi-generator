package com.example.generator;

import org.junit.Test;
import org.openapitools.codegen.ClientOptInput;
import org.openapitools.codegen.DefaultGenerator;
import org.openapitools.codegen.config.CodegenConfigurator;

/***
 * This test allows you to easily launch your code generation software under a debugger.
 * Then run this test under debug mode.  You will be able to step through your java code 
 * and then see the results in the out directory. 
 *
 * To experiment with debugging your code generator:
 * 1) Set a break point in SimpleJavaSpringGenerator.java in the postProcessOperationsWithModels() method.
 * 2) To launch this test in Eclipse: right-click | Debug As | JUnit Test
 *
 */
public class SimpleJavaSpringGeneratorTest {

  // use this test to launch you code generator in the debugger.
  // this allows you to easily set break points in MyclientcodegenGenerator.
  @Test
  public void launchCodeGenerator() {
    // to understand how the 'openapi-generator-cli' module is using 'CodegenConfigurator', have a look at the 'Generate' class:
    // https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-cli/src/main/java/org/openapitools/codegen/cmd/Generate.java

    final CodegenConfigurator configurator = new CodegenConfigurator()
//            .setVerbose(true) // for debug output
              .setGeneratorName("simple-java-spring") // use this codegen library
               .setInputSpec("http://localhost:8080/v3/api-docs") // or from the server
//               .setInputSpec("https://raw.githubusercontent.com/openapitools/openapi-generator/master/modules/openapi-generator/src/test/resources/2_0/petstore.yaml") // or from the server
//              .setInputSpec("src/test/resources/openapi-backend.json") // sample OpenAPI file
            .setOutputDir("target/generated-sources/test/simple-java-spring"); // output directory

    final ClientOptInput clientOptInput = configurator.toClientOptInput();
    DefaultGenerator generator = new DefaultGenerator();
    generator.opts(clientOptInput).generate();
  }
}