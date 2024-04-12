package com.dawcl1.wilmerocampo.controllers;

import com.dawcl1.wilmerocampo.models.Numero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NumeroController {
    @GetMapping("/numeroentero")
    public String mostrarFormulario(Model model) {
        model.addAttribute("numeroModel", new Numero());
        return "numeroentero";
    }

    @PostMapping("/numeroentero")
    public String descomponerNumero(Numero numeroModel, Model model) {
        int numero = numeroModel.getNumero();
        int unidades = numero % 10;
        int decenas = (numero / 10) % 10 + (numero / 100) * 10;
        numeroModel.setUnidades(unidades);
        numeroModel.setDecenas(decenas);
        model.addAttribute("numeroModel", numeroModel);
        return "numeroentero";
    }

    @GetMapping("/suma-numeros")
    public String showNumberForm() {
        return "sumanumeros";
    }

    @PostMapping("/suma-numeros")
    public String sumDigits(@RequestParam("numero") int numero, Model model) {
        Numero numero_sumar = new Numero();
        numero_sumar.setNumero(numero);
        int sum = numero_sumar.sumarDigitos();

        model.addAttribute("numero", numero);
        model.addAttribute("suma", sum);

        return "sumanumeros";
    }


}
