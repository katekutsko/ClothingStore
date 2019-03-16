package by.epam.javatraining.kutsko.task2.collection;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;

public class ArrayStack<T> extends ArrayList<T> implements Stack<T> {
	
	@Override
	public void push(T e) throws CorruptItemReferenceException {
		super.add(e);
	}

	@Override
	public T pop() {
		int length = elements.length;
		
		if (length != 0 && size != 0) {
			T item = (T) elements[size - 1];
			Object[] temp = new Object[length - 1];
			
			for (int i = 0; i < length - 1; i++) {
				temp[i] = elements[i];
			}
			
			size--;
			elements = temp;
			return item;
		}
		
		return null;
	}

	@Override
	public T peek() {
		int length = elements.length;
		
		if (length != 0) {
			return (T) elements[length - 1];
		}
		
		return null;
	}

}
