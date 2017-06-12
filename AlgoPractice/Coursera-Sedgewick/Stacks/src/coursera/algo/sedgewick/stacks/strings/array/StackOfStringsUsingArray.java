package coursera.algo.sedgewick.stacks.strings.array;

import coursera.algo.sedgewick.stacks.Stack;

public class StackOfStringsUsingArray implements Stack<String> {

	private String[] arr;
	private int top;
	
	public StackOfStringsUsingArray() {
		super();
		arr = new String[10];
		top = -1;
	}

	protected void resize(){
		int curSize = arr.length;
		String[] newArr = new String[curSize * 2];
		for(int i=0; i<curSize; i++){
			newArr[i] = arr[i];
		}
		arr = newArr;		
	}
	
	@Override
	public void push(String t) {
		if(top >= arr.length-1){
			resize();
		}
		top++;	
		arr[top] = t;
	}
	
	private void downSize(){
		double dTop = 1.0*top;
		double dLim = 1.0*arr.length/4;
		if(dTop < dLim){
			int size = (top == -1 || top == 0)?10:top*2;
			String[] newArr = new String[size];
			for(int i=0; i<=top; i++){
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
	}

	@Override
	public String pop() {
		if(!isEmpty()){
			String ret = arr[top];
			arr[top] = null;
			top--;
			downSize();
			return ret;
		}
		else{
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public int size() {
		return top+1;
	}

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

}
