import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		if(n < m){
			System.out.println(0);
		}
		else{
			int r = in.nextInt();
			int[] arr = new int[n];
			int zeroCount = n;
			for(int i = 0 ; i < n ; i ++){
				//因为每一种花都要r朵，即r朵某种花组成一份有效的花，统一除以r去掉余数只存有效份数。
				arr[i] = in.nextInt()/r;
				zeroCount -= arr[i] == 0 ? 1 : 0;
			}
			
			/*
			 * 只存份数后这个题就转化成了，每次取m份各不相同的花，求最多取多少次。
			 * 对应在数组元素上表现为每次取m个元素每个减一，求最多可以减多少次。
			 * 
			 * 明显可以发现，如果先从最小值开始减，会导致原本就大的元素上冗余很多份数
			 * 并且没有足够的种类组成一束花，导致最大值的浪费，所以尽量从最大的开始减。
			 * 
			 * 这样这个题目就有了第二次转化，每次寻找最大的n个数，每个减一，再进行一下轮寻找
			 * 直到大于0的元素个数小于m为止，记录一共取出了多少次数---即多少束花。
			 * 
			 * 每次都找m个最大显然不用全部排序，使用堆排序的思路构建大顶堆后调整m个元素即可
			 */
			int res = 0;
			while(zeroCount >= m){
				zeroCount -= heapSort(arr,m);
				res++;
			}
			System.out.println(res);
		}
	}
	
	private static int heapSort(int[] arr,int m){
		int res = 0;		//统计是否有元素减到了0
		//从第一个非叶子结点开始,先构建大顶堆
		for(int i = arr.length/2-1; i>=0 ; i--){
			adjustHeap(arr, i, arr.length);
		}
		//从最后一个结点开始，交换最后和堆顶元素，每交换一个，找到一个当前最大
		//完整堆排序需要调整所有，这里只用调整m次
		for(int i = arr.length-1 ; i > arr.length-m-1; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			adjustHeap(arr, 0, i);
		}
		for(int i = arr.length-1 ; i > arr.length-m-1 ; i--){
			arr[i]--;
			res += arr[i] == 0 ? 1 : 0;
		}
//     打印迭代过程
//		for(int i = 0; i<arr.length ; i++){
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println("\n---------------------------\n");
		return res;
	}
	
	private static void adjustHeap(int[]arr,int i,int length){
        int temp = arr[i];
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }
	
}