package br.senai.repository;

import br.senai.model.ControleRenda;
import br.senai.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControleRendaRepository extends JpaRepository<ControleRenda, Long> {

}
