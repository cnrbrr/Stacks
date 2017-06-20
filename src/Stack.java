import java.lang.reflect.Method;
import java.util.Arrays;


public class Stack implements IStack{

	int bottom = 0; //first value in the double stack
	boolean forward;//checks which way to process the stack
	Object[] Stacker; //holder for the stack
	int top;//current head of the stack

	int meeting; //size of the array

	public Stack(boolean forward, Object[] Stacker){
		this.forward = forward;
		this.Stacker = Stacker;
		if(forward){ //if true move forward
			top = bottom - 1;
		}else{ //if false move back
			top = Stacker.length;
		}		
	}


	@Override
	public void push(Object element) throws StackOverflowException {

		if(forward){ 
			top++; //increase the size of top if true
			if(Stacker[top] != null){ //check if null
				throw new StackOverflowException(); //if adding to where already added throw exception
			} else {
				if(element == null){//if adding a null dont change top
					top--;
				} else {//not null increase size of stack
					meeting++;
				}
			}
			if(top < 0){ 
				Stacker[0] = element;
			} else {
				Stacker[top] = element; //set the new value of top
			}

		}

		if(!forward){ //similar to above but in reverse
			top--;
			if(Stacker[top] != null){
				throw new StackOverflowException();
			} else {
				if(element == null){
					top++;
				} else {
					meeting++;
				}

			}
			if(top > Stacker.length - 1){
				Stacker[Stacker.length - 1] = element;
			} else {
				Stacker[top] = element;
			}	
		}
	}

	@Override
	public Object pop() throws StackEmptyException {
		if(forward){
			if(top < bottom){//if < 0
				throw new StackEmptyException();
			}
			Object tempPop1 = Stacker[top];//holds a temp value
			Stacker[top] = null;//set at null
			top--;//decrease the size of top
			meeting--;//decrease the size of the stack value
			return tempPop1;//return the value which was removed
		} else{
			if(top >= Stacker.length){//same as above but in reverse
				throw new StackEmptyException();
			}
			Object tempPop2 = Stacker[top];
			Stacker[top] = null;
			top++;
			meeting--;
			return tempPop2;
		}
	}

	@Override
	public Object top() throws StackEmptyException {
		if(forward){ //check if there is anything in the stack
			if(top < bottom || meeting == 0){
				throw new StackEmptyException();
			}
			return Stacker[top];//return the head value
		} else {
			if(top >= Stacker.length){//same as above but in reverse
				throw new StackEmptyException();
			}
			return Stacker[top];
		}
	}

	@Override
	public int size() {
		if(Stacker.length == 0){
			return 0; //if it is 0 return 0
		}

		return meeting; //return the size of the stack

	}

	@Override
	public boolean isEmpty() {
		if(top < bottom){//if <0
			return true;
		}

		if(top >= meeting){//if>max
			return true;
		}

		if(meeting == 0){
			return true;
		}

		return false;//or return false
	}

	@Override
	public void clear() { //delete everything in the stack
		meeting = 0;
		if(forward){
			for(int i = 0; i < meeting; i++){
				Stacker[i] = null;
			}
			top = -1;

		} else {
			for(int i = Stacker.length - 1; i > Stacker.length - meeting - 1; i--){
				Stacker[i] = null;
			}
			top = Stacker.length;
		}

	}

}
