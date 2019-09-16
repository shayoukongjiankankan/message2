package ant;

public class Reorder {
	public static void main(String[] args){
		int []array={1,2,3,4,5,6,7,87,56,64,34,37,39};
		int []array1={1,2,3,4,5,6,7,87,56,64,34,37,39};
		reOrder(array1);
		patition(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		for(int i=0;i<array1.length;i++){
			System.out.print(array1[i]+" ");
		}
	}
	public static void reOrder(int []array){//能够保证相对位置不变，但是时间复杂度较高。
		int a=array.length;
		for(int i=0;i<a;i++){
			if(array[i]%2==0){
				int temp=array[i];
				for(int j=i;j<array.length-1;j++){
					
					array[j]=array[j+1];
				}
				array[array.length-1]=temp;
				i=i-1;
				a=a-1;
			}
		}
	}
	public static void patition(int []array,int lo,int hi){//无法保证相对位置不变，但是时间复杂度较小
		if(lo>hi){
			return ;
		}
		while(lo<hi){
			while(lo<hi&&array[lo]%2!=0){
				lo++;
			}
			swap(lo,hi,array);
			while(lo<hi&&array[hi]%2==0){
				hi--;
			}
			swap(lo,hi,array);
		}
	}
	public static void swap(int lo,int hi,int[] array){
		if(array[lo]==array[hi]){
			return ;
		}
		int temp=array[lo];
		array[lo]=array[hi];
		array[hi]=temp;
	}
}
