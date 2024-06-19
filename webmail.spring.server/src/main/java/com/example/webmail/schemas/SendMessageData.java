package com.example.webmail.schemas;

import lombok.Data;

@Data
public class SendMessageData {
    private String toEmail;
    private String subject;
    private String text;
}
