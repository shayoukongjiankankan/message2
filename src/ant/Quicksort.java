package ant;

public class Quicksort {
	public static void main(String[] args){
		int []array={3,43,54,65,67,78,89,90,23,45};
		quickSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	public static void quickSort(int []array,int lo,int hi){
		if(lo>hi){
			return ;
		}
		int index=Patition(array,lo,hi);
		quickSort(array,lo,index-1);
		quickSort(array,index+1,hi);
		
	}
	public static int Patition(int []array,int lo,int hi){
		int key=array[lo];
		while(lo<hi){
			while(array[hi]>=key&&lo<hi){
				hi--;
			}
			swap(array, lo, hi);
			
			
			
			while(array[lo]<=key&&lo<hi){
				lo++;
			}
			swap(array, lo, hi);
			
						
		}
		
		return lo;
	}
	private static void swap(int[] array, int lo, int hi) {
		int temp=array[hi];
		array[hi]=array[lo];
		array[lo]=temp;
	}
}
