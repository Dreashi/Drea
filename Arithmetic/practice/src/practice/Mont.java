package practice;

import java.util.Scanner;

public class Mont {
  static double MontePI(int n) {
	  double PI = 0;
	  double x,y;
	  int i,sum;
	  sum=0;
	  for(i=1;i<n;i++) {
		  x=Math.random();
		  y=Math.random();
		  if((x*x+y*y)<=1) {
			  sum++;
		  }
		  PI=4.0*sum/n;
		  
	  } 
	  return PI;
  }
  public static void main(String args[]) {
	  int n;
	  double PI;
	 System.out.println("���ؿ��޸����㷨����PI��");
	 Scanner input =new Scanner(System.in);
	 System.out.println("����������");
	 n=input.nextInt();
	 PI=MontePI(n);
	 System.out.println("PI="+PI);
  }
}
