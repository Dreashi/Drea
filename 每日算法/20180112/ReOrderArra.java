package com.java.number;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */

import java.util.LinkedList;
import java.util.Queue;

public class ReOrderArra {
	
	//����
	public static void reOrderArray1(int[] array) {
		int i=0,j=0,tmp=0;
		for(i=0; i<array.length; i++) {
			if(array[i]%2==0) {
				for(j=i; j<array.length && array[j]%2==0; j++);
				if(j<array.length) {
					for(;j>i;j--) {
						tmp=array[j];
						array[j]=array[j-1];
						array[j-1]=tmp;
					}
				}
			}
		}
	}
	
	//����ջ��һ����������һ����ż��
	public static void reOrderArray2(int[] array) {
		Queue<Integer> queue1=new LinkedList<Integer>();
		Queue<Integer> queue2=new LinkedList<Integer>();
		
		for(int i=0; i<array.length;i++) {
			if(array[i]%2!=0) {
				queue1.add(array[i]);
			}else {
				queue2.add(array[i]);
			}
		}
		
		int i=0;
		while(!queue1.isEmpty()) {
			array[i++]=queue1.poll();
		}
		while(!queue2.isEmpty()) {
			array[i++]=queue2.poll();
		}
	}
	
	public static void main(String[] args) {
		int[] array={2,3,5,8,4,7,6,9};
		reOrderArray2(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
		
	}

}
