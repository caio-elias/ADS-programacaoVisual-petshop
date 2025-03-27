package modelDAO;

import model.Cliente;

/**
 *
 * @author cristiane
 */
import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Animal;
import model.Fisica;
import model.Juridica;

public class ClienteDAO {

    private Connection conn = null;
    private int codigo;
    private Statement stm;

    public ClienteDAO() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();

    }

    public boolean incluirCliente(Cliente cli) {

        String sql;
        PreparedStatement ps = null;
        boolean retorno = true;
        int tipos;

        if (cli instanceof Fisica) {
            tipos = 1;
        } else {
            tipos = 2;
        }

        sql = "INSERT INTO cliente(id, nome, logradouro, numero,complemento,"
                + " bairro,municipio, estado, telefone, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cli.getId());
            ps.setString(2, cli.getNome());
            ps.setString(3, cli.getLogradouro());
            ps.setInt(4, cli.getNumero());
            ps.setString(5, cli.getComplemento());
            ps.setString(6, cli.getBairro());
            ps.setString(7, cli.getMunicipio());
            ps.setString(8, cli.getEstado());
            ps.setString(9, cli.getTelefone());
            ps.setInt(10, tipos);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir Cliente: " + e.getMessage());

        }

        if (cli instanceof Fisica) {
            Fisica f = (Fisica) cli;

            retorno = incluirFisica(f);
        } else {
            Juridica j = (Juridica) cli;

            retorno = incluirJuridica(j);
        }
        return retorno;

    }

    private boolean incluirFisica(Fisica fis) {
        String sql;
        PreparedStatement ps = null;
        sql = "INSERT INTO cliente_fisico( fk_clif,cpf) VALUES (?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(2, fis.getCpf());
            ps.setInt(1, fis.getId());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
            return false;

        }

    }
    

    private boolean incluirJuridica(Juridica jud) {
        String sql;
        PreparedStatement ps = null;
        boolean retorno = true;
        sql = "INSERT INTO cliente_juridico(cnpj, fk_clij) VALUES (?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, jud.getCnpj());
            ps.setInt(2, jud.getId());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir registro: " + e.getMessage());
            return false;

        }

    }

    public int proximoCodigo() {
        String sql;
        PreparedStatement ps = null;
        int proximoCodigo = -1;

        sql = "select max(id) from cliente";

        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = null;
            rs = ps.executeQuery();

            if (rs.next()) {
                proximoCodigo = rs.getInt(1);
                proximoCodigo++;
            }
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação buscar código máximo: " + e.getMessage());
        }

        return proximoCodigo;
    }

    public void apagar(int cliId) {
        String sql;
        PreparedStatement ps = null;

        sql = "delete from cliente where id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliId);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println("Erro na operação de apagar registro de cliente: " + e.getMessage());
        }
    }

    public boolean alterarCli(Cliente cli) {

        String sql;
        PreparedStatement ps = null;
        boolean retorno = false;
        int tipo;
        Fisica cliF;
        Juridica cliJ;
        if (cli instanceof Fisica) {

            tipo = 1;
        } else {
            tipo = 2;
        }

        sql = "update cliente set nome = ?, logradouro = ?, numero = ?,  complemento = ?, bairro = ?, municipio = ?, estado = ?, telefone = ?, tipo = ? where id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getLogradouro());
            ps.setInt(3, cli.getNumero());
            ps.setString(4, cli.getComplemento());
            ps.setString(5, cli.getBairro());
            ps.setString(6, cli.getMunicipio());
            ps.setString(7, cli.getEstado());
            ps.setString(8, cli.getTelefone());
            ps.setInt(9, tipo);
            ps.setInt(10, cli.getId());
            retorno = true;
           
            ps.execute();
            ps.close();

        } catch (Exception e) {
            System.out.println("Erro na operação de alterar registro de cliente: " + e.getMessage());
        }

        if (tipo == 1) {
            cliF = (Fisica) cli;

           

            try {

                sql = "update cliente_fisico set cpf= ? where fk_clif = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, cliF.getCpf());
                ps.setInt(2, cliF.getId());
                ps.execute();
                ps.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na operação de alterar produto: " + e.getMessage());
            }

        } else {
            cliJ = (Juridica) cli;

            alterarJuridica(cliJ.getId(), cliJ.getCnpj());
        }

        return retorno;
    }

    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cliente";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int tipo = rs.getInt("tipo");
                if (tipo == 1) {
                    Fisica f = new Fisica();
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setLogradouro(rs.getString("logradouro"));
                    f.setNumero(rs.getInt("numero"));
                    f.setComplemento(rs.getString("complemento"));
                    f.setBairro(rs.getString("bairro"));
                    f.setMunicipio(rs.getString("municipio"));
                    f.setEstado(rs.getString("estado"));
                    f.setTelefone(rs.getString("telefone"));

                    clientes.add(buscarFisica(f));
                } else {
                    Juridica j = new Juridica();

                    j.setId(rs.getInt("id"));
                    j.setNome(rs.getString("nome"));
                    j.setLogradouro(rs.getString("logradouro"));
                    j.setNumero(rs.getInt("numero"));
                    j.setComplemento(rs.getString("complemento"));
                    j.setBairro(rs.getString("bairro"));
                    j.setMunicipio(rs.getString("municipio"));
                    j.setEstado(rs.getString("estado"));
                    j.setTelefone(rs.getString("telefone"));

                    clientes.add(buscarJuridica(j));
                }

            }
            rs.close();
            ps.close();
            return clientes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar Itens excluídos: " + e.getMessage());
        }

        return clientes;
    }

//    public void alterar(Fisica cli) {
//        String sql;
//        PreparedStatement ps = null;
//
//        sql = "update cliente set nome = ?, logradouro = ?, numero = ?,  complemento = ?, bairro = ?,municipio"
//                + " estado = ?, telefone = ?, cpf = ?  where id = ?";
//
//        try {
//            ps.setDouble(1, cli.getId());
//            ps.setString(2, cli.getNome());
//            ps.setString(3, cli.getLogradouro());
//            ps.setInt(4, cli.getNumero());
//            ps.setString(5, cli.getComplemento());
//            ps.setString(6, cli.getBairro());
//            ps.setString(7, cli.getEstado());
//            ps.setString(8, cli.getTelefone());
//            ps.setString(9, cli.getCpf());
//
//            ps.execute();
//            ps.close();
//        } catch (Exception e) {
//            System.out.println("Erro na operação de alterar registro de cliente: " + e.getMessage());
//        }
//    }
    public ArrayList<Juridica> listaJuridica() {
        ArrayList<Juridica> clientes = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select c.id, c.nome, c.logradouro,c.numero, c.complemento, c.bairro,"
                + " c.municipio,c.estado, c.telefone, j.cnpj from cliente  as c "
                + "join cliente_juridico as j on c.id = j.fk_clij";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Juridica cli = new Juridica();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setLogradouro(rs.getString("logradouro"));
                cli.setNumero(rs.getInt("numero"));
                cli.setComplemento(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setMunicipio(rs.getString("municipio"));
                cli.setEstado(rs.getString("estado"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setCnpj(rs.getString("cnpj"));

                clientes.add(cli);
            }
            rs.close();
            ps.close();
            return clientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação : " + e.getMessage());
        }

        return null;
    }

    public ArrayList<Fisica> listaFisica() {
        ArrayList<Fisica> clientes = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select c.id, c.nome, c.logradouro,c.numero, c.complemento, c.bairro,"
                + " c.municipio,c.estado, c.telefone, f.cpf from cliente  as c "
                + "join cliente_fisico as f on c.id = f.fk_clif";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Fisica cli = new Fisica();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setLogradouro(rs.getString("logradouro"));
                cli.setNumero(rs.getInt("numero"));
                cli.setComplemento(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setMunicipio(rs.getString("municipio"));
                cli.setEstado(rs.getString("estado"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setCpf(rs.getString("cpf"));

                clientes.add(cli);
            }
            rs.close();
            ps.close();
            return clientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação listar clientes fisicos: " + e.getMessage());
        }

        return null;

    }

    public Cliente retornaClienteID(int id) {
        String sql = "select * from cliente where id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cliente cli = new Cliente();
        int tipo;

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                tipo = rs.getInt("tipo");
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setLogradouro(rs.getString("logradouro"));
                cli.setNumero(rs.getInt("numero"));
                cli.setComplemento(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setEstado(rs.getString("estado"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setMunicipio(rs.getString("municipio"));

                if (tipo == 1) {
                    Fisica f = buscaClienteFisico(cli);
                    cli = f;
                } else if (tipo == 2) {
                    Juridica j = buscaClienteJuridico(cli);
                    cli = j;

                }

            }
            rs.close();
            ps.close();
            return cli;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros do cliente" + e.getMessage());

        }

        return null;

    }
    public ArrayList<Cliente> retornaClientesCpf(String cpf) {
        String sql = "SELECT * FROM cliente_fisico, cliente where cpf LIKE ? and fk_clif = id";
        ArrayList <Cliente> clientes = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int tipo;
        
        try {
            ps = conn.prepareStatement(sql);

             ps.setString(1, "%"+cpf+"%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                tipo = rs.getInt("tipo");
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setLogradouro(rs.getString("logradouro"));
                cli.setNumero(rs.getInt("numero"));
                cli.setComplemento(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setEstado(rs.getString("estado"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setMunicipio("municipio");
                
                
                if (tipo==1){
                    Fisica f = buscaClienteFisico(cli);
                    cli = f;
                }else{
                    Juridica j = buscaClienteJuridico(cli);
                    cli = j;
                    
                }
                clientes.add(cli);
            
            }
            rs.close();
            ps.close();
            return clientes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros do cliente" + e.getMessage());

        }

        return null;

    } 
    public ArrayList<Cliente> retornaClientesCnpj(String cnpj) {
        String sql = "SELECT * FROM cliente_juridico, cliente where cnpj LIKE ? and fk_clij = id";
        ArrayList <Cliente> clientes = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int tipo;
        
        try {
            ps = conn.prepareStatement(sql);

             ps.setString(1, "%"+cnpj+"%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                tipo = rs.getInt("tipo");
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setLogradouro(rs.getString("logradouro"));
                cli.setNumero(rs.getInt("numero"));
                cli.setComplemento(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setEstado(rs.getString("estado"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setMunicipio("municipio");
                
                
                if (tipo==1){
                    Fisica f = buscaClienteFisico(cli);
                    cli = f;
                }else{
                    Juridica j = buscaClienteJuridico(cli);
                    cli = j;
                    
                }
                clientes.add(cli);
            
            }
            rs.close();
            ps.close();
            return clientes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros do cliente" + e.getMessage());

        }

        return null;

    }

    public Fisica retornaClienteCPF(String cpf) {
        String sql = "select * from cliente,cliente_fisico where id = fk_clif and cpf LIKE ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Fisica f = new Fisica();

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + cpf + "%");

            rs = ps.executeQuery();
            if (rs.next()) {

                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setLogradouro(rs.getString("logradouro"));
                f.setNumero(rs.getInt("numero"));
                f.setComplemento(rs.getString("complemento"));
                f.setBairro(rs.getString("bairro"));
                f.setEstado(rs.getString("estado"));
                f.setTelefone(rs.getString("telefone"));
                f.setMunicipio(rs.getString("municipio"));
                f.setCpf(rs.getString("cpf"));

            }
            rs.close();
            ps.close();
            return f;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros do cliente" + e.getMessage());

        }

        return null;

    }

    public Juridica retornaClienteCNPJ(String cnpj) {
        String sql = "select * from cliente,cliente_juridico where id = fk_clij and cnpj LIKE ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Juridica j = new Juridica();

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + cnpj + "%");

            rs = ps.executeQuery();
            if (rs.next()) {

                j.setId(rs.getInt("id"));
                j.setNome(rs.getString("nome"));
                j.setLogradouro(rs.getString("logradouro"));
                j.setNumero(rs.getInt("numero"));
                j.setComplemento(rs.getString("complemento"));
                j.setBairro(rs.getString("bairro"));
                j.setEstado(rs.getString("estado"));
                j.setTelefone(rs.getString("telefone"));
                j.setMunicipio(rs.getString("municipio"));
                j.setCnpj(rs.getString("cnpj"));

            }
            rs.close();
            ps.close();
            return j;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros do cliente" + e.getMessage());

        }

        return null;

    }

    public ArrayList<Cliente> retornaClienteNome(String nome) {
        String sql = "SELECT * FROM cliente where nome LIKE ?";
        ArrayList<Cliente> clientes = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;

        int tipo;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + nome + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                tipo = rs.getInt("tipo");
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setLogradouro(rs.getString("logradouro"));
                cli.setNumero(rs.getInt("numero"));
                cli.setComplemento(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setEstado(rs.getString("estado"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setMunicipio("municipio");

                if (tipo == 1) {
                    Fisica f = buscaClienteFisico(cli);
                    cli = f;
                } else {
                    Juridica j = buscaClienteJuridico(cli);
                    cli = j;

                }
                clientes.add(cli);

            }
            rs.close();
            ps.close();
            return clientes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros do cliente" + e.getMessage());

        }

        return null;

    }

    public Fisica buscaClienteFisico(Cliente cli) {
        String sql = "select * from cliente_fisico where fk_clif = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Fisica fis = new Fisica();

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, cli.getId());

            rs = ps.executeQuery();
            if (rs.next()) {
                fis.setBairro(cli.getBairro());
                fis.setComplemento(cli.getComplemento());
                fis.setEstado(cli.getEstado());
                fis.setId(cli.getId());
                fis.setLogradouro(cli.getLogradouro());
                fis.setMunicipio(cli.getMunicipio());
                fis.setNome(cli.getNome());
                fis.setNumero(cli.getNumero());
                fis.setTelefone(cli.getTelefone());
                fis.setCpf(rs.getString("cpf"));
                return fis;

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros do cliente" + e.getMessage());

        }

        return fis;

    }

    public Juridica buscaClienteJuridico(Cliente cli) {
        String sql = "select * from cliente_juridico where fk_clij = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Juridica jud = new Juridica();

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, cli.getId());

            rs = ps.executeQuery();
            if (rs.next()) {
                jud.setBairro(cli.getBairro());
                jud.setComplemento(cli.getComplemento());
                jud.setEstado(cli.getEstado());
                jud.setId(cli.getId());
                jud.setLogradouro(cli.getLogradouro());
                jud.setMunicipio(cli.getMunicipio());
                jud.setNome(cli.getNome());
                jud.setNumero(cli.getNumero());
                jud.setTelefone(cli.getTelefone());
                jud.setCnpj(rs.getString("cnpj"));
                return jud;

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar registros do cliente" + e.getMessage());

        }

        return jud;

    }

    public String excluirCliente(int id) {
        try {
            stm.execute("DELETE FROM cliente WHERE id = " + id + "");
            return "sucesso";
        } catch (SQLException ex) {
            return ex.toString();
        }
    }

    public void alterarJuridica(int id, String cnpj) {

        String sql;
        PreparedStatement ps = null;

        sql = "update cliente_juridico set cnpj = ? where fk_clij = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cnpj);
            ps.setInt(2, id);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de alterar produto: " + e.getMessage());
        }

    }

    private Fisica buscarFisica(Fisica f) {
        String sql;
        PreparedStatement ps = null;

        sql = "SELECT * FROM cliente_fisico WHERE fk_clif = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, f.getId());
            ResultSet rs = null;
            rs = ps.executeQuery();
            if (rs.next()) {
                f.setCpf(rs.getString("cpf"));

                rs.close();
                ps.close();
                return f;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de buscar cliente fisico " + e.getMessage());
        }
        return f;
    }

    ////BUSCAR PESSOA JURIDICA
    private Juridica buscarJuridica(Juridica j) {
        String sql;
        PreparedStatement ps = null;

        sql = "SELECT * FROM cliente_juridico WHERE fk_clij = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, j.getId());
            ResultSet rs = null;
            rs = ps.executeQuery();
            if (rs.next()) {
                j.setCnpj(rs.getString("cnpj"));

                rs.close();
                ps.close();
                return j;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de buscar cliente juridico: " + e.getMessage());
        }
        return j;
    }
    public ArrayList<Animal> retornaAnimaisCliente(int id){
        ArrayList<Animal> animais = new ArrayList<>();
        String sql = "select * from animal where cliente_animal = " + id;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        PreparedStatement ps = null;
        ResultSet rs = null;
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
                animais.add(a);
              

            }
            rs.close();
            ps.close();
            return animais;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar animais do cliente" + e.getMessage());

        }
        return animais;
    }
  
}
