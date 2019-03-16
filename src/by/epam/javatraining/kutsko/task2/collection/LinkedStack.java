package by.epam.javatraining.kutsko.task2.collection;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;

public class LinkedStack<T> extends LinkedList<T> implements Stack<T> {

	
	public LinkedStack(){
		super();
	}

	
	public LinkedStack(LinkedList<T> stack){
		super(stack);
	}
	
	@Override
	public void push(T e) throws CorruptItemReferenceException {
			super.add(e);
	}

	@Override
	public T pop() {
		T item = last.get();
		last = last.previous();
		last.setNext(null);
		size--;
		return item;
	}

	@Override
	public T peek() {
		return last.get();
	}

}
