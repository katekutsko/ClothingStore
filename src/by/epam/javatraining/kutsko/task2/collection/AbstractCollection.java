package by.epam.javatraining.kutsko.task2.collection;

public abstract class AbstractCollection<T> implements Collection<T> {
	
	protected int size;
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
}
