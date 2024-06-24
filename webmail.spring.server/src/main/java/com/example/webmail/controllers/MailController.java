package com.example.webmail.controllers;

import com.example.webmail.schemas.SendMessageData;
import com.example.webmail.services.interfaces.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@Slf4j
public class MailController {
    @Autowired
    private IEmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody SendMessageData messageData) {
        try {
            emailService.sendMessage(messageData);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("При отправке сообщения произошла ошибка.", e);
            return new ResponseEntity<String>("При отправке сообщения произошла ошибка.", HttpStatus.BAD_REQUEST);
        }
    }
}
