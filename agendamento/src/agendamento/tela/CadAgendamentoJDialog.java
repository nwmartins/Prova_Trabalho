/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamento.tela;

import agendamento.DAO.AgendamentoDAO;
import agendamento.DAO.FuncionarioDAO;
import agendamento.DAO.MotoristaDAO;
import agendamento.DAO.VeiculoDAO;
import agendamento.model.Agendamento;
import agendamento.model.Funcionario;
import agendamento.model.Motorista;
import agendamento.model.Veiculo;
import agendamento.util.DateUtil;
import static agendamento.util.DateUtil.dateToString;
import static agendamento.util.DateUtil.stringToDate;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Norton Wagner Martins
 */
public class CadAgendamentoJDialog extends javax.swing.JDialog {
    
    private MotoristaDAO motDAO = new MotoristaDAO();
    private VeiculoDAO veicDAO = new VeiculoDAO();
    private AgendamentoDAO agendDAO = new AgendamentoDAO();
    
    /**
     * Creates new form CadFuncionario
     */
    public CadAgendamentoJDialog(java.awt.Frame parent, boolean modal) {
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
        tfCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfPassageiro = new javax.swing.JTextField();
        cbVeic = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbMotora = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tfOrigem = new javax.swing.JTextField();
        tfDestino = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfDtSaida = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        tfDtVolta = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfObs = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        pnConsultas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAgend = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rbCodigo = new javax.swing.JRadioButton();
        rbOrigem = new javax.swing.JRadioButton();
        btSearch = new javax.swing.JButton();
        tfFiltroCod = new javax.swing.JTextField();
        tfFiltroNome = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btRemove = new javax.swing.JButton();
        btExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro De Agendamento");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        pnCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Angendamentos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnCadastro.setToolTipText("Cadastros");
        pnCadastro.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnCadastroMouseMoved(evt);
            }
        });

        jLabel5.setText("Motorista");

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

        jLabel7.setText("Nº Passageiros");

        jLabel2.setText("Destino:");

        jLabel3.setText("Veiculo");

        jLabel4.setText("Origem:");

        jLabel6.setText("Data Saída:");

        try {
            tfDtSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("Data Regresso");

        try {
            tfDtVolta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tfObs.setColumns(20);
        tfObs.setRows(5);
        jScrollPane2.setViewportView(tfObs);

        jLabel9.setText("Observação:");

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMotora, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnCadastroLayout.createSequentialGroup()
                                        .addComponent(cbVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnCadastroLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDtVolta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel9))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(tfPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbVeic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbMotora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfDtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfDtVolta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnConsultas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        pnConsultas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnConsultasMouseMoved(evt);
            }
        });

        tbAgend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Motorista", "Veiculo", "Origem", "Destino", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAgend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAgendMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAgend);

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

        btGroup.add(rbOrigem);
        rbOrigem.setText("Filtrar por Destino");
        rbOrigem.setActionCommand("Filtrar por Origem");
        rbOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOrigemActionPerformed(evt);
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
                    .addComponent(rbOrigem)
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
                            .addComponent(rbOrigem)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            Agendamento agend = new Agendamento();
            Veiculo vec = new Veiculo();
            Motorista mot = new Motorista();
            vec = (Veiculo) (cbVeic.getSelectedItem());
            mot = (Motorista) (cbMotora.getSelectedItem());
            agend.setCodigo(Integer.parseInt((tfCod.getText().trim())));
            agend.setDestino(tfDestino.getText().trim());
            agend.setDtRetorno(DateUtil.stringToDate(tfDtVolta.getText().trim()));
            agend.setDtSaida(DateUtil.stringToDate(tfDtSaida.getText().trim()));
            agend.setMotorista(mot);
            agend.setNumPassageiros(Integer.parseInt(tfPassageiro.getText().trim()));
            agend.setObs(tfObs.getText().trim());
            agend.setOrigem(tfOrigem.getText().trim());
            agend.setVeiculo(vec);
            
            if (agend.getNumPassageiros() > vec.getNumPassageiros()) {
                JOptionPane.showMessageDialog(null, "Atenção, Numero de passageiros informado, MAIOR que o limite do "
                        + "veiculo, Verifique!", "ATENÇÃO", 2);
                tfPassageiro.requestFocus();
                return;
            }
            if (agend.getDtSaida().after(agend.getDtRetorno())) {
                JOptionPane.showMessageDialog(null, "Atenção, Data de Regresso, anterior a Saída"
                        + ", Verifique!", "ATENÇÃO", 2);
                tfDtVolta.requestFocus();
                return;                
            }
            if (agendDAO.getLastId() == Integer.parseInt(tfCod.getText())) {
                agendDAO.save(agend);                
            } else { 
                agendDAO.update(agend);    
                btAdd.setText("Adicionar");
            }
            tfCod.setText(String.valueOf(agendDAO.getLastId()));
            carregaTable(agendDAO.getAll());
            limpaCampos();
            desabilitaCampos(false);
            JOptionPane.showMessageDialog(null, "Agendamento Salvo Com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();         
        }


    }//GEN-LAST:event_btAddActionPerformed

    private void carregaTable(List<Agendamento> agendList) {
        if (agendList == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbAgend.getModel();
        model.setRowCount(0);
        for (Agendamento a : agendList) {
            model.addRow(new Object[]{
                a.getCodigo(),
                a.getMotorista().getFuncionario().getNome(),
                a.getVeiculo().getPlaca(),
                a.getOrigem(),
                a.getDestino(),
                a.getObs()});
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

    private void tbAgendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAgendMouseClicked
        Agendamento agend = new Agendamento();
        try {
            agend = agendDAO.getById((int) tbAgend.getValueAt(tbAgend.getSelectedRow(), 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        novo();
        btAdd.setText("Atualizar");
        tfCod.setText(String.valueOf(agend.getCodigo()));
        tfDestino.setText(agend.getDestino());
        tfDtSaida.setText(dateToString(agend.getDtSaida()));
        tfDtVolta.setText(dateToString(agend.getDtRetorno()));
        tfObs.setText(agend.getObs());
        tfOrigem.setText(agend.getOrigem());
        tfPassageiro.setText(String.valueOf(agend.getNumPassageiros()));
    }//GEN-LAST:event_tbAgendMouseClicked

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btClearActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        verificaCampos();
    }//GEN-LAST:event_formMouseMoved

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        try {
            if (rbCodigo.isSelected() && tfFiltroCod.getText().trim().length() > 0) {
                Agendamento agend = agendDAO.getById(Integer.parseInt(tfFiltroCod.getText()));
                List<Agendamento> agendList = new ArrayList<>();
                agendList.add(agend);
                carregaTable(agendList);
            } else if (rbOrigem.isSelected() && tfFiltroNome.getText().trim().length() > 0) {
                carregaTable(agendDAO.getByName(tfFiltroNome.getText()));
            } else {
                carregaTable(agendDAO.getAll());
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

    private void rbOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOrigemActionPerformed
        verificaFiltro();
    }//GEN-LAST:event_rbOrigemActionPerformed

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
            java.util.logging.Logger.getLogger(CadAgendamentoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadAgendamentoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadAgendamentoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadAgendamentoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                CadAgendamentoJDialog dialog = new CadAgendamentoJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbMotora;
    private javax.swing.JComboBox<String> cbVeic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JPanel pnConsultas;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbOrigem;
    private javax.swing.JTable tbAgend;
    private javax.swing.JTextField tfCod;
    private javax.swing.JTextField tfDestino;
    private javax.swing.JFormattedTextField tfDtSaida;
    private javax.swing.JFormattedTextField tfDtVolta;
    private javax.swing.JTextField tfFiltroCod;
    private javax.swing.JTextField tfFiltroNome;
    private javax.swing.JTextArea tfObs;
    private javax.swing.JTextField tfOrigem;
    private javax.swing.JTextField tfPassageiro;
    // End of variables declaration//GEN-END:variables

    private void iniciaTela() {
        try {
            tfCod.setText(String.valueOf(agendDAO.getLastId()));
            desabilitaCampos(false);
            carregaTable(agendDAO.getAll());
            verificaFiltro();
            DefaultComboBoxModel modeloComboVeiculo;
            modeloComboVeiculo = new DefaultComboBoxModel(veicDAO.getAll().toArray());   
            cbVeic.setModel(modeloComboVeiculo);
            DefaultComboBoxModel modeloComboMotorista;
            modeloComboMotorista = new DefaultComboBoxModel(motDAO.getAll().toArray());   
            cbMotora.setModel(modeloComboMotorista);            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void desabilitaCampos(boolean ativo) {
        cbVeic.setEnabled(ativo);
        cbMotora.setEnabled(ativo);
        tfDestino.setEnabled(ativo);
        tfDtSaida.setEnabled(ativo);
        tfDtVolta.setEnabled(ativo);
        tfObs.setEnabled(ativo);
        tfOrigem.setEnabled(ativo);
        tfPassageiro.setEnabled(ativo);
        btClear.setEnabled(ativo);
        btAdd.setEnabled(ativo);
        btNew.setEnabled(!ativo);
    }   
    
    private void limpaCampos() {
        tfDestino.setText(""); 
        tfDtSaida.setText(""); 
        tfDtVolta.setText(""); 
        tfObs.setText(""); 
        tfOrigem.setText(""); 
        tfPassageiro.setText("");     
        cbVeic.setSelectedIndex(0);
        cbMotora.setSelectedIndex(0);
    }

    private void novo() {
        try {
            tfCod.setText(String.valueOf(agendDAO.getLastId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        desabilitaCampos(true);
        btAdd.setEnabled(true);
    }

    private void remover() {
        int linhaSelecionada = tbAgend.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Deve-se selecionar uma linha para ser removido", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int codigoRemover = (int) tbAgend.getValueAt(linhaSelecionada, 0);
        try {
            agendDAO.delete(codigoRemover);
            JOptionPane.showMessageDialog(null, "Agendamento Removido com Sucesso!");
            carregaTable(agendDAO.getAll());
            limpaCampos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void verificaFiltro() {
        if (rbCodigo.isSelected()) {
            tfFiltroNome.setEnabled(false);
            tfFiltroCod.setEnabled(true);
            tfFiltroNome.setText("");
        } else {
            tfFiltroNome.setEnabled(true);
            tfFiltroCod.setEnabled(false);
            tfFiltroCod.setText("");
        }   
    }

    private void verificaCampos() {
        if (tfPassageiro.getText().trim().length() > 0 &&
                tfDestino.getText().trim().length() > 0 &&
                tfOrigem.getText().trim().length() > 0 &&
                tfPassageiro.getText().trim().length() > 0 &&
                tfDtSaida.getText().replace("/", "").trim().length() > 0 &&
                tfDtVolta.getText().replace("/", "").trim().length() > 0) {
            btAdd.setEnabled(true);
        } else {
            btAdd.setEnabled(false);
        }
        if (tbAgend.getSelectedRow() != -1) {
            btRemove.setEnabled(true);
        } else {
            btRemove.setEnabled(false);
        }
    }

}
