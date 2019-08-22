package com.murali.ds.collection;

public class Stack<E> {

	private int maxSize;
	private int top;
	private Object[] element;

	public Stack(int size) {
		maxSize = size;
		element = new Object [maxSize];
		top = -1;
	}

	public void push(E e) {
		top++;
		element[top] = e;
	}

	public E pop() {
		E val = (E) element[top];
		remove();
		top--;
		return val;
	}

	public E peek() {
		return (E) element[top];
	}

	private void remove() {
		element[top] = null;
	}
}