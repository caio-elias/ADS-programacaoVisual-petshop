package view;

import controller.GerenciaAnimal;
import controller.ManipularImagem;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Animal;
import modelDAO.AnimalDAO;

public final class TelaAnimaCadastrar extends javax.swing.JInternalFrame {

    BufferedImage imagem;
    GerenciaAnimal gani = new GerenciaAnimal();

    ArrayList<Animal> animais;
    Animal a = new Animal();
    AnimalDAO adao = new AnimalDAO();
    int idCliente;

    public TelaAnimaCadastrar(int idCliente) {
        this.idCliente = idCliente;
        initComponents();

        proximoCod();
        setaidCli();

    }

    public void proximoCod() {
        tfdId.setText(new String("" + adao.proximoCodigo()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        btnInserirImagem = new javax.swing.JButton();
        tfdIdPropietario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdAltura = new javax.swing.JTextField();
        ftdDataNascimento = new javax.swing.JFormattedTextField();
        lblDataNasc = new javax.swing.JLabel();
        lblIdPropietario = new javax.swing.JLabel();
        lblNomedoAnimal = new javax.swing.JLabel();
        tfdNomeAnimal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdRaca = new javax.swing.JTextField();
        tfdPeso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tfdId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        rbMacho = new javax.swing.JRadioButton();
        rbFemea = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cadastro de Animais");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Selecione uma foto");
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
            ftdDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
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

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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
        rbFemea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemeaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbMacho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbFemea)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMacho)
                    .addComponent(rbFemea)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(112, 112, 112)
                                    .addComponent(btnInserirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(66, 66, 66)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfdNomeAnimal)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                    .addGap(10, 10, 10)
                                                    .addComponent(lblIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(tfdIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(lblDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(489, 489, 489))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(218, 218, 218)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(ftdDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(tfdAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfdPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfdRaca)))))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnInserirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addComponent(lblNomedoAnimal))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblIdPropietario)))
                        .addGap(6, 6, 6)
                        .addComponent(tfdNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftdDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 980, 500));
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

        lblFoto.setText("");
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), lblFoto.getWidth(), lblFoto.getHeight());

                lblFoto.setIcon(new ImageIcon(imagem.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH)));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Você não selecionou nenhum arquivo.");
            lblFoto.setText("Selecione uma foto");
        }
    }//GEN-LAST:event_btnInserirImagemActionPerformed


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (testaNulos()) {
            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos");
        } else {

            a.setNome(tfdNomeAnimal.getText());
            a.setRaca(tfdRaca.getText());
            a.setAltura(Float.parseFloat(tfdAltura.getText()));
            a.setPeso(Float.parseFloat(tfdPeso.getText()));
            a.setDataNascimento(LocalDate.parse(ftdDataNascimento.getText(), formatter));
            a.setFoto(ManipularImagem.getImgBytes(imagem));
            a.setIdCliente(Integer.parseInt(tfdIdPropietario.getText()));

            if (rbMacho.isSelected()) {
                a.setSexo("Macho");
                adao.inserir(a);
            } else {
                a.setSexo("Fêmea");
                adao.inserir(a);
            }

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Deseja vincular mais um animal?", "Cadastro de animais", dialogButton);
            if (dialogResult == 0) {
                limpa();

                proximoCod();

            } else {
                this.dispose();
            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    public void setaidCli() {
        tfdIdPropietario.setText(String.valueOf(idCliente));
    }


    private void tfdIdPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdIdPropietarioActionPerformed
        
    }//GEN-LAST:event_tfdIdPropietarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tfdIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdIdFocusLost
     
    }//GEN-LAST:event_tfdIdFocusLost

    private void rbMachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMachoActionPerformed
        
    }//GEN-LAST:event_rbMachoActionPerformed

    private void rbFemeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemeaActionPerformed
       
    }//GEN-LAST:event_rbFemeaActionPerformed

    public void limpa() {
        tfdId.setText(null);
        tfdAltura.setText(null);
        tfdNomeAnimal.setText(null);
        tfdPeso.setText(null);
        tfdRaca.setText(null);
        ftdDataNascimento.setText(null);
        lblFoto.setIcon(null);
        lblFoto.setText("Insira uma foto");
        rbFemea.setSelected(false);
        rbMacho.setSelected(false);

    }

    public boolean testaNulos() {

        if (tfdNomeAnimal.getText().isEmpty()
                || ftdDataNascimento.getText().isEmpty()
                || tfdRaca.getText().isEmpty()
                || tfdPeso.getText().isEmpty()
                || tfdAltura.getText().isEmpty()
                || lblFoto.getText().equals("Selecione uma foto")
                || (!rbMacho.isSelected() && !rbFemea.isSelected())) {
            return true;
        }

        return false;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInserirImagem;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField ftdDataNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblIdPropietario;
    private javax.swing.JLabel lblNomedoAnimal;
    private javax.swing.JRadioButton rbFemea;
    private javax.swing.JRadioButton rbMacho;
    private javax.swing.JTextField tfdAltura;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdIdPropietario;
    private javax.swing.JTextField tfdNomeAnimal;
    private javax.swing.JTextField tfdPeso;
    private javax.swing.JTextField tfdRaca;
    // End of variables declaration//GEN-END:variables
}
