
package model;

import java.util.ArrayList;


public class Cliente {
     private int id;
     private String nome;
     private String logradouro;
     private int numero;
     private String complemento;
     private String bairro ;
     private String municipio;
     private String estado;
     private String telefone;
  
     private ArrayList<Animal> animal;

    public Cliente(int id, String nome, String logradouro, int numero, String complemento, String bairro, String municipio, String estado, String telefone, ArrayList<Animal> animal) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.telefone = telefone;
        this.animal = animal;
    }

 

    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(ArrayList<Animal> animal) {
        this.animal = animal;
    }
     
}
