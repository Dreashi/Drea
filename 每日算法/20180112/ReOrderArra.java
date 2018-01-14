package com.java.number;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

import java.util.LinkedList;
import java.util.Queue;

public class ReOrderArra {
	
	//交换
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
	
	//两个栈，一个存奇数，一个存偶数
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
