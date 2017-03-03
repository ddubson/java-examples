package pkg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pkg.Todo;
import pkg.TodoService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final TodoService todoService;

    @Autowired
    public RestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
}
