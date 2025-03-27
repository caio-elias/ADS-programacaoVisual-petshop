package view;

import controller.GerenciaClientes;
import controller.GerenciaContas;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Item;
import controller.GerenciaItens;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.Agendamento;
import model.Conta;
import model.Cliente;
import model.Fisica;
import model.Juridica;
import model.Parcela;

public class TelaConta extends javax.swing.JInternalFrame {

    GerenciaItens geItens = new GerenciaItens();
    GerenciaContas geConta = new GerenciaContas();
    GerenciaClientes geCli = new GerenciaClientes();
    ArrayList<Item> itens;
    ArrayList<Parcela> parcelas;
    ArrayList<Cliente> clientes;
    ArrayList<Integer> agendamentos;
    boolean existeAgendamento = false;
    boolean abrirTelaAgendamento;
    Agendamento ag;
    TelaAgendamentos telaAgenda;

    public TelaConta() {
        clientes = new ArrayList();
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblItensBusca.getModel();
        tblItensBusca.setRowSorter(new TableRowSorter(modelo));
        tabPane.setEnabledAt(0, false);
        tabPane.setEnabledAt(1, false);
        tabPane.setEnabledAt(2, false);
        tabPane.setEnabledAt(3, false);
        btnSair.setVisible(false);
    }
    public TelaConta(Agendamento ag,TelaAgendamentos telaAgenda){
        initComponents();
        abrirTelaAgendamento = true;
        DefaultTableModel modelo = (DefaultTableModel) tblItensBusca.getModel();
        tblItensBusca.setRowSorter(new TableRowSorter(modelo));
        tabPane.setEnabledAt(0, false);
        tabPane.setEnabledAt(1, false);
        tabPane.setEnabledAt(2, false);
        tabPane.setEnabledAt(3, false);
        this.ag = ag;
        setarTelaFaturarServico(ag);
        this.telaAgenda = telaAgenda;
        this.setClosable(false);
        btnSair.setVisible(true);
       
        
    }
    private void setarTelaFaturarServico(Agendamento ag){
        DefaultTableModel modeloCBN = (DefaultTableModel) tblClientes.getModel();
        modeloCBN.setNumRows(0);
        btnPesquisaCliente.setEnabled(false);
     
            if (ag.getCli() instanceof Juridica) {
                Juridica j = new Juridica();
                modeloCBN.addRow(new Object[]{
                    ((Juridica) ag.getCli()).getNome(),
                    "-",
                    ((Juridica) ag.getCli()).getCnpj(),
                    ((Juridica) ag.getCli()).getId(),});
            } else if (ag.getCli() instanceof Fisica) {
                modeloCBN.addRow(new Object[]{
                    ((Fisica) ag.getCli()).getNome(),
                    ((Fisica) ag.getCli()).getCpf(),
                    "-",
                    ((Fisica) ag.getCli()).getId(),});

            }
            tblClientes.addRowSelectionInterval(0, 0);
            setarCampos();
            DefaultTableModel modeloIC = (DefaultTableModel) tblItensConta.getModel();
            float valor = ag.getServico().getPreco();
            modeloIC.addRow(new Object[]{
                ag.getServico().getId(),
                (""+ag.getServico().getDescricao() +" /OS: "+ ag.getIdAgendamento()),
                ag.getServico().getPreco(),
                1,
                valor,});
            
                somaItens();
                tabPane.setSelectedIndex(1);
                agendamentos = new ArrayList<>();
                agendamentos.add(ag.getIdAgendamento());
                verificaExistAgendamento();
                tabPane.setSelectedIndex(1);
          
    }

    public void salvarConta(String op) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat formatarFloat = new DecimalFormat("#.##");
        itens = new ArrayList();
        parcelas = new ArrayList();
        Conta conta = new Conta();
        Cliente cli = new Cliente();
        int numLinhas = tblItensConta.getRowCount();
        float total = Float.parseFloat(tfdValorTotal.getText());
        cli.setId(Integer.parseInt(tfdID.getText()));

        for (int i = 0; i < numLinhas; i++) {
            Item it = new Item();
            it.setId(Integer.parseInt(tblItensConta.getValueAt(i, 0).toString()));
            it.setDescricao(tblItensConta.getValueAt(i, 1).toString());
            it.setPreco(Float.parseFloat(tblItensConta.getValueAt(i, 2).toString()));
            it.setQtdItConta(Integer.parseInt(tblItensConta.getValueAt(i, 3).toString()));
            itens.add(it);
        }

        conta.setCliente(cli);
        conta.setItens(itens);
        conta.setTotal(total);
        conta.setData(LocalDate.now());
        if (op.equals("cred")) {
            int nrlinhastbParcelas = tblParcelas.getRowCount();
            for (int i = 0; i < nrlinhastbParcelas; i++) {
                Parcela p = new Parcela();
                p.setDataVenc(LocalDate.parse(tblParcelas.getValueAt(i, 0).toString(), formatter));
                float val = Float.parseFloat(tblParcelas.getValueAt(i, 1).toString().replace(",", "."));
                p.setValor(val);
                parcelas.add(p);
            }
            conta.setParcelas(parcelas);

        }

        geConta.adicionarConta(conta, op);
        if (existeAgendamento) {
            geConta.MudaStatusAgendamentoParaPago(agendamentos, conta.getCliente().getId());
        }

        JOptionPane.showMessageDialog(null, "Venda salva com sucesso!");
        if(abrirTelaAgendamento){
            telaAgenda.setVisible(true);
            telaAgenda.atualizaTabela();
            
        }
        dispose();

    }

    public void limpaTabelaItensBusca() {
        DefaultTableModel modeloIB = (DefaultTableModel) tblItensBusca.getModel();
        while (tblItensBusca.getModel().getRowCount() > 0) {
            modeloIB.removeRow(0);
        }
    }

    public void limpaTabelaItensConta() {
        DefaultTableModel modeloIB = (DefaultTableModel) tblItensConta.getModel();
        while (tblItensConta.getModel().getRowCount() > 0) {
            modeloIB.removeRow(0);
        }
    }

    public void limpaTabelaParcelas() {
        DefaultTableModel modeloParcelas = (DefaultTableModel) tblParcelas.getModel();
        while (tblParcelas.getModel().getRowCount() > 0) {
            modeloParcelas.removeRow(0);
        }
    }

    public void verificaExistAgendamento() {
        int idcliente = Integer.parseInt(tfdID.getText());
        ArrayList<Agendamento> servicos = geConta.retornaidServicosPorCliente(idcliente);
        if (!servicos.isEmpty()) {
            existeAgendamento = true;
            lerTabelaServicos(servicos);
            tabPane.setSelectedIndex(1);
            limpaTabelaItensBusca();
        } else {
            limpaTabelaItensBusca();
            tabelaServicos.setVisible(false);
            jbaddServico.setVisible(false);
            tabelaServicos.setEnabled(false);
            tabPane.setSelectedIndex(1);
        }
       

    }
    private void lerTabelaServicos(ArrayList<Agendamento> servicos){
        DefaultTableModel modeloTabelaServicos = (DefaultTableModel) tabelaServicos.getModel();
        modeloTabelaServicos.setNumRows(0);
        for (Agendamento it: servicos){
             modeloTabelaServicos.addRow(new Object[]{
                it.getIdAgendamento(),
                it.getServico().getId(), (""+it.getServico().getDescricao()+" /OS: " +it.getIdAgendamento()),
                it.getAnimal().getNome(),
                it.getServico().getPreco()});
        }
        tabelaServicos.setVisible(true);
        jbaddServico.setVisible(true);
        tabelaServicos.setEnabled(true);
    }

    public void lerTabelaItensBuscaID() {
        DefaultTableModel modeloIB = (DefaultTableModel) tblItensBusca.getModel();
        while (tblItensBusca.getModel().getRowCount() > 0) {
            modeloIB.removeRow(0);
        }

        int id = Integer.parseInt(tfdBuscaItem.getText());
        Item it = geItens.retornaProdutosPoID(id);

        if (it != null) {
            modeloIB.addRow(new Object[]{
                it.getId(),
                it.getDescricao(),
                it.getPreco(),});
        } else {
            JOptionPane.showMessageDialog(null, "ID não encontrado!");
        }

    }

    public void lerTabelaItensBuscaID(ArrayList<Integer> servicos) {
        DefaultTableModel modeloIB = (DefaultTableModel) tblItensBusca.getModel();
        while (tblItensBusca.getModel().getRowCount() > 0) {
            modeloIB.removeRow(0);
        }
        
        for (int i=0;i<servicos.size();i++){
            Item it = geItens.retornarITem(servicos.get(i));
             modeloIB.addRow(new Object[]{
                it.getId(),
                it.getDescricao(),
                it.getPreco(),});
        }
    }

    public void lerTabelaItensBuscaporDesc() {
        DefaultTableModel modeloIB = (DefaultTableModel) tblItensBusca.getModel();
        while (tblItensBusca.getModel().getRowCount() > 0) {
            modeloIB.removeRow(0);
        }

        String desc = (tfdBuscaItem.getText());

        itens = geItens.retornaProdutosPorDesc(desc);

        for (Item it : itens) {
            modeloIB.addRow(new Object[]{
                it.getId(),
                it.getDescricao(),
                it.getPreco(),});
        }

    }
    public void populaTabelaItensContaServico() {
        DefaultTableModel modeloIC = (DefaultTableModel) tblItensConta.getModel();
        float valor = Float.parseFloat(tabelaServicos.getValueAt(tabelaServicos.getSelectedRow(), 4).toString());
        modeloIC.addRow(new Object[]{
            tabelaServicos.getValueAt(tabelaServicos.getSelectedRow(), 1).toString(),
            tabelaServicos.getValueAt(tabelaServicos.getSelectedRow(), 2).toString(),
            tabelaServicos.getValueAt(tabelaServicos.getSelectedRow(), 4).toString(),
            1,
            valor,});
        somaItens();

    }

    public void populaTabelaItensConta() {
        DefaultTableModel modeloIC = (DefaultTableModel) tblItensConta.getModel();
        int quantidade = Integer.parseInt(tfdQtd.getText());
        float valor = Float.parseFloat(tblItensBusca.getValueAt(tblItensBusca.getSelectedRow(), 2).toString());
        modeloIC.addRow(new Object[]{
            tblItensBusca.getValueAt(tblItensBusca.getSelectedRow(), 0).toString(),
            tblItensBusca.getValueAt(tblItensBusca.getSelectedRow(), 1).toString(),
            tblItensBusca.getValueAt(tblItensBusca.getSelectedRow(), 2).toString(),
            quantidade,
            quantidade * valor,});

        somaItens();
        
        
    }

    public void populaTabelaClientesBuscaporNome() {
        DefaultTableModel modeloCBN = (DefaultTableModel) tblClientes.getModel();
        while (tblClientes.getModel().getRowCount() > 0) {
            modeloCBN.removeRow(0);
        }

        String nome = tfdBuscaCliente.getText();
        clientes = geCli.retornaClienteNome(nome);

        for (Cliente cli : clientes) {
            if (cli instanceof Juridica) {
                Juridica j = new Juridica();
                modeloCBN.addRow(new Object[]{
                    ((Juridica) cli).getNome(),
                    "-",
                    ((Juridica) cli).getCnpj(),
                    ((Juridica) cli).getId(),});
            } else if (cli instanceof Fisica) {
                modeloCBN.addRow(new Object[]{
                    ((Fisica) cli).getNome(),
                    ((Fisica) cli).getCpf(),
                    "-",
                    ((Fisica) cli).getId(),});

            }
        }

    }

    public void populaTabelaClienteBuscaporCPF() {
        DefaultTableModel modeloCBI = (DefaultTableModel) tblClientes.getModel();
        while (tblClientes.getModel().getRowCount() > 0) {
            modeloCBI.removeRow(0);
        }
        String cpf = tfdBuscaCliente.getText().toString();

        Fisica f = geCli.retornaClienteCPF(cpf);

        if (f == null) {
            JOptionPane.showMessageDialog(null, "CPF não encontrado!");
        } else {
            modeloCBI.addRow(new Object[]{
                f.getNome(),
                f.getCpf(),
                "-",
                f.getId(),});
        }

    }

    public void populaTabelaClienteBuscaporCNPJ() {
        DefaultTableModel modeloCBI = (DefaultTableModel) tblClientes.getModel();
        while (tblClientes.getModel().getRowCount() > 0) {
            modeloCBI.removeRow(0);
        }
        String cnpj = tfdBuscaCliente.getText().toString();

        Juridica j = geCli.retornaClienteCNPJ(cnpj);

        if (j == null) {
            JOptionPane.showMessageDialog(null, "CNPJ não encontrado!");
        } else {
            modeloCBI.addRow(new Object[]{
                j.getNome(),
                "-",
                j.getCnpj(),
                j.getId(),});
        }

    }

    public void lerTabelaParcelas() {
        limpaTabelaParcelas();
        DefaultTableModel modeloParcelas = (DefaultTableModel) tblParcelas.getModel();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        float vtotal, valorParcela, entrada;
        int nrParcelas, i = 0;
        String vParcela;

        vtotal = Float.parseFloat(tfdValorTotal.getText().toString());
        nrParcelas = Integer.parseInt(tfdNrParcelas.getText());
        entrada = Float.parseFloat(tfdEntrada.getText().toString());

        valorParcela = (vtotal - entrada) / nrParcelas;
        vParcela = String.format("%.2f", valorParcela);

        while (i < nrParcelas) {
            modeloParcelas.addRow(new Object[]{
                LocalDate.now().plusMonths(i + 1).format(formatter),
                vParcela,});

            i++;
        }

    }

    public void setarCampos() {
        int linha = tblClientes.getSelectedRow();
        int id = Integer.parseInt(tblClientes.getValueAt(linha, 3).toString());

        Cliente cli = geCli.retornaClienteID(id);
        tfdID.setText(String.valueOf(cli.getId()));
        tfdRua.setText(cli.getLogradouro());
        tfdnro.setText(String.valueOf(cli.getNumero()));
        tfdBairro.setText(cli.getBairro());
        tfdMunicipio.setText(cli.getMunicipio());
        tfdTelefone.setText(cli.getTelefone());
    }

    public void somaItens() {
        float valor, soma = 0;
        int numLinhas = tblItensConta.getRowCount();
        for (int i = 0; i < numLinhas; i++) {
            valor = (float) tblItensConta.getValueAt(i, 4);
            soma = soma + valor;
        }
        tfdValorTotal.setText(String.valueOf(soma));

    }

    public void calculaTroco() {
        if (!tfdVpago.getText().isEmpty()) {
            float vtotal, vpago, desconto, diferenca;
            vtotal = Float.parseFloat(tfdValorTotal.getText());
            vpago = Float.parseFloat(tfdVpago.getText());
            desconto = Float.parseFloat(tfdDesconto.getText());
            diferenca = (float) (vpago - (vtotal - ((vtotal * desconto) / 100.0)));

            String troco = String.format("%.2f", diferenca);
            tfdTroco.setText(troco);
        }

    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoCli = new javax.swing.ButtonGroup();
        btnGrupoItens = new javax.swing.ButtonGroup();
        tabPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tfdBuscaCliente = new javax.swing.JTextField();
        btnPesquisaCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfdRua = new javax.swing.JTextField();
        tfdTelefone = new javax.swing.JTextField();
        tfdBairro = new javax.swing.JTextField();
        tfdMunicipio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdnro = new javax.swing.JTextField();
        tfdID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnProx1 = new javax.swing.JButton();
        cbPesquisaCliente = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnAdicionarItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItensConta = new javax.swing.JTable();
        tfdQtd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnVendaAVista = new javax.swing.JButton();
        tfdBuscaItem = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        btnPesquisaItem = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblItensBusca = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        tfdValorTotal = new javax.swing.JTextField();
        btnRemover = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbPesquisaItem = new javax.swing.JComboBox<>();
        btnCrediario = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaServicos = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jbaddServico = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfdVvenda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfdVpago = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfdTroco = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnFinalizarAV = new javax.swing.JButton();
        tfdDesconto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblParcelas = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        tfdNrParcelas = new javax.swing.JTextField();
        btnParcelar = new javax.swing.JButton();
        btnFinalizarCred = new javax.swing.JButton();
        btnCancelar2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tfdEntrada = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfdValorVenda = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();

        setBackground(new java.awt.Color(237, 237, 247));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Venda");

        jPanel1.setBackground(new java.awt.Color(237, 237, 247));

        tfdBuscaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdBuscaClienteKeyPressed(evt);
            }
        });

        btnPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa.png"))); // NOI18N
        btnPesquisaCliente.setText("Pesquisar");
        btnPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaClienteActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "CNPJ", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setRowHeight(35);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        tblClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblClientesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblClientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do cliente"));

        jLabel1.setText("Rua:");

        jLabel2.setText("Bairro: ");

        jLabel3.setText("Município:");

        jLabel4.setText("Telefone:");

        tfdRua.setEditable(false);

        tfdTelefone.setEditable(false);

        tfdBairro.setEditable(false);
        tfdBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdBairroActionPerformed(evt);
            }
        });

        tfdMunicipio.setEditable(false);

        jLabel5.setText("N°:");

        tfdnro.setEditable(false);

        tfdID.setEditable(false);
        tfdID.setForeground(new java.awt.Color(0, 51, 51));

        jLabel13.setText("ID:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tfdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(tfdMunicipio))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tfdRua, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdnro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfdID, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tfdTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfdRua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdnro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfdBairro, tfdID, tfdMunicipio, tfdRua, tfdTelefone});

        btnProx1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/seta_frente_32px.png"))); // NOI18N
        btnProx1.setText("Próximo");
        btnProx1.setEnabled(false);
        btnProx1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProx1ActionPerformed(evt);
            }
        });

        cbPesquisaCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "CNPJ" }));
        cbPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPesquisaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnProx1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbPesquisaCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfdBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisaCliente)
                        .addGap(20, 20, 20)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfdBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProx1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jPanel4.getAccessibleContext().setAccessibleDescription("Dados do cliente");

        tabPane.addTab("Cliente", jPanel1);

        jPanel2.setBackground(new java.awt.Color(237, 237, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/criar.png"))); // NOI18N
        btnAdicionarItem.setText("Adicionar");
        btnAdicionarItem.setEnabled(false);
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdicionarItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 140, 40));

        tblItensConta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Valor Unitário", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItensConta.setRowHeight(35);
        tblItensConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItensContaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblItensConta);
        if (tblItensConta.getColumnModel().getColumnCount() > 0) {
            tblItensConta.getColumnModel().getColumn(0).setMinWidth(90);
            tblItensConta.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblItensConta.getColumnModel().getColumn(0).setMaxWidth(90);
            tblItensConta.getColumnModel().getColumn(1).setMinWidth(100);
            tblItensConta.getColumnModel().getColumn(2).setMinWidth(150);
            tblItensConta.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblItensConta.getColumnModel().getColumn(2).setMaxWidth(150);
            tblItensConta.getColumnModel().getColumn(3).setMinWidth(100);
            tblItensConta.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItensConta.getColumnModel().getColumn(3).setMaxWidth(100);
            tblItensConta.getColumnModel().getColumn(4).setMinWidth(150);
            tblItensConta.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblItensConta.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 1080, 150));

        tfdQtd.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdQtd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdQtd.setText("1");
        jPanel2.add(tfdQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 140, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Quantidade: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 110, 30));

        jLabel7.setText("Itens da conta: ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        btnVendaAVista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pagar.png"))); // NOI18N
        btnVendaAVista.setText("Venda à Vista");
        btnVendaAVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaAVistaActionPerformed(evt);
            }
        });
        jPanel2.add(btnVendaAVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 590, 160, 40));

        tfdBuscaItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdBuscaItemKeyPressed(evt);
            }
        });
        jPanel2.add(tfdBuscaItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 570, 40));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/seta_atraz_32px.png"))); // NOI18N
        jButton5.setText("Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, 120, 40));

        btnPesquisaItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa.png"))); // NOI18N
        btnPesquisaItem.setText("Pesquisar");
        btnPesquisaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaItemActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisaItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 150, 40));

        tblItensBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItensBusca.setRowHeight(35);
        tblItensBusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblItensBuscaFocusLost(evt);
            }
        });
        tblItensBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItensBuscaMouseClicked(evt);
            }
        });
        tblItensBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblItensBuscaKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(tblItensBusca);
        if (tblItensBusca.getColumnModel().getColumnCount() > 0) {
            tblItensBusca.getColumnModel().getColumn(0).setMinWidth(90);
            tblItensBusca.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblItensBusca.getColumnModel().getColumn(0).setMaxWidth(90);
            tblItensBusca.getColumnModel().getColumn(2).setMinWidth(150);
            tblItensBusca.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblItensBusca.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 690, 110));

        jLabel11.setText("Valor Total: ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 510, -1, -1));

        tfdValorTotal.setEditable(false);
        tfdValorTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdValorTotal.setText("0");
        jPanel2.add(tfdValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 530, 100, 40));

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jPanel2.add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, -1, 40));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("Adicionar Itens");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        cbPesquisaItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descricao", "ID" }));
        jPanel2.add(cbPesquisaItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 110, 40));

        btnCrediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nota.png"))); // NOI18N
        btnCrediario.setText("Crediário");
        btnCrediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrediarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrediario, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 590, 130, 40));

        tabelaServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID AGENDAMENTO", "ID SERVIÇO", "DESCRIÇÃO", "ANIMAL", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaServicos.setOpaque(false);
        tabelaServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaServicosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaServicos);
        if (tabelaServicos.getColumnModel().getColumnCount() > 0) {
            tabelaServicos.getColumnModel().getColumn(0).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaServicos.getColumnModel().getColumn(1).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(1).setPreferredWidth(10);
            tabelaServicos.getColumnModel().getColumn(2).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelaServicos.getColumnModel().getColumn(3).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabelaServicos.getColumnModel().getColumn(4).setResizable(false);
            tabelaServicos.getColumnModel().getColumn(4).setPreferredWidth(15);
        }

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 690, 110));

        jLabel18.setFont(new java.awt.Font("DialogInput", 1, 17)); // NOI18N
        jLabel18.setText("Adicionar Serviços");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        jbaddServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/criar.png"))); // NOI18N
        jbaddServico.setText("Adicionar");
        jbaddServico.setEnabled(false);
        jbaddServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbaddServicoActionPerformed(evt);
            }
        });
        jPanel2.add(jbaddServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 140, 40));

        tabPane.addTab("Itens", jPanel2);

        jPanel3.setBackground(new java.awt.Color(237, 237, 247));

        jLabel8.setText("Valor da venda: ");

        tfdVvenda.setEditable(false);
        tfdVvenda.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdVvenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdVvenda.setText("0");
        tfdVvenda.setToolTipText("");
        tfdVvenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdVvendaActionPerformed(evt);
            }
        });

        jLabel9.setText("Valor Pago: ");

        tfdVpago.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdVpago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdVpago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfdVpagoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdVpagoFocusLost(evt);
            }
        });
        tfdVpago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdVpagoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfdVpagoMouseExited(evt);
            }
        });
        tfdVpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdVpagoActionPerformed(evt);
            }
        });
        tfdVpago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdVpagoKeyPressed(evt);
            }
        });

        jLabel10.setText("Valor do Troco:");

        tfdTroco.setEditable(false);
        tfdTroco.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdTroco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdTrocoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancela.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnFinalizarAV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_3621.png"))); // NOI18N
        btnFinalizarAV.setText("Finalizar");
        btnFinalizarAV.setEnabled(false);
        btnFinalizarAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarAVActionPerformed(evt);
            }
        });
        btnFinalizarAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnFinalizarAVKeyPressed(evt);
            }
        });

        tfdDesconto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdDesconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdDesconto.setText("0.00");
        tfdDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfdDescontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdDescontoFocusLost(evt);
            }
        });
        tfdDesconto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdDescontoMouseClicked(evt);
            }
        });
        tfdDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdDescontoKeyPressed(evt);
            }
        });

        jLabel12.setText("Desconto (%) :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfdVvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdVpago, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(133, 133, 133))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfdTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnFinalizarAV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(1, 1, 1)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(517, 517, 517)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(509, 509, 509)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(511, 511, 511)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(jLabel10)))
                .addContainerGap(444, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfdDesconto, tfdTroco, tfdVpago, tfdVvenda});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdVvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfdVpago, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel12)
                .addGap(12, 12, 12)
                .addComponent(tfdDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarAV))
                .addGap(46, 46, 46))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfdDesconto, tfdTroco, tfdVpago, tfdVvenda});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnFinalizarAV});

        tabPane.addTab("Pagamento AV", jPanel3);

        jPanel5.setBackground(new java.awt.Color(237, 237, 247));

        tblParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Parcela", "Valor Parcela"
            }
        ));
        tblParcelas.setRowHeight(35);
        jScrollPane3.setViewportView(tblParcelas);

        jLabel15.setText("Quant de parcelas: ");

        tfdNrParcelas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdNrParcelas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdNrParcelas.setText("1");
        tfdNrParcelas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfdNrParcelasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdNrParcelasFocusLost(evt);
            }
        });
        tfdNrParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdNrParcelasKeyPressed(evt);
            }
        });

        btnParcelar.setText("Parcelar");
        btnParcelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParcelarActionPerformed(evt);
            }
        });

        btnFinalizarCred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_3621.png"))); // NOI18N
        btnFinalizarCred.setText("Finalizar");
        btnFinalizarCred.setEnabled(false);
        btnFinalizarCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCredActionPerformed(evt);
            }
        });

        btnCancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancela.png"))); // NOI18N
        btnCancelar2.setText("Cancelar");
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Valor de Entrada: ");

        tfdEntrada.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdEntrada.setText("0.00");
        tfdEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfdEntradaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdEntradaFocusLost(evt);
            }
        });
        tfdEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdEntradaKeyPressed(evt);
            }
        });

        jLabel17.setText("Valor da Venda: ");

        tfdValorVenda.setEditable(false);
        tfdValorVenda.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdValorVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar2)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizarCred))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(tfdValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(107, 107, 107)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(tfdEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(96, 96, 96)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(tfdNrParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnParcelar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfdEntrada, tfdNrParcelas, tfdValorVenda});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar2, btnFinalizarCred});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnParcelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdNrParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarCred)
                    .addComponent(btnCancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfdEntrada, tfdNrParcelas});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar2, btnFinalizarCred});

        tabPane.addTab("Pagamento Cred", jPanel5);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancela.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdBairroActionPerformed

    }//GEN-LAST:event_tfdBairroActionPerformed

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        int linhaselec = tblItensBusca.getSelectedRow();
        if (linhaselec != -1) {
            populaTabelaItensConta();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado!");
        }

    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void tfdTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdTrocoActionPerformed

    }//GEN-LAST:event_tfdTrocoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpaTabelaItensConta();
        tabPane.setSelectedIndex(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnPesquisaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaItemActionPerformed
        if (cbPesquisaItem.getSelectedItem().toString().equals("ID")) {
            if (!tfdBuscaItem.getText().isEmpty()) {
                lerTabelaItensBuscaID();
            } else {
                JOptionPane.showMessageDialog(null, "Campo vazio!");
            }
        } else {
            lerTabelaItensBuscaporDesc();
        }
    }//GEN-LAST:event_btnPesquisaItemActionPerformed

    private void tblItensBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItensBuscaMouseClicked
        btnAdicionarItem.setEnabled(true);
    }//GEN-LAST:event_tblItensBuscaMouseClicked

    private void tblItensBuscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblItensBuscaFocusLost

    }//GEN-LAST:event_tblItensBuscaFocusLost

    private void tfdVvendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdVvendaActionPerformed

    }//GEN-LAST:event_tfdVvendaActionPerformed

    private void btnVendaAVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaAVistaActionPerformed
        if (tblItensConta.getRowCount() > 0) {
            tfdVvenda.setText(tfdValorTotal.getText());
            tabPane.setSelectedIndex(2);
            tfdVpago.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Adicione um item!");
        }


    }//GEN-LAST:event_btnVendaAVistaActionPerformed

    private void tfdVpagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdVpagoKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                float valorpago = Float.parseFloat(tfdVpago.getText());
                float valorvenda = Float.parseFloat(tfdVvenda.getText());
                if (valorpago < valorvenda) {
                    JOptionPane.showMessageDialog(null, "Valor pago inferior ao valor da venda!");
                    tfdTroco.setText("");
                    btnFinalizarAV.setEnabled(false);
                } else {
                    calculaTroco();
                    tfdDesconto.requestFocus();
                    btnFinalizarAV.setEnabled(true);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido!");
        }


    }//GEN-LAST:event_tfdVpagoKeyPressed

    private void tfdVpagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdVpagoFocusLost
        if (tfdVpago.getText().isEmpty()) {
            tfdVpago.setText("0.00");
        }
    }//GEN-LAST:event_tfdVpagoFocusLost

    private void tfdBuscaItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdBuscaItemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnPesquisaItem.doClick();
        } else {
            if (cbPesquisaItem.getSelectedItem().toString().equals("Descricao")) {
                lerTabelaItensBuscaporDesc();
            }
        }
    }//GEN-LAST:event_tfdBuscaItemKeyPressed

    private void btnProx1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProx1ActionPerformed
        
        verificaExistAgendamento();
        agendamentos = new ArrayList<>();
        
 
       
    }//GEN-LAST:event_btnProx1ActionPerformed

    private void tblItensBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblItensBuscaKeyPressed

    }//GEN-LAST:event_tblItensBuscaKeyPressed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if(tblClientes.getSelectedRowCount() > 0){
            setarCampos();
            btnProx1.setEnabled(true);
        }else{
            btnProx1.setEnabled(false);
        }
       

    }//GEN-LAST:event_tblClientesMouseClicked
    private void removerServico(int linha){
        String aux1 = tblItensConta.getValueAt(linha, 1).toString();
        int cod = -1;
        for(int x=0; x<tabelaServicos.getRowCount();x++){
            String aux2 = tabelaServicos.getValueAt(x, 2).toString();
            if(aux1.equals(aux2)){
                cod = Integer.parseInt(tabelaServicos.getValueAt(x, 0).toString());
                break;
            }
        }
        if(cod != -1){
        Iterator i = agendamentos.iterator();
        
            while(i.hasNext()){
                Integer a = (Integer) i.next();
                if(a == cod){
                    i.remove();
                }
            }
        }
        
    }
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int linhaselec = tblItensConta.getSelectedRow();
        if (linhaselec != -1) {
            removerServico(linhaselec);
            ((DefaultTableModel) tblItensConta.getModel()).removeRow(linhaselec);
       
            somaItens();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado! ");
        }


    }//GEN-LAST:event_btnRemoverActionPerformed

    private void tblItensContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItensContaMouseClicked
        btnRemover.setEnabled(true);
    }//GEN-LAST:event_tblItensContaMouseClicked

    private void tfdVpagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdVpagoMouseClicked
        tfdVpago.setText("");
    }//GEN-LAST:event_tfdVpagoMouseClicked

    private void tfdVpagoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdVpagoMouseExited

    }//GEN-LAST:event_tfdVpagoMouseExited

    private void tfdVpagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdVpagoFocusGained

    }//GEN-LAST:event_tfdVpagoFocusGained

    private void tfdDescontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdDescontoMouseClicked
        tfdDesconto.setText("");
    }//GEN-LAST:event_tfdDescontoMouseClicked

    private void tfdDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdDescontoFocusLost
        if (tfdDesconto.getText().isEmpty()) {
            tfdDesconto.setText("0.00");
        }
    }//GEN-LAST:event_tfdDescontoFocusLost

    private void btnPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaClienteActionPerformed
        if (cbPesquisaCliente.getSelectedItem().toString().equals("Nome")) {
            populaTabelaClientesBuscaporNome();
        } else if (cbPesquisaCliente.getSelectedItem().toString().equals("CPF")) {
            populaTabelaClienteBuscaporCPF();
        } else {
            populaTabelaClienteBuscaporCNPJ();
        }
    }//GEN-LAST:event_btnPesquisaClienteActionPerformed

    private void tblClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClientesKeyReleased
        setarCampos();
    }//GEN-LAST:event_tblClientesKeyReleased

    private void tfdDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdDescontoKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (!tfdVpago.getText().isEmpty()) {
                    float valorpago = Float.parseFloat(tfdVpago.getText());
                    float valorvenda = Float.parseFloat(tfdVvenda.getText());
                    if (valorpago < valorvenda) {
                        JOptionPane.showMessageDialog(null, "Valor pago inferior ao valor da venda!");
                        tfdTroco.setText("");
                        btnFinalizarAV.setEnabled(false);
                    } else {
                        calculaTroco();
                        btnFinalizarAV.setEnabled(true);
                        btnFinalizarAV.requestFocus();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido!");
        }

    }//GEN-LAST:event_tfdDescontoKeyPressed

    private void btnFinalizarAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarAVActionPerformed
        salvarConta("av");
    }//GEN-LAST:event_btnFinalizarAVActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tfdVpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdVpagoActionPerformed

    }//GEN-LAST:event_tfdVpagoActionPerformed

    private void tblClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClientesKeyPressed

    }//GEN-LAST:event_tblClientesKeyPressed

    private void tfdBuscaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdBuscaClienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnPesquisaCliente.doClick();
        }
        if (cbPesquisaCliente.getSelectedItem().toString().equals("Nome")) {
            populaTabelaClientesBuscaporNome();
        }
    }//GEN-LAST:event_tfdBuscaClienteKeyPressed

    private void cbPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPesquisaClienteActionPerformed

    }//GEN-LAST:event_cbPesquisaClienteActionPerformed

    private void btnCrediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrediarioActionPerformed

        if (tblItensConta.getRowCount() > 0) {
            tabPane.setSelectedIndex(3);
            tfdValorVenda.setText(tfdValorTotal.getText());
            tfdNrParcelas.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Adicione um item!");
        }

    }//GEN-LAST:event_btnCrediarioActionPerformed

    private void btnParcelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParcelarActionPerformed
        try {
            float valorDaVenda, entrada;
            valorDaVenda = Float.parseFloat(tfdValorTotal.getText().toString());
            entrada = Float.parseFloat(tfdEntrada.getText().toString());
            if (entrada > valorDaVenda) {
                JOptionPane.showMessageDialog(null, "Valor da entrada maior que o valor da venda! ");
            } else {
                lerTabelaParcelas();
                btnFinalizarCred.setEnabled(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Número de parcelas inválido! " + e.getMessage());
        }

    }//GEN-LAST:event_btnParcelarActionPerformed

    private void btnFinalizarCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCredActionPerformed
        salvarConta("cred");
    }//GEN-LAST:event_btnFinalizarCredActionPerformed

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    private void tfdDescontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdDescontoFocusGained
        tfdDesconto.setText("");
    }//GEN-LAST:event_tfdDescontoFocusGained

    private void btnFinalizarAVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnFinalizarAVKeyPressed

    }//GEN-LAST:event_btnFinalizarAVKeyPressed

    private void tfdEntradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdEntradaFocusGained
        tfdEntrada.setText("");
    }//GEN-LAST:event_tfdEntradaFocusGained

    private void tfdEntradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdEntradaFocusLost
        if (tfdEntrada.getText().isEmpty()) {
            tfdEntrada.setText("");
        }
    }//GEN-LAST:event_tfdEntradaFocusLost

    private void tfdNrParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdNrParcelasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnParcelar.requestFocus();
        }
    }//GEN-LAST:event_tfdNrParcelasKeyPressed

    private void tfdEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdEntradaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           tfdNrParcelas.requestFocus();
        }
    }//GEN-LAST:event_tfdEntradaKeyPressed

    private void tfdNrParcelasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdNrParcelasFocusLost
        if (tfdNrParcelas.getText().isEmpty()){
            tfdNrParcelas.setText("1");
        }
    }//GEN-LAST:event_tfdNrParcelasFocusLost

    private void tfdNrParcelasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdNrParcelasFocusGained
        tfdNrParcelas.setText("");
    }//GEN-LAST:event_tfdNrParcelasFocusGained
    public boolean verificarServicoIncluso(int linha){
        for(Integer i: agendamentos){
            if(Objects.equals(i, tabelaServicos.getValueAt(linha, 0))){
                return false;
            }
        }
        return true;
    }
    
    private void jbaddServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbaddServicoActionPerformed
       DefaultTableModel modelo = (DefaultTableModel) tabelaServicos.getModel();
        if(tabelaServicos.getSelectedRowCount() > 0){
            int linha = tabelaServicos.getSelectedRow();
            if(verificarServicoIncluso(linha)){
            populaTabelaItensContaServico();
            agendamentos.add(Integer.parseInt(tabelaServicos.getValueAt(linha, 0).toString()));
            }else{
                JOptionPane.showMessageDialog(null, "Serviço já selecionado");
            }
        }
    }//GEN-LAST:event_jbaddServicoActionPerformed

    private void tabelaServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaServicosMouseClicked
       if(tabelaServicos.getSelectedRowCount() > 0){
           jbaddServico.setEnabled(true);
       }
       else{
           jbaddServico.setEnabled(false);
       }
    }//GEN-LAST:event_tabelaServicosMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        telaAgenda.setVisible(true);
        telaAgenda.atualizaTabela();
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnCrediario;
    private javax.swing.JButton btnFinalizarAV;
    private javax.swing.JButton btnFinalizarCred;
    private javax.swing.ButtonGroup btnGrupoCli;
    private javax.swing.ButtonGroup btnGrupoItens;
    private javax.swing.JButton btnParcelar;
    private javax.swing.JButton btnPesquisaCliente;
    private javax.swing.JButton btnPesquisaItem;
    private javax.swing.JButton btnProx1;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVendaAVista;
    private javax.swing.JComboBox<String> cbPesquisaCliente;
    private javax.swing.JComboBox<String> cbPesquisaItem;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton jbaddServico;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTable tabelaServicos;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblItensBusca;
    private javax.swing.JTable tblItensConta;
    private javax.swing.JTable tblParcelas;
    private javax.swing.JTextField tfdBairro;
    private javax.swing.JTextField tfdBuscaCliente;
    private javax.swing.JTextField tfdBuscaItem;
    private javax.swing.JTextField tfdDesconto;
    private javax.swing.JTextField tfdEntrada;
    private javax.swing.JTextField tfdID;
    private javax.swing.JTextField tfdMunicipio;
    private javax.swing.JTextField tfdNrParcelas;
    private javax.swing.JTextField tfdQtd;
    private javax.swing.JTextField tfdRua;
    private javax.swing.JTextField tfdTelefone;
    private javax.swing.JTextField tfdTroco;
    private javax.swing.JTextField tfdValorTotal;
    private javax.swing.JTextField tfdValorVenda;
    private javax.swing.JTextField tfdVpago;
    private javax.swing.JTextField tfdVvenda;
    private javax.swing.JTextField tfdnro;
    // End of variables declaration//GEN-END:variables
}
