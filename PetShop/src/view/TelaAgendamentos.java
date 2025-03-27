
package view;

import controller.ManipularImagem;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javafx.scene.input.DataFormat;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.Animal;
import model.Cliente;
import model.Fisica;
import model.Juridica;
import model.Profissional;
import model.Servico;
import modelDAO.AgendaDAO;
import modelDAO.AnimalDAO;
import modelDAO.ClienteDAO;
import modelDAO.ItensDAO;


public class TelaAgendamentos extends javax.swing.JInternalFrame {
    ArrayList<Profissional> selecionados;
    DefaultListModel modeloCel;
    DefaultTableModel modelotabelaclientes;
    ArrayList<Cliente> Todosclientes ;
    ArrayList<Cliente> ResultPesquisaclientes ;
    ArrayList<Servico> ResultPesquisaServico ;
    ClienteDAO cliDao;
    DefaultListModel modeloProfissionaisDoServico;
    ArrayList<Animal> animais ;
    DefaultTableModel modelotabelaServico;
    DefaultListModel modeloDisp;
    DefaultTableModel modeloTabelaAgendamentos;
    ItensDAO itDao;
    ArrayList<Profissional> disponiveis = null;
    private AgendaDAO agDao;
    TelaPrincipal tp;
    public TelaAgendamentos(TelaPrincipal tp) {
        selecionados = new ArrayList<>();
        modeloCel = new DefaultListModel();
        cliDao = new ClienteDAO();
        initComponents();
        Todosclientes = cliDao.listar();
        lerTabelaCliente(Todosclientes);
        modeloProfissionaisDoServico = new  DefaultListModel();
        itDao = new ItensDAO();
        modelotabelaServico = (DefaultTableModel) tabelaServico.getModel();
        modeloDisp = new DefaultListModel();
        agDao = new AgendaDAO();
        estadoInicialTela2();
        this.tp = tp;
       
        
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tabelpane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        filtroTipoBusca = new javax.swing.JComboBox<>();
        tfpesquisaAgendamento = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        dataFinal = new com.toedter.calendar.JDateChooser();
        dataInicial = new com.toedter.calendar.JDateChooser();
        inicial = new javax.swing.JCheckBox();
        fim = new javax.swing.JCheckBox();
        statusPagamento = new javax.swing.JComboBox<>();
        statusServico = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAgendamentos = new javax.swing.JTable();
        jbFaturar = new javax.swing.JButton();
        jbAlterarStatus = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfdCliente = new javax.swing.JTextField();
        tfdAnimal = new javax.swing.JTextField();
        tfServico = new javax.swing.JTextField();
        tfdID = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfProfissionais = new javax.swing.JTextField();
        btnAlterarData = new javax.swing.JButton();
        tfPreco = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnSalvarED = new javax.swing.JButton();
        listaNovaHora = new javax.swing.JComboBox<>();
        novaData = new com.toedter.calendar.JDateChooser();
        jbcancelarAgendamento = new javax.swing.JButton();
        painelAgendamento = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        filtroPesquisaCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jbPesquisar = new javax.swing.JButton();
        tfPesquisa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        listaAnimaisCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        labelFoto = new javax.swing.JLabel();
        tfDataNasc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfAltura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfPeso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfRaca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jbcancelar = new javax.swing.JButton();
        jbConfirmar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaServico = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        filtroServicos = new javax.swing.JComboBox<>();
        tfpesquisaServico = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaDisponiveis = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaescolhidos = new javax.swing.JList<>();
        adicionar = new javax.swing.JButton();
        retirar = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        listaHora = new javax.swing.JComboBox<>();
        dataRealizar = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar")));

        filtroTipoBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Serviço", "Animal" }));

        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        inicial.setSelected(true);
        inicial.setText("Inicial");
        inicial.setHideActionText(true);
        inicial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inicial.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        fim.setText("Final");
        fim.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        statusPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Faturado", "Não Faturado" }));

        statusServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Aguardando", "Atrasado", "Realizados" }));

        jLabel5.setText("Status Pagamento");

        jLabel6.setText("Status Serviço");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inicial)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(fim)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filtroTipoBusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfpesquisaAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(statusServico, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filtroTipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfpesquisaAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(inicial)
                                .addGap(4, 4, 4)
                                .addComponent(fim, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Cliente", "Animal", "Serviço", "Faturado", "Status Serviço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAgendamentos.getTableHeader().setReorderingAllowed(false);
        tabelaAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAgendamentosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaAgendamentos);
        if (tabelaAgendamentos.getColumnModel().getColumnCount() > 0) {
            tabelaAgendamentos.getColumnModel().getColumn(0).setResizable(false);
            tabelaAgendamentos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabelaAgendamentos.getColumnModel().getColumn(1).setPreferredWidth(30);
            tabelaAgendamentos.getColumnModel().getColumn(2).setPreferredWidth(120);
            tabelaAgendamentos.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabelaAgendamentos.getColumnModel().getColumn(4).setPreferredWidth(50);
            tabelaAgendamentos.getColumnModel().getColumn(5).setPreferredWidth(5);
            tabelaAgendamentos.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        jbFaturar.setText("Faturar");
        jbFaturar.setEnabled(false);
        jbFaturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFaturarActionPerformed(evt);
            }
        });

        jbAlterarStatus.setText("Alterar Status para Realizado");
        jbAlterarStatus.setEnabled(false);
        jbAlterarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarStatusActionPerformed(evt);
            }
        });

        jButton5.setText("Novo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Serviço"));

        jLabel15.setText("Cliente:");

        jLabel16.setText("Animal:");

        jLabel18.setText("Serviço:");

        jLabel19.setText("Data / Hora");

        tfdCliente.setEditable(false);

        tfdAnimal.setEditable(false);
        tfdAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdAnimalActionPerformed(evt);
            }
        });

        tfServico.setEditable(false);

        tfdID.setEditable(false);
        tfdID.setForeground(new java.awt.Color(0, 51, 51));

        jLabel21.setText("ID:");

        jLabel20.setText("Profissionais:");

        btnAlterarData.setText("Alterar Data");
        btnAlterarData.setEnabled(false);
        btnAlterarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDataActionPerformed(evt);
            }
        });

        tfPreco.setEditable(false);
        tfPreco.setForeground(new java.awt.Color(0, 51, 51));

        jLabel22.setText("Valor:");

        btnSalvarED.setText("Salvar");
        btnSalvarED.setEnabled(false);
        btnSalvarED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(tfdCliente))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(80, 80, 80)
                                .addComponent(tfdID, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(tfdAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(tfServico, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfPreco)
                                    .addComponent(novaData, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(listaNovaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfProfissionais, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(btnAlterarData, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSalvarED, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel21))
                    .addComponent(tfdID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel16))
                    .addComponent(tfdAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(novaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(listaNovaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAlterarData, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSalvarED, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(tfProfissionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbcancelarAgendamento.setText("Cancelar Agendamento");
        jbcancelarAgendamento.setEnabled(false);
        jbcancelarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarAgendamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbFaturar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbcancelarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAlterarStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1202, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAlterarStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbFaturar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbcancelarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        tabelpane.addTab("Agenda", jPanel1);

        painelAgendamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        filtroPesquisaCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Cpf", "Cnpj" }));
        filtroPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroPesquisaClienteActionPerformed(evt);
            }
        });

        jLabel7.setText("Pesquisar por:");

        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyReleased(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Animal"));

        listaAnimaisCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaAnimaisClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Data Nasc:");

        labelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/8f95d343cb060aa025d9b61ea901b223.jpg"))); // NOI18N

        jLabel3.setText("Altura");

        jLabel2.setText("Peso:");

        jLabel4.setText("Raça:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listaAnimaisCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRaca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(listaAnimaisCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))))
        );

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Cpf", "Cnpj"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);
        if (tabelaCliente.getColumnModel().getColumnCount() > 0) {
            tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(500);
            tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(17, 17, 17)
                        .addComponent(filtroPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbPesquisar))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(filtroPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        painelAgendamento.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1220, 280));

        jbcancelar.setText("Cancelar");
        jbcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelarActionPerformed(evt);
            }
        });
        painelAgendamento.add(jbcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 650, 170, 40));

        jbConfirmar.setText("Confirmar");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });
        painelAgendamento.add(jbConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 650, 156, 40));

        tabelaServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID SERVIÇO", "DESCRIÇÃO", "PREÇO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaServicoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaServico);
        if (tabelaServico.getColumnModel().getColumnCount() > 0) {
            tabelaServico.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaServico.getColumnModel().getColumn(1).setPreferredWidth(400);
            tabelaServico.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        painelAgendamento.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 1220, 140));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Selecionar Serviço")));

        filtroServicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descrição", "Código" }));

        tfpesquisaServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfpesquisaServicoKeyReleased(evt);
            }
        });

        jButton3.setText("pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(filtroServicos, 0, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfpesquisaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filtroServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfpesquisaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAgendamento.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1220, 80));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Escolher Profissional"));

        jLabel13.setText("Disponiveis");

        listaDisponiveis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaDisponiveis.setVisibleRowCount(4);
        listaDisponiveis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listaDisponiveisFocusGained(evt);
            }
        });
        listaDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaDisponiveisMouseClicked(evt);
            }
        });
        listaDisponiveis.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaDisponiveisValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(listaDisponiveis);

        jLabel14.setText("Escolhido(s)");

        listaescolhidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                listaescolhidosFocusLost(evt);
            }
        });
        listaescolhidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaescolhidosMouseClicked(evt);
            }
        });
        listaescolhidos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaescolhidosValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(listaescolhidos);

        adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/seta_frente_32px.png"))); // NOI18N
        adicionar.setEnabled(false);
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        retirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/seta_atraz_32px.png"))); // NOI18N
        retirar.setEnabled(false);
        retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(103, 103, 103))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        painelAgendamento.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 600, 170));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Agendamento"));

        listaHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "15:00", "16:00", "17:00", "18:00" }));

        jLabel12.setText("Dia");

        jLabel17.setText("Hora");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataRealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataRealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        painelAgendamento.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, 610, 110));

        tabelpane.addTab("Agendamento", painelAgendamento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelpane, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelpane, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void prencherTabelaAgendamentos(ArrayList<Agendamento> agds){
      Collections.sort(agds);
      modeloTabelaAgendamentos = (DefaultTableModel) tabelaAgendamentos.getModel();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String status, pagamento;
        modeloTabelaAgendamentos.setNumRows(0);
        for(Agendamento ag : agds){
           
            if(ag.getStatusPagamento().equals("npago")){
                pagamento = "Não";
            }
            else{
                pagamento = "Sim";
            }
            
            if(ag.getStatusServico().equals("realizado")){
                status = "Realizado";
            }
            else{
                if(ag.getDataRealizacao().isAfter(LocalDateTime.now()) || ag.getDataRealizacao().isEqual(LocalDateTime.now()) ){
                    status = "Aguardando";
                }
                else{
                    status= "Atrasado";
                }
            }
            
            modeloTabelaAgendamentos.addRow(new Object[]{
                ag.getIdAgendamento(),
                ag.getDataRealizacao().format(formatter),
                ag.getCli().getNome(),
                ag.getAnimal().getNome(),
                ag.getServico().getDescricao(),
                pagamento,
                status
                });
            
        }
     
    }
    
    private void retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarActionPerformed
        int ind = listaescolhidos.getSelectedIndex();
        Profissional s = selecionados.get(ind);
        
        if(listaescolhidos.getModel().getSize() > 1){
        if(ind > 0){
            listaescolhidos.setSelectedIndex(ind-1);
           
        }else{
            listaescolhidos.setSelectedIndex(ind+1);
           
        }
        }
        else{
            retirar.setEnabled(false);
        }
        disponiveis.add(s);
        selecionados.remove(ind);
        modeloCel.remove(ind);
        modeloDisp.addElement(s.getNome());
    }//GEN-LAST:event_retirarActionPerformed

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        listaescolhidos.setModel(modeloCel);
        Profissional s = disponiveis.get(listaDisponiveis.getSelectedIndex());
        selecionados.add(s);
        modeloCel.addElement(s.getNome());
        int ind = listaDisponiveis.getSelectedIndex();
        if(listaDisponiveis.getModel().getSize() > 1){
        if(ind > 0){
            listaDisponiveis.setSelectedIndex(ind-1);
            
        }else{
            listaDisponiveis.setSelectedIndex(ind+1);
         
        }
        }
        else{
            adicionar.setEnabled(false);
        }
        modeloDisp.remove(ind);
        disponiveis.remove(ind);
        
    }//GEN-LAST:event_adicionarActionPerformed

    private void listaescolhidosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaescolhidosValueChanged
        if (!listaescolhidos.isSelectionEmpty()) {
            Profissional p = selecionados.get(listaescolhidos.getSelectedIndex());
           
            adicionar.setEnabled(false);
            retirar.setEnabled(true);
        } else {
            adicionar.setEnabled(false);
            
        }
    }//GEN-LAST:event_listaescolhidosValueChanged

    private void listaescolhidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaescolhidosMouseClicked

    }//GEN-LAST:event_listaescolhidosMouseClicked

    private void listaescolhidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaescolhidosFocusLost

    }//GEN-LAST:event_listaescolhidosFocusLost
    
    private void listaDisponiveisValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaDisponiveisValueChanged
        if (!listaDisponiveis.isSelectionEmpty()) {
            Profissional p = disponiveis.get(listaDisponiveis.getSelectedIndex());
          
            
            adicionar.setEnabled(true);
            retirar.setEnabled(false);
        } else {
            adicionar.setEnabled(false);
         
        }
    }//GEN-LAST:event_listaDisponiveisValueChanged

    private void listaDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaDisponiveisMouseClicked
       
    }//GEN-LAST:event_listaDisponiveisMouseClicked

    private void listaDisponiveisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaDisponiveisFocusGained

    }//GEN-LAST:event_listaDisponiveisFocusGained

    private boolean verificar(ArrayList<Profissional> prs, LocalDateTime d){
       
        
       for(Profissional p : prs){
           if(!agDao.verificarDisponibilidade(d, p.getId())){
               return false;
           }
       }
       return true;
    }
    private boolean  verificarData(){
        try{
        DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        String data = formater.format(dataRealizar.getDate());
        return true;
        }catch(Exception e){
        return false;
        }
    }
    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        if(listaAnimaisCliente.getItemCount() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum animal Selecionado!!");
        }else if(tabelaCliente.getSelectedRowCount() < 1){
            JOptionPane.showMessageDialog(null, "Nenhum cliente Selecionado!!");
        }else if(selecionados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum profissional Selecionado!!");
        }else if(tabelaServico.getSelectedRowCount() < 1){
            JOptionPane.showMessageDialog(null, "Nenhum Serviço Selecionado!!");
        }else if(!verificarData()){
            JOptionPane.showMessageDialog(null, "Data inválida!!");
        }
        else{
        Agendamento ag = new Agendamento();
        int ind = listaAnimaisCliente.getSelectedIndex();
        if(!animais.isEmpty()){
            ag.setAnimal(animais.get(ind));
        }
        int idCliente = Integer.parseInt(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(),0).toString());
        ag.setCli(cliDao.retornaClienteID(idCliente));
        ag.setProfissonais(selecionados);
        int id = Integer.parseInt(tabelaServico.getValueAt(tabelaServico.getSelectedRow(), 0).toString());
        ag.setServico(itDao.pesquisaServicoPorCodigo(id));
        ag.setDataGendamento(LocalDateTime.now());
        DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        String data = formater.format(dataRealizar.getDate());
        data = data +" " + listaHora.getSelectedItem();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ag.setDataRealizacao(LocalDateTime.parse(data, formatter));
        
        if(!verificar(selecionados, ag.getDataRealizacao())){
            JOptionPane.showMessageDialog(null, "Profissional(s) estará ocupado no horario escolhido");
            
        }else{
        if(!ag.getDataRealizacao().isAfter(LocalDateTime.now())){
            JOptionPane.showMessageDialog(null, "Defina uma data posterior a agora");
        }else{
            agDao.incluirAgendamento(ag);
            JOptionPane.showMessageDialog(null, "Agendamento concluído");
           
            estadoInicialTela2();
            
        }
        }
        
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed
    private void estadoInicialTela2(){
        ArrayList<Agendamento> ags = agDao.listaTodos();
        dataInicial.setDate(Date.valueOf(LocalDate.now()));
        dataFinal.setDate(Date.valueOf(LocalDate.now()));
        configurarDataInicial(ags);
        prencherTabelaAgendamentos(ags);
        tabelpane.setEnabledAt(1, false);
        listaAnimaisCliente.setEnabled(false);
        tfAltura.setEditable(false);
        tfDataNasc.setEditable(false);
        tfPeso.setEditable(false);
        tfRaca.setEditable(false);
        modelotabelaServico.setNumRows(0);
        modeloCel.setSize(0);
        modeloDisp.setSize(0);
        modelotabelaclientes.setNumRows(0);
        tfAltura.setText("");
        tfDataNasc.setText("");
        tfPeso.setText("");
        tfRaca.setText("");
        selecionados = new ArrayList<>();
        disponiveis = new ArrayList<>();
        tabelpane.setSelectedIndex(0);
        btnSalvarED.setVisible(false);
        
    }
    private void jbcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarActionPerformed
        estadoInicialTela2();
    }//GEN-LAST:event_jbcancelarActionPerformed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        if(tabelaCliente.getSelectedRowCount() > 0){
            setarListaAnimaisCliente();
        }
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased

        if (tfPesquisa.getText().isEmpty()) {
            modelotabelaclientes.setNumRows(0);
            lerTabelaCliente(Todosclientes);

        } else {
            if (filtroPesquisaCliente.getSelectedIndex() == 0) {
                ResultPesquisaclientes = cliDao.retornaClienteNome(tfPesquisa.getText());

            } else if (filtroPesquisaCliente.getSelectedIndex() == 1) {
                ResultPesquisaclientes = cliDao.retornaClientesCpf(tfPesquisa.getText());

            } else {
                ResultPesquisaclientes = cliDao.retornaClientesCnpj(tfPesquisa.getText());
            }
            if(ResultPesquisaclientes.isEmpty()){

            }
            else{
                modelotabelaclientes.setNumRows(0);
                lerTabelaCliente(ResultPesquisaclientes);
            }
        }
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        PesquisarCliente();
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void filtroPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroPesquisaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroPesquisaClienteActionPerformed
    private void configurarDataInicial(ArrayList<Agendamento> ags){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            String data = formater.format(dataInicial.getDate());
            LocalDate dt = LocalDate.parse(data, formatter);
            Iterator i = ags.iterator();
            while(i.hasNext()){
                Agendamento a = (Agendamento) i.next();
                LocalDate dt1 = a.getDataRealizacao().toLocalDate();
                if(dt1.isBefore(dt)){
                    i.remove();
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Inicial Inválida!!");
        }
       
        
    }
    private void configurarDataFinal(ArrayList<Agendamento> ags){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            String data = formater.format(dataFinal.getDate());
            LocalDate dt = LocalDate.parse(data, formatter);
            Iterator i = ags.iterator();
            while(i.hasNext()){
                Agendamento a = (Agendamento) i.next();
                LocalDate dt1 = a.getDataRealizacao().toLocalDate();
                if(dt1.isAfter(dt)){
                    i.remove();
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Final Inválida!!");
        }
       
        
    }
    private void configurarFaturados(ArrayList<Agendamento> ags){
        Iterator i = ags.iterator();
            while(i.hasNext()){
                Agendamento a = (Agendamento) i.next();
                if(a.getStatusPagamento().equals("npago")){
                    i.remove();
                }
            }
    }
     private void configurarNaoFaturados(ArrayList<Agendamento> ags){
        Iterator i = ags.iterator();
            while(i.hasNext()){
                Agendamento a = (Agendamento) i.next();
                if(!a.getStatusPagamento().equals("npago")){
                    i.remove();
                }
            }
    }
    private void configurarAtrasado(ArrayList<Agendamento> ags){
        Iterator i = ags.iterator();
            while(i.hasNext()){
                Agendamento a = (Agendamento) i.next();
                if((a.getDataRealizacao().isAfter(LocalDateTime.now())) || a.getStatusServico().equals("realizado") ){
                      
                         i.remove();
                    }
            }
    }
    private void configurarAguardando(ArrayList<Agendamento> ags){
        Iterator i = ags.iterator();
            while(i.hasNext()){
                Agendamento a = (Agendamento) i.next();
               
                    
                    if((a.getDataRealizacao().isBefore(LocalDateTime.now()) ||a.getDataRealizacao().equals(LocalDate.now())) || a.getStatusServico().equals("realizado") ){
                      
                         i.remove();
                    }
                
            }
    }
    private void configurarRealizado(ArrayList<Agendamento> ags){
        Iterator i = ags.iterator();
            while(i.hasNext()){
                Agendamento a = (Agendamento) i.next();
                if(!a.getStatusServico().equals("realizado")){
                    i.remove();
                }
            }
    }
    public void atualizaTabela(){
        ArrayList<Agendamento> ags = new ArrayList<>();
        if (tfpesquisaAgendamento.getText().isEmpty()) {
            ags = agDao.listaTodos();
        } else {
            if (filtroTipoBusca.getSelectedIndex() == 0) {
                ags = agDao.pesquisarPorNomeCliente(tfpesquisaAgendamento.getText());
            } else if (filtroTipoBusca.getSelectedIndex() == 1) {
                ags = agDao.pesquisarPorServico(tfpesquisaAgendamento.getText());
            } else {
                ags = agDao.pesquisarPorAnimal(tfpesquisaAgendamento.getText());
            }
        }
        
        if(ags.isEmpty()){
            modeloTabelaAgendamentos.setNumRows(0);
        }else{
            if(inicial.isSelected()){
                configurarDataInicial(ags);
            }
            if(fim.isSelected()){
                configurarDataFinal(ags);
            }
            
            if(statusPagamento.getSelectedIndex() == 1){
                configurarFaturados(ags);
            }else if(statusPagamento.getSelectedIndex() == 2){
                configurarNaoFaturados(ags);
            }
            
            
            if(statusServico.getSelectedIndex() == 1){
              
                configurarAguardando(ags);
            }else if(statusServico.getSelectedIndex() == 2){
        
                configurarAtrasado(ags);
            }else if(statusServico.getSelectedIndex() == 3){
      
                configurarRealizado(ags);
            }
            
            prencherTabelaAgendamentos(ags);
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         atualizaTabela();
        jbAlterarStatus.setEnabled(false);
        jbcancelarAgendamento.setEnabled(false);
        jbFaturar.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listaAnimaisClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaAnimaisClienteActionPerformed
        int ind = listaAnimaisCliente.getSelectedIndex();
        if(listaAnimaisCliente.getItemCount() > 0){
        if(!animais.isEmpty()){
            setarDadosAnimal(animais.get(ind));
        }
        }
    }//GEN-LAST:event_listaAnimaisClienteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

            pesquisaServico();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pesquisaServico(){
        ResultPesquisaServico = new ArrayList<>();
         if (tfpesquisaServico.getText().isEmpty()) {
            modelotabelaServico.setNumRows(0);
            lerTabelaServicos(itDao.listarServicosAtivos());

        } else {
            if (filtroServicos.getSelectedIndex() == 0) {
                ResultPesquisaServico = itDao.pesquisaServicoDescricao(tfpesquisaServico.getText());
            
            } else {
                Servico s = itDao.pesquisaServicoPorCodigo(Integer.parseInt(tfpesquisaServico.getText()));
                
                if(s != null)
                    ResultPesquisaServico.add(s);

            }
            
            if(ResultPesquisaServico.isEmpty()){
            
            }
            else{
                
                modelotabelaServico.setNumRows(0);
                lerTabelaServicos(ResultPesquisaServico);
            }
        }
    }
    private void tfpesquisaServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfpesquisaServicoKeyReleased
       pesquisaServico();
    }//GEN-LAST:event_tfpesquisaServicoKeyReleased

    private void setarListaProfissionaisDisponiveis(){
        modeloDisp = null;
        modeloDisp = new DefaultListModel();
        disponiveis = itDao.listaProfissionaisServico(Integer.parseInt(tabelaServico.getValueAt(tabelaServico.getSelectedRow(), 0).toString()));
        for(Profissional p : disponiveis){
           modeloDisp.addElement(p.getNome());
        }
        listaDisponiveis.setModel(modeloDisp);
    }
    
    private void tabelaServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaServicoMouseClicked
        if(tabelaServico.getSelectedRowCount() > 0){
            setarListaProfissionaisDisponiveis();
           modeloCel.removeAllElements();
           selecionados = new ArrayList<>();
        }
    }//GEN-LAST:event_tabelaServicoMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       tabelpane.setSelectedIndex(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tfdAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdAnimalActionPerformed

    }//GEN-LAST:event_tfdAnimalActionPerformed
    public Agendamento retornaAg(){
        if(tabelaAgendamentos.getSelectedRowCount() > 0){
        int id = Integer.parseInt(tabelaAgendamentos.getValueAt(tabelaAgendamentos.getSelectedRow(), 0).toString());
        for(Agendamento a : agDao.listaTodos()){
            if(a.getIdAgendamento() == id){
                return a;
            }
        }
        }
        return null;
    }
    public void setarDadosServico(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        tfdID.setEditable(false);
        tfServico.setEditable(false);
        novaData.setEnabled(false);
        tfPreco.setEditable(false);
        tfProfissionais.setEditable(false);
        tfServico.setEditable(false);
        tfdCliente.setEditable(false);
        tfdAnimal.setEditable(false);
        listaNovaHora.setEnabled(false);
        listaNovaHora.setEditable(false);
        btnSalvarED.setVisible(false);
        Agendamento a = retornaAg();
        if (a != null) {
            tfdID.setText(String.valueOf(a.getIdAgendamento()));
            tfServico.setText(a.getServico().getDescricao());
            Date d = Date.valueOf(a.getDataRealizacao().toLocalDate());
            novaData.setDate(d);
            listaNovaHora.removeAllItems();
            listaNovaHora.addItem(a.getDataRealizacao().toLocalTime().toString());
            tfPreco.setText(String.valueOf(a.getServico().getPreco()));
            String prof = "";
            for (Profissional p : a.getProfissonais()) {
                prof = prof + p.getNome() + ", ";
            }
            tfProfissionais.setText(prof);
            tfServico.setText(a.getServico().getDescricao());
            tfdCliente.setText(a.getCli().getNome());
            tfdAnimal.setText(a.getAnimal().getNome());
            
        }
    }
    private void tabelaAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAgendamentosMouseClicked
         if(tabelaAgendamentos.getSelectedRowCount() > 0){
            setarDadosServico();
            String status = tabelaAgendamentos.getValueAt(tabelaAgendamentos.getSelectedRow(), 6).toString();
            String statusP = tabelaAgendamentos.getValueAt(tabelaAgendamentos.getSelectedRow(), 5).toString();
            
            if(!status.equals("Realizado")){
                jbAlterarStatus.setEnabled(true);
                btnAlterarData.setEnabled(true);
                
                if(!statusP.equals("Sim")){
                    jbcancelarAgendamento.setEnabled(true);
                }else{
                    jbcancelarAgendamento.setEnabled(true);
                }
            }
            else{
                jbAlterarStatus.setEnabled(false);
                jbcancelarAgendamento.setEnabled(false);
                btnAlterarData.setEnabled(false);
            }
            
            if(!statusP.equals("Sim")){
              jbFaturar.setEnabled(true);
              
            }
            else{
                jbFaturar.setEnabled(false);
                jbcancelarAgendamento.setEnabled(false);
            }
        }else{
           jbAlterarStatus.setEnabled(false); 
           jbcancelar.setEnabled(false);
           btnAlterarData.setEnabled(false);
        }
         
    }//GEN-LAST:event_tabelaAgendamentosMouseClicked

    private void jbAlterarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarStatusActionPerformed
        if(tabelaAgendamentos.getSelectedRowCount() > 0){
            if(JOptionPane.showConfirmDialog(null, "Confirma Alteração de status?")== 0 ){
                if(agDao.alterarStatusServico(Integer.parseInt(tabelaAgendamentos.getValueAt(tabelaAgendamentos.getSelectedRow(), 0).toString()))){
                    JOptionPane.showMessageDialog(null, "Status Alterado");
                    btnAlterarData.setEnabled(false);
                    tabelaAgendamentos.setValueAt("Realizado", tabelaAgendamentos.getSelectedRow(), 6);
                }
            }
        }
       
    }//GEN-LAST:event_jbAlterarStatusActionPerformed

    private void jbcancelarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelarAgendamentoActionPerformed
        Agendamento ag = retornaAg();
        if(ag!=null){
        if(JOptionPane.showConfirmDialog(null, "Confirma Cancelamento??") == 0){
            if(agDao.apagar(ag.getIdAgendamento())){
                JOptionPane.showMessageDialog(null, "Cancelado!");
                estadoInicialTela2();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Dados mantidos");
        }
        }
    }//GEN-LAST:event_jbcancelarAgendamentoActionPerformed

    private void btnAlterarDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDataActionPerformed
        novaData.setEnabled(true);
        listaNovaHora.removeAllItems();
        listaNovaHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "15:00", "16:00", "17:00", "18:00" }));
        listaNovaHora.setEnabled(true);
        btnSalvarED.setVisible(true);btnSalvarED.setEnabled(true);
        btnAlterarData.setEnabled(false);
    }//GEN-LAST:event_btnAlterarDataActionPerformed

    private void btnSalvarEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEDActionPerformed
        Agendamento ag = new Agendamento();
        try{
        ag.setIdAgendamento(Integer.parseInt(tfdID.getText()));
        ag = agDao.buscarAgendamento(ag.getIdAgendamento());
        DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        String data = formater.format(novaData.getDate());
        data = data +" " + listaNovaHora.getSelectedItem();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ag.setDataRealizacao(LocalDateTime.parse(data, formatter));
        
        if(!ag.getDataRealizacao().isAfter(LocalDateTime.now())){
            JOptionPane.showMessageDialog(null, "Defina uma data posterior a agora");
        }else{
            if(!verificar(ag.getProfissonais(), ag.getDataRealizacao())){
                JOptionPane.showMessageDialog(null, "Profissionais escolhidos não disponíveis no horário escolhido");
            }else{
            agDao.alterarData(ag);
            JOptionPane.showMessageDialog(null, "Alterado");
            estadoInicialTela2();
            }
           
            
            
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSalvarEDActionPerformed

    private void jbFaturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFaturarActionPerformed
       if(tabelaAgendamentos.getSelectedRowCount() > 0){
           int linha = tabelaAgendamentos.getSelectedRow();
           int id = Integer.parseInt(tabelaAgendamentos.getValueAt(linha, 0).toString());
           Agendamento ag = agDao.buscarAgendamento(id);
           TelaConta tc = new TelaConta(ag, this);
           tp.getDekstop().add(tc);
          
           tc.setVisible(true);
           this.setVisible(false);
           
           
       }
    }//GEN-LAST:event_jbFaturarActionPerformed
    
    private void setarDadosAnimal(Animal a){
        tfDataNasc.setText(a.getDataNascimento().toString());
        tfAltura.setText(String.valueOf(a.getAltura()));
        tfPeso.setText(String.valueOf(a.getPeso()));
        tfRaca.setText(a.getRaca());
        AnimalDAO adao = new AnimalDAO();
        Animal aux = adao.buscarPorId(a.getId());
        ManipularImagem.exibiImagemLabel(aux.getFoto(), labelFoto);
       
        
   }
    private void lerTabelaCliente(ArrayList<Cliente> clientes) {
        modelotabelaclientes = (DefaultTableModel) tabelaCliente.getModel();
        for (Cliente p : clientes) {
            if(p instanceof Fisica){
                Fisica f = (Fisica) p;
                modelotabelaclientes.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getCpf(),
                "-"
                });
            }
            else{
                Juridica f = (Juridica) p;
                modelotabelaclientes.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                "-",
                f.getCnpj()
                });
            }
           
        }

    }
    private void lerTabelaServicos(ArrayList<Servico> servicos) {
        modelotabelaServico = (DefaultTableModel) tabelaServico.getModel();
        
        for (Servico p : servicos) {
                modelotabelaServico.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getPreco()
                });
           
           
        }


    }
    private void resultadoPesquisa(String tipo){
        if(ResultPesquisaclientes.isEmpty()){
                JOptionPane.showMessageDialog(null, " Nenhum cliente com " + tipo + " " +tfPesquisa.getText() +" encontrado!!!");
            }
            else{
                modelotabelaclientes.setNumRows(0);
                lerTabelaCliente(ResultPesquisaclientes);
            }
    }
    private void PesquisarCliente(){
         if (tfPesquisa.getText().isEmpty()) {
           modelotabelaclientes.setNumRows(0);
           lerTabelaCliente(Todosclientes);

        } else {
            if (filtroPesquisaCliente.getSelectedIndex() == 0) {
                ResultPesquisaclientes = cliDao.retornaClienteNome(tfPesquisa.getText());
                resultadoPesquisa("nome");
            } else if (filtroPesquisaCliente.getSelectedIndex() == 1) {
                ResultPesquisaclientes = cliDao.retornaClientesCpf(tfPesquisa.getText());
                resultadoPesquisa("cpf");
            } else {
                ResultPesquisaclientes = cliDao.retornaClientesCnpj(tfPesquisa.getText());
                resultadoPesquisa("cnpj");
            }
        }
    }    
    private void setarListaAnimaisCliente(){
        int idCliente = Integer.parseInt(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(),0).toString());
        animais = cliDao.retornaAnimaisCliente(idCliente);
        if(animais.isEmpty()){
             listaAnimaisCliente.removeAllItems();
             tfAltura.setText("");
             tfDataNasc.setText("");
             tfPeso.setText("");
             tfRaca.setText("");
             labelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/8f95d343cb060aa025d9b61ea901b223.jpg")));
             JOptionPane.showMessageDialog(null, "Cliente não tem animais cadastrados");
             listaAnimaisCliente.setEnabled(false);
             
        }else{
          
            
            listaAnimaisCliente.removeAllItems();
            for(Animal a : animais){
              
              listaAnimaisCliente.addItem(a.getNome());
           
            }
            listaAnimaisCliente.setSelectedIndex(0);
            listaAnimaisCliente.setEnabled(true);
           
            
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton btnAlterarData;
    private javax.swing.JButton btnSalvarED;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser dataFinal;
    private com.toedter.calendar.JDateChooser dataInicial;
    private com.toedter.calendar.JDateChooser dataRealizar;
    private javax.swing.JComboBox<String> filtroPesquisaCliente;
    private javax.swing.JComboBox<String> filtroServicos;
    private javax.swing.JComboBox<String> filtroTipoBusca;
    private javax.swing.JCheckBox fim;
    private javax.swing.JCheckBox inicial;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton jbAlterarStatus;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbFaturar;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbcancelar;
    private javax.swing.JButton jbcancelarAgendamento;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JComboBox<String> listaAnimaisCliente;
    private javax.swing.JList<String> listaDisponiveis;
    private javax.swing.JComboBox<String> listaHora;
    private javax.swing.JComboBox<String> listaNovaHora;
    private javax.swing.JList<String> listaescolhidos;
    private com.toedter.calendar.JDateChooser novaData;
    private javax.swing.JPanel painelAgendamento;
    private javax.swing.JButton retirar;
    private javax.swing.JComboBox<String> statusPagamento;
    private javax.swing.JComboBox<String> statusServico;
    private javax.swing.JTable tabelaAgendamentos;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTable tabelaServico;
    private javax.swing.JTabbedPane tabelpane;
    private javax.swing.JTextField tfAltura;
    private javax.swing.JTextField tfDataNasc;
    private javax.swing.JTextField tfPeso;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfProfissionais;
    private javax.swing.JTextField tfRaca;
    private javax.swing.JTextField tfServico;
    private javax.swing.JTextField tfdAnimal;
    private javax.swing.JTextField tfdCliente;
    private javax.swing.JTextField tfdID;
    private javax.swing.JTextField tfpesquisaAgendamento;
    private javax.swing.JTextField tfpesquisaServico;
    // End of variables declaration//GEN-END:variables
}
