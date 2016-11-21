package example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: ddubson
 */
@Configuration
public class AppConfig {
    @Value("${hello.greeting}")
    private String greeting;

    @Bean
    //@RefreshScope
    public String greeting() {
        return greeting;
    }
}
