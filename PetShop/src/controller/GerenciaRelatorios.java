
package controller;

import java.io.InputStream;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class GerenciaRelatorios {

    private Connection conn = null;

    public GerenciaRelatorios() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
    }

    public void gerarRelatorioClienteAnimal() {
        try {
            InputStream is = getClass().getResourceAsStream("../relatorios/ClientesComAnimais.jasper");
            JasperPrint print = JasperFillManager.fillReport(is, null, conn);

            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não gerado! " + e.getMessage());
        }
    }

    public void gerarRelatorioClientesFisicos() {
        try {
            InputStream is = getClass().getResourceAsStream("../relatorios/RelatorioClientesFisicos.jasper");
            JasperPrint print = JasperFillManager.fillReport(is, null, conn);

            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não gerado! " + e.getMessage());
        }
    }

    public void gerarRelatorioClientesJuridicos() {
        try {
            InputStream is = getClass().getResourceAsStream("../relatorios/RelatorioClientesJuridicos.jasper");
            JasperPrint print = JasperFillManager.fillReport(is, null, conn);

            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não gerado! " + e.getMessage());
        }
    }

    public void gerarRelatorioClientesQueMaisCompram() {
        try {
            InputStream is = getClass().getResourceAsStream("../relatorios/RelatorioClientesMaisCompram.jasper");
            JasperPrint print = JasperFillManager.fillReport(is, null, conn);

            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não gerado! " + e.getMessage());
        }
    }

    public void gerarRelatorioContasAReceber() {
        try {
            InputStream is = getClass().getResourceAsStream("../relatorios/RelatorioContasAReceber.jasper");
            JasperPrint print = JasperFillManager.fillReport(is, null, conn);

            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não gerado! " + e.getMessage());
        }
    }

    public void gerarRelatorioVendasEmAtraso() {
        try {
            HashMap filtro = new HashMap();
            LocalDate dataAtual = LocalDate.now();

            InputStream is = getClass().getResourceAsStream("../relatorios/RelatorioContasAtrasadas.jasper");
            filtro.put("dataAtual", java.sql.Date.valueOf(dataAtual));
            JasperPrint print = JasperFillManager.fillReport(is, filtro, conn);

            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não gerado! " + e.getMessage());
        }

    }

}
