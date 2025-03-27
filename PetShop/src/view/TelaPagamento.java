
package view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Conta;
import modelDAO.ContaDAO;


public class TelaPagamento extends javax.swing.JFrame {

    ArrayList<Conta> contas;
    ContaDAO cdao ;
    
    public TelaPagamento() {
        initComponents();
    }

    public void populaTabelaPagamento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DefaultTableModel modeloPagamento = (DefaultTableModel) tblPagamento.getModel();
        while (tblPagamento.getModel().getRowCount() > 0) {
            modeloPagamento.removeRow(0);
        }
        cdao = new ContaDAO();
        NumberFormat formatarFloat = new DecimalFormat("#.##");

        String nome = tfdNome.getText();
        contas = cdao.retornaContasParceladasPorNome(nome);
        
        
        for (Conta c : contas) {
            float valor = c.getParcela().getValor();
            float valorPago = c.getParcela().getValorPago();
            float valorformatado = Float.parseFloat(formatarFloat.format(valor).replace(",", "."));
            float valorPagoformatado = Float.parseFloat(formatarFloat.format(valorPago).replace(",", "."));
            modeloPagamento.addRow(new Object[]{
                c.getId(),
                c.getParcela().getId(),
                c.getCliente().getNome(),
                c.getParcela().getDataVenc().format(formatter),
                valorformatado,
                valorPagoformatado,
               });
        }
    }
    
    public void pagar(){
        float valorPago = Float.parseFloat(tfdVpago.getText());
        int linhaSelecionada = tblPagamento.getSelectedRow();
        int idParcela = Integer.parseInt(tblPagamento.getModel().getValueAt(linhaSelecionada, 1).toString());
        
        cdao.pagarConta(idParcela, valorPago);
        JOptionPane.showMessageDialog(null, "Sucesso!");
        populaTabelaPagamento();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfdVpago = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagamento = new javax.swing.JTable();
        btnPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome do Cliente:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor a ser pago:");

        tfdVpago.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfdVpago.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tblPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Conta", "ID Parcela", "Nome do Cliente", "Data Vencimento", "Valor Parcela", "Valor Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPagamento.setRowHeight(35);
        jScrollPane1.setViewportView(tblPagamento);
        if (tblPagamento.getColumnModel().getColumnCount() > 0) {
            tblPagamento.getColumnModel().getColumn(0).setMinWidth(70);
            tblPagamento.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblPagamento.getColumnModel().getColumn(0).setMaxWidth(70);
            tblPagamento.getColumnModel().getColumn(1).setMinWidth(70);
            tblPagamento.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblPagamento.getColumnModel().getColumn(1).setMaxWidth(70);
            tblPagamento.getColumnModel().getColumn(3).setMinWidth(120);
            tblPagamento.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblPagamento.getColumnModel().getColumn(3).setMaxWidth(120);
            tblPagamento.getColumnModel().getColumn(4).setMinWidth(90);
            tblPagamento.getColumnModel().getColumn(4).setPreferredWidth(90);
            tblPagamento.getColumnModel().getColumn(4).setMaxWidth(90);
            tblPagamento.getColumnModel().getColumn(5).setMinWidth(90);
            tblPagamento.getColumnModel().getColumn(5).setPreferredWidth(90);
            tblPagamento.getColumnModel().getColumn(5).setMaxWidth(90);
        }

        btnPagar.setText("Efetuar Pagamento");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(415, 415, 415))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPagar)
                            .addComponent(tfdVpago, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(392, 392, 392))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfdVpago, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        populaTabelaPagamento();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int linhaselec = tblPagamento.getSelectedRow();
        if (linhaselec != -1) {
            try {
                pagar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma parcela selecionadoa! ");
        }
        
    }//GEN-LAST:event_btnPagarActionPerformed


    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPagamento;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdVpago;
    // End of variables declaration//GEN-END:variables
}
