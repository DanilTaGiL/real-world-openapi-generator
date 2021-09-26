package com.example.generator;

import org.openapitools.codegen.CodegenOperation;

import java.util.List;
import java.util.Map;

public class OperationsProcessing {
    private static List<CodegenOperation> getCodegenOperations(Map<String, Object> postProcessOperations) {
        return (List<CodegenOperation>) ((Map<String, Object>) postProcessOperations.get("operations")).get("operation");
    }

    public static void changeReturnBaseType(Map<String, Object> postProcessOperations) {
        List<CodegenOperation> ops = getCodegenOperations(postProcessOperations);

        ops.forEach(operation -> {
            if (operation.returnBaseType != null) {
                if (operation.returnBaseType.equals("ByteArray")) {
                    operation.returnBaseType = "Byte";
                }
            }
        });
    }
}