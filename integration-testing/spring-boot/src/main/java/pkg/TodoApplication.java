package pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by pivotal on 3/3/17.
 */
@SpringBootApplication
@Configuration
@RestController
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

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostConstruct
    public void init() {
        todoService.saveTodo(new Todo("Example 1"));
        todoService.saveTodo(new Todo("Example 2"));
    }
}
