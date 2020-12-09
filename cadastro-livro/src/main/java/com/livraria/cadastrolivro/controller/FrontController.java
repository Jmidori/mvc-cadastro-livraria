package com.livraria.cadastrolivro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/cadastro")
public class FrontController {

    @RequestMapping("/livro")
    public ModelAndView getMainView() {
        return new ModelAndView("main");
    }

    @RequestMapping("/novo-livro")
    public ModelAndView getRegisterView() {
        return new ModelAndView("novo");
    }

    @RequestMapping("/alterar-livro")
    public ModelAndView getUpdateView(@RequestParam(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("alterar");
        modelAndView.addObject("bookId", id);
        return modelAndView;
    }
}
