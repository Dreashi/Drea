public int getJumeCnt(int n){
		//由于只能一次跳一阶或者两阶，所以n阶段最终状态必然是由n-1或者n-2阶一步跳来的
		//换句话说就是第n阶次数为n-1的次数加n-2的次数
		//即斐波拉切数列求解，可以用递归也可以dp
		//但由于只用求第n阶，不需要存每一步的结果
		//所以本题的最优解为用两个变量反复相加求到第n阶
		
		/*	
			递归解法省略
			dp解法:
		
        if(n<3){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2 ; i < n ; i++){
            dp[i] = dp[i-1]+dp[i+2];
        }
        return dp[n-1];
		
		*/
		
		// 最优解
		if(n<3){
            return n;
        }
		int i = 1;
		int j = 2;
		while(n-- > 2){
			j = i + j;
			i = j - 1;
		}
		return j ;
    }