package com.example.leftbehindchildren.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class LeftBehindChild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 姓名
    private String gender; // 性别
    private LocalDate birthDate; // 出生日期
    private String idNumber; // 身份证号
    private String school; // 所在学校
    private String grade; // 年级
    private String address; // 家庭住址
    private String guardianName; // 监护人姓名
    private String guardianPhone; // 监护人电话
    private String status; // 留守儿童状态
    private String remarks; // 备注

    // 创建时间和更新时间
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        updatedAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }
}
