package com.java.num11;

/**
 * 打印给定的两个有序链表是公共部分
 * @author lenovo
 *
 */

public class Node {
	public static class ListNode{
		public int val;
		public ListNode next=null;
		public ListNode(int val) {
			this.val=val;
		}
	}
	
	public static void printCommonPart(ListNode list1, ListNode list2) {
		while(list1!=null && list2!=null) {
			if(list1.val<list2.val) {
				list1=list1.next;
			}else if(list2.val<list1.val) {
				list2=list2.next;
			}else {
				System.out.print(list1.val+" ");
				list1=list1.next;
				list2=list2.next;
			}
		}
	}
	
	public static void main(String[] args) {
		ListNode list1=new ListNode(3);
		ListNode list2=new ListNode(2);
		ListNode list3=new ListNode(5);
		ListNode list4=new ListNode(8);
		ListNode list5=new ListNode(4);
		list1.next=list2;
		list2.next=list3;
		list3.next=list4;
		list4.next=list5;
		
		ListNode list6=new ListNode(1);
		ListNode list7=new ListNode(2);
		ListNode list8=new ListNode(5);
		ListNode list9=new ListNode(4);
		ListNode list10=new ListNode(8);
		list6.next=list7;
		list7.next=list8;
		list8.next=list9;
		list9.next=list10;
		
		printCommonPart(list1,list6);
	}
	

}
