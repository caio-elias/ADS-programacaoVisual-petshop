
package model;

import java.util.ArrayList;


public class Juridica extends Cliente{
    private String cnpj;

    public Juridica(String cnpj, int id, String nome, String logradouro, int numero, String complemento, String bairro, String municipio, String estado, String telefone, ArrayList<Animal> animal) {
        super(id, nome, logradouro, numero, complemento, bairro, municipio, estado, telefone, animal);
        this.cnpj = cnpj;
    }

    public Juridica() {
       
    }

    

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
