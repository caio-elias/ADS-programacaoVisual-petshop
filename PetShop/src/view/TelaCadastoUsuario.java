package view;

import controller.Criptografia;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Usuario;
import modelDAO.UsuarioDAO;

public class TelaCadastoUsuario extends javax.swing.JFrame {

    public TelaCadastoUsuario() {
        initComponents();
    }

    public void cadastrar() {
        UsuarioDAO udao = new UsuarioDAO();
        String usuario, senha, perfil;
        usuario = tfdUser.getText();
        senha = new String(tfdSenha.getPassword());
        perfil = (String) cbPerfil.getSelectedItem();

        if ((senha == null || usuario == null) || ((senha.trim().equals("")) || (usuario.trim().equals("")))) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            senha = Criptografia.criptografar(senha);
            Usuario usr = new Usuario(usuario, senha, perfil);
            if (!udao.verificaUsuario(usuario)) {
                udao.incluir(usr);
                TelaGerenciaUsuario tu = new TelaGerenciaUsuario();
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                tfdUser.setText("");
                tfdSenha.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário existente!");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        tfdUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdSenha = new javax.swing.JPasswordField();
        btnCadastrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbPerfil = new javax.swing.JComboBox<>();
        lblPerfil = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(870, 510));
        getContentPane().setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Cadastro de Usuário");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(330, 40, 290, 86);

        tfdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdUserActionPerformed(evt);
            }
        });
        tfdUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdUserKeyPressed(evt);
            }
        });
        getContentPane().add(tfdUser);
        tfdUser.setBounds(310, 160, 360, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel2.setText("Digite o usuário:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 180, 150, 18);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setText("Digite a senha: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 240, 130, 15);

        tfdSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdSenhaActionPerformed(evt);
            }
        });
        tfdSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(tfdSenha);
        tfdSenha.setBounds(310, 230, 360, 40);

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(490, 390, 140, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancela.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 390, 140, 40);

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin", " " }));
        getContentPane().add(cbPerfil);
        cbPerfil.setBounds(460, 280, 200, 50);

        lblPerfil.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblPerfil.setText("Perfil:");
        getContentPane().add(lblPerfil);
        lblPerfil.setBounds(310, 310, 51, 15);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo0.jpg"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 920, 550);

        setSize(new java.awt.Dimension(922, 572));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void tfdUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrar();
        }

    }//GEN-LAST:event_tfdUserKeyPressed

    private void tfdSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrar();
        }

    }//GEN-LAST:event_tfdSenhaKeyPressed

    private void tfdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdUserActionPerformed
        
    }//GEN-LAST:event_tfdUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfdSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdSenhaActionPerformed
        
    }//GEN-LAST:event_tfdSenhaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField tfdSenha;
    private javax.swing.JTextField tfdUser;
    // End of variables declaration//GEN-END:variables
}
