/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagementapp;


import com.mycompany.librarymanagementapp.model.*;
import com.mycompany.librarymanagementapp.dao.*;
import com.mycompany.librarymanagementapp.view.Giaodienchinh;
import javax.swing.SwingUtilities;

/**
 *
 * @author ddd
 */
public class LibraryManagementApp {

    public static void main(String[] args) {
        new LibraryManagementApp().run();
    }

    public void run() {
        // Khởi chạy giao diện chính
        SwingUtilities.invokeLater(() -> {
            Giaodienchinh giaodienchinh = new Giaodienchinh();
            giaodienchinh.setVisible(true);
        });
        System.out.println("Hello World!");
        
        PublisherDAO publisherDAO = new PublisherDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        // Thêm mới Publisher
        Publisher publisher = new Publisher("O'Reilly Media");
        publisherDAO.savePublisher(publisher);

        // Thêm mới Category
        Category category = new Category("Technology");
        categoryDAO.saveCategory(category);

        // Lấy tất cả Publisher
        publisherDAO.getAllPublishers().forEach(pub -> System.out.println(pub));

        // Lấy tất cả Category
        categoryDAO.getAllCategories().forEach(cat -> System.out.println(cat));
        
        

        // Commit transaction và đóng session

        System.out.println("Bảng đã được tạo và dữ liệu đã được thêm!");
    }
}
