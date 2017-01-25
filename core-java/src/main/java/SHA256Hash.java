import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author: ddubson
 */
public class SHA256Hash {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        printEncodingInHex("Manual", manualSHA256Encoding("Hello World!"));
        printEncodingInHex("Guava", guavaSHA256Encoding("Hello World!"));
        printEncodingInHex("Commons", commonsSHA256Encoding("Hello World!"));

    }

    public static String commonsSHA256Encoding(String str) {
        return DigestUtils.sha256Hex(str);
    }

    public static String guavaSHA256Encoding(String str) {
        return Hashing.sha256()
                .hashString(str, StandardCharsets.UTF_8)
                .toString();
    }

    public static String manualSHA256Encoding(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                str.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedhash);
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

    public static void printEncodingInHex(String encoder, String encodedString) {
        System.out.printf("[%s] SHA256: %s\n", encoder, encodedString);
    }
}
