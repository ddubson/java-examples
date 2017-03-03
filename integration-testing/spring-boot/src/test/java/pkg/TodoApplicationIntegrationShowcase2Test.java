package pkg;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Simplified Spring Boot Integration Test Scheme (since 1.4.x)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = TodoApplication.class,
        properties = "classpath:/application.yml"
)
public class TodoApplicationIntegrationShowcase2Test {
    @Autowired
    TodoService todoService;

    @Value("${example.test}")
    String value;

    @Test
    public void todoServiceShouldReturnEmptyListWhenThereAreNoTodos() {
        List<Todo> todos = todoService.getAllTodos();
        assertThat(todos.size(), equalTo(2));

        System.out.println(value);
    }

    @Test
    public void testRunnerShouldSuccessfullyLoadFromTestPropertiesYml() {
        assertThat(value, equalTo("this should load in test"));
    }
}