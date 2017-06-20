import java.util.ArrayList;


public class PriorityQueue implements IPriorityQueue{
	int size = 0; //size of the queue currently
	int maxSize; //max size of the queue
	ArrayList<Comparable> priorityQueue = new ArrayList<Comparable>();//stores the queue

	public PriorityQueue(int max){
		this.maxSize = max; //sets the max size
	}

	@Override
	public void enqueue(Comparable element) throws QueueFullException {
		if(size < maxSize){
			priorityQueue.add(element);
			size++;
		}else{//if bigger than max throw exception
			throw new QueueFullException();
		}
	}

	@Override
	public Comparable dequeue() throws QueueEmptyException {
		if(size == 0){//if nothing to dequeue throw exception
			throw new QueueEmptyException();
		}
		Comparable big = priorityQueue.get(0);//current value to send off
		int bigLocation = 0;//location of value
		for(int j = 0; j < size; j++){
			if(priorityQueue.get(j).compareTo(big) > 0){
				big = priorityQueue.get(j);
				bigLocation = j;
			}
		}

		priorityQueue.remove(bigLocation);//remove from queue
		size--;//decrease size by 1
		return big;//return value
	}

	@Override
	public int size() {
		return size;//return current size of the queue
	}

	@Override
	public boolean isEmpty() {
		if(size == 0){//if nothing in the queue then true
			return true;
		}
		return false;
	}

	@Override
	public void clear() {//clears the queue
		priorityQueue.clear();
		size = 0;		
	}

}
