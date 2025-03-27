package view;

import controller.Criptografia;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Usuario;
import modelDAO.UsuarioDAO;

public class TelaGerenciaUsuario extends javax.swing.JFrame {

    public TelaGerenciaUsuario() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblUsers.getModel();
        tblUsers.setRowSorter(new TableRowSorter(modelo));
        
        lerTabela();

    }

    public void lerTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tblUsers.getModel();

        UsuarioDAO udao = new UsuarioDAO();

        for (Usuario u : udao.listar()) {

            modelo.addRow(new Object[]{
                u.getId(),
                u.getUsuario(),
                u.getPerfil()
            });
        }

    }

    public void setarCampos() {
        int linha = tblUsers.getSelectedRow();
        tfdUser.setText(tblUsers.getValueAt(linha, 1).toString());
        tfdSenha.setText("******");
        cbPerfil.setSelectedItem(tblUsers.getValueAt(linha, 2).toString());
    }

    public void excluir() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblUsers.getModel();
            UsuarioDAO udao = new UsuarioDAO();
            String usuario;
            usuario = tblUsers.getValueAt(tblUsers.getSelectedRow(), 1).toString();
            udao.apagar(usuario);
            JOptionPane.showMessageDialog(this, "Excluído com sucesso!");
            dispose();
            new TelaGerenciaUsuario().setVisible(true);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário na tabela!");
        }

    }

    public void alterar() { 
        try {
            UsuarioDAO udao = new UsuarioDAO();
            String usuario, senha, perfil;
            usuario = tfdUser.getText();
            senha = new String(tfdSenha.getPassword());
            String usertabela = tblUsers.getValueAt(tblUsers.getSelectedRow(), 1).toString();

            if (senha.equals("******")) {
                if (usuario==usertabela){
                    Usuario a = udao.retornaUsuario(usuario);
                    senha = a.getSenha();
                }else{
                   Usuario a = udao.retornaUsuario(usertabela);
                   senha = a.getSenha();
                }
                
               
            } else {
                senha = Criptografia.criptografar(senha);
            }

            perfil = cbPerfil.getSelectedItem().toString();
            int id = Integer.valueOf(tblUsers.getValueAt(tblUsers.getSelectedRow(), 0).toString());
            Usuario user = new Usuario(usuario, senha, perfil);
            user.setId(id);

            Usuario diferente = udao.retornaUsuario(usuario);

            if ((udao.verificaUsuario(usuario)) && (diferente.getId() != id)) {
                JOptionPane.showMessageDialog(null, "Usuário já existente!");
            } else {
                udao.alterar(user);
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                dispose();
                new TelaGerenciaUsuario().setVisible(true);
            }     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        tfdUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfdSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsers.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblUsers.setForeground(new java.awt.Color(0, 0, 0));
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuário", "Perfil"
            }
        ));
        tblUsers.setRowHeight(30);
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        tblUsers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblUsersKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsers);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 590, 180));

        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 130, 40));

        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 110, 40));

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 110, 40));

        tfdUser.setToolTipText("Selecione um campo da tabela");
        tfdUser.setEnabled(false);
        tfdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdUserActionPerformed(evt);
            }
        });
        getContentPane().add(tfdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 340, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel2.setText("Nova Senha: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setText("Novo Usuário:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin" }));
        getContentPane().add(cbPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 120, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setText("Perfil:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 60, 30));

        tfdSenha.setToolTipText("Selecione um campo da tabela");
        tfdSenha.setEnabled(false);
        tfdSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdSenhaMouseClicked(evt);
            }
        });
        getContentPane().add(tfdSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 340, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logout256_24927.png"))); // NOI18N
        jButton1.setToolTipText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 60, 60));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo0.jpg"))); // NOI18N
        lblFundo.setText("jLabel1");
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 480));

        setSize(new java.awt.Dimension(829, 504));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        new TelaCadastoUsuario().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        int dialog= JOptionPane.showConfirmDialog(null,"Confirma exclusão?");
         if(dialog == JOptionPane.YES_OPTION){
             excluir();
             
         }
        
       

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

            int dialog = JOptionPane.showConfirmDialog(null, "Confirma alteração?");
            if (dialog == JOptionPane.YES_OPTION) {
                
                alterar();
            }
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
        setarCampos();  
        tfdUser.setEnabled(true);
        tfdSenha.setEnabled(true);
    }//GEN-LAST:event_tblUsersMouseClicked

    private void tfdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdUserActionPerformed
        
    }//GEN-LAST:event_tfdUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfdSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdSenhaMouseClicked
        tfdSenha.setText("");
    }//GEN-LAST:event_tfdSenhaMouseClicked

    private void tblUsersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblUsersKeyReleased
        setarCampos();  
        tfdUser.setEnabled(true);
        tfdSenha.setEnabled(true);
    }//GEN-LAST:event_tblUsersKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JTable tblUsers;
    private javax.swing.JPasswordField tfdSenha;
    private javax.swing.JTextField tfdUser;
    // End of variables declaration//GEN-END:variables
}
