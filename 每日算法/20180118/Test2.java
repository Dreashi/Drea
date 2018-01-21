package com.java.num13;

/**
 * 给定链表的头结点head，整数a和b，实现删除位于a/b处的结点
 * @date 2018/1/18
 * @author lenovo
 *
 */

public class Test2 {
	public static class ListNode{
		int val;
		ListNode next=null;
		public ListNode(int val){
			this.val=val;
		}
	}
	
	public static ListNode removeByRatio(ListNode head, int  a, int b) {
		if(a<1 || a>b)	return head;
		int n=0;
		ListNode node=head;
		//遍历链表，求出链表的长度
		while(node!=null) {
			n++;
			node=node.next;
		}
		//计算需要删除的结点位置
		int num=(int) Math.round((double)(a*n)/b);
		if(num==1)	return node.next;
		if(num>1) {
			node=head;
			while(--num>1) {
				node=node.next;
			}
			node.next=node.next.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head=new ListNode(3);
		ListNode head1=new ListNode(2);
		ListNode head2=new ListNode(5);
		ListNode head3=new ListNode(8);
		ListNode head4=new ListNode(7);
		ListNode head5=new ListNode(6);
		//ListNode head6=new ListNode(9);
		
		head.next=head1;
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=head5;
		//head5.next=head6;
		
		ListNode node=removeByRatio(head,2,6);
		
		while(node!=null) {
			System.out.print(node.val+" ");
			node=node.next;
		}
	}

}
