package dev.codeIO.HelloWorld;

import dev.codeIO.HelloWorld.models.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

//CRUD - create read update delete
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
