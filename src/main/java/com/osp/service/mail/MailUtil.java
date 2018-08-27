package com.osp.service.mail;


import com.osp.common.web.AbstractAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil extends AbstractAction{
    private Logger logger = LoggerFactory.getLogger(MailUtil.class);

    public void sendGmail(String[] to, String subject, String body) throws AddressException, MessagingException {
        String from = getText("email.username");
        String pass = getText("email.password");
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));
        InternetAddress[] toAddress = new InternetAddress[to.length];

        // To get the array of addresses
        for (int i = 0; i < to.length; i++) {
            toAddress[i] = new InternetAddress(to[i]);
        }

        for (int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }
        message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        message.addHeader("format", "flowed");
        message.addHeader("Content-Transfer-Encoding", "8bit");
        message.setContent(body, "text/html; charset=UTF-8");
        message.setSubject(subject, "UTF-8");
        // message.setText(body, "UTF-8", "text/html");

        // System.out.println(message.getContent().toString());
        Transport transport = session.getTransport("smtp");
        transport.connect(host, from, pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public boolean mail(String mailTo, String newPass, String account, String linkLogin) {
        final String username = "ospuchitest@gmail.com";
        final String password = "tongcongty";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ospuchitest@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mailTo));
            message.setSubject("[OSP:UCHI] Cấp lại mật khẩu","utf-8");
            message.setContent("<h4 style='color:black'>Mật khẩu mới cho tài khoản " + account + " là : <a style='text-decoration:none;' href='#'>" + newPass + "</a></h4>" +
                    "<p>Để bảo vệ thông tin cá nhân hãy đăng nhập và đổi mật khẩu " + "<a style='color:blue;text-decoration:none;' href='" + linkLogin + "'>Tại đây</a>" + " </p><br>" +
                    "<div style='with:100%;text-align:center;'>" +
                    "<p style='text-align:center;font-weight:bold'>CÔNG TY CỔ PHẦN CÔNG NGHỆ PHẦN MỀM VÀ NỘI DUNG SỐ OSP</p>" +
                    "<p style='text-align:center;'>Trụ sở:  Tầng 7, Toà Nhà Đại Phát, số 82, Phố Duy Tân, Cầu Giấy , Hà Nội</p>" +
                    "<p style='text-align:center;'>Tel: (024) 3568 2502; (024) 3568 2503; Fax: (024) 3568 2504</p>" +
                    "<p style='text-align:center;'>Website: www.osp.com.vn</p></div>", "text/html; charset=UTF-8");
            //message.setText(newPass);
            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
