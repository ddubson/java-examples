package com.ddubson.datastructures.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Author: ddubson
 */
public class SetTest {
    MySet set;

    @Before
    public void setUp() throws Exception {
        set = new MySetImpl();
    }

    // identify what type of objects will be in the set?
    // Generics or any type of 'Object'

    // Function testing
    // add
    // - can add
    // @ throw exception if object already exists
    // - throw exception if object is null
    // remove
    // - remove successfully
    // - throw exception if object does not exist for removal
    // - throw exception if object to remove is null
    // contains
    // - return true if object exists, false otherwise successfully
    // - throw exception if object is null
    // size
    // - should return the correct size of the set.
    // isEmpty
    // - return true if set is empty, false otherwise successfully
    // iterator
    // - return the iterator of the set successfully.
    // clear
    // - should clear the set of its values successfully
    // - clear can be executed against an empty set successfully.


    @Test(expected = IllegalStateException.class)
    public void set_shouldThrowExceptionIfValueAlreadyExists() throws Exception {
        set.add("Hello");
        set.add("Hello");
    }

    @Test
    public void set_shouldReturnAnIteratorSuccessfully() throws Exception {
        set.add("Hello");
        set.add("World");
        set.add(124);
        Iterator setIterator = set.iterator();
        while(setIterator.hasNext()) {
            Object o = setIterator.next();
            System.out.println(o.toString());
        }
    }

    @Test
    public void set_shouldReturnTrueWhenValueIsPresent() throws Exception {
        set.add(1);
        assertTrue(set.contains(1));
    }

    @Test
    public void set_shouldReturnFalseWhenValueIsNotInSet() throws Exception {
        assertFalse(set.contains(2));
    }

    @Test
    public void set_shouldReturnProperSize() throws Exception {
        set.add(1);
        set.add(2);
        assertTrue(set.size()==2);
    }

    @Test
    public void set_shouldReturnTrueWhenEmpty() throws Exception {
        assertTrue(set.isEmpty());
    }

    @Test
    public void set_shouldReturnFalseWhenNonEmpty() throws Exception {
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void set_successfullyremovesexistingobject() throws Exception {
        set.add(1);
        set.add("Hello");
        assertTrue(set.size()==2);
        set.remove(1);
        assertTrue(set.size()==1);
    }

    @Test
    public void set_successfullyclearsanonemptyset() throws Exception {
        set.add(1);
        assertTrue(set.size()==1);
        set.clear();
        assertTrue(set.size()==0);
    }
}
