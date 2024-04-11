package com.dawcl1.wilmerocampo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LlantaController {

    @GetMapping("/inicio")
    public String mostrarFormulario() {
        return "llanta-formulario";
    }

    @PostMapping("/calculartotal")
    public String calcularTotal(@RequestParam int cantidad, Model model) {
        double totalPagar;
        if (cantidad < 5) {
            totalPagar = 800 * cantidad;
        } else {
            totalPagar = 700 * cantidad;
        }
        model.addAttribute("totalPagar", totalPagar);
        model.addAttribute("cantidad", cantidad);
        return "resultado";
    }

}
