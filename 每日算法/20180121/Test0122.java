package com.java.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 从上往下打印二叉树的每个节点，同层结点从左至右打印(二叉树的层次遍历)
 * @date 2018/1/21
 * @author lenovo
 *
 */

public class Test0122 {
	public static class TreeNode{
		int val;
		TreeNode left=null;
		TreeNode right=null;
		public TreeNode(int val) {
			this.val=val;
		}
	}
	
	
	public static ArrayList<Integer> printFromTopToBottom(TreeNode root){
		//list存储打印的结点的值
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(root==null)	return list;
		//deque是双端队列，存储将来要查找的结点
		Deque<TreeNode> deque=new LinkedList<TreeNode>();
		
		deque.add(root);//add方法加入队列的尾部,push方法加入队列头部
		while(!deque.isEmpty()) {
			//当前节点出队
			TreeNode node=deque.pop();
			//出队结点加入list中
			list.add(node.val);
			//判断出队结点的左子节点,有的话入队
			if(node.left!=null)		deque.add(node.left);
			//判断出队结点的右子节点，有的话入队
			if(node.right!=null)	deque.add(node.right);
		}
		return list;
	}
	
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
		node3.right=node7;
		
		ArrayList<Integer> list=printFromTopToBottom(node1);
		for(Integer li : list) {
			System.out.print(li+" ");
		}
		
	}
}
