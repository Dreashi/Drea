package com.hellojava.demo2;

import java.util.Stack;
/**
 * 用一个栈实现另一个站的排序（由大到小）
 * @author Administrator
 *
 */
public class StackTest {
	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<>();
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			while(!help.isEmpty() && help.peek()>cur) {
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while(!help.isEmpty()) {
			stack.push(help.pop());
			System.out.println(stack.pop());
		}
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		StackTest test = new StackTest();
		test.sortStackByStack(stack);
	}
}
