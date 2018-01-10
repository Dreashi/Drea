package com.java.find;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 同Fibocnacci数列;
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author lenovo
 *
 */

public class Frog1 {
	public static int JumpFloor(int target) {
		if(target<=0)	return 0;
		if(target==1)	return 1;
		if(target==2)	return 2;
		
		int i=1,j=1,result=0;
		for(int k=2;k<=target;k++) {
			result=i+j;
			i=j;
			j=result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Frog1.JumpFloor(3));
	}

}
