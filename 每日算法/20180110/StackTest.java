package com.java.num5;

import java.util.Stack;
//一个栈元素类型为整数，现在将该栈从顶到底按从大到小的顺序排列，只许额外申请一个栈
public class StackTest {
	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help=new Stack<Integer>();
		while(!stack.isEmpty()) {
			int cur=stack.pop();
			while(!help.isEmpty()&&help.peek()>cur) {
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while(!help.isEmpty()) {
			stack.push(help.pop());
		}

	}
	
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(9);
		stack.push(6);
		
		sortStackByStack(stack);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
//			System.out.println("hahaaha");
		}
	}

}
