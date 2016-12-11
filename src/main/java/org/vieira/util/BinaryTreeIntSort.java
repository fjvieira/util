package org.vieira.util;

/**
 * This util class provides sorting of an int array in ascending and descending way using a binary tree.
 * @author Fernando José Vieira
 *
 */
public final class BinaryTreeIntSort {

    private static class Node {

        private Node left;

        private Node right;

        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

    }

    private static Node generateBinaryTree(int[] a) {
        Node root = new Node(a[0]);
        for (int i = 1; i < a.length; i++) {
            insertNode(a[i], root);
        }
        return root;
    }

    private static void insertNode(int value, Node parent) {
        if (value < parent.getValue()) {
            if (parent.getLeft() != null) {
                insertNode(value, parent.getLeft());
            } else {
                parent.setLeft(new Node(value));
            }
        } else {
            if (parent.getRight() != null) {
                insertNode(value, parent.getRight());
            } else {
                parent.setRight(new Node(value));
            }
        }
    }

    private static int transverseAscending(int[] a, int pos, Node node) {
        if (node.getLeft() != null) {
            pos = transverseAscending(a, pos, node.getLeft());
        }
        a[pos++] = node.getValue();

        if (node.getRight() != null)
            pos = transverseAscending(a, pos, node.getRight());

        return pos;
    }

    private static int transverseDescending(int[] a, int pos, Node node) {
        if (node.getRight() != null)
            pos = transverseDescending(a, pos, node.getRight());

        a[pos++] = node.getValue();

        if (node.getLeft() != null) {
            pos = transverseDescending(a, pos, node.getLeft());
        }

        return pos;
    }
    
    /**
     * Sorts a given array in ascending order.
     * @param a The array to be sorted
     * @return Ascending sorted array.
     * @throws ArrayIndexOutOfBoundsException if array size is zero.
     * @throws NullPointerException if array pointer is null.
     */
    public static int[] sortArrayAscending(int[] a) {
        Node root = generateBinaryTree(a);

        int[] sortedArray = new int[a.length];
        
        transverseAscending(sortedArray, 0, root);

        return sortedArray;
    }
    
    /**
     * Sorts a given array in descending order.
     * @param a The array to be sorted
     * @return Descending sorted array.
     * @throws ArrayIndexOutOfBoundsException if array size is zero.
     * @throws NullPointerException if array pointer is null.
     */
    public static int[] sortArrayDescending(int[] a) {
        Node root = generateBinaryTree(a);

        int[] sortedArray = new int[a.length];
        
        transverseDescending(sortedArray, 0, root);

        return sortedArray;
    }
    
}
