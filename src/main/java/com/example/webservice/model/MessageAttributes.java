package com.example.webservice.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.Type;

import javax.persistence.Embeddable;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Embeddable
public class MessageAttributes {

    @Valid
    @Type( type = "json" )
    private Map<String, String> messageAttributes;

    private String messageAttributesJSON;

    public void serializeMessageAttributes() throws JsonProcessingException {
        this.messageAttributesJSON = new ObjectMapper().writeValueAsString(messageAttributes);
    }

    public void deserializeMessageAttributes() throws IOException {
        this.messageAttributes = new ObjectMapper().readValue(messageAttributesJSON, HashMap.class);
    }
}
