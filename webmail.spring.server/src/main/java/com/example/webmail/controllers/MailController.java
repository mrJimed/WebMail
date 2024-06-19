package com.example.webmail.controllers;

import com.example.webmail.schemas.SendMessageData;
import com.example.webmail.services.interfaces.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private IEmailService emailService;

    @PostMapping("/send")
    public String sendMessage(SendMessageData messageData){
        return emailService.sendMessage(messageData);
    }
}
