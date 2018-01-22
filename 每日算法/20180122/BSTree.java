package com.java.tree;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
 * @date 2018/1/22
 * @author lenovo
 *
 */

public class BSTree {
	
	public static boolean isTreeBST(int[] sequence, int start, int end) {
		if(end<=start)	return true;
		int i=start;
		for(; i<end;i++) {
			if(sequence[i]>sequence[end])	break;//�˴�����return false����ΪҪ�ҵ����ڵ����������λ��
		}
		//���붨��j�����ܶ�ʧi��λ��
		for(int j=i; j<end; j++) {
			if(sequence[j]<sequence[end])	return false;//�˴�����return false����Ϊ��������
		}
		//�����ֱ������������������
		return isTreeBST(sequence, start, i-1) && isTreeBST(sequence, i+1,end);
	}
	
	public static boolean verifySequenceOfBST(int[] sequence) {
		if(sequence.length==0)
			return false;
		return isTreeBST(sequence, 0, sequence.length-1);
	}
	
	public static void main(String[] args) {
		int[] sequence= {1,3,2,5,7,6,4,9,11,10,13,15,14,12,8};
		System.out.println(verifySequenceOfBST(sequence));
	}

}
