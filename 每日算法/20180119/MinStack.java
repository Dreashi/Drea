package com.java.stack;

import java.util.Stack;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min�������ڸ�ջ�У�����min��push��pop��ʱ�临�Ӷȶ���O(1)
 * @date 2018/1/20
 * @author lenovo
 *
 */

/**
 * ����ջ��һ��m_data���������ݣ�һ��m_min�浱ǰջ�е���Сֵ�������ջ�����ִ�����Сֵ��m_minջ�����뵱ǰջ��Сֵ����m_minջ������
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
