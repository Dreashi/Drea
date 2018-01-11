package com.java.number;

public class NumberOf1 {
	/**
	 * ���ɣ�n-1�ǽ�n���ұߵ�1��Ϊ0�����ұߵ�����0��Ϊ1��n&(n-1)������n���ұߵ�1������ѭ�����Եó�n��1�ĸ���
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
	 * ��n����������1���������㣬���Ϊ1˵��n��ǰλΪ1��
	 * ע�� ���������޷���>>>����Ϊ���������λ��1���з������ƻ������λ���ϲ�1
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
	 * ��flag=1��ʼ��n���������㣬��������Ϊ0��˵��n�ĵ�ǰλΪ1��Ȼ��flag���ƣ�����ѭ��
	 * @param n
	 * @return
	 */
	public static int number3(int n) {
		int count=0;
		int flag=1;
		
		while(flag!=0) {
			//����ʹ��count+=flag&n;
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
