package br.senai.controller;

import br.senai.model.ControleRenda;
import br.senai.model.Funcionario;
import br.senai.service.ControleRendaService;
import br.senai.service.FuncionarioService;
import br.senai.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("controleRenda")
@Controller
public class ControleRendaController {
    @Autowired
    ControleRendaService controleRendaService;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("list")
    public String findAll(Model model){
        model.addAttribute("controlesRendas", controleRendaService.findAll());
        return "controleRenda/list";
    }

    @GetMapping("add")
    public String add(Model model){
        model.addAttribute("controleRenda", new ControleRenda());
        model.addAttribute("produtos", produtoService.findAll());
        return "controleRenda/add";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable long id){
        model.addAttribute("controleRenda", controleRendaService.findById(id));
        model.addAttribute("produtos", produtoService.findAll());
        return "controleRenda/edit";
    }

    @PostMapping("save")
    public String save(ControleRenda controleRenda, Model model){
        try{
            controleRendaService.save(controleRenda);
            model.addAttribute("controleRenda", controleRenda);
            model.addAttribute("produtos", produtoService.findAll());
            model.addAttribute("isSaved",true);
            return "controleRenda/add";
        } catch (Exception e){
            model.addAttribute("controleRenda", controleRenda);
            model.addAttribute("produtos", produtoService.findAll());
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());
            return "controleRenda/add";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable long id){
        try{
            controleRendaService.deleteById(id);
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/controleRenda/list";
    }

}
