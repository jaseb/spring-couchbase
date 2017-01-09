package jp.bikon.service;

import jp.bikon.model.Example;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        final Example example = new Example("12345", "Test");
        service.create(example);

        // Read
        final Example read = service.getById("12345");
        Assert.assertNotNull("Should not be null", read);

        // Update
        final Example updated = new Example("12345", "Updated");
        service.update(updated);
        // Verify update
        final Example readUpdated = service.getById("12345");
        Assert.assertNotNull("Should not be null", readUpdated);
        Assert.assertEquals(updated.getId(), readUpdated.getId());
        Assert.assertEquals(updated.getMessage(), readUpdated.getMessage());

        // Delete
        service.delete("12345");
        // Verify delete
        final Example deleted = service.getById("12345");
        Assert.assertNull("Should be null", deleted);
    }

}
