package com.rest;

/*import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;*/

/**
 * Created by Lingfeng on 2016/3/23.
 */
/*public class EmailTest {

    @Test
    public void textSend() {
        JavaMailSender sender = createSender();

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("joseph.wang@jjcargo.com");
        mail.setTo("joseph.wlf@qq.com");
        mail.setSubject("测试Spring Mail(text)");

        String text = "你购买了什么？你猜啊！";
        mail.setText(text);
        sender.send(mail);
    }

    @Test
    public void htmlSend() {
        JavaMailSender sender = createSender();
        //建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mailMessage = sender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);

        try {
            // 设置收件人，寄件人
            messageHelper.setFrom("joseph.wang@jjcargo.com");
            messageHelper.setTo("joseph.wlf@qq.com");

            messageHelper.setSubject("测试Spring Mail(html)");
            //true 表示启动HTML格式的邮件
            messageHelper.setText("<html><head></head><body><h1>hello!!it's me</h1></body></html>", true);

            //发送邮件
            sender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void htmlWithPicSend() {
        JavaMailSender sender = createSender();

        //建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mimeMessage = sender.createMimeMessage();

        try {
            //注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用multipart模式
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");

            // 设置收件人，寄件人
            messageHelper.setFrom("joseph.wang@jjcargo.com");
            messageHelper.setTo("joseph.wlf@qq.com");

            messageHelper.setSubject("测试Spring Mail(html with pic)");
            //true 表示启动HTML格式的邮件
            messageHelper.setText("<html><head></head><body><h1>hello!!&nbsp;it's me</h1><br/>" +
                    "<a href='http://www.baidu.com' target='_blank'>这只是一段简单的中文</a><br/>" +
                    "<img src='cid:heihei'/></body></html>", true);

            FileSystemResource img = new FileSystemResource(new File("E:\\mail_send\\QQ20150630111611.png"));
            messageHelper.addInline("heihei", img);
            sender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void attachmentSend() {
        JavaMailSender sender = createSender();

        //建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mimeMessage = sender.createMimeMessage();

        try {
            //注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用multipart模式
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");

            // 设置收件人，寄件人
            messageHelper.setFrom("joseph.wang@jjcargo.com");
            messageHelper.setTo("joseph.wlf@qq.com");

            messageHelper.setSubject("测试Spring Mail(html with attachment file)");
            //true 表示启动HTML格式的邮件
            messageHelper.setText("<html><head></head><body><h1>hello!!&nbsp;it's me</h1><br/>" +
                    "<a href='http://www.baidu.com' target='_blank'>这只是一段简单的中文</a><br/>" +
                    "<img src='cid:pic'/></body></html>", true);

            FileSystemResource img = new FileSystemResource(new File("E:\\mail_send\\QQ20150630111611.png"));
            messageHelper.addInline("pic", img);

            FileSystemResource attachmentFile = new FileSystemResource(new File("E:\\mail_send\\info.txt"));
            messageHelper.addAttachment("下载看看.txt", attachmentFile);

            sender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public JavaMailSender createSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.smtp.auth", "true");
        // 添加SSL认证
        javaMailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        sender.setHost("smtp.jjcargo.com");
        sender.setPort(465);
        sender.setJavaMailProperties(javaMailProperties);
        sender.setUsername("joseph.wang@jjcargo.com");
        sender.setPassword("W19901208lf");

        return sender;
    }
}*/
