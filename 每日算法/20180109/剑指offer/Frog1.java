package com.java.find;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * ͬFibocnacci����;
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
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
