/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author andi
 */
public class Transaksi {
   private int bayar,kembalian,total;
   private String terbilangBayar,terbilangTotal;
    Koneksi koneksi= new Koneksi();
    String pesan;
    
    public boolean simpan(){
       boolean adaKesalahan=false;
       Connection connection;
       boolean simpan;
               PreparedStatement pst;
               simpan=false;
        if((connection=koneksi.getConnection())!=null){
            
            
            String query="insert into pembayaran(bayar,total,kembalian) values(?,?,?)";
           try {
               int jumlahSimpan;
               
           
               pst=connection.prepareStatement(query);
               pst.setInt(1, bayar);
               pst.setInt(2, total);
               pst.setInt(3, kembalian);
               jumlahSimpan=pst.executeUpdate();
               
               pst.close();
               connection.close();
               simpan=true;
               if(simpan){
                   if(jumlahSimpan<1){
                       JOptionPane.showMessageDialog(null,"model error");
                   }
               }
           } catch (SQLException ex) {
               Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
               pesan="error : model";
               
           }
           
        }
        else{
            JOptionPane.showMessageDialog(null,"error model");
        }
        return !adaKesalahan;
    }
}
