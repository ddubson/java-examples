package pkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pivotal on 3/3/17.
 */
@SpringBootApplication
@Configuration
@RestController
public class TodoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Bean
    public TodoService todoService() {
        return new BasicTodoService();
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }
}
