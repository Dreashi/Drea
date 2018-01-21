package com.java.num16;

/**
 * 约瑟夫环问题：一个循环链表，每数m个数删一个结点，最后剩余的一个结点存活，找出存活结点
 * @date 2018/1/21
 * @author lenovo
 *
 */

public class Josephus {
	public static  class ListNode{
		int val;
		ListNode next=null;
		public ListNode(int val) {
			this.val=val;
		}
	}
	
	//非递归解法
	public static ListNode JosephusKill1(ListNode head, int m) {
		//先判断特殊情况
		if(head==null || head.next==head || m<1) {
			return head;
		}
		//定义尾结点
		ListNode last=head;
		while(last.next!=head) {
			last=last.next;
		}
		//首尾结点联动，删除第m个结点
		int count=0;
		while(head!=last) {
			//碰到第m个结点就删除
			//count从0开始，m从1开始计数，所以必须先加1再比较
			if(++count==m) {
				last.next=head.next;
				count=0;
			}else {//不是第m个结点就继续联动
				last=last.next;
			}
			head=last.next;
		}
		return head.next;
	}
	
	
	//递归解法 时间复杂度O(n)
	public static int getLive(int i, int m) {
		if(i==1)	return 1;
		return (getLive(i-1,m)+m-1)%i+1;
	}
	public static ListNode JosephusKill2(ListNode head, int m) {
		if(head==null || head.next==head || m<1) {
			return head;
		}
		int count=1;
		ListNode cur=head.next;
		//遍历结点，计算出链表的长度
		while(cur!=head) {
			cur=cur.next;
			count++;
		}
		//递归找到生存的结点的位置
		count=getLive(count,m);
		//指针指向生存的结点
		while(--count!=0) {
			head=head.next;
		}
		//把生存下来的结点变成一个单节点
		head.next=head;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node1;
		
		ListNode head=JosephusKill2(node1,3);
		System.out.println(head.val);
	}
	

}
