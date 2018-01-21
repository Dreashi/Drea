package com.java.num13;

/**
 * 给定头结点head，实现删除链表中间节点的函数。
 * 节点数与删除节点的位置关系：1--0，2--1,3--2,4--2。。。。
 * 节点数从3开始遵循节点数加2，待删结点序号加1的规律
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
		//如果链表为空或只有一个结点，则不做修改
		if(head==null || head.next==null) {
			return head;
		}
		//如果只有两个结点，则删除头结点
		if(head.next.next==null) {
			return head.next;
		}
		ListNode pre=head;//待删结点的前一个节点
		ListNode cur=head.next.next;//表示链表的长度（假设的尾结点）
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
