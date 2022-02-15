package com.example.webservice.service;

import com.example.webservice.Mapper;
import com.example.webservice.dto.MessageDto;
import com.example.webservice.model.Message;
import com.example.webservice.persistence.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private Mapper mapper;

    public Message createMessage(Message message) throws BadRequest {

        messageRepository.save(message);

        return message;
    }

    private boolean validateMessageFormat() {

        return false;
    }

    private boolean isValidTimeStamp(MessageDto msg) {

        return false;
    }

    private boolean isValidSender() {
        return false;
    }

    private boolean isValidMessage(MessageDto msg) {
        return false;
    }

    private boolean isValidIpv4(MessageDto msg) {
        return false;
    }

}
