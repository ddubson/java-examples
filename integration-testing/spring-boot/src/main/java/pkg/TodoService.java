package pkg;

import java.util.List;

/**
 * Created by pivotal on 3/3/17.
 */
public interface TodoService {
    List<Todo> getAllTodos();

    void saveTodo(Todo todo);
}
