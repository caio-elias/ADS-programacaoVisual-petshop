
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
import model.Animal;

public class AnimalDAO {

    private Connection conn = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AnimalDAO() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
    }

    public int proximoCodigo() {
        String sql;
        PreparedStatement ps = null;
        int proximoCodigo = -1;

        sql = "select max(id) from animal";

        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = null;
            rs = ps.executeQuery();

            if (rs.next()) {
                proximoCodigo = rs.getInt("max");
                proximoCodigo++;
            }
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação buscar código máximo: " + e.getMessage());
        }

        return proximoCodigo;
    }

    public void inserir(Animal a) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String sql;
        PreparedStatement ps = null;

        sql = "INSERT INTO animal(cliente_animal,nome,data_nascimento,raca,peso,altura,sexo,foto) VALUES (?,?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getIdCliente());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getDataNascimento().format(formatter));
            ps.setString(4, a.getRaca());
            ps.setFloat(5, a.getPeso());
            ps.setFloat(6, a.getAltura());
            ps.setString(7, a.getSexo());
            ps.setBytes(8, a.getFoto());
            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no Cadastro do animal" + e.getMessage());

        }

    }

    public void alterarAnimal(Animal a) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String sql;
        PreparedStatement ps = null;

        sql = "update animal set nome = ?,data_nascimento = ?,raca = ?,peso = ? ,altura = ?,sexo = ?, foto = ? where id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getDataNascimento().format(formatter));
            ps.setString(3, a.getRaca());
            ps.setFloat(4, a.getPeso());
            ps.setFloat(5, a.getAltura());
            ps.setString(6, a.getSexo());
            ps.setBytes(7, a.getFoto());
            ps.setInt(8, a.getId());
            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(null, "Animal alterado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no Cadastro do animal" + e.getMessage());

        }

    }

    
    public Animal buscarPorId(Integer id) {
        Animal retorno = null;
        String sql = "SELECT * from animal where id = ?";
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                retorno = new Animal();

                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
                retorno.setAltura(rs.getFloat("altura"));
                retorno.setPeso(rs.getFloat("peso"));
                retorno.setDataNascimento(LocalDate.parse(rs.getString("data_Nascimento"), formatter));
                retorno.setRaca(rs.getString("raca"));
                retorno.setFoto(rs.getBytes("foto"));
                retorno.setIdCliente(rs.getInt("cliente_animal"));
                retorno.setSexo(rs.getString("sexo"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            retorno = null;
        }

        return retorno;

    }

    public ArrayList<Animal> listarAnimais() {
        ArrayList<Animal> animais = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from animal";
        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Animal a = new Animal();

                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setAltura(rs.getFloat("altura"));
                a.setPeso(rs.getFloat("peso"));
                a.setDataNascimento(LocalDate.parse(rs.getString("data_Nascimento"), formatter));
                a.setRaca(rs.getString("raca"));
                a.setFoto(rs.getBytes("foto"));
                a.setIdCliente(rs.getInt("cliente_animal"));
                a.setSexo(rs.getString("sexo"));

                animais.add(a);
            }
            rs.close();
            ps.close();
            return animais;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar animais: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<Animal> listarAnimaisPorCliente(int idcli) {
        ArrayList<Animal> animais = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select id, nome, raca from animal where cliente_animal = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idcli);
            rs = ps.executeQuery();
            while (rs.next()) {
                Animal a = new Animal();

                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setRaca(rs.getString("raca"));

                animais.add(a);
            }
            rs.close();
            ps.close();
            return animais;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
        }

        return null;
    }

    public void excluirAnimal(int id) {
        String sql;
        PreparedStatement ps = null;

        sql = "Delete from animal where id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de excluir animal: " + e.getMessage());
        }
    }

}
