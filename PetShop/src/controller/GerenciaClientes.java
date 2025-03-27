
package controller;

import java.util.ArrayList;
import model.Cliente;
import model.Fisica;
import model.Juridica;
import modelDAO.ClienteDAO;

public class GerenciaClientes {
    ClienteDAO clidao;

    public GerenciaClientes() {
        clidao = new ClienteDAO();
    }
    
    public ArrayList<Cliente> retornaClienteNome(String nome){
        ArrayList<Cliente> clientes = clidao.retornaClienteNome(nome);
        return clientes;
    }
    
    public Fisica retornaClienteCPF(String cpf){
        Fisica f;
        f = clidao.retornaClienteCPF(cpf);
        return f;
    }
    
    public Juridica retornaClienteCNPJ(String cnpj){
        Juridica j;
        j = clidao.retornaClienteCNPJ(cnpj);
        return j;
    }
    
     public Cliente retornaClienteID(int id){
        Cliente cli;
        cli = clidao.retornaClienteID(id);
        return cli;
    }
}
