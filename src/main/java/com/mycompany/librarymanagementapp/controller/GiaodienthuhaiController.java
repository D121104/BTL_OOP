package com.mycompany.librarymanagementapp.controller;

import com.mycompany.librarymanagementapp.view.Giaodienthuhai;
import com.mycompany.librarymanagementapp.view.Giaodienchinh;
import com.mycompany.librarymanagementapp.utils.SessionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaodienthuhaiController {

    private Giaodienthuhai view;

    public GiaodienthuhaiController(Giaodienthuhai view) {
        this.view = view;
        addListeners();
    }

    private void addListeners() {
        // Đăng xuất
        view.getjButtonDANGXUAT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi đăng xuất, xóa phiên đăng nhập và quay lại giao diện đăng nhập
                SessionManager.clearSession();
                new Giaodienchinh().setVisible(true);  // Mở giao diện đầu tiên
                view.dispose();  // Đóng giao diện hiện tại
            }
        });

        // Thêm hành động cho nút "THÊM TÀI KHOẢN QUẢN LÝ"
        view.getjButtonTHEMQUANLY().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra vai trò người dùng từ SessionManager
                String role = SessionManager.getCurrentUserRole();  // Giả sử bạn có phương thức này để lấy vai trò người dùng
                if ("quan li".equals(role)) {
            JOptionPane.showMessageDialog(view, "Thực hiện thêm tài khoản quản lý.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, "Bạn không có quyền này!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
            }
        });
    }
}
