package coursera.algo.sedgewick.stacks.infixoperation;

import coursera.algo.sedgewick.stacks.Stack;
import coursera.algo.sedgewick.stacks.generics.array.StackOfGenericsUsingArray;
import coursera.algo.sedgewick.stacks.strings.array.StackOfStringsUsingArray;

public class DijkstraTwoStackInfixMathOperation {
	
	private Stack<String> operatorStack;
	private Stack<Double> operandStack;
	
	public DijkstraTwoStackInfixMathOperation() {
		super();
		operandStack = new StackOfGenericsUsingArray<>();
		operatorStack = new StackOfStringsUsingArray();
	}
	
	private boolean verify(String expression){
		//return verifyBrackets(expression);
		return true;
	}
	
	private boolean verifyBrackets(String expression){
		int leftBracketCount = 0;
		int rightBracketCount = 0;
		String tokens[] = expression.split(" ");
		for(String each: tokens){
			if(isLeftBracket(each)){
				leftBracketCount++;
			}
			else if(isRightBracket(each)){
				rightBracketCount++;
			}
		}
		return (leftBracketCount == rightBracketCount);
	}
	
	private boolean isLeftBracket(String c){
		return c.trim().equals("(");
	}
	
	private boolean isRightBracket(String c){
		return c.trim().equals(")");
	}
	
	private boolean isOperator(String c){
		return (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"));
	}
	
	private boolean isOperand(String x){
		try{
			Double.parseDouble(x);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
	
	private double operate(double operand1, double operand2, String operator){
		//System.out.println(operand2+operator+operand1);
		if(operator.equals("+")){
			return operand2 + operand1;
		}
		else if(operator.equals("-")){
			return operand2 - operand1;
		}
		else if(operator.equals("*")){
			return operand2 * operand1;
		}
		else if(operator.equals("/")){
			return operand2 / operand1;
		}
		else{
			throw new IllegalArgumentException("Incorrect operator - "+operator);
		}
	}
	
	/*
	 * Assume that each operand, operator and bracket is separated by a SPACE character.
	 */
	public double doMath(String expression){
		if(verify(expression)){
			String[] tokens = expression.split(" ");
			for(String each: tokens){
				if(isOperand(each)){
					operandStack.push(Double.parseDouble(each));
				}
				if(isOperator(each)){
					operatorStack.push(each);
				}
				if(isRightBracket(each)){
					double result = operate(operandStack.pop(), operandStack.pop(), operatorStack.pop());
					operandStack.push(result);
				}
			}
			double ret = operandStack.pop();
			if(operandStack.isEmpty()){
				return ret;
			}
			else{
				throw new RuntimeException("Something went wrong. Please check your expression again - "+expression);
			}
		}
		else{
			throw new IllegalArgumentException("Incorrect expression [ "+expression+" ] provided.");
		}
	}
	
	public static void main(String args[]){
		DijkstraTwoStackInfixMathOperation op = new DijkstraTwoStackInfixMathOperation();
		String expression = " ( 1 + ( ( ( 2 * 3 ) + ( 43.2 + 2.8 ) ) - ( 3 * 17 ) ) ) ";
		System.out.println(expression);
		System.out.println(op.doMath(expression));
	}

}
