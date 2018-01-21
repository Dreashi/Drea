package com.java.num16;

/**
 * Լɪ�����⣺һ��ѭ������ÿ��m����ɾһ����㣬���ʣ���һ�������ҳ������
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
	
	//�ǵݹ�ⷨ
	public static ListNode JosephusKill1(ListNode head, int m) {
		//���ж��������
		if(head==null || head.next==head || m<1) {
			return head;
		}
		//����β���
		ListNode last=head;
		while(last.next!=head) {
			last=last.next;
		}
		//��β���������ɾ����m�����
		int count=0;
		while(head!=last) {
			//������m������ɾ��
			//count��0��ʼ��m��1��ʼ���������Ա����ȼ�1�ٱȽ�
			if(++count==m) {
				last.next=head.next;
				count=0;
			}else {//���ǵ�m�����ͼ�������
				last=last.next;
			}
			head=last.next;
		}
		return head.next;
	}
	
	
	//�ݹ�ⷨ ʱ�临�Ӷ�O(n)
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
		//������㣬���������ĳ���
		while(cur!=head) {
			cur=cur.next;
			count++;
		}
		//�ݹ��ҵ�����Ľ���λ��
		count=getLive(count,m);
		//ָ��ָ������Ľ��
		while(--count!=0) {
			head=head.next;
		}
		//�����������Ľ����һ�����ڵ�
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
