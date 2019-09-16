package ant;
//快速排序              
public class Test001 {
	public static void main(String[] args){
		System.out.println("123");
		int []array={3,43,54,65,67,78,89,90,23,45};
		sort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		
	}
//	public static int[] quickSort(int []array){
//		
//	}
	public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
//            array[lo]=array[hi];
            swap(array,lo,hi);
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
//            array[hi]=array[lo];
            swap(array,lo,hi);
        }
        array[hi]=key;
        return hi;
    }
    public static void swap(int []array,int a, int b){
    	if(a!=b){
    		int temp;
    		temp=array[a];
    		array[a]=array[b];
    		array[b]=temp;
    	}
    }
    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi); 
    }
}
