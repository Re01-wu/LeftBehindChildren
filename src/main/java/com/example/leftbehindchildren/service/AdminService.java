package com.example.leftbehindchildren.service;

import com.example.leftbehindchildren.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin createAdmin(Admin admin);

    Admin updateAdmin(Admin admin);

    void deleteAdmin(Long id);

    Admin getAdminById(Long id);

    List<Admin> getAllAdmins();

    Admin findByUsername(String username);
}
