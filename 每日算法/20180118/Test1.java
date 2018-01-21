package com.java.num13;

/**
 * ����ͷ���head��ʵ��ɾ�������м�ڵ�ĺ�����
 * �ڵ�����ɾ���ڵ��λ�ù�ϵ��1--0��2--1,3--2,4--2��������
 * �ڵ�����3��ʼ��ѭ�ڵ�����2����ɾ�����ż�1�Ĺ���
 * @date 2018/1/18
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
	
	public  static ListNode removeMidNode(ListNode head) {
		//�������Ϊ�ջ�ֻ��һ����㣬�����޸�
		if(head==null || head.next==null) {
			return head;
		}
		//���ֻ��������㣬��ɾ��ͷ���
		if(head.next.next==null) {
			return head.next;
		}
		ListNode pre=head;//��ɾ����ǰһ���ڵ�
		ListNode cur=head.next.next;//��ʾ����ĳ��ȣ������β��㣩
		while(cur.next!=null && cur.next.next!=null) {
			pre=pre.next;
			cur=cur.next.next;
		}
		pre.next=pre.next.next;
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
		
		ListNode node=removeMidNode(head);
		
		while(node!=null) {
			System.out.print(node.val+" ");
			node=node.next;
		}
		
	}

}
