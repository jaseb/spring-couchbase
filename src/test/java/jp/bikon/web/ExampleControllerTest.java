package jp.bikon.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jp.bikon.model.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * @author jase
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    private static final String URL = "/example";

    @Test
    public void testCRUD() throws Exception {

        final Example example = new Example("12345", "Test message");
        final String json = jacksonObjectMapper.writeValueAsString(example);

        // Create
        mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json))
                .andExpect(status().isOk());

        // Read
        mockMvc.perform(get("/example/12345").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("Test message")));

        // Update
        example.setMessage("Updated message");
        final String updatedJson = jacksonObjectMapper.writeValueAsString(example);

        mockMvc.perform(put("/example/12345").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(updatedJson))
                .andExpect(status().isOk());

        // Verify update
        mockMvc.perform(get("/example/12345").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("Updated message")));

        // Delete
        mockMvc.perform(delete("/example/12345")).andExpect(status().isOk());

        // Verify delete
        mockMvc.perform(get("/example/12345").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("")));
    }

}
