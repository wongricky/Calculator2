package com.calculator;

import java.util.ArrayList;

public class Calculator implements java.io.Serializable {
	private static double answer;
	private static ArrayList<Double> operand = new ArrayList<Double>();
	private static ArrayList<String> operation = new ArrayList<String>();

	
	public Calculator() {
		
	}
	
	public ArrayList<Double>operand(){
		return operand;
	}
	
	public ArrayList<String>operation(){
		return operation;
	}
	
	
	public void performOperation(double number) {
		operand.add(number);
	}
	public void performOperation(String operator) {
		operation.add(operator);
	}
	
	public void getResults() {
		System.out.println("Here is the answer: " + operand);
	}
	
	
	
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.performOperation(10.5);
		calc.performOperation("+");
		calc.performOperation(5.2);
		calc.performOperation("*");
		calc.performOperation(10);
		calc.performOperation("+");
		calc.performOperation(5);
		calc.performOperation("-");
		calc.performOperation(2);
		calc.performOperation("=");
	
		
		for(int i = 0; i < operation.size(); i ++) {
			if (operation.get(i) == "*" || operation.get(i) == "/") {
				if (operation.get(i) == "*") {
					answer = operand.get(i) * operand.get(i + 1);
				}
				else if (operation.get(i) == "/") {
					answer = operand.get(i) / operand.get(i + 1);
				}
				operand.set(i + 1, answer);
				operand.remove(i);
				operation.remove(i);
			}
		}
		for(int i = 0; i < operation.size(); i ++) {
			i = 0;
			if (operation.get(i) == "+" || operation.get(i) == "-") {
				if (operation.get(i) == "+") {
					answer = operand.get(i) + operand.get(i + 1);
				}
				else if (operation.get(i) == "-") {
					answer = operand.get(i) - operand.get(i + 1);
				}
				operand.set(i + 1, answer);
				operand.remove(i);
				operation.remove(i);
			}
		}
		
		if (operation.get(0) == "=") {
			System.out.println("Here is the answer: " + calc.operand());
		}
		
		
		}
	
}
