
package view;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import model.Animal;
import model.Cliente;
import model.Fisica;
import model.Juridica;
import modelDAO.AnimalDAO;
import modelDAO.ClienteDAO;


public class TelaCliente extends javax.swing.JInternalFrame {

    ArrayList<Fisica> clienteF;
    ArrayList<Juridica> clienteJ;
    ClienteDAO cdao;
    private Fisica cliF;
    private Juridica cliJ;
    private Cliente cli;
    DefaultTableModel modelo;
    private TelaPrincipal tp;

    boolean novo = false, alterando = false, excluindo = false;

    public TelaCliente(TelaPrincipal tp) {

        cli = new Cliente();
        cdao = new ClienteDAO();
        initComponents();
        tfdId.setEditable(false);
        desabilitaCampos();
        estadoBotoes(true);
        modelo = (DefaultTableModel) tabelaClientes.getModel();
        tabelaClientes.setRowSorter(new TableRowSorter(modelo));
        this.tp = tp;

        Preenchertabela();
    }

    public void limpaCampos() {

        tfdBairro.setText("");
        tfdComplemento.setText("");
        tfdLogradouro.setText("");
        tfdMunicipio.setText("");
        tfdNome.setText("");
        tfdNumero.setText("");
        lblCpfCnpj.setText("");
        ftfCpfCnpj.setText("");
        ftfTelefone.setText("");
        cbEstado.setSelectedIndex(0);


    }

    public boolean testaNulos() {
        if (tfdBairro.getText().isEmpty()
                || tfdComplemento.getText().isEmpty()
                || tfdLogradouro.getText().isEmpty()
                || tfdNome.getText().isEmpty()
                || tfdMunicipio.getText().isEmpty()
                || tfdNumero.getText().isEmpty()
                || cbEstado.getSelectedIndex() == 0
                || ftfCpfCnpj.getText().isEmpty()
                || ftfTelefone.getText().isEmpty()) {
            return true;

        }

        return false;

    }

    public void abilitaCampos() {

        tfdBairro.setEditable(true);
        tfdComplemento.setEditable(true);
        tfdLogradouro.setEditable(true);
        tfdMunicipio.setEditable(true);
        tfdNome.setEditable(true);
        tfdNumero.setEditable(true);
        cbTipoCliente.setEditable(true);
        cbEstado.setEnabled(true);
        ftfCpfCnpj.setEditable(true);
        ftfTelefone.setEditable(true);
        cbTipoCliente.setEnabled(true);
     
        

    }

    private void desabilitaCampos() {

        tfdBairro.setEditable(false);
        tfdComplemento.setEditable(false);
        tfdLogradouro.setEditable(false);
        tfdMunicipio.setEditable(false);
        tfdNome.setEditable(false);
        tfdNumero.setEditable(false);
        cbTipoCliente.setEditable(false);
        cbEstado.setEnabled(false);
        ftfCpfCnpj.setEditable(false);
        ftfTelefone.setEditable(false);
        cbTipoCliente.setEnabled(false);
        tabelaClientes.setEnabled(true);
        
        
        
    }

    public void proximoCod() {
        tfdId.setText(new String("" + cdao.proximoCodigo()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tfdPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfdId = new javax.swing.JTextField();
        tfdNome = new javax.swing.JTextField();
        tfdLogradouro = new javax.swing.JTextField();
        tfdNumero = new javax.swing.JTextField();
        tfdComplemento = new javax.swing.JTextField();
        tfdBairro = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox<>();
        tfdMunicipio = new javax.swing.JTextField();
        cbTipoCliente = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblCpfCnpj = new javax.swing.JLabel();
        ftfCpfCnpj = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbTipoPesquisa = new javax.swing.JComboBox<>();
        ftfTelefone = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAnimaisCliente = new javax.swing.JTable();
        btnIncluiAnimal = new javax.swing.JButton();
        btnAbrirtelaAnimal = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Tela Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Logradouro", "Numero", "Complemento ", "Bairro", "Municipio", "Estado", "Telefone", "CPF", "CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);
        if (tabelaClientes.getColumnModel().getColumnCount() > 0) {
            tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(1).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(2).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(3).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(4).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(5).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(6).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(7).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(8).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(9).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(10).setResizable(false);
        }

        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ir_primeiro.png"))); // NOI18N
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/anterior.png"))); // NOI18N
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nav_proximo.png"))); // NOI18N
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ir_ultimo.png"))); // NOI18N
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnProximo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfdPesquisa.setText("Pesquisa de Clientes");
        tfdPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdPesquisaMouseClicked(evt);
            }
        });
        tfdPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdPesquisaActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jLabel3.setText("Nome");

        jLabel4.setText("Logradouro");

        jLabel5.setText("Número");

        jLabel6.setText("Complemento");

        jLabel7.setText("Bairro");

        jLabel8.setText("Municipio");

        jLabel9.setText("Estado");

        jLabel10.setText("Tipo de Cliente");

        tfdId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdIdFocusLost(evt);
            }
        });

        tfdComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdComplementoActionPerformed(evt);
            }
        });

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione -", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        cbTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecione--", "Física", "Jurídica" }));
        cbTipoCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoClienteItemStateChanged(evt);
            }
        });
        cbTipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoClienteActionPerformed(evt);
            }
        });

        jLabel11.setText("Telefone");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/criar.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        ftfCpfCnpj.setText("Selecione um tipo de cliente");
        ftfCpfCnpj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ftfCpfCnpjMouseClicked(evt);
            }
        });
        ftfCpfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfCpfCnpjActionPerformed(evt);
            }
        });
        ftfCpfCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfCpfCnpjKeyPressed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_3621.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_cancel_128_28318.png"))); // NOI18N
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

        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ##### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfdLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ftfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(725, 725, 725))
                            .addComponent(tfdNome)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(tfdNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(ftfTelefone)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(cbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(tfdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(602, 602, 602))
                                    .addComponent(tfdComplemento))))))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ftfCpfCnpj)
                    .addComponent(tfdNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(6, 6, 6)
                                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Animais Vinculados ao Cliente"));

        tabelaAnimaisCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Raça"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(tabelaAnimaisCliente);
        if (tabelaAnimaisCliente.getColumnModel().getColumnCount() > 0) {
            tabelaAnimaisCliente.getColumnModel().getColumn(0).setResizable(false);
            tabelaAnimaisCliente.getColumnModel().getColumn(1).setResizable(false);
            tabelaAnimaisCliente.getColumnModel().getColumn(2).setResizable(false);
        }

        btnIncluiAnimal.setText("Vincular Animal");
        btnIncluiAnimal.setActionCommand("");
        btnIncluiAnimal.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnIncluiAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluiAnimalActionPerformed(evt);
            }
        });

        btnAbrirtelaAnimal.setText("Abrir tela Animal");
        btnAbrirtelaAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirtelaAnimalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAbrirtelaAnimal)
                        .addGap(40, 40, 40)
                        .addComponent(btnIncluiAnimal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIncluiAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnAbrirtelaAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        limpaCampos();
        abilitaCampos();
        proximoCod();
        estadoBotoes(false);
        novo = true;
    }//GEN-LAST:event_btnNovoActionPerformed


    private void cbTipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoClienteActionPerformed

        if (cbTipoCliente.getItemAt(cbTipoCliente.getSelectedIndex()).equals("Física")) {
            lblCpfCnpj.setText("CPF");
            try {
                ftfCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }

        } else {
            lblCpfCnpj.setText("CNPJ");

            try {
                ftfCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }

        }

    }//GEN-LAST:event_cbTipoClienteActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        if (tfdPesquisa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Insira um dado para pesquisa");
        } else {

            if (cbTipoPesquisa.getSelectedItem().equals("ID")) {

                for (int x = 0; x < tabelaClientes.getRowCount(); x++) {
                    if (tfdPesquisa.getText().equals(tabelaClientes.getValueAt(x, 0).toString())) {
                        tabelaClientes.clearSelection();
                        tabelaClientes.addRowSelectionInterval(x, x);
                        setarCampos();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Pesquisa não encontrou resultados");

            } else {
                for (int x = 0; x < tabelaClientes.getRowCount(); x++) {
                    if (tfdPesquisa.getText().equals(tabelaClientes.getValueAt(x, 1).toString())) {
                        tabelaClientes.clearSelection();
                        tabelaClientes.addRowSelectionInterval(x, x);
                        setarCampos();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Pesquisa não encontrou resultados");

            }

        }


    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tfdPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdPesquisaActionPerformed
        
    }//GEN-LAST:event_tfdPesquisaActionPerformed

    private void tfdComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdComplementoActionPerformed
        
    }//GEN-LAST:event_tfdComplementoActionPerformed

    private void tfdIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdIdFocusLost

    }//GEN-LAST:event_tfdIdFocusLost

    private void ftfCpfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfCpfCnpjActionPerformed
        ftfCpfCnpj.setText("");

    }//GEN-LAST:event_ftfCpfCnpjActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desabilitaCampos();
        estadoBotoes(true);
        setarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        if (tabelaClientes.getSelectedRow() >= 0) {
            alterando = true;
            cbTipoCliente.setEnabled(false);
            abilitaCampos();
            estadoBotoesAlterar();
            setarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione um cliente antes de editar");
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        if (tabelaClientes.getSelectedRow() >= 0) {

            excluirCliente(Integer.parseInt(tfdId.getText()));
            modelo.removeRow(tabelaClientes.getSelectedRow());

        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione um cliente antes de excluir");
        }


    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
       
        tabelaClientes.clearSelection();
        tabelaClientes.addRowSelectionInterval(0, 0);
        setarCampos();
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
       
        tabelaClientes.clearSelection();
        int x = tabelaClientes.getRowCount();
        tabelaClientes.addRowSelectionInterval(x - 1, x - 1);
        setarCampos();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
       
        int x = tabelaClientes.getSelectedRow() - 1;
        if (x >= 0) {
            tabelaClientes.clearSelection();
            tabelaClientes.addRowSelectionInterval(x, x);
            setarCampos();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        
        int x = tabelaClientes.getSelectedRow() + 1;
        if (x < tabelaClientes.getRowCount()) {
            tabelaClientes.clearSelection();
            tabelaClientes.addRowSelectionInterval(x, x);
            setarCampos();
        }
    }//GEN-LAST:event_btnProximoActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
 
         setarCampos();
         desabilitaCampos();
        if (tabelaClientes.getSelectedRow() >= 0) {
           
            lerAnimaldoCliente(Integer.parseInt(tfdId.getText()));
        }


    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void cbTipoClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoClienteItemStateChanged
        if (cbTipoCliente.getItemAt(cbTipoCliente.getSelectedIndex()).equals("- Selecione -")) {
            btnSalvar.setEnabled(false);
        } else {
            btnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_cbTipoClienteItemStateChanged

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (novo) {

            if (testaNulos()) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos antes de salvar");
            } else {
                incluir();
                limpaCampos();

                estadoBotoes(true);
                novo = false;
                Preenchertabela();
            }

        } else if (alterando) {

     
            comparaAltera();
            limpaCampos();
            Preenchertabela();
            estadoBotoes(true);
            alterando = false;
        }
     
    }//GEN-LAST:event_btnSalvarActionPerformed

    public void mascara() {

        if (ftfCpfCnpj.getText().isEmpty()) {

            if (lblCpfCnpj.getText().equals("CPF")) {
                lblCpfCnpj.setText("CPF");
                try {
                    ftfCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
                } catch (java.text.ParseException ex) {
                    ex.printStackTrace();
                }

            } else {
                lblCpfCnpj.setText("CNPJ");

                try {
                    ftfCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
                } catch (java.text.ParseException ex) {
                    ex.printStackTrace();
                }

            }

        }

    }

    public Cliente retornaCliente(int id) {
        Cliente c = new Cliente();


        int numero;
        String nome, logradouro, complemento, bairro, municipio, estado, telefone, cpfCnpj;

        cpfCnpj = ftfCpfCnpj.getText();
        id = cdao.proximoCodigo();
        nome = tfdNome.getText();
        logradouro = tfdLogradouro.getText();
        complemento = tfdComplemento.getText();
        bairro = tfdBairro.getText();
        municipio = tfdMunicipio.getText();
        estado = cbEstado.getItemAt(cbEstado.getSelectedIndex());
        telefone = ftfTelefone.getText();
        numero = Integer.parseInt(tfdNumero.getText());

        return c;
    }


    private void ftfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfTelefoneActionPerformed
        
    }//GEN-LAST:event_ftfTelefoneActionPerformed

    private void ftfCpfCnpjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ftfCpfCnpjMouseClicked

    }//GEN-LAST:event_ftfCpfCnpjMouseClicked

    private void ftfCpfCnpjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfCpfCnpjKeyPressed
        if (ftfCpfCnpj.getText().isEmpty()) {
            mascara();
        }
    }//GEN-LAST:event_ftfCpfCnpjKeyPressed

    private void cbTipoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoPesquisaItemStateChanged
        
    }//GEN-LAST:event_cbTipoPesquisaItemStateChanged

    private void cbTipoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPesquisaActionPerformed
        
    }//GEN-LAST:event_cbTipoPesquisaActionPerformed

    private void tfdPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdPesquisaMouseClicked
        tfdPesquisa.setText("");
    }//GEN-LAST:event_tfdPesquisaMouseClicked

    private void btnIncluiAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluiAnimalActionPerformed

        if (tabelaClientes.getSelectedRow() >= 0) {
            TelaAnimaCadastrar ta = new TelaAnimaCadastrar(Integer.parseInt(tfdId.getText()));
            tp.getDekstop().add(ta);
            ta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione um cliente antes de vincular um animal");
        }


    }//GEN-LAST:event_btnIncluiAnimalActionPerformed

    private void tabelaClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseEntered
     
    }//GEN-LAST:event_tabelaClientesMouseEntered

    private void btnAbrirtelaAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirtelaAnimalActionPerformed
        TelaA tanimal = new TelaA();
        tp.getDekstop().add(tanimal);
        tanimal.setVisible(true);
    }//GEN-LAST:event_btnAbrirtelaAnimalActionPerformed

    public void incluir() {
        String op = (String) cbTipoCliente.getSelectedItem();
        int id, numero, option = 0;
        String nome, logradouro, complemento, bairro, municipio, estado, telefone, cpfCnpj;

        cpfCnpj = ftfCpfCnpj.getText();
        id = cdao.proximoCodigo();
        nome = tfdNome.getText();
        logradouro = tfdLogradouro.getText();
        complemento = tfdComplemento.getText();
        bairro = tfdBairro.getText();
        municipio = tfdMunicipio.getText();
        estado = cbEstado.getItemAt(cbEstado.getSelectedIndex());
        telefone = ftfTelefone.getText();
        try{
            numero = Integer.parseInt(tfdNumero.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Numero Inválido");
            return;
        }
        
        if ("Física".equals(op)) {
            option = 1;

            cliF = new Fisica(cpfCnpj, id, nome, logradouro, numero, complemento, bairro,
                    municipio, estado, telefone, null);

            if (cdao.incluirCliente(cliF)) {
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja adicionar um animal?");

                if (JOptionPane.YES_OPTION == opcao) {
                    TelaAnimaCadastrar tanimalcad = new TelaAnimaCadastrar(id);
                    tp.getDekstop().add(tanimalcad);
                    tanimalcad.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não possui animal");
                }
            }

        } else if ("Jurídica".equals(op)) {
            option = 2;
            lblCpfCnpj.setText("CNPJ");
            id = cdao.proximoCodigo();
            cliJ = new Juridica(cpfCnpj, id, nome, logradouro, numero, complemento, bairro,
                    municipio, estado, telefone, null);

            if (cdao.incluirCliente(cliJ)) {
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja adicionar um animal?");

                if (JOptionPane.YES_OPTION == opcao) {
                    TelaAnimaCadastrar tanimalcad = new TelaAnimaCadastrar(id);
                    tp.getDekstop().add(tanimalcad);
                    tanimalcad.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não possui animal");
                }
            }

        }

        novaLinha(option);

    }

    public void novaLinha(int op) {

        if (op == 1) {

            DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
            modelo.addRow(new Object[]{
                (cdao.proximoCodigo() - 1),
                Integer.parseInt(tfdId.getText()),
                tfdNome.getText(),
                Integer.parseInt(tfdNumero.getText()),
                tfdComplemento.getText(),
                tfdBairro.getText(),
                tfdMunicipio.getText(),
                cbEstado.getSelectedIndex(),
                ftfTelefone.getText(),
                ftfCpfCnpj.getText(),
                "-"

            });

        } else {

            DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
            modelo.addRow(new Object[]{
                (cdao.proximoCodigo() - 1),
                Integer.parseInt(tfdId.getText()),
                tfdNome.getText(),
                Integer.parseInt(tfdNumero.getText()),
                tfdComplemento.getText(),
                tfdBairro.getText(),
                tfdMunicipio.getText(),
                cbEstado.getSelectedIndex(),
                ftfTelefone.getText(),
                "-",
                ftfCpfCnpj.getText()

            });

        }

    }

    public void excluirCliente(int id) {

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Deseja Excluir Cliente?", "Exclusão de Clientes", dialogButton);
        if (dialogResult == 0) {
            cdao.apagar(id);
            limpaCampos();
            estadoBotoes(true);
            JOptionPane.showMessageDialog(this, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Cliente mantido!");
            
        }


       
    }

    public void estadoBotoesAlterar() {
        btnAlterar.setVisible(false);
        btnExcluir.setVisible(false);
        btnSalvar.setVisible(true);
        btnCancelar.setVisible(true);
        btnNovo.setVisible(false);
    }

    private void estadoBotoes(boolean aux) {
        btnAlterar.setVisible(aux);
        btnExcluir.setVisible(aux);
        btnNovo.setVisible(aux);
        btnSalvar.setVisible(!aux);
        btnCancelar.setVisible(!aux);
    }

    public void setarCampos() {

        int setar = tabelaClientes.getSelectedRow();
        tfdId.setText(tabelaClientes.getValueAt(setar, 0).toString());
        tfdNome.setText(tabelaClientes.getValueAt(setar, 1).toString());
        tfdLogradouro.setText(tabelaClientes.getValueAt(setar, 2).toString());
        tfdNumero.setText(tabelaClientes.getValueAt(setar, 3).toString());
        tfdComplemento.setText(tabelaClientes.getValueAt(setar, 4).toString());
        tfdBairro.setText(tabelaClientes.getValueAt(setar, 5).toString());
        tfdMunicipio.setText(tabelaClientes.getValueAt(setar, 6).toString());
        ftfTelefone.setText(tabelaClientes.getValueAt(setar, 8).toString());
        cbEstado.setSelectedItem(tabelaClientes.getValueAt(setar, 7).toString());


        if (!tabelaClientes.getValueAt(setar, 9).toString().equals("-")) {
             cbTipoCliente.setSelectedIndex(1);
            lblCpfCnpj.setText("CPF");
            ftfCpfCnpj.setText(tabelaClientes.getValueAt(setar, 9).toString());

        } else {
            cbTipoCliente.setSelectedIndex(2);

            lblCpfCnpj.setText("CNPJ");
            ftfCpfCnpj.setText(tabelaClientes.getValueAt(setar, 10).toString());
        }

    }

    public void lerAnimaldoCliente(int id) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaAnimaisCliente.getModel();
        while (tabelaAnimaisCliente.getModel().getRowCount() > 0) {
            modelo.removeRow(0);
        }

        AnimalDAO adao = new AnimalDAO();
        ArrayList<Animal> animais = new ArrayList<>();
        animais = adao.listarAnimaisPorCliente(id);

        if (!animais.isEmpty()) {
            for (Animal a : animais) {
                modelo.addRow(new Object[]{
                    a.getId(),
                    a.getNome(),
                    a.getRaca()

                });

            }
        }

    }

    public void Preenchertabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        while (tabelaClientes.getModel().getRowCount() > 0) {
            modelo.removeRow(0);
        }

        ClienteDAO cliDAO = new ClienteDAO();

        for (Fisica c : cliDAO.listaFisica()) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getLogradouro(),
                c.getNumero(),
                c.getComplemento(),
                c.getBairro(),
                c.getMunicipio(),
                c.getEstado(),
                c.getTelefone(),
                c.getCpf(),
                "-"

            });
        }

        for (Juridica c : cliDAO.listaJuridica()) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getLogradouro(),
                c.getNumero(),
                c.getComplemento(),
                c.getBairro(),
                c.getMunicipio(),
                c.getEstado(),
                c.getTelefone(),
                "-",
                c.getCnpj()
            });
        }

    }

    public void comparaAltera() {

        int numero;
        String nome, logradouro, complemento, bairro, municipio, estado, telefone, cpfCnpj;
        estadoBotoes(true);

        nome = tfdNome.getText();
        logradouro = tfdLogradouro.getText();
        complemento = tfdComplemento.getText();
        bairro = tfdBairro.getText();
        municipio = tfdMunicipio.getText();
        estado = cbEstado.getItemAt(cbEstado.getSelectedIndex());
        telefone = ftfTelefone.getText();
        numero = Integer.parseInt(tfdNumero.getText());
        cpfCnpj = ftfCpfCnpj.getText();

        if (lblCpfCnpj.getText().equals("CPF")) {

            Fisica cf = new Fisica();

            cf.setId(Integer.parseInt(tfdId.getText().toString()));
            cf.setNome(nome);
            cf.setLogradouro(logradouro);
            cf.setComplemento(complemento);
            cf.setBairro(bairro);
            cf.setMunicipio(municipio);
            cf.setEstado(estado);
            cf.setTelefone(telefone);
            cf.setNumero(numero);
            cf.setCpf(cpfCnpj);

            boolean deu = cdao.alterarCli(cf);
            if (deu) {
                JOptionPane.showMessageDialog(null, "Alterado!");
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro");
            }

        } else {
            Juridica cj = new Juridica();

            cj.setId(Integer.parseInt(tfdId.getText().toString()));
            cj.setNome(nome);
            cj.setLogradouro(logradouro);
            cj.setComplemento(complemento);
            cj.setBairro(bairro);
            cj.setMunicipio(municipio);
            cj.setEstado(estado);
            cj.setTelefone(telefone);
            cj.setNumero(numero);
            cj.setCnpj(cpfCnpj);

            boolean deu = cdao.alterarCli(cj);
            if (deu) {
                JOptionPane.showMessageDialog(null, "Alterado!");
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro");
            }

        }

    }
    
    

    public void limpaTabela() {

        if (tabelaClientes.getRowCount() > 0) {
            for (int i = 0; i <= tabelaClientes.getRowCount(); i++) {
                modelo.removeRow(i);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirtelaAnimal;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluiAnimal;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbTipoCliente;
    private javax.swing.JComboBox<String> cbTipoPesquisa;
    private javax.swing.JFormattedTextField ftfCpfCnpj;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCpfCnpj;
    private javax.swing.JTable tabelaAnimaisCliente;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField tfdBairro;
    private javax.swing.JTextField tfdComplemento;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdLogradouro;
    private javax.swing.JTextField tfdMunicipio;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdNumero;
    private javax.swing.JTextField tfdPesquisa;
    // End of variables declaration//GEN-END:variables
}
