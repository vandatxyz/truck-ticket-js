package com.anoystick.service.impl;

import com.anoystick.entity.mail.EmailEntity;
import com.anoystick.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String EMAIL_HOST = "vandatxyz@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sendTextMail(EmailEntity email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EMAIL_HOST);
        message.setTo(email.getToEmail());
        message.setSubject(email.getSubject());
        message.setText(email.getMessageBody());
        message.setSentDate(new java.util.Date());
        try {
            mailSender.send(message);
            System.out.println("Email sent successfully");
            return "Email sent successfully";
        }
        catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public String sendHtmlMail(EmailEntity email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(EMAIL_HOST);
            helper.setTo(email.getToEmail());
            helper.setSubject(email.getSubject());
            helper.setText(email.getMessageBody(), true);

            mailSender.send(message);
            System.out.println("Email sent successfully");
            return "Email sent successfully";
        }
        catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public String sendEmailAttachmentMail(EmailEntity email) {
        return "";
    }
}
