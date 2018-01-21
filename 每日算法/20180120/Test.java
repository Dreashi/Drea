package com.java.num15;

/**
 * 给定一个单项链表的头结点head，以及两个整数from和to，在单线链表上把第from个结点都第to个结点进行反转
 * @date 2018/1/20
 * @author lenovo
 *
 */

public class Test {
	public static class ListNode{
		int val;
		ListNode next=null;
		
		public ListNode(int val){
			this.val=val;
		}
	}
	
	//链表第一个结点为1
	public static ListNode reverse(ListNode head, int from, int to) {
		int len=0;
		ListNode fpre=null;//指向from的前一个节点
		ListNode tpos=null;//指向to的后一个结点
		ListNode node1=head;//用来遍历整个链表，找到form的前一个节点和to的后一个节点
		//遍历整个链表，找到form的前一个节点和to的后一个节点
		while(node1!=null) {
			len++;
			fpre=len==from-1?node1:fpre;
			tpos=len==to+1?node1:tpos;
			node1=node1.next;
		}
		//不符合常理的情况
		if(from>to || from<1 || to>len) {
			return head;
		}
		ListNode pfrom=fpre==null?head:fpre.next;//from结点
		ListNode next=pfrom.next;//from结点的下一个结点
		pfrom.next=tpos;
		ListNode tnext=null;//from结点的下一个结点的下一个结点
		
		//反转中间的结点
		while(next!=tpos) {
			tnext=next.next;
			next.next=pfrom;
			pfrom=next;
			next=tnext;
		}
		if(fpre!=null) {
			fpre.next=pfrom;
			return head;
		}
		return pfrom;
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
		
		ListNode head=reverse(node1,0,4);
		
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}

}
