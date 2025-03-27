
package modelDAO;

import controller.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Agendamento;
import model.Cliente;
import model.Conta;
import model.Item;
import model.Parcela;

/**
 *
 * @author bruno
 */
public class ContaDAO {

    private Connection conn = null;

    public ContaDAO() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
    }

    public void incluir(Conta conta, String op) {
        String sql;
        PreparedStatement ps = null;
        sql = "INSERT INTO conta(fk_cliente, data_venda, total, status) VALUES (?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, conta.getCliente().getId());
            ps.setDate(2, Date.valueOf(conta.getData()));
            ps.setFloat(3, conta.getTotal());
            ps.setInt(4, 0);

            ps.execute();
            ps.close();
            for (Item it : conta.getItens()) {
                incluirItens(it, retornaIdConta());
            }

            if (op.equals("cred")) {
                for (Parcela p : conta.getParcelas()) {
                    incluirParcelas(p, retornaIdConta());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir conta: " + e.getMessage());

        }

    }

    public void incluirItens(Item item, int id) {
        String sql;
        PreparedStatement ps = null;
        sql = "INSERT INTO conta_itens(fk_conta,fk_item, itvalor, itqtd) VALUES (?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setInt(2, item.getId());
            ps.setFloat(3, item.getPreco());
            ps.setInt(4, item.getQtdItConta());

            ps.execute();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir item: " + e.getMessage());

        }
    }

    public void incluirParcelas(Parcela p, int id) {
        String sql;
        PreparedStatement ps = null;
        int i = 0;
        sql = "INSERT INTO conta_parcelas(fk_idconta, data_venc, valor_parcela, valor_pago) VALUES (?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setDate(2, Date.valueOf(p.getDataVenc()));
            ps.setFloat(3, p.getValor());
            ps.setFloat(4, 0);

            ps.execute();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de incluir parcelas: " + e.getMessage());

        }
    }

    public void excluirConta(int id) {
        String sql;
        PreparedStatement ps = null;

        sql = "update conta set status = ? where id_conta = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, id);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de excluir conta: " + e.getMessage());
        }
    }

    public int retornaIdConta() {
        String sql;
        PreparedStatement ps = null;
        int maxId = 0;

        sql = "select max(id_conta) from conta";

        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = null;
            rs = ps.executeQuery();

            if (rs.next()) {
                maxId = rs.getInt(1);
            }

            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação buscar código máximo: " + e.getMessage());
        }

        return maxId;
    }

    public ArrayList<Conta> retornaContasPorData(String data) {
        ArrayList<Conta> contas = new ArrayList();
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "select id_conta,nome,data_venda,total,status from conta,cliente where data_venda = ? and id=fk_cliente";

        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(data));
            rs = ps.executeQuery();

            while (rs.next()) {
                int status = rs.getInt("status");

                if (status == 0) {
                    Conta conta = new Conta();
                    Cliente cli = new Cliente();
                    cli.setNome(rs.getString("nome"));
                    conta.setCliente(cli);
                    conta.setData(LocalDate.parse(rs.getString("data_venda")));
                    conta.setTotal(rs.getFloat("total"));
                    conta.setId(rs.getInt("id_conta"));
                    contas.add(conta);
                }

            }
            rs.close();
            ps.close();
            return contas;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar Contas por Data: " + e.getMessage());
        }
        return contas;
    }

    public ArrayList<Conta> retornaContasPorNome(String nome) {
        ArrayList<Conta> contas = new ArrayList();
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "select id_conta,nome,data_venda,total,status from conta,cliente where nome like ? and id=fk_cliente order by data_venda desc";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                int status = rs.getInt("status");

                if (status == 0) {
                    Conta conta = new Conta();
                    Cliente cli = new Cliente();
                    cli.setNome(rs.getString("nome"));
                    conta.setCliente(cli);
                    conta.setData(LocalDate.parse(rs.getString("data_venda")));
                    conta.setTotal(rs.getFloat("total"));
                    conta.setId(rs.getInt("id_conta"));
                    contas.add(conta);
                }

            }
            rs.close();
            ps.close();
            return contas;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de listar Contas por nome: " + e.getMessage());
        }
        return contas;
    }

    public ArrayList<Conta> retornaContasParceladasPorNome(String nome) {
        ArrayList<Conta> contas = new ArrayList();
        ArrayList<Parcela> parcelas = new ArrayList();
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "select id_conta,id_parc,nome,data_venc,valor_parcela,valor_pago from cliente,conta,conta_parcelas "
                + "where  cliente.nome like ? and fk_cliente = id and id_conta = fk_idconta and status = 0 order by data_venc";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+nome+"%");
            rs = ps.executeQuery();

            while (rs.next()) {

                Conta conta = new Conta();
                Cliente cli = new Cliente();
                Parcela p = new Parcela();
                conta.setId(rs.getInt("id_conta"));
                cli.setNome(rs.getString("nome"));

                p.setId(rs.getInt("id_parc"));
                p.setDataVenc(LocalDate.parse(rs.getString("data_venc")));
                p.setValor(rs.getFloat("valor_parcela"));
                p.setValorPago(rs.getFloat("valor_pago"));

                conta.setParcela(p);
                conta.setCliente(cli);

                contas.add(conta);

            }
            rs.close();
            ps.close();

            return contas;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de retornar contas parceladas: " + e.getMessage());
        }
        return contas;
    }

    public void pagarConta(int idParc,float valor) {
        String sql;
        PreparedStatement ps = null;

        sql = "update conta_parcelas set valor_pago = ? where id_parc = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, valor + retornaVpago(idParc));
            ps.setInt(2, idParc);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de pagar conta: " + e.getMessage());
        }
    }
    
    
    
    
    public float retornaVpago(int idParc){
         String sql;
        PreparedStatement ps = null;
        float vpago = 0;

        sql = "select * from conta_parcelas where id_parc = ? ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idParc);
            ResultSet rs = null;
            rs = ps.executeQuery();
            

            if (rs.next()) {
                vpago = rs.getFloat("valor_pago");
            }

            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de retornar valor pago: " + e.getMessage());
        }

        return vpago;
    }

    public ArrayList<Item> retornaItensDaConta(int id) {
        ArrayList<Item> itens = new ArrayList();
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;

        sql = "select descricao,itqtd,itvalor from conta_itens, item where fk_conta = ? and id = fk_item";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Item it = new Item();
                it.setDescricao(rs.getString("descricao"));
                it.setQtdItConta(rs.getInt("itqtd"));
                it.setPreco(rs.getFloat("itvalor"));
                itens.add(it);

            }
            rs.close();
            ps.close();
            return itens;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de retornar itens da conta " + e.getMessage());
        }
        return itens;

    }

    public void mudarStatusAgendamentoPago(ArrayList<Integer> c, int id) {
        String sql;
        PreparedStatement ps = null;

        sql = "update agendamento set status = 'pago', data_faturado = ? where idcliente = ? and idagendamento = ?";

        try {
            for(Integer i : c){
            ps = conn.prepareStatement(sql);
            ps.setInt(2, id);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(3, i);
            
            ps.execute();
            ps.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na operação de mudar status do agendamento: " + e.getMessage());
        }

    }

}
