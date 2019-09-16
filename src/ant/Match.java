package ant;

public class Match {
	public static void main(String[] args){
		
	}
	public static boolean match(char[] str,char[] pattern){
//		if(str.length==0&&pattern.length==0){
//			return true;
//		}
//		if(str.length!=0&&pattern.length==0){
//			return false;
//		}
		 if (str == null || pattern == null) {
		        return false;
		    }
		int strIndex=0;
		int patIndex=0;
		return match4(str, pattern, strIndex, patIndex);
		
	}
	public static boolean match4(char[] str, char[] pattern, int strIndex, int patIndex) {
		if(strIndex==str.length&&patIndex==pattern.length){
			return true;
		}if(strIndex!=str.length&&patIndex==pattern.length){
			return false;
		}
		if(patIndex+1<pattern.length&&pattern[patIndex+1]=='*'){
			if((strIndex!=str.length&&str[strIndex]==pattern[patIndex])||(pattern[patIndex]=='.'&&strIndex!=str.length)){
				return match4(str,pattern,strIndex,patIndex+2)
						||match4(str,pattern,strIndex+1,patIndex+2)
						||match4(str,pattern,strIndex+1,patIndex);
			}
			else{
				return match4(str,pattern,strIndex,patIndex+2);
			}
		}
//		 if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
//		        if ((strIndex != str.length && pattern[patIndex] == str[strIndex]) || (pattern[patIndex] == '.' && strIndex != str.length)) {
//		            return match4(str, pattern, strIndex,  patIndex + 2)//模式后移2，视为x*匹配0个字符
//		                    || match4(str, pattern, strIndex + 1,  patIndex + 2)//视为模式匹配1个字符
//		                    || match4(str, pattern, strIndex + 1,  patIndex);//*匹配1个，再匹配str中的下一个
//		        } else {
//		            return match4(str, pattern, strIndex,  patIndex + 2);
//		        }
//		    }
//		
		if(strIndex!=str.length&&str[strIndex]==pattern[patIndex]||pattern[patIndex]=='.'&&strIndex!=str.length){
				return match4(str,pattern,strIndex+1,patIndex+1);
			}else{
				return false;
			}
			
		
	}
}
