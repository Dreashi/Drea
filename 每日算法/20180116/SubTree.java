package com.java.list;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author lenovo
 *
 */

public class SubTree {
	public static class TreeNode{
		int val;
		TreeNode left=null;
		TreeNode right=null;
		
		public TreeNode(int val) {
			this.val=val;
		}
	}
	
	public static boolean isTree(TreeNode root1, TreeNode root2) {
		if(root1==null && root2!=null)	return false;
		if(root2==null)	return true;
		if(root1.val!=root2.val)	return false;
		return isTree(root1.left,root2.left) && isTree(root1.right, root2.right);
	}
	
	public static boolean hadSubTree1(TreeNode root1, TreeNode root2) {
		if(root1==null || root2==null)	return false;
		return isTree(root1,root2)||hadSubTree1(root1.left,root2) || hadSubTree1(root1.right,root2);
		
	}
	
	public static boolean hadSubTree2(TreeNode  root1, TreeNode root2) {
		boolean result=false;
		if(root1!=null && root2!=null) {
			if(root1.val==root2.val) {
				result=isTree(root1,root2);
			}
			if(!result) {
				result=hadSubTree2(root1.left,root2);
			}
			if(!result) {
				result=hadSubTree2(root1.right,root2);
			}
		}
		return result;
	}
	
	//通过前序遍历和中序遍历重建二叉树
	public static TreeNode build(int[] pre, int startpre, int endpre, int[] in, int startin, int endin) {
		if(startin>endin || startpre>endpre)	return null;
		TreeNode root=new TreeNode(pre[startpre]);
		for(int i=startin; i<=endin; i++) {
			if(in[i]==pre[startpre]) {
				root.left=build(pre, startpre+1, startpre+i-startin, in, startin, i-1);
				root.right=build(pre, startpre+i-startin+1, endpre, in, i+1, endin);
				break;
			}
		}
		return root;
	}
	
	public static TreeNode fun(int[] pre, int startpre, int endpre, int[] in, int startin, int endin) {
		if (startin > endin || startpre > endpre) {
			return null;
		}
		TreeNode root = new TreeNode(pre[startpre]);

		for (int i = startin; i <= endin; i++) {
			if (in[i] == pre[startpre]) {
				//pre的下一个起点为startpre+1,终点是起点加左子树结点个数
				root.left = fun(pre, startpre + 1, startpre + i - startin, in, startin, i - 1);
				//pre的起点是左子树终点加1
				root.right = fun(pre, startpre+i-startin+1, endpre, in, i + 1, endin);
				break;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		int[] parentPre = {8,8,9,2,4,7,7};
		int[] parentIn = {9,8,4,2,7,8,7};
		int[] sonPre = {8,9,2};
		int[] sonIn = {9,8,2};
		
		TreeNode parent=fun(parentPre,0,parentPre.length-1,parentIn,0,parentIn.length-1);
		TreeNode son=fun(sonPre,0,sonPre.length-1,sonIn,0,sonIn.length-1);
		
		boolean bool=hadSubTree2(parent,son);
		System.out.println(bool);
	}

}
