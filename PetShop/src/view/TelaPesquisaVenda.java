
package view;

import controller.GerenciaContas;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Conta;
import model.Item;


public class TelaPesquisaVenda extends javax.swing.JFrame {

    ArrayList<Conta> contas;
    ArrayList<Item> itens;
    GerenciaContas geConta;

    public TelaPesquisaVenda() {
        initComponents();
        geConta = new GerenciaContas();

    }

    public String formatarDataParaUS(String dataBr) throws ParseException {
        String dataEmUmFormato = dataBr;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse(dataEmUmFormato);
        formato.applyPattern("yyyy-MM-dd");
        String dataFormatada = formato.format(data);
        return dataFormatada;
    }

    public static boolean isDateValid(String strDate) {
        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public void populaTabelaVendasBuscaPorNome() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DefaultTableModel modeloVendas = (DefaultTableModel) tblVendas.getModel();
        while (tblVendas.getModel().getRowCount() > 0) {
            modeloVendas.removeRow(0);
        }
        NumberFormat formatarFloat = new DecimalFormat("#.##");

        String nome = tfdDataNome.getText();
        contas = geConta.retornarContasporNome(nome);

        for (Conta c : contas) {
            float total = c.getTotal();
            float totalformatado = Float.parseFloat(formatarFloat.format(total).replace(",", "."));
            modeloVendas.addRow(new Object[]{
                c.getId(),
                c.getData().format(formatter),
                c.getCliente().getNome(),
                totalformatado,});
        }

    }

    public void populaTabelaVendasBuscaPorData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DefaultTableModel modeloVendas = (DefaultTableModel) tblVendas.getModel();
        while (tblVendas.getModel().getRowCount() > 0) {
            modeloVendas.removeRow(0);
        }
        NumberFormat formatarFloat = new DecimalFormat("#.##");
        String data = tfdDataNome.getText();
        if (isDateValid(data)) {
            try {
                data = formatarDataParaUS(data);
            } catch (ParseException ex) {
                Logger.getLogger(TelaPesquisaVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            contas = geConta.retornarContasporData(data);
            if (contas == null){
                JOptionPane.showMessageDialog(null, "Nenhuma venda na data informada");
            }else{
                for (Conta c : contas) {
                float total = c.getTotal();
                float totalformatado = Float.parseFloat(formatarFloat.format(total).replace(",", "."));
                modeloVendas.addRow(new Object[]{
                    c.getId(),
                    c.getData().format(formatter),
                    c.getCliente().getNome(),
                    totalformatado,});
                }
            }
            

        } else {
            JOptionPane.showMessageDialog(null, "Data inválida");
        }

    }

    public void limpaTabelaDetalheVendas() {
        DefaultTableModel modeloDetVendas = (DefaultTableModel) tblDetVenda.getModel();
        while (tblDetVenda.getModel().getRowCount() > 0) {
            modeloDetVendas.removeRow(0);
        }
    }

    public void populaTabelaDetalheVendas() {
        DefaultTableModel modeloDetVendas = (DefaultTableModel) tblDetVenda.getModel();
        limpaTabelaDetalheVendas();
        int linhaSelec = tblVendas.getSelectedRow();
        int id = Integer.parseInt(tblVendas.getModel().getValueAt(linhaSelec, 0).toString());
        itens = geConta.retornaItensDaConta(id);

        for (Item i : itens) {
            modeloDetVendas.addRow(new Object[]{
                i.getDescricao(),
                i.getQtdItConta(),
                i.getPreco(),});
        }

    }

    public void excluir() {
        try {
            int linhaselec = tblVendas.getSelectedRow();
            int id = Integer.parseInt(tblVendas.getValueAt(linhaselec, 0).toString());

            geConta.excluirConta(id);

            ((DefaultTableModel) tblVendas.getModel()).removeRow(linhaselec);
            limpaTabelaDetalheVendas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário na tabela! " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetVenda = new javax.swing.JTable();
        tfdDataNome = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        cbPesquisaVenda = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Vendas");
        setResizable(false);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data da Venda", "Cliente", "Total"
            }
        ));
        tblVendas.setRowHeight(35);
        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendas);
        if (tblVendas.getColumnModel().getColumnCount() > 0) {
            tblVendas.getColumnModel().getColumn(0).setMinWidth(70);
            tblVendas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblVendas.getColumnModel().getColumn(0).setMaxWidth(70);
            tblVendas.getColumnModel().getColumn(1).setMinWidth(110);
            tblVendas.getColumnModel().getColumn(1).setPreferredWidth(110);
            tblVendas.getColumnModel().getColumn(1).setMaxWidth(110);
            tblVendas.getColumnModel().getColumn(3).setMinWidth(100);
            tblVendas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblVendas.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jLabel2.setText("Detalhes da venda: ");

        jLabel4.setText("Vendas: ");

        tblDetVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Quantidade", "Valor Unitário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetVenda.setRowHeight(20);
        jScrollPane2.setViewportView(tblDetVenda);
        if (tblDetVenda.getColumnModel().getColumnCount() > 0) {
            tblDetVenda.getColumnModel().getColumn(1).setMinWidth(90);
            tblDetVenda.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblDetVenda.getColumnModel().getColumn(1).setMaxWidth(90);
            tblDetVenda.getColumnModel().getColumn(2).setMinWidth(100);
            tblDetVenda.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblDetVenda.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        tfdDataNome.setToolTipText("Digite uma data ou um nome");
        tfdDataNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdDataNomeActionPerformed(evt);
            }
        });
        tfdDataNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdDataNomeKeyPressed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancela.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        cbPesquisaVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome do Cliente", "Data" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbPesquisaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(tfdDataNome, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdDataNome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPesquisaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        int opcao;
        if (cbPesquisaVenda.getSelectedIndex() == 1) {
            populaTabelaVendasBuscaPorData();
        } else {
            populaTabelaVendasBuscaPorNome();
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendasMouseClicked
        populaTabelaDetalheVendas();
    }//GEN-LAST:event_tblVendasMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int dialog = JOptionPane.showConfirmDialog(null, "Confirma exclusão da conta selecionada?","Exclusão", JOptionPane.YES_NO_OPTION);
        if (dialog == JOptionPane.YES_OPTION) {
            excluir();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tfdDataNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdDataNomeActionPerformed

    }//GEN-LAST:event_tfdDataNomeActionPerformed

    private void tfdDataNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdDataNomeKeyPressed
        if (cbPesquisaVenda.getSelectedIndex() == 0) {
            populaTabelaVendasBuscaPorNome();
        }

    }//GEN-LAST:event_tfdDataNomeKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPesquisaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbPesquisaVenda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDetVenda;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField tfdDataNome;
    // End of variables declaration//GEN-END:variables
}
