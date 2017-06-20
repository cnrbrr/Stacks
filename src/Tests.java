import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
public class Tests extends AbstractTest{

	@Test
	public void normalStack(){ 
		//this test checks the double stack works normally

		IDoubleStack doubleStack = new DoubleStack(10);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();



		try {
			stack1.push("1");
			stack2.push("1");
			stack1.push("2");
			stack2.push("2");
			stack1.push("3");
			stack2.push("3");
			stack1.push("4");
			stack2.push("4");
			stack1.push("5");
			stack2.push("5");
		} catch (StackOverflowException e) {
		}
		assertTrue(stack1.size() == 5);
		assertTrue(stack2.size() == 5);
	}

	@Test
	public void normalStack2(){
		//same as normal stack but reverses the order
		IDoubleStack doubleStack = new DoubleStack(10);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();

		for(int i = 0; i < 5; i++){
			try {
				stack2.push("hello");
				stack1.push("hello");
			} catch (StackOverflowException e) { 
			}

		}

		assertTrue(stack1.size() == 5);
		assertTrue(stack2.size() == 5);
	}

	@Test(expected=StackOverflowException.class)
	public void OverLoadStacks() throws StackOverflowException{
		//overloads the stack
		IDoubleStack doubleStack = new DoubleStack(10);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();

		for(int i = 0; i < 7; i++){
			stack2.push(i);			
		}

		for(int i = 0; i < 4; i++){
			stack1.push(i);			
		}		
	}

	@Test(expected=StackOverflowException.class)
	public void OverLoadStacks2() throws StackOverflowException{
		//overloads the stack but changes order
		IDoubleStack doubleStack = new DoubleStack(10);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();

		for(int i = 0; i < 4; i++){
			stack1.push(i);			
		}	

		for(int i = 0; i < 7; i++){
			stack2.push(i);			
		}	
	}

	@Test
	public void pushNull() throws StackOverflowException{
		//how does the program handle a null
		IDoubleStack doubleStack = new DoubleStack(10);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();

		stack1.push(null);			
		stack2.push(null);			

		assertTrue(stack1.isEmpty());
		assertTrue(stack2.isEmpty());
	}

	@Test
	public void unfilledStack(){
		//checks if the stack works without being completely full
		IDoubleStack doubleStack = new DoubleStack(10);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();


		try {
			stack1.push("1");
			stack2.push("1");
			stack1.push("2");
			stack2.push("2");
			stack1.push("3");
			stack2.push("3");
			stack1.push("4");

		} catch (StackOverflowException e) {
		}
		assertTrue(stack1.size() == 4);
		assertTrue(stack2.size() == 3);
	}

	@Test
	public void normalStackPop(){
		//adds and pops
		IDoubleStack doubleStack = new DoubleStack(4);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();


		try {
			stack1.push("1");
			stack2.push("1");
			stack1.push("2");
			stack2.push("2");
			stack1.pop();


		} catch (StackOverflowException e) {
		} catch (StackEmptyException e) {
		}

		assertTrue(stack1.size() == 1);
		assertTrue(stack2.size() == 2);
	}

	@Test
	public void pop(){
		//checks the return value of the pop
		IDoubleStack doubleStack = new DoubleStack(4);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();
		Object obj = null;

		try {
			stack1.push("1");
			stack2.push("1");
			stack1.push("2");
			stack2.push("2");
			obj = stack1.pop();


		} catch (StackOverflowException e) {
		} catch (StackEmptyException e) {
		}

		assertTrue(obj.equals("2"));

	}

	@Test(expected=StackEmptyException.class)
	public void popFail() throws StackEmptyException{
		//pop when empty
		IDoubleStack doubleStack = new DoubleStack(4);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();
		stack1.pop();

	}

	@Test(expected=StackEmptyException.class)
	public void popFail2() throws StackEmptyException, StackOverflowException{
		//pop until past empty
		IDoubleStack doubleStack = new DoubleStack(4);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();
		stack1.push("hello");
		stack1.pop();
		stack1.pop();

	}

	@Test
	public void top() throws StackEmptyException{
		//checks the top value
		IDoubleStack doubleStack = new DoubleStack(10);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();


		try {
			stack1.push("1");
			stack2.push("1");
			stack1.push("2");
			stack2.push("2");
			stack1.push("3");
			stack2.push("3");
			stack1.push("4");
			stack2.push("4");
			stack1.push("5");
			stack2.push("5");
		} catch (StackOverflowException e) {
		}
		assertTrue(stack1.top().equals("5"));
	}

	@Test
	public void clear() throws StackEmptyException{
		//checks the clear
		IDoubleStack doubleStack = new DoubleStack(10);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();


		try {
			stack1.push("1");
			stack2.push("1");
			stack1.push("2");
			stack2.push("2");
			stack1.push("3");
			stack2.push("3");
			stack1.push("4");
			stack2.push("4");
			stack1.push("5");
			stack2.push("5");
			stack1.clear();
		} catch (StackOverflowException e) {
		}
		assertTrue(stack1.size() == 0);
		assertTrue(stack2.size() == 5);

	}

	@Test
	public void clear2() throws StackEmptyException{

		IDoubleStack doubleStack = new DoubleStack(10);
		IStack stack1 = doubleStack.getFirstStack();
		IStack stack2 = doubleStack.getSecondStack();


		try {
			stack1.push("1");
			stack2.push("1");
			stack1.push("2");
			stack2.push("2");
			stack1.push("3");
			stack2.push("3");
			stack1.push("4");
			stack2.push("4");
			stack1.push("5");
			stack2.push("5");
			stack1.clear();
			stack2.clear();
		} catch (StackOverflowException e) {
		}
		assertTrue(stack1.size() == 0);
		assertTrue(stack2.size() == 0);

	}

	@Test
	public void priorityNormal(){
		IPriorityQueue pQ = new PriorityQueue(4);

		try {
			pQ.enqueue(2);
			pQ.enqueue(3);
			pQ.enqueue(4);
			pQ.enqueue(5);
		} catch (QueueFullException e) {
		}

		assertTrue(pQ.size() == 4);

	}

	@Test
	public void priorityDeQueue(){
		IPriorityQueue pQ = new PriorityQueue(4);
		Comparable x = 0;
		try {
			pQ.enqueue(2);
			pQ.enqueue(3);
			pQ.enqueue(5);
			pQ.enqueue(4);
			x = pQ.dequeue();
		} catch (QueueFullException e) {
		} catch (QueueEmptyException e){
		}

		assertTrue(pQ.size() == 3);
		assertTrue((int) x == 5);

	}

	@Test
	public void priorityEmpty(){
		IPriorityQueue pQ = new PriorityQueue(4);

		assertTrue(pQ.isEmpty());

	}

	@Test
	public void priorityEmpty2(){
		IPriorityQueue pQ = new PriorityQueue(4);

		try {
			pQ.enqueue(2);
			pQ.enqueue(3);
			pQ.enqueue(5);
			pQ.enqueue(4);
			pQ.dequeue();
		} catch (QueueFullException e) {
		} catch (QueueEmptyException e){
		}

		assertFalse(pQ.isEmpty());

	}

	@Test
	public void priorityClear(){
		IPriorityQueue pQ = new PriorityQueue(4);

		try {
			pQ.enqueue(2);
			pQ.enqueue(3);
			pQ.enqueue(5);
			pQ.enqueue(4);
			pQ.dequeue();
			pQ.clear();
		} catch (QueueFullException e) {
		} catch (QueueEmptyException e){
		}

		assertTrue(pQ.isEmpty());		
	}

	@Test(expected=QueueFullException.class)
	public void priorityOverFlow() throws QueueFullException{
		IPriorityQueue pQ = new PriorityQueue(2);

		pQ.enqueue(2);
		pQ.enqueue(3);
		pQ.enqueue(5);

	}

}
