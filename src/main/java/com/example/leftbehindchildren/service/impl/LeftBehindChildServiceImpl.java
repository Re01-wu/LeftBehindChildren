package com.example.leftbehindchildren.service.impl;

import com.example.leftbehindchildren.entity.LeftBehindChild;
import com.example.leftbehindchildren.exception.ResourceNotFoundException;
import com.example.leftbehindchildren.repository.LeftBehindChildRepository;
import com.example.leftbehindchildren.service.LeftBehindChildService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeftBehindChildServiceImpl implements LeftBehindChildService {

    private final LeftBehindChildRepository childRepository;

    public LeftBehindChildServiceImpl(LeftBehindChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public LeftBehindChild createChild(LeftBehindChild child) {
        return childRepository.save(child);
    }

    @Override
    public LeftBehindChild updateChild(Long id, LeftBehindChild childDetails) {
        LeftBehindChild child = childRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Child not found with id: " + id));

        child.setName(childDetails.getName());
        child.setGender(childDetails.getGender());
        child.setBirthDate(childDetails.getBirthDate());
        child.setIdNumber(childDetails.getIdNumber());
        child.setSchool(childDetails.getSchool());
        child.setGrade(childDetails.getGrade());
        child.setAddress(childDetails.getAddress());
        child.setGuardianName(childDetails.getGuardianName());
        child.setGuardianPhone(childDetails.getGuardianPhone());
        child.setStatus(childDetails.getStatus());
        child.setRemarks(childDetails.getRemarks());

        return childRepository.save(child);
    }

    @Override
    public List<LeftBehindChild> getAllChildren() {
        return childRepository.findAll();
    }

    @Override
    public LeftBehindChild getChildById(Long id) {
        return childRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Child not found with id: " + id));
    }

    @Override
    public LeftBehindChild getChildByIdNumber(String idNumber) {
        return childRepository.findByIdNumber(idNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Child not found with id number: " + idNumber));
    }

    @Override
    public void deleteChild(Long id) {
        LeftBehindChild child = childRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Child not found with id: " + id));
        childRepository.delete(child);
    }

    @Override
    public List<LeftBehindChild> getChildrenBySchool(String school) {
        return childRepository.findBySchool(school);
    }

    @Override
    public List<LeftBehindChild> getChildrenByStatus(String status) {
        return childRepository.findByStatus(status);
    }
}
