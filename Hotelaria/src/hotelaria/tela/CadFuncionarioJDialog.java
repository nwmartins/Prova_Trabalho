/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria.tela;

import hotelaria.DAO.FuncionarioDAO;
import hotelaria.DAO.PessoaFisicaDAO;
import hotelaria.model.Funcionario;
import hotelaria.model.Funcionario;
import hotelaria.model.PessoaFisica;
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
public class CadFuncionarioJDialog extends javax.swing.JDialog {

    private FuncionarioDAO funDAO = new FuncionarioDAO();
    private PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();

    /**
     * Creates new form CadFuncionario
     */
    public CadFuncionarioJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciaTela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroup = new javax.swing.ButtonGroup();
        pnCadastro = new javax.swing.JPanel();
        tfDtContr = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfCPF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        tfCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        tfRG = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tfSalario = new javax.swing.JFormattedTextField();
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

        pnCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Funcionario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnCadastro.setToolTipText("Cadastros");
        pnCadastro.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnCadastroMouseMoved(evt);
            }
        });

        try {
            tfDtContr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Nome:");

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Data de Contratação:");

        jLabel3.setText("RG:");

        jLabel6.setText("Sexo:");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outro" }));

        tfCod.setEnabled(false);

        jLabel1.setText("Código:");

        jLabel2.setText("CPF:");

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

        try {
            tfRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Salário:");

        tfSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(261, 261, 261))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfDtContr)
                    .addComponent(tfRG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSalario))
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(155, 155, 155))
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfDtContr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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

        tbFun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Data Contratação", "Salario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        btGroup.add(rbNome);
        rbNome.setText("Filtrar por Nome");

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
                    .addComponent(tfFiltroCod)
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
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))))
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
            fun.setCpf(tfCPF.getText().trim());
            fun.setDtContratacao(DateUtil.stringToDate(tfDtContr.getText().trim()));
            fun.setNome(tfNome.getText().trim());
            fun.setRg(tfRG.getText().trim());
            fun.setSexo(verificaSexo());
            fun.setSalario(Double.parseDouble(tfSalario.getText().trim().replace(",", ".")));
            if (pfDAO.getLastId() == Integer.parseInt(tfCod.getText())) {
                funDAO.save(fun);
                tfCod.setText(String.valueOf(pfDAO.getLastId()));
            } else { 
                funDAO.update(fun);          
                btAdd.setText("Adicionar");
            }
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
                f.getCpf(),
                f.getDtContratacao(),
                "R$ " + String.valueOf(f.getSalario()).replace(".", ",")});
                
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
        tfCPF.setText(fun.getCpf());
        tfNome.setText(fun.getNome());
        tfRG.setText(fun.getRg());
        tfSalario.setText(String.valueOf(fun.getSalario()));
        tfDtContr.setText(DateUtil.dateToString(fun.getDtContratacao()));
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
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JPanel pnConsultas;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JTable tbFun;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JTextField tfCod;
    private javax.swing.JFormattedTextField tfDtContr;
    private javax.swing.JTextField tfFiltroCod;
    private javax.swing.JTextField tfFiltroNome;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfRG;
    private javax.swing.JFormattedTextField tfSalario;
    // End of variables declaration//GEN-END:variables

    private void iniciaTela() {
        try {
            tfCod.setText(String.valueOf(pfDAO.getLastId()));
            desabilitaCampos(false);
            carregaTable(funDAO.getAll());
            tfDtContr.setText(DateUtil.dateToString(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void desabilitaCampos(boolean ativo) {
        tfNome.setEnabled(ativo);
        tfCPF.setEnabled(ativo);
        cbSexo.setEnabled(ativo);
        tfRG.setEnabled(ativo);
        btClear.setEnabled(ativo);
        btAdd.setEnabled(ativo);
        btNew.setEnabled(!ativo);
        tfDtContr.setEnabled(ativo);
        tfSalario.setEnabled(ativo);
    }   
    
    private void limpaCampos() {
        tfNome.setText("");
        tfDtContr.setText(String.valueOf(new Date()));
        tfCPF.setText("");
        tfRG.setText("");
        cbSexo.setSelectedIndex(0);
        tfSalario.setText("");        
    }

    private void novo() {
        try {
            tfCod.setText(String.valueOf(pfDAO.getLastId()));
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

    private void verificaCampos() {
        if (tfNome.getText().trim().length() > 0 &&
                tfCPF.getText().replace(".", "").replace("-", "").trim().length() > 0 &&
                tfRG.getText().replace(".", "").replace("-", "").trim().length() > 0) {
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

    private String verificaSexo() {
        String sexo = "";
        switch (cbSexo.getSelectedIndex()) {
            case 0:
                sexo = "M";
                break;
            case 1:
                sexo = "F";
                break;
            case 2:
                sexo = "?";
                break;
        } 
        
        return sexo;
    }

}
