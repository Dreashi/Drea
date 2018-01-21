package com.java.num13;

/**
 * ���������ͷ���head������a��b��ʵ��ɾ��λ��a/b���Ľ��
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
		//���������������ĳ���
		while(node!=null) {
			n++;
			node=node.next;
		}
		//������Ҫɾ���Ľ��λ��
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
