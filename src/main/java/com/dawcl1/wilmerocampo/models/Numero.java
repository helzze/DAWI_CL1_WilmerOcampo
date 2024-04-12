package com.dawcl1.wilmerocampo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Numero {
    private int numero;
    private int unidades;
    private  int decenas;

    public int sumarDigitos(){
        int sum = 0;
        int numero_temporal = numero;
        while (numero_temporal != 0){
            sum += numero_temporal % 10;
            numero_temporal /= 10;
        }
        return sum;
    }
}
