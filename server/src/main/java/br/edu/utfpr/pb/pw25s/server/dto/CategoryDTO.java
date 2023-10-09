package br.edu.utfpr.pb.pw25s.server.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;

    @Size(min = 2, max = 32)
    @NotNull(message = "{br.edu.utfpr.pb.pw25s.server.model.name.NotNull.message}")
    private String name;
}
