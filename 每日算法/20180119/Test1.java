package com.java.num14;

/**
 * 实现反转单向链表
 * @date 2018/1/19
 * @author lenovo
 *
 */

public class Test1 {
	public static class ListNode{
		int val;
		ListNode next=null;
		public ListNode(int val) {
		this.val=val;
		}
	}
	
	public static ListNode reverse(ListNode head) {
		ListNode pre=null;
		ListNode next=null;
		while(head!=null) {
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		
		ListNode head=reverse(node1);
		
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}

}
