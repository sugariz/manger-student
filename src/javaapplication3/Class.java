/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.util.Collections;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/**
 *
 * @author azu
 */
public class Class extends javax.swing.JFrame {
    
    public Class() throws Exception {
        this.build();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void build() throws Exception {
        setTitle("Quản lý học sinh");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(new java.awt.Color(255,255,255));
        setPreferredSize(new java.awt.Dimension(1200, 600));
        getContentPane().setLayout(new BorderLayout());
        
//        panelMain = new JPanel();
        panelMenu = new JPanel(new BorderLayout());
        panelBody = new JPanel(new BorderLayout());
        
        panelBody.setBackground(new Color(255, 255, 100));
        panelBody.setPreferredSize(new Dimension(950, 600));
        panelMenu.setBackground(new Color(7, 121, 228));
        panelMenu.setPreferredSize(new Dimension(250, 600));
        
        getContentPane().add(panelBody, BorderLayout.CENTER);
        getContentPane().add(panelMenu, BorderLayout.WEST);
        
        this.leftPanel();
        this.centerPanel();
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    private void leftPanel() {
        panelItemTop     = new JPanel();
        panelItemMid     = new JPanel(new GridLayout(4, 0));
        panelItemBottom  = new JPanel();
        
        panelItemTop.setLayout(new BoxLayout(panelItemTop, BoxLayout.PAGE_AXIS));
        
        panelItemHome     = new JPanel(new GridLayout());
        panelItemSchedule = new JPanel(new GridLayout());
        panelItemScore    = new JPanel(new GridLayout());
        panelItemAbout    = new JPanel(new GridLayout());
        
        panelItemTop.setBackground(new Color(7, 121, 200));
        panelItemTop.setPreferredSize(new Dimension(250, 150));
        panelItemMid.setBackground(new Color(7, 121, 150));
        panelItemMid.setPreferredSize(new Dimension(250, 50));
        panelItemBottom.setBackground(new Color(7, 121, 100));
        panelItemBottom.setPreferredSize(new Dimension(250, 150));
        
        panelItemHome.setBackground(new Color(16, 137, 255));
        panelItemHome.setPreferredSize(new Dimension(250, 50));
        panelItemHome.setBorder(new javax.swing.border.EmptyBorder(0, 10, 0, 0));
        panelItemSchedule.setBackground(new Color(16, 137, 200));
        panelItemSchedule.setPreferredSize(new Dimension(250, 50));
        panelItemSchedule.setBorder(new javax.swing.border.EmptyBorder(0, 10, 0, 0));
        panelItemScore.setBackground(new Color(16, 137, 150));
        panelItemScore.setPreferredSize(new Dimension(250, 50));
        panelItemScore.setBorder(new javax.swing.border.EmptyBorder(0, 10, 0, 0));
        panelItemAbout.setBackground(new Color(16, 137, 100));
        panelItemAbout.setPreferredSize(new Dimension(250, 50));
        panelItemAbout.setBorder(new javax.swing.border.EmptyBorder(0, 10, 0, 0));
        
        panelMenu.add(panelItemTop, BorderLayout.NORTH);
        panelMenu.add(panelItemMid, BorderLayout.CENTER);
        panelMenu.add(panelItemBottom, BorderLayout.SOUTH);
        
        panelItemMid.add(panelItemHome);
        panelItemMid.add(panelItemSchedule);
        panelItemMid.add(panelItemScore);
        panelItemMid.add(panelItemAbout);
        
        this.createItemMid("Trang chủ", panelItemHome);
        this.createItemMid("Thời khóa biểu", panelItemSchedule);
        this.createItemMid("Điểm", panelItemScore);
        this.createItemMid("Thông tin", panelItemAbout);
        this.createItemTop();
//        panelItemHome.action
    }
    
    private void centerPanel() throws Exception {
        panelBodyHead = new JPanel();
        panelBodyBody = new JPanel(new GridLayout(1, 0));
        panelBodyBody.setBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0));
        
        panelBodyHead.setBackground(new Color(220, 214, 247));
        panelBodyHead.setPreferredSize(new Dimension(950, 150));
        
        panelBodyBody.setBackground(new Color(220, 214, 200));
        panelBodyBody.setPreferredSize(new Dimension(950, 450));
        
        panelBody.add(panelBodyHead, BorderLayout.NORTH);
        panelBody.add(panelBodyBody, BorderLayout.CENTER);
        
//        this.createTable();
    }
    
    private void createTable() throws Exception {
        
        String[] columns = {"Mã học sinh", "Họ", "Tên", "Ngày sinh", "Địa chỉ", "Giới tính", "Email", "Số điện thoại"};
        
//        Vector<Object> rowData = new database().getQuery(columns);
        Vector<String> headers = new Vector<String>();
        Collections.addAll(headers, columns);
        
        tableData = new JTable();
        tableData.setPreferredSize(new Dimension(950, 450));
        tableData.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 12));
        tableData.getTableHeader().setOpaque(false);
        tableData.getTableHeader().setBackground(new Color(32, 136, 203));
        tableData.getTableHeader().setForeground(new Color(255, 255, 255));
        tableData.getTableHeader().setReorderingAllowed(false);
        tableData.setRowHeight(25);
        tableData.setIntercellSpacing(new Dimension(0, 0));
        tableData.setFocusable(false);
        tableData.setShowVerticalLines(false);
        
        JScrollPane scrollPanel = new JScrollPane(tableData);
        scrollPanel.setPreferredSize(new Dimension(950, 450));
        scrollPanel.setBackground(new Color(255, 255, 255));
        
        panelBodyBody.add(scrollPanel);
    }
    
    private void createItemMid(String text, JPanel parentPanel) {
//        JLabel icon  = new JLabel("O");
        JLabel title = new JLabel(text);
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Verdana", 1, 20));
//        parentPanel.add(icon);
        parentPanel.add(title);
    }
    
    private void createItemTop() {
        JLabel labelTitle = new JLabel("===");
        labelTitle.setForeground(new Color(255, 255, 255));
        
        JLabel labelNotification = new JLabel("Xin chào bạn " + "Nguyễn Minh Trí");
        labelNotification.setForeground(new Color(255, 255, 255));
        labelNotification.setFont(new Font("Verdana", 1, 15));
        
        JLabel labelMASV = new JLabel("MASV: 3119410456");
        labelMASV.setForeground(new Color(255, 255, 255));
        labelMASV.setFont(new Font("Verdana", 1, 15));
        
        JLabel labelClass = new JLabel("Lớp: 12A4");
        labelClass.setForeground(new Color(255, 255, 255));
        labelClass.setFont(new Font("Verdana", 1, 15));
        
        JLabel labelPassWordChange = new JLabel("Thay đổi mật khẩu");
        labelPassWordChange.setForeground(new Color(255, 255, 255));
        labelPassWordChange.setFont(new Font("Verdana", 1, 15));
        
        JLabel labelLogout = new JLabel("Đăng xuất");
        labelLogout.setForeground(new Color(255, 255, 255));
        labelLogout.setFont(new Font("Verdana", 1, 15));
        
        panelItemTop.add(labelTitle);
        panelItemTop.add(Box.createRigidArea(new Dimension(0,20)));
        panelItemTop.add(labelNotification);
        panelItemTop.add(Box.createRigidArea(new Dimension(0,5)));
        panelItemTop.add(labelMASV);
        panelItemTop.add(Box.createRigidArea(new Dimension(0,5)));
        panelItemTop.add(labelClass);
        panelItemTop.add(Box.createRigidArea(new Dimension(0,5)));
        panelItemTop.add(labelPassWordChange);
        panelItemTop.add(Box.createRigidArea(new Dimension(0,5)));
        panelItemTop.add(labelLogout);
        
    }
    
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelItemHome;
    private javax.swing.JPanel panelItemSchedule;
    private javax.swing.JPanel panelItemScore;
    private javax.swing.JPanel panelItemAbout;
    private javax.swing.JPanel panelItemTop;
    private javax.swing.JPanel panelItemMid;
    private javax.swing.JPanel panelItemBottom;
    private javax.swing.JPanel panelBodyHead;
    private javax.swing.JPanel panelBodyBody;
    private javax.swing.JTable tableData;
}
