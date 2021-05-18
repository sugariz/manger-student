/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.Dimension;
import javax.swing.border.*;
import java.awt.Font;

/**
 *
 * @author azu
 */
public class FRMLOGIN extends JPanel {
    
    private Dimension sizeOriganal = new Dimension(950, 600);
    private JPanel panelLogin;
    private JPanel panelEntry;
    private JPanel panelForgotPass;
    private JLabel labelTitle;
    private PlaceholderTextField textFieldUsername;
    private PlaceholderTextField textFieldPassword;
    private JButton buttonLogin;
    private JLabel labelForgotPassword;
    
    public FRMLOGIN() {
        this.build();
    }
    
    private void build() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setPreferredSize(sizeOriganal);
        
        panelLogin = new JPanel();
        panelEntry = new JPanel();
        panelForgotPass = new JPanel();
        labelTitle = new JLabel("Đăng nhập");
        textFieldUsername = new PlaceholderTextField("");
        textFieldPassword = new PlaceholderTextField("");
        buttonLogin = new JButton("Đăng nhập");
        labelForgotPassword = new JLabel("Quên mật khẩu?");
        
        this.configInput(textFieldUsername);
        this.configInput(textFieldPassword);
        this.configButton(buttonLogin);
        
        panelLogin.add(labelTitle);
        panelEntry.add(textFieldUsername);
        panelEntry.add(textFieldPassword);
        panelEntry.add(buttonLogin);
        panelForgotPass.add(labelForgotPassword);
        
        this.add(panelLogin, BorderLayout.NORTH);
        this.add(panelEntry, BorderLayout.CENTER);
        this.add(panelForgotPass, BorderLayout.SOUTH);
    }
    
//    @Override
    public void configInput(PlaceholderTextField myTextField) {
        AbstractBorder borderradius = new BORDERRADIUS(new Color(205, 210, 215), 1, 16, 0);
        myTextField.setPreferredSize(new Dimension(250, 50));
        myTextField.setFont(new Font("DENSE", 1, 16));
        myTextField.setBorder(borderradius);
        myTextField.setPlaceholder("Nhập tài khoản");
    }
    
    public void configButton(JButton myButton) {
        AbstractBorder borderradius = new BORDERRADIUS(new Color(205, 210, 215), 1, 16, 0);
        myButton.setPreferredSize(new Dimension(250, 50));
        myButton.setFont(new Font("DENSE", 1, 16));
        myButton.setBorder(borderradius);
        myButton.setBackground(Color.WHITE);
    }

}
