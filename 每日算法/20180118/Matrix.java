package com.java.number;

/**
 * 输入一个矩阵，按照从外向里顺时针的顺序依次打印出每一个数字
 * @date 2018/1/18
 * @author lenovo
 *
 */

public class Matrix {
	
	public static void printMatrix(int[][] matrix){	
		if(matrix==null) {
			return;
		}
		int rows=matrix.length;
		int column=matrix[0].length;
		int start=0;
		
		while(column>start*2 && rows>start*2) {
			int endX=column-start-1;
			int endY=rows-start-1;
			for(int i=start; i<=endX; i++) {
				System.out.print(matrix[start][i]+" ");
			}
			if(endY>start) {
				for(int i=start+1; i<=endY; i++) {
					System.out.print(matrix[i][endY]+" ");
				}
			}
			if(endY>start && endX>start) {
				for(int i=endX-1; i>=start; i--) {
					System.out.print(matrix[endY][i]+" ");
				}
			}
			if(endY-1>start && endX>start) {
				for(int i=endY-1; i>=start+1; i--) {
					System.out.print(matrix[i][start]+" ");
				}
			}
			start++;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},
				{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		printMatrix(matrix);
	}

}
