package br.edu.fateczl.ingressos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ingresso {
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private static int contador;

    private String codigo;
    private static final float VALOR = 15.50f;

    public Ingresso(){
        contador++;
        this.codigo = String.valueOf(contador);
    }

    public float valorFinal(float taxa){
        BigDecimal fator = new BigDecimal(taxa);
        fator = fator.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).add(BigDecimal.ONE);
        float retorno = fator.multiply(BigDecimal.valueOf(getValor())).floatValue();
        return retorno;
    }

    public static float getValor() {
        return VALOR;
    }

    public String getCodigo() {
        return codigo;
    }
}
