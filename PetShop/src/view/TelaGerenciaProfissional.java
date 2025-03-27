package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Profissional;
import modelDAO.ProfissionalDAO;

public class TelaGerenciaProfissional extends javax.swing.JInternalFrame {

    public TelaGerenciaProfissional() {
        initComponents();
        lerTabela();
    }

    public void lerTabela() {

        DefaultTableModel modeloP = (DefaultTableModel) tblPros.getModel();
        while (tblPros.getModel().getRowCount() > 0) {
            modeloP.removeRow(0);
        }

        ProfissionalDAO pdao = new ProfissionalDAO();

        for (Profissional p : pdao.listarProfissionais()) {

            modeloP.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getEspecialidade()
            });
        }

    }

    public void limpaCampos() {
        tfdNome.setText("");
        tfdEspecialidade.setText("");
    }
    


    public void excluirPro() {
        try {
            DefaultTableModel modeloP = (DefaultTableModel) tblPros.getModel();
            ProfissionalDAO pdao = new ProfissionalDAO();
            int idpro;
            idpro = Integer.parseInt(tblPros.getValueAt(tblPros.getSelectedRow(), 0).toString());
            pdao.apagar(idpro);
            JOptionPane.showMessageDialog(this, "Excluído com sucesso!");
            lerTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um profissional na tabela! " + e);
        }

    }

    public void alterarPro() {
        try {
            ProfissionalDAO pdao = new ProfissionalDAO();
            String nome, especialidade, perfil;
            int id = Integer.parseInt(tblPros.getValueAt(tblPros.getSelectedRow(), 0).toString());
            nome = tfdNome.getText();
            especialidade = tfdEspecialidade.getText();

            Profissional pro = new Profissional(especialidade, nome);
            pro.setId(id);
            pdao.alterar(pro);
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            lerTabela();
           
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um profissional na tabela " + e);
        }
    }

    public void setarCampos() {
        int linha = tblPros.getSelectedRow();
        tfdNome.setText(tblPros.getValueAt(linha, 1).toString());
        tfdEspecialidade.setText(tblPros.getValueAt(linha, 2).toString());
    }

    public void cadastrarPro() {
        ProfissionalDAO pdao = new ProfissionalDAO();
        String especialidade, nome;
        nome = tfdNome.getText();
        especialidade = tfdEspecialidade.getText();
        Profissional pro = new Profissional(especialidade, nome);

        if (tfdNome.getText().isEmpty() || tfdEspecialidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            pdao.incluir(pro);
            JOptionPane.showMessageDialog(null, "Profissional cadastrado com sucesso!");
            tfdNome.setText("");
            tfdEspecialidade.setText("");
            lerTabela();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfdEspecialidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPros = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Profissionais");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Nome: ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Especialidade: ");

        tblPros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Especialidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPros.setRowHeight(20);
        tblPros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProsMouseClicked(evt);
            }
        });
        tblPros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPros);
        if (tblPros.getColumnModel().getColumnCount() > 0) {
            tblPros.getColumnModel().getColumn(0).setMinWidth(70);
            tblPros.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblPros.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DocumentEdit_40924.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/criar.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancela.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfdEspecialidade)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(tfdNome)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditar, btnExcluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(tfdEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        cadastrarPro();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int dialog = JOptionPane.showConfirmDialog(null, "Confirma exclusão?");
        if (dialog == JOptionPane.YES_OPTION) {
            excluirPro();
            limpaCampos();

        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        alterarPro();
        limpaCampos();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblProsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProsMouseClicked
        setarCampos();
        btnExcluir.setEnabled(true);
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_tblProsMouseClicked

    private void tblProsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProsKeyReleased
        setarCampos();
    }//GEN-LAST:event_tblProsKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPros;
    private javax.swing.JTextField tfdEspecialidade;
    private javax.swing.JTextField tfdNome;
    // End of variables declaration//GEN-END:variables
}
