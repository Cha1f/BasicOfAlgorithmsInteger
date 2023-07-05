package com.boainteger.basicofalgorithmsparttwo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.theme.CookieThemeResolver;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListImplTest {
    private IntegerListImpl list;

    @BeforeEach
    public void setUp() {
        list = new IntegerListImpl();
    }

    @Test
    void addTest() {
        list.add(5);
        assertEquals(5, list.get(0));
        assertEquals(1, list.size());
        assertTrue(list.contains(5));
    }

    @Test
    void addForIndexTest() {
        list.add(1);
        assertEquals(1, list.get(0));
        list.add(0, 5);
        assertEquals(5, list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    void removeTest() {
        list.add(1);
        list.remove((Integer) 1);
        assertTrue(list.isEmpty());
    }

    @Test
    void removeForIndexTest() {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(2, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void setTest() {
        list.add(1);
        list.add(2);
        list.set(0, 3);
        assertEquals(3, list.get(0));
    }

    @Test
    void indexOfTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.lastIndexOf(3));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    void equalTest() {
        IntegerListImpl otherList = new IntegerListImpl();
        list.add(1);
        otherList.add(1);
        assertTrue(list.equals(otherList));
    }

    @Test
    void clearTest() {
        list.add(1);
        list.add(2);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void ItemValueNullExceptionTest() {
        assertThrows(ItemValueNullException.class, () -> list.add(null));
    }

    @Test
    void SizeValueNullExceptionTest() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertThrows(SizeValueNullException.class, () -> list.add(11));
    }

    @Test
    void IndexValueNullExceptionTest() {
        assertThrows(IndexValueNullException.class, () -> list.add(-1, 1));
    }

    @Test
    void ElementNotFoundExceptionTest() {
        assertThrows(ElementNotFoundException.class, () -> list.remove((Integer) 1));
    }
}
