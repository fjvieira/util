package org.vieira.util;

/**
 * A stack able to handle nested transactions based on linked lists, with theoretically unlimited size.
 * @author Fernando José Vieira
 *
 * @param <E> Type to be used in the stack.
 */
public class TransactionStack<E> {

    private DoubleLinkedList<DoubleLinkedList<Transaction<E>>> transactions;

    // current stack
    private DoubleLinkedList<E> stack;

    public TransactionStack() {
        stack = new DoubleLinkedList<>();
        transactions = new DoubleLinkedList<>();
    }

    /**
     * Add a value in the top of the stack.
     * @param value
     */
    public void push(E value) {
        synchronized (stack) {

            stack.appendToTail(value);
            if (!transactions.isEmpty()) {
                transactions.peekTail().appendToTail(new Transaction<>(Transaction.Type.PUSH, value));
            }
        }
    }

    /**
     * Return what is in the top of the stack.
     * @return
     */
    public E top() {
        return stack.peekTail();
    }

    /**
     * Removes and return what was in the top of the stack.
     * @return
     */
    public E pop() {
        synchronized (stack) {
            if (!transactions.isEmpty()) {
                transactions.peekTail().appendToTail(new Transaction<>(Transaction.Type.PULL, stack.pullTail()));
            }
        }
        return stack.pullTail();
    }

    /**
     * Starts a transaction.
     */
    public void beginTransaction() {
        synchronized (stack) {
            transactions.appendToTail(new DoubleLinkedList<>());
        }
    }

    /**
     * Rollbacks the current transaction.
     * @return true if there was an opened transaction.
     */
    public boolean rollbackTransaction() {
        synchronized (stack) {
            if (!transactions.isEmpty()) {
                DoubleLinkedList<Transaction<E>> currentTransaction = transactions.pullTail();

                while (!currentTransaction.isEmpty()) {
                    Transaction<E> transaction = currentTransaction.pullTail();
                    if (Transaction.Type.PUSH == transaction.type) {
                        stack.pullTail();
                    } else {
                        stack.appendToTail(transaction.value);
                    }
                }
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * Commits the current transaction.
     * @return true if there was an opened transaction.
     */
    public boolean commitTransaction() {
        synchronized (stack) {
            if (!transactions.isEmpty()) {
                DoubleLinkedList<Transaction<E>> currentTransaction = transactions.pullTail();
                if (!transactions.isEmpty()) {
                    DoubleLinkedList<Transaction<E>> parentTransactionStack = transactions.peekTail();
                    while (!currentTransaction.isEmpty()) {
                        parentTransactionStack.appendToTail(currentTransaction.pullTail());
                    }
                }
                return true;
            } else {
                return false;
            }
        }
    }

    protected static class Transaction<E> {
        
        enum Type{PUSH, PULL}

        Type type;
        // does not mater in pop
        E value;

        Transaction(Type type, E value) {
            this.type = type;
            this.value = value;
        }

    }

}