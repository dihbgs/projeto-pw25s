package br.edu.utfpr.pb.pw25s.server.dto;

import br.edu.utfpr.pb.pw25s.server.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BankAccountDTO {
    private Long id;

    private User user;

    @Size(min = 2, max = 32)
    private String number;

    @Size(min = 2, max = 32)
    private String agency;

    @Size(min = 2, max = 32)
    private String bank;

    @NotNull(message = "{br.edu.utfpr.pb.pw25s.server.model.BankAccount.Type.NotNull.message}")
    private int type;
}
