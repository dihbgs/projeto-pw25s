package br.edu.utfpr.pb.pw25s.server.dto;

import br.edu.utfpr.pb.pw25s.server.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BankAccountDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private User user;

    private int number;

    private int agency;

    private int bank;

    @NotNull(message = "{br.edu.utfpr.pb.pw25s.server.model.BankAccount.Type.NotNull.message}")
    private int type;
}
