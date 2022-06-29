package br.senai.service;

import br.senai.model.ControleRenda;
import br.senai.model.Funcionario;

import java.util.List;

public interface ControleRendaService {

    List<ControleRenda> findAll();
    ControleRenda findById(Long id);
    ControleRenda save(ControleRenda controleRenda);
    void deleteById(Long id);


}
