/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author andi
 */
public class ButtonTabComponent extends JPanel{
    public  final JTabbedPane pane;
    public ButtonTabComponent( final JTabbedPane pane){
       
        super(new FlowLayout(FlowLayout.LEFT,0,0));
        
        if(pane==null){
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane=pane;
        setOpaque(false);
        //make JLabel read titles from JTabbedPane
        JLabel label=new JLabel(){
        @Override
        public String getText(){
            int i=pane.indexOfTabComponent(ButtonTabComponent.this);
            if(i!=-1){
                return pane.getTitleAt(i);
            }
            return null;
        }
    };
     add(label);
     //add more space between label and button
     label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
     JButton button=new TabButton();
     add(button);
     //add more space to the top of the component
     setBorder(BorderFactory.createEmptyBorder(2,0,0,0));
    }
    class TabButton extends JButton implements ActionListener{
    public TabButton(){
        int size=17;
        setPreferredSize(new Dimension(size,size));
        setToolTipText("Close this tab");
        //make the button looks the same for all plafs
        setUI(new BasicButtonUI());
        //make it transparent
        setContentAreaFilled(false);
        //no need to be focuseable
        setFocusable(false);
        setBorder(BorderFactory.createEtchedBorder());
        setBorderPainted(false);
        //making nice rollover effect
        //we use the same listener for all buttons
        addMouseListener(buttonMouseListener);
        setRolloverEnabled(true);
        //close the proper tab by clicking the button
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Component i=pane.getSelectedComponent();
        if(i!=null){
            pane.remove(i);
        }
    }
    //we dont want to update UI for this button
    @Override
    public void updateUI(){
        
    }
    //paint the cross
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g.create();
        //shift the image for pressed buttons 
        if(getModel().isPressed()){
            g2.translate(1, 1);
        }
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        if(getModel().isRollover()){
            g2.setColor(Color.RED);
        }
        int delta=6;
        g2.drawLine(delta,delta,getWidth()-delta-1,getHeight()-delta-1);
        g2.drawLine(getWidth()-delta-1, delta, delta, getHeight()-delta-1);
        g2.dispose();
    }
}
    private final static MouseListener buttonMouseListener=new MouseAdapter(){
        @Override
        public void mouseEntered(MouseEvent e){
            Component component=e.getComponent();
            if(component instanceof AbstractButton){
                AbstractButton button= (AbstractButton)component;
                button.setBorderPainted(true);
            }
        }
        @Override
        public void mouseExited(MouseEvent e){
            Component component=e.getComponent();
            if(component instanceof AbstractButton){
                AbstractButton button=(AbstractButton)component;
                button.setBorderPainted(false);
            }
        }
    };
  
}
