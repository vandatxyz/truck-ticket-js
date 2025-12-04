package com.anoystick;

import com.anoystick.util.EmailSenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {

    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Test
    public void SendEmailTest(){
        String to = "maily101102@gmail.com";
        String subject = "Test Send Email";
        String content = "This is a test email";

        emailSenderUtil.setMailSender(to,subject,content);
    }

    @Test
    public void SendEmailHTMLTest() throws IOException {
        String to = "maily101102@gmail.com";
        String subject = "Test Send Email";
        String content = "This is a test email";

        Resource resource = new ClassPathResource("/templates/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        emailSenderUtil.sendMailHTMLSender(to,subject,htmlContent);
    }
}
