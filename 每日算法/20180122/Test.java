package com.java.num17;

import java.util.Stack;

/**
 * 给定一个链表的头结点，判断该链表是否为回文链
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
	
	//方法一：用一个辅助栈把每个节点存进去，再一次出栈于原链表进行比较
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
	
	//解法二：将链表的一半存入栈中，再出栈与另一半进行比较
	public static boolean isPalindrome2(ListNode head) {
		if(head==null || head.next==null)
			return true;
		ListNode cur=head;
		ListNode right=head.next;
		Stack<ListNode> stack=new Stack<ListNode>();
		//得到链表的右半边的部分
		while(cur.next!=null && cur.next.next!=null) {
			right=right.next;
			cur=cur.next.next;
		}
		//右半边入栈
		while(right!=null) {
			stack.push(right);
			right=right.next;
		}
		//右半边出栈与左半边比较
		while(!stack.isEmpty()) {
			if(head.val!=stack.pop().val)
				return false;
			head=head.next;
		}
		return true;	
	}
	
	//（推荐）解法三：把链表的有半部分反转，从两边向中间依次进行比较，比较完后再把链表还原
	public static boolean isPalindrome3(ListNode head) {
		if(head==null || head.next==null)
			return true;
		//找到中间节点
		ListNode n1=head;
		ListNode n2=head;
		while(n2.next!=null && n2.next.next!=null) {
			n1=n1.next;
			n2=n2.next.next;
		}
		//反转链表的有半部分
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
		//把链表的有半部分还原
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
