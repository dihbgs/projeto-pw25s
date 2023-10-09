package br.edu.utfpr.pb.pw25s.server.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.pw25s.server.model.BankAccount;
import br.edu.utfpr.pb.pw25s.server.repository.BankAccountRepository;

@Service
public class BankAccountService extends CrudService<BankAccount, Long> {
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    protected JpaRepository<BankAccount, Long> getRepository() {
        return this.bankAccountRepository;
    }
}
