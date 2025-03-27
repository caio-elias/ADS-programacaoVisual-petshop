
package modelDAO;

import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.JOptionPane;
import model.Agendamento;
import model.Animal;
import model.Cliente;
import model.Profissional;
import model.Servico;

public class AgendaDAO {
    private Connection conn = null;
    ClienteDAO cliDao = new ClienteDAO();
    AnimalDAO aDao = new AnimalDAO();
    ItensDAO iDao = new ItensDAO();
    
    public AgendaDAO() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
    }
     public int proximoCodigo(){
		String sql;
                PreparedStatement ps = null;
		int proximoCodigo = -1;

		sql = "select max(idagendamento) from agendamento";

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
     
    public void incluirAgendamento(Agendamento ag){
        String sql;
        PreparedStatement ps = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        sql = "INSERT INTO agendamento(idanimal,idcliente,idservico,status, data_agendamento,data_realizacao,status_servico) VALUES (?, ?, ?, ?, ?, ?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ag.getAnimal().getId());
            ps.setInt(2, ag.getCli().getId());
            ps.setInt(3, ag.getServico().getId());
            ps.setString(4, "npago");
            ps.setString(5, ag.getDataGendamento().format(formatter));
            ps.setTimestamp(6, Timestamp.valueOf(ag.getDataRealizacao()));
            ps.setString(7, "Aberto");
            ps.execute();
            ps.close();
            ag.setIdAgendamento(proximoCodigo()-1);
            for(Profissional p : ag.getProfissonais()){
                   incluirProfissionalAgendamento(p, ag.getIdAgendamento());
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());

        }
    }
    public Agendamento buscarAgendamento( int idAg){
        
        ArrayList<Agendamento> ags = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int id;
       
        String sql = "Select * from agendamento where idagendamento = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idAg);
            rs = ps.executeQuery();
            if (rs.next()) {
                
                Agendamento p = new Agendamento();
                p.setProfissonais(new ArrayList<>());
                p.setIdAgendamento(rs.getInt("idagendamento"));
                id = rs.getInt("idanimal");
                p.setAnimal(aDao.buscarPorId(id));
                id = rs.getInt("idcliente");
                p.setCli(cliDao.retornaClienteID(id));
                p.setDataRealizacao(LocalDateTime.parse(rs.getString("data_realizacao"), formatter));
                p.setStatusPagamento(rs.getString("status"));
                p.setStatusServico(rs.getString("status_servico"));
                id = rs.getInt("idservico");
                p.setServico(iDao.pesquisaServicoPorCodigo(id));
                listarProfissionais(p);
                return p;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar agendamentos: " + e.getMessage());
        }
        
        return null;
    }
       
    public ArrayList<Agendamento> listaTodos(){
        
        ArrayList<Agendamento> ags = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int id;
       
        String sql = "Select * from agendamento ";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Agendamento p = new Agendamento();
                p.setProfissonais(new ArrayList<>());
                p.setIdAgendamento(rs.getInt("idagendamento"));
                id = rs.getInt("idanimal");
                p.setAnimal(aDao.buscarPorId(id));
                id = rs.getInt("idcliente");
                p.setCli(cliDao.retornaClienteID(id));
                p.setDataRealizacao(LocalDateTime.parse(rs.getString("data_realizacao"), formatter));
                p.setStatusPagamento(rs.getString("status"));
                p.setStatusServico(rs.getString("status_servico"));
                id = rs.getInt("idservico");
                p.setServico(iDao.pesquisaServicoPorCodigo(id));
                listarProfissionais(p);
                ags.add(p);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar agendamentos: " + e.getMessage());
        }
        
        return ags;
    }
    private void listarProfissionais(Agendamento ag){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from agenda_profissional, profissional where id_agendamento = ? and profissional.id = id_profissional";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ag.getIdAgendamento());
            rs = ps.executeQuery();
            
            while(rs.next()){
                Profissional p = new Profissional();
                p.setNome(rs.getString("nome"));
                p.setId(rs.getInt("id"));
                p.setEspecialidade(rs.getString("especialidade"));
                
                ag.getProfissonais().add(p);
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na operação de listar profissionais do servico: " + e.getMessage());
        }
    }
    private boolean incluirProfissionalAgendamento(Profissional p, int id){
         String sql;
         PreparedStatement ps = null; 
         ps = null; 
         sql = "INSERT INTO agenda_profissional(id_profissional, id_agendamento) VALUES (?, ?)";
         try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setInt(2, id);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
            return false;

        }
    }
    public boolean verificarDisponibilidade(LocalDateTime data, int id){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = "select data_realizacao from agenda_profissional, agendamento where id_profissional = ? and id_agendamento = idagendamento and status_servico = 'Aberto' ;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                LocalDateTime d = LocalDateTime.parse(rs.getString("data_realizacao"), formatter);
                if(d.equals(data)){
                    return false;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao verificar disponibilidade: " + e.getMessage());
        }
        return true;
    }
    
    
    public ArrayList<Agendamento> pesquisarPorNomeCliente(String pesquisa){
        ArrayList<Agendamento> ags = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = "Select cliente.nome as nome_cliente, animal.nome as nome_animal, item.descricao as descricao,agendamento.* "
                + "from cliente, animal, agendamento,item "
                + "where agendamento.idcliente = cliente.id and agendamento.idanimal = animal.id and item.id = agendamento.idservico "
                + "and cliente.nome like ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+pesquisa+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Agendamento p = new Agendamento();
                p.setAnimal(new Animal());
                p.setCli(new Cliente());
                p.setServico(new Servico());
                p.setIdAgendamento(rs.getInt("idagendamento"));
                p.getAnimal().setNome(rs.getString("nome_animal"));
                p.getCli().setNome(rs.getString("nome_cliente"));
                p.setDataRealizacao(LocalDateTime.parse(rs.getString("data_realizacao"), formatter));
                p.setStatusPagamento(rs.getString("status"));
                p.setStatusServico(rs.getString("status_servico"));
                p.getServico().setDescricao(rs.getString("descricao"));
                ags.add(p);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar agendamentos: " + e.getMessage());
        }
        return ags;
    }
    public ArrayList<Agendamento> pesquisarPorIdClienteParaConta(int pesquisa){
        ArrayList<Agendamento> ags = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = "Select cliente.nome as nome_cliente, animal.nome as nome_animal, item.id as idServico,agendamento.* "
                + "from cliente, animal, agendamento,item "
                + "where agendamento.idcliente = cliente.id and agendamento.idanimal = animal.id and item.id = agendamento.idservico "
                + "and cliente.id = ? and agendamento.status = 'npago' ;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pesquisa);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Agendamento p = new Agendamento();
                p.setAnimal(new Animal());
                p.setCli(new Cliente());
                p.setServico(new Servico());
                p.setIdAgendamento(rs.getInt("idagendamento"));
                p.getAnimal().setNome(rs.getString("nome_animal"));
                p.getCli().setNome(rs.getString("nome_cliente"));
                p.setDataRealizacao(LocalDateTime.parse(rs.getString("data_realizacao"), formatter));
                p.setStatusPagamento(rs.getString("status"));
                p.setStatusServico(rs.getString("status_servico"));
                int id = rs.getInt("idServico");
                p.setServico(iDao.pesquisaServicoPorCodigo(id));
                p.getServico().setAuxFaturamento(p.getIdAgendamento());
                ags.add(p);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar agendamentos para conta: " + e.getMessage());
        }
        return ags;
    }
    public ArrayList<Agendamento> pesquisarPorAnimal(String pesquisa){
        ArrayList<Agendamento> ags = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = "Select cliente.nome as nome_cliente, animal.nome as nome_animal, item.descricao as descricao,agendamento.* "
                + "from cliente, animal, agendamento,item "
                + "where agendamento.idcliente = cliente.id and agendamento.idanimal = animal.id and item.id = agendamento.idservico "
                + "and animal.nome like ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+pesquisa+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Agendamento p = new Agendamento();
                p.setAnimal(new Animal());
                p.setCli(new Cliente());
                p.setServico(new Servico());
                p.setIdAgendamento(rs.getInt("idagendamento"));
                p.getAnimal().setNome(rs.getString("nome_animal"));
                p.getCli().setNome(rs.getString("nome_cliente"));
                p.setDataRealizacao(LocalDateTime.parse(rs.getString("data_realizacao"), formatter));
                p.setStatusPagamento(rs.getString("status"));
                p.setStatusServico(rs.getString("status_servico"));
                p.getServico().setDescricao(rs.getString("descricao"));
                ags.add(p);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar agendamentos: " + e.getMessage());
        }
        return ags;
    }
     public ArrayList<Agendamento> pesquisarPorServico(String pesquisa){
        ArrayList<Agendamento> ags = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = "Select cliente.nome as nome_cliente, animal.nome as nome_animal, item.descricao as descricao,agendamento.* "
                + "from cliente, animal, agendamento,item "
                + "where agendamento.idcliente = cliente.id and agendamento.idanimal = animal.id and item.id = agendamento.idservico "
                + "and item.descricao like ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+pesquisa+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Agendamento p = new Agendamento(); // TODO add your handling code here:
                p.setAnimal(new Animal());
                p.setCli(new Cliente()); // TODO add your handling code here:
                p.setServico(new Servico());
                p.setIdAgendamento(rs.getInt("idagendamento"));
                p.getAnimal().setNome(rs.getString("nome_animal"));
                p.getCli().setNome(rs.getString("nome_cliente"));
                p.setDataRealizacao(LocalDateTime.parse(rs.getString("data_realizacao"), formatter));
                p.setStatusPagamento(rs.getString("status"));
                p.setStatusServico(rs.getString("status_servico"));
                p.getServico().setDescricao(rs.getString("descricao"));
                ags.add(p);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar agendamentos: " + e.getMessage());
        }
        return ags;
    }
     public ArrayList<Agendamento> pesquisarPorProfissional(int pesquisa){
        ArrayList<Agendamento> ags = new ArrayList<>();
        
        String sql = "select * from agenda_profissional where id_profissional = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pesquisa);
            rs = ps.executeQuery();
            while (rs.next()) {
                int busca = rs.getInt("id_agendamento");
                ags.add(buscarAgendamento(busca));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar agendamentos: " + e.getMessage());
        }
        return ags;
    }
     
     public boolean alterarStatusServico(int id){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String data = LocalDateTime.now().format(formatter);
      
        LocalDateTime dataRealizado = LocalDateTime.parse(data, formatter);
        String sql;
        PreparedStatement ps = null;

        sql = "update agendamento set status_servico = 'realizado', data_realizado = ? where idagendamento = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(dataRealizado));
            ps.setInt(2, id);

            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de mudar status do agendamento: " + e.getMessage());
        }
         
         return false;
         
         
     }
     public boolean apagar(int id){
         String sql;
		PreparedStatement ps = null;
		
		sql = "delete from agendamento where idagendamento = ?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
                        return true;
		}
		catch(Exception e){
			System.out.println("Erro na operação de apagar registro: " + e.getMessage());
		}
                return false;
     }
     public boolean alterarData(Agendamento ag){
         String sql;
        PreparedStatement ps = null;

        sql = "update agendamento set data_realizacao = ? where idagendamento = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(ag.getDataRealizacao()));
            ps.setInt(2, ag.getIdAgendamento());
            ps.execute();
            ps.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de mudar status do agendamento: " + e.getMessage());
        }
         
         return false;
         
         
         
         
         
     
     }
}
