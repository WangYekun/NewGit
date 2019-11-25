package study11;

import com.sun.mail.pop3.POP3Folder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.util.MimeMessageParser;

import javax.activation.DataSource;
import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;


/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/11/8 16:07
 * @description javamail解析邮件内容中含有图片
 * 方法说明：邮件内容中包含图片，则将正文中的图片上传到文件储存服务器(OOS)上，
 * * 然后将[原图片地址]替换成[上传到OOS上后的地址]
 */
public class ContentImageReceive {
    public static void main(String[] args) throws Exception {
        Folder folder = null;
        Store store = null;
        try {
            Properties props = new Properties();
            // 协议
            props.setProperty("mail.store.protocol", "pop3");
            // 端口 110 995
            props.setProperty("mail.pop3.port", "995");
            // pop3服务器
            props.setProperty("mail.pop3.host", "pop.qiye.163.com");
            // 如果设置，则指定实现该javax.net.SocketFactory接口的类的名称 。这个类将被用来创建POP3套接字。
            props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            // 如果设置为true，则无法使用指定的套接字工厂类创建套接字将导致使用java.net.Socket该类创建套接字。默认为true。
            props.setProperty("mail.pop3.socketFactory.fallback", "false");
            // 指定在使用指定的套接字工厂时要连接的端口。如果未设置，则将使用默认端口。
            props.setProperty("mail.pop3.socketFactory.port", "995");
            props.setProperty("mail.pop3.ssl.enable", "true");
            //          props.setProperty("mail.debug", "true");//打印mail日志
            //			props.setProperty("mail.mime.charset","iso8859-1");
            Session session = Session.getInstance(props);
            session.setDebug(false);
            store = session.getStore("pop3");
            store.connect("17866630618@163.com", "aa1234567890");
            // 获得收件箱
            folder = store.getFolder("INBOX");

            POP3Folder inbox = (POP3Folder) folder;
            /*
             * Folder.READ_ONLY：只读权限
             * Folder.READ_WRITE：可读可写（可以修改邮件的状态）
             */
            // 打开收件箱
            folder.open(Folder.READ_WRITE);
            int messageCount = inbox.getMessageCount();
            if (messageCount <= 0) {
                System.out.println("没有可接受的邮件 ");
            }
            MimeMessageParser parser = null;
            MimeMessage msg = null;
            String contentStr = null;
            String uid = "";
            // 得到收件箱中的所有邮件,并解析
            for (int i = messageCount; i > 0; i--) {
                //判断是否open
                if (!inbox.isOpen()) {
                    inbox.open(Folder.READ_ONLY);
                }
                msg = (MimeMessage) inbox.getMessage(i);
                uid = inbox.getUID(msg);
                parser = new MimeMessageParser(msg).parse();
                //邮件内容中的图片处理
                List<DataSource> attachments = parser.getAttachmentList();
                //文件预览中无法显示不能包含/ 和-
                Set<String> cids = (Set<String>) parser.getContentIds();
                Iterator<String> it = cids.iterator();
                while (it.hasNext()) {
                    String cid = it.next();
                    // contentStr判断是否含有cid,如果含有需要处理，如果不包含，不需要处理
                    if (contentStr.contains(cid)) {
                        DataSource ds = parser.findAttachmentByCid(cid);
                        if (ds != null) {
                            // to do 将邮件内容中的图片上传到文件存储服务器
                            // 得到  上传到文件存储服务器后的地址
                            String replaceStr = "101.37.175.62";
                            attachments.remove(ds);
                            contentStr = contentStr.replace("cid:" + cid, replaceStr);
                        }
                    }
                }
                for (int j = 0; j < attachments.size(); j++) {
                    DataSource ds = attachments.get(i);
                    byte[] bytesfile = IOUtils.toByteArray(ds.getInputStream());
                    String fileName = decodeText(ds.getName());
                    //to do 保存附件信息到数据库中
                    //to do 将附件上传到文件存储服务器上
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (folder != null && folder.isOpen()) {
                folder.close(true);
            }
            if (store != null) {
                store.close();
            }
        }
    }

    public static String decodeText(String encodeText) throws UnsupportedEncodingException {
        if (encodeText == null || "".equals(encodeText)) {
            return "";
        } else {
            return MimeUtility.decodeText(encodeText);
        }
    }
}
