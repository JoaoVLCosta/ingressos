package br.edu.fateczl.ingressos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IngressoVIP extends Ingresso{
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    String funcao;

    public IngressoVIP(){
        super();
    }

    @Override
    public float valorFinal(float taxa){
        return super.valorFinal(18 + taxa);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
