/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatDarkLaf;
import static gui.SignIn.logger;
import javax.swing.JOptionPane;
import model.MySQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huawei
 */
public class UserRegistration extends javax.swing.JFrame {

    private static HashMap<String, String> userTypeMap = new HashMap<>();
    private static HashMap<String, String> employeeGenderMap = new HashMap<>();
    private static HashMap<String, String> statusMap = new HashMap<>();

    /**
     * Creates new form UserRegistration
     */
    public UserRegistration() {
        initComponents();
        loadTypes();
        loadGender();
        loadUsers();
        loadStatus();
    }

    private void loadTypes() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `user_type`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                vector.add(resultSet.getString("type"));
                userTypeMap.put(resultSet.getString("type"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model1 = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model1);

        } catch (Exception e) {
            logger.log(Level.WARNING, "User_registration_load_types", e);
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
            logger.log(Level.WARNING, "user_registration_load_status", e);
        }

    }

    private void loadGender() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `gender`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                vector.add(resultSet.getString("type"));
                employeeGenderMap.put(resultSet.getString("type"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);

        } catch (Exception e) {
            logger.log(Level.WARNING, "user_registration_load_gender", e);
        }

    }

    private void reset() {

        jTextField1.setText("");
        jTextField1.setEnabled(true);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox4.setEnabled(false);

    }

    private void loadUsers() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `user` "
                    + "INNER JOIN `user_type` ON `user`.`user_type_id`=`user_type`.`id` "
                    + "INNER JOIN `gender` ON `user`.`gender_id`=`gender`.`id`"
                    + "INNER JOIN `status` ON `user`.`status_id`=`status`.`id`");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("gender.type"));
                vector.add(resultSet.getString("password"));
                vector.add(resultSet.getString("user_type.type"));
                vector.add(resultSet.getString("date_registered"));
                vector.add(resultSet.getString("status.status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            logger.log(Level.WARNING, "user_registration_load_users", e);
        }

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
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Registration");
        setResizable(false);

        jLabel1.setText("Email");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("First Name");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Last Name");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setText("NIC");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Mobile");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel8.setText("Gender");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Password");

        jLabel7.setText("Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Create Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "First Name", "Last Name", "NIC", "Mobile", "Gender", "Password", "Type", "Date Registerd", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
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

        jLabel9.setText("Account Status");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)))
                                .addGap(15, 21, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField5)
                                    .addComponent(jComboBox2, 0, 170, Short.MAX_VALUE)))
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {

            String email = jTextField1.getText();
            String fname = jTextField2.getText();
            String lname = jTextField3.getText();
            String nic = jTextField4.getText();
            String mobile = jTextField5.getText();
            String gender = String.valueOf(jComboBox2.getSelectedItem());
            String type = String.valueOf(jComboBox1.getSelectedItem());
            String password = String.valueOf(jPasswordField1.getPassword());

            if (fname.isEmpty()) {

                JOptionPane.showMessageDialog(this, "please Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (lname.isEmpty()) {

                JOptionPane.showMessageDialog(this, "please Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (nic.isEmpty()) {

                JOptionPane.showMessageDialog(this, "please Enter nic", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (mobile.isEmpty()) {

                JOptionPane.showMessageDialog(this, "please Enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {

                JOptionPane.showMessageDialog(this, "Invalid Mobile", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (gender.equals("Select")) {

                JOptionPane.showMessageDialog(this, "please Enter gender", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (password.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Please Enter Password", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (type.equals("Select")) {

                JOptionPane.showMessageDialog(this, "please Enter Employee Type", "Warning", JOptionPane.WARNING_MESSAGE);

            } else {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `user` WHERE `email`='" + email + "' OR `nic`='" + nic + "' OR `mobile`='" + mobile + "'");

                if (resultSet.next()) {

                    JOptionPane.showMessageDialog(this, "Email, Mobile or NIC Already Used", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.execute("INSERT INTO `user` (`email`,`password`,`first_name`,`last_name`,`nic`,`mobile`,`user_type_id`,`gender_id`,`date_registered`,`status_id`) "
                            + "VALUES ('" + email + "','" + password + "','" + fname + "','" + lname + "','" + nic + "','" + mobile + "','" + userTypeMap.get(type) + "'"
                            + ",'" + employeeGenderMap.get(gender) + "','" + sdf.format(date) + "','1')");

                    loadUsers();
                    reset();
                }
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "user_registration_Insert_user", e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(this, "Please Select Account You Want to Update", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {

                String email = jTextField1.getText();
                String fname = jTextField2.getText();
                String lname = jTextField3.getText();
                String nic = jTextField4.getText();
                String mobile = jTextField5.getText();
                String gender = String.valueOf(jComboBox2.getSelectedItem());
                String type = String.valueOf(jComboBox1.getSelectedItem());
                String password = String.valueOf(jPasswordField1.getPassword());
                String status = String.valueOf(jComboBox4.getSelectedItem());

                if (fname.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "please Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (lname.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "please Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (nic.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "please Enter nic", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (mobile.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "please Enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {

                    JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (gender.equals("Select")) {

                    JOptionPane.showMessageDialog(this, "please Enter gender", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {

                    JOptionPane.showMessageDialog(this, "Password must Contain Minimum eight characters, at least one uppercase letter, one lowercase letter and one number", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (type.equals("Select")) {

                    JOptionPane.showMessageDialog(this, "please Enter Employee Type", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (status.equals("Select")) {

                    JOptionPane.showMessageDialog(this, "Please Select Account Status", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    ResultSet resultSet = MySQL.execute("SELECT * FROM `user` WHERE `nic`='" + nic + "' OR `mobile`='" + mobile + "'");

                    boolean canUpdate = false;

                    if (resultSet.next()) {

                        if (!resultSet.getString("email").equals(email)) {

                            JOptionPane.showMessageDialog(this, "Mobile or Nic is already used", "Warning", JOptionPane.WARNING_MESSAGE);

                        } else {
                            canUpdate = true;
                        }

                    } else {

                        canUpdate = true;

                    }

                    if (canUpdate) {

                        MySQL.execute("UPDATE `user` SET `first_name`='" + fname + "',`last_name`='" + lname + "',`nic`='" + nic + "',"
                                + "`mobile`='" + mobile + "',`gender_id`='" + employeeGenderMap.get(gender) + "',"
                                + "`password`='" + password + "',`user_type_id`='" + userTypeMap.get(type) + "',"
                                + "`status_id`='" + statusMap.get(status) + "' WHERE `email`='" + email + "'");

                        JOptionPane.showMessageDialog(this, "User Account Updated", "Success", JOptionPane.INFORMATION_MESSAGE);

                        loadUsers();
                        reset();

                    }
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "user_registration_Update_user", e);
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {

            int row = jTable1.getSelectedRow();

            jTextField1.setEnabled(false);
            jComboBox4.setEnabled(true);

            String email = String.valueOf(jTable1.getValueAt(row, 0));
            jTextField1.setText(email);

            String fname = String.valueOf(jTable1.getValueAt(row, 1));
            jTextField2.setText(fname);

            String lname = String.valueOf(jTable1.getValueAt(row, 2));
            jTextField3.setText(lname);

            String nic = String.valueOf(jTable1.getValueAt(row, 3));
            jTextField4.setText(nic);

            String mobile = String.valueOf(jTable1.getValueAt(row, 4));
            jTextField5.setText(mobile);

            String gender = String.valueOf(jTable1.getValueAt(row, 5));
            jComboBox2.setSelectedItem(gender);

            String password = String.valueOf(jTable1.getValueAt(row, 6));
            jPasswordField1.setText(password);

            String type = String.valueOf(jTable1.getValueAt(row, 7));
            jComboBox1.setSelectedItem(type);

            String status = String.valueOf(jTable1.getValueAt(row, 9));
            jComboBox4.setSelectedItem(status);
        }

        if (evt.getClickCount() == 2) {

            int row = jTable1.getSelectedRow();
            String email = String.valueOf(jTable1.getValueAt(row, 0));

        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
