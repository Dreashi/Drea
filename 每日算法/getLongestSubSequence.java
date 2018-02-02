import java.util.Scanner;

public class Main{
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[]arr = new int[n];
		for(int i = 0 ; i < n ; i++){
			arr[i] = in.nextInt();
		}
		getLongestSubSequence(arr);
	}
	
	private static void getLongestSubSequence(int[]arr){
		int len = arr.length;
		int [] dp = new int[len];
		//dp[i] = 在0 <= j < i范围内，满足arr[i] > arr[j]条件的j对应的dp[j]中的最大值

		String[] subSequence = new String[len]; //记录子序列
		for(int i = 0 ; i < len ; i++){
			
			dp[i] = 1;   //最小长度为1
			subSequence[i] = String.valueOf(arr[i]);	//最小子序列为自身
			
			//遍历i之前的所有状态
			for(int j = 0 ; j < i ; j++){
				if(arr[i] > arr[j] && dp[i] < dp[j]+1){   //递增且暂时最长
					dp[i] = dp[j] + 1; 	//更新最大
					subSequence[i] = subSequence[j]+" "+arr[i];   //抓取子序列
				}
			}
		}
		
		System.out.println(dp[len-1]); 
		System.out.println(subSequence[len-1]);
	}
	
}