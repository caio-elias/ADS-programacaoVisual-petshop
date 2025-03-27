
package controller;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class RelatorioVendasEmAtraso {
    private Connection conn = null;

    public RelatorioVendasEmAtraso() {
        Conexao a = Conexao.obterInstancia();
        conn = a.obterConexao();
    }
    
    public String formatarDataParaUS(String dataBr) throws ParseException {
        String dataEmUmFormato = dataBr;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse(dataEmUmFormato);
        formato.applyPattern("yyyy-MM-dd");
        String dataFormatada = formato.format(data);
        return dataFormatada;
    }
    
    public void gerarRelatorio() {
        try {
            HashMap filtro = new HashMap();
            LocalDate dataAtual = LocalDate.now();
            
            filtro.put("dataAtual", java.sql.Date.valueOf(dataAtual));
            JasperPrint print = JasperFillManager.fillReport("/home/caio/NetBeansProjects/petshop/PetShop/src/relatorios/RelatorioContasAtrasadas.jasper", filtro, conn);
            
            JasperViewer viewer = new JasperViewer (print,false);
            viewer.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Relatório não gerado! "+e.getMessage());
        }

    }
    
}
