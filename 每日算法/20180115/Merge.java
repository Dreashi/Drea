package com.java.list;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author lenovo
 *
 */

public class Merge {
	public static class ListNode{
		int val;
		ListNode next=null;
		
		ListNode(int val){
			this.val=val;
		}
	}
	
	//非递归解法
	public static ListNode listMerge1(ListNode list1, ListNode list2) {
		if(list1==null || list2==null) {
			return list1==null?list2:list1;
		}
		
		ListNode head=null;
		ListNode h=null;
		//list1和list2哪个小，哪个作为合并后的头指针
		head=(list1.val<=list2.val)?list1:list2;
		h=head;
		while(list1!=null && list2!=null) {
			//list1的值小，则把list1加入到合并后的链表中
			if(list1.val<=list2.val) {
				h.next=list1;
				list1=list1.next;
				h=h.next;
			}else {
				h.next=list2;
				list2=list2.next;
				h=h.next;
			}
		}
		//list1遍历完，把list2加入到合并链表中
		if(list1==null) {
			h.next=list2;
		}
		//list2遍历完，把list1加入到合并链表中
		if(list2==null) {
			h.next=list1;
		}
		return head;
	}
	
	//推荐解法
	//递归解法
	public static ListNode listMerge2(ListNode list1, ListNode list2) {
		if(list1==null || list2==null) {
			return list1==null?list2:list1;
		}
		//如果list1.val<=list2.val,则list1.next就是list1剩余部分和list2剩余部分生成的有序队列
		if(list1.val<=list2.val) {
			list1.next=listMerge2(list1.next,list2);
			return list1;
		}else {
			list2.next=listMerge2(list1,list2.next);
			return list2;
		}
	}
	
	public static void main(String[] args) {
		ListNode list1=new ListNode(1);
		ListNode list3=new ListNode(3);
		ListNode list4=new ListNode(5);
		
		ListNode list2=new ListNode(2);
		ListNode list5=new ListNode(4);
		ListNode list6=new ListNode(6);
		
		list1.next=list3;
		list3.next=list4;
		list2.next=list5;
		list5.next=list6;
		
		ListNode head=listMerge1(list1,list2);
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}

}
