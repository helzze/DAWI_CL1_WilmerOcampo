package com.dawcl1.wilmerocampo.controllers;

import com.dawcl1.wilmerocampo.models.Numero;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class NumeroController {
    @GetMapping("/numeroentero")
    public String mostrarFormulario(Model model) {
        model.addAttribute("numeroModel", new Numero());
        return "Numero/numeroentero";
    }



    @PostMapping("/numeroentero")
    public String descomponerNumero(Numero numeroModel, Model model) {
        int numero = numeroModel.getNumero();
        int unidades = numero % 10;
        int decenas = (numero / 10) % 10 + (numero / 100) * 10;
        numeroModel.setUnidades(unidades);
        numeroModel.setDecenas(decenas);
        model.addAttribute("numeroModel", numeroModel);
        return "Numero/numeroentero";
    }

}
