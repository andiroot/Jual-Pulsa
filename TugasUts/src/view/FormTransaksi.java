/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Koneksi;
import model.Provider;
import static model.Provider.rs;

/**
 *
 * @author andi
 */
public class FormTransaksi extends javax.swing.JPanel {
    Koneksi koneksi=new Koneksi();
    String data;
    
    /**
     * Creates new form FormPembayaran
     */
    public FormTransaksi() {
        initComponents();
        setComboBoxProvider();
        setComboBoxKartu();
        setComboBoxNominal();
        tampilkanData();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Harga = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxProvider = new javax.swing.JComboBox();
        comboBoxKartu = new javax.swing.JComboBox();
        hargaTextField = new javax.swing.JTextField();
        nomorTextField = new javax.swing.JTextField();
        prosesButton = new javax.swing.JButton();
        comboBoxNominal = new javax.swing.JComboBox();
        bayarTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaksi"));

        jLabel1.setText("Provider");

        jLabel2.setText("Kartu");

        jLabel4.setText("Nomor Telepon");

        Harga.setText("Harga");

        jLabel6.setText("Nominal");

        hargaTextField.setEditable(false);

        prosesButton.setText("Proses");
        prosesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesButtonActionPerformed(evt);
            }
        });

        comboBoxNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNominalActionPerformed(evt);
            }
        });

        jLabel3.setText("Bayar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel6)
                                .addComponent(jLabel2))
                            .addGap(56, 56, 56))
                        .addComponent(Harga, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(prosesButton))
                        .addGap(63, 63, 63)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomorTextField)
                    .addComponent(comboBoxKartu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxProvider, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hargaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(comboBoxNominal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bayarTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(Harga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboBoxKartu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(hargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(prosesButton)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bayarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tabelData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNominalActionPerformed
        // TODO add your handling code here:
        String nominal=comboBoxNominal.getSelectedItem().toString();
        int a=Integer.parseInt(nominal);
        int b=1000;
        int c=a+b;
        hargaTextField.setText(Integer.toString(c));
    }//GEN-LAST:event_comboBoxNominalActionPerformed

    private void prosesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesButtonActionPerformed
        // TODO add your handling code here:
        int i=JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null,"Konfirmasi");
        if(i==0){
            simpan();
            tampilkanData();
        }
        else{
            JOptionPane.showMessageDialog(null, "ga jadi");
        }
    }//GEN-LAST:event_prosesButtonActionPerformed

    public void setComboBoxProvider(){
        Connection connection;
        if((connection=koneksi.getConnection())!=null){
            String query="select nama_provider from data_provider";
            Statement st;
            
            
            try {
                st=connection.createStatement();
                rs=st.executeQuery(query);
                while(rs.next()){
                    data=rs.getString("nama_provider");
                    comboBoxProvider.addItem(data);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Provider.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else{
            JOptionPane.showMessageDialog(null,"error");
        }
    }
    public void setComboBoxKartu(){
        Connection connection;
        if((connection=koneksi.getConnection())!=null){
            String query="select nama_kartu from data_kartu";
            
            try {
                Statement st;
                st=connection.createStatement();
                rs=st.executeQuery(query);
                while(rs.next()){
                    data=rs.getString("nama_kartu");
                    comboBoxKartu.addItem(data);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Provider.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else{
            JOptionPane.showMessageDialog(null,"error");
        }
    }
    public void setComboBoxNominal(){
        Connection connection;
        if((connection=koneksi.getConnection())!=null){
            String query="select nominal_pulsa from data_pulsa";
            Statement st;
            
            
            try {
                st=connection.createStatement();
                rs=st.executeQuery(query);
                while(rs.next()){
                    data=rs.getString("nominal_pulsa");
                    comboBoxNominal.addItem(data);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Provider.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else{
            JOptionPane.showMessageDialog(null,"error");
        }
    }
    public void simpan(){
        int kembalian=Integer.parseInt(bayarTextField.getText())-Integer.parseInt(hargaTextField.getText());
        
        Connection connection=null;
        PreparedStatement pst=null;
        if((connection=koneksi.getConnection())!=null){
            String query="insert into transaksi "
                    + "values(?,?,?,?,?,?,?)";
            try {
                pst=connection.prepareStatement(query);
                pst.setInt(1,Integer.parseInt(comboBoxNominal.getSelectedItem().toString()));
                pst.setInt(2, Integer.parseInt(hargaTextField.getText()));
                pst.setString(3, nomorTextField.getText());
                pst.setString(4,comboBoxKartu.getSelectedItem().toString());
                pst.setString(5, comboBoxProvider.getSelectedItem().toString());
                pst.setInt(6, Integer.parseInt(bayarTextField.getText()));
                pst.setInt(7,kembalian);
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(FormTransaksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void tampilkanData(){
        DefaultTableModel tblModel=tblModel();
        tabelData.setModel(tblModel);
        Connection connection;
        if((connection=koneksi.getConnection())!=null){
            PreparedStatement pst;
            ResultSet rset;
            
            String query="select * from transaksi";
            try {
                pst = connection.prepareStatement(query);
                rset=pst.executeQuery();
                while(rset.next()){
                if(rset.getRow()>0){
                    Object []datatbl=new Object[7];
                    datatbl[0]=rset.getString("nama_provider");
                    datatbl[1]=rset.getString("nama_kartu");
                    datatbl[2]=rset.getString("nomor_telepon");
                    datatbl[3]=rset.getString("nominal_pulsa");
                    datatbl[4]=rset.getString("harga");
                    datatbl[5]=rset.getString("bayar");
                    datatbl[6]=rset.getString("Kembalian");
                    
                    tblModel.addRow(datatbl);
                }
                }
                pst.close();
                rset.close();
                connection.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Provider.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public DefaultTableModel tblModel(){
        String kolom[]={ "Nama Provider","Nama Kartu","Nomor ","Nominal","Harga","Bayar","Kembalian"};
         DefaultTableModel dtm = new DefaultTableModel(null, kolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
         return dtm;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Harga;
    private javax.swing.JTextField bayarTextField;
    private javax.swing.JComboBox comboBoxKartu;
    private javax.swing.JComboBox comboBoxNominal;
    private javax.swing.JComboBox comboBoxProvider;
    private javax.swing.JTextField hargaTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomorTextField;
    private javax.swing.JButton prosesButton;
    private javax.swing.JTable tabelData;
    // End of variables declaration//GEN-END:variables
}
