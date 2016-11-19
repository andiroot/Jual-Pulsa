/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Provider;
import view.FormProvider;
import view.MainForm;

/**
 *
 * @author andi
 */
public class ProviderController {
    FormProvider formProvider;
    Provider provider=new Provider();
    public void simpanProvider(JTextField kodeProvider,JTextField namaProvider){
        if(!(kodeProvider.getText().equals("")&&namaProvider.getText().equals(""))){
            provider.setKodeProvider(kodeProvider.getText());
            provider.setNamaProvider(kodeProvider.getText());
            if(provider.simpanProvider()){
                MainForm.provider.setNamaProvider("");
                MainForm.provider.setKodeProvider("");
                JOptionPane.showMessageDialog(null,"sukses");
                
            }
            else{
                JOptionPane.showMessageDialog(null,"gagal menyimpan");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"isi field dahulu");
        }
    }
    public void simpanKartu(JTextField kodeKartu,JTextField namaKartu,JComboBox comboBox){
        if(!(kodeKartu.getText().equals("")&&namaKartu.getText().equals(""))){
            provider.setKodeKartu(kodeKartu.getText());
            provider.setNamaKartu(namaKartu.getText());
            provider.setNamaProviderKartu(comboBox.getSelectedItem().toString());
            if(provider.simpanKartu()){
                MainForm.provider.setNamaKartu("");
                MainForm.provider.setKodeKartu("");
                MainForm.provider.setNamaProvider("");
                JOptionPane.showMessageDialog(null,"sukses");
            }
            else{
                JOptionPane.showMessageDialog(null,"gagal menyimpan");
            }
            
        }
        else{
           JOptionPane.showMessageDialog(null,"isi field dahulu");
        }
    }
    public void bacaData(){
        if(provider.bacaData()){
            
        }
    }
     
}

   
