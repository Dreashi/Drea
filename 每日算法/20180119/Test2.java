package com.java.num14;

/**
 * 实现反转双向链表
 * @date 2018/1/19
 * @author lenovo
 *
 */

public class Test2 {
	public static class ListNode{
		int val;
		ListNode pre=null;
		ListNode next=null;
		
		public  ListNode(int val) {
			this.val=val;
		}
	}
	
	public static ListNode reverse1(ListNode head) {
		ListNode next=head.next;
		while(head.next!=null) {
			head.next=head.pre;
			head.pre=next;
			head=next;
			next=next.next;
		}
		head.next=head.pre;
		head.pre=next;
		return head;
	}
	
	public static ListNode reverse2(ListNode head) {
		ListNode pre=null;
		ListNode next=null;
		while(head!=null) {
			next=head.next;//不在循环最后一步移动next，最后一步移动next后出现空指针异常，next==null然后继续找next.next
			head.next=pre;
			head.pre=next;
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
		
		node2.pre=node1;
		node3.pre=node2;
		node4.pre=node3;
		node5.pre=node4;
		node6.pre=node5;
		
		ListNode head=reverse2(node1);
		
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}

}
