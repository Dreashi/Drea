#include<stdio.h>
bool duplicate(int numbers[],int length){
	if(numbers==NULL||length<=0){
		return false;
	}
	for(int i=0;i<length;i++){
		if(numbers[i]<0||numbers[i]>length-1){
			return false;
		}
	}
	for(int i=0;i<length;i++){
		while(i!=numbers[i]){
			if(numbers[i]==numbers[numbers[i]]){
			//	*duplication=numbers[i];
				return true;
			}
			//½»»»numbers[i] ºÍnumbers[numbers[i]]
			int temp=numbers[i];
			numbers[i]=numbers[temp];
			numbers[temp]=temp;
			 
		}
	}
	return false;
}
int main(void){
	int numbers[7]={2,3,1,0,2,5,3};
   	duplicate(numbers,7);
	//printf("%s",boolean);
}
