package pkg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * ContextConfiguration only loads Spring related entities, but not the entire Spring Boot collection of
 * entities that might be needed. Refer to TodoApplicationIntegrationShowcaseTest2 for an example of full Spring Boot test.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TodoApplication.class)
public class TodoApplicationIntegrationShowcase1Test {
    @Autowired
    TodoService todoService;

    @Test
    public void todoServiceShouldReturnTwoTodos() {
        List<Todo> todos = todoService.getAllTodos();
        assertThat(todos.size(), equalTo(2));
    }
}