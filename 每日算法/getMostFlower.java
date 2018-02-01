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
				//��Ϊÿһ�ֻ���Ҫr�䣬��r��ĳ�ֻ����һ����Ч�Ļ���ͳһ����rȥ������ֻ����Ч������
				arr[i] = in.nextInt()/r;
				zeroCount -= arr[i] == 0 ? 1 : 0;
			}
			
			/*
			 * ֻ�������������ת�����ˣ�ÿ��ȡm�ݸ�����ͬ�Ļ��������ȡ���ٴΡ�
			 * ��Ӧ������Ԫ���ϱ���Ϊÿ��ȡm��Ԫ��ÿ����һ���������Լ����ٴΡ�
			 * 
			 * ���Կ��Է��֣�����ȴ���Сֵ��ʼ�����ᵼ��ԭ���ʹ��Ԫ��������ܶ����
			 * ����û���㹻���������һ�������������ֵ���˷ѣ����Ծ��������Ŀ�ʼ����
			 * 
			 * ���������Ŀ�����˵ڶ���ת����ÿ��Ѱ������n������ÿ����һ���ٽ���һ����Ѱ��
			 * ֱ������0��Ԫ�ظ���С��mΪֹ����¼һ��ȡ���˶��ٴ���---������������
			 * 
			 * ÿ�ζ���m�������Ȼ����ȫ������ʹ�ö������˼·�����󶥶Ѻ����m��Ԫ�ؼ���
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
		int res = 0;		//ͳ���Ƿ���Ԫ�ؼ�����0
		//�ӵ�һ����Ҷ�ӽ�㿪ʼ,�ȹ����󶥶�
		for(int i = arr.length/2-1; i>=0 ; i--){
			adjustHeap(arr, i, arr.length);
		}
		//�����һ����㿪ʼ���������ͶѶ�Ԫ�أ�ÿ����һ�����ҵ�һ����ǰ���
		//������������Ҫ�������У�����ֻ�õ���m��
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
//     ��ӡ��������
//		for(int i = 0; i<arr.length ; i++){
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println("\n---------------------------\n");
		return res;
	}
	
	private static void adjustHeap(int[]arr,int i,int length){
        int temp = arr[i];
        for(int k=i*2+1;k<length;k=k*2+1){//��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
            if(k+1<length && arr[k]<arr[k+1]){//������ӽ��С�����ӽ�㣬kָ�����ӽ��
                k++;
            }
            if(arr[k] >temp){//����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//��tempֵ�ŵ����յ�λ��
    }
	
}