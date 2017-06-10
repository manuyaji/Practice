package coursera.algo.sedgewick.stacks.generics.array;

import java.util.Iterator;

import coursera.algo.sedgewick.stacks.Stack;

public class StackOfGenericsUsingArray<T> implements Stack<T>,Iterable<T> {

	private T[] arr;
	private int top;
	
	public StackOfGenericsUsingArray() {
		super();
		arr = (T[])new Object[10];
		top = -1;
	}

	protected void resize(){
		int curSize = arr.length;
		T[] newArr = (T[])new Object[curSize * 2];
		for(int i=0; i<curSize; i++){
			newArr[i] = arr[i];
		}
		arr = newArr;		
	}
	
	@Override
	public void push(T t) {
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
			T[] newArr = (T[])new Object[top*2];
			for(int i=0; i<=top; i++){
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
	}

	@Override
	public T pop() {
		if(!isEmpty()){
			T ret = arr[top];
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
	
	@Override
	public Iterator<T> iterator() {
		return new StackOfGenericsArrayIterator();
	}

	private class StackOfGenericsArrayIterator implements Iterator<T>{
		
		private int index=top;
		
		@Override
		public boolean hasNext() {
			return (index >= 0);
		}

		@Override
		public T next() {
			if(index >= 0){
				return arr[index--];
			}
			throw new IndexOutOfBoundsException();
		}

		
	}

}
