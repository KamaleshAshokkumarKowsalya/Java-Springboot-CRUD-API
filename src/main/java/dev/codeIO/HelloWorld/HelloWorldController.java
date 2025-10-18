package dev.codeIO.HelloWorld;

import dev.codeIO.HelloWorld.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class HelloWorldController {
    @Autowired
    private TodoService todoService;
    @PostMapping("/create")
    ResponseEntity<Todo> getTodo(@RequestBody Todo todo){
         return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    ResponseEntity<Todo> hello(@PathVariable long id){ //input variable pathvariable
        return new ResponseEntity<>(todoService.getTodoById(id),HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<List<Todo>>(todoService.getTodos(), HttpStatus.OK);
    }
    @PutMapping
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo ){
        return new ResponseEntity<>(todoService.updateTodo(todo),HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable long id){
        todoService.deleteTodoById(id);

    }


   


}
