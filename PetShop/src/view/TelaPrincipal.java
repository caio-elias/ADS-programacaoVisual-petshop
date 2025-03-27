package view;

import controller.GerenciaRelatorios;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;

public class TelaPrincipal extends javax.swing.JFrame {

    TelaAgendamentos ag;
    TelaServico ts;
    TelaProdutos tb;
    TelaConta tc;
    TelaGerenciaProfissional tgp;
    TelaPagamentos tp;
    TelaPesquisaVenda tpv;
    GerenciaRelatorios gr;
    TelaCliente tcli;

    public TelaPrincipal() {
        initComponents();
        ag = new TelaAgendamentos(this);
        ts = new TelaServico();
        tb = new TelaProdutos();
        tc = new TelaConta();
        tcli = new TelaCliente(this);
        tgp = new TelaGerenciaProfissional();
        tp = new TelaPagamentos();
        tpv = new TelaPesquisaVenda();
        gr = new GerenciaRelatorios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPmenuP1 = new javax.swing.JPopupMenu();
        desktop = new javax.swing.JDesktopPane();
        jbClientes = new javax.swing.JButton();
        jbAgenda = new javax.swing.JButton();
        jbProdutos = new javax.swing.JButton();
        jbServicos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnPesquisaVenda = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnPagamentos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCad = new javax.swing.JMenu();
        itemCadUser = new javax.swing.JMenuItem();
        MenuGerenciar = new javax.swing.JMenu();
        ItemGerUser = new javax.swing.JMenuItem();
        itemCadProduto = new javax.swing.JMenuItem();
        MenuRelatorio = new javax.swing.JMenu();
        itemRelatorioCliMComp = new javax.swing.JMenuItem();
        itemRelatorioVA = new javax.swing.JMenuItem();
        itemRelatorioCA = new javax.swing.JMenuItem();
        itemRelatorioClientesJuridicos = new javax.swing.JMenuItem();
        itemRelatorioCF = new javax.swing.JMenuItem();
        itemRelatorioPV = new javax.swing.JMenuItem();
        itemRelatorioCR = new javax.swing.JMenuItem();
        itemRelatorioAS = new javax.swing.JMenuItem();
        itemRelatorioAF = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktop.setBackground(new java.awt.Color(207, 202, 196));
        desktop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente_color.png"))); // NOI18N
        jbClientes.setText("Clientes");
        jbClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClientesActionPerformed(evt);
            }
        });

        jbAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/agenda_collor.png"))); // NOI18N
        jbAgenda.setText("Agenda");
        jbAgenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAgenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgendaActionPerformed(evt);
            }
        });

        jbProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos.png"))); // NOI18N
        jbProdutos.setText("Produtos");
        jbProdutos.setAutoscrolls(true);
        jbProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbProdutosMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbProdutosMouseClicked(evt);
            }
        });
        jbProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProdutosActionPerformed(evt);
            }
        });

        jbServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/scissors_23816.png"))); // NOI18N
        jbServicos.setText("Serviços");
        jbServicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbServicos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbServicosMouseClicked(evt);
            }
        });
        jbServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbServicosActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Venda.png"))); // NOI18N
        jButton1.setText("Venda");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPesquisaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procura Conta.png"))); // NOI18N
        btnPesquisaVenda.setText("Consulta Vendas");
        btnPesquisaVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisaVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesquisaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaVendaActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/profissionais.png"))); // NOI18N
        jButton2.setText("Profissionais");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnPagamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/receber.png"))); // NOI18N
        btnPagamentos.setText("Pagamento");
        btnPagamentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagamentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagamentosActionPerformed(evt);
            }
        });

        jMenuBar1.setPreferredSize(new java.awt.Dimension(77, 30));

        MenuCad.setText("Cadastro");

        itemCadUser.setText("Usuário");
        itemCadUser.setEnabled(false);
        itemCadUser.setPreferredSize(new java.awt.Dimension(75, 22));
        itemCadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadUserActionPerformed(evt);
            }
        });
        MenuCad.add(itemCadUser);

        jMenuBar1.add(MenuCad);

        MenuGerenciar.setText("Gerenciar");

        ItemGerUser.setText("Usuários");
        ItemGerUser.setEnabled(false);
        ItemGerUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemGerUserActionPerformed(evt);
            }
        });
        MenuGerenciar.add(ItemGerUser);

        itemCadProduto.setText("Produto");
        MenuGerenciar.add(itemCadProduto);

        jMenuBar1.add(MenuGerenciar);

        MenuRelatorio.setText("Relatórios");

        itemRelatorioCliMComp.setText("RELATÓRIO DE CLIENTES QUE MAIS COMPRAM");
        itemRelatorioCliMComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioCliMCompActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itemRelatorioCliMComp);

        itemRelatorioVA.setText("RELATÓRIO DE CLIENTES EM ATRASO");
        itemRelatorioVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioVAActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itemRelatorioVA);

        itemRelatorioCA.setText("RELATÓRIO DE CLIENTES QUE POSSUEM ANIMAIS");
        itemRelatorioCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioCAActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itemRelatorioCA);

        itemRelatorioClientesJuridicos.setText("RELATÓRIO DE CLIENTES JURÍDICOS");
        itemRelatorioClientesJuridicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioClientesJuridicosActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itemRelatorioClientesJuridicos);

        itemRelatorioCF.setText("RELATÓRIO DE CLIENTES FÍSICOS");
        itemRelatorioCF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioCFActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itemRelatorioCF);

        itemRelatorioPV.setText("RELATÓRIO PERIÓDICO DE VENDAS");
        itemRelatorioPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioPVActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itemRelatorioPV);

        itemRelatorioCR.setText("RELATÓRIO DE CONTAS A RECEBER");
        itemRelatorioCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioCRActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itemRelatorioCR);

        itemRelatorioAS.setText("RELATÓRIO DE AGENDAMENTOS COM SERVICO APOS O TEMPO");
        itemRelatorioAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioASActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itemRelatorioAS);

        itemRelatorioAF.setText("RELATÓRIO DE AGENDAMENTOS FATURADOS");
        itemRelatorioAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioAFActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itemRelatorioAF);

        jMenuBar1.add(MenuRelatorio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisaVenda))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 1534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPesquisaVenda, jButton1, jButton2, jbAgenda, jbClientes, jbProdutos, jbServicos});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jbServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(btnPagamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 78, Short.MAX_VALUE))
            .addComponent(desktop)
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPesquisaVenda, jButton1, jButton2, jbAgenda, jbClientes, jbProdutos, jbServicos});

        setSize(new java.awt.Dimension(1370, 798));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemCadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadUserActionPerformed
        TelaCadastoUsuario tcu = new TelaCadastoUsuario();
        tcu.setVisible(true);
    }//GEN-LAST:event_itemCadUserActionPerformed

    private void ItemGerUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemGerUserActionPerformed
        new TelaGerenciaUsuario().setVisible(true);
    }//GEN-LAST:event_ItemGerUserActionPerformed

    private void jbProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProdutosActionPerformed

    }//GEN-LAST:event_jbProdutosActionPerformed
    public JDesktopPane getDekstop() {
        return desktop;
    }
    private void jbAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgendaActionPerformed
        if (ag.isVisible()) {
            try {
                ag.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ag.setIcon(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ag = new TelaAgendamentos(this);
            desktop.add(ag);
            ag.setVisible(true);
        }
    }//GEN-LAST:event_jbAgendaActionPerformed

    private void jbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClientesActionPerformed
         if (tcli.isVisible()) {
            try {
                tcli.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                tcli.setIcon(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            tcli = new TelaCliente(this);
            desktop.add(tcli);
            tcli.setVisible(true);
        }
    }//GEN-LAST:event_jbClientesActionPerformed

    private void jbServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbServicosActionPerformed
        if (ts.isVisible()) {
            try {
                ts.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ts.setIcon(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ts = new TelaServico();
            desktop.add(ts);
            ts.setVisible(true);
        }
    }//GEN-LAST:event_jbServicosActionPerformed

    private void jbProdutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbProdutosMousePressed

    }//GEN-LAST:event_jbProdutosMousePressed

    private void jbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbProdutosMouseClicked
        if (tb.isVisible()) {
            try {
                tb.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                tb.setIcon(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            tb = new TelaProdutos();
            desktop.add(tb);
            tb.setVisible(true);
        }
    }//GEN-LAST:event_jbProdutosMouseClicked

    private void jbServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbServicosMouseClicked

    }//GEN-LAST:event_jbServicosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tc.isVisible()) {
            try {
                tc.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                tc.setIcon(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            tc = new TelaConta();
            desktop.add(tc);
            tc.setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPesquisaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaVendaActionPerformed
        if (tpv.isVisible()) {
            tpv.show();
        } else {
            tpv.setVisible(true);
        }

    }//GEN-LAST:event_btnPesquisaVendaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tgp.isVisible()) {
            try {
                tgp.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                tgp.setIcon(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            tgp = new TelaGerenciaProfissional();
            desktop.add(tgp);
            tgp.setVisible(true);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void itemRelatorioPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelatorioPVActionPerformed
        TelaRelatorioVendasData trv = new TelaRelatorioVendasData();
        trv.setVisible(true);
    }//GEN-LAST:event_itemRelatorioPVActionPerformed

    private void itemRelatorioVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelatorioVAActionPerformed
        gr.gerarRelatorioVendasEmAtraso();
    }//GEN-LAST:event_itemRelatorioVAActionPerformed

    private void itemRelatorioCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelatorioCRActionPerformed
        gr.gerarRelatorioContasAReceber();
    }//GEN-LAST:event_itemRelatorioCRActionPerformed

    private void itemRelatorioCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelatorioCAActionPerformed
        gr.gerarRelatorioClienteAnimal();
    }//GEN-LAST:event_itemRelatorioCAActionPerformed

    private void itemRelatorioASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelatorioASActionPerformed
        TelaRelatorioAgendamentoComServicoAposOTempo tras = new TelaRelatorioAgendamentoComServicoAposOTempo();
        tras.setVisible(true);
    }//GEN-LAST:event_itemRelatorioASActionPerformed

    private void itemRelatorioClientesJuridicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelatorioClientesJuridicosActionPerformed
        gr.gerarRelatorioClientesJuridicos();
    }//GEN-LAST:event_itemRelatorioClientesJuridicosActionPerformed

    private void itemRelatorioCFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelatorioCFActionPerformed
        gr.gerarRelatorioClientesFisicos();
    }//GEN-LAST:event_itemRelatorioCFActionPerformed

    private void itemRelatorioAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelatorioAFActionPerformed
        TelaRelatorioAgendamentosFaturados traf = new TelaRelatorioAgendamentosFaturados();
        traf.setVisible(true);
    }//GEN-LAST:event_itemRelatorioAFActionPerformed

    private void btnPagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagamentosActionPerformed
        if (tp.isVisible()) {
            try {
                tp.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                tp.setIcon(false);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            tp = new TelaPagamentos();
            desktop.add(tp);
            tp.setVisible(true);
        }
    }//GEN-LAST:event_btnPagamentosActionPerformed

    private void itemRelatorioCliMCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRelatorioCliMCompActionPerformed
        gr.gerarRelatorioClientesQueMaisCompram();
    }//GEN-LAST:event_itemRelatorioCliMCompActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem ItemGerUser;
    private javax.swing.JMenu MenuCad;
    private javax.swing.JMenu MenuGerenciar;
    private javax.swing.JMenu MenuRelatorio;
    private javax.swing.JButton btnPagamentos;
    private javax.swing.JButton btnPesquisaVenda;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem itemCadProduto;
    public static javax.swing.JMenuItem itemCadUser;
    private javax.swing.JMenuItem itemRelatorioAF;
    private javax.swing.JMenuItem itemRelatorioAS;
    private javax.swing.JMenuItem itemRelatorioCA;
    private javax.swing.JMenuItem itemRelatorioCF;
    private javax.swing.JMenuItem itemRelatorioCR;
    private javax.swing.JMenuItem itemRelatorioCliMComp;
    private javax.swing.JMenuItem itemRelatorioClientesJuridicos;
    private javax.swing.JMenuItem itemRelatorioPV;
    private javax.swing.JMenuItem itemRelatorioVA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPmenuP1;
    private javax.swing.JButton jbAgenda;
    private javax.swing.JButton jbClientes;
    private javax.swing.JButton jbProdutos;
    private javax.swing.JButton jbServicos;
    // End of variables declaration//GEN-END:variables
}
