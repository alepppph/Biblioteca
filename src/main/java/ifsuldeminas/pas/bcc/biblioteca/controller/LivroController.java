package com.biblioteca.demo.controller;

import com.biblioteca.demo.model.entities.Livro;
import com.biblioteca.demo.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", service.listarTodos());
        return "livro-lista";
    }

    @GetMapping("/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livro-form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Livro livro, BindingResult errors) {

        if (errors.hasErrors()) {
            return "livro-form";
        }

        service.salvar(livro);
        return "redirect:/livros";
    }
}
