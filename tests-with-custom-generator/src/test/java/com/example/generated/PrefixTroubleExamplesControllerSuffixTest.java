package com.example.generated;

import com.example.generated.api.PrefixTroubleExamplesControllerSuffix;
import com.example.generated.model.InlineObject1;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * API tests for PrefixTroubleExamplesControllerSuffix
 */
@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PrefixTroubleExamplesControllerSuffixTest {

    @Autowired      // don't need initialize api object
    private PrefixTroubleExamplesControllerSuffix api;


    /**
     * OK
     */
    @Test // List<byte[]> replaced on byte[], and now its work
    public void shouldSee200AfterGetByteArray() {
        var response = api.getByteArray()
                .body("[]").executeAs(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * OK
     */
    @Test
    public void shouldSee200AfterGetListFiles() {
        InlineObject1 inlineObject1 = new InlineObject1();
        var response = api.getListFiles()
                .body(inlineObject1).executeAs(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * OK
     */
    @Test
    public void shouldSee200AfterGetListString() {
        List<String> strings = List.of("Test");
        var response = api.getListString()
                .stringsQuery(strings).executeAs(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * OK
     */
    @Test
    public void shouldSee200AfterGetRawByteArray() {
        var response = api.getRawByteArray()
                .respSpec(spec -> spec.expectContentType(ContentType.BINARY))
                .body("[]").execute(r -> r.asByteArray());
        // TODO: test validations
    }

    /**
     * OK
     */
    @Test
    public void shouldSee200AfterGetRawByteArrayFix() {
        var response = api.getRawByteArrayFix()
                .respSpec(spec -> spec.expectContentType(ContentType.BINARY))
                .body("[]").execute(r -> r.asByteArray());
        // TODO: test validations
    }

    /**
     * OK
     */
    @Test
    public void shouldSee200AfterGetRawListFiles() {
        var response = api.getRawListFiles()
                .body("[]").executeAs(r -> r.prettyPeek());
        // TODO: test validations
    }

    /**
     * OK
     */
    @Test
    public void shouldSee200AfterGetRawListString() {
        List<String> strings = List.of("Test");
        var response = api.getRawListString()
                .stringsQuery(strings).executeAs(r -> r.prettyPeek());
        // TODO: test validations
    }
}