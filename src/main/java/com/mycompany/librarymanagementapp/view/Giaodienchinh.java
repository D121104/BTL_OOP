package com.mycompany.librarymanagementapp.view;

import com.mycompany.librarymanagementapp.controller.LoginController;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Giaodienchinh extends JFrame {
    private boolean isPasswordVisible = false;

    // Các thành phần giao diện
    private JTextField jTextFieldTAIKHOAN;
    private JPasswordField jTextFieldMATKHAU;
    private JLabel jLabelTHONGBAODANGNHAP;
    private JButton nutdangnhap;
    private JButton jButtonTHOAT;
    private JButton jButtonHienMatKhau;

    private LoginController controller; // Tham chiếu đến Controller

    public Giaodienchinh() {
        initComponents();
        setTitle("Chương Trình Quản Lí Thư Viện");
        setSize(600, 400);
        setLocationRelativeTo(null);  // Căn giữa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Không cho mở toàn màn hình

        controller = new LoginController(this); // Chuyển View đến Controller
    }

    private void initComponents() {
        // Tạo panel nền
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new GridBagLayout());

        // Tạo panel chứa thành phần giao diện
        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(true);
        mainPanel.setBackground(Color.decode("#6BA3BE")); // Đặt màu nền

        mainPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.decode("#303F30"), 2),
            "Đăng Nhập", 
            TitledBorder.CENTER, 
            TitledBorder.TOP, 
            new Font("Roboto", Font.BOLD, 18), 
            Color.decode("#303F30")) // Màu chữ tiêu đề
        );

        mainPanel.setLayout(new GridBagLayout());

        // Khởi tạo các thành phần giao diện
        JLabel jLabelTAIKHOAN = new JLabel("Tài khoản:");
        JLabel jLabelMATKHAU = new JLabel("Mật khẩu:");
        jTextFieldTAIKHOAN = new JTextField(20);
        jTextFieldMATKHAU = new JPasswordField(20);
        jTextFieldMATKHAU.setEchoChar('*');

        jLabelTHONGBAODANGNHAP = new JLabel("", SwingConstants.CENTER);

        nutdangnhap = new RoundedButton("Tiếp tục", Color.GREEN);
        jButtonTHOAT = new RoundedButton("Thoát", Color.decode("#845152"));
        jButtonHienMatKhau = new RoundedButton("Hiện mật khẩu", Color.YELLOW);
        jButtonHienMatKhau.setForeground(Color.BLACK); // Màu chữ

        // Thiết lập font cho các thành phần
        setCustomFont(jLabelTAIKHOAN, Font.PLAIN, 16);
        setCustomFont(jLabelMATKHAU, Font.PLAIN, 16);
        setCustomFont(nutdangnhap, Font.BOLD, 16);
        setCustomFont(jButtonTHOAT, Font.BOLD, 16);
        setCustomFont(jButtonHienMatKhau, Font.BOLD, 16);

        JLabel Tieude = new JLabel("APP QUẢN LÍ THƯ VIỆN", SwingConstants.CENTER);
        Tieude.setFont(new Font("Roboto", Font.BOLD, 24));

        // Hiện/ẩn mật khẩu
        jButtonHienMatKhau.addActionListener(evt -> {
            isPasswordVisible = !isPasswordVisible;
            jTextFieldMATKHAU.setEchoChar(isPasswordVisible ? (char) 0 : '*');
            jButtonHienMatKhau.setText(isPasswordVisible ? "Ẩn mật khẩu" : "Hiện mật khẩu");
        });

        // Đăng nhập
        nutdangnhap.addActionListener(evt -> controller.handleLogin());

        // Thoát
        jButtonTHOAT.addActionListener(evt -> System.exit(0));

        // Cài đặt layout cho các thành phần
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Thêm tiêu đề
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(Tieude, gbc);

        // Thêm tài khoản
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(jLabelTAIKHOAN, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(jTextFieldTAIKHOAN, gbc);

        // Thêm mật khẩu
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(jLabelMATKHAU, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(jTextFieldMATKHAU, gbc);

        // Thêm thông báo đăng nhập
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(jLabelTHONGBAODANGNHAP, gbc);

        // Thêm các nút vào cùng một dòng
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(nutdangnhap);
        buttonPanel.add(jButtonTHOAT);
        buttonPanel.add(jButtonHienMatKhau);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        // Thêm mainPanel vào backgroundPanel
        backgroundPanel.add(mainPanel);

        // Thêm backgroundPanel vào JFrame
        setContentPane(backgroundPanel);
    }

    // Phương thức để đặt font cho các thành phần
    private void setCustomFont(Component component, int style, int size) {
        component.setFont(new Font("Roboto", style, size));
    }

    // Getter methods
    public String getUsername() {
        return jTextFieldTAIKHOAN.getText();
    }

    public String getPassword() {
        return new String(jTextFieldMATKHAU.getPassword());
    }

    public void setFeedbackMessage(String message, boolean isSuccess) {
        jLabelTHONGBAODANGNHAP.setForeground(isSuccess ? Color.GREEN : Color.RED);
        jLabelTHONGBAODANGNHAP.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Giaodienchinh().setVisible(true));
    }

    // Lớp nội bộ tạo hình nền
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            try {
                backgroundImage = new ImageIcon("src\\main\\resources\\image\\images.jpg").getImage();
            } catch (Exception e) {
                System.out.println("Không thể tải ảnh nền.");
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    // Lớp RoundedButton để bo tròn các nút
    class RoundedButton extends JButton {
        private Color backgroundColor;

        public RoundedButton(String text, Color backgroundColor) {
            super(text);
            this.backgroundColor = backgroundColor;
            setFocusPainted(false);
            setContentAreaFilled(false);
            setForeground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            g2.setColor(getForeground());
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

            FontMetrics fm = g2.getFontMetrics();
            int stringWidth = fm.stringWidth(getText());
            int stringHeight = fm.getAscent();
            g2.setColor(getForeground());
            g2.drawString(getText(), (getWidth() - stringWidth) / 2, (getHeight() + stringHeight) / 2 - 3);
            g2.dispose();
        }
    }
}

