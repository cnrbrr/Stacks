
public abstract class Factory implements IFactory{


	public IStack makeStack(int max, boolean reversed, Object[] Stack){
		return new Stack(reversed, Stack);
	}

	public IDoubleStack makeDoubleStack(int arraySize){
		return new DoubleStack(arraySize);
	}

	public IPriorityQueue makePriorityQueue(int max){
		return new PriorityQueue(max);
	}
}
