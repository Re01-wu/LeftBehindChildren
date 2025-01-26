package com.example.leftbehindchildren.service;

import com.example.leftbehindchildren.entity.Admin;
import com.example.leftbehindchildren.repository.AdminRepository;
import com.example.leftbehindchildren.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceTests {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin();
        admin.setId(1L);
        admin.setUsername("testAdmin");
        admin.setPassword("testPassword");
    }

    @Test
    void testCreateAdmin() {
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        Admin created = adminService.createAdmin(admin);

        assertNotNull(created);
        assertEquals("testAdmin", created.getUsername());
        verify(adminRepository, times(1)).save(any(Admin.class));
    }

    @Test
    void testGetAdminById() {
        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));

        Admin found = adminService.getAdminById(1L);

        assertNotNull(found);
        assertEquals(1L, found.getId());
        verify(adminRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateAdmin() {
        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));

        admin.setUsername("updatedAdmin");
        Admin updated = adminService.updateAdmin(admin);

        assertNotNull(updated);
        assertEquals("updatedAdmin", updated.getUsername());
        verify(adminRepository, times(1)).save(any(Admin.class));
    }

    @Test
    void testDeleteAdmin() {
        doNothing().when(adminRepository).deleteById(1L);

        adminService.deleteAdmin(1L);

        verify(adminRepository, times(1)).deleteById(1L);
    }
}
