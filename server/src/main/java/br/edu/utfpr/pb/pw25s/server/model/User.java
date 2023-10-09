package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import br.edu.utfpr.pb.pw25s.server.annotation.UniqueName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
public class User extends GenericModel {
    @NotNull
    @Size(min = 4, max = 64, message = "{br.edu.utfpr.pb.pw25s.server.model.name.Size.message}")
    private String name;

    @UniqueName
    @Size(min = 4, max = 64)
    @NotNull(message = "{br.edu.utfpr.pb.pw25s.server.model.name.NotNull.message}")
    private String displayName;

    @NotNull
    @Size(min = 4, max = 64)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{br.edu.utfpr.pb.pw25s.server.model.User.Password.Pattern.message}")
    private String password;
}
