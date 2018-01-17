package com.java.num12;

/**
 * 分别实现两个函数，一个可以实现删除单链表中倒数第k个结点，另一个可以实现删除双向链表中倒数第k个结点
 * @author lenovo
 *
 */

public class SingleListNode {
	public static class ListNode{
		int val;
		ListNode next=null;
		
		public ListNode(int val){
			this.val=val;
		}
	}
	
	public static ListNode removeLastKthNode(ListNode head,int k) {
		if(head == null)	return null;
		ListNode node=head;
		//遍历链表，每遍历一个结点，k-1
		while(node.next!=null) {
			node=node.next;
			k--;
		}
		//k>0 说明k值超出链表范围
		if(k>0) {
			return null;
		}else if(k==0)//k=0 说明需要删除第一个结点
		{
			return head.next;
		}else {//k<0 说明要删除第一个以后的结点
			node=head;
			//从头结点开始重新遍历链表，每遍历一个结点使k+1,当k==0时，则当前节点为需要删除的结点的前一个结点
			while(k<0) {
				node=node.next;
				k++;
			}
			node.next=node.next.next;
		}
		return head;
	}
	
	public static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode node1=new ListNode(3);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(5);
		ListNode node4=new ListNode(8);
		ListNode node5=new ListNode(4);
		ListNode node6=new ListNode(7);
		ListNode node7=new ListNode(6);
		ListNode node8=new ListNode(9);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		node7.next=node8;
		
		ListNode head=removeLastKthNode(node1, 4);
		print(head);
	}

}
