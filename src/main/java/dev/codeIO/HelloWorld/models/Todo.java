package dev.codeIO.HelloWorld.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    Long id;
    @NotNull
    @NotBlank
    @Schema(name = "title",example = "Spring-boot Tutorial")
    String title;
    String Date;
}
