
package modelDAO;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Profissional;


public class ProfissionalDAO {
    private Connection conn = null;

    public ProfissionalDAO() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
    }
    
    public void incluir(Profissional prof) {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO profissional(nome, especialidade) VALUES (?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, prof.getNome());
            ps.setString(2, prof.getEspecialidade());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());

        }
    }
    
     public void apagar(int id){
		String sql;
		PreparedStatement ps = null;
		
		sql = "delete from profissional where id = ?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		}
		catch(Exception e){
			System.out.println("Erro na operação de apagar registro: " + e.getMessage());
		}
    }
     
     public void alterar(Profissional pro){
		String sql;
		PreparedStatement ps = null;
		
		sql = "update profissional set nome = ?, especialidade = ? where id = ?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getNome());
			ps.setString(2, pro.getEspecialidade());
                        ps.setInt(3, pro.getId());
                        
			ps.execute();
			ps.close();
		}
		catch(Exception e){
			System.out.println("Erro na operação de alterar registro: " + e.getMessage());
		}
	}
    
     public ArrayList<Profissional> listarProfissionais(){
	ArrayList<Profissional> pros = new ArrayList();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select nome, especialidade, id from profissional";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissional pro = new Profissional();

                pro.setNome(rs.getString("nome"));
                pro.setEspecialidade(rs.getString("especialidade"));
                pro.setId(rs.getInt("id"));

                pros.add(pro);
            }
            rs.close();
            ps.close();
        } 
        catch (Exception e) {
            System.err.println("Erro na operação de listar registros: " + e.getMessage());
        }

        return pros;
    }
    
}
