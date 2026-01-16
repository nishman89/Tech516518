package com.sparta.todo;

import com.sparta.todo.models.Todo;
import com.sparta.todo.repositories.TodoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpartaTodoApplication {

    public static void main(String[] args) {

        // Start the Spring application and get the application context
        ApplicationContext context = SpringApplication.run(SpartaTodoApplication.class, args);

        // Get the CustomerService bean from the application context
        TodoRepository todoRepository = context.getBean(TodoRepository.class);
        List<Todo> todos = todoRepository.findAll();
        for(Todo todo : todos){
            System.out.println(todo);
        }


    }

}