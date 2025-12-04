package com.anoystick.service;

import com.anoystick.entity.mail.EmailEntity;

public interface EmailService {

    String sendTextMail(EmailEntity email);
    String sendHtmlMail(EmailEntity email);
    String sendEmailAttachmentMail(EmailEntity email);
}
