package com.example.leftbehindchildren.controller;

import com.example.leftbehindchildren.entity.Child;
import com.example.leftbehindchildren.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/children")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Child>> getAllChildren() {
        return ResponseEntity.ok(childService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Child> getChildById(@PathVariable Long id) {
        return ResponseEntity.ok(childService.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Child> createChild(@RequestBody Child child) {
        return ResponseEntity.ok(childService.save(child));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Child> updateChild(@PathVariable Long id, @RequestBody Child child) {
        child.setId(id);
        return ResponseEntity.ok(childService.update(child));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteChild(@PathVariable Long id) {
        childService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/assigned")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Child>> getAssignedChildren() {
        return ResponseEntity.ok(childService.findAssignedChildren());
    }
}