package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java.util.ArrayList;

import util.Stack;

public class ExpressionConvertor {

	static String expression = "( A + B ) * C - ( D - E ) * ( F + G )";
	static HashMap<String,Integer> operatorPrecedence = new HashMap<>(); 
	static Stack<String> operatorsList =  new Stack<>(new ArrayList<String>());
	static Stack<String> operandsList =  new Stack<>(new ArrayList<String>());
	
	public ExpressionConvertor(){
		//operatorPrecedence = new HashMap<>();
		
		
		//operatorsList = new Stack<>(new ArrayList<String>());
		//operandsList = new Stack<>(new ArrayList<String>());
	}
	public static void main(String[] args) throws Exception {		
		
		fillPrecedence();
		infixToPostFixConvertor();
	}
	
	public static void infixToPostFixConvertor() throws Exception{
		
		List<String> splitExpressions =  Arrays.asList(expression.split(" "));
		
		
		for(String split : splitExpressions){
			
			if(checkIfOperator(split)){		
				
				String previousOperator = operatorsList.peek();
				if(previousOperator == null){
					operatorsList.push(split);
				}else{
					// check if close )
					if(split.equals("(")){
						operatorsList.push(split);
					}
					else if(split.equals(")")){
						
						combineAllExpressions();
						operatorsList.pop();
					}else{
						if(getOperatorPrecedence(previousOperator) >= getOperatorPrecedence(split)){
							formPostFixExpression();
						}
						
						operatorsList.push(split);
						
					}
				}				
			}else{
				operandsList.push(split);
			}
		}
		
		combineAllExpressions();
		System.out.println(operandsList.peek());
	}
	
	private static boolean checkIfOperator(String operator){
		
		if(operatorPrecedence.get(operator) != null){
			return true;
		}else{		
			return false;
		}
	}
	
	private static Integer getOperatorPrecedence(String operator){
		
		return operatorPrecedence.get(operator);
	}
	
	private static void formPostFixExpression() throws Exception{
		String rightOperand = operandsList.pop();
		String leftOperand = operandsList.pop();
		String temp = leftOperand +" "+ rightOperand +" "+ operatorsList.pop();
		operandsList.push(temp);
	}
	
	private static void combineAllExpressions() throws Exception{
		
		while(operatorsList.peek() != null && !operatorsList.peek().equals("(")){
			formPostFixExpression();
		}
	}
	
	private static void fillPrecedence(){
		operatorPrecedence.put("^",4);
		operatorPrecedence.put("/",3);
		operatorPrecedence.put("*",3);
		operatorPrecedence.put("+",2);
		operatorPrecedence.put("-",2);
		operatorPrecedence.put("(",0);
		operatorPrecedence.put(")",0);
	}
}
