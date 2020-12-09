package com.livraria.cadastrolivro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/cadastro")
public class FrontController {

    @RequestMapping("/livro")
    public ModelAndView getMainView() {
        return new ModelAndView("main");
    }
}
