package br.edu.utfpr.pb.pw25s.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.pw25s.server.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}
