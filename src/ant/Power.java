package ant;

public class Power {
	public static void main(String[] args){
		double result=Power(3.4,8);
		System.out.println(result);
		double result1=Power1(3.4,8);
		System.out.println(result1);
	}
	 public static double Power(double base, int exponent) {
	        double result=1;
	        if(base==0){
	           return 0; 
	        }else if(exponent==0){
	            return 1;
	        }else if(exponent<0){
	            base=1/base;
	            for(int i=0;i<-exponent;i++){
	                result=result*base;
	            }
	        }else if(exponent>0){
	            for(int i=0;i<exponent;i++){
	                result=result*base;
	            }
	        }
	        return result;    
	  }
	 public static double Power1(double base,int exponent){
		 if(base==0&&exponent==0){
			 return 0;
		 }else if(exponent==0){
			 return 1;
		 }else{
			 double result=Power1(base,exponent>>1);
			 result*=result;
			 if(exponent%2==1){
				 result*=base;
			 }
			 return result;
		 }
	 }
}
