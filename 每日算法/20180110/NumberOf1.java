package com.java.number;

public class NumberOf1 {
	/**
	 * 规律：n-1是将n最右边的1变为0，其右边的所有0变为1，n&(n-1)会消掉n最右边的1，不断循环可以得出n中1的个数
	 * @param n
	 * @return
	 */
	public static int number1(int n) {
		  int count = 0;
	      while (n!=0)
	      {
	            n = (n - 1) & n;
	            ++ count;
	      }
        return count;
	}
	
	/**
	 * 把n不断右移与1进行与运算，结果为1说明n当前位为1。
	 * 注意 ：必须是无符号>>>，因为负数的最高位是1，有符号右移会想最高位不断补1
	 * @param n
	 * @return
	 */
	public static int number2(int n) {
		int count=0;
		while(n!=0) {
			count+=n&1;
			n=n>>>1;
		}
		return count;
	}
	
	/**
	 * 
	 * 用flag=1开始于n进行与运算，如果结果不为0，说明n的当前位为1，然后flag左移，继续循环
	 * @param n
	 * @return
	 */
	public static int number3(int n) {
		int count=0;
		int flag=1;
		
		while(flag!=0) {
			//不能使用count+=flag&n;
			if((n&flag)!=0) {
				count++;
			}	
			flag=flag<<1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(number3(10));
	}

}
