
package model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Conta {
   private ArrayList<Item> itens;
   private ArrayList<Parcela> parcelas;
   private Parcela parcela;
   private Cliente cliente; 
   private LocalDate data;
   private float total;
   private int id;

    public Conta(ArrayList<Item> itens, Cliente cliente, LocalDate data, float total) {
        this.itens = itens;
        this.cliente = cliente;
        this.data = data;
        this.total = total;
    }
    
    
    public Conta(){
    
    }

    public ArrayList<Item> getItens() {
        return itens;
    }
    
    public ArrayList<Parcela> getParcelas() {
        return parcelas;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    
    public void setParcelas(ArrayList<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    
   
    
   
   
   
}
