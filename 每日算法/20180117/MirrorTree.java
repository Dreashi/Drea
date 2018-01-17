package com.java.tree;

import java.util.Stack;

/**
 * ���������Ķ�����������任ΪԴ�������ľ���
 * 
 * @author lenovo
 *
 */

public class MirrorTree {
	public static class TreeNode{
		int val;
		TreeNode left=null;
		TreeNode right=null;
		
		TreeNode(int val){
			this.val=val;
		}
	}
	
	//�ǵݹ�ⷨ
	public static void mirror(TreeNode root) {
		if(root==null)	return;
		//��ջ�����������ÿһ�����
		Stack<TreeNode> stack=new Stack<TreeNode>();
		//���ڵ���ջ
		stack.push(root);
		while(!stack.isEmpty()) {
			//ջ��Ԫ�س�ջ��ջ��Ԫ�ر�ʾ��ǰ�������Ľ�㣩
			TreeNode node=stack.pop();
			if(node.left!=null || node.right!=null) {
				TreeNode leftNode=node.left;
				TreeNode rightNode=node.right;
				node.left=rightNode;
				node.right=leftNode;
			}
			if(node.left!=null) {
				stack.push(node.left);
			}
			if(node.right!=null) {
				stack.push(node.right);
			}
		}	
	}
	
	//�ݹ�ⷨ
	public static void Mirror(TreeNode root) {
		if(root==null)	return;
		TreeNode node=root.left;
		root.left=root.right;
		root.right=node;
		if(root.left!=null)
			Mirror(root.left);
		if(root.right!=null)
			Mirror(root.right);
	}
	
	/**
	 * ����ǰ������������������һ�Ŷ�����
	 * @param pre ǰ���������
	 * @param startpre pre����ʼ�±�
	 * @param endpre pre�Ľ����±�
	 * @param in �����������
	 * @param startin in����ʵ�±�
	 * @param endin in�Ľ����±�
	 * @return ���������ڵ�
	 */
	public static TreeNode build(int[] pre,  int startpre, int endpre, int[] in, int startin, int endin) {
		if(startpre>endpre || startin>endin)
			return null;
		//ǰ������ĵ�һ�����Ƕ��������ڵ�
		TreeNode root=new TreeNode(pre[startpre]);
		for(int i=startin; i<=endin; i++) {
			//����������������Ҹ��ڵ�
			if(in[i]==pre[startpre]) {
				root.left=build(pre, startpre+1, startpre+i-startin, in, startin, i-1);
				root.right=build(pre, startpre+i-startin+1, endpre, in, i+1, endin);
				break;
			}
		}
		return root;
	}
	
	/**
	 * ���������ǰ���������
	 * @param root ���������ڵ�
	 */
	public static void prePrint(TreeNode root) {
		if(root!=null) {
			System.out.print(root.val+" ");
			prePrint(root.left);
			prePrint(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		int[] pre = {8,6,5,7,10,9,11};
		int[] in = {5,6,7,8,9,10,11};
		TreeNode root=build(pre, 0, pre.length-1, in, 0, in.length-1);
		prePrint(root);
		System.out.println();
		Mirror(root);
		prePrint(root);
		
		
	}

}
