package com.example.webservice.dto;

import com.example.webservice.model.MessageAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {

    @Valid
    @JsonProperty(value = "ts", required = true)
    int ts;

    @Valid
    @JsonProperty(value = "sender", required = true)
    String sender;

    @Valid
    @JsonProperty(value = "message", required = true)
    MessageAttributes messageAttributes;

    @JsonProperty(value = "sent-from-ip", required = true)
    String sentFromIp;

    @JsonProperty("priority")
    int priority;

    public MessageDto() {

    }

    public MessageDto(int ts, String sender) {
        this.ts = ts;
        this.sender = sender;
    }

    public MessageDto(int ts, String sender, String sentFromIp) {
        this.ts = ts;
        this.sender = sender;
        this.sentFromIp = sentFromIp;
    }

    public MessageDto(int ts, String sender, int priority) {
        this.ts = ts;
        this.sender = sender;
        this.priority = priority;
    }

    public MessageDto(int ts, String sender, String sentFromIp, int priority) {
        this.ts = ts;
        this.sender = sender;
        this.sentFromIp = sentFromIp;
        this.priority = priority;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageAttributes getMessageAttributes() {
        return messageAttributes;
    }

    public void setMessageAttributes(MessageAttributes messageAttributes) {
        this.messageAttributes = messageAttributes;
    }

    public String getSentFromIp() {
        return sentFromIp;
    }

    public void setSentFromIp(String sentFromIp) {
        this.sentFromIp = sentFromIp;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

}
