package jp.bikon.service;

import jp.bikon.model.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * @author jase
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ExampleServiceTest {

    @Autowired
    private ExampleService service;

    @Test
    public void testCRUD() {

        // Create
        final Example example = new Example("12345", "Test message");
        service.create(example);

        // Read
        final Example persisted = service.getById("12345");
        assertNotNull("Should not be null", persisted);
        assertEquals(persisted.getId(), example.getId());
        assertEquals(persisted.getMessage(), example.getMessage());

        // Update
        example.setMessage("Updated message");
        service.update(example);

        // Verify update
        final Example updated = service.getById("12345");
        assertNotNull("Should not be null", updated);
        assertEquals(example.getId(), updated.getId());
        assertEquals(example.getMessage(), updated.getMessage());

        // Delete
        service.delete("12345");

        // Verify delete
        final Example deleted = service.getById("12345");
        assertNull("Should be null", deleted);
    }

}
