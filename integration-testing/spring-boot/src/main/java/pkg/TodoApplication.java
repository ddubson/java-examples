package pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pkg.controller.IndexController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
public class TodoApplication {
    @Autowired
    TodoService todoService;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Bean
    public TodoService todoService() {
        return new BasicTodoService();
    }

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }

    @PostConstruct
    public void init() {
        todoService.saveTodo(new Todo("Example 1"));
        todoService.saveTodo(new Todo("Example 2"));
    }
}
