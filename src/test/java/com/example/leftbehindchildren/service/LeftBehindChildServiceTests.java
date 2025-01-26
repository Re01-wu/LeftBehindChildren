package com.example.leftbehindchildren.service;

import com.example.leftbehindchildren.entity.LeftBehindChild;
import com.example.leftbehindchildren.repository.LeftBehindChildRepository;
import com.example.leftbehindchildren.service.impl.LeftBehindChildServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LeftBehindChildServiceTests {

    @Mock
    private LeftBehindChildRepository childRepository;

    @InjectMocks
    private LeftBehindChildServiceImpl childService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateChild() {
        LeftBehindChild child = new LeftBehindChild();
        when(childRepository.save(child)).thenReturn(child);

        LeftBehindChild created = childService.createChild(child);
        assertNotNull(created);
        verify(childRepository, times(1)).save(child);
    }

    @Test
    void testGetAllChildren() {
        when(childRepository.findAll()).thenReturn(Arrays.asList(new LeftBehindChild(), new LeftBehindChild()));

        List<LeftBehindChild> children = childService.getAllChildren();
        assertEquals(2, children.size());
        verify(childRepository, times(1)).findAll();
    }

    @Test
    void testGetChildById() {
        Long id = 1L;
        LeftBehindChild child = new LeftBehindChild();
        when(childRepository.findById(id)).thenReturn(Optional.of(child));

        LeftBehindChild found = childService.getChildById(id);
        assertNotNull(found);
        verify(childRepository, times(1)).findById(id);
    }

    @Test
    void testUpdateChild() {
        Long id = 1L;
        LeftBehindChild existing = new LeftBehindChild();
        LeftBehindChild newDetails = new LeftBehindChild();
        when(childRepository.findById(id)).thenReturn(Optional.of(existing));
        when(childRepository.save(existing)).thenReturn(existing);

        LeftBehindChild updated = childService.updateChild(id, newDetails);
        assertNotNull(updated);
        verify(childRepository, times(1)).findById(id);
        verify(childRepository, times(1)).save(existing);
    }

    @Test
    void testDeleteChild() {
        Long id = 1L;
        LeftBehindChild child = new LeftBehindChild();
        when(childRepository.findById(id)).thenReturn(Optional.of(child));
        doNothing().when(childRepository).delete(child);

        childService.deleteChild(id);
        verify(childRepository, times(1)).findById(id);
        verify(childRepository, times(1)).delete(child);
    }
}
