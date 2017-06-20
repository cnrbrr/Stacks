
public interface IFactory {
	IStack makeStack(int max, boolean reversed, Object[] Stack);

	IDoubleStack makeDoubleStack(int stack1Size, int stack2Size);

	IPriorityQueue makePriorityQueue();

}
