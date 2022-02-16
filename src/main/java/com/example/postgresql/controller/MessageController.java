package com.example.postgresql.controller;

import com.google.gson.Gson;
import org.apache.commons.validator.routines.InetAddressValidator;
import com.example.postgresql.model.Message;
import com.example.postgresql.repository.MessageRepository;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import org.json.simple.parser.ParseException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;

@RestController
@RequestMapping("/product")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    
    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(this.messageRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody Message message) throws IOException, ParseException {
        long now = Instant.now().getEpochSecond();

        Integer timeStamp = message.getTs();
        String sender = message.getSender();
        String ipv4 = message.getSent_from_ip();
        String foo = message.getMessageAttributes().getFoo();
        String bar = message.getMessageAttributes().getBar();
        InetAddressValidator inetAddressValidator = InetAddressValidator.getInstance();
        String SCHEMA_PATH =
                "/Users/kylehe/repo/spring-boot-postgresql/src/main/java/com/example/postgresql/schema/messageSchema.json";

        //schema validation
        try (InputStream inputStream = getClass().getResourceAsStream("/schema/messageSchema.json")) {
            JSONObject rawSchema = new JSONObject(inputStream);
            Schema schema = SchemaLoader.load(rawSchema);
            Gson gson = new Gson();
            schema.validate(gson.toJson(message));
        } catch (IOException e) {
            return new ResponseEntity<>("Invalid schema", HttpStatus.BAD_REQUEST);
        }

        if (timeStamp == null) {
            return new ResponseEntity<>("Timestamp must not be null", HttpStatus.BAD_REQUEST);
        }

        if ((long) timeStamp >= now) {
            return new ResponseEntity<>("Timestamp " + timeStamp + " is not a valid unix timestamp.", HttpStatus.BAD_REQUEST);
        }

        if (sender == null) {
            return new ResponseEntity<>("Sender must not be null", HttpStatus.BAD_REQUEST);
        }

        if (ipv4 != null && !inetAddressValidator.isValid(ipv4)) {
            return new ResponseEntity<>("The IP address " + ipv4 + " isn't valid", HttpStatus.BAD_REQUEST);
        }

        if (foo == null && bar == null) {
            return new ResponseEntity<>("Message attributes cannot be null", HttpStatus.BAD_REQUEST);
        }

        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.convertAndSend("myQueue", "Hello, world!");
        messageRepository.save(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
