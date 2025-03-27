package view;

import controller.GerenciaAnimal;
import controller.ManipularImagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Animal;
import modelDAO.AnimalDAO;

public final class TelaA extends javax.swing.JInternalFrame {

    BufferedImage imagem;
    GerenciaAnimal gani = new GerenciaAnimal();
    DefaultTableModel modelo;
    ArrayList<Animal> animais;
    Animal a = new Animal();
    AnimalDAO adao = new AnimalDAO();
    int idCliente;
    boolean alterando;

    public TelaA() {
        initComponents();

        lerTabela();
        modelo = (DefaultTableModel) tabelaAnimais.getModel();
        desabilitaCampos();
        desabilitarEditarCampos(false);
        estadoInicialBotoes();
        tfdId.setEditable(false);
        tfdIdPropietario.setEditable(false);
        btnInserirImagem.setVisible(false);

    }

    public TelaA(int idCliente) {
        this.idCliente = idCliente;
        initComponents();
        modelo = (DefaultTableModel) tabelaAnimais.getModel();
        lerTabela();
        proximoCod();
        setaidCli();
        tfdId.setEditable(false);
        tfdIdPropietario.setEditable(false);
        btnInserirImagem.setVisible(false);


    }

    public void proximoCod() {
        tfdId.setText(new String("" + adao.proximoCodigo()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAnimais = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        btnInserirImagem = new javax.swing.JButton();
        tfdIdPropietario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdAltura = new javax.swing.JTextField();
        ftfDataNascimento = new javax.swing.JFormattedTextField();
        lblDataNasc = new javax.swing.JLabel();
        lblIdPropietario = new javax.swing.JLabel();
        lblNomedoAnimal = new javax.swing.JLabel();
        tfdNomeAnimal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdRaca = new javax.swing.JTextField();
        tfdPeso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        tfdPesquisaAnimal = new javax.swing.JTextField();
        btnPesquisaIdAnimal = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfdId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        rbMacho = new javax.swing.JRadioButton();
        rbFemea = new javax.swing.JRadioButton();
        btnSair = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbTipoPesquisa = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Gerenciar Animais");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Animal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 12))); // NOI18N

        tabelaAnimais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data de Nascimento", "Raça", "peso", "Altura", "Sexo", "IdCliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAnimais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicouNoCampo(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAnimais);
        if (tabelaAnimais.getColumnModel().getColumnCount() > 0) {
            tabelaAnimais.getColumnModel().getColumn(0).setResizable(false);
            tabelaAnimais.getColumnModel().getColumn(1).setResizable(false);
            tabelaAnimais.getColumnModel().getColumn(2).setResizable(false);
            tabelaAnimais.getColumnModel().getColumn(3).setResizable(false);
            tabelaAnimais.getColumnModel().getColumn(4).setResizable(false);
            tabelaAnimais.getColumnModel().getColumn(5).setResizable(false);
            tabelaAnimais.getColumnModel().getColumn(6).setResizable(false);
            tabelaAnimais.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 990, 138));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnInserirImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirImagemActionPerformed(evt);
            }
        });

        tfdIdPropietario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicou(evt);
            }
        });
        tfdIdPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdIdPropietarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Altura");

        try {
            ftfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblDataNasc.setText("Data de Nascimento");

        lblIdPropietario.setText("Id do Porietário");

        lblNomedoAnimal.setText("Nome do Animal");

        tfdNomeAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdNomeAnimalActionPerformed(evt);
            }
        });

        jLabel2.setText("Raça");

        tfdRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdRacaActionPerformed(evt);
            }
        });

        jLabel1.setText("Peso");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Editar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        tfdPesquisaAnimal.setText("Digite o ID do animal");
        tfdPesquisaAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cliccou(evt);
            }
        });
        tfdPesquisaAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdPesquisaAnimalActionPerformed(evt);
            }
        });

        btnPesquisaIdAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaIdAnimalActionPerformed(evt);
            }
        });

        jLabel9.setText("ID");

        jLabel10.setText("ID ");

        tfdId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdIdFocusLost(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        buttonGroup1.add(rbMacho);
        rbMacho.setText("Macho");
        rbMacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMachoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbFemea);
        rbFemea.setText("Fêmea");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbMacho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(rbFemea)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMacho)
                    .addComponent(rbFemea))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "ID", "Nome" }));
        cbTipoPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoPesquisaItemStateChanged(evt);
            }
        });
        cbTipoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdRaca)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(btnInserirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ftfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(tfdAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfdNomeAnimal)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNomedoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfdIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(tfdPesquisaAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnPesquisaIdAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)))
                            .addComponent(lblDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(159, 159, 159))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnInserirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(lblIdPropietario))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(btnPesquisaIdAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(jLabel10)
                                                .addGap(4, 4, 4))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfdIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfdPesquisaAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9)
                                        .addComponent(lblNomedoAnimal)))
                                .addGap(6, 6, 6)
                                .addComponent(tfdNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 1010, 560));
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clicou(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicou

    }//GEN-LAST:event_clicou

    private void tfdNomeAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdNomeAnimalActionPerformed
       
    }//GEN-LAST:event_tfdNomeAnimalActionPerformed

    private void tfdRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdRacaActionPerformed

    }//GEN-LAST:event_tfdRacaActionPerformed

    private void btnInserirImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirImagemActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        fc.setFileFilter(filter);
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), lblFoto.getWidth(), lblFoto.getHeight());

                lblFoto.setIcon(new ImageIcon(imagem));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao selecionar arquivo " + ex.getMessage());

            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_btnInserirImagemActionPerformed


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        a = new Animal();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (testaNulos()) {
            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos");
        } else {
            a.setId(Integer.parseInt(tfdId.getText()));
            a.setNome(tfdNomeAnimal.getText());
            a.setRaca(tfdRaca.getText());
            a.setAltura(Float.parseFloat(tfdAltura.getText()));
            a.setPeso(Float.parseFloat(tfdPeso.getText()));
            a.setDataNascimento(LocalDate.parse(ftfDataNascimento.getText(), formatter));
            a.setIdCliente(Integer.parseInt(tfdIdPropietario.getText()));
            if (imagem != null) {
                a.setFoto(ManipularImagem.getImgBytes(imagem));
            } else {
                Animal aux = adao.buscarPorId(a.getId());
                a.setFoto(aux.getFoto());
            }

            if (rbMacho.isSelected()) {
                a.setSexo("Macho");
            } else {
                a.setSexo("Fêmea");
            }

            adao.alterarAnimal(a);
            lerTabela();
            estadoInicialBotoes();
            desabilitaCampos();
            desabilitarEditarCampos(false);
            limpa();
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    public void setaidCli() {
        tfdIdPropietario.setText(String.valueOf(idCliente));
    }


    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        if (tabelaAnimais.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(null, tfdNomeAnimal.getText(), "Confirmar exclusão", JOptionPane.YES_NO_OPTION) == 0) {
                adao.excluirAnimal(Integer.parseInt(tfdId.getText()));

                modelo.removeRow(tabelaAnimais.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Excluido");
                estadoInicialBotoes();
                lerTabela();
                limpa();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione um animal antes de excluir");
        }


    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tfdIdPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdIdPropietarioActionPerformed
        
    }//GEN-LAST:event_tfdIdPropietarioActionPerformed

    private void tfdPesquisaAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdPesquisaAnimalActionPerformed
        
    }//GEN-LAST:event_tfdPesquisaAnimalActionPerformed

    private void Cliccou(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cliccou
        tfdPesquisaAnimal.setText("");
    }//GEN-LAST:event_Cliccou

    private void btnPesquisaIdAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaIdAnimalActionPerformed
        
        if (tfdPesquisaAnimal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Insira um dado para pesquisa");
        } else {

            if (cbTipoPesquisa.getSelectedItem().equals("ID")) {

                for (int x = 0; x < tabelaAnimais.getRowCount(); x++) {
                    if (tfdPesquisaAnimal.getText().equals(tabelaAnimais.getValueAt(x, 0).toString())) {
                        tabelaAnimais.clearSelection();
                        tabelaAnimais.addRowSelectionInterval(x, x);
                        setarCampos();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Pesquisa não encontrou resultados");

            } else {
                for (int x = 0; x < tabelaAnimais.getRowCount(); x++) {
                    if (tfdPesquisaAnimal.getText().equals(tabelaAnimais.getValueAt(x, 1).toString())) {
                        tabelaAnimais.clearSelection();
                        tabelaAnimais.addRowSelectionInterval(x, x);
                        setarCampos();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Pesquisa não encontrou resultados");

            }

        }
        
        
        

    }//GEN-LAST:event_btnPesquisaIdAnimalActionPerformed

    private void clicouNoCampo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicouNoCampo
        setarCampos();
    }//GEN-LAST:event_clicouNoCampo

    private void tfdIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdIdFocusLost
        
    }//GEN-LAST:event_tfdIdFocusLost

    private void rbMachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMachoActionPerformed
        
    }//GEN-LAST:event_rbMachoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
         if (tabelaAnimais.getSelectedRow() >= 0) {

            desabilitarEditarCampos(true);
            abilitaCampos();
            estadoBotoesAposAlterar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione um animal antes de editar");
        }


    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void cbTipoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoPesquisaItemStateChanged
        
    }//GEN-LAST:event_cbTipoPesquisaItemStateChanged

    private void cbTipoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPesquisaActionPerformed
        
    }//GEN-LAST:event_cbTipoPesquisaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            lerTabela();
            estadoInicialBotoes();
            desabilitaCampos();
            desabilitarEditarCampos(false);
            limpa();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void estadoInicialBotoes() {
        btnExcluir.setVisible(true);
        btnSalvar.setVisible(false);
        btnCancelar.setVisible(false);
        btnSair.setVisible(true);
        btnAlterar.setVisible(true);
        btnInserirImagem.setVisible(false);

    }

    public void estadoBotoesAposAlterar() {
        btnExcluir.setVisible(false);
        btnSalvar.setVisible(true);
        btnCancelar.setVisible(true);
        btnSair.setVisible(false);
        btnAlterar.setVisible(false);
    }

    public void limpa() {
        tfdId.setText(null);
        tfdAltura.setText(null);
        tfdNomeAnimal.setText(null);
        tfdIdPropietario.setText(null);
        tfdPeso.setText(null);
        tfdRaca.setText(null);
        ftfDataNascimento.setText(null);
        rbFemea.setSelected(false);
        rbMacho.setSelected(false);

    }

    public void abilitaCampos() {
        tfdAltura.setEnabled(true);
        tfdNomeAnimal.setEnabled(true);

        tfdPeso.setEnabled(true);
        tfdRaca.setEnabled(true);
        ftfDataNascimento.setEnabled(true);
        btnInserirImagem.setVisible(true);

    }

    public void desabilitaCampos() {
        tfdAltura.setEnabled(false);
        tfdNomeAnimal.setEnabled(false);
        tfdIdPropietario.setEnabled(false);
        tfdPeso.setEnabled(false);
        tfdRaca.setEnabled(false);
        ftfDataNascimento.setEnabled(false);
        

    }

    private void lerTabela() {
        modelo = (DefaultTableModel) tabelaAnimais.getModel();
        while (tabelaAnimais.getModel().getRowCount() > 0) {
            modelo.removeRow(0);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        animais = adao.listarAnimais();
        for (Animal a : animais) {

            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getDataNascimento().format(formatter),
                a.getRaca(),
                a.getPeso(),
                a.getAltura(),
                a.getSexo(),
                a.getIdCliente()

            });

        }
    }

    public void setarCampos() {

        int setar = tabelaAnimais.getSelectedRow();

        tfdId.setText(tabelaAnimais.getValueAt(setar, 0).toString());
        tfdNomeAnimal.setText(tabelaAnimais.getValueAt(setar, 1).toString());
        ftfDataNascimento.setText(tabelaAnimais.getValueAt(setar, 2).toString());
        tfdRaca.setText(tabelaAnimais.getValueAt(setar, 3).toString());
        tfdPeso.setText(tabelaAnimais.getValueAt(setar, 4).toString());
        tfdAltura.setText(tabelaAnimais.getValueAt(setar, 5).toString());
        if (tabelaAnimais.getValueAt(setar, 6).toString().equals("Macho")) {
            rbMacho.setSelected(true);
        } else {
            rbFemea.setSelected(true);
        }
        tfdIdPropietario.setText(tabelaAnimais.getValueAt(setar, 7).toString());

        Animal aux = adao.buscarPorId(Integer.parseInt(tfdId.getText()));
        ManipularImagem.exibiImagemLabel(aux.getFoto(), lblFoto);
        imagem = null;
        desabilitarEditarCampos(false);
    }

    public void desabilitarEditarCampos(boolean a) {
        tfdNomeAnimal.setEditable(a);
        tfdAltura.setEditable(a);
        tfdIdPropietario.setEditable(a);
        tfdPeso.setEditable(a);
        tfdRaca.setEditable(a);
        ftfDataNascimento.setEditable(a);
        btnInserirImagem.setVisible(a);
        rbMacho.setEnabled(a);
        rbFemea.setEnabled(a);
    }


    public boolean testaNulos() {

        String nome, dataNascimento, raca, peso, altura;
        nome = tfdNomeAnimal.getText();
        dataNascimento = ftfDataNascimento.getText();
        raca = tfdRaca.getText();
        peso = tfdPeso.getText();
        altura = tfdAltura.getText();

        if (tfdNomeAnimal.getText().isEmpty()
                || tfdAltura.getText().isEmpty()
                || tfdIdPropietario.getText().isEmpty()
                || tfdPeso.getText().isEmpty()
                || tfdRaca.getText().isEmpty()
                || ftfDataNascimento.getText().isEmpty()
                || (!rbFemea.isSelected() && !rbMacho.isSelected())) {

            return true;
        } else {
            return false;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserirImagem;
    private javax.swing.JButton btnPesquisaIdAnimal;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbTipoPesquisa;
    private javax.swing.JFormattedTextField ftfDataNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblIdPropietario;
    private javax.swing.JLabel lblNomedoAnimal;
    private javax.swing.JRadioButton rbFemea;
    private javax.swing.JRadioButton rbMacho;
    private javax.swing.JTable tabelaAnimais;
    private javax.swing.JTextField tfdAltura;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdIdPropietario;
    private javax.swing.JTextField tfdNomeAnimal;
    private javax.swing.JTextField tfdPeso;
    private javax.swing.JTextField tfdPesquisaAnimal;
    private javax.swing.JTextField tfdRaca;
    // End of variables declaration//GEN-END:variables
}
