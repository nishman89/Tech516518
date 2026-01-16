package com.sparta.todo.controllers;

import com.sparta.todo.models.Todo;
import com.sparta.todo.repositories.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos") // Specifies all endpoints for this controller start with /todos
public class TodoController {

    private final TodoRepository todoRepository;

    // Constructor injection for the repository
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("") // Maps to /todos
    public String listTodos(Model model) {
        // Fetch all to-do items from the database and add them to the model with the attribute name "todos" for use in the Thymeleaf template
        model.addAttribute("todos", todoRepository.findAll());
        return "todos/index"; // Refers to templates/todos/index.html
    }

    @GetMapping("/{id}") // Maps to /todos/{id}
    public String viewTodo(@PathVariable int id, Model model) {
        // Fetch the Todo by its ID
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo ID: " + id));

        // Add the Todo to the model
        model.addAttribute("todo", todo);

        // Return the view page
        return "todos/view"; // Refers to templates/todos/view.html
    }

    @PostMapping("/{id}/update")
    public String updateTodo(@PathVariable int id, @ModelAttribute Todo updatedTodo) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo ID: " + id));
        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setDescription(updatedTodo.getDescription());
        existingTodo.setComplete(updatedTodo.isComplete());
        todoRepository.save(existingTodo);
        return "redirect:/todos"; // Redirects to the /todos page
    }

    @PostMapping("/{id}/delete")
    public String deleteTodo(@PathVariable int id) {
        todoRepository.deleteById(id);
        return "redirect:/todos"; // Redirects to the /todos page after deletion
    }

    @GetMapping("/new")
    public String newTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "/todos/new";
    }


    @PostMapping("/save")
    public String saveTodo(@ModelAttribute Todo newTodo) {
        todoRepository.save(newTodo);
        return "redirect:/todos";
    }
}