package ant;
//顺时针打印矩阵
import java.util.ArrayList;

public class Printmatrix {
	public static void main(String[] args){
		int[][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ArrayList<Integer> print=printMatrix(matrix);
		for(int i=0;i<print.size();i++){
			System.out.print(print.get(i)+" ");
		}
	}
	public static  ArrayList<Integer> printMatrix(int [][] matrix) {
	       int rows=matrix.length;
	       int cows=matrix[0].length;
	       ArrayList<Integer> print=new ArrayList<Integer>();
	       if(cows==0||rows==0){
	    	   return null;
	       }
	       int start=0;
	       
	       while(rows>start*2&&cows>2*start){//循环条件
	    	int endX=cows-start-1;//x轴结束
	   		int endY=rows-start-1;//y轴结束
	   		for(int i=start;i<=endX;i++){//一定会有第一次横向打印
	   			print.add(matrix[start][i]);
	   		}
	   		if(start<endY){//进入第二次竖着打印的条件
	   			for(int i=start+1;i<=endY;i++){
	   				print.add(matrix[i][endX]);
	   			}
	   		}
	   		if(start<endX&&start<endY){//进入第三次反向横着打印的条件
	   			for(int i=endX-1;i>=start;i--){
	   				print.add(matrix[endY][i]);
	   			}
	   		}
	   		if(start<endX&&start<endY-1){//进入第四次反向竖着的条件
	   			for(int i=endY-1;i>start;i--){
	   				print.add(matrix[i][start]);
	   			}
	   			
	   		}
	    	   start++;
	       }
	       return print;
	    }

}
