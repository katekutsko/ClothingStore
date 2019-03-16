package by.epam.javatraining.kutsko.task2.collection;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;

public interface Collection<T> {
	
	int size();
	
	void add(T e) throws CorruptItemReferenceException;
	
	boolean isEmpty();
	
	void removeElement(T e) throws CorruptItemReferenceException, NoSuchItemException;
	
	boolean contains(T e);
	
	T[] toArray(T[] destination);
	
	void clear();
}
