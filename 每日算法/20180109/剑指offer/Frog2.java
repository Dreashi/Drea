package com.java.find;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
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
