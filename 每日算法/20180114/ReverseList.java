package com.java.list;

import java.util.Stack;

/**
 * ����һ��������ת�����������������Ԫ�ء�
 * @author lenovo
 *
 */

public class ReverseList {
	public static class ListNode{
		int val;
		ListNode next=null;
		
		ListNode(int val){
			this.val=val;
		}
	}
	
	public static ListNode Reverse1(ListNode head) {
		Stack<Integer> stack=new Stack<Integer>();
		ListNode p=head;
		ListNode q=null;
		while(p!=null) {
			stack.push(p.val);
			p=p.next;
		}
		while(!stack.isEmpty()) {
			if(q==null) {
				head=new ListNode(stack.pop());
				q=head;
			}else {
				p=new ListNode(stack.pop());
			}
			if(p!=null) {
				q.next=p;
				q=q.next;
			}
		}
		return head;
	}
	
	//�ǵݹ�ⷨ
	public static ListNode Reverse2(ListNode head) {
		if(head==null)	return null;
		ListNode end=null;//endָ��ת���next���
		ListNode p=head;//ָ��ǰ���
		ListNode q=null;//ָ��תǰ��next���
		while(p!=null) {
			q=p.next;
			p.next=end;
			end=p;
			p=q;
		}
		head=end;
		
		return head;
	}
	
	//�ݹ�ⷨ
	public static ListNode Reverse3(ListNode head) {
		if(head==null||head.next==null)	return head;
		ListNode pReverse=Reverse3(head.next);
		head.next.next=head;
		head.next=null;
		
		return pReverse;
	}
	
	public static void main(String[] args) {
		ListNode head=null;
		ListNode[] arr=new ListNode[10];
		for(int i=0; i<arr.length; i++) {
			arr[i]=new ListNode(i);
		}
		for(int i=0; i<arr.length-1; i++) {
			if(i==0) {
				head=arr[i];
			}
			arr[i].next=arr[i+1];
		}
		ListNode h=Reverse3(head);
		
		while(h!=null) {
			System.out.print(h.val+" ");
			h=h.next;
		}
		
	}

}
