package com.example.generator;

import org.openapitools.codegen.*;
import org.openapitools.codegen.templating.mustache.CaseFormatLambda;

import java.util.*;
import java.io.File;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.UPPER_UNDERSCORE;

public class SimpleJavaSpringGenerator extends DefaultCodegen implements CodegenConfig {
  private static final String JAVA_FILE_EXTENSION = ".java";

  // source folder where to write the files
  protected String sourceFolder = "src/main/java";
  protected String testSourceFolder = "src/test/java";
  protected String basePackage = "org.openapitools";

  /**
   * Configures the type of generator.
   * 
   * @return  the CodegenType for this generator
   * @see     org.openapitools.codegen.CodegenType
   */
  @Override
  public CodegenType getTag() {
    return CodegenType.OTHER;
  }

  /**
   * Configures a friendly name for the generator.  This will be used by the generator
   * to select the library with the -g flag.
   * 
   * @return the friendly name for the generator
   */
  @Override
  public String getName() {
    return "simple-java-spring";
  }

  /**
   * Provides an opportunity to inspect and modify operation data before the code is generated.
   */
  @SuppressWarnings("unchecked")
  @Override
  public Map<String, Object> postProcessOperationsWithModels(Map<String, Object> objs, List<Object> allModels) {

    // to try debugging your code generator:
    // set a break point on the next line.
    // then debug the JUnit test called LaunchGeneratorInDebugger

    Map<String, Object> results = super.postProcessOperationsWithModels(objs, allModels);

    OperationsProcessing.changeReturnBaseType(results); // ByteArray -> Byte

    return results;
  }

  @Override
  public Map<String, Object> postProcessAllModels(Map<String, Object> objs) {
    Map<String, Object> result = super.postProcessAllModels(objs);

    ModelsProcessing.byteArrayReplacement(result);

    return result;
  }

  /**
   * Returns human-friendly help for the generator.  Provide the consumer with help
   * tips, parameters here
   * 
   * @return A string value for the help message
   */
  public String getHelp() {
    return "Generates a simple-java-spring client library.";
  }

  @Override
  public void processOpts() {
    super.processOpts();
    var invokerPackage = (String) additionalProperties.get("invokerPackage");
    if (invokerPackage != null) {
      basePackage = invokerPackage;
    }
    var configPackage = basePackage + ".config";

    /**
     * Models.  You can write model files using the modelTemplateFiles map.
     * if you want to create one template for file, you can do so here.
     * for multiple files for model, just put another entry in the `modelTemplateFiles` with
     * a different extension
     */
    modelTemplateFiles.put(
            "model.mustache", // the template to use
            JAVA_FILE_EXTENSION);       // the extension for each file to write

    /**
     * Api classes.  You can write classes for each Api file with the apiTemplateFiles map.
     * as with models, add multiple entries with different extensions for multiple files per
     * class
     */
    apiTemplateFiles.put(
            "api.mustache",   // the template to use
            JAVA_FILE_EXTENSION);       // the extension for each file to write

    // Api test classes
    apiTestTemplateFiles.put("api_test.mustache", JAVA_FILE_EXTENSION);

    /**
     * Supporting Files.  You can write single files for the generator with the
     * entire object tree available.  If the input file has a suffix of `.mustache
     * it will be processed by the template engine.  Otherwise, it will be copied
     */
    supportingFiles.add(new SupportingFile(
            "config_restassured.mustache",              // the input template or file
            configPackageFolder(),                      // the destination folder, relative `outputFolder`
            "RestAssuredConfig" + JAVA_FILE_EXTENSION   // the output file
    ));

    // add custom properties for using it in templates
    additionalProperties.put("configPackage", configPackage); // used in config_restassured

    // lambdas
    additionalProperties.put("convert", new CaseFormatLambda(LOWER_CAMEL, UPPER_UNDERSCORE));
  }

  public SimpleJavaSpringGenerator() {
    super();

    // set the output folder here
    outputFolder = "generated-code/simple-java-spring";

    // Template Location. This is the location which templates will be read from.
    templateDir = "simple-java-spring";

    // Api Package.  Optional, if needed, this can be used in templates
    apiPackage = "org.openapitools.api";

    // Model Package.  Optional, if needed, this can be used in templates
    modelPackage = "org.openapitools.model";

    /* available configOptions */
    cliOptions.add(CliOption.newBoolean("restassuredGlobalSpec", "If true, provide default request spec for all requests", false));

    // enable api prefix/postfix feature
    cliOptions.add(CliOption.newString("apiNamePrefix", "Add prefix to api name"));
    cliOptions.add(CliOption.newString("apiNameSuffix", "Add suffix to api name"));
  }

  /**
   * Location to write model files.  You can use the modelPackage() as defined when the class is
   * instantiated
   */
  @Override
  public String modelFileFolder() {
    return outputFolder + "/" + sourceFolder + "/" + modelPackage().replace('.', File.separatorChar);
  }

  /**
   * Location to write api files.  You can use the apiPackage() as defined when the class is
   * instantiated
   */
  @Override
  public String apiFileFolder() {
    return outputFolder + "/" + sourceFolder + "/" + apiPackage().replace('.', File.separatorChar);
  }

  @Override
  public String apiTestFileFolder() {
    return outputFolder + "/" + testSourceFolder + "/" + apiPackage().replace('.', File.separatorChar);
  }

  // custom
  public String basePackageFolder() {
    return sourceFolder + "/" + basePackage.replace('.', File.separatorChar);
  }

  // custom
  public String configPackageFolder() {
    return basePackageFolder() + "/config";
  }
}