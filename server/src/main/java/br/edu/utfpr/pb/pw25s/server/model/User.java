package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_users")
public class User extends GenericModel {

    @NotNull
    @Size(min = 4, max = 64)
    private String username;

    @NotNull
    @Size(min = 4, max = 64)
    private String displayName;

    @Size
    @Getter
    @Setter
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
}
