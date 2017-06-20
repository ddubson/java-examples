public class SHA256Hash {

    @FunctionalInterface
    public interface Hasher {
        String hash(String str);
    }

    public static String hashIt(String str, Hasher hasher) {
        return hasher.hash(str);
    }

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
