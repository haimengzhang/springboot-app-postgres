package com.example.webservice;

import com.example.webservice.dto.MessageDto;
import com.example.webservice.model.Message;
import com.example.webservice.model.MessageAttributes;
import com.example.webservice.service.MessageService;
import groovy.transform.TailRecursive;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @Test
    void testCreateMessage_returns_201_created() {
        MessageDto message = new MessageDto();
        message.setTs(1530228282);
        message.setSender("testy-test-service");

        Map<String, Object> msgAttributesMap = new HashMap<>();
        msgAttributesMap.put("address", "123 Main Street");
        msgAttributesMap.put("zipcode", 12345);

        messageService.createMessage(message);
    }

    @Test
    void testCreateMessage_Invalid_TimeStamp() {

    }

    @Test
    void testCreateMessage_InvalidIpv4() {

    }

    @Test
    void testCreateMessage_InvalidMessageBody() {

    }

    @Test
    void testCreateMessage_InvalidSenderString() {

    }

    @Test
    void testCreateMessage_SenderIsNull() {

    }

    @Test
    void testCreateMessage_InvalidRequestBody() {

    }
}
