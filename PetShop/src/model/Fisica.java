
package model;

import java.util.ArrayList;


public class Fisica extends Cliente{
    private String cpf;

    public Fisica(String cpf, int id, String nome, String logradouro, int numero, String complemento, String bairro, String municipio, String estado, String telefone, ArrayList<Animal> animal) {
        super(id, nome, logradouro, numero, complemento, bairro, municipio, estado, telefone, animal);
        this.cpf = cpf;
    }

   
 

    public Fisica() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cnpj) {
        this.cpf = cnpj;
    }
    
}
