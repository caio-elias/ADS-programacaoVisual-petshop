
package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class RelatorioContasAReceber {
    private Connection conn = null;

    public RelatorioContasAReceber() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
    }
    
    public void gerarRelatorio() {
        try {
            
            JasperPrint print = JasperFillManager.fillReport("/home/caio/NetBeansProjects/petshop/PetShop/src/relatorios/RelatorioContasAReceber.jasper", null, conn);
            
            JasperViewer viewer = new JasperViewer (print,false);
            viewer.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não gerado! "+e.getMessage());
        }

    }
    
}
