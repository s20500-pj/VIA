package com.via.service;

import com.via.exception.EmailNotSendException;
import com.via.utils.NotifyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EmailService implements NotifyService {

    private JavaMailSender mailSender;

    @Override
    public void notify(String email, String message) {
        try {
            sendSimpleMessage(email, "Lista działań", message);
        } catch (MailException e) {
            log.error("Error during sending email: {}", email, e);
            throw new EmailNotSendException("Couldn't send email to: " + email);
        }
    }

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}