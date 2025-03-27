package controller;

import java.util.ArrayList;
import model.Agendamento;
import model.Conta;
import model.Item;
import modelDAO.AgendaDAO;
import modelDAO.ContaDAO;

public class GerenciaContas {

    ContaDAO cdao;

    public GerenciaContas() {
        cdao = new ContaDAO();
    }

    public void adicionarConta(Conta conta, String op) {
        cdao.incluir(conta, op);
    }

    public ArrayList<Conta> retornarContasporNome(String nome) {
        ArrayList<Conta> contas;
        contas = cdao.retornaContasPorNome(nome);
        return contas;
    }

    public ArrayList<Conta> retornarContasporData(String data) {
        ArrayList<Conta> contas;
        contas = cdao.retornaContasPorData(data);
        return contas;
    }
    
    public ArrayList<Conta> retornarContasParceladasPorNome(String nome) {
        ArrayList<Conta> contas;
        contas = cdao.retornaContasParceladasPorNome(nome);
        return contas;
    }
    
    public void pagarConta(int idParcela, float valorASerPago){
        cdao.pagarConta(idParcela, valorASerPago);
    }

    public void excluirConta(int id) {
        cdao.excluirConta(id);
    }

    public ArrayList<Item> retornaItensDaConta(int id) {
        ArrayList<Item> itens;
        itens = cdao.retornaItensDaConta(id);
        return itens;
    }

    public void MudaStatusAgendamentoParaPago(ArrayList<Integer> c, int id) {
        cdao.mudarStatusAgendamentoPago(c, id);
    }
    
    public ArrayList<Agendamento> retornaidServicosPorCliente(int idCliente){
        AgendaDAO agDao = new AgendaDAO();
        ArrayList<Agendamento> servicos = agDao.pesquisarPorIdClienteParaConta(idCliente);
        return servicos;
    }
    
    

}
