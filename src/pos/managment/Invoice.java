package pos.managment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Invoice extends javax.swing.JPanel {

    
    public Invoice() {
        initComponents();
        updateTable();
        jDateChooser.setMaxSelectableDate(new Date());
    }

    private void updateTable() {
        String[] columnNames = {"Invoice Id", "Customer Name", "Customer Id", "Product Name", "Bar Code", "Unit Price", "Quantity", "Price", "Date"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        try {
            String query = "select a.*, b.name,c.product_name,c.sell_price, (c.sell_price * a.quantity) as price from dbo.sales a inner join dbo.customer b on a.customer_id = b.c_id inner join dbo.product c on a.barcode = c.bar_code";
            Statement s = DBUtil.getConnection().createStatement();
            ResultSet result = s.executeQuery(query);
            while(result.next()) {
                Object[] row = {
                    result.getInt("invoice_id"),
                    result.getString("name"),
                    result.getInt("customer_id"),
                    result.getString("product_name"),
                    result.getString("barcode"),
                    result.getDouble("sell_price"),
                    result.getDouble("quantity"),
                    result.getDouble("price"),
                    result.getString("date")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error Occured while fetching sales data..." + e);
        }
        jTable1.setModel(model);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inid = new javax.swing.JTextField();
        i_search = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(36, 143, 228));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Date:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("INID :");

        inid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inidActionPerformed(evt);
            }
        });

        i_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        i_search.setText("Search");
        i_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1123, 1123, 1123)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inid, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(i_search)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(i_search)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(215, 215, 246));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice Id", "Customer Name", "Customer Id", "Product Name", "Bar Code", "Unit Price", "Quantity", "Price", "Date"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inidActionPerformed

    private void i_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_searchActionPerformed
        // customer Name Search Btn:
        try {
            String invoice_id = inid.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = "";
            if (jDateChooser.getDate() == null) {
                System.out.println("Null date");
            } else {
                System.out.println(jDateChooser.getDate());
                date = sdf.format(jDateChooser.getDate());
            }
            System.out.println(invoice_id + ":" + date);
            if ((invoice_id.isBlank() || invoice_id.isEmpty()) && (date.isBlank() || date.isEmpty())) {
                System.out.println("No search");
            }
            String sql;
            if (!invoice_id.isEmpty() && !date.isEmpty()){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(jDateChooser.getDate());
                calendar.add(Calendar.DATE, 1);
                String nextDate = sdf.format(calendar.getTime());
                String[] columnNames = {"Invoice Id", "Customer Name", "Customer Id", "Product Name", "Bar Code", "Unit Price", "Quantity", "Price", "Date"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                sql = "select * from dbo.vw_sales_data where invoice_id = ? and date >= ? and date < ?"; 
                PreparedStatement s = DBUtil.getConnection().prepareStatement(sql);
                s.setString(1, invoice_id);
                s.setString(2, date);
                s.setString(3, nextDate);
                ResultSet result = s.executeQuery();
                while(result.next()) {
                    Object[] row = {
                        result.getInt("invoice_id"),
                        result.getString("customer_name"),
                        result.getInt("customer_id"),
                        result.getString("product_name"),
                        result.getString("barcode"),
                        result.getDouble("sell_price"),
                        result.getDouble("quantity"),
                        result.getDouble("price"),
                        result.getString("date")
                    };
                    model.addRow(row);
                }
                jTable1.setModel(model);
            } else if (!invoice_id.isEmpty()) {
                String[] columnNames = {"Invoice Id", "Customer Name", "Customer Id", "Product Name", "Bar Code", "Unit Price", "Quantity", "Price", "Date"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                sql = "select * from dbo.vw_sales_data where invoice_id = ?"; 
                PreparedStatement s = DBUtil.getConnection().prepareStatement(sql);
                s.setString(1, invoice_id);
                ResultSet result = s.executeQuery();
                while(result.next()) {
                    Object[] row = {
                        result.getInt("invoice_id"),
                        result.getString("customer_name"),
                        result.getInt("customer_id"),
                        result.getString("product_name"),
                        result.getString("barcode"),
                        result.getDouble("sell_price"),
                        result.getDouble("quantity"),
                        result.getDouble("price"),
                        result.getString("date")
                    };
                    model.addRow(row);
                }
                jTable1.setModel(model);
            } else if (!date.isEmpty()) {
                String[] columnNames = {"Invoice Id", "Customer Name", "Customer Id", "Product Name", "Bar Code", "Unit Price", "Quantity", "Price", "Date"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(jDateChooser.getDate());
                calendar.add(Calendar.DATE, 1);
                String nextDate = sdf.format(calendar.getTime());
                sql = "select * from dbo.vw_sales_data where date >= ? and date < ?"; 
                PreparedStatement s = DBUtil.getConnection().prepareStatement(sql);
                s.setString(1, date);
                s.setString(2, nextDate);
                ResultSet result = s.executeQuery();
                while(result.next()) {
                    Object[] row = {
                        result.getInt("invoice_id"),
                        result.getString("customer_name"),
                        result.getInt("customer_id"),
                        result.getString("product_name"),
                        result.getString("barcode"),
                        result.getDouble("sell_price"),
                        result.getDouble("quantity"),
                        result.getDouble("price"),
                        result.getString("date")
                    };
                    model.addRow(row);
                }
                jTable1.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "No Search Parameters!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e) {
            System.out.println("Error in finding user " + e);
        }
    }//GEN-LAST:event_i_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton i_search;
    private javax.swing.JTextField inid;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
