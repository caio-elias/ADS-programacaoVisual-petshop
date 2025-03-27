
package model;

public class Profissional {
    private int id;
    private String especialidade;
    private String nome;

    public Profissional() {
    }

    
    public Profissional(String especialidade, String nome) {
        this.especialidade = especialidade;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
