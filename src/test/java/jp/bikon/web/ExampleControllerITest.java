package jp.bikon.web;

import jp.bikon.model.Example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * @author jase
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExampleControllerITest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/example/");
    }

    @Test
    public void testCRUD() throws Exception {

        final Example example = new Example("12345", "Test message");

        // Create
        template.postForEntity(base.toString(), example, Example.class);

        // Read
        ResponseEntity<Example> response =
                template.getForEntity(base.toString() + "12345", Example.class);
        assertNotNull("Should not be null", response.getBody());
        assertEquals("12345", response.getBody().getId());
        assertEquals("Test message", response.getBody().getMessage());

        // Update
        example.setMessage("Updated message");
        template.put(base.toString() + "12345", example, Example.class);

        // Verify
        ResponseEntity<Example> updated =
                template.getForEntity(base.toString() + "12345", Example.class);
        assertNotNull("Should not be null", updated.getBody());
        assertEquals("12345", updated.getBody().getId());
        assertEquals("Updated message", updated.getBody().getMessage());

        // Delete
        template.delete(base.toString() + "12345");

        // Verify delete
        ResponseEntity<Example> deleted =
                template.getForEntity(base.toString() + "12345", Example.class);
        assertEquals("Entity not found", deleted.getBody().getMessage());
    }
}
