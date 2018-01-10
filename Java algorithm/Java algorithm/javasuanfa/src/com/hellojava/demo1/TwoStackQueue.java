package com.hellojava.demo1;

import java.util.Stack;
/**
 * 有两个栈组成队列 ，并且对队列进行基本的操作
 * @author Administrator
 *
 */
public class TwoStackQueue {
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	public TwoStackQueue() {
		this.stackPush = new Stack<Integer>();
		this.stackPop = new Stack<Integer>();
	}
	public void add(int pushInt) {
		this.stackPush.add(pushInt);
	}
	public int poll() {
		if(this.stackPush.empty() && this.stackPop.empty()) {
			throw new RuntimeException("your queue is empty!");
		}else if(this.stackPop.empty()) {
			while(!this.stackPush.empty()) {
				this.stackPop.add(this.stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	public static void main(String[] args) {
		TwoStackQueue tt = new TwoStackQueue();
		tt.add(2);
		tt.poll();
	}
}
