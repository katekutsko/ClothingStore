package by.epam.javatraining.kutsko.task2.collection;

public class LinkedQueue<T> extends LinkedList<T> implements Queue<T> {

	
	public LinkedQueue() {
		super();
	}
	
	public LinkedQueue(LinkedQueue<T> queue) {
		super(queue);
	}

	@Override
	public T remove() {
		T currentItem = first.get();
		Node<T> nextNode = first.next();
		if (nextNode != null) {
			T nextItem = nextNode.get();
			Node<T> newNextNode = nextNode.next();
			first = new Node<T>(null, nextItem, newNextNode);
		} else {
			first = null;
		}
		size--;
		return currentItem;
	}

	@Override
	public T element() {
		return first.get();
	}

}
