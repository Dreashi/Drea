package com.java.number;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author lenovo
 *
 */

public class Power {
	
	/**
	 * 原理：10^1101 = 10^0001*10^0100*10^1000
	 * 二进制位左移一位，对应的指数变为原来的二倍，即结果从右向左以2次幂增长
	 * 通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果
	 * @param base 底数
	 * @param n 指数
	 * @return base的exponent次方
	 */
	public static double power2(double base, int n) {
		//res用来累乘最终结果,curr用来累乘中间结果
		double res=1,curr=base;
		int exponent;
		if(n>0) {
			exponent=n;
		}else if(n<0) {
			exponent=-n;
		}else {
			return 1;
		}
		while(exponent!=0) {
			//指数的二进制数当前位为1，将curr的值累乘到res
			if((exponent&1)==1) {
				res*=curr;
			}
			//结果以二次幂增长
			curr*=curr;
			exponent>>=1;
		}
		return n>=0?res:(1/res);
	}
	
	public static double power(double base, int exponent) {
		double num=1;
		if(exponent==0)	return num;
		if(exponent<0) {
			exponent=-exponent;
			for(int  i=1; i<=exponent; i++) {
				num *= base;
			}
			num = 1.0/num;
		}else {
			for(int  i=1; i<=exponent; i++) {
				num *= base;
			}
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(power2(2,10));
		
	}

}
