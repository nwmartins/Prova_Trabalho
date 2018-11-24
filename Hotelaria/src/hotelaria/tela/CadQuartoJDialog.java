/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria.tela;

import hotelaria.DAO.QuartoDAO;
import hotelaria.DAO.PessoaFisicaDAO;
import hotelaria.DAO.QuartoDAO;
import hotelaria.model.Quarto;
import hotelaria.model.Quarto;
import hotelaria.model.PessoaFisica;
import hotelaria.model.Quarto;
import hotelaria.model.Sexo;
import hotelaria.util.DateUtil;
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
public class CadQuartoJDialog extends javax.swing.JDialog {

    private QuartoDAO quartoDAO = new QuartoDAO();
    private PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
    
    public CadQuartoJDialog(java.awt.Frame parent, boolean modal) {
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
        tfStatus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tfValor = new javax.swing.JFormattedTextField();
        tfAndar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfNum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfCapPess = new javax.swing.JTextField();
        tfDesc = new javax.swing.JTextField();
        pnConsultas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQuarto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rbCodigo = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();
        btSearch = new javax.swing.JButton();
        tfFiltroCod = new javax.swing.JTextField();
        tfFiltroNome = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btRemove = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btExit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro De Funcionario");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        pnCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Quarto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnCadastro.setToolTipText("Cadastros");
        pnCadastro.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnCadastroMouseMoved(evt);
            }
        });

        jLabel5.setText("Status");

        jLabel4.setText("Andar");

        tfCod.setEnabled(false);

        jLabel1.setText("Código:");

        jLabel2.setText("Descrição");

        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelaria/tela/Add.png"))); // NOI18N
        btAdd.setText("Adicionar");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelaria/tela/new.png"))); // NOI18N
        btNew.setText("Novo");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelaria/tela/Clear.png"))); // NOI18N
        btClear.setText("Limpar");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        jLabel9.setText("Valor");

        tfValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel11.setText("Nº Do Quarto");

        jLabel3.setText("Capacidade de Pessoas");

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCapPess, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createSequentialGroup()
                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(261, 261, 261))
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNum)
                            .addComponent(tfAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnCadastroLayout.createSequentialGroup()
                            .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(tfCapPess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnCadastroLayout.createSequentialGroup()
                            .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(tfAndar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(tfDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnConsultas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        pnConsultas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnConsultasMouseMoved(evt);
            }
        });

        tbQuarto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Status", "Valor do Quarto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbQuarto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbQuartoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbQuarto);

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
        rbNome.setText("Filtrar por Descrição");
        rbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNomeActionPerformed(evt);
            }
        });

        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelaria/tela/Search.png"))); // NOI18N
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
                    .addComponent(tfFiltroCod, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
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

        btRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelaria/tela/Remove.png"))); // NOI18N
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

        jLabel7.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jLabel7.setText("Maestro Hotel");

        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelaria/tela/Exit.png"))); // NOI18N
        btExit.setLabel("Sair");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelaria/tela/Hotel.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(pnConsultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(354, 354, 354))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnCadastro.getAccessibleContext().setAccessibleName("Cadastros");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        try {
            Quarto quarto = new Quarto();
            quarto.setCodigo(Integer.parseInt(tfCod.getText().trim()));
            quarto.setAndar(Integer.parseInt(tfAndar.getText().trim()));
            quarto.setCapPessoas(Integer.parseInt(tfCapPess.getText().trim()));
            quarto.setDescricao(tfDesc.getText());
            quarto.setNumQuarto(Integer.parseInt(tfNum.getText().trim()));
            quarto.setStatus(tfStatus.getText().trim());
            quarto.setValor(Double.parseDouble(tfValor.getText().trim().replace(",", ".")));
            if (quartoDAO.getLastId() == Integer.parseInt(tfCod.getText())) {
                quartoDAO.save(quarto);
                tfCod.setText(String.valueOf(quartoDAO.getLastId()));
            } else { 
                quartoDAO.update(quarto);          
                btAdd.setText("Adicionar");
            }
            carregaTable(quartoDAO.getAll());
            limpaCampos();
            desabilitaCampos(false);
            JOptionPane.showMessageDialog(null, "Quarto Salvo Com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btAddActionPerformed

    private void carregaTable(List<Quarto> quartoList) {
        if (quartoList == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbQuarto.getModel();
        model.setRowCount(0);
        for (Quarto f : quartoList) {
            model.addRow(new Object[]{
                f.getCodigo(),
                f.getDescricao(),
                //f.getAndar(),
                f.getStatus(),
                //f.getCapPessoas(),              
                //f.getNumQuarto(),                
                "R$ " + String.valueOf(f.getValor()).replace(".", ",")});               
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

    private void tbQuartoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQuartoMouseClicked
        Quarto quarto = new Quarto();
        try {
            quarto = quartoDAO.getById((int) tbQuarto.getValueAt(tbQuarto.getSelectedRow(), 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        novo();
        btAdd.setText("Atualizar");
        tfCod.setText(String.valueOf(quarto.getCodigo()));
        tfAndar.setText(String.valueOf(quarto.getAndar()));
        tfStatus.setText(quarto.getStatus());
        tfCapPess.setText(String.valueOf(quarto.getCapPessoas()));
        tfValor.setText(String.valueOf(quarto.getValor()));
        tfDesc.setText(quarto.getDescricao());
        tfNum.setText(String.valueOf(quarto.getNumQuarto()));
       
    }//GEN-LAST:event_tbQuartoMouseClicked

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btClearActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        verificaCampos();
    }//GEN-LAST:event_formMouseMoved

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        try {
            if (rbCodigo.isSelected() && tfFiltroCod.getText().trim().length() > 0) {
                Quarto quarto = quartoDAO.getById(Integer.parseInt(tfFiltroCod.getText()));
                List<Quarto> quartoList = new ArrayList<>();
                quartoList.add(quarto);
                carregaTable(quartoList);
            } else if (rbNome.isSelected() && tfFiltroNome.getText().trim().length() > 0) {
                carregaTable(quartoDAO.getByName(tfFiltroNome.getText()));
            } else {
                carregaTable(quartoDAO.getAll());
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
            java.util.logging.Logger.getLogger(CadQuartoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadQuartoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadQuartoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadQuartoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                CadQuartoJDialog dialog = new CadQuartoJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JPanel pnConsultas;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JTable tbQuarto;
    private javax.swing.JTextField tfAndar;
    private javax.swing.JTextField tfCapPess;
    private javax.swing.JTextField tfCod;
    private javax.swing.JTextField tfDesc;
    private javax.swing.JTextField tfFiltroCod;
    private javax.swing.JTextField tfFiltroNome;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfStatus;
    private javax.swing.JFormattedTextField tfValor;
    // End of variables declaration//GEN-END:variables

    private void iniciaTela() {
        try {
            tfCod.setText(String.valueOf(quartoDAO.getLastId()));
            desabilitaCampos(false);
            carregaTable(quartoDAO.getAll());
            verificaFiltro();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void desabilitaCampos(boolean ativo) {
        tfStatus.setEnabled(ativo);
        tfAndar.setEnabled(ativo);
        tfCapPess.setEnabled(ativo);
        tfDesc.setEnabled(ativo);
        btClear.setEnabled(ativo);
        btAdd.setEnabled(ativo);
        btNew.setEnabled(!ativo);
        tfNum.setEnabled(ativo);
        tfValor.setEnabled(ativo);
        tfStatus.setEnabled(ativo);
    }   
    
    private void limpaCampos() {
        tfStatus.setText("");
        tfAndar.setText("");
        tfCapPess.setText("");
        tfDesc.setText("");
        tfNum.setText("");
        tfValor.setText("");        
        tfStatus.setText("");
    }

    private void novo() {
        try {
            tfCod.setText(String.valueOf(quartoDAO.getLastId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        desabilitaCampos(true);
        btAdd.setEnabled(true);
    }

    private void remover() {
        int linhaSelecionada = tbQuarto.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Deve-se selecionar uma linha para ser removido", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int codigoRemover = (int) tbQuarto.getValueAt(linhaSelecionada, 0);
        try {
            quartoDAO.delete(codigoRemover);
            JOptionPane.showMessageDialog(null, "Quarto Removido com Sucesso!");
            carregaTable(quartoDAO.getAll());
            limpaCampos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void verificaCampos() {
        if (tfStatus.getText().trim().length() > 0 &&
                tfAndar.getText().trim().length() > 0 &&
                tfDesc.getText().trim().length() > 0 &&
                tfNum.getText().trim().length() > 0 &&
                tfValor.getText().replace(".", ",").trim().length() > 0 &&
                tfCapPess.getText().trim().length() > 0) {
            btAdd.setEnabled(true);
        } else {
            btAdd.setEnabled(false);
        }
        if (tbQuarto.getSelectedRow() != -1) {
            btRemove.setEnabled(true);
        } else {
            btRemove.setEnabled(false);
        }
    }

    private void verificaFiltro() {
        if (rbCodigo.isSelected()) {
            tfFiltroNome.setEnabled(false);
            tfFiltroCod.setEnabled(true);
        } else {
            tfFiltroCod.setEnabled(false);
            tfFiltroNome.setEnabled(true);
        }
    }

}
