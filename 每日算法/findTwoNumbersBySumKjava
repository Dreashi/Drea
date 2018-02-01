import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[]arr = new int[n];
		for(int i = 0 ; i < n ; i++){
			arr[i] = in.nextInt();
		}
		int k = in.nextInt();
		
		//先排序，再用两个指针从两头遍历，和等于k输出，小于i++，大于j--，ij相遇结束
		quickSort(arr, 0, arr.length-1);
		getNumbersBySumK(arr, k);
	}
	private static void getNumbersBySumK(int[]arr,int k){
		int i = 0;
		int j = arr.length - 1;
		while(i < j){
			int tmp = arr[i] + arr[j];
			if(tmp == k){
				System.out.println(arr[i]+" "+arr[j]);
				break;
			}else if(tmp < k){
				i++;
			}else{
				j--;
			}
		}
	}
	
	private static void quickSort(int[]arr,int left,int right){
		if(left < right){
			int mid = par(arr, left, right);
			quickSort(arr, left, mid - 1);
			quickSort(arr, mid + 1, right);
		}
	}
	private static int par(int[]arr,int left,int right){
		int index = arr[left];
		while(left<right){
			while(left<right && arr[right] >= index){
				right--;
			}
			arr[left] = arr[right];
			while(left<right && arr[left] <= index){
				left++;
			}
			arr[right] = arr[left];
		}
		arr[right] = index;
		return right;
		
	}
	
}