package br.senai.service;

import br.senai.model.ControleRenda;
import br.senai.model.Produto;
import br.senai.repository.ControleRendaRepository;
import br.senai.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Long id){
        Produto func = produtoRepository.findById(id).get();
        return func != null ? func : new Produto();
    }

    @Override
    public Produto save(Produto produto){
        try{
            return produtoRepository.save(produto);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteById(Long id){
        try{
            produtoRepository.deleteById(id);
        } catch(Exception e){
            throw  e;
        }
    }
}
