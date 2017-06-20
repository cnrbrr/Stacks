public interface IStack {
	void push(Object element) throws StackOverflowException;
	Object pop() throws StackEmptyException;
	Object top() throws StackEmptyException;
	int size();
	boolean isEmpty();
	void clear();
}

