package vn.ute.library.util;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
public final class EmailUtil_24110329 {
    private EmailUtil_24110329(){}
    public static void sendOtp(String to,String otp){
        String host=System.getenv().getOrDefault("MAIL_HOST","");
        String user=System.getenv().getOrDefault("MAIL_USERNAME","");
        String pass=System.getenv().getOrDefault("MAIL_PASSWORD","");
        String from=System.getenv().getOrDefault("MAIL_FROM",user);
        if(host.isBlank() || user.isBlank() || pass.isBlank()){
            System.out.println("[OTP TEST] "+to+" => "+otp);
            return;
        }
        String port=System.getenv().getOrDefault("MAIL_PORT","587");
        Properties p=new Properties();
        p.put("mail.smtp.host",host); p.put("mail.smtp.port",port);
        p.put("mail.smtp.auth","true"); p.put("mail.smtp.starttls.enable","true");
        Session s=Session.getInstance(p,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){return new PasswordAuthentication(user,pass);}
        });
        try{
            Message m=new MimeMessage(s);
            m.setFrom(new InternetAddress(from)); m.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            m.setSubject("OTP đăng ký tài khoản - Library");
            m.setText("Mã OTP của bạn là: "+otp+"\nMã có hiệu lực trong 5 phút.");
            Transport.send(m);
        }catch(MessagingException e){ throw new IllegalStateException("Không gửi được OTP: "+e.getMessage(),e); }
    }
}
