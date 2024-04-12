package com.dawcl1.wilmerocampo.controllers;

import com.dawcl1.wilmerocampo.models.NumeroNatural;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NumeroNaturalController {
    @GetMapping("/numero-natural")
    public String numeroNatural(Model model) {
        model.addAttribute("numeroNatural", new NumeroNatural());
        model.addAttribute("mmsg", false);
        return "numero-natural";
    }

    @PostMapping("/verificar")
    public String verificarNumero(@ModelAttribute NumeroNatural numeroNatural, Model model) {
        int numero = numeroNatural.getNumero();
        boolean esPerfecto = esNumeroPerfecto(numero);
        numeroNatural.setEsPerfecto(esPerfecto);

        model.addAttribute("mmsg", true);
        model.addAttribute("resultado", esPerfecto ? "Es perfecto" : "No es perfecto");

        return "numero-natural";
    }

    private boolean esNumeroPerfecto(int numero) {
        int suma = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma == numero;
    }
}
