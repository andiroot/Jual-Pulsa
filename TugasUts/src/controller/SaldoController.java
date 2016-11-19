/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Saldo;
import view.FormSaldo;
import view.MainForm;

/**
 *
 * @author andi
 */
public class SaldoController {
    Saldo saldo=new Saldo();
    FormSaldo formSaldo;
    public void simpan(JComboBox comboBoxProvider,JTextField fieldSaldo){
        if(!fieldSaldo.getText().equals("")){
            saldo.setInputSaldo(Integer.parseInt(fieldSaldo.getText()));
            saldo.setProvider(comboBoxProvider.getSelectedItem().toString());
            
            if(saldo.simpan()){
                MainForm.saldo.setSaldoField("");
            }
            else{
                JOptionPane.showMessageDialog(null,"error ga nyimpen");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"controller error");
        }
        JOptionPane.showMessageDialog(null,comboBoxProvider.getSelectedItem().toString());
    }
    
    public void setComboBox(){
        //harus ada nilai comboboxnya dulu. 
        //jadi harus select from provider, model.Providernya belom jadi masalahnya
    }
}
