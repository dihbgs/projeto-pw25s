package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
