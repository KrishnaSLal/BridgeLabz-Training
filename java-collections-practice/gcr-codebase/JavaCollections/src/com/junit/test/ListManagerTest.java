package com.junit.test;

import org.junit.Test;

import com.junit.com.ListManager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    ListManager manager = new ListManager();

    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();

        manager.addElement(list, 10);
        manager.addElement(list, 20);

        assertEquals(2, manager.getSize(list));
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        manager.removeElement(list, 20);

        assertEquals(2, manager.getSize(list));
        assertFalse(list.contains(20));
    }

    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();

        assertEquals(0, manager.getSize(list));

        manager.addElement(list, 5);
        manager.addElement(list, 15);

        assertEquals(2, manager.getSize(list));
    }
}