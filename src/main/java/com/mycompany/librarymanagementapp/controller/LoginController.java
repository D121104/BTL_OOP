package com.mycompany.librarymanagementapp.controller;

import com.mycompany.librarymanagementapp.dao.UserDAO;
import com.mycompany.librarymanagementapp.view.Giaodienchinh;
import com.mycompany.librarymanagementapp.view.Giaodienthuhai;
import com.mycompany.librarymanagementapp.model.User;
import com.mycompany.librarymanagementapp.utils.SessionManager;

public class LoginController {

    private Giaodienchinh view;
    private UserDAO userDAO;

    public LoginController(Giaodienchinh view) {
        this.view = view;
        this.userDAO = new UserDAO();  // Khởi tạo UserDAO
    }

    // Phương thức xử lý đăng nhập
    public void handleLogin() {
        String taiKhoan = view.getUsername();
        String matKhau = view.getPassword();

        // Kiểm tra nếu thiếu tên đăng nhập hoặc mật khẩu
        if (taiKhoan.isEmpty() || matKhau.isEmpty()) {
            view.setFeedbackMessage("Vui lòng điền đầy đủ thông tin!",false);
        } else {
            // Kiểm tra tên đăng nhập và mật khẩu trong cơ sở dữ liệu
            if (checkLogin(taiKhoan, matKhau)) {
                // Đăng nhập thành công, lưu thông tin phiên đăng nhập
                User user = userDAO.getUserByUsername(taiKhoan);
                SessionManager.saveUserSession(user.getUsername(), user.getRole());

                // Tắt giao diện đăng nhập và mở giao diện Giaodienthuhai
                view.dispose(); // Đóng cửa sổ đăng nhập
                Giaodienthuhai giaodien = new Giaodienthuhai(user.getUsername()); // Truyền tên người dùng
                giaodien.setVisible(true);
                view.setFeedbackMessage("Đăng nhập thành công!",true);
            } else {
                view.setFeedbackMessage("Tên đăng nhập hoặc mật khẩu sai!",false);
            }
        }
    }

    // Phương thức kiểm tra đăng nhập
    private boolean checkLogin(String username, String password) {
        // Sử dụng UserDAO để tìm user theo username
        User user = userDAO.getUserByUsername(username);
        
        if (user != null) {
            // Kiểm tra mật khẩu, lưu ý nếu mật khẩu được mã hóa bạn cần so sánh mật khẩu đã mã hóa
            return user.getPassword().equals(password);  // So sánh mật khẩu chưa mã hóa
        }
        return false;
    }
}
