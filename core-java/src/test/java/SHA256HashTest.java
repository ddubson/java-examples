import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class SHA256HashTest {
    private final String precalculatedHelloWorldHash =
            "7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069";

    @Test
    public void sha256_usingGuavaLib() {
        SHA256Hash.Hasher guavaHasher = ((str) -> Hashing.sha256().hashString(str, StandardCharsets.UTF_8)
            .toString());

        String hash = SHA256Hash.hashIt("Hello World!", guavaHasher);
        assertThat(hash, equalTo(precalculatedHelloWorldHash));
    }

    @Test
    public void sha256_usingCommonsCodecLib() {
        SHA256Hash.Hasher commonsHasher = DigestUtils::sha256Hex;

        String hash = SHA256Hash.hashIt("Hello World!", commonsHasher);
        assertThat(hash, equalTo(precalculatedHelloWorldHash));
    }

    @Test
    public void sha256_usingManualMethod() {
        SHA256Hash.Hasher manualHasher = (str) -> {
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            assert digest != null;
            byte[] encodedhash = digest.digest(
                    str.getBytes(StandardCharsets.UTF_8));
            return SHA256Hash.bytesToHex(encodedhash);
        };

        String hash = SHA256Hash.hashIt("Hello World!", manualHasher);
        assertThat(hash, equalTo(precalculatedHelloWorldHash));
    }
}