package view;

import controller.Conexao;
import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class TelaRelatorioAgendamentosFaturados extends javax.swing.JFrame {

    private Connection conn = null;

    public TelaRelatorioAgendamentosFaturados() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
        initComponents();
    }
    
    public String formatarDataParaUS(String dataBr) throws ParseException {
        String dataEmUmFormato = dataBr;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse(dataEmUmFormato);
        formato.applyPattern("yyyy-MM-dd");
        String dataFormatada = formato.format(data);
        return dataFormatada;
    }
    
    private void gerarRelatorio() {
        try {
            HashMap filtro = new HashMap();
            String dataI = tfdDataI.getText();
            String dataF = tfdDataF.getText();
            
            InputStream is = getClass().getResourceAsStream("../relatorios/RelatorioPeriodicoAgendamentosFaturados.jasper");
            filtro.put("dataI", java.sql.Date.valueOf(formatarDataParaUS(dataI)));
            filtro.put("dataF", java.sql.Date.valueOf(formatarDataParaUS(dataF)));
            JasperPrint print = JasperFillManager.fillReport(is, filtro, conn);
            
            JasperViewer viewer = new JasperViewer (print,false);
            viewer.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não gerado, verifique as datas! "+e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfdDataI = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdDataF = new javax.swing.JFormattedTextField();
        btnGerarRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendamentos Faturados");
        setResizable(false);

        jLabel1.setText("Data Inicial");

        try {
            tfdDataI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdDataI.setToolTipText("");

        jLabel2.setText("Data Final");

        try {
            tfdDataF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfdDataF.setToolTipText("");

        btnGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Relatorios.png"))); // NOI18N
        btnGerarRelatorio.setText("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfdDataF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdDataI, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap(113, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tfdDataI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tfdDataF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        gerarRelatorio();
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioAgendamentosFaturados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField tfdDataF;
    private javax.swing.JFormattedTextField tfdDataI;
    // End of variables declaration//GEN-END:variables
}
