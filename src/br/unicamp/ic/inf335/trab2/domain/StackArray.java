/**
 * This class implements a Stack using a regular array.
 * <p>
 * A stack is exactly what it sounds like. An element gets added to the top of
 * the stack and only the element on the top may be removed. This is an example
 * of an array implementation of a Stack. So an element can only be added/removed
 * from the end of the array. In theory stack have no fixed size, but with an
 * array implementation it does.
 *
 * @author Modified based on https://github.com/TheAlgorithms/Java
 */
package br.unicamp.ic.inf335.trab2.domain;

public class StackArray {

	/**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The max size of the Stack
     */
    private int maxSize;

    /**
     * The array representation of the Stack
     */
    private int[] stackArray;

    /**
     * The top of the stack
     */
    private int top;

    /**
     * init Stack with DEFAULT_CAPACITY
     */
    public StackArray() {
    	// QDO CRIA COM O DEFAULT_CAPACITY JA CHAMA O SEGUNDO CONSTRUTOR
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Constructor
     *
     * @param size Size of the Stack
     */
    public StackArray(int size) {
        setMaxSize(size);
        stackArray = new int[getMaxSize()];
        top = -1;
    }

    /**
     * Adds an element to the top of the stack
     *
     * @param value The element added
     */
    public void push(int value) {
        if (!isFull()) { // Checks for a full stack
            top++;
            stackArray[top] = value;
        } else {
            resize(getMaxSize() * 2);
            //push(value); // don't forget push after resizing
        }
    }

    /**
     * Removes the top element of the stack and returns the value you've removed
     *
     * @return value popped off the Stack
     */
    public int pop() {
        if (!isEmpty()) { // Checks for an empty stack
            return stackArray[top--];
        } else {
            //System.out.println("The stack is already empty");
            return -1;
        }
    }

    /**
     * Returns the element at the top of the stack
     *
     * @return element at the top of the stack
     */
    public int peek() {
        if (!isEmpty()) { // Checks for an empty stack
            return stackArray[top];
        } else {
            //System.out.println("The stack is empty, cant peek");
            return -1;
        }
    }

    private void resize(int newSize) {
        int[] transferArray = new int[newSize];

        for (int i = 0; i < stackArray.length; i++) {
            transferArray[i] = stackArray[i];
        }
        // This reference change might be nice in here
        stackArray = transferArray;
        setMaxSize(newSize);
    }

    /**
     * Returns true if the stack is empty
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * Returns true if the stack is full
     *
     * @return true if the stack is full
     */
    public boolean isFull() {
        return ( (size() + 1) == getMaxSize());
    }
    
    /**
     * Returns the number of elements in the stack
     *
     * @return the number of elements in the stack
     */
    public int size() {
    	return top;
    }

    /**
     * Deletes everything in the Stack
     * <p>
     * Doesn't delete elements in the array
     * but if you call push method after calling
     * makeEmpty it will overwrite previous
     * values
     */
    public void makeEmpty() { // Doesn't delete elements in the array but if you call
        top = -1;             // push method after calling makeEmpty it will overwrite previous values
    }
    
    /**
     * Retorna o tamanho inicial da pilha
     * @return
     */
	public int getMaxSize() {
		return maxSize;
	}
	
	/**
	 * Define o tamanho inicial para a pilha
	 * @param maxSize
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}