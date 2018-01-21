package com.java.num15;

/**
 * ����һ�����������ͷ���head���Լ���������from��to���ڵ��������ϰѵ�from����㶼��to�������з�ת
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
	
	//�����һ�����Ϊ1
	public static ListNode reverse(ListNode head, int from, int to) {
		int len=0;
		ListNode fpre=null;//ָ��from��ǰһ���ڵ�
		ListNode tpos=null;//ָ��to�ĺ�һ�����
		ListNode node1=head;//�����������������ҵ�form��ǰһ���ڵ��to�ĺ�һ���ڵ�
		//�������������ҵ�form��ǰһ���ڵ��to�ĺ�һ���ڵ�
		while(node1!=null) {
			len++;
			fpre=len==from-1?node1:fpre;
			tpos=len==to+1?node1:tpos;
			node1=node1.next;
		}
		//�����ϳ�������
		if(from>to || from<1 || to>len) {
			return head;
		}
		ListNode pfrom=fpre==null?head:fpre.next;//from���
		ListNode next=pfrom.next;//from������һ�����
		pfrom.next=tpos;
		ListNode tnext=null;//from������һ��������һ�����
		
		//��ת�м�Ľ��
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
