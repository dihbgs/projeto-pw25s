package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
