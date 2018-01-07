package com.array.cj;

import java.util.LinkedList;

public class NewArray {

	public int []getMaxWindow(int array[],int w) {
		int res[]=new int[array.length-w+1];
		int index=0;
		LinkedList<Integer> qmax=new LinkedList<Integer>();
		for (int i = 0; i < array.length; i++) {
			while(!qmax.isEmpty()&&array[i]>=array[qmax.peekLast()]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst()==i-w) {
				qmax.pollFirst();
			}
			if(i>=w-1) {
				res[index++]=array[qmax.peekFirst()];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int arrays[]= {4,3,5,4,3,3,6,7};
		NewArray n=new NewArray();
		int w=3;
		int gh[]=n.getMaxWindow(arrays, w);
		for (int i = 0; i < gh.length; i++) {
			System.out.print(gh[i]);
		}
}

}
