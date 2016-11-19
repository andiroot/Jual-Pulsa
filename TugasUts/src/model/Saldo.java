/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author andi
 */
public class Saldo {
    int sisaSaldo,inputSaldo;
    String provider;
    Koneksi koneksi=new Koneksi();

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
    
    public int getSisaSaldo() {
        return sisaSaldo;
    }

    public void setSisaSaldo(int sisaSaldo) {
        this.sisaSaldo = sisaSaldo;
    }

    public int getInputSaldo() {
        return inputSaldo;
    }

    public void setInputSaldo(int inputSaldo) {
        this.inputSaldo = inputSaldo;
    }
    
    public boolean simpan(){
        boolean adaKesalahan=false;
        Connection connection=null;
        PreparedStatement pst=null;
        boolean simpan=false;
        if((connection=koneksi.getConnection())!=null){
            String query="update saldo set sisa_saldo=sisa_saldo+? where jenis_provider=?";
            int jumlahSimpan;
            try {
                pst=connection.prepareStatement(query);
                
                pst.setInt(1,inputSaldo);
                pst.setString(2,provider);
                jumlahSimpan=pst.executeUpdate();
                simpan=true;
                
                if(jumlahSimpan<1){
                    JOptionPane.showMessageDialog(null,"error saldo : "+jumlahSimpan);
                }
                else{
                    JOptionPane.showMessageDialog(null,"sukses");
                }
                pst.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Saldo.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Error saldo 2");
        }
        return !adaKesalahan;
    }
    public boolean tampil(){
        boolean adaKesalahan=true;
        Connection connection;
        this.sisaSaldo=0;
        if((connection=koneksi.getConnection())!=null){
            ResultSet rs;
            PreparedStatement pst;
            String query="select * from saldo";
            try {
                pst=connection.prepareStatement(query);
                rs=pst.executeQuery();
                if(rs.next()){
                    this.sisaSaldo=rs.getInt("sisa_saldo");
                    this.provider=rs.getString("jenis_provider");
                }
                else{
                    adaKesalahan=true;
                    
                }
                pst.close();
                
                rs.close();
                connection.close();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Saldo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"model gaggal");
        }
        return !adaKesalahan;
    }
    
}
