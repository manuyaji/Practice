package coursera.algo.sedgewick.stacks.strings.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import coursera.algo.sedgewick.stacks.Stack;
import coursera.algo.sedgewick.stacks.strings.array.StackOfStringsUsingArray;
import coursera.algo.sedgewick.stacks.strings.linkedlist.StackOfStringsUsingLinkedList;

@RunWith(Parameterized.class)
public class JunitTestSet {

	Stack<String> stackOfStrings;

	public JunitTestSet(Stack<String> stackOfStrings) {
		super();
		this.stackOfStrings = stackOfStrings;
	}
	
	@Test
	public void test1(){
		
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> initializeParameters(){
		return Arrays.asList(
				new Object[]{new StackOfStringsUsingArray()},
				new Object[]{new StackOfStringsUsingLinkedList()}
				);
	}
	
}