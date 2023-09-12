package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Table;
import lombok.ToString;

@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@ToString
public class User extends GenericModel {
    @NotNull
    @Size(min = 4, max = 64)
    private String username;

    @NotNull
    @Size(min = 4, max = 64)
    private String displayName;

    @NotNull
    @Size
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
}
