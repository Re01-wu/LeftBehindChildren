package com.example.leftbehindchildren.controller;

import com.example.leftbehindchildren.entity.LeftBehindChild;
import com.example.leftbehindchildren.service.LeftBehindChildService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/children")
public class LeftBehindChildController {

    private final LeftBehindChildService childService;

    public LeftBehindChildController(LeftBehindChildService childService) {
        this.childService = childService;
    }

    @PostMapping
    public LeftBehindChild createChild(@RequestBody LeftBehindChild child) {
        return childService.createChild(child);
    }

    @GetMapping
    public List<LeftBehindChild> getAllChildren() {
        return childService.getAllChildren();
    }

    @GetMapping("/{id}")
    public LeftBehindChild getChildById(@PathVariable Long id) {
        return childService.getChildById(id);
    }

    @GetMapping("/idNumber/{idNumber}")
    public LeftBehindChild getChildByIdNumber(@PathVariable String idNumber) {
        return childService.getChildByIdNumber(idNumber);
    }

    @PutMapping("/{id}")
    public LeftBehindChild updateChild(@PathVariable Long id, @RequestBody LeftBehindChild childDetails) {
        return childService.updateChild(id, childDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteChild(@PathVariable Long id) {
        childService.deleteChild(id);
    }

    @GetMapping("/school/{school}")
    public List<LeftBehindChild> getChildrenBySchool(@PathVariable String school) {
        return childService.getChildrenBySchool(school);
    }

    @GetMapping("/status/{status}")
    public List<LeftBehindChild> getChildrenByStatus(@PathVariable String status) {
        return childService.getChildrenByStatus(status);
    }
}
