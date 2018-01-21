package com.java.stack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min，push及pop的时间复杂度都是O(1)
 * @date 2018/1/20
 * @author lenovo
 *
 */

/**
 * 两个栈，一个m_data存正常数据，一个m_min存当前栈中的最小值，如果入栈的数字大于最小值，m_min栈继续入当前栈最小值，即m_min栈顶数据
 * @author lenovo
 *
 */
public class MinStack {
	Stack<Integer> m_data;
	Stack<Integer> m_min;
	
	public void push(int num) {
		m_data.push(num);
		if(m_min.size()==0 || m_min.peek()>num) {
			m_min.push(num);
		}else {
			m_min.push(m_min.peek());
		}
	}
	
	public int pop() {
		Integer num=null;
		if(m_data.size()!=0 && m_min.size()!=0) {
			num=m_data.pop();
			m_min.pop();
		}
		return num;
	}
	
	public int min() {
		Integer num=null;
		if(m_data.size()!=0 || m_min.size()!=0)
			num=m_min.pop();
		return num;
	}

}
