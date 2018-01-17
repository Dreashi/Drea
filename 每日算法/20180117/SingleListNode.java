package com.java.num12;

/**
 * �ֱ�ʵ������������һ������ʵ��ɾ���������е�����k����㣬��һ������ʵ��ɾ��˫�������е�����k�����
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
		//��������ÿ����һ����㣬k-1
		while(node.next!=null) {
			node=node.next;
			k--;
		}
		//k>0 ˵��kֵ��������Χ
		if(k>0) {
			return null;
		}else if(k==0)//k=0 ˵����Ҫɾ����һ�����
		{
			return head.next;
		}else {//k<0 ˵��Ҫɾ����һ���Ժ�Ľ��
			node=head;
			//��ͷ��㿪ʼ���±�������ÿ����һ�����ʹk+1,��k==0ʱ����ǰ�ڵ�Ϊ��Ҫɾ���Ľ���ǰһ�����
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
