package com.java.tree;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @date 2018/1/23
 * @author lenovo
 *
 */

public class Path {
	public static class TreeNode{
		int val;
		TreeNode left=null;
		TreeNode right=null;
		public TreeNode(int val) {
			this.val=val;
		}
	}
	
	public static void path(TreeNode root, int target, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1, int sum) {
		if(root==null)	return;
		sum+=root.val;
		if(root.right==null && root.left==null) {
			if(sum==target) {
				a1.add(root.val);
				arr.add(new ArrayList<Integer>(a1));
				a1.remove(a1.size()-1);//remove的作用是移除上一个加入的结点，以便加入下一个结点
			}
			return;
		}
		a1.add(root.val);
		path(root.left,target,arr,a1,sum);
		path(root.right,target,arr,a1,sum);
		a1.remove(a1.size()-1);
	}
	
	public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		if(root==null)	return arr;
		ArrayList<Integer> a1=new ArrayList<Integer>();
		int sum=0;
		path(root,target,arr,a1,sum);
		return arr;
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(10);
		TreeNode node1=new TreeNode(5);
		TreeNode node2=new TreeNode(12);
		TreeNode node3=new TreeNode(4);
		TreeNode node4=new TreeNode(7);
		root.left=node1;
		root.right=node2;
		node1.left=node3;
		node1.right=node4;
		
		ArrayList<ArrayList<Integer>> arr=findPath(root,22);
		for(ArrayList<Integer> a1 : arr) {
			System.out.println(a1);
		}
		
	}

}
