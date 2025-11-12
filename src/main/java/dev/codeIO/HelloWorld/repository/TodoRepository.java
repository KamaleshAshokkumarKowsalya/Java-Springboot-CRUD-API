package dev.codeIO.HelloWorld.repository;

import dev.codeIO.HelloWorld.models.Todo;
import dev.codeIO.HelloWorld.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//CRUD - create read update delete
public interface TodoRepository extends JpaRepository<Todo, Long> {


}
