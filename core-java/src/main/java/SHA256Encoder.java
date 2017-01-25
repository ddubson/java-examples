import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author: ddubson
 */
public class SHA256Encoder {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        manualSHA256Encoding("Hello World!");
        guavaSHA256Encoding("Hello World!");
        commonsSHA256Encoding("Hello World!");
    }

    public static void commonsSHA256Encoding(String str) {
        System.out.println("[Commons] Encoded SHA256 Hex: " + DigestUtils.sha256Hex(str));
    }

    public static void guavaSHA256Encoding(String str) {
        String sha256hex = Hashing.sha256()
                .hashString(str, StandardCharsets.UTF_8)
                .toString();
        System.out.println("[Guava] Encoded SHA256 Hex: " + sha256hex);
    }

    public static void manualSHA256Encoding(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                str.getBytes(StandardCharsets.UTF_8));

        System.out.println("[Manual] Encoded SHA256 Hex: "+ bytesToHex(encodedhash));
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
