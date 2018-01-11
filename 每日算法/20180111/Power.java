package com.java.number;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * @author lenovo
 *
 */

public class Power {
	
	/**
	 * ԭ��10^1101 = 10^0001*10^0100*10^1000
	 * ������λ����һλ����Ӧ��ָ����Ϊԭ���Ķ��������������������2��������
	 * ͨ��&1��>>1����λ��ȡ1101��Ϊ1ʱ����λ����ĳ����۳˵����ս��
	 * @param base ����
	 * @param n ָ��
	 * @return base��exponent�η�
	 */
	public static double power2(double base, int n) {
		//res�����۳����ս��,curr�����۳��м���
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
			//ָ���Ķ���������ǰλΪ1����curr��ֵ�۳˵�res
			if((exponent&1)==1) {
				res*=curr;
			}
			//����Զ���������
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
