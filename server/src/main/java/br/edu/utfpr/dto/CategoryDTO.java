package br.edu.utfpr.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;

    @NotNull
    @Size(min = 2, max = 32)
    private String name;
}
