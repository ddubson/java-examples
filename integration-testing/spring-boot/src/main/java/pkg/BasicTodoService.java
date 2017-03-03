package pkg;

import java.util.Collections;
import java.util.List;

/**
 * Created by pivotal on 3/3/17.
 */
public class BasicTodoService implements TodoService {
    @Override
    public List<Todo> getAllTodos() {
        return Collections.emptyList();
    }

    @Override
    public void saveTodo(Todo todo) {

    }
}
