/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstock;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Go
 */
public class Sales extends javax.swing.JPanel {

    // Static variables to hold barcode, customer ID, and selected product name
    public static String barcode_c = "0" ;
    public static String cus_id = "0";
    public static String Select_product_name = null;
    
    // Constructor
    public Sales() {
        initComponents();
       data_load(); // Load data when initializing the panel
        
    }
// Method to load data into the interface components
  public void data_load(){
  
  // load customer data
  
      try {
          
          Statement s= db.mycon().createStatement();
          
          ResultSet rs = s.executeQuery("SELECT * FROM customer");
          Vector v = new Vector();
          
          while (rs.next()) {              
              v.add(rs.getString("customer_name")); // Add customer name to vector
              
              DefaultComboBoxModel com = new DefaultComboBoxModel(v);
              com_cus.setModel(com); // Set the model for the customer combo box
               
          }
           
      } catch (SQLException e) {
            System.out.println(e);
      }
     
     // Load product data
  
      try {
          
          Statement s= db.mycon().createStatement();
          
          ResultSet rs = s.executeQuery("SELECT * FROM product");
          Vector v = new Vector();
          
          while (rs.next()) {              
              v.add(rs.getString("Product_Name")); //Add product name to vector
              
              DefaultComboBoxModel com = new DefaultComboBoxModel(v);
              com_pro.setModel(com); // Set the model for the product combo box
               
          }
           
      } catch (SQLException e) {
            System.out.println(e);
      }  
      
      // Load the last invoice number and increment it
      
      try {
          
        Statement s = db.mycon().createStatement();
          ResultSet rs = s.executeQuery("SELECT * FROM extra WHERE exid =1");
          
          if (rs.next()) {
              
              inid.setText(rs.getString("val"));
              
          }
          
      } catch (Exception e) {
      }
     
       // Increment the invoice number
      int i = Integer.valueOf(inid.getText());
      i++;
      inid.setText(String.valueOf(i));
      
      
      /**
     * Method to calculate the total price for the selected product
     */
      
  }
    
 public void pro_tot_cal(){
 
  // product calculation
         
        Double qt = Double.valueOf(p_qty.getText());// Get quantity
        Double price = Double.valueOf(u_price.getText()); // Get unit price
        Double tot ;
        
        tot = qt * price;// Calculate total price
        
        tot_price.setText(String.valueOf(tot)); // Set total price in the text field
 
 }   
 
/**
     * Method to calculate the total amount for the cart
     */
    public void cart_total() {
        int numofrow = jTable1.getRowCount(); // Get number of rows in the table
        double total = 0;

        // Loop through each row to calculate the total price
        for (int i = 0; i < numofrow; i++) {
            double value = Double.valueOf(jTable1.getValueAt(i, 5).toString());
            total += value;
        }
        bill_tot.setText(Double.toString(total)); // Set the total bill amount

        // Calculate the total quantity
        int numofrows = jTable1.getRowCount();
        double totals = 0;
        for (int i = 0; i < numofrows; i++) {
            double values = Double.valueOf(jTable1.getValueAt(i, 3).toString());
            totals += values;
        }
        tot_qty.setText(Double.toString(totals)); // Set the total quantity
    }
 /**
     * Method to calculate the total, tax, discount, shipping cost, and balance
     */
 public void tot(){
     DecimalFormat df = new DecimalFormat("000.00");
        Double paid_amount = Double.valueOf(paid_amt.getText()); // Paid amount
        Double Total_amount = Double.valueOf(bill_tot.getText()); // Total amount
        Double Ship_cost = Double.valueOf(shipc.getText()); // Shipping cost
        Double Taxes = Double.valueOf(tax.getText()); // Tax percentage
        Double Discount = Double.valueOf(disc.getText()); // Discount percentage
         
      //calculate tax amount
      Double Tax_Amount = Total_amount * Taxes /100.0;
      t_taxamount.setText(String.valueOf(Tax_Amount));
      //calculate Discount Amount
      Double Discount_Amount = Total_amount * Discount /100.0;
      t_discamount.setText(String.valueOf(Discount_Amount));
   
       //calculate ship cost
      Double Shipping_cost = Double.valueOf(t_shipcost.getText());
      t_shipcost.setText(shipc.getText());
      
      //Grand Total Amount
      Double Grand_Amount =  (Total_amount + Ship_cost + Tax_Amount) - Discount_Amount;
      Grand.setText(df.format(Grand_Amount));
    //balance amount
      Double due;
      due =  paid_amount -Grand_Amount;
       
       balance.setText(df.format(due));
 
 }
 
 /**
     * Method to add data to the table
     */
 public void data_add_to_table(){
 
 DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        
        Vector v = new Vector();
        
        v.add(inid.getText()); // Add invoice ID
        v.add(Select_product_name); // Add selected product name
        v.add(br_code.getText()); // Add barcode
        v.add(p_qty.getText()); // Add quantity
        v.add(u_price.getText()); // Add unit price
        v.add(tot_price.getText()); // Add total price

        dt.addRow(v); // Add row to the table

        cart_total(); // Update cart total
        tot(); // Update overall totals
 
 }
 
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        inid = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        u_price = new javax.swing.JLabel();
        com_cus = new javax.swing.JComboBox<String>();
        com_pro = new javax.swing.JComboBox<String>();
        p_qty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tot_price = new javax.swing.JLabel();
        br_code = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cityname = new javax.swing.JLabel();
        Barcode = new javax.swing.JTextField();
        Product_name = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        bill_tot = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        t_discamount = new javax.swing.JLabel();
        Grand = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        t_shipcost = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        t_taxamount = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        shipc = new javax.swing.JTextField();
        tax = new javax.swing.JTextField();
        disc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        paid_amt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tot_qty = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        label1.setText("label1");

        setBackground(new java.awt.Color(255, 153, 0));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(255, 231, 209));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        inid.setText("01");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("INVOICE NO :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(inid)
                .addContainerGap(875, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inid)
                    .addComponent(jLabel2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 231, 209));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Customer :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Product :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Qty :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Unit Price :");

        u_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        u_price.setText("00.00");

        com_cus.setBackground(new java.awt.Color(255, 231, 209));
        com_cus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_cus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select " }));
        com_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_cusActionPerformed(evt);
            }
        });

        com_pro.setBackground(new java.awt.Color(255, 231, 209));
        com_pro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_pro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select " }));
        com_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_proActionPerformed(evt);
            }
        });
        com_pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                com_proKeyReleased(evt);
            }
        });

        p_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        p_qty.setText("0");
        p_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_qtyKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Total Price :");

        tot_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tot_price.setText("00.00");

        br_code.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        br_code.setText("0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Bar Code:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("City:");

        cityname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        Barcode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Barcode.setText("0");
        Barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarcodeActionPerformed(evt);
            }
        });
        Barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BarcodeKeyReleased(evt);
            }
        });

        Product_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Product_name.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(com_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(u_price, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tot_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cityname, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(Product_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(br_code, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Product_name)
                            .addComponent(br_code)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cityname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(u_price)
                                .addComponent(jLabel7)
                                .addComponent(tot_price)
                                .addComponent(jLabel5)
                                .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(com_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBackground(new java.awt.Color(255, 231, 209));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBackground(new java.awt.Color(255, 231, 209));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bill_tot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bill_tot.setText("00.00");
        bill_tot.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bill_tot.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("SUB-TOTAL");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("SHIPPING COST :");

        balance.setBackground(new java.awt.Color(51, 0, 51));
        balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        balance.setForeground(new java.awt.Color(255, 255, 255));
        balance.setText("00.00");
        balance.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        balance.setOpaque(true);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("DISCOUNT AMOUNT :");

        t_discamount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t_discamount.setText("00.00");
        t_discamount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        t_discamount.setOpaque(true);

        Grand.setBackground(new java.awt.Color(0, 102, 0));
        Grand.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Grand.setForeground(new java.awt.Color(255, 255, 255));
        Grand.setText("00.00");
        Grand.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Grand.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(0, 102, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("GRAND TOTAL AMOUNT :");
        jLabel21.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(51, 0, 51));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("BALANCE/DUE :");
        jLabel22.setOpaque(true);

        t_shipcost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t_shipcost.setText("00.00");
        t_shipcost.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        t_shipcost.setOpaque(true);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("TAX AMOUNT :");

        t_taxamount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t_taxamount.setText("00.00");
        t_taxamount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        t_taxamount.setOpaque(true);

        jButton4.setBackground(new java.awt.Color(255, 231, 209));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-receipt-50.png"))); // NOI18N
        jButton4.setText("Pay & Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                    .addComponent(Grand, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(t_discamount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(t_shipcost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(t_taxamount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_shipcost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(t_taxamount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_discamount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Grand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 231, 209));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Shipping Cost:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Tax:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Discount:");

        shipc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        shipc.setText("0");
        shipc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipcActionPerformed(evt);
            }
        });
        shipc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shipcKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                shipcKeyReleased(evt);
            }
        });

        tax.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tax.setText("0");
        tax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxActionPerformed(evt);
            }
        });
        tax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                taxKeyReleased(evt);
            }
        });

        disc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        disc.setText("0");
        disc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Paid Amount :");

        paid_amt.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        paid_amt.setText("0");
        paid_amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paid_amtActionPerformed(evt);
            }
        });
        paid_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paid_amtKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("%");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("%");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Total QTY:");

        tot_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tot_qty.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel18))
                                .addGap(18, 18, 18)))))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(shipc, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tot_qty)
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(disc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(tax, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)))
                            .addComponent(paid_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(shipc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(tot_qty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel24))
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paid_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTable1.setBackground(new java.awt.Color(255, 231, 209));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INID", "Name", "Bar code", "Qty", "Unit Price", "Total Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel5.setBackground(new java.awt.Color(255, 231, 209));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setBackground(new java.awt.Color(255, 231, 209));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-shopping-basket-remove-48.png"))); // NOI18N
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 231, 209));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-shopping-basket-add-48.png"))); // NOI18N
        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 231, 209));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-remove-50.png"))); // NOI18N
        jButton3.setText("Remove All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jButton1)
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void com_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_proActionPerformed
       // This method is triggered when an action is performed on the product combo box (com_pro).
    
    // Get the selected product name from the combo box.
    String name = com_pro.getSelectedItem().toString();
    
    try {
        // Create a statement to execute the SQL query.
        Statement s = db.mycon().createStatement();
        
        // Execute the query to get the barcode and selling price for the selected product.
        ResultSet rs = s.executeQuery("SELECT Bar_code, Sell_Price FROM product WHERE Product_Name ='" + name + "'");
        
        // If the query returns a result, update the unit price, barcode, and selected product name.
        if (rs.next()) {
            u_price.setText(rs.getString("Sell_Price")); // Set the unit price text field with the selling price.
            br_code.setText(rs.getString("Bar_code")); // Set the barcode text field with the barcode.
            Select_product_name = name; // Update the selected product name.
        }

        // Calculate the total price for the product based on quantity and unit price.
        pro_tot_cal();

    } catch (SQLException e) {
        // Print any SQL exception that occurs.
        System.out.println(e);
    }

    // After selecting the product, clear the quantity text field.
    p_qty.setText("");
    
    // Set the focus to the barcode text field.
    Barcode.requestFocus();
    }//GEN-LAST:event_com_proActionPerformed

    private void p_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_qtyKeyReleased

    // Calculate the total price for the product based on the quantity and unit price.
    pro_tot_cal();

    // Check if the Enter key is released.
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        // If Enter key is pressed, add the product data to the table.
        data_add_to_table();

        // After adding the data, clear the barcode text field.
        Barcode.setText("");
        
        // Set the focus to the barcode text field.
        Barcode.requestFocus();
    }
    }//GEN-LAST:event_p_qtyKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //add  cart to product details 
        data_add_to_table();
       
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // This method is triggered when the "Remove" button (jButton2) is clicked.
    
    try {
        // Get the table model to manipulate table data.
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        
        // Get the index of the selected row in the table.
        int rw = jTable1.getSelectedRow();
        
        // Remove the selected row from the table model.
        dt.removeRow(rw);

    } catch (Exception e) {
        // Catch any exceptions that may occur during the removal process.
    }
    
    // Update the cart total after removing an item from the table.
    cart_total(); 
    
    // Update the total amounts after cart modification.
    tot(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       // This method is triggered when the "Remove All" button (jButton3) is clicked.
    
    // Get the table model to manipulate table data.
    DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
    
    // Set the row count of the table model to 0, effectively removing all rows.
    dt.setRowCount(0);

    // Update the cart total after removing all items from the table.
    cart_total();
    
    // Update the total amounts after cart modification.
    tot(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void paid_amtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paid_amtKeyReleased
        
      tot(); 
        
        
    }//GEN-LAST:event_paid_amtKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // data send to databace
        // This method is an event handler for the action performed by jButton4, likely a button click.
    // It's responsible for saving data to a database, handling sales, and generating a report.

        try {
            
            // `cartid`, `INID`, `Product_Name`, `Bar_code`, `qty`, `Unit_Price`, `Total_Price`
            
          DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
          int rc = dt.getRowCount();
           // Iterating through the rows of jTable1 to retrieve data and save it to the cart database.
            for (int i = 0; i < rc; i++) {
                // Retrieving data from each column of the table.
                String inid = dt.getValueAt(i, 0).toString(); // get inid
                String P_name = dt.getValueAt(i, 1).toString(); // get product name
                String bar_code = dt.getValueAt(i, 2).toString(); // get barcode
                String qty = dt.getValueAt(i, 3).toString(); // get product qty
                String un_price = dt.getValueAt(i, 4).toString(); // get product unit price
                String tot_price = dt.getValueAt(i, 5).toString(); // get product total Price
            
                // Saving the retrieved data into the cart database.
             Statement s = db.mycon().createStatement();
             s.executeUpdate(" INSERT INTO cart (INID, Product_Name, Bar_code, qty, Unit_Price, Total_Price) VALUES ('"+inid+"','"+P_name+"','"+bar_code+"','"+qty+"','"+un_price+"','"+tot_price+"') ");
           
            }
            
                JOptionPane.showMessageDialog(null, "Data Saved");
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
  
        try {
            
            
            // Retrieving data related to sales.
             
             //`saleid`, `INID`, `Cid`, `Customer_Name`, `Total_Qty`, `Total_Bill`, `Status`, `Balance`
            String inv_id = inid.getText();
            String cname  = com_cus.getSelectedItem().toString();
            String totqty = tot_qty.getText();
            String tot_bil = bill_tot.getText();           
            String blnc = balance.getText();
            
             // Determining the status of the payment (Paid, Partial, or Unpaid).
             
             Double tot = Double.valueOf(bill_tot.getText());
             Double pid = Double.valueOf(paid_amt.getText());
             String Status = null;
             if (pid.equals(0.0)) {
                 
                Status = "Unpaid";
                
            }else if (tot>pid) {
                 Status = "Partial";
                 
            }else if (tot<=pid) {
                Status = "Paid";
            }
             
            
            
             // Saving sales data into the sales database.
             Statement ss = db.mycon().createStatement();
             ss.executeUpdate("INSERT INTO sales(INID, Cid, Customer_Name, Total_Qty, Total_Bill, Status, Balance) VALUES('"+inv_id+"','"+cus_id+"','"+cname+"','"+totqty+"','"+tot_bil+"','"+Status+"','"+blnc+"')");
             
            
            
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
  
        // Saving the last INID number.
        try {
            
           String id = inid.getText(); 
            Statement s = db.mycon().createStatement();
            s.executeUpdate("UPDATE  extra SET val='"+id+"' WHERE exid = 1");
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
       
       // Printing or viewing the report (iReport bill).
        try {
            
           
        HashMap para = new HashMap();
        
        para.put("inv_id", inid.getText());  // inv_id  is ireport parameter name
        
        ReportView r =new ReportView("src\\Reports\\print.jasper", para);
        r.setVisible(true);  
            
            
            
        } catch (Exception e) {
        // Handling any exceptions that may occur during report generation.
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void com_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_cusActionPerformed
   // This method is triggered when an action is performed on the com_cus combo box, likely a selection change.

    // Retrieving the selected customer name from the combo box.
    String name = com_cus.getSelectedItem().toString();
    
    try {
        // Creating a database statement to query the customer table based on the selected customer name.
        Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT cid, city, customer_name FROM customer WHERE customer_name ='" + name + "'");

        // If a matching record is found in the database.
        if (rs.next()) {
            // Retrieving the customer ID and city from the result set.
            cus_id = rs.getString("cid");
            cityname.setText(rs.getString("city"));
        }
    } catch (SQLException e) {
        // Handling any SQL exception that might occur.
        System.out.println(e);
    }

        
        
    }//GEN-LAST:event_com_cusActionPerformed

    private void BarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodeKeyReleased
       // This method is triggered when a key is released in the Barcode text field, likely used for barcode scanning.

    // Retrieving the barcode from the Barcode text field.
    String bcode = Barcode.getText();
    
    try {
        // Creating a database statement to query the product table based on the barcode.
        Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT Bar_code, Product_Name, Sell_Price FROM product WHERE Bar_code ='" + bcode + "'");

        // If a matching product is found in the database.
        if (rs.next()) {
            // Updating GUI components with product information retrieved from the database.
            u_price.setText(rs.getString("Sell_Price"));
            br_code.setText(rs.getString("Bar_code"));
            Select_product_name = rs.getString("Product_Name");
            Product_name.setText(rs.getString("Product_Name"));

            // Updating the combo box model with the retrieved product name.
             Vector<String> v = new Vector<>();
            v.add(rs.getString("Product_Name"));
            DefaultComboBoxModel<String> combo = new DefaultComboBoxModel<>(v);
            com_pro.setModel(combo);
        } else {
            // If no result is found
            System.out.println("Product not found for barcode: " + bcode);
        }

        // Calculating product total after retrieving product details.
        pro_tot_cal();

   } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        System.out.println("Exception: " + e.getMessage());
        e.printStackTrace();
    }
    
    // Pressing the Enter key moves the cursor to the quantity text field.
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        p_qty.selectAll();
        p_qty.requestFocus();
    }
    }//GEN-LAST:event_BarcodeKeyReleased

    private void BarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarcodeActionPerformed

    private void paid_amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paid_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paid_amtActionPerformed

    private void taxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taxActionPerformed

    private void shipcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shipcActionPerformed

    private void shipcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shipcKeyPressed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_shipcKeyPressed

    private void shipcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shipcKeyReleased
        // TODO add your handling code here:
          tot();
    }//GEN-LAST:event_shipcKeyReleased

    private void taxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxKeyReleased
        // TODO add your handling code here:
          tot();
    }//GEN-LAST:event_taxKeyReleased

    private void discKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discKeyReleased
        // TODO add your handling code here:
          tot();
    }//GEN-LAST:event_discKeyReleased

    private void com_proKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_com_proKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_com_proKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Barcode;
    private javax.swing.JLabel Grand;
    private javax.swing.JLabel Product_name;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel bill_tot;
    private javax.swing.JLabel br_code;
    private javax.swing.JLabel cityname;
    private javax.swing.JComboBox<String> com_cus;
    private javax.swing.JComboBox<String> com_pro;
    private javax.swing.JTextField disc;
    private javax.swing.JLabel inid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JTextField p_qty;
    private javax.swing.JTextField paid_amt;
    private javax.swing.JTextField shipc;
    private javax.swing.JLabel t_discamount;
    private javax.swing.JLabel t_shipcost;
    private javax.swing.JLabel t_taxamount;
    private javax.swing.JTextField tax;
    private javax.swing.JLabel tot_price;
    private javax.swing.JLabel tot_qty;
    private javax.swing.JLabel u_price;
    // End of variables declaration//GEN-END:variables
}
