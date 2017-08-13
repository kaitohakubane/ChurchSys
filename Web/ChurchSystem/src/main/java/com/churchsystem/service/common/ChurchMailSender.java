package com.churchsystem.service.common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by hungmcse61561-admin on 6/21/2017.
 */
public class ChurchMailSender {
    @Autowired
    private JavaMailSenderImpl mailSender;


    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String from, String cc, String to, String subject, String msg) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try{
            message.setFrom(new InternetAddress(from));
            helper.setTo(new InternetAddress(to));
            helper.setCc(new InternetAddress(cc));
            message.setText(msg,"UTF-8");
            message.setSubject(subject);
        }catch(Exception e){
            e.printStackTrace();
        }
        mailSender.send(message);
    }
}
