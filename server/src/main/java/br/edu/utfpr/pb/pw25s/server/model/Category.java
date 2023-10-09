package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
@EqualsAndHashCode(callSuper = false)
public class Category extends GenericModel {
    @Size(min = 2, max = 32)
    @EqualsAndHashCode.Exclude
    @NotNull(message = "{br.edu.utfpr.pb.pw25s.server.model.name.NotNull.message}")
    @Column(length = 32, nullable = false)
    private String name;
}
