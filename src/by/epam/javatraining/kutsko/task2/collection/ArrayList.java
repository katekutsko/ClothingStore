package by.epam.javatraining.kutsko.task2.collection;

import java.util.Arrays;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;

public class ArrayList<T> extends AbstractCollection<T> {

	protected Object[] elements;

	public final static int DEFAULT_CAPACITY = 10;

	protected ArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	protected ArrayList(int capacity) {
		elements = new Object[capacity];
	}

	protected ArrayList(ArrayList<T> collection) {
		super();
		
		if (collection != null) {
			elements = Arrays.copyOf(collection.elements, collection.elements.length);
			size = collection.size;
		}
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
		
		ArrayList<T> collection = (ArrayList<T>) other;
		
		if (size != collection.size) {
			return false;
		}
		
		return Arrays.deepEquals(elements, collection.elements);
	}

	@Override
	public int hashCode() {
		return Arrays.deepHashCode(elements);
	}

	public boolean set(T item, int index) {
		
		if (index >= 0 && index < size) {
			int capacity = elements.length;
			Object[] newArray = new Object[capacity + 1];
			for (int i = 0, j = 0; j < capacity; i++, j++) {
				if (j != index) {
					newArray[i] = elements[j];
				} else {
					newArray[i] = item;
					j--;
				}
			}
			return true;
		} else {
			throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
		}
	}

	public T get(int index) {
		
		if (index >= 0 && index < size) {
			return (T) elements[index];
		} else {
			throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
		}
	}

	public boolean removeAtIndex(int index) throws NoSuchItemException {
		
		if (index >= 0 && index < size) {
			
			int capacity = elements.length;
			
			Object[] newArray = new Object[capacity - 1];
			
			if (index == capacity - 1) {
				for (int i = 0; i < capacity - 1; i++) {
					newArray[i] = elements[i];
				}
			} else {
				for (int i = 0, j = 0; i < capacity - 1; i++, j++) {
					if (j == index) {
						j++;
					}
					newArray[i] = elements[j];
				}
			}
			
			elements = newArray;
			size--;
			return true;
		} else {
			throw new NoSuchItemException("Invalid index: " + index);
		}
	}

	public T replace(T item, int index) {
		if (index >= 0 && index < size) {
			if (item != null) {
				T oldItem = (T) elements[index];
				elements[index] = item;
				return oldItem;
			}
			return null;
		} else {
			throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
		}
	}

	@Override
	public void add(T e) throws CorruptItemReferenceException {
		if (e != null) {
			if (size == elements.length) {
				elements = Arrays.copyOf(elements, size + 1);
			}
			elements[size++] = e;
		} else {
			throw new CorruptItemReferenceException("Item reference was null");
		}
	}

	@Override
	public void removeElement(T e) throws CorruptItemReferenceException, NoSuchItemException {
		if (e != null) {
			int i, deleteCount = 0;
			for (i = 0; i < elements.length; i++) {
				if (e.equals(elements[i])) {
					try {
						removeAtIndex(i);
						deleteCount++;
					} catch (NoSuchItemException ex) {}
				}
			}
			if (deleteCount == 0) {
				throw new NoSuchItemException("Item is not in the collection");
			}
		} else {
			throw new CorruptItemReferenceException("Item reference was null");
		}
	}

	@Override
	public boolean contains(T e) {
		if (e != null) {
			for (Object element : elements) {
				if (e.equals(element)) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	@Override
	public T[] toArray(T[] destination) {
		int length = destination.length;
		if (length != 0) {
			for (int i = 0; i < length; i++) {
				if (i < size) {
					destination[i] = (T) elements[i];
				}
				else {
					destination[i] = null;
				}
			}
		}
		return destination;
	}

	@Override
	public void clear() {
		elements = new Object[0];
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < size; i++) {
			buffer.append(elements[i]);
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
