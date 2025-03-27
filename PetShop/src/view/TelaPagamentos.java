package view;

import controller.GerenciaContas;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Conta;


public class TelaPagamentos extends javax.swing.JInternalFrame {

    ArrayList<Conta> contas;
    GerenciaContas geConta;

    public TelaPagamentos() {
        initComponents();
        geConta = new GerenciaContas();
    }

    public void populaTabelaPagamento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DefaultTableModel modeloPagamento = (DefaultTableModel) tblPagamento.getModel();
        while (tblPagamento.getModel().getRowCount() > 0) {
            modeloPagamento.removeRow(0);
        }
        NumberFormat formatarFloat = new DecimalFormat("#.##");

        String nome = tfdNome.getText();
        contas = geConta.retornarContasParceladasPorNome(nome);

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
                valorPagoformatado,});
        }
    }

    public void calculaTroco() {
        if (!tfdQuantiaRecebida.getText().isEmpty()) {
            float vaSerPago, quantiaRecebida, desconto, diferenca;
            vaSerPago = Float.parseFloat(tfdVpago.getText());
            quantiaRecebida = Float.parseFloat(tfdQuantiaRecebida.getText());
            desconto = Float.parseFloat(tfdDesconto.getText());
            diferenca = (float) (quantiaRecebida - (vaSerPago - ((vaSerPago * desconto) / 100.0)));

            String troco = String.format("%.2f", diferenca);
            tfdTroco.setText(troco);
        }

    }

    public void pagar() {
        float valoraSerPago = Float.parseFloat(tfdVpago.getText());
        float quantiaRecebida = Float.parseFloat(tfdQuantiaRecebida.getText());
        if (quantiaRecebida < valoraSerPago) {
            JOptionPane.showMessageDialog(null, "Quantia recebida inferior ao valor a ser pago!");
        } else {
            int linhaSelecionada = tblPagamento.getSelectedRow();
            float valorPago = Float.parseFloat(tblPagamento.getValueAt(linhaSelecionada, 5).toString());
            float valorParcela = Float.parseFloat(tblPagamento.getValueAt(linhaSelecionada, 4).toString());
            int idParcela = Integer.parseInt(tblPagamento.getModel().getValueAt(linhaSelecionada, 1).toString());
            if (valoraSerPago > valorParcela - valorPago) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
            } else {
                geConta.pagarConta(idParcela, valoraSerPago);
                JOptionPane.showMessageDialog(null, "Recebido!");
                populaTabelaPagamento();
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagamento = new javax.swing.JTable();
        tfdVpago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfdQuantiaRecebida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdTroco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdDesconto = new javax.swing.JTextField();

        setBackground(new java.awt.Color(237, 237, 247));
        setClosable(true);
        setIconifiable(true);
        setTitle("Pagamento");

        jLabel1.setText("Nome do Cliente:");

        tfdNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdNomeKeyPressed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

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
        tblPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPagamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPagamento);

        tfdVpago.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfdVpago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdVpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdVpagoActionPerformed(evt);
            }
        });
        tfdVpago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdVpagoKeyPressed(evt);
            }
        });

        jLabel2.setText("Valor a ser pago:");

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pagar.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        btnPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPagarKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logout256_24927.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantia recebida: ");

        tfdQuantiaRecebida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdQuantiaRecebida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfdQuantiaRecebidaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdQuantiaRecebidaFocusLost(evt);
            }
        });
        tfdQuantiaRecebida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdQuantiaRecebidaKeyPressed(evt);
            }
        });

        jLabel4.setText("Troco: ");

        tfdTroco.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Desconto: ");

        tfdDesconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfdDesconto.setText("0.00");
        tfdDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfdDescontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdDescontoFocusLost(evt);
            }
        });
        tfdDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdDescontoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfdVpago)
                                        .addGap(47, 47, 47)
                                        .addComponent(tfdQuantiaRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel3)))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(jLabel5))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(tfdTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(30, 30, 30)
                                .addComponent(btnPagar))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPesquisar)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfdDesconto, tfdQuantiaRecebida, tfdTroco, tfdVpago});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPagar, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdQuantiaRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdVpago, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfdDesconto, tfdQuantiaRecebida, tfdTroco, tfdVpago});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPagar, jButton1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdNomeKeyPressed

        populaTabelaPagamento();

    }//GEN-LAST:event_tfdNomeKeyPressed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        populaTabelaPagamento();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int linhaselec = tblPagamento.getSelectedRow();
        if (linhaselec != -1) {
            try {
                pagar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma parcela selecionada! ");
        }

    }//GEN-LAST:event_btnPagarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfdVpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdVpagoActionPerformed

    }//GEN-LAST:event_tfdVpagoActionPerformed

    private void tfdVpagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdVpagoKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                tfdQuantiaRecebida.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido!");
        }
    }//GEN-LAST:event_tfdVpagoKeyPressed

    private void tfdQuantiaRecebidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdQuantiaRecebidaKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                float valoraSerpago = Float.parseFloat(tfdVpago.getText());
                float quantiaRecebida = Float.parseFloat(tfdQuantiaRecebida.getText());
                if (quantiaRecebida < valoraSerpago) {
                    JOptionPane.showMessageDialog(null, "Quantia recebida inferior ao valor a ser pago!");
                    tfdTroco.setText("");
                } else {
                    calculaTroco();
                    tfdDesconto.requestFocus();
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido! " + e.getMessage());
        }
    }//GEN-LAST:event_tfdQuantiaRecebidaKeyPressed

    private void tfdDescontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdDescontoFocusGained
        tfdDesconto.setText("");
    }//GEN-LAST:event_tfdDescontoFocusGained

    private void tfdDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdDescontoFocusLost
        if (tfdDesconto.getText().isEmpty()) {
            tfdDesconto.setText("0.00");
        }
    }//GEN-LAST:event_tfdDescontoFocusLost

    private void tfdDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdDescontoKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (tfdDesconto.getText().isEmpty()) {
                    tfdDesconto.setText("0.00");
                }
                calculaTroco();
                btnPagar.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido! " + e.getMessage());
        }
    }//GEN-LAST:event_tfdDescontoKeyPressed

    private void btnPagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPagarKeyPressed

    }//GEN-LAST:event_btnPagarKeyPressed

    private void tblPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPagamentoMouseClicked
        tfdVpago.setText("");
        tfdQuantiaRecebida.setText("0.00");
        tfdDesconto.setText("0.00");
        tfdTroco.setText("0.00");
        tfdVpago.requestFocus();
    }//GEN-LAST:event_tblPagamentoMouseClicked

    private void tfdQuantiaRecebidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdQuantiaRecebidaFocusGained
        tfdQuantiaRecebida.setText("");
    }//GEN-LAST:event_tfdQuantiaRecebidaFocusGained

    private void tfdQuantiaRecebidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdQuantiaRecebidaFocusLost
        if (tfdQuantiaRecebida.getText().isEmpty()) {
            tfdQuantiaRecebida.setText("0.00");
        }
    }//GEN-LAST:event_tfdQuantiaRecebidaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPagamento;
    private javax.swing.JTextField tfdDesconto;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdQuantiaRecebida;
    private javax.swing.JTextField tfdTroco;
    private javax.swing.JTextField tfdVpago;
    // End of variables declaration//GEN-END:variables
}
