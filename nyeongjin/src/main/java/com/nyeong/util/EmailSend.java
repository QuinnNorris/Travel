package com.nyeong.util;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Date;
import java.util.Properties;

/**
 * Title: EmailSend
 * Description: 向用户发送邮件以验证或其他操作 邮箱工具
 *
 * @date: 2017/10/2 下午1:54
 * @author: quinn_norris
 * @version: 1.0
 */
public class EmailSend {

    /**
     * 创建一封邮件并保存
     *
     * @param session          SMTP的session
     * @param sendMail         发送邮件的发送者邮箱
     * @param sendMailNickname 发送邮件人昵称
     * @param receiveMail      接收邮件邮箱
     * @param receivePhone     接收邮件昵称（phone）
     * @param subjectMail      邮件题目
     * @param htmlMail         邮件内容的html转义格式
     * @return 返回一个等待发送的创建好的邮件
     * @throws Exception
     */
    private static MimeMessage createMimeMessage(Session session, String sendMail, String sendMailNickname,
                                                 String receiveMail, String receivePhone, String subjectMail, String htmlMail) throws Exception {
        //创建一封邮件
        MimeMessage message = new MimeMessage(session);
        //发件人
        message.setFrom(new InternetAddress(sendMail, sendMailNickname, "UTF-8"));
        //收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receivePhone, "UTF-8"));
        //邮件主题
        message.setSubject(subjectMail, "UTF-8");
        //邮件正文（可以使用html标签）
        message.setContent(htmlMail, "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }

    /**
     * 通过此方法向用户发送一封邮件
     * 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
     * 如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
     * 打开下面的注释代码, 开启 SSL 安全连接。
     * SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
     * 需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
     * QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
     * final String smtpPort = "465";
     * props.setProperty("mail.smtp.port", smtpPort);
     * props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
     * props.setProperty("mail.smtp.socketFactory.fallback", "false");
     * props.setProperty("mail.smtp.socketFactory.port", smtpPort);
     * 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
     * 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
     * 仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
     * 类型到对应邮件服务器的帮助网站上查看具体失败原因。
     * 连接失败的原因通常为以下几点, 仔细检查代码:
     * (1) 邮箱没有开启 SMTP 服务;
     * (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
     * (3) 邮箱服务器要求必须要使用 SSL 安全连接;
     * (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
     * (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
     *
     * @param receiveMail  收件人邮箱
     * @param receivePhone 收件人昵称（phone）
     * @param subjectMail  邮件主题
     * @param htmlMail     邮件格式html类型
     * @throws Exception
     */
    public static void sendMail(String receiveMail, String receivePhone, String subjectMail, String htmlMail) throws Exception {
        // 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", "SMTP 服务器地址");   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        // 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
        // 创建一封邮件
        MimeMessage message = EmailSend.createMimeMessage(session, "xx发送人邮箱xx@xxx.com",
                "发送邮件人的昵称", receiveMail, receivePhone, subjectMail, htmlMail);
        // 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
        transport.connect("xx发送人邮箱xx@xxx.com", "邮箱SMTP独立密码");
        // 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());
        // 关闭连接
        transport.close();

    }

    /**
     * 通过参数中的文件路径，将要显示在邮件中的html文件通过转义为string类型
     * 存放在字符串中，通过发送邮件方法调用该字符串
     *
     * @param filePath 文件路径
     * @param phone    用户名phone
     * @return 返回转义后的html字符串
     */
    public static String htmlMailToString(String filePath, String phone) {
        File file = new File(filePath);
        String read = "";
        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufread = new BufferedReader(fileReader);) {
            while ((read = bufread.readLine()) != null) {
                read.replace("\"", "\\\"")
                        .replace("username", phone);
                //在此替换所有的转义字符
                stringBuffer.append(read);
            }
            bufread.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stringBuffer.toString();
    }

}
