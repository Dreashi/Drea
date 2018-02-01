import java.util.Scanner;

public class Main {

    private static int getLongestTime(int[]arr,int t){
        int len = arr.length-1;
        int[][] dp = new int[len][t+1];
        for(int i = 0 ; i < t ; i++){
            dp[0][i] = arr[0] < i ? arr[0] : 0;
        }
        for(int i = 1 ; i < len ; i++){
            int temp = arr[i];
            for(int j = 0 ; j < t+1; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j]);
                if(arr[i] < j){
                    dp[i][j] = Math.max(dp[i-1][j-temp]+temp,dp[i][j]);
                }
            }
        }
//         //动态规划表
//        for(int i = len-1 ; i > -1 ; i--){
//            for(int j = 0 ; j < t+1; j++){
//                String str = dp[i][j] > 9 ? " " : "  ";
//                System.out.print(str+dp[i][j]);
//            }
//            System.out.println();
//        }
        
        return dp[len-1][t] + arr[len];
    }

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[]arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = in.nextInt();
        }


        findAndSwapMax(arr);
        System.out.println(getLongestTime(arr,t));
    }
    //找到最大值放到最后
    private static void findAndSwapMax(int[]arr){
        int maxIndex = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[arr.length-1];
        arr[arr.length-1] = temp;
    }
}