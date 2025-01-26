package com.example.leftbehindchildren.repository;

import com.example.leftbehindchildren.entity.LeftBehindChild;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface LeftBehindChildRepository extends JpaRepository<LeftBehindChild, Long> {
    // 可以根据需要添加自定义查询方法
    Optional<LeftBehindChild> findByIdNumber(String idNumber);

    List<LeftBehindChild> findBySchool(String school);

    List<LeftBehindChild> findByStatus(String status);
}
