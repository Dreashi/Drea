package com.hellojava.demo03;

import java.util.LinkedList;

public class LinkedText {
	public  int[] getMaxWindow(int[] arr,int w ) {
		if(arr==null || w<1 || arr.length<w) {
			return null;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[] res = new int[arr.length-w+1];
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			while(!list.isEmpty()&&arr[list.peekLast()]<=arr[i]) {
				list.pollLast();
			}
			list.addLast(i);
			if(list.peekFirst()==i-w) {
				list.pollFirst();
			}
			if(i>=w-1) {
				res[index++] = arr[list.peekFirst()];
			}
			
		}
		return res;
	}
	public static void main(String[] args) {
		
		int[] arr = {4,3,5,4,3,3,6,7};
		LinkedText l= new LinkedText();
		int[] ll = l.getMaxWindow(arr,3);
		for(int i=0;i<ll.length;i++) {
			System.out.println(ll[i]);
		}
	}
	
}
