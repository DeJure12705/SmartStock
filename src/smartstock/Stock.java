    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstock;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author De Jure
 */



public class Stock extends javax.swing.JPanel {
// Database connection and query objects
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    // Date object for current date
    Date ddad = new Date();
    // Date formatter for formatting date
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // String to hold formatted current date
    String logdate = (dateFormat.format(ddad));
    // Default id
    String id = "0";



    // Constructor
    public Stock() {
        // Initialize components
        initComponents();
        // Establish database connection
        con = db.mycon();
        // Load data into table
        tbload();
        // Call method to calculate total
        cal();
        // Call method to display total for all products
        all();
    }
   // Method to load data into table
    public void tbload() {
        try {
            // SQL query to select all data from the product table
            String sql = "SELECT * FROM product";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            // Set the table model with the result set
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method to filter data based on parameters
    public void paras() {
        // Get search parameters from text fields
        String bcode = txt_bcode.getText(); // Barcode
        String pname = txt_pname.getText(); // Product name
        String supp = text_supp.getText();  // Supplier name

        try {
            // SQL query to filter data based on parameters
            String sql = "SELECT * FROM product WHERE Product_Name LIKE '%" + pname + "%' AND Supplier_Name LIKE '%" + supp + "%' AND Bar_code LIKE '%" + bcode + "%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            // Set the table model with the filtered result set
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e);
        }
        // Call method to recalculate total
        cal();
    }

    // Method to calculate total quantity for all products
    public void all() {
        try {
            // Create a statement for SQL query
            Statement s = db.mycon().createStatement();
            // Execute query to calculate total quantity
            ResultSet rs = s.executeQuery("SELECT SUM(Qty) FROM product");
            // If result is found
            if (rs.next()) {
                // Set total quantity in GUI component
                date_new1.setText(rs.getString("SUM(Qty)"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method to calculate total value of stock
    public void cal() {
        // Get number of rows in the table
        int numberOfRaw = jTable1.getRowCount();
        double total = 0;

        // Iterate through each row to calculate total
        for (int i = 0; i < numberOfRaw; i++) {
            // Get the value from the 5th column (assuming the column index for total value)
            double value = Double.valueOf(jTable1.getValueAt(i, 5).toString());
            total += value;
        }

        // Display total in GUI component
        date_new1.setText(Double.toString(total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_bcode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_pname = new javax.swing.JTextField();
        text_supp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        date_new1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_bcode1 = new javax.swing.JTextField();
        txt_pname1 = new javax.swing.JTextField();
        txt_stkqty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_newQty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 0));

        jTabbedPane2.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jPanel1.setBackground(new java.awt.Color(255, 231, 209));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_bcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bcodeActionPerformed(evt);
            }
        });
        txt_bcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bcodeKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Barcode ID:");

        txt_pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pnameActionPerformed(evt);
            }
        });
        txt_pname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pnameKeyReleased(evt);
            }
        });

        text_supp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_suppKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Product Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Supplier Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_bcode, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(125, 125, 125)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_pname, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bcode, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setBackground(new java.awt.Color(255, 231, 209));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Bar_code", "Cost Price", "Stock Qty", "Supplier_ID", "Supplier_Name"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Table Total :");

        date_new1.setBackground(new java.awt.Color(204, 255, 204));
        date_new1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        date_new1.setText("0");
        date_new1.setMaximumSize(new java.awt.Dimension(6, 28));
        date_new1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_new1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_new1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(249, 249, 249))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date_new1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("View Stock", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));

        jPanel3.setBackground(new java.awt.Color(255, 231, 209));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_bcode1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_bcode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bcode1ActionPerformed(evt);
            }
        });
        txt_bcode1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bcode1KeyReleased(evt);
            }
        });

        txt_pname1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_pname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pname1ActionPerformed(evt);
            }
        });
        txt_pname1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pname1KeyReleased(evt);
            }
        });

        txt_stkqty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_stkqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stkqtyActionPerformed(evt);
            }
        });
        txt_stkqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_stkqtyKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Stock Qty:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Product Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Barcode ID:");

        txt_newQty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_newQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_newQtyActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 231, 209));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-save-50.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.setToolTipText("");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("New Add /Less Qty");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_bcode1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txt_pname1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_stkqty, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_newQty, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bcode1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pname1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_stkqty, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_newQty, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ADD Stock", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1268, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void date_new1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_new1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_new1ActionPerformed

    private void txt_bcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bcodeKeyReleased
      paras();
    }//GEN-LAST:event_txt_bcodeKeyReleased

    private void txt_pnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pnameKeyReleased
       paras();
    }//GEN-LAST:event_txt_pnameKeyReleased

    private void text_suppKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_suppKeyReleased
        paras();
    }//GEN-LAST:event_text_suppKeyReleased

    private void txt_pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pnameActionPerformed

    private void txt_bcode1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bcode1KeyReleased
            // This method is an event handler for key release events in txt_bcode1 component.
    // It retrieves product details based on the entered barcode.

    // Get the barcode entered in txt_bcode1
    String name= txt_bcode1.getText();
    try{
        // Create a statement for database query
        Statement s = db.mycon().createStatement();
        // Execute query to retrieve product details based on barcode
        ResultSet rs = s.executeQuery("SELECT * FROM product WHERE Bar_code = '"+name+"'");
        // If result is found
        if(rs.next()){
            // Update id, product name, and stock quantity fields with retrieved values
            id= rs.getString("pid");
            txt_pname1.setText(rs.getString("Product_Name"));
            txt_stkqty.setText(rs.getString("Qty"));
        }
    } catch(SQLException e) {
        System.out.println(e);
    }
        
        
    }//GEN-LAST:event_txt_bcode1KeyReleased

    private void txt_pname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pname1ActionPerformed

    private void txt_pname1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pname1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pname1KeyReleased

    private void txt_stkqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stkqtyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stkqtyKeyReleased

    private void txt_bcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bcodeActionPerformed

    private void txt_bcode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bcode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bcode1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  // This method is an event handler for the action performed by jButton1.
    // It is responsible for updating the stock quantity of a product.

    // Get the new quantity entered in txt_newQty field
    double newqty = Double.valueOf(txt_newQty.getText());
    // Get the old quantity from txt_stkqty field
    double oldQty = Double.valueOf(txt_stkqty.getText());
    // Calculate the updated quantity by adding the new quantity to the old quantity
    double up_qty=  newqty + oldQty;
    
    try {
        // Create a statement for database query
        Statement s = db.mycon().createStatement();
        // Execute the SQL update query to update the stock quantity of the product
        s.executeUpdate("UPDATE product SET Qty ='"+up_qty+"' WHERE pid = '"+id+"' ");
        // Display a success message
        JOptionPane.showMessageDialog(null, "Data Updated");
    } catch (HeadlessException | SQLException e) {
        // Print any exceptions that occur
        System.out.println(e);
    }

       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_newQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_newQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_newQtyActionPerformed

    private void txt_stkqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stkqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stkqtyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date_new1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField text_supp;
    private javax.swing.JTextField txt_bcode;
    private javax.swing.JTextField txt_bcode1;
    private javax.swing.JTextField txt_newQty;
    private javax.swing.JTextField txt_pname;
    private javax.swing.JTextField txt_pname1;
    private javax.swing.JTextField txt_stkqty;
    // End of variables declaration//GEN-END:variables
}
