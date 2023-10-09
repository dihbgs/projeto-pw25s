package br.edu.utfpr.pb.pw25s.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.pw25s.server.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByName(String name);
}