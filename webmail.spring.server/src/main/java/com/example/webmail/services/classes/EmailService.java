package com.example.webmail.services.classes;

import com.example.webmail.schemas.SendMessageData;
import com.example.webmail.services.interfaces.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendMessage(SendMessageData messageData) {
        try {
            var mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(messageData.getToEmail());
            mailMessage.setText(messageData.getText());
            mailMessage.setSubject(messageData.getSubject());
            javaMailSender.send(mailMessage);
            return "Сообщение отправлено";
        }
        catch (Exception e) {
            return "При отправке сообщения произошла ошибка:\n" + e.getMessage();
        }
    }
}
