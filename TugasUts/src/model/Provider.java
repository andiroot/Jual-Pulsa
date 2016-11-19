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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author andi
 */
public class Provider {
    String namaProvider,namaKartu,kodeProvider,kodeKartu;
    String data;
    String namaProviderKartu;
    Object[][]list;
    Koneksi koneksi=new Koneksi();
    public static ResultSet rs;

    public Object[][] getList() {
        return list;
    }

    public void setList(Object[][] list) {
        this.list = list;
    }
    
    
    
    public String getNamaProviderKartu() {
        return namaProviderKartu;
    }

    public void setNamaProviderKartu(String namaProviderKartu) {
        this.namaProviderKartu = namaProviderKartu;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
            
    public String getNamaProvider() {
        return namaProvider;
    }

    public void setNamaProvider(String namaProvider) {
        this.namaProvider = namaProvider;
    }

    public String getNamaKartu() {
        return namaKartu;
    }

    public void setNamaKartu(String namaKartu) {
        this.namaKartu = namaKartu;
    }

    public String getKodeProvider() {
        return kodeProvider;
    }

    public void setKodeProvider(String kodeProvider) {
        this.kodeProvider = kodeProvider;
    }

    public String getKodeKartu() {
        return kodeKartu;
    }

    public void setKodeKartu(String kodeKartu) {
        this.kodeKartu = kodeKartu;
    }
    
    
    public boolean simpanProvider(){
        boolean adaKesalahan=false;
        Connection connection=null;
        if((connection=koneksi.getConnection())!=null){
        PreparedStatement pst;
            boolean simpan=false;
            String query="insert into data_provider values(?,?) ";
            int jumlahSimpan=0;
            try {
                pst=connection.prepareStatement(query);
                pst.setString(1,kodeProvider);
                pst.setString(2,namaProvider);
                jumlahSimpan=pst.executeUpdate();
                pst.close();
                connection.close();
                simpan=true;
                if(jumlahSimpan<1){
                    JOptionPane.showMessageDialog(null,"error");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Provider.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
        return !adaKesalahan;
    }
    public boolean simpanKartu(){
        boolean adaKesalahan=false;
        Connection connection;
        if((connection=koneksi.getConnection())!=null){
            PreparedStatement pst;
            boolean simpan=false;
            String query="insert into data_kartu values(?,?,?)";
            int jumlahSimpan=0;
            try {
                pst=connection.prepareStatement(query);
                pst.setString(1, kodeKartu);
                pst.setString(2,namaKartu);
                pst.setString(3,namaProviderKartu);
                jumlahSimpan=pst.executeUpdate();
                pst.close();
                connection.close();
                if(jumlahSimpan<1){
                    JOptionPane.showMessageDialog(null,"error");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Provider.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return !adaKesalahan;
    }
    public boolean bacaData(){
        boolean adaKesalahan=false;
        
        return !adaKesalahan;
    }
    
}
