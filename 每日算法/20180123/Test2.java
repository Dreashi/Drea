package com.java.num18;

import com.java.num18.Test1.Node;

/**
 * ����������ĳֵ���ֳ����С���м���ȡ��ұߴ����ʽ
 * �ⷨ�������������������ṹ���ֱ��γ�С��������ȵ���������������������������
 * @date 2018/1/23
 * @author lenovo
 *
 */

public class Test2 {
	public static class Node{
		int val;
		Node next=null;
		public Node(int val) {
			this.val=val;
		}
	}
	
	public  static Node listPartition(Node head, int pivot) {
		Node sStart=null;
		Node sEnd=null;
		Node eStart=null;
		Node eEnd=null;
		Node bStart=null;
		Node bEnd=null;
		Node next=null;
		
		while(head!=null) {
				next=head.next;
				head.next=null;
				if(head.val<pivot) {
					if(sStart==null) {
						sStart=head;
						sEnd=head;
					}else {
						sEnd.next=head;
						sEnd=head;
					}
				}else if(head.val==pivot){
					if(eStart==null) {
						eStart=head;
						eEnd=head;
					}else {
						eEnd.next=head;
						eEnd=head;
					}
				}else {
					if(bStart==null) {
						bStart=head;
						bEnd=head;
					}else {
						bEnd.next=head;
						bEnd=head;
					}
				}
			head=next;
		}
		//����С��������ȵ���
		if(sEnd!=null) {
			sEnd.next=eStart;
			//��һ���������� �������ȵ�Ϊnull�������ȵ�βָ��С��β����������Ͽ�
			eEnd=eEnd==null?sEnd:eEnd;
		}
		//������ȵ����ʹ����
		if(eEnd!=null) {
			eEnd.next=bStart;
		}
		return sStart!=null?sStart:eStart!=null?eStart:bStart;
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
		
		Node head=listPartition(node1,3);
		
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
	}


}
