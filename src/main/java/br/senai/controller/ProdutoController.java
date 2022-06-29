package br.senai.controller;

import br.senai.model.ControleRenda;
import br.senai.model.Produto;
import br.senai.service.ControleRendaService;
import br.senai.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("produto")
@Controller
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("list")
    public String findAll(Model model){
        model.addAttribute("produtos", produtoService.findAll());
        return "produto/list";
    }

    @GetMapping("add")
    public String add(Model model){
        model.addAttribute("produto", new Produto());
        return "produto/add";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable long id){
        model.addAttribute("produto", produtoService.findById(id));
        return "produto/edit";
    }

    @PostMapping("save")
    public String save(Produto produto, Model model){
        try{
            produtoService.save(produto);
            model.addAttribute("produto", produto);
            model.addAttribute("isSaved",true);
            return "produto/add";
        } catch (Exception e){
            model.addAttribute("produto", produto);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());
            return "produto/add";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable long id){
        try{
            produtoService.deleteById(id);
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/produto/list";
    }

}
