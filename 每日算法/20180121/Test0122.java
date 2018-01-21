package com.java.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * �������´�ӡ��������ÿ���ڵ㣬ͬ����������Ҵ�ӡ(�������Ĳ�α���)
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
		//list�洢��ӡ�Ľ���ֵ
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(root==null)	return list;
		//deque��˫�˶��У��洢����Ҫ���ҵĽ��
		Deque<TreeNode> deque=new LinkedList<TreeNode>();
		
		deque.add(root);//add����������е�β��,push�����������ͷ��
		while(!deque.isEmpty()) {
			//��ǰ�ڵ����
			TreeNode node=deque.pop();
			//���ӽ�����list��
			list.add(node.val);
			//�жϳ��ӽ������ӽڵ�,�еĻ����
			if(node.left!=null)		deque.add(node.left);
			//�жϳ��ӽ������ӽڵ㣬�еĻ����
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
