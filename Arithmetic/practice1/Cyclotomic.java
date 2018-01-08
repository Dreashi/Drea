package practice1;

import java.util.Scanner;

public class Cyclotomic {
    static void cyclotomic(int n) {
	int i,s;
	double k,len;
	i=0;
	k=3.0;
	len=1.0;
	s=6;
	while(i<=n) {
		System.out.print("第%2d次切割，为正%5d边形，PI=%.24f\n",i,s,k*Math.sqrt(len));
      s*=2;
      len=2-Math.sqrt(4-len);
      i++;
      k*=2.0;
	}
}
public  static void main(String args[]) {
	int n;
	System.out.print("切割次数");
	Scanner input =new Scanner(System.in);
	n=input.nextInt();
	cyclotomic(n);
}
}
