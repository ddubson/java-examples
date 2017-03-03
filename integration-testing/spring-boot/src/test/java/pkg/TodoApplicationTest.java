package pkg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TodoApplication.class)
public class TodoApplicationTest {
    @Autowired
    TodoService todoService;

    @Test
    public void todoServiceShouldReturnEmptyListWhenThereAreNoTodos() {
        List<Todo> todos = todoService.getAllTodos();
        assertThat(todos.size(), equalTo(0));
    }
}