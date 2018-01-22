package com.java.num17;

import java.util.Stack;

/**
 * ����һ�������ͷ��㣬�жϸ������Ƿ�Ϊ������
 * @date 2018/1/22
 * @author lenovo
 *
 */

public class Test {
	
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val=val;
		}
	}
	
	//����һ����һ������ջ��ÿ���ڵ���ȥ����һ�γ�ջ��ԭ������бȽ�
	public static boolean isPalindrome1(ListNode head) {
		Stack<ListNode> stack=new Stack<ListNode>();
		ListNode cur=head;
		while(cur!=null) {
			stack.add(cur);
			cur=cur.next;
		}
		
		while(!stack.isEmpty()) {
			if(head.val!=stack.pop().val)
				return false;
			head=head.next;
		}
		return true;
	}
	
	//�ⷨ�����������һ�����ջ�У��ٳ�ջ����һ����бȽ�
	public static boolean isPalindrome2(ListNode head) {
		if(head==null || head.next==null)
			return true;
		ListNode cur=head;
		ListNode right=head.next;
		Stack<ListNode> stack=new Stack<ListNode>();
		//�õ�������Ұ�ߵĲ���
		while(cur.next!=null && cur.next.next!=null) {
			right=right.next;
			cur=cur.next.next;
		}
		//�Ұ����ջ
		while(right!=null) {
			stack.push(right);
			right=right.next;
		}
		//�Ұ�߳�ջ�����߱Ƚ�
		while(!stack.isEmpty()) {
			if(head.val!=stack.pop().val)
				return false;
			head=head.next;
		}
		return true;	
	}
	
	//���Ƽ����ⷨ������������а벿�ַ�ת�����������м����ν��бȽϣ��Ƚ�����ٰ�����ԭ
	public static boolean isPalindrome3(ListNode head) {
		if(head==null || head.next==null)
			return true;
		//�ҵ��м�ڵ�
		ListNode n1=head;
		ListNode n2=head;
		while(n2.next!=null && n2.next.next!=null) {
			n1=n1.next;
			n2=n2.next.next;
		}
		//��ת������а벿��
		n2=n1.next;
		ListNode n3=null;
		n1.next=null;
		while(n2!=null) {
			n3=n2.next;
			n2.next=n1;
			n1=n2;
			n2=n3;
		}
		n3=n1;
		n2=head;
		while(n2!=null && n3!=null) {
			if(n2.val!=n3.val) {
				return false;
			}
			n2=n2.next;
			n3=n3.next;
		}
		//��������а벿�ֻ�ԭ
		n2=n1.next;
		n1.next=null;
		while(n2!=null) {
			n3=n2.next;
			n2.next=n1;
			n1=n2;
			n2=n3;
		}
		return true;
		
	}
	
	
		public static void main(String[] args) {
			ListNode node1=new ListNode(1);
			ListNode node2=new ListNode(2);
			ListNode node3=new ListNode(3);
			ListNode node4=new ListNode(2);
			ListNode node5=new ListNode(1);
			
			node1.next=node2;
			node2.next=node3;
			node3.next=node4;
			node4.next=node5;
			
			System.out.println(isPalindrome3(node1));
		}

}
