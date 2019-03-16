package by.epam.javatraining.kutsko.task2.collection;

import java.util.Arrays;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;

public class LinkedList<T> extends AbstractCollection<T> {

	protected static class Node<T> {

		private T element;
		private Node<T> next;
		private Node<T> previous;

		public Node(Node<T> n1, T e, Node<T> n2) {
			previous = n1;
			next = n2;
			element = e;
		}

		public T get() {
			return element;
		}

		public Node<T> previous() {
			return previous;
		}

		public Node<T> next() {
			return next;
		}

		public void setNext(Node<T> nextNode) {
			next = nextNode;
		}

		public void setPrevious(Node<T> prevNode) {
			previous = prevNode;
		}

	}

	protected int size = 0;
	protected Node<T> first;
	protected Node<T> last;

	protected LinkedList() {
		first = new Node<T>(null, null, null);
		last = first;
	}

	protected LinkedList(LinkedList<T> template) {
		this();
		
		if (template != null) {
			Object[] itemSet = new Object[template.size];
			LinkedList<Object> newTemplate = (LinkedList<Object>) template;
			newTemplate.toArray(itemSet);
			for (Object item : itemSet) {
				try {
					add((T) item);
				} catch (CorruptItemReferenceException e) {}
			}
		}
	}

	@Override
	public void clear() {
		first = new Node<T>(null, null, null);
		last = first;
		size = 0;
	}

	@Override
	public void add(T e) throws CorruptItemReferenceException {
		if (e != null) {
			if (first.get() == null) {
				first = new Node<T>(null, e, null);
				last = first;
			} else if (last == first) {
				last = new Node<T>(first, e, null);
				first.setNext(last);
			} else {
				last = new Node<T>(last, e, null);
				Node<T> previous = last.previous();
				previous.setNext(last);
			}
			size++;
		}
		throw new CorruptItemReferenceException("Item reference was null");
	}

	@Override
	public void removeElement(T e) throws CorruptItemReferenceException, NoSuchItemException {
		if (e != null) {
			int deleteCount = 0;
			for (Node<T> x = first; x != null; x = x.next()) {
				if (e.equals(x.get())) {
					Node<T> prev = x.previous();
					Node<T> next = x.next();
					prev.setNext(next);
					next.setPrevious(prev);
					size--;
					deleteCount++;
				}
			}
			if (deleteCount == 0) {
				throw new NoSuchItemException("Item is not in collection");
			}
		} else {
			throw new CorruptItemReferenceException("Item reference was null");
		}
	}

	@Override
	public boolean contains(T e) {
		if ((e != null) && (first != null) && (first.get() != null)) {
			boolean found = false;
			for (Node<T> x = first; x != null; x = x.next()) {
				if (e.equals(x.get())) {
					found = true;
				}
			}
			return found;
		}
		return false;
	}

	@Override
	public T[] toArray(T[] destination) {
		int length = destination.length;
		Node<T> x = first;
		for (int i = 0; i < length; i++) {
			if (x != null) {
				destination[i] = x.get();
				x = x.next();
			} else {
				break;
			}
		}
		return (T[]) destination;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int hashCode() {
		int result = 0;
		final int prime = 31;
		for (Node<T> x = first; x != null; x = x.next()) {
			result += prime * x.get().hashCode();
		}
		return result;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (this == other) {
			return true;
		}
		if (getClass() != other.getClass()) {
			return false;
		}
		LinkedList<T> collection = (LinkedList<T>) other;
		if (collection.size != size) {
			return false;
		}
		Object[] thisTarget = new Object[size];
		Object[] otherTarget = new Object[size];
		return Arrays.deepEquals(toArray((T[]) thisTarget), collection.toArray((T[]) otherTarget));
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Node<T> x = first; x != null; x = x.next()) {
			buffer.append(x.get().toString());
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
