package com.java.find;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author lenovo
 *
 */

public class Frog2 {
	public static int JumpFloorII(int target) {
		if(target<=0)	return 0;
		if(target==1)	return 1;
		
		int result=1;
		for(int i=1; i<target; i++) {
			result=result*2;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Frog2.JumpFloorII(5));
	}
	

}
