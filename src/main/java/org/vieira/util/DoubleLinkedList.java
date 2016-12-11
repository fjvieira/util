package org.vieira.util;

import lombok.AllArgsConstructor;

/**
 * A simple double linked list.
 * @author Fernando José Vieira
 *
 * @param <E> Value type to be used in the list.
 */
public class DoubleLinkedList<E> {

    private Node<E> head;

    private Node<E> tail;

    /**
     * Appends a value to the tail of the list, and head if list head is null.
     * @param value
     */
    public void appendToTail(E value) {
        Node<E> nNode = new Node<>(value, tail, null);
        if (head == null) {
            head = nNode;
        }
        
        if(tail != null) {
            tail.next = nNode;
        } 
        
        tail = nNode;
    }

    /**
     * Appends a value to the taheadil of the list, and tail if list tail is null.
     * @param value
     */
    public void appendToHead(E value) {
        Node<E> nNode = new Node<>(value, null, head);
        if (tail == null) {
             tail = nNode;
        } 
        
        if(head != null) {
            head.previous = nNode;
        } 
        
        head = nNode;
    }
    
    
    public E peekTail() {
        return tail == null? null : tail.value;
    }
    
    public E peekHead() {
        return head == null? null : head.value;
    }
    
    public E pullTail() {
        if(tail == null) {
            return null;
        }        
        Node<E> oldTail = tail;
        tail = oldTail.previous;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        
        
        return oldTail.value;
    }
    
    public E pullHead() {
        if(head == null) {
            return null;
        }
        Node<E> oldHead = head;
        head = head.next;
        if (head != null) {
            head.previous = null;
        } else {
            tail = null;
        }
        
        return oldHead.value;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    @AllArgsConstructor
    protected static class Node<E> {

        E value;

        Node<E> previous;

        Node<E> next;

    }

}
