package pkg;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();

    void saveTodo(Todo todo);
}
