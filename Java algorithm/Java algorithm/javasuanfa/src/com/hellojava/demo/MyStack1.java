package com.hellojava.demo;

import java.util.Stack;

import javax.management.RuntimeErrorException;

public class MyStack1 {
	private  Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public MyStack1(){
		this.stackData=new Stack<Integer>();
		this.stackMin=new Stack<Integer>();
	}
	public void push(int newNum) {
		if(this.stackMin.empty()) {
			this.stackMin.push(newNum);
		}else if(newNum<=this.getmin()) {
			 this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
		//System.out.println(this.stackMin.empty());
	}
	public int pop() {
		if(this.stackData.empty()) {
			throw new RuntimeException("this stak is empty!");
		}
		int value = this.stackData.pop();
		if(value==this.getmin()) {
			this.stackMin.pop();
		}
		//System.out.println(value);
		return value;
	}
	public int getmin() {
		if(this.stackMin.empty()) {
			throw new RuntimeException("your stack is empty!");
		}
		//peek()是求一个栈中的最小值
		System.out.println(this.stackMin.peek());
		return this.stackMin.peek();
		
	}
	public static void main(String[] args) {
		MyStack1 mystack = new MyStack1();
		mystack.push(3);
		mystack.push(2);
		mystack.push(1);
		mystack.pop();
	}
}
