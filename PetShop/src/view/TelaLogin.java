package view;

import controller.Conexao;
import controller.Criptografia;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import model.Usuario;
import modelDAO.UsuarioDAO;


public class TelaLogin extends javax.swing.JFrame {
    private Connection conn = null;
    

    public TelaLogin() {
        initComponents();
        Conexao a =  Conexao.obterInstancia();
	conn = a.obterConexao();
    }
    
    
    public void Criptografar(String senha){
        MessageDigest md = null;
        String retorno = null;
        try {
            md=MessageDigest.getInstance("MD5");
            
            
        } 
        catch (Exception e) {
        }
    }
    
    
    public void logar(){
        UsuarioDAO udao = new UsuarioDAO();
        String user,senha,perfil;
        user=tfdUser.getText();
        senha=new String(tfdSenha.getPassword());
        senha = Criptografia.criptografar(senha);
        perfil=udao.retornaPerfil(user, senha);
        if (perfil.equals("admin")||(perfil.equals("user"))){
            TelaPrincipal tp = new TelaPrincipal();
            if (perfil.equals("admin")){
                tp.itemCadUser.setEnabled(true);
                tp.ItemGerUser.setEnabled(true);
            }
            tp.setExtendedState(JFrame.MAXIMIZED_BOTH);
            tp.setVisible(true);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        tfdSenha = new javax.swing.JPasswordField();
        tfdUser = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblFundoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 120, 40));

        tfdSenha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfdSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(tfdSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 360, 40));

        tfdUser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfdUser.setForeground(new java.awt.Color(102, 102, 102));
        tfdUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfdUserKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdUserKeyPressed(evt);
            }
        });
        getContentPane().add(tfdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 360, 40));

        lblUser.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblUser.setText("Usuário: ");
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        lblSenha.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblSenha.setText("Senha: ");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logojonespetshop_1.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        lblFundoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo0.jpg"))); // NOI18N
        getContentPane().add(lblFundoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 870, 520));

        setSize(new java.awt.Dimension(874, 540));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       logar();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void tfdUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdUserKeyPressed
     if (evt.getKeyCode()== KeyEvent.VK_ENTER){
        logar();
       }
    }//GEN-LAST:event_tfdUserKeyPressed

    private void tfdSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdSenhaKeyPressed
       if (evt.getKeyCode()== KeyEvent.VK_ENTER){
        logar();
       }
    }//GEN-LAST:event_tfdSenhaKeyPressed

    private void tfdUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdUserKeyTyped
      
    }//GEN-LAST:event_tfdUserKeyTyped

  
    public static void main(String args[]) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            
        } catch (ClassNotFoundException e) {
            
        } catch (InstantiationException e) {
            
        } catch (IllegalAccessException e) {
           
        }
        UsuarioDAO ud= new UsuarioDAO();
       if(ud.listar().isEmpty()){
           String usuario, senha, perfil;
           JOptionPane.showMessageDialog(null, "ESTE É SEU PRIMEIRO ACESSO!!\nDEFINA A SEGUIR UM NOME DE USUÁRIO E SENHA.\n"
                   + "ESTE USUÁRIO SERÁ UM ADMINISTRADOR.\n"
                   + "VOCÊ PODERAR ALTERAR OU EXCLUÍ-LO ASSIM QUE DESEJAR.");
           do{
                usuario = JOptionPane.showInputDialog("USUÁRIO:");
           }while(usuario.isEmpty());
           do{
                senha  = JOptionPane.showInputDialog("SENHA:");
           }while(senha.isEmpty());
           senha = Criptografia.criptografar(senha);
           perfil =  "admin";
           Usuario usr = new Usuario(usuario, senha, perfil);
           ud.incluir(usr);
           
           TelaPrincipal tp = new TelaPrincipal();
                tp.itemCadUser.setEnabled(true);
                tp.ItemGerUser.setEnabled(true);
            tp.setExtendedState(JFrame.MAXIMIZED_BOTH);
            tp.setVisible(true);
       }else{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
                
            }
        });}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblFundoLogin;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField tfdSenha;
    private javax.swing.JTextField tfdUser;
    // End of variables declaration//GEN-END:variables
}
