package com.mycompany.librarymanagementapp.utils;

public class SessionManager {
    private static String currentUsername = "";  // Lưu trữ tên người dùng
    private static String currentUserRole = "";  // Lưu trữ vai trò người dùng

    // Phương thức để lưu thông tin người dùng và vai trò
    public static void saveUserSession(String username, String role) {
        currentUsername = username;
        currentUserRole = role;
    }

    // Phương thức để lấy tên người dùng
    public static String getCurrentUsername() {
        return currentUsername;
    }

    // Phương thức để lấy vai trò người dùng
    public static String getCurrentUserRole() {
        return currentUserRole;
    }

    // Phương thức để xóa thông tin phiên đăng nhập
    public static void clearSession() {
        currentUsername = "";
        currentUserRole = "";
    }
}
