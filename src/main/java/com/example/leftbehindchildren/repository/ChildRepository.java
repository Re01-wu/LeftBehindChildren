package com.example.leftbehindchildren.repository;

import com.example.leftbehindchildren.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByAssignedUserId(Long userId);
}