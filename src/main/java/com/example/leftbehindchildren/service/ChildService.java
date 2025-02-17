package com.example.leftbehindchildren.service;

import com.example.leftbehindchildren.entity.Child;
import java.util.List;

public interface ChildService {
    List<Child> findAll();
    
    Child findById(Long id);
    
    Child save(Child child);
    
    Child update(Child child);
    
    void deleteById(Long id);
    
    List<Child> findAssignedChildren();
}