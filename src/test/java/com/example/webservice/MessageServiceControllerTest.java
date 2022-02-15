package com.example.webservice;

import com.example.webservice.dto.MessageDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class MessageServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    void test_post_creatMessage_201_SUCCESS() throws Exception {

        String URL = "/messages";

//        Map<String, Object> msgAttributesMap = new HashMap<>();
//        msgAttributesMap.put("address", "123 Main Street");
//        msgAttributesMap.put("zipcode", 12345);
//
//        MessageDto messageDto = new MessageDto(1530228282, "testy-test-service", msgAttributesMap);
//
//        this.mockMvc.perform(post(URL)
//                        .content(mapper.writeValueAsString(messageDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void test_post_creatMessage_INVALID_JSON() throws Exception {

        String URL = "/messages";

//        Map<String, Object> msgAttributesMap = new HashMap<>();
//        msgAttributesMap.put("address", "123 Main Street");
//        msgAttributesMap.put("zipcode", 12345);
//
//        MessageDto messageDto = new MessageDto(1530228282, "testy-test-service", msgAttributesMap);
//
//        this.mockMvc
//                .perform(post(URL)
//                        .content(mapper.writeValueAsString(messageDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isBadRequest())
//                .andExpect((ResultMatcher) jsonPath("$.errorCode").value("Bad message json."));
    }
}
