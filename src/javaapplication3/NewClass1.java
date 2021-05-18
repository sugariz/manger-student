/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Vector;
import javaapplication3.GUI.FRMLOGIN;
import javaapplication3.GUI.inputScoreGUI;
import javax.swing.border.EmptyBorder;
import javaapplication3.GUI.scoreGUI;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author azu
 */
public class NewClass1 extends JFrame {
    
    public NewClass1() throws Exception {
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
        
        panelBody = new JPanel(new CardLayout());
        panelMenu = new JPanel(new BorderLayout());
        panelTopMenu = new JPanel(new BorderLayout());
        panelIconMenu = new JPanel();
        panelTitleMenu = new JPanel();
        
        panelIconMenu.setLayout(new BoxLayout(panelIconMenu, BoxLayout.PAGE_AXIS));
        panelTitleMenu.setLayout(new BoxLayout(panelTitleMenu, BoxLayout.PAGE_AXIS));
        
        this.configPanel(panelBody, Color.WHITE, sizeBodySmall);
        this.configPanel(panelMenu, new Color(7, 121, 228), new Dimension(250, 600));
        this.configPanel(panelTopMenu, colorMenu, new Dimension(250, 60));
        this.configPanel(panelIconMenu, colorMenu, new Dimension(60, 540));
        this.configPanel(panelTitleMenu, colorMenu, new Dimension(190, 600));
        
        panelTopMenu.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(26, 26, 26)));
        
        panelMenu.add(panelTopMenu, BorderLayout.NORTH);
        panelMenu.add(panelIconMenu, BorderLayout.WEST);
        panelMenu.add(panelTitleMenu, BorderLayout.CENTER);
        
        getContentPane().add(panelBody, BorderLayout.CENTER);
        getContentPane().add(panelMenu, BorderLayout.WEST);
        
        this.buildIconMenu();
        this.buildTitleMenu();
        this.buildBodyLayout();
        this.createAvatarUser();
    }
    
    private void createAvatarUser() throws Exception {
        JPanel panelAvatar = new JPanel(new BorderLayout());
        JPanel panelInfo = new JPanel();
        
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.PAGE_AXIS));
        
        JLabel labelMyAvatar = new JLabel(this.createAvatar());
        JLabel labelMyName = new JLabel(this.nameStudent);
        JLabel labelMyMAHS = new JLabel(this.MAHS);
        
        labelMyName.setForeground(Color.WHITE);
        labelMyMAHS.setForeground(colorLine);
        
        panelAvatar.setBackground(colorMenu);
        panelAvatar.setPreferredSize(new Dimension(60, 60));
        panelAvatar.setMaximumSize(panelTitleShowHide.getPreferredSize());
        panelInfo.setBackground(colorMenu);
        panelInfo.setPreferredSize(new Dimension(540, 60));
        panelInfo.setMaximumSize(panelTitleShowHide.getPreferredSize());
        panelInfo.setBorder(new javax.swing.border.EmptyBorder(0, 10, 0, 0));
        
        panelAvatar.add(labelMyAvatar, BorderLayout.CENTER);
        panelInfo.add(Box.createRigidArea(new Dimension(10, 10)));
        panelInfo.add(labelMyName);
        panelInfo.add(Box.createRigidArea(new Dimension(10, 10)));
        panelInfo.add(labelMyMAHS);
        
        panelTopMenu.add(panelAvatar, BorderLayout.WEST);
        panelTopMenu.add(panelInfo, BorderLayout.CENTER);
        
    }
    
    private ImageIcon createAvatar() throws Exception {
        BufferedImage master = ImageIO.read(new File("/home/azu/Downloads/164691192_487744059246011_2793785905854363508_n(1)(1).jpg"));

        int diameter = Math.min(master.getWidth(), master.getHeight());
        BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = mask.createGraphics();
        applyQualityRenderingHints(g2d);
        g2d.fillOval(0, 0, diameter - 1, diameter - 1);
        g2d.dispose();

        BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = masked.createGraphics();
        applyQualityRenderingHints(g2d);
        int x = (diameter - master.getWidth()) / 2;
        int y = (diameter - master.getHeight()) / 2;
        g2d.drawImage(master, x, y, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2d.drawImage(mask, 0, 0, null);
        g2d.dispose();

        return new ImageIcon(masked);
    }
    
    private static void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }
    
    javax.swing.JPanel homeLayout = new JPanel(new BorderLayout());
    javax.swing.JPanel scheduleLayout = new JPanel();
    javax.swing.JPanel scoreLayout = new JPanel();
    javax.swing.JPanel aboutLayout = new JPanel();
    
//    JPanel panelHomeHead = new JPanel();
    JPanel panelScoreBody = new JPanel(new BorderLayout());
    
    private void buildBodyLayout() throws Exception {
        this.configPanel(homeLayout, Color.WHITE, sizeBodySmall);
        this.configPanel(scheduleLayout, Color.WHITE, sizeBodySmall);
        this.configPanel(scoreLayout, Color.WHITE, sizeBodySmall);
        this.configPanel(aboutLayout, Color.WHITE, sizeBodySmall);

        new scoreGUI(scheduleLayout, this.MAHS);
        
        this.createDataEntryScore(scoreLayout);
//        this.createBTVN(aboutLayout);
        homeLayout.add(new FRMLOGIN());
        scoreLayout.setLayout(new BoxLayout(scoreLayout, BoxLayout.PAGE_AXIS));
        scheduleLayout.setLayout(new BoxLayout(scheduleLayout, BoxLayout.PAGE_AXIS));
        
        panelBody.add(homeLayout, "Home");
        panelBody.add(scheduleLayout, "Schedule");
        panelBody.add(scoreLayout, "Score");
        panelBody.add(aboutLayout, "About");
        
        this.cardLayout = (CardLayout)(panelBody.getLayout());
    }
    
    private void createBTVN(JPanel myPanel) throws Exception {
        String[] columns = {"MAHS", "Họ", "Tên", "Ngày sinh", "Địa chỉ", "Giới tính", "Email", "Số điện thoại"};
        Vector<Vector<String>> data = new database().getQuery(columns);
        JTable myTable = new JTable(data, new Vector<String>(java.util.Arrays.asList(columns)));
        JScrollPane myScroll = new JScrollPane(myTable);
        JPanel panel = new JPanel();
        this.configPanel(panel, Color.WHITE, new Dimension(950, 300));
        this.editTable(panel, myTable);
        myPanel.add(panel);
        myPanel.add(myScroll);
    }
    
    
    JTextField txMAHS = new JTextField(10);
    JTextField txHo = new JTextField(10);
    JTextField txTen = new JTextField(10);
    JTextField txDOB = new JTextField(10);
    JTextField txDiaChi = new JTextField(10);
    JTextField txGioiTinh = new JTextField(10);
    JTextField txEmail = new JTextField(10);
    JTextField txSoDienThoai = new JTextField(10);
        
    
    private void editTable(JPanel myPanel, JTable myTable) throws Exception {
        JLabel labelMAHS = new JLabel("Mã HS: ");
        JLabel labelHo = new JLabel("Họ: ");
        JLabel labelTen = new JLabel("Tên: ");
        JLabel labelDOB = new JLabel("Ngày sinh: ");
        JLabel labelDiaChi = new JLabel("Địa chỉ: ");
        JLabel labelGioiTinh = new JLabel("Giới tính: ");
        JLabel labelEmail = new JLabel("Email: ");
        JLabel labelSoDienThoai = new JLabel("Số điện thoại: ");
       
        JButton addRecord = new JButton("Thêm");
        JButton updateRecord = new JButton("Sửa");
        JButton removeRecord = new JButton("Xóa");
        
        myPanel.add(labelMAHS);
        myPanel.add(txMAHS);
        myPanel.add(labelHo);
        myPanel.add(txHo);
        myPanel.add(labelTen);
        myPanel.add(txTen);
        myPanel.add(labelDOB);
        myPanel.add(txDOB);
        myPanel.add(labelDiaChi);
        myPanel.add(txDiaChi);
        myPanel.add(labelGioiTinh);
        myPanel.add(txGioiTinh);
        myPanel.add(labelEmail);
        myPanel.add(txEmail);
        myPanel.add(labelSoDienThoai);
        myPanel.add(txSoDienThoai);
        myPanel.add(addRecord);
        myPanel.add(updateRecord);
        myPanel.add(removeRecord);
        
        addRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addnewRecord(evt, myTable);
                }
                catch(Exception e) {
                    System.err.println(e);
                }
            }
        });
        
        updateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    editRecord(evt, myTable);
                }
                catch(Exception e) {
                    
                }
            }
        });
        removeRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnDeleteActionPerformed(evt, myTable);
                }
                catch(Exception e) {
                    System.err.println(e);
                }
            }
        });
    }
    
    private void addnewRecord(java.awt.event.ActionEvent evt, JTable dgv) throws Exception {
        javax.swing.table.DefaultTableModel model =(javax.swing.table.DefaultTableModel) dgv.getModel();
        model.addRow(new Object[]{txMAHS.getText(), 
        txHo.getText(), txTen.getText(), txDOB.getText(), txDiaChi.getText(),txGioiTinh.getText(), txEmail.getText(), txSoDienThoai.getText()});
        String myString = String.format("('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
                txHo.getText(), txTen.getText(), txDOB.getText(), txDiaChi.getText(),txGioiTinh.getText(), txEmail.getText(), txSoDienThoai.getText(), txMAHS.getText());
        new database().addRowToDatabase(myString);
    }
    
    private void editRecord(java.awt.event.ActionEvent evt, JTable dgv) throws Exception {
        if (dgv.getSelectedRow()==-1) {
            if (dgv.getRowCount()==0) {
//                lblError.setText("Bảng trống!");
            }
            else{
//                lblError.setText("Bạn cần phải chọn một dòng");
            }
        }
        else{
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) dgv.getModel();
            model.setValueAt(txMAHS.getText(), dgv.getSelectedRow(), 0);
            model.setValueAt(txHo.getText(), dgv.getSelectedRow(), 1);
            model.setValueAt(txTen.getText(), dgv.getSelectedRow(), 2);
            model.setValueAt(txDOB.getText(), dgv.getSelectedRow(), 3);
            model.setValueAt(txDiaChi.getText(), dgv.getSelectedRow(), 4);
            model.setValueAt(txGioiTinh.getText(), dgv.getSelectedRow(), 5);
            model.setValueAt(txEmail.getText(), dgv.getSelectedRow(), 6);
            model.setValueAt(txSoDienThoai.getText(), dgv.getSelectedRow(), 7);
        }
    }
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt, JTable dgv) throws Exception {                                        
        // TODO add your handling code here:
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) dgv.getModel();
        if (dgv.getSelectedRow()==-1) {
            if (dgv.getRowCount()==0) {
//                lblError.setText("Bảng trống!");
            }
            else{
//                lblError.setText("Bạn cần phải chọn một dòng");
            }
        }
        else{
//            System.out.println();
            new database().deleteRowToDatabase((String)(dgv.getValueAt((int)dgv.getSelectedRow(), 0)));
            model.removeRow(dgv.getSelectedRow());
        }
    }
    
    javax.swing.JTable tableScoreOfClass;
    JScrollPane scrollPanelScoreOfClass;
    JPanel JPanelChooseClass;
    
    private void createDataEntryScore(JPanel myPanel) throws Exception {
        new inputScoreGUI(this.maGv, myPanel);
    }
    
    javax.swing.JTable tableDataScore;
    javax.swing.JTable tableDataDayOff;
    javax.swing.JTable tableDataSummary;
    JScrollPane scrollPanelScore;
    JScrollPane scrollPanelDayOff;
    JScrollPane scrollPanelSummary;
    JPanel JPanelChooseYear;
    JLabel schoolYear;
    
    private void setScrollPanel(JScrollPane myScrollPane, int height) {
        myScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        myScrollPane.setPreferredSize(new Dimension(950, height));
        myScrollPane.setBackground(new Color(255, 255, 255));
    }
    
    private void configPanel(JPanel myPanel, Color colorBackGround, Dimension size) {
        myPanel.setBackground(colorBackGround);
        myPanel.setPreferredSize(size);
    }

    private void buildTitleMenu() {
        javax.swing.JLabel labelTitleMenu = new JLabel("Ẩn");
        javax.swing.JLabel labelTitleHome = new JLabel("Trang chủ");
        javax.swing.JLabel labelTitleSchedule = new JLabel("Thời khóa biểu");
        javax.swing.JLabel labelTitleScore = new JLabel("Điểm");
        javax.swing.JLabel labelTitleAbout = new JLabel("Thông tin");
        
        panelTitleShowHide.setBackground(colorMenu);
        panelTitleShowHide.setPreferredSize(new Dimension(200, 50));
        panelTitleShowHide.setMaximumSize(panelTitleShowHide.getPreferredSize());
        panelTitleHome.setBackground(colorMenu);
        panelTitleHome.setPreferredSize(new Dimension(200, 50));
        panelTitleHome.setMaximumSize(panelTitleHome.getPreferredSize());
        panelTitleSchedule.setBackground(colorMenu);
        panelTitleSchedule.setPreferredSize(new Dimension(200, 50));
        panelTitleSchedule.setMaximumSize(panelTitleSchedule.getPreferredSize());
        panelTitleScore.setBackground(colorMenu);
        panelTitleScore.setPreferredSize(new Dimension(200, 50));
        panelTitleScore.setMaximumSize(panelTitleScore.getPreferredSize());
        panelTitleAbout.setBackground(colorMenu);
        panelTitleAbout.setPreferredSize(new Dimension(200, 50));
        panelTitleAbout.setMaximumSize(panelTitleAbout.getPreferredSize());
//        panelTitleAbout.setBorder(new javax.swing.border.EmptyBorder(0, 10, 0, 0));
        
        labelTitleMenu.setForeground(Color.WHITE);
        labelTitleHome.setForeground(Color.WHITE);
        labelTitleSchedule.setForeground(Color.WHITE);
        labelTitleScore.setForeground(Color.WHITE);
        labelTitleAbout.setForeground(Color.WHITE);
        
        labelTitleMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(isShow == true) {
                    hideShow(panelTitleMenu, isShow);
                    isShow = false;
                }
                else {
                    hideShow(panelTitleMenu, isShow);
                    isShow = true;
                }
                
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[0], panelIconShowHide, linebr[0], panelTitleShowHide, 0);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[0], panelIconShowHide, linebr[0], panelTitleShowHide, 0);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[0], panelIconShowHide, linebr[0], panelTitleShowHide, 0);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[0], panelIconShowHide, linebr[0], panelTitleShowHide, 0);
            }
        });
        
        labelTitleHome.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt, panelTitleHome, panelIconHome, 1);
                changeLayout("Home");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[1], panelIconHome, linebr[1], panelTitleHome, 1);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[1], panelIconHome, linebr[1], panelTitleHome, 1);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[1], panelIconHome, linebr[1], panelTitleHome, 1);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[1], panelIconHome, linebr[1], panelTitleHome, 1);
            }
        });
        
        labelTitleSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt, panelTitleSchedule, panelIconSchedule, 2);
                changeLayout("Schedule");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[2], panelIconSchedule, linebr[2], panelTitleSchedule, 2);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[2], panelIconSchedule, linebr[2], panelTitleSchedule, 2);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[2], panelIconSchedule, linebr[2], panelTitleSchedule, 2);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[2], panelIconSchedule, linebr[2], panelTitleSchedule, 2);
            }
        });
        
        labelTitleScore.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt, panelTitleScore, panelIconScore, 3);
                changeLayout("Score");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[3], panelIconScore, linebr[3], panelTitleScore, 3);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[3], panelIconScore, linebr[3], panelTitleScore, 3);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[3], panelIconScore, linebr[3], panelTitleScore, 3);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[3], panelIconScore, linebr[3], panelTitleScore, 3);
            }
        });
        
        labelTitleAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt, panelTitleAbout, panelIconAbout, 4);
                changeLayout("About");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[4], panelIconAbout, linebr[4], panelTitleAbout, 4);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[4], panelIconAbout, linebr[4], panelTitleAbout, 4);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[4], panelIconAbout, linebr[4], panelTitleAbout, 4);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[4], panelIconAbout, linebr[4], panelTitleAbout, 4);
            }
        });
        
        panelTitleShowHide.add(labelTitleMenu, BorderLayout.CENTER);
        panelTitleHome.add(labelTitleHome, BorderLayout.CENTER);
        panelTitleSchedule.add(labelTitleSchedule, BorderLayout.CENTER);
        panelTitleScore.add(labelTitleScore, BorderLayout.CENTER);
        panelTitleAbout.add(labelTitleAbout, BorderLayout.CENTER);
        
        panelTitleMenu.add(panelTitleShowHide);
        panelTitleMenu.add(panelTitleHome);
        panelTitleMenu.add(panelTitleSchedule);
        panelTitleMenu.add(panelTitleScore);
        panelTitleMenu.add(panelTitleAbout);
    }
    
    private void buildIconMenu() {
        this.isShow = true;
        this.isClick = new boolean[5];
        
        javax.swing.JLabel labelIconMenu = new JLabel();
        javax.swing.JLabel labelIconHome = new JLabel();
        javax.swing.JLabel labelIconSchedule = new JLabel();
        javax.swing.JLabel labelIconScore = new JLabel();
        javax.swing.JLabel labelIconAbout = new JLabel();
        
        panelIconShowHide.setBackground(colorMenu);
        panelIconShowHide.setPreferredSize(new Dimension(60, 50));
        panelIconShowHide.setMaximumSize(panelIconShowHide.getPreferredSize());
        panelIconHome.setBackground(colorMenu);
        panelIconHome.setPreferredSize(new Dimension(60, 50));
        panelIconHome.setMaximumSize(panelIconHome.getPreferredSize());
        panelIconSchedule.setBackground(colorMenu);
        panelIconSchedule.setPreferredSize(new Dimension(60, 50));
        panelIconSchedule.setMaximumSize(panelIconSchedule.getPreferredSize());
        panelIconScore.setBackground(colorMenu);
        panelIconScore.setPreferredSize(new Dimension(60, 50));
        panelIconScore.setMaximumSize(panelIconScore.getPreferredSize());
        panelIconAbout.setBackground(colorMenu);
        panelIconAbout.setPreferredSize(new Dimension(60, 50));
        panelIconAbout.setMaximumSize(panelIconAbout.getPreferredSize());
        
        for(int i = 0; i < 5; i++) {
            lineSetting[i] = new JPanel();
            linebr[i] = new JPanel();
            linebr[i].setBackground(colorMenu);
            lineSetting[i].setBackground(colorMenu);
            lineSetting[i].setPreferredSize(new Dimension(5, 50));
            linebr[i].setPreferredSize(new Dimension(5, 50));
            this.isClick[i] = false;
        }
        
        panelIconShowHide.add(lineSetting[0], BorderLayout.WEST);
        panelIconHome.add(lineSetting[1], BorderLayout.WEST);
        panelIconSchedule.add(lineSetting[2], BorderLayout.WEST);
        panelIconScore.add(lineSetting[3], BorderLayout.WEST);
        panelIconAbout.add(lineSetting[4], BorderLayout.WEST);
        
        panelIconShowHide.add(linebr[0], BorderLayout.EAST);
        panelIconHome.add(linebr[1], BorderLayout.EAST);
        panelIconSchedule.add(linebr[2], BorderLayout.EAST);
        panelIconScore.add(linebr[3], BorderLayout.EAST);
        panelIconAbout.add(linebr[4], BorderLayout.EAST);
        
        labelIconMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/icon/menu(2).png")));
        labelIconMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/icon/home(4).png")));
        labelIconHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconSchedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/icon/timetable.png")));
        labelIconSchedule.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/icon/grade.png")));
        labelIconScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/icon/info(1).png")));
        labelIconAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        labelIconMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(isShow == true) {
                    hideShow(panelTitleMenu, isShow);
                    isShow = false;
                }
                else {
                    hideShow(panelTitleMenu, isShow);
                    isShow = true;
                }
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[0], panelIconShowHide, linebr[0], panelTitleShowHide, 0);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[0], panelIconShowHide, linebr[0], panelTitleShowHide, 0);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[0], panelIconShowHide, linebr[0], panelTitleShowHide, 0);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[0], panelIconShowHide, linebr[0], panelTitleShowHide, 0);
            }
        });
        
        labelIconHome.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt, panelIconHome, panelTitleHome, 1);
                changeLayout("Home");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[1], panelIconHome, linebr[1], panelTitleHome, 1);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[1], panelIconHome, linebr[1], panelTitleHome, 1);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[1], panelIconHome, linebr[1], panelTitleHome, 1);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[1], panelIconHome, linebr[1], panelTitleHome, 1);
            }
        });
        
        labelIconSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt, panelIconSchedule, panelTitleSchedule, 2);
                changeLayout("Schedule");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[2], panelIconSchedule, linebr[2], panelTitleSchedule, 2);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[2], panelIconSchedule, linebr[2], panelTitleSchedule, 2);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[2], panelIconSchedule, linebr[2], panelTitleSchedule, 2);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[2], panelIconSchedule, linebr[2], panelTitleSchedule, 2);
            }
        });
        
        labelIconScore.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt, panelIconScore, panelTitleScore, 3);
                changeLayout("Score");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[3], panelIconScore, linebr[3], panelTitleScore, 3);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[3], panelIconScore, linebr[3], panelTitleScore, 3);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[3], panelIconScore, linebr[3], panelTitleScore, 3);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[3], panelIconScore, linebr[3], panelTitleScore, 3);
            }
        });
        
        labelIconAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt, panelIconAbout, panelTitleAbout, 4);
                changeLayout("About");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt, lineSetting[4], panelIconAbout, linebr[4], panelTitleAbout, 4);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt, lineSetting[4], panelIconAbout, linebr[4], panelTitleAbout, 4);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseReleased(evt, lineSetting[4], panelIconAbout, linebr[4], panelTitleAbout, 4);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt, lineSetting[4], panelIconAbout, linebr[4], panelTitleAbout, 4);
            }
        });
        
        panelIconShowHide.add(labelIconMenu, BorderLayout.CENTER);
        panelIconHome.add(labelIconHome, BorderLayout.CENTER);
        panelIconSchedule.add(labelIconSchedule, BorderLayout.CENTER);
        panelIconScore.add(labelIconScore, BorderLayout.CENTER);
        panelIconAbout.add(labelIconAbout, BorderLayout.CENTER);
        
        panelIconMenu.add(panelIconShowHide);
        panelIconMenu.add(panelIconHome);
        panelIconMenu.add(panelIconSchedule);
        panelIconMenu.add(panelIconScore);
        panelIconMenu.add(panelIconAbout);
    }
    
    public void changeLayout(String name) {
        cardLayout.show(panelBody, name);
    }
    
    public void hideShow(JPanel menushowhide, boolean dashboard) {
        if(dashboard == true) {
            panelMenu.setPreferredSize(new Dimension(60, menushowhide.getHeight()));
            Component[] components = scoreLayout.getComponents();
            for(Component cpn : components) {
                cpn.setPreferredSize(new Dimension(1140, cpn.getHeight()));
                System.err.println(cpn.getWidth());
            }
            SwingUtilities.updateComponentTreeUI(NewClass1.this);
            this.configJComboBox();
        }
        else {
            panelMenu.setPreferredSize(new Dimension(250, menushowhide.getHeight()));
            Component[] components = scoreLayout.getComponents();
            for(Component cpn : components) {
                cpn.setPreferredSize(new Dimension(1140, cpn.getHeight()));
                System.err.println(cpn.getWidth());
            }
            SwingUtilities.updateComponentTreeUI(NewClass1.this);
            this.configJComboBox();
        }
    }
    
    public void clickMenu(JPanel panel1, JPanel panel2, int numberbool) {
        if(numberbool == 1) {
            panel1.setBackground(new Color(7, 121, 200));
            panel2.setBackground(new Color(7, 121, 150));
        }
        else {
            panel1.setBackground(new Color(7, 121, 150));
            panel2.setBackground(new Color(7, 121, 200));
        }
    }
    
    public void changeColor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }
    
    public void MouseExited(java.awt.event.MouseEvent evt, JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, int index) {
        if(this.isClick[index] == false) {
            changeColor(panel1, colorMenu);
            changeColor(panel2, colorMenu);
            changeColor(panel3, colorMenu);
            changeColor(panel4, colorMenu);
        }
    }
    
    public void MousePressed(java.awt.event.MouseEvent evt, JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, int index) {
        if(this.isClick[index] == false) {
            changeColor(panel1, colorLine);
            changeColor(panel2, colorLine);
            changeColor(panel3, colorLine);
            changeColor(panel4, colorLine);
        }
    }
    
    public void MouseReleased(java.awt.event.MouseEvent evt, JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, int index) {
        if(this.isClick[index] == false) {
            changeColor(panel1, colorLine);
            changeColor(panel2, colorHoverMenu);
            changeColor(panel3, colorHoverMenu);
            changeColor(panel4, colorHoverMenu);
        }
    }
    
    public void MouseEntered(java.awt.event.MouseEvent evt, JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, int index) {
        if(this.isClick[index] == false) {
            changeColor(panel1, colorLine);
            changeColor(panel2, colorHoverMenu);
            changeColor(panel3, colorHoverMenu);
            changeColor(panel4, colorHoverMenu);
        }
    }
    
    public void MouseClicked(java.awt.event.MouseEvent evt, JPanel panel1, JPanel panel2, int index) {
        for(int i = 0; i < 5; i++) {
            changeColor(lineSetting[i], colorMenu);
            changeColor(linebr[i], colorMenu);
            this.isClick[i] = false;
        }
        changeColor(panelTitleShowHide, colorMenu);
        changeColor(panelTitleHome, colorMenu);
        changeColor(panelTitleSchedule, colorMenu);
        changeColor(panelTitleScore, colorMenu);
        changeColor(panelTitleAbout, colorMenu);
        changeColor(panelIconShowHide, colorMenu);
        changeColor(panelIconHome, colorMenu);
        changeColor(panelIconSchedule, colorMenu);
        changeColor(panelIconScore, colorMenu);
        changeColor(panelIconAbout, colorMenu);
        
        changeColor(lineSetting[index], colorLine);
        changeColor(panel1, colorHoverMenu);
        changeColor(panel2, colorHoverMenu);
        changeColor(linebr[index], colorHoverMenu);
        this.isClick[index] = true;
    }
    
    private void configJComboBox() {
        UIManager.put("ComboBox.background", new ColorUIResource(Color.WHITE));
        UIManager.put("JTextField.background", new ColorUIResource(Color.WHITE));
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Color.WHITE));
        UIManager.put("ComboBox.selectionForeground", new ColorUIResource(new Color(72,128,248)));
    }
    
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelTopMenu;
    private javax.swing.JPanel panelIconMenu;
    private javax.swing.JPanel panelTitleMenu;
    private boolean isShow;
    private boolean[] isClick;
    private CardLayout cardLayout;
    
    private javax.swing.JPanel panelTitleShowHide = new JPanel(new BorderLayout());
    private javax.swing.JPanel panelTitleHome = new JPanel(new BorderLayout());
    private javax.swing.JPanel panelTitleSchedule = new JPanel(new BorderLayout());
    private javax.swing.JPanel panelTitleScore = new JPanel(new BorderLayout());
    private javax.swing.JPanel panelTitleAbout = new JPanel(new BorderLayout());
    
    private javax.swing.JPanel[] lineSetting = new JPanel[5];
    private JPanel[] linebr = new JPanel[5];
    private javax.swing.JPanel panelIconShowHide = new JPanel(new BorderLayout());
    private javax.swing.JPanel panelIconHome = new JPanel(new BorderLayout());
    private javax.swing.JPanel panelIconSchedule = new JPanel(new BorderLayout());
    private javax.swing.JPanel panelIconScore = new JPanel(new BorderLayout());
    private javax.swing.JPanel panelIconAbout = new JPanel(new BorderLayout());

    private Color colorMenu = new Color(15,25,34);
    private Color colorHoverMenu = new Color(28, 43, 54);
    private Color colorLine = new Color(242, 82, 135);
    private String MAHS = "3119410304";
    private String maGv = "GV0001";
    private String nameStudent = "Diệp Bảo Thanh Phong";
    private String nameTeacher = "Chai Dầu";
    
    private Dimension sizeBodySmall = new Dimension(950, 600);
    private Dimension sizeBodyLarge = new Dimension(1140, 600);
    
//    private Font fontMenu = new Font("DENSE", 1, 14);
//    private Color colorFontTitle = new Color(176, 189, 196);

    public NewClass1(JTable tableDataScore, JTable tableDataDayOff, JTable tableDataSummary, JScrollPane scrollPanelScore, JScrollPane scrollPanelDayOff, JScrollPane scrollPanelSummary, JPanel JPanelChooseYear, JPanel panelMenu, JPanel panelBody, JPanel panelTopMenu, JPanel panelIconMenu, JPanel panelTitleMenu, boolean isShow, boolean[] isClick, CardLayout cardLayout) throws HeadlessException {
        this.tableDataScore = tableDataScore;
        this.tableDataDayOff = tableDataDayOff;
        this.tableDataSummary = tableDataSummary;
        this.scrollPanelScore = scrollPanelScore;
        this.scrollPanelDayOff = scrollPanelDayOff;
        this.scrollPanelSummary = scrollPanelSummary;
        this.JPanelChooseYear = JPanelChooseYear;
        this.panelMenu = panelMenu;
        this.panelBody = panelBody;
        this.panelTopMenu = panelTopMenu;
        this.panelIconMenu = panelIconMenu;
        this.panelTitleMenu = panelTitleMenu;
        this.isShow = isShow;
        this.isClick = isClick;
        this.cardLayout = cardLayout;
    }
}
