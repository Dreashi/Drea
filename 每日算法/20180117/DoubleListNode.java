package com.java.num12;

/**
 *  删除双向链表中倒数第k个结点
 * @author lenovo
 *
 */

public class DoubleListNode {
	public static class DoubleNode{
		int val;
		DoubleNode next=null;
		DoubleNode last=null;
		
		public DoubleNode(int val) {
			this.val=val;
		}
	}
	
	public static DoubleNode removeLastKthNode(DoubleNode head, int k) {
		if(head==null || k<1)	return null;
		DoubleNode node=head;
		while(node.next!=null) {
			node=node.next;
			k--;
		}
		if(k>0) {
			return null;
		}else if(k==0) {
			head=head.next;
			head.last=null;
		}else {
			node=head;
			while(k<0) {
				node=node.next;
				k++;
			}
			node.next=node.next.next;
			node.next.last=node;
		}
		return head;
	}
	
	public static void print(DoubleNode head) {
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
	
	public static void main(String[] args) {
		DoubleNode node1=new DoubleNode(3);
		DoubleNode node2=new DoubleNode(2);
		DoubleNode node3=new DoubleNode(5);
		DoubleNode node4=new DoubleNode(8);
		DoubleNode node5=new DoubleNode(4);
		DoubleNode node6=new DoubleNode(7);
		DoubleNode node7=new DoubleNode(6);
		DoubleNode node8=new DoubleNode(9);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		node7.next=node8;
		
		node2.last=node1;
		node3.last=node2;
		node4.last=node3;
		node5.last=node4;
		node6.last=node5;
		node7.last=node6;
		node8.last=node7;
		
		DoubleNode head=removeLastKthNode(node1,5);
		print(head);
	}

}
