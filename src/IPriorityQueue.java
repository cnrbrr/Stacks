
public interface IPriorityQueue {
	void enqueue(Comparable element) throws QueueFullException;
	Comparable dequeue() throws QueueEmptyException;
	int size();
	boolean isEmpty();
	void clear();
}