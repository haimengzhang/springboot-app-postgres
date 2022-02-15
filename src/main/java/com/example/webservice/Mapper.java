package com.example.webservice;

import com.example.webservice.dto.MessageDto;
import com.example.webservice.model.Message;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public MessageDto toMessageDto(Message message) {
        MessageDto messageDto = new MessageDto(message.getTs(), message.getSender());
        messageDto.setPriority(message.getPriority());
        return messageDto;
    }

    public Message toMessage(MessageDto messageDto) {
        return new Message(messageDto.getTs(), messageDto.getSender(),
                messageDto.getSentFromIp(), messageDto.getPriority());
    }
}
