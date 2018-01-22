package com.java.tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @date 2018/1/22
 * @author lenovo
 *
 */

public class BSTree {
	
	public static boolean isTreeBST(int[] sequence, int start, int end) {
		if(end<=start)	return true;
		int i=start;
		for(; i<end;i++) {
			if(sequence[i]>sequence[end])	break;//此处不能return false，因为要找到根节点的右子树的位置
		}
		//必须定义j，不能丢失i的位置
		for(int j=i; j<end; j++) {
			if(sequence[j]<sequence[end])	return false;//此处可以return false，因为是右子树
		}
		//继续分别遍历左子树和右子树
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
