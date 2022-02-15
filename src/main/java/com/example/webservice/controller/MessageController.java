/*
 * $Copyright: Copyright (c) 2022 Veritas Technologies LLC. All rights reserved VT25-0977-2658-84-51-3 $
 */

package com.example.webservice.controller;

import javax.validation.Valid;

import com.example.webservice.model.Message;
import com.example.webservice.persistence.MessageRepository;
import com.example.webservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createMessage(@Valid @RequestBody final Message request) {
        messageService.createMessage(request);

        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAllMessages() {
        return ResponseEntity.ok(messageRepository.findAll());
    }

}
