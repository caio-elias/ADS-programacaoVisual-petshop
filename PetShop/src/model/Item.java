
package model;

public class Item {
    private int id;
    private String descricao;
    private float preco;
    private int qtdItConta;
    private int auxFaturamento;

    public void setAuxFaturamento(int auxFaturamento) {
        this.auxFaturamento = auxFaturamento;
    }

    public int getAuxFaturamento() {
        return auxFaturamento;
    }
    

    public Item() {
    }

    public Item(int id, String descricao, float preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public float getPreco() {
        return preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtdItConta() {
        return qtdItConta;
    }

    public void setQtdItConta(int qtdItConta) {
        this.qtdItConta = qtdItConta;
    }
    
    
    
    
}
