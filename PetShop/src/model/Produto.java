
package model;

import java.time.LocalDate;

public class Produto extends Item{
    private String marca;
    private String modelo;
    private LocalDate validade;
    private String codProduto;

    public Produto(String marca, String modelo, LocalDate date, int id, String descricao, float preco,String codProduto) {
        super(id, descricao, preco);
        this.marca = marca;
        this.modelo = modelo;
        this.validade = date;
        this.codProduto = codProduto;
    }

    public Produto() {
        super();
    }

    public Produto(String marca, String modelo, LocalDate date, String codProduto) {
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.validade = date;
        this.codProduto = codProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate date) {
        this.validade = date;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }
    
    
    
    
    
}
