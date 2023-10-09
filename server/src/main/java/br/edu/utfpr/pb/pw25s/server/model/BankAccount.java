package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "bank_accounts")
@EqualsAndHashCode(callSuper = false)
public class BankAccount extends GenericModel {
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
