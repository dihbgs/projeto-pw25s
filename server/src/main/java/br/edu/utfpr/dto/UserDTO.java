package br.edu.utfpr.dto;

import br.edu.utfpr.pb.pw25s.server.annotation.UniqueUsername;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @UniqueUsername
    @NotNull(message = "{br.edu.utfpr.pb.pw25s.model.User.name.NotNull.message}")
    @Size(min = 4, max = 64, message = "{br.edu.utfpr.pb.pw25s.model.User.Size.message}")
    private String name;

    @NotNull
    @Size(min = 4, max = 64)
    private String displayName;

    @NotNull
    @Size(min = 4)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{br.edu.utfpr.pb.pw25s.server.model.User.Password.Pattern.message}")
    private String password;
}
