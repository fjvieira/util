package org.vieira.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Fernando José Vieira
 *
 */
public class TransactionStackTest {
    
    @Test
    public void testWithoutOpenTransaction() {
        TransactionStack<Integer> stack = new TransactionStack<>();
        
        stack.push(1);
        Assert.assertEquals(Integer.valueOf(1), stack.top());
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(null, stack.pop());
        
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        Assert.assertFalse(stack.commitTransaction()); // there is no open transaction
        Assert.assertFalse(stack.rollbackTransaction()); // there is no open transaction
        
        Assert.assertEquals(Integer.valueOf(4), stack.top());
        Assert.assertEquals(Integer.valueOf(4), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.top());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.top());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        
        Assert.assertEquals(null, stack.pop());
    }

    @Test
    public void testTransaction() {
        TransactionStack<Integer> stack = new TransactionStack<>();
        stack.push(1);
        stack.beginTransaction(); // start transaction 1
        stack.push(3);
        stack.beginTransaction(); // start transaction 2
        stack.push(2);
        Assert.assertTrue(stack.rollbackTransaction()); // rollback transaction 2
        Assert.assertEquals(Integer.valueOf(3), stack.top());
        stack.beginTransaction(); // start transaction 3
        stack.push(10);
        Assert.assertTrue(stack.commitTransaction()); // transaction 3 is committed
        Assert.assertEquals(Integer.valueOf(10), stack.top());
        Assert.assertTrue(stack.rollbackTransaction()); // rollback transaction 1
        Assert.assertEquals(Integer.valueOf(1), stack.top());        
        Assert.assertFalse(stack.commitTransaction());
        stack.pop();
        Assert.assertNull(stack.top());
        
    }
    
}
