package jp.bikon.service;

import jp.bikon.model.Example;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleServiceTest {

    @Autowired
    private ExampleService service;

    @Test
    public void testCRUD() {

        // Create
        final Example example = new Example("12345", "Test message");
        service.create(example);

        // Read
        final Example read = service.getById("12345");
        assertNotNull("Should not be null", read);
        assertEquals(read.getId(), example.getId());
        assertEquals(read.getMessage(), example.getMessage());

        // Update
        final Example updated = new Example("12345", "Updated message");
        service.update(updated);
        // Verify update
        final Example readUpdated = service.getById("12345");
        assertNotNull("Should not be null", readUpdated);
        assertEquals(updated.getId(), readUpdated.getId());
        assertEquals(updated.getMessage(), readUpdated.getMessage());

        // Delete
        service.delete("12345");
        // Verify delete
        final Example deleted = service.getById("12345");
        assertNull("Should be null", deleted);
    }

}
