
package controller;

import java.util.ArrayList;
import model.Item;
import model.Produto;
import model.Servico;
import modelDAO.ItensDAO;

public class GerenciaItens {
    ItensDAO itDao;

    public GerenciaItens() {
        itDao= new ItensDAO();
    }
    
   public void cadastrarProduto(Produto p){
       itDao.incluirItem(p);
    } 
   public void alterarProdutos(Produto p){
      itDao.alterarProduto(p);
   }
   
   public ArrayList<Produto> listarProdutos(){
      return itDao.listarProdutosAtivos();
   }
   public void excluirProduto(int id){
       itDao.excluirItem(id);
   }
   public boolean cadastrarServico(Servico  s){
       return itDao.incluirItem(s);
       
    } 
   public void alterarServico(Servico s){
     itDao.alterarServico(s);
   }
   
   public ArrayList<Servico> listarServicos(){
     
      return itDao.listarServicosAtivos();
   }
   public Item retornarITem(int id){
      Item item;
      item = itDao.retornaItem(id);
      return item;
   }
    public ArrayList<Item> retornarItensPorDesc(String desc){
      ArrayList<Item> itens;
      itens = itDao.listarItensPorDescricao(desc);
      return itens;
   }
    public Item retornaProdutosPoID(int id){
        return itDao.listarProdPorID(id);
    }
    public ArrayList<Item> retornaProdutosPorDesc(String desc){
        return itDao.listarProdPorDescricao(desc);
    }
   public void excluirServico(int id){
       itDao.excluirItem(id);
   }
   public int proximoCodigo(){
       return itDao.proximoCodigo();
   }
   public boolean codIsValido(String busca){
       return itDao.codigoValido(busca);
   }
   public Servico pesquisaServicoID(int busca){
       return itDao.pesquisaServicoPorCodigo(busca);
   }
   
   public ArrayList<Servico> pesquisarServicoDescricao(String busca){
       return itDao.pesquisaServicoDescricao(busca);
   }
   
   
        
}
