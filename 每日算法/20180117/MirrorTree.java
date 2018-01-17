package com.java.tree;

import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
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
	
	//非递归解法
	public static void mirror(TreeNode root) {
		if(root==null)	return;
		//用栈来存二叉树的每一个结点
		Stack<TreeNode> stack=new Stack<TreeNode>();
		//根节点入栈
		stack.push(root);
		while(!stack.isEmpty()) {
			//栈顶元素出栈（栈顶元素表示当前遍历到的结点）
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
	
	//递归解法
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
	 * 根据前序遍历和终须遍历构建一颗二叉树
	 * @param pre 前序遍历数组
	 * @param startpre pre的起始下标
	 * @param endpre pre的结束下标
	 * @param in 中序遍历数组
	 * @param startin in的其实下标
	 * @param endin in的结束下标
	 * @return 二叉树根节点
	 */
	public static TreeNode build(int[] pre,  int startpre, int endpre, int[] in, int startin, int endin) {
		if(startpre>endpre || startin>endin)
			return null;
		//前序遍历的第一个数是二叉树根节点
		TreeNode root=new TreeNode(pre[startpre]);
		for(int i=startin; i<=endin; i++) {
			//在中序遍历序列中找根节点
			if(in[i]==pre[startpre]) {
				root.left=build(pre, startpre+1, startpre+i-startin, in, startin, i-1);
				root.right=build(pre, startpre+i-startin+1, endpre, in, i+1, endin);
				break;
			}
		}
		return root;
	}
	
	/**
	 * 输出二叉树前序遍历序列
	 * @param root 二叉树根节点
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
