package com.anoystick.util;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderUtil {
    private static final String EMAIL_HOST = "vandatxyz@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    public void setMailSender(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EMAIL_HOST);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setSentDate(new java.util.Date());
        try {
            mailSender.send(message);
            System.out.println("Email sent successfully");
        }
        catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    public void sendMailHTMLSender(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(EMAIL_HOST);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);

            mailSender.send(message);
            System.out.println("Email sent successfully");
        }
        catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
