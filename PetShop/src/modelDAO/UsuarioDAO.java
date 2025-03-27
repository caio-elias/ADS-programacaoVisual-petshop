
package modelDAO;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author bruno
 */
public class UsuarioDAO {

    private Connection conn = null;
    String perfil = "";

    public UsuarioDAO() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
    }

    public void incluir(Usuario user) {
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO login(usuario, senha, perfil) VALUES (?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getSenha());
            ps.setString(3, user.getPerfil());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());

        }
    }
    
    public void apagar(String usuario){
		String sql;
		PreparedStatement ps = null;
		
		sql = "delete from login where usuario = ?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.execute();
			ps.close();
		}
		catch(Exception e){
			System.out.println("Erro na operação de apagar registro: " + e.getMessage());
		}
    }
    
    public ArrayList<Usuario> listar(){
	ArrayList<Usuario> users = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select usuario, senha, perfil, id from login";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();

                us.setUsuario(rs.getString("usuario"));
                us.setSenha(rs.getString("senha"));
                us.setPerfil(rs.getString("perfil"));
                us.setId(rs.getInt("id"));

                users.add(us);
            }
            rs.close();
            ps.close();
        } 
        catch (Exception e) {
            System.err.println("Erro na operação de listar registros: " + e.getMessage());
        }

        return users;
    }
    
    public void alterar(Usuario us){
		String sql;
		PreparedStatement ps = null;
		
		sql = "update login set usuario = ?, senha = ?, perfil = ? where id = ?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, us.getUsuario());
			ps.setString(2, us.getSenha());
			ps.setString(3, us.getPerfil());
                        ps.setInt(4, us.getId());
                        
			ps.execute();
			ps.close();
		}
		catch(Exception e){
			System.out.println("Erro na operação de alterar registro: " + e.getMessage());
		}
	}
    
    
    
    public boolean verificaUsuario(String usuario) {

        String sql = "Select * from login where usuario = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conn.prepareStatement(sql);
           
            ps.setString(1, usuario);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros" + e.getMessage());

        }

        return false;

    }
    
    public Usuario retornaUsuario(String user) {
        String sql = "Select * from login where usuario = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario us = new Usuario();
        
        try {
            ps = conn.prepareStatement(sql);
           
            ps.setString(1, user);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                
                us.setUsuario(rs.getString("usuario"));
                us.setSenha(rs.getString("senha"));
                us.setPerfil(rs.getString("perfil"));
                us.setId(rs.getInt("id"));
                return us;
               

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros" + e.getMessage());

        }

         return us;
    
    }
    
    

    public String retornaPerfil(String usuario, String senha) {

        String sql = "Select * from login where usuario = ? and senha = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, usuario);
            ps.setString(2, senha);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                perfil = rs.getString("perfil");
                
            
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros" + e.getMessage());

        }

        return perfil;

    }
    

}
