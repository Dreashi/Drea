package com.java.num18;

/**
 * 将单项链表按某值划分成左边小、中间相等、右边大的形式
 * 解法一:把链表所有值存入数组中进行排序后再连接成链表
 * @date 2018/1/23
 * @author lenovo
 *
 */

public class Test1 {
	public static class Node{
		int val;
		Node next=null;
		public Node(int val) {
			this.val=val;
		}
	}
	
	public static void swap(Node[] nodeArr,int i, int j) {
		Node tmp;
		tmp=nodeArr[i];
		nodeArr[i]=nodeArr[j];
		nodeArr[j]=tmp;
	}
	
	public static void arrPatition(Node[] nodeArr, int pivot) {
		int small=0;
		int big=nodeArr.length-1;
		int index=0;
		while(index != big+1) {//加1是因为如果index刚好等于最大值，则最后一个数不会被比较
			if(nodeArr[index].val < pivot) {
				swap( nodeArr, index++, small++);
			}else if(nodeArr[index].val==pivot) {
				index++;
			}else {
				swap(nodeArr, index, big--);
			}
		}
	}
	
	public static Node listPartition(Node head, int pivot) {
		if(head==null)	return null;
		int len=0;
		Node cur=head;
		while(cur!=null) {
			len++;
			cur=cur.next;
		}
		Node[] nodeArr=new Node[len];
		cur=head;
		int i=0;
		for(i=0; i<nodeArr.length; i++) {
			nodeArr[i]=cur;
			cur=cur.next;
		}
		arrPatition(nodeArr, pivot);
		head=nodeArr[0];
		for(i=1; i<len; i++) {
			nodeArr[i-1].next=nodeArr[i];
		}
		nodeArr[i-1].next=null;
		return head;
	}
	
	public static void main(String[] args) {
		Node node1=new Node(9);
		Node node2=new Node(0);
		Node node3=new Node(4);
		Node node4=new Node(5);
		Node node5=new Node(1);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		
		Node head=listPartition(node1,-1);
		
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}

}
