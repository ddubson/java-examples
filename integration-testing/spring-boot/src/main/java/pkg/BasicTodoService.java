package pkg;

import java.util.ArrayList;
import java.util.List;

public class BasicTodoService implements TodoService {
    private final List<Todo> todos;

    public BasicTodoService() {
        this.todos = new ArrayList<>();
    }

    @Override
    public List<Todo> getAllTodos() {
        return this.todos;
    }

    @Override
    public void saveTodo(Todo todo) {
        this.todos.add(todo);
    }
}
