
package model;

import java.util.ArrayList;

public class Servico extends Item{
    private ArrayList<Profissional> proficionais;
    private String equipamentos;

    public Servico(ArrayList<Profissional> proficionais, String equipamentos, int id, String descricao, float preco) {
        super(id, descricao, preco);
        this.proficionais = proficionais;
        this.equipamentos = equipamentos;
    }

    public Servico() {
        super();
    }

    public void setProficionais(ArrayList<Profissional> proficionais) {
        this.proficionais = proficionais;
    }

    public ArrayList<Profissional> getProficionais() {
        return proficionais;
    }


    public String getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(String equipamentos) {
        this.equipamentos = equipamentos;
    }


    
    
    
    
}
