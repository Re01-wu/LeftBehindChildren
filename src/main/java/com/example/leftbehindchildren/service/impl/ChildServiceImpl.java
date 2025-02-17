package com.example.leftbehindchildren.service.impl;

import com.example.leftbehindchildren.entity.Child;
import com.example.leftbehindchildren.entity.User;
import com.example.leftbehindchildren.repository.ChildRepository;
import com.example.leftbehindchildren.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Override
    public List<Child> findAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return childRepository.findAll();
        } else {
            return findAssignedChildren();
        }
    }

    @Override
    public Child findById(Long id) {
        return childRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Child not found with id: " + id));
    }

    @Override
    public Child save(Child child) {
        return childRepository.save(child);
    }

    @Override
    public Child update(Child child) {
        if (!childRepository.existsById(child.getId())) {
            throw new RuntimeException("Child not found with id: " + child.getId());
        }
        return childRepository.save(child);
    }

    @Override
    public void deleteById(Long id) {
        if (!childRepository.existsById(id)) {
            throw new RuntimeException("Child not found with id: " + id);
        }
        childRepository.deleteById(id);
    }

    @Override
    public List<Child> findAssignedChildren() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            User currentUser = (User) authentication.getPrincipal();
            return childRepository.findByAssignedUserId(currentUser.getId());
        }
        return List.of();
    }
}