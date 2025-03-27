
package view;

import controller.GerenciaItens;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Profissional;
import model.Servico;
import modelDAO.ItensDAO;


public class TelaServico extends javax.swing.JInternalFrame {
    ItensDAO itDao;
    ArrayList<Profissional> selecionados;
    DefaultListModel modeloCel;
    DefaultListModel modeloDisp;
    ArrayList<Profissional> disponiveis;
    GerenciaItens geItens;
    ArrayList<Servico> servicos;
    DefaultTableModel modelo;
    boolean editando = true;
    boolean criando = false;
    public TelaServico() {
        initComponents();
        itDao = new ItensDAO();
        selecionados = new ArrayList<>();
        modeloCel = new DefaultListModel();
        
        listaescolhidos.setModel(modeloCel);
        modeloDisp = new DefaultListModel();
        geItens = new GerenciaItens();
        lerTabela(geItens.listarServicos());
       jtxtCodigo.setEditable(false);
       jtxtDescricao.setEditable(false);
       jtxtEquipamentos.setEditable(false);
       jtxtPreco.setEditable(false);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaservico = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaprofDoServico = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaDisponiveis = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaescolhidos = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtxNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtEspecialidade = new javax.swing.JTextField();
        adicionar = new javax.swing.JButton();
        retirar = new javax.swing.JButton();
        jtxtEquipamentos = new javax.swing.JTextField();
        jbsalvar = new javax.swing.JButton();
        JbNovo = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        filtroPesquisa = new javax.swing.JComboBox<>();
        jtfPesquisa = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        tabelaservico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preço", "Equipamentos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
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
        tabelaservico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaservicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaservico);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profissional(s) ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tabelaprofDoServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Profissional", "Especialidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaprofDoServico.setEnabled(false);
        tabelaprofDoServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaprofDoServicoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaprofDoServico);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
        );

        jLabel1.setText("Código");

        jtxtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtCodigoFocusLost(evt);
            }
        });

        jLabel2.setText("Descrição");

        jtxtDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtDescricaoFocusLost(evt);
            }
        });

        jLabel3.setText("Preço");

        jtxtPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtPrecoFocusLost(evt);
            }
        });

        jLabel4.setText("Equipamentos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleção de Profissional(s)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        listaDisponiveis.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Código Profissionais", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        listaDisponiveis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaDisponiveis.setEnabled(false);
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
        jScrollPane4.setViewportView(listaDisponiveis);

        listaescolhidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Códigos Profissionais", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
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
        jScrollPane5.setViewportView(listaescolhidos);

        jLabel5.setText("Disponiveis");

        jLabel6.setText("Escolhido(s)");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do profissonal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel7.setText("Nome");

        jtxNome.setFocusable(false);

        jLabel8.setText("Especialidade");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxNome, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jtxtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jtxNome, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel5)
                        .addGap(137, 137, 137)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jtxtEquipamentos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtEquipamentosFocusLost(evt);
            }
        });

        jbsalvar.setText("Salvar");
        jbsalvar.setEnabled(false);
        jbsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalvarActionPerformed(evt);
            }
        });

        JbNovo.setText("Novo");
        JbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbNovoActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Exluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        filtroPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CÓDIGO", "DESCRIÇÃO" }));

        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jbsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filtroPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel2)
                        .addGap(420, 420, 420)
                        .addComponent(jLabel3))
                    .addComponent(jtxtEquipamentos)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtPreco)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCodigo)
                    .addComponent(jtxtDescricao, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filtroPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lerTabela(ArrayList<Servico> servs) {
        modelo = (DefaultTableModel) tabelaservico.getModel();
        modelo.setNumRows(0);
        for (Servico p : servs) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getPreco(),
                p.getEquipamentos()
            });
        }

    }
    private void cancelar(){
        adicionar.setEnabled(false);
        retirar.setEnabled(false);
        limpaCampos();
        jbEditar.setEnabled(false);
        tabelaservico.setEnabled(true);
        jtxtDescricao.setEditable(false);
        jtxtPreco.setEditable(false);
        jtxtEquipamentos.setEditable(false);
                
        listaDisponiveis.setEnabled(false);
        jtxNome.setEditable(false);
        jtxtEspecialidade.setEditable(false);
        adicionar.setEnabled(false);
        jtxNome.setText(null);
        jtxtEspecialidade.setText(null);
         
        modeloCel = null;
        modeloCel = new DefaultListModel();
        listaescolhidos.setModel(modeloCel);
        listaescolhidos.setEnabled(false);
        jbExcluir.setText("Excluir");
        jbsalvar.setEnabled(false);
        criando = editando = false;
        jbPesquisar.setEnabled(true);
        filtroPesquisa.setEnabled(true);
        jtfPesquisa.setEnabled(true);
        JbNovo.setEnabled(true);
        
    }
    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
       if(criando || editando){
           cancelar();
           
       }
       else if(tabelaservico.getSelectedRowCount() > 0){
       int setar = tabelaservico.getSelectedRow();
       int id = Integer.parseInt(tabelaservico.getValueAt(setar, 0).toString());
       geItens.excluirServico(id);
       modelo.removeRow(tabelaservico.getSelectedRow());
       JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso");
       limpaCampos();
       proximoCod();
       DefaultTableModel modelo = null;
        modelo = (DefaultTableModel) tabelaprofDoServico.getModel();
        modelo.setNumRows(0);
       }
       
        
        
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void setProfissionaisDisponiveis(){
        modeloDisp = null;
        modeloDisp = new DefaultListModel();
        for(Profissional p : disponiveis){
           modeloDisp.addElement(new String(""+p.getId()));
            
        }
        listaDisponiveis.setModel(modeloDisp);
    }
     public void proximoCod(){
         jtxtCodigo.setText(String.valueOf(geItens.proximoCodigo()));
    }
     private void limpaCampos(){
        jtxtDescricao.setText(null);
        jtxtPreco.setText(null);
        jtxtEquipamentos.setText(null); 
     }
     private void prepararParaNovo(){
        jbEditar.setEnabled(false);
        tabelaservico.setEnabled(false);
        disponiveis = itDao.listaProfissionais();
        selecionados = new ArrayList<>();
        proximoCod();
        limpaCampos();
        
        jtxtDescricao.setEditable(true);
        jtxtPreco.setEditable(true);
        jtxtEquipamentos.setEditable(true);
        
        setProfissionaisDisponiveis();
        
        listaDisponiveis.setEnabled(true);
        
        jtxNome.setEditable(false);
        jtxtEspecialidade.setEditable(false);
        
        adicionar.setEnabled(false);
        jbsalvar.setEnabled(true);
        jtxNome.setText(null);
        jtxtEspecialidade.setText(null);
         
        modeloCel = null;
        modeloCel = new DefaultListModel();
        listaescolhidos.setModel(modeloCel);
        listaescolhidos.setEnabled(true);
        jbsalvar.setEnabled(false);
        criando = true;
        jbPesquisar.setEnabled(false);
        filtroPesquisa.setEnabled(false);
        jtfPesquisa.setEnabled(false);
        jbExcluir.setText("Cancelar");
     }
    private void JbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbNovoActionPerformed
        prepararParaNovo(); 
       
    }//GEN-LAST:event_JbNovoActionPerformed

    private Profissional retornaProficional(String selecionado){
        for(Profissional p: disponiveis){
                String id = "" + p.getId();
                if(selecionado.equals(id)){
                    return p;
                }
            }
        
       return null; 
    }
    private boolean preencheu(){
        if(jtxtDescricao.getText().isEmpty() || 
                jtxtEquipamentos.getText().isEmpty() ||
                jtxtPreco.getText().isEmpty() || 
                 selecionados.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    private void listaDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaDisponiveisMouseClicked
        
      
    }//GEN-LAST:event_listaDisponiveisMouseClicked

    private void listaDisponiveisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaDisponiveisFocusGained
        
        
    }//GEN-LAST:event_listaDisponiveisFocusGained

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
       String selecionado = listaDisponiveis.getSelectedValue();
            
        Profissional s = retornaProficional(selecionado);
        selecionados.add(s);
        modeloCel.addElement(new String(""+s.getId()));
        int ind = listaDisponiveis.getSelectedIndex();
        if(listaDisponiveis.getModel().getSize() > 1){
        if(ind > 0){
            listaDisponiveis.setSelectedIndex(ind-1);
            jtxNome.setText(s.getNome());
            jtxtEspecialidade.setText(s.getEspecialidade());
        }else{
            listaDisponiveis.setSelectedIndex(ind+1);
            jtxNome.setText(s.getNome());
            jtxtEspecialidade.setText(s.getEspecialidade());
        }
        }
        else{
            adicionar.setEnabled(false);
        }
        modeloDisp.remove(ind);
        if(criando){
        if(preencheu()){
            jbsalvar.setEnabled(true);
        }else{
            jbsalvar.setEnabled(false);
        }
        }
    }//GEN-LAST:event_adicionarActionPerformed

    private void listaescolhidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaescolhidosMouseClicked
       
    }//GEN-LAST:event_listaescolhidosMouseClicked
    public int retornaPosicaoSelecionados(String selecionado){
        int x=0;
      for(Profissional p: selecionados){
                String id = "" + p.getId();
                if(selecionado.equals(id)){
                    return x;
                }
                x++;
            }
        return -1;
    }
    private void retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarActionPerformed
        String selecionado = listaescolhidos.getSelectedValue();
        Profissional s = retornaProficional(selecionado);
        int ind = listaescolhidos.getSelectedIndex();
        if(listaescolhidos.getModel().getSize() > 1){
        if(ind > 0){
            listaescolhidos.setSelectedIndex(ind-1);
            jtxNome.setText(s.getNome());
            jtxtEspecialidade.setText(s.getEspecialidade());
        }else{
            listaescolhidos.setSelectedIndex(ind+1);
            jtxNome.setText(s.getNome());
            jtxtEspecialidade.setText(s.getEspecialidade());
        }
        }
        else{
            retirar.setEnabled(false);
        }
        modeloCel.remove(ind);
        modeloDisp.addElement(new String(""+s.getId()));
        selecionados.remove(retornaPosicaoSelecionados(selecionado));
        
        if(criando){
        if(preencheu()){
            jbsalvar.setEnabled(true);
        }else{
            jbsalvar.setEnabled(false);
        }
        }
        
        
    }//GEN-LAST:event_retirarActionPerformed

    private void listaDisponiveisValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaDisponiveisValueChanged
        if (!listaDisponiveis.isSelectionEmpty()) {
            String selecionado = listaDisponiveis.getSelectedValue();
            
            Profissional p = retornaProficional(selecionado);
            
            jtxNome.setText(p.getNome());
            jtxtEspecialidade.setText(p.getEspecialidade());
            
            adicionar.setEnabled(true);
            retirar.setEnabled(false);
        } else {
            adicionar.setEnabled(false);
            jtxNome.setText("");
            jtxtEspecialidade.setText("");
        }
    }//GEN-LAST:event_listaDisponiveisValueChanged

    private void listaescolhidosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaescolhidosValueChanged
       if (!listaescolhidos.isSelectionEmpty()) {
            String selecionado = listaescolhidos.getSelectedValue();
            Profissional p = retornaProficional(selecionado);
            jtxNome.setText(p.getNome());
            jtxtEspecialidade.setText(p.getEspecialidade());
            adicionar.setEnabled(false);
            retirar.setEnabled(true);
        } else {
            adicionar.setEnabled(false);
            jtxNome.setText("");
            jtxtEspecialidade.setText("");
        }
    }//GEN-LAST:event_listaescolhidosValueChanged
    private boolean precoOK(){
        try{
            float teste = Float.parseFloat(jtxtPreco.getText());
            return true;
        }catch(Exception e){
            return false;
        }
    }
    private void jbsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalvarActionPerformed
        if (criando) {
            if (!precoOK()) {
                JOptionPane.showMessageDialog(this, "Formato de preço inválido");
                jtxtPreco.requestFocus();
            } else if (selecionados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Selecione ao menos 1 profissional");

            } else {

                Servico s = new Servico();
                s.setEquipamentos(jtxtEquipamentos.getText());
                s.setDescricao(jtxtDescricao.getText());
                s.setPreco(Float.parseFloat(jtxtPreco.getText()));
                s.setProficionais(selecionados);
                if (geItens.cadastrarServico(s)) {
                    proximoCod();
                    int codigo = Integer.parseInt(jtxtCodigo.getText()) - 1;
                    modelo.addRow(new Object[]{
                        codigo,
                        s.getDescricao(),
                        s.getPreco(),
                        s.getEquipamentos()
                    });
                    JOptionPane.showMessageDialog(this, "cadastrado com sucesso");
                    prepararParaNovo();
                    cancelar();
                } else {
                    JOptionPane.showMessageDialog(this, "Cadastro falhou");
                }
            }
        } else if (editando) {
            if (!precoOK()) {
                JOptionPane.showMessageDialog(this, "Formato de preço inválido");
                jtxtPreco.requestFocus();
            } else if (selecionados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Selecione ao menos 1 profissional");

            } else {
                Servico s = new Servico();
                s.setId(Integer.parseInt(jtxtCodigo.getText()));
                s.setEquipamentos(jtxtEquipamentos.getText());
                s.setDescricao(jtxtDescricao.getText());
                s.setPreco(Float.parseFloat(jtxtPreco.getText()));
                s.setProficionais(selecionados);
                geItens.alterarServico(s);
                int x = tabelaservico.getSelectedRow();
                tabelaservico.setValueAt(s.getDescricao(), x, 1);
                tabelaservico.setValueAt(s.getPreco(), x, 2);
                tabelaservico.setValueAt(s.getEquipamentos(), x, 3);
                JOptionPane.showMessageDialog(this, "alterado com sucesso");
                cancelar();
                DefaultTableModel modelo = null;
                modelo = (DefaultTableModel) tabelaprofDoServico.getModel();
                modelo.setNumRows(0);
            }
        }

    }//GEN-LAST:event_jbsalvarActionPerformed

    private void setarTabelaProficionais() {
        servicos= geItens.listarServicos();
        if(tabelaservico.getSelectedRowCount() > 0){
        DefaultTableModel modelo = null;
        modelo = (DefaultTableModel) tabelaprofDoServico.getModel();
        modelo.setNumRows(0);
        ArrayList<Profissional> p;
        int setar = tabelaservico.getSelectedRow();

        for (Servico s : servicos) {
            if (s.getId() == Integer.parseInt(tabelaservico.getValueAt(setar, 0).toString())) {
                for (Profissional pr : s.getProficionais()) {
                    modelo.addRow(new Object[]{
                        pr.getNome(),
                        pr.getEspecialidade(),});
                }
            }
        }
        tabelaprofDoServico.setModel(modelo);


        }
        
    }
    public void setarCampos() {
        if(tabelaservico.getSelectedRowCount() > 0){
            int setar = tabelaservico.getSelectedRow();
            jtxtCodigo.setText(tabelaservico.getValueAt(setar, 0).toString());
            jtxtDescricao.setText(tabelaservico.getValueAt(setar, 1).toString());
            jtxtPreco.setText(tabelaservico.getValueAt(setar, 2).toString());
            jtxtEquipamentos.setText((tabelaservico.getValueAt(setar, 3).toString()));
            jbsalvar.setEnabled(false);
            jtxtCodigo.setEditable(false);}
    }
    private void tabelaservicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaservicoMouseClicked
        if(tabelaservico.isEnabled()){
        if(tabelaservico.getSelectedRowCount() > 0){
        setarTabelaProficionais();
        setarCampos();
        
        listaDisponiveis.setEnabled(false);
        listaescolhidos.setEnabled(false);
        jbEditar.setEnabled(true);
        }
        }
        
        
    }//GEN-LAST:event_tabelaservicoMouseClicked

    private void tabelaprofDoServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaprofDoServicoMouseClicked

    }//GEN-LAST:event_tabelaprofDoServicoMouseClicked

    private void jtxtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtCodigoFocusLost
       
    }//GEN-LAST:event_jtxtCodigoFocusLost

    private void jtxtDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtDescricaoFocusLost
        if(criando){
        if(preencheu()){
            jbsalvar.setEnabled(true);
        }else{
            jbsalvar.setEnabled(false);
        }
        }
    }//GEN-LAST:event_jtxtDescricaoFocusLost

    private void jtxtPrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPrecoFocusLost
        if(criando){
        if(preencheu()){
            jbsalvar.setEnabled(true);
        }else{
            jbsalvar.setEnabled(false);
        }
        }
    }//GEN-LAST:event_jtxtPrecoFocusLost

    private void jtxtEquipamentosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtEquipamentosFocusLost
       if(criando){
        if(preencheu()){
            jbsalvar.setEnabled(true);
        }else{
            jbsalvar.setEnabled(false);
        }
        }
    }//GEN-LAST:event_jtxtEquipamentosFocusLost

    private void listaescolhidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaescolhidosFocusLost
       if(criando){
        if(preencheu()){
            jbsalvar.setEnabled(true);
        }else{
            jbsalvar.setEnabled(false);
        }
        }
    }//GEN-LAST:event_listaescolhidosFocusLost
    private void setarListaProdfissionaisAtual(){
        if(tabelaservico.getSelectedRowCount() > 0){
        modeloCel = null;
        modeloCel = new DefaultListModel();
        listaescolhidos.setModel(modeloCel);
        listaescolhidos.setEnabled(true);
        ArrayList<Profissional> p;
        int setar = tabelaservico.getSelectedRow();
        for (Servico s : servicos) {
            if (s.getId() == Integer.parseInt(tabelaservico.getValueAt(setar, 0).toString())) {
                for (Profissional pr : s.getProficionais()) {
                     selecionados.add(pr);
                     modeloCel.addElement(new String(""+pr.getId()));
                }
            }
        }
     }
            
    }
    public void setarProfissionaisDisponiveisEditar(){
        modeloDisp = null;
        modeloDisp = new DefaultListModel();
        for(Profissional p : disponiveis){
            boolean add = true;
            for(Profissional s : selecionados){
                if(p.getId() == s.getId()){
                    add=false;
                }
            }
            if(add){
                 modeloDisp.addElement(new String(""+p.getId()));
            }
            
        }
        listaDisponiveis.setModel(modeloDisp);
    }
    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        if(tabelaservico.getRowCount() > 0){
        jbEditar.setEnabled(false);
        tabelaservico.setEnabled(false);
        disponiveis = itDao.listaProfissionais();
        selecionados = new ArrayList<>();
        setarListaProdfissionaisAtual();
        setarProfissionaisDisponiveisEditar();
        listaDisponiveis.setEnabled(true);
        jtxtDescricao.setEditable(true);
        jtxtPreco.setEditable(true);
        jtxtEquipamentos.setEditable(true);
        
        jtxNome.setEditable(false);
        jtxtEspecialidade.setEditable(false);
        
        adicionar.setEnabled(false);
        jbsalvar.setEnabled(true);
        jtxNome.setText(null);
        jtxtEspecialidade.setText(null);
         
       
        listaescolhidos.setEnabled(true);
        editando = true;
        jbPesquisar.setEnabled(false);
        filtroPesquisa.setEnabled(false);
        jtfPesquisa.setEnabled(false);
        jbExcluir.setText("Cancelar"); 
        JbNovo.setEnabled(false);}
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
       if(filtroPesquisa.getSelectedIndex() == 0){
           if(jtfPesquisa.getText().isEmpty()){
            lerTabela(geItens.listarServicos());
           }else{
               ArrayList<Servico> servs = new ArrayList<>();
               
               if(geItens.pesquisaServicoID(Integer.parseInt(jtfPesquisa.getText())) == null){
                   JOptionPane.showMessageDialog(null, "Código não encontrado!!!");
               }else{
                   servs.add(geItens.pesquisaServicoID(Integer.parseInt(jtfPesquisa.getText())));
                   lerTabela(servs);
               }
           }
       }else if(filtroPesquisa.getSelectedIndex() == 1){
           ArrayList<Servico> servs = new ArrayList<>();
           servs = geItens.pesquisarServicoDescricao(jtfPesquisa.getText());
           lerTabela(servs);
       }
        
        
    }//GEN-LAST:event_jbPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbNovo;
    private javax.swing.JButton adicionar;
    private javax.swing.JComboBox<String> filtroPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbsalvar;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JTextField jtxNome;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtDescricao;
    private javax.swing.JTextField jtxtEquipamentos;
    private javax.swing.JTextField jtxtEspecialidade;
    private javax.swing.JTextField jtxtPreco;
    private javax.swing.JList<String> listaDisponiveis;
    private javax.swing.JList<String> listaescolhidos;
    private javax.swing.JButton retirar;
    private javax.swing.JTable tabelaprofDoServico;
    private javax.swing.JTable tabelaservico;
    // End of variables declaration//GEN-END:variables
}
