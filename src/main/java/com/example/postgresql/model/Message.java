package com.example.postgresql.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "products")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @JsonProperty(required = true)
    @Column(name = "ts")
    Integer ts;

    @NotEmpty
    @JsonProperty(required = true)
    @Column(name = "sender")
    String sender;

    @Column(name = "sentFromIp")
    String sent_from_ip;

    @Column(name = "priority")
    Integer priority;

    @Embedded
    @Column(name = "messageAttributeJson")
    MessageAttributes messageAttributes;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSent_from_ip() {
        return sent_from_ip;
    }

    public void setSent_from_ip(String sentFromIp) {
        this.sent_from_ip = sentFromIp;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public MessageAttributes getMessageAttributes() {
        return messageAttributes;
    }

    public void setMessageAttributes(MessageAttributes messageAttributes) {
        this.messageAttributes = messageAttributes;
    }

}
