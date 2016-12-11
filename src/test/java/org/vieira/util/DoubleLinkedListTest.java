package org.vieira.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Fernando José Vieira
 *
 */
public class DoubleLinkedListTest {

    @Test
    public void testNullList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        
        Assert.assertEquals(null, list.peekHead());
        Assert.assertEquals(null, list.peekTail());
        
        Assert.assertEquals(null, list.pullHead());
        Assert.assertEquals(null, list.pullTail());
        Assert.assertEquals(true, list.isEmpty());
    }
    
    @Test
    public void testOneElement() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        //add 5, peek it, pull head, get null
        list.appendToTail(5);
        
        Assert.assertEquals(Integer.valueOf(5), list.peekHead());
        Assert.assertEquals(Integer.valueOf(5), list.peekTail());
        
        Assert.assertEquals(Integer.valueOf(5), list.pullHead());
        Assert.assertEquals(null, list.peekHead());
        Assert.assertEquals(null, list.peekTail());        
        Assert.assertEquals(null, list.pullHead());
        Assert.assertEquals(null, list.pullTail());
        Assert.assertEquals(true, list.isEmpty());
        
        list.appendToHead(5);
        
        Assert.assertEquals(Integer.valueOf(5), list.peekHead());
        Assert.assertEquals(Integer.valueOf(5), list.peekTail());
        
        Assert.assertEquals(Integer.valueOf(5), list.pullHead());
        Assert.assertEquals(null, list.peekHead());
        Assert.assertEquals(null, list.peekTail());        
        Assert.assertEquals(null, list.pullHead());
        Assert.assertEquals(null, list.pullTail());
        Assert.assertEquals(true, list.isEmpty());
        
        //add 5, peek it, pull tail, get null
        list.appendToTail(6);
        
        Assert.assertEquals(Integer.valueOf(6), list.pullTail());
        Assert.assertEquals(null, list.pullHead());
        Assert.assertEquals(null, list.pullTail());
        Assert.assertEquals(true, list.isEmpty());
        
        list.appendToHead(6);
        
        Assert.assertEquals(Integer.valueOf(6), list.pullTail());
        Assert.assertEquals(null, list.pullHead());
        Assert.assertEquals(null, list.pullTail());
        Assert.assertEquals(true, list.isEmpty());
    }
    
    @Test
    public void testMoreThanOneElement() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.appendToTail(1);
        
        Assert.assertEquals(Integer.valueOf(1), list.peekHead());
        Assert.assertEquals(Integer.valueOf(1), list.peekTail());
        
        list.appendToTail(2);
        
        Assert.assertEquals(Integer.valueOf(1), list.peekHead());
        Assert.assertEquals(Integer.valueOf(2), list.peekTail());
        
        list.appendToTail(3);
        list.appendToTail(4);
        Assert.assertEquals(Integer.valueOf(1), list.peekHead());
        Assert.assertEquals(Integer.valueOf(4), list.peekTail());
        
        Assert.assertEquals(Integer.valueOf(4), list.pullTail());
        Assert.assertEquals(Integer.valueOf(1), list.peekHead());
        Assert.assertEquals(Integer.valueOf(3), list.peekTail());
        
        Assert.assertEquals(Integer.valueOf(1), list.pullHead());
        Assert.assertEquals(Integer.valueOf(2), list.peekHead());
        Assert.assertEquals(Integer.valueOf(3), list.peekTail());
        
        list.appendToHead(1);
        Assert.assertEquals(Integer.valueOf(1), list.pullHead());
        Assert.assertEquals(Integer.valueOf(2), list.peekHead());
        Assert.assertEquals(Integer.valueOf(3), list.peekTail());        
        
        Assert.assertEquals(Integer.valueOf(2), list.pullHead());
        Assert.assertEquals(Integer.valueOf(3), list.peekHead());
        Assert.assertEquals(Integer.valueOf(3), list.peekTail());
        
        Assert.assertEquals(Integer.valueOf(3), list.pullHead());
        Assert.assertEquals(null, list.pullHead());
        Assert.assertEquals(null, list.pullTail());
        Assert.assertEquals(true, list.isEmpty());
    }
    
}
