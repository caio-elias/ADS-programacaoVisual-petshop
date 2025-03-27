
package modelDAO;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Item;
import model.Produto;
import model.Profissional;
import model.Servico;


public class ItensDAO {
    private Connection conn = null;
    DateTimeFormatter fdata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public ItensDAO() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
    }
    
    public boolean codigoValido(String busca){
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "select codigo_produto from produto where codigo_produto = ?";
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, busca);
            rs = ps.executeQuery();
            if (rs.next()) {
               return false;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar produtos ativod: " + e.getMessage());
        }
        
        return true;
    }
    public Item retornaItem(int id){
        Item it = new Item();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from item WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
	    ps.setInt(1, id);
           rs = ps.executeQuery();
            if (rs.next()) {
                
                int status = rs.getInt("status");
                if ((status == 0)){
                    it.setId(rs.getInt("id"));
                    it.setDescricao(rs.getString("descricao"));
                    it.setPreco(rs.getFloat("preco"));
                }
               
            }
            rs.close();
            ps.close();
            return it;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
        }
         return null;
    }
    public Servico pesquisaServicoPorCodigo(int cod){
         PreparedStatement ps = null;
         Servico p = new Servico();
         ResultSet rs = null;
         String sql = "select * from servico, item where id = ? and id = servico_item and status = 0";
         try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getFloat("preco"));
                p.setEquipamentos(rs.getString("equipamentos"));
                p.setProficionais(listaProfissionaisServico(p.getId()));
                return p;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar produtos ativod: " + e.getMessage());
        }
        
        return null;
    }
    public ArrayList<Item> listarItensPorDescricao(String desc){
	ArrayList<Item> itens = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM item where descricao LIKE ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+desc+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
             
                int status = rs.getInt("status");
                if ((status == 0)){
                    
                        Item i = new Item();
                        i.setId(rs.getInt("id"));
                        i.setDescricao(rs.getString("descricao"));
                        i.setPreco(rs.getFloat("preco"));
                        itens.add(i);
                    
               
                    }

                }
            
            rs.close();
            ps.close();
            return itens;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar Itens excluídos: " + e.getMessage());
        }

        return null;
    }
    
    public ArrayList<Servico> pesquisaServicoDescricao(String busca){
         PreparedStatement ps = null;
         ArrayList<Servico> servicos = new ArrayList<>();
         ResultSet rs = null;
         String sql = "select * from servico, item where descricao like ? and id = servico_item and status = 0 ;";
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+busca+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Servico p = new Servico();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getFloat("preco"));
                p.setEquipamentos(rs.getString("equipamentos"));
                p.setProficionais(listaProfissionaisServico(p.getId()));
                
                servicos.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de pesquisar serviços: " + e.getMessage());
        }
        return servicos;
    }
//    
    public int proximoCodigo(){
		String sql;
                PreparedStatement ps = null;
		int proximoCodigo = -1;

		sql = "select max(id) from item";

		try{
			ps = conn.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();

			if(rs.next()){
				proximoCodigo = rs.getInt(1);
				proximoCodigo++;
			}
			ps.close();

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro na operação buscar código máximo: " + e.getMessage());
		}
		
		return proximoCodigo;
	}
    public boolean incluirItem(Item item) {
        String sql;
        PreparedStatement ps = null;
        boolean retorno = true;
        int tipo;
         if(item instanceof Produto){
            tipo=1;
        }
        else{
            tipo=2;
        }
        sql = "INSERT INTO item(descricao, preco, tipo, status) VALUES (?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getDescricao());
            ps.setFloat(2, item.getPreco());
            ps.setInt(3, tipo);
            ps.setInt(4, 0);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir Item: " + e.getMessage());

        }
        if(item instanceof Produto){
            Produto p = (Produto) item;
            p.setId(proximoCodigo() -1);
            retorno =incluirProduto(p);
        }
        else{
            Servico s = (Servico) item;
            s.setId(proximoCodigo() -1);
            retorno = incluirServico(s);
        }
        return retorno;
        
    }
    private boolean incluirProduto(Produto pdt){
        String sql;
        PreparedStatement ps = null; 
        sql = "INSERT INTO produto(validade,marca, modelo,codigo_produto, produto_item) VALUES (?, ?, ?, ?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, pdt.getValidade().format(fdata));
            ps.setString(2, pdt.getMarca());
            ps.setString(3, pdt.getModelo());
            ps.setString(4, pdt.getCodProduto());
            ps.setInt(5, pdt.getId());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
            return false;

        }
    }
    private boolean incluirProfissionalServico(Profissional p, int idServico){
         String sql;
         PreparedStatement ps = null; 
         ps = null; 
         sql = "INSERT INTO servico_profissional(id_profissional, id_servico) VALUES (?, ?)";
         try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setInt(2, idServico);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
            return false;

        }
    }
    private boolean incluirServico(Servico serv){
        String sql;
        PreparedStatement ps = null; 
        boolean retorno = true;
        sql = "INSERT INTO servico(equipamentos, servico_item) VALUES (?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, serv.getEquipamentos());
            ps.setInt(2, serv.getId());
            ps.execute();
            ps.close();
                for(Profissional p : serv.getProficionais()){
                    retorno = incluirProfissionalServico(p, serv.getId());
                }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
            return false;

        }
        return retorno;
        
    }
 
     public ArrayList<Servico> listarServicosAtivos() {
        ArrayList<Servico> prods = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM public.item, public.servico where item.id = servico.servico_item and item.status = 0";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servico p = new Servico();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getFloat("preco"));
                p.setEquipamentos(rs.getString("equipamentos"));
                p.setProficionais(listaProfissionaisServico(p.getId()));
                prods.add(p);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar servicos ativos: " + e.getMessage());
        }

        return prods;
    }
    public ArrayList<Produto> listarProdutosAtivos() {
        ArrayList<Produto> prods = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM public.item, public.produto where item.id = produto.produto_item and item.status = 0";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getFloat("preco"));
                p.setCodProduto(rs.getString("codigo_produto"));
                p.setMarca(rs.getString("marca"));
                p.setModelo(rs.getString("modelo"));
                p.setValidade(LocalDate.parse(rs.getString("validade"), formatter));
                prods.add(p);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar produtos ativod: " + e.getMessage());
        }

        return prods;
    }
    
    public ArrayList<Item> listarProdPorDescricao(String desc){
	ArrayList<Item> itens = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM item where descricao LIKE ? and tipo = 1";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+desc+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
             
                int status = rs.getInt("status");
                if ((status == 0)){
                    
                        Item i = new Item();
                        i.setId(rs.getInt("id"));
                        i.setDescricao(rs.getString("descricao"));
                        i.setPreco(rs.getFloat("preco"));
                        itens.add(i);
                    
               
                    }

                }
            
            rs.close();
            ps.close();
            return itens;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar Itens excluídos: " + e.getMessage());
        }

        return null;
    }
    public Item listarProdPorID(int id){
	Item i = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM item where id = ? and tipo = 1";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
             
                int status = rs.getInt("status");
                if ((status == 0)){
                        i= new Item();
                        
                        i.setId(rs.getInt("id"));
                        i.setDescricao(rs.getString("descricao"));
                        i.setPreco(rs.getFloat("preco"));
                        
                    
               
                    }

                }
            
            rs.close();
            ps.close();
            return i;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar Itens excluídos: " + e.getMessage());
        }

        return null;
    }
     public void alterarProduto(Produto p){
		String sql;
		PreparedStatement ps = null;
		
		sql = "update produto set validade = ?,marca = ?, modelo = ? where produto_item = ?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getValidade().format(fdata));
			ps.setString(2, p.getMarca());
			ps.setString(3, p.getModelo());
                        ps.setInt(4, p.getId());
			ps.execute();
			ps.close();
                        try{
                           sql = "update item set descricao = ?, preco = ? where id = ?";
                           ps = conn.prepareStatement(sql); 
                           ps.setString(1, p.getDescricao());
                           ps.setFloat(2, p.getPreco());
                           ps.setInt(3, p.getId());
                           ps.execute();
                            ps.close();
                        }catch(SQLException e){
                          JOptionPane.showMessageDialog(null, "Erro na operação de alterar produto: " + e.getMessage());
                        }
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro na operação de alterar produto: " + e.getMessage());
		}
    }
    public void alterarServico(Servico p) {
        String sql;
        PreparedStatement ps = null;
        boolean retorno;
        sql = "update servico set equipamentos = ? where servico_item = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getEquipamentos());
            ps.setInt(2, p.getId());
            ps.execute();
            ps.close();
            try {
                sql = "delete from servico_profissional where id_servico = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, p.getId());
                ps.execute();
                ps.close();
                for (Profissional s : p.getProficionais()) {
                    retorno = incluirProfissionalServico(s, p.getId());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na operação de alterar serviço: " + e.getMessage());
            }
            try {
                sql = "update item set descricao = ?, preco = ? where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, p.getDescricao());
                ps.setFloat(2, p.getPreco());
                ps.setInt(3, p.getId());
                ps.execute();
                ps.close();
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na operação de alterar serviço: " + e.getMessage());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de alterar serviço: " + e.getMessage());
        }
    }
     public void excluirItem(int id){
                String sql;
		PreparedStatement ps = null;
		
		sql = "update item set status = ? where id = ?";
		
		try{
			ps = conn.prepareStatement(sql);
                        ps.setInt(1, 1);
			ps.setInt(2, id);
			ps.execute();
			ps.close();
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro na operação de excluir produto: " + e.getMessage());
		}
     }
     
     public ArrayList<Profissional> listaProfissionais(){
        ArrayList<Profissional> prs = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from profissional";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissional pr = new Profissional();
                 pr.setEspecialidade(rs.getString("especialidade"));
                 pr.setId(rs.getInt("id"));
                 pr.setNome(rs.getString("nome"));
                 prs.add(pr);    
            }
            rs.close();
            ps.close();
            return prs;
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
        }
        
        return null;
     }
     private Profissional buscaProfissional(int id){
        Profissional pr = new Profissional();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from profissional WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
	    ps.setInt(1, id);
           rs = ps.executeQuery();
            if (rs.next()) {
                pr.setEspecialidade(rs.getString("especialidade"));
                pr.setId(rs.getInt("id"));
                pr.setNome(rs.getString("nome"));     
            }
            rs.close();
            ps.close();
            return pr;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
        }
         return null;
     }
     public ArrayList<Profissional> listaProfissionaisServico( int id){
        ArrayList<Profissional> prs = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
     

        String sql = "select * from servico_profissional WHERE id_servico = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id );
            rs = ps.executeQuery();
            while (rs.next()) {
                prs.add(buscaProfissional(rs.getInt("id_profissional")));    
            }
            rs.close();
            ps.close();
            return prs;
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
        }
        
        return null;
     }
     
}
    
