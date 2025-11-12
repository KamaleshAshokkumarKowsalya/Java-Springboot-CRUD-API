package dev.codeIO.HelloWorld.controller;

import dev.codeIO.HelloWorld.service.TodoService;
import dev.codeIO.HelloWorld.models.Todo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@Slf4j
public class HelloWorldController {

    @ApiResponses (value= {
            @ApiResponse(responseCode = "200", description = "Todo Status Success"),
            @ApiResponse(responseCode = "404", description = "Todo Status Error")

    })

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getTodosPaged(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(todoService.getAllTodos(page,size),HttpStatus.OK);
    }


    @Autowired
    private TodoService todoService;
    @PostMapping("/create")
    ResponseEntity<Todo> getTodo(@RequestBody Todo todo){
         return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    ResponseEntity<Todo> hello(@PathVariable long id){ //input variable pathvariable
        try{
            return new ResponseEntity<>(todoService.getTodoById(id),HttpStatus.OK);
        } catch (Exception e) {
            log.info("ERROR");
            log.warn("");
            log.error("",e);
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
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
