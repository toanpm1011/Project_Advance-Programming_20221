/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import entities.Product;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import form.Store;
import static gaminggearstore_final.Database.getConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Admin
 */
public class Statistics extends javax.swing.JFrame {

    /**
     * Creates new form Statistics
     */
    public Statistics() {
        initComponents();
        CreateChart1();
    }
    public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "THỐNG KÊ SỐ LƯỢNG HÀNG HÓA",
                "LOẠI SẢN PHẨM", "SỐ LƯỢNG",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }
     public static int get_keyboard_number()
     {  
        int number=0;
        ArrayList<Product> product_list = product_list();
        for (Product p : product_list)
        {
            if (p.getType().equals("Keyboard"))
            {
               number++;
            }
        }
        return number;
     }
     public static int get_mouse_number()
     {  
         int number=0;
         ArrayList<Product> product_list = product_list();
         for (Product p : product_list)
         {
             if (p.getType().equals("Mouse"))
             {
                number++;
             }
         }
         return number;
     }
     public static int get_headphone_number()
     {  
         int number=0;
         ArrayList<Product> product_list = product_list();
         for (Product p : product_list)
         {
             if (p.getType().equals("Headphone"))
             {
                number++;
             }
         }
         return number;
     }
     public static ArrayList<Product> product_list()
    {
        ArrayList<Product> product_list = new ArrayList<Product>();
        Connection con = getConnection("jdbc:mysql://localhost:3306/gearstore", "root", "deadpool2k1");
        String query = "Select * from product ";
        Statement st;   
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            while(rs.next())
            {
                product = new Product(rs.getInt("idproduct"),rs.getString("brand"), rs.getString("name"), rs.getDouble("price"),
                        rs.getString("type"),rs.getString("thumbnail"));
                product_list.add(product);
            }
        } catch (Exception e) {
        }
        return product_list;
    }

    private static CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(get_keyboard_number(), "Số người", "Keyboard");
        dataset.addValue(get_mouse_number(), "Số người", "Mouse");
        dataset.addValue(get_headphone_number(), "Số người", "Headphone");
        return dataset;
    }

    public static void CreateChart1() {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Thống kê kho hàng");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thống kê sản phẩm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistics().setVisible(false);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}