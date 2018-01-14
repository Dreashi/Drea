package com.java.find;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author lenovo
 *
 */

public class LinkedNode {
	
	public static class ListNode{
		int val;
		ListNode next=null;
		
		ListNode(int val){
			this.val=val;
		}
	}
	
	public static ListNode FindKthToTail1(ListNode head, int k) {
		if(head==null)	return null;
		int num=1;
		ListNode p=head;
		while(p.next!=null) {
			p=p.next;
			num++;
		}
		if(num<k)	return null;
		p=head;
		int i=1;
		while(i<num-k+1) {
			p=p.next;
			i++;
		}
		return p;
	}
	
	public static ListNode FindKthToTail2(ListNode head, int k) {
		if(k<0)	return null;
		ListNode p=head;
		ListNode q=head;
		for(int i=0; i<k; i++) {
			if(p==null)		return null;
			p=p.next;
		}
		while(p!=null) {
			p=p.next;
			q=q.next;
		}
		return q==null?null:q;
	}
	
	//p先跑，当跑到第k个时，q开始跑，p跑到最后，q就是倒数第k个
	public static ListNode FindKthToTail3(ListNode head, int k) {
		ListNode p=head;
		ListNode q=head;
		int i=1;
		for(;p!=null;i++) {
			p=p.next;
			if(i>k) {
				q=q.next;
			}
		}
		return (i<k||q==null)?null:q;
	}
	
	public static void main(String[] args) {
		ListNode[] arr=new ListNode[10];
		for(int i=0; i<arr.length; i++) {
			arr[i]=new ListNode(i);
		}
		
		for(int i=0; i<arr.length-1; i++) {
			arr[i].next=arr[i+1];
		}
		ListNode head=arr[0];
		ListNode p=FindKthToTail3(head,20);
		if(p==null) {
			System.out.println("null");
		}else {
			System.out.println(p.val);
		}
	}

}
