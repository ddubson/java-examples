package ftp;

import org.apache.camel.main.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ddubs on 12/2/2016.
 */
@Configuration
public class CamelConfig {
    @Bean
    public Main camelMain() {
        return new Main();
    }
}
