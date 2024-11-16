package com.mycompany.librarymanagementapp.view;

import com.mycompany.librarymanagementapp.controller.*;
import javax.swing.*;
import java.awt.*;

public class Giaodienthuhai extends JFrame {
    private JButton jButtonDANGXUAT, jButtonDONMUONSACH, jButtonNGUOIDOC, jButtonSACH, jButtonTHEMQUANLY;
    private JLabel jLabelWelcome;

    public Giaodienthuhai(String tenDangNhap) {
        initComponents(tenDangNhap);
        new GiaodienthuhaiController(this);  // Tạo controller để xử lý sự kiện
    }

    private void initComponents(String tenDangNhap) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Phần chào và đăng xuất
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jLabelWelcome = new JLabel("Xin chào " + tenDangNhap);
        jLabelWelcome.setFont(new Font("Tahoma", Font.PLAIN, 14));  // Đổi phông và cỡ chữ
        jButtonDANGXUAT = new JButton("Đăng xuất");
        jButtonDANGXUAT.setBackground(Color.RED);
        jButtonDANGXUAT.setForeground(Color.WHITE);
        topPanel.add(jLabelWelcome);
        topPanel.add(jButtonDANGXUAT);
        add(topPanel, BorderLayout.NORTH);

        // Phần nút chính với màu sắc hài hòa
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        
        jButtonSACH = new JButton("SÁCH");
        jButtonSACH.setBackground(new Color(135, 206, 250));

        jButtonNGUOIDOC = new JButton("NGƯỜI ĐỌC");
        jButtonNGUOIDOC.setBackground(new Color(144, 238, 144));

        jButtonDONMUONSACH = new JButton("ĐƠN MƯỢN SÁCH");
        jButtonDONMUONSACH.setBackground(new Color(255, 228, 181));

        jButtonTHEMQUANLY = new JButton("THÊM TÀI KHOẢN QUẢN LÝ");
        jButtonTHEMQUANLY.setBackground(new Color(221, 160, 221));

        // Thiết lập font cho các nút
        Font buttonFont = new Font("Tahoma", Font.BOLD, 16);  // Đổi phông và cỡ chữ cho các nút
        jButtonSACH.setFont(buttonFont);
        jButtonNGUOIDOC.setFont(buttonFont);
        jButtonDONMUONSACH.setFont(buttonFont);
        jButtonTHEMQUANLY.setFont(buttonFont);

        buttonPanel.add(jButtonSACH);
        buttonPanel.add(jButtonNGUOIDOC);
        buttonPanel.add(jButtonDONMUONSACH);
        buttonPanel.add(jButtonTHEMQUANLY);

        add(buttonPanel, BorderLayout.CENTER);

        setSize(800, 600);  // Thay đổi kích thước cửa sổ 
        setLocationRelativeTo(null);  // Căn giữa màn hình
        setResizable(false);  // Không thể phóng to cửa sổ
    }

    public JButton getjButtonDANGXUAT() {
        return jButtonDANGXUAT;
    }
    public JButton getjButtonTHEMQUANLY() {
    return jButtonTHEMQUANLY;
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Giaodienthuhai("Admin").setVisible(true));
    }
}
