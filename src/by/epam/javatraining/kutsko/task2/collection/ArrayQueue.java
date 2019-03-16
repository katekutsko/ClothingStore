package by.epam.javatraining.kutsko.task2.collection;

public class ArrayQueue<T> extends ArrayList<T> implements Queue<T> {

	
	public ArrayQueue() {
		super();
	}
	
	public ArrayQueue(ArrayQueue<T> queue) {
		super(queue);
	}
	
	@Override
	public T remove() {
		int length = elements.length;
		if (length != 0) {
			T item = (T) elements[0];
			Object[] temp = new Object[length - 1];
			for (int i = 0; i < length - 1; i++) {
				temp[i] = elements[i + 1];
			}
			size--;
			elements = temp;
			return item;
		}
		return null;
	}

	@Override
	public T element() {
		if (elements.length != 0) {
			return (T) elements[0];
		}
		else {
			return null;
		}
	}

}
