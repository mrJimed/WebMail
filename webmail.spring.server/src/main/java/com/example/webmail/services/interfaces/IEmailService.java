package com.example.webmail.services.interfaces;

import com.example.webmail.schemas.SendMessageData;

public interface IEmailService {
    String NAME = "emailService";

    void sendMessage(SendMessageData messageData);
}
