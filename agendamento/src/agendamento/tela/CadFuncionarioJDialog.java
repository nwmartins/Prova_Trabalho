/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamento.tela;

import agendamento.DAO.FuncionarioDAO;
import agendamento.model.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Norton Wagner Martins
 */
public class CadFuncionarioJDialog extends javax.swing.JDialog {
    
    private FuncionarioDAO funDAO = new FuncionarioDAO();
    
    /**
     * Creates new form CadFuncionario
     */
    public CadFuncionarioJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciaTela();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroup = new javax.swing.ButtonGroup();
        pnCadastro = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfMatricula = new javax.swing.JTextField();
        pnConsultas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFun = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rbCodigo = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();
        btSearch = new javax.swing.JButton();
        tfFiltroCod = new javax.swing.JTextField();
        tfFiltroNome = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btRemove = new javax.swing.JButton();
        btExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro De Funcionario");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        pnCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Funcionario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnCadastro.setToolTipText("Cadastros");
        pnCadastro.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnCadastroMouseMoved(evt);
            }
        });

        jLabel5.setText("Nome:");

        tfCod.setEnabled(false);

        jLabel1.setText("Código:");

        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendamento/tela/Add.png"))); // NOI18N
        btAdd.setText("Adicionar");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendamento/tela/new.png"))); // NOI18N
        btNew.setText("Novo");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendamento/tela/Clear.png"))); // NOI18N
        btClear.setText("Limpar");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        jLabel7.setText("Nº Matricula:");

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pnConsultas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        pnConsultas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnConsultasMouseMoved(evt);
            }
        });

        tbFun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Nº Matricula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFunMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFun);

        javax.swing.GroupLayout pnConsultasLayout = new javax.swing.GroupLayout(pnConsultas);
        pnConsultas.setLayout(pnConsultasLayout);
        pnConsultasLayout.setHorizontalGroup(
            pnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnConsultasLayout.setVerticalGroup(
            pnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultasLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btGroup.add(rbCodigo);
        rbCodigo.setSelected(true);
        rbCodigo.setText("Filtrar por Código");
        rbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCodigoActionPerformed(evt);
            }
        });

        btGroup.add(rbNome);
        rbNome.setText("Filtrar por Nome");
        rbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNomeActionPerformed(evt);
            }
        });

        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendamento/tela/Search.png"))); // NOI18N
        btSearch.setText("Filtrar");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbNome)
                    .addComponent(rbCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFiltroCod, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(tfFiltroNome))
                .addGap(18, 18, 18)
                .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbCodigo)
                            .addComponent(tfFiltroCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbNome)
                            .addComponent(tfFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Remover da Lista?", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendamento/tela/Remove.png"))); // NOI18N
        btRemove.setText("Remover");
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendamento/tela/Exit.png"))); // NOI18N
        btExit.setLabel("Sair");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(pnConsultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(406, 406, 406))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnCadastro.getAccessibleContext().setAccessibleName("Cadastros");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        try {
            Funcionario fun = new Funcionario();
            fun.setCodigo(Integer.parseInt(tfCod.getText().trim()));
            fun.setNome(tfNome.getText().trim());
            fun.setNumMatricula(Integer.parseInt(tfMatricula.getText().trim()));
            if (funDAO.getLastId() == Integer.parseInt(tfCod.getText())) {
                funDAO.save(fun);                
            } else { 
                funDAO.update(fun);    
                btAdd.setText("Adicionar");
            }
            tfCod.setText(String.valueOf(funDAO.getLastId()));
            carregaTable(funDAO.getAll());
            limpaCampos();
            desabilitaCampos(false);
            JOptionPane.showMessageDialog(null, "Funcionario Salvo Com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btAddActionPerformed

    private void carregaTable(List<Funcionario> funList) {
        if (funList == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbFun.getModel();
        model.setRowCount(0);
        for (Funcionario f : funList) {
            model.addRow(new Object[]{
                f.getCodigo(),
                f.getNome(),
                f.getNumMatricula() });
        }
    }

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        novo();
    }//GEN-LAST:event_btNewActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        this.dispose();
        MenuJDialog dialog = new MenuJDialog(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btExitActionPerformed

    private void tbFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFunMouseClicked
        Funcionario fun = new Funcionario();
        try {
            fun = funDAO.getById((int) tbFun.getValueAt(tbFun.getSelectedRow(), 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        novo();
        btAdd.setText("Atualizar");
        tfCod.setText(String.valueOf(fun.getCodigo()));
        tfNome.setText(fun.getNome());
        tfMatricula.setText(String.valueOf(fun.getNumMatricula()));
    }//GEN-LAST:event_tbFunMouseClicked

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btClearActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        verificaCampos();
    }//GEN-LAST:event_formMouseMoved

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        try {
            if (rbCodigo.isSelected() && tfFiltroCod.getText().trim().length() > 0) {
                Funcionario fun = funDAO.getById(Integer.parseInt(tfFiltroCod.getText()));
                List<Funcionario> funList = new ArrayList<>();
                funList.add(fun);
                carregaTable(funList);
            } else if (rbNome.isSelected() && tfFiltroNome.getText().trim().length() > 0) {
                carregaTable(funDAO.getByName(tfFiltroNome.getText()));
            } else {
                carregaTable(funDAO.getAll());
                JOptionPane.showMessageDialog(null, "Informe o filtro desejado para pesquisa", "Atenção", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Algum campo foi informado incorretamente", null, 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btSearchActionPerformed

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveActionPerformed
        remover();
    }//GEN-LAST:event_btRemoveActionPerformed

    private void pnCadastroMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnCadastroMouseMoved
        verificaCampos();
    }//GEN-LAST:event_pnCadastroMouseMoved

    private void pnConsultasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnConsultasMouseMoved
        verificaCampos();
    }//GEN-LAST:event_pnConsultasMouseMoved

    private void rbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCodigoActionPerformed
        verificaFiltro();
    }//GEN-LAST:event_rbCodigoActionPerformed

    private void rbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNomeActionPerformed
        verificaFiltro();
    }//GEN-LAST:event_rbNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadFuncionarioJDialog dialog = new CadFuncionarioJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btExit;
    private javax.swing.ButtonGroup btGroup;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btRemove;
    private javax.swing.JButton btSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JPanel pnConsultas;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JTable tbFun;
    private javax.swing.JTextField tfCod;
    private javax.swing.JTextField tfFiltroCod;
    private javax.swing.JTextField tfFiltroNome;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private void iniciaTela() {
        try {
            tfCod.setText(String.valueOf(funDAO.getLastId()));
            desabilitaCampos(false);
            carregaTable(funDAO.getAll());
            verificaFiltro();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void desabilitaCampos(boolean ativo) {
        tfNome.setEnabled(ativo);
        tfMatricula.setEnabled(ativo);
        btClear.setEnabled(ativo);
        btAdd.setEnabled(ativo);
        btNew.setEnabled(!ativo);
    }   
    
    private void limpaCampos() {
        tfNome.setText("");
        tfMatricula.setText("");     
    }

    private void novo() {
        try {
            tfCod.setText(String.valueOf(funDAO.getLastId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        desabilitaCampos(true);
        btAdd.setEnabled(true);
    }

    private void remover() {
        int linhaSelecionada = tbFun.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Deve-se selecionar uma linha para ser removido", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int codigoRemover = (int) tbFun.getValueAt(linhaSelecionada, 0);
        try {
            funDAO.delete(codigoRemover);
            JOptionPane.showMessageDialog(null, "Funcionario Removido com Sucesso!");
            carregaTable(funDAO.getAll());
            limpaCampos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void verificaFiltro() {
        if (rbCodigo.isSelected()) {
            tfFiltroNome.setEnabled(false);
            tfFiltroCod.setEnabled(true);
        } else {
            tfFiltroNome.setEnabled(true);
            tfFiltroCod.setEnabled(false);
        }   
    }

    private void verificaCampos() {
        if (tfNome.getText().trim().length() > 0 &&
                tfMatricula.getText().replace(".", "").replace("-", "").trim().length() > 0) {
            btAdd.setEnabled(true);
        } else {
            btAdd.setEnabled(false);
        }
        if (tbFun.getSelectedRow() != -1) {
            btRemove.setEnabled(true);
        } else {
            btRemove.setEnabled(false);
        }
    }

}
