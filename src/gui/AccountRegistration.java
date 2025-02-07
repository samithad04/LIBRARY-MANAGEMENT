/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatDarkLaf;
import static gui.SignIn.logger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Huawei
 */
public class AccountRegistration extends javax.swing.JFrame {

    private BookReservation reservation;

    public void setReservation(BookReservation reservation) {
        this.reservation = reservation;
    }

    private BookReturn bookReturn;

    public void setBookReturn(BookReturn bookReturn) {
        this.bookReturn = bookReturn;
    }

    private static HashMap<String, String> GenderMap = new HashMap<>();
    private static HashMap<String, String> typeMap = new HashMap<>();
    private static HashMap<String, String> statusMap = new HashMap<>();

    /**
     * Creates new form AccountRegistration
     */
    public AccountRegistration() {
        initComponents();
        loadType();
        loadAccounts("");
        loadGender();
        loadStatus();
    }

    private void loadAccounts(String id) {

        try {

            String query = "SELECT * FROM `account` INNER JOIN `gender` ON `account`.`gender_id`=`gender`.`id`"
                    + "INNER JOIN `grade_or_type` ON `account`.`grade_or_type_id`=`grade_or_type`.`id` "
                    + "INNER JOIN `status` ON `account`.`status_id`=`status`.`id` WHERE `account`.`id` LIKE '" + id + "%' ";

            String sort = String.valueOf(jComboBox3.getSelectedItem());

            if (sort.equals("Select")) {
                //query += "";
            } else {

                query += "AND `grade_or_type`.`grade_type`='" + sort + "'";

            }

            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("membership_date"));
                vector.add(resultSet.getString("gender.type"));
                vector.add(resultSet.getString("grade_or_type.grade_type"));
                vector.add(resultSet.getString("status.status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "Account_registration_load_accounts", e);
        }

    }

    private void loadGender() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `gender`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                vector.add(resultSet.getString("type"));
                GenderMap.put(resultSet.getString("type"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Account_registration_load_genders", e);
        }

    }

    private void loadType() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `grade_or_type`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                vector.add(resultSet.getString("grade_type"));
                typeMap.put(resultSet.getString("grade_type"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);

            DefaultComboBoxModel model2 = new DefaultComboBoxModel(vector);
            jComboBox3.setModel(model2);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Account_registration_load_type", e);
        }

    }

    private void loadStatus() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `status`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                vector.add(resultSet.getString("status"));
                statusMap.put(resultSet.getString("status"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox4.setModel(model);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Accout_registration_load_status", e);
        }

    }

    private void resetUI() {

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jTextField1.grabFocus();
        jComboBox4.setEnabled(false);
        jButton2.setEnabled(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Account Registration");
        setResizable(false);

        jLabel1.setText("Account ID");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Gender");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Grade or Type");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel6.setText("Account Registration");

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add New Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update Account");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Account Status");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.setEnabled(false);

        jButton4.setText("R");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, 185, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account ID", "First Name", "Last Name", "Membership Date", "Gender", "Grade or Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jLabel7.setText("Sort by Grade or Type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(this, "Please Select Account You Want to Update", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {

                String id = jTextField1.getText();
                String fname = jTextField2.getText();
                String lname = jTextField3.getText();
                String gender = String.valueOf(jComboBox1.getSelectedItem());
                String type = String.valueOf(jComboBox2.getSelectedItem());
                String status = String.valueOf(jComboBox4.getSelectedItem());

                if (fname.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (lname.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "Please Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (gender.equals("Select")) {

                    JOptionPane.showMessageDialog(this, "Please Select Gender", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (type.equals("Select")) {

                    JOptionPane.showMessageDialog(this, "Please Select Grade or Type", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (status.equals("Select")) {

                    JOptionPane.showMessageDialog(this, "Please Select Account Status", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    ResultSet resultSet = MySQL.execute("SELECT * FROM `account` WHERE `id`='" + id + "'");

                    if (jTable1.getSelectionModel().isSelectionEmpty()) {

                        JOptionPane.showMessageDialog(this, "Please Select Account to Update", "Warning", JOptionPane.WARNING_MESSAGE);

                    } else {

                        MySQL.execute("UPDATE `account` SET `first_name`='" + fname + "',`last_name`='" + lname + "',"
                                + "`gender_id`='" + GenderMap.get(gender) + "',`grade_or_type_id`='" + typeMap.get(type) + "',"
                                + "`status_id`='" + statusMap.get(status) + "' WHERE `id`='" + id + "'");

                        JOptionPane.showMessageDialog(this, "Account Updated", "Success", JOptionPane.INFORMATION_MESSAGE);

                        loadAccounts("");
                        resetUI();
                    }
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Account_registration_Update_user", e);
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:

        loadAccounts(jTextField1.getText());

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        String id = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String gender = String.valueOf(jComboBox1.getSelectedItem());
        String type = String.valueOf(jComboBox2.getSelectedItem());

        if (id.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please Enter Account ID", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (fname.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (lname.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (gender.equals("Select")) {

            JOptionPane.showMessageDialog(this, "Please Select Gender", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (type.equals("Select")) {

            JOptionPane.showMessageDialog(this, "Please Select Grade or Type", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `account` WHERE `id`='" + id + "'");

                if (resultSet.next()) {

                    JOptionPane.showMessageDialog(this, "Account ID Already Registerd", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.execute("INSERT INTO `account`(`id`,`first_name`,`last_name`,`membership_date`,`gender_id`,`grade_or_type_id`,`status_id`) "
                            + "VALUES ('" + id + "','" + fname + "','" + lname + "','" + sdf.format(date) + "','" + GenderMap.get(gender) + "',"
                            + "'" + typeMap.get(type) + "','1')");

                    loadAccounts("");
                    resetUI();

                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Account_registration_Insert_user", e);
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String gradeType = jTextField4.getText();

        if (gradeType.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please Enter Grade or Type", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `grade_or_type` WHERE `grade_type`='" + gradeType + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Type or Grade Already Added", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    if (jComboBox2.getSelectedIndex() == 0) {
                        MySQL.execute("INSERT INTO `grade_or_type`(`grade_type`) VALUES ('" + gradeType + "')");
                        JOptionPane.showMessageDialog(this, "New Type added", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {

                        int response = JOptionPane.showConfirmDialog(this, "Do you want to update this Type", "Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            MySQL.execute("UPDATE `grade_or_type` SET `grade_type`='" + gradeType + "' WHERE `grade_type`='" + String.valueOf(jComboBox2.getSelectedItem()) + "'");
                            JOptionPane.showMessageDialog(this, "Type Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }

                    loadType();
                    jTextField4.setText("");

                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Account_registration_Insert_or_update_Gradetype", e);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int row = jTable1.getSelectedRow();

        if (evt.getClickCount() == 1) {

            jTextField1.setEnabled(false);
            jComboBox4.setEnabled(true);
            jButton2.setEnabled(false);

            String id = String.valueOf(jTable1.getValueAt(row, 0));
            jTextField1.setText(id);

            String fname = String.valueOf(jTable1.getValueAt(row, 1));
            jTextField2.setText(fname);

            String lname = String.valueOf(jTable1.getValueAt(row, 2));
            jTextField3.setText(lname);

            String gender = String.valueOf(jTable1.getValueAt(row, 4));
            jComboBox1.setSelectedItem(gender);

            String type = String.valueOf(jTable1.getValueAt(row, 5));
            jComboBox2.setSelectedItem(type);

            String status = String.valueOf(jTable1.getValueAt(row, 6));
            jComboBox4.setSelectedItem(status);
        }

        if (evt.getClickCount() == 2) {

            if (reservation != null) {
                reservation.getjTextField3().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                reservation.getjTextField4().setText(String.valueOf(jTable1.getValueAt(row, 1)) + " " + String.valueOf(jTable1.getValueAt(row, 2)));
                reservation.getjTextField3().setEditable(false);
                this.dispose();
            }

            if (bookReturn != null) {
                bookReturn.getjTextField3().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                bookReturn.getjTextField4().setText(String.valueOf(jTable1.getValueAt(row, 1)) + " " + String.valueOf(jTable1.getValueAt(row, 2)));
                bookReturn.getjTextField3().setEditable(false);
                this.dispose();
            }

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:

        loadAccounts("");

    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        resetUI();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
