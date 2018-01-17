package com.java.list;

/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
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
	
	//�ǵݹ�ⷨ
	public static ListNode listMerge1(ListNode list1, ListNode list2) {
		if(list1==null || list2==null) {
			return list1==null?list2:list1;
		}
		
		ListNode head=null;
		ListNode h=null;
		//list1��list2�ĸ�С���ĸ���Ϊ�ϲ����ͷָ��
		head=(list1.val<=list2.val)?list1:list2;
		h=head;
		while(list1!=null && list2!=null) {
			//list1��ֵС�����list1���뵽�ϲ����������
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
		//list1�����꣬��list2���뵽�ϲ�������
		if(list1==null) {
			h.next=list2;
		}
		//list2�����꣬��list1���뵽�ϲ�������
		if(list2==null) {
			h.next=list1;
		}
		return head;
	}
	
	//�Ƽ��ⷨ
	//�ݹ�ⷨ
	public static ListNode listMerge2(ListNode list1, ListNode list2) {
		if(list1==null || list2==null) {
			return list1==null?list2:list1;
		}
		//���list1.val<=list2.val,��list1.next����list1ʣ�ಿ�ֺ�list2ʣ�ಿ�����ɵ��������
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
