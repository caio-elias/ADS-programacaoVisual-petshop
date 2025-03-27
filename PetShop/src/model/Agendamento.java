
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agendamento implements Comparable<Agendamento>{
    private int idAgendamento;
    private Cliente cli;
    private Animal animal;
    private ArrayList<Profissional> profissonais;
    private Servico servico;
    private LocalDateTime dataRealizacao;
    private LocalDateTime dataGendamento;
    private String statusPagamento, StatusServico;

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public String getStatusServico() {
        return StatusServico;
    }

    public void setStatusServico(String StatusServico) {
        this.StatusServico = StatusServico;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
    

    public LocalDateTime getDataGendamento() {
        return dataGendamento;
    }

  

    public LocalDateTime getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataGendamento(LocalDateTime dataGendamento) {
        this.dataGendamento = dataGendamento;
    }

    public void setDataRealizacao(LocalDateTime dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
    
    
    public Agendamento() {
    }

    public Agendamento(int idAgendamento, Cliente cli, Animal animal, ArrayList<Profissional> profissonais, Servico servico) {
        this.idAgendamento = idAgendamento;
        this.cli = cli;
        this.animal = animal;
        this.profissonais = profissonais;
        this.servico = servico;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }


    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }


    public Cliente getCli() {
        return cli;
    }


    public void setCli(Cliente cli) {
        this.cli = cli;
    }

 
    public Animal getAnimal() {
        return animal;
    }

 
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


    public ArrayList<Profissional> getProfissonais() {
        return profissonais;
    }

 
    public void setProfissonais(ArrayList<Profissional> profissonais) {
        this.profissonais = profissonais;
    }

 
    public Servico getServico() {
        return servico;
    }


    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public int compareTo(Agendamento o) {
        if(this.dataRealizacao.isAfter(o.getDataRealizacao())){
            return 1;
        }else if(this.dataRealizacao.isBefore(o.getDataRealizacao())){
            return -1;
        }else{
            return 0;
        }
        
    }
    
    
    
    
}
