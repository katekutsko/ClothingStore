package by.epam.javatraining.kutsko.task2.collection;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;

public interface Stack<T> extends Collection<T> {

	void push(T e) throws CorruptItemReferenceException;
	T pop();
	T peek();
}
