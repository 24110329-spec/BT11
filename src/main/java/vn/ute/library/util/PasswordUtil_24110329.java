package vn.ute.library.util;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
public final class PasswordUtil_24110329 {
    private PasswordUtil_24110329(){}
    public static String sha256(String value){
        try{
            byte[] b=MessageDigest.getInstance("SHA-256").digest(value.getBytes(StandardCharsets.UTF_8));
            StringBuilder s=new StringBuilder();
            for(byte x:b)s.append(String.format("%02x",x));
            return s.toString();
        }catch(Exception e){throw new IllegalStateException(e);}
    }
}
