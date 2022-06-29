package br.senai.service;

import br.senai.model.ControleRenda;
import br.senai.model.Funcionario;
import br.senai.repository.ControleRendaRepository;
import br.senai.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControleRendaServiceImpl implements ControleRendaService{

    @Autowired
    ControleRendaRepository controleRendaRepository;

    @Override
    public List<ControleRenda> findAll() {
        return controleRendaRepository.findAll();
    }

    @Override
    public ControleRenda findById(Long id){
        ControleRenda func = controleRendaRepository.findById(id).get();
        return func != null ? func : new ControleRenda();
    }

    @Override
    public ControleRenda save(ControleRenda controleRenda){
        try{
            return controleRendaRepository.save(controleRenda);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteById(Long id){
        try{
            controleRendaRepository.deleteById(id);
        } catch(Exception e){
            throw  e;
        }
    }
}
