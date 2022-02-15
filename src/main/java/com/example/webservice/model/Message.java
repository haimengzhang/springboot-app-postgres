package com.example.webservice.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "messages")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    int ts;

    String sender;

//    @Embedded
//    private MessageAttributes messageAttributes;

    String sentFromIp;

    int priority;

    public Message() {

    }

    public Message(int ts, String sender) {
        this.ts = ts;
        this.sender = sender;
//        this.messageAttributes = messageAttributes;
    }

    public Message(int ts, String sender, String sentFromIp, int priority) {
        this.ts = ts;
        this.sender = sender;
        this.sentFromIp = sentFromIp;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return ts == message.ts && priority == message.priority && Objects.equals(id, message.id) && sender.equals(message.sender) && sentFromIp.equals(message.sentFromIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ts, sender, sentFromIp, priority);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", ts=" + ts +
                ", sender='" + sender + '\'' +
                ", sentFromIp='" + sentFromIp + '\'' +
                ", priority=" + priority +
                '}';
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

}
