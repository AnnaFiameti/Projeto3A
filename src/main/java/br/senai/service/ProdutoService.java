package br.senai.service;


import br.senai.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll();
    Produto findById(Long id);
    Produto save(Produto produto);
    void deleteById(Long id);


}
