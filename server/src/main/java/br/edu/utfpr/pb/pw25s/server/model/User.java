package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import br.edu.utfpr.pb.pw25s.server.annotation.UniqueUsername;
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

    @UniqueUsername
    @Size(min = 4, max = 64)
    @NotNull(message = "{br.edu.utfpr.pb.pw25s.server.model.User.NotNull.message}")
    private String displayName;

    @Getter
    @Setter
    @NotNull
    @Size(min=4, max = 64)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{br.edu.utfpr.pb.pw25s.server.model.User.Password.Pattern.message}")
    private String password;
}
