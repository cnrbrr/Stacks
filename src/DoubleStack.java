
public class DoubleStack implements IDoubleStack {

	Object[] doubleStack; //used to hold the 2 stacks
	Stack stack1;
	Stack stack2;

	public DoubleStack(int arraySize){
		doubleStack = new Object[arraySize];
		stack1 = new Stack(true, doubleStack);//make it move forward ++
		stack2 = new Stack(false, doubleStack);//make it move back --
	}

	@Override
	public IStack getFirstStack() {
		return stack1;
	}

	@Override
	public IStack getSecondStack() {
		return stack2;
	}

}
