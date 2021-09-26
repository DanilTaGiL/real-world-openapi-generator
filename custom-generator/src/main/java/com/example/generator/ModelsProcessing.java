package com.example.generator;

import org.openapitools.codegen.CodegenModel;

import java.util.List;
import java.util.Map;

public class ModelsProcessing {
    private static CodegenModel getCodegenModelFromMap(Map<String, Object> postProcessModels) {
        var models = (List<Object>) postProcessModels.get("models");
        var model = (Map<String, Object>) models.get(0);
        return (CodegenModel) model.get("model");
    }

    public static void byteArrayReplacement(Map<String, Object> postProcessModels) {
        postProcessModels.forEach((key, value) -> {
            var codegenModel = getCodegenModelFromMap((Map<String, Object>) value);

            if (codegenModel.vars != null) {
                codegenModel.vars.forEach(var -> {
                    if (var.complexType != null && var.complexType.equals("ByteArray")) {
                        var.items = null;
                        var.isContainer = false;
                        var.datatypeWithEnum = "byte[]";
                    }
                });
            }
        });
    }
}
