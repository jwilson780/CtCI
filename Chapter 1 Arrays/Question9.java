public class Question9{
	public static void main(String[] args){
		System.out.println(isRotationOne("waterbottle","erbottlewat",0));
		System.out.println(isRotationOne("waterbottla","erbottlewat",0));
		System.out.println(isRotationOne("baterbottle","erbottlewat",0));
		
		System.out.println(isRotationTwo("waterbottle","erbottlewat"));
		System.out.println(isRotationTwo("abcabababab","ababababcab"));
		System.out.println(isRotationTwo("baterbottle","erbottlewat"));
		System.out.println(isRotationTwo("abacbababab","abcabababab"));
		
	}

	/**
	* O(n) time, O(n) space - method call stack
	*/
	public static boolean isRotationOne(String str1, String str2, int ctr){
		if(str1.length()!=str2.length() || str1.length()<2 || ctr >=str1.length()){
			return false;
		}
		if(str1.equals(str2)){
			return true;
		}
		return isRotationOne(str1,str2.substring(1,str2.length())+str2.charAt(0),++ctr);
	}

	/**
	*
	*/
	public static boolean isRotationTwo(String str1, String str2){
		int firstLetterPointer = 0;
		for(int i=str2.length()-1;i>=0;i--){
			if(str2.charAt(i)==str1.charAt(0)){
				firstLetterPointer = i;
			}
		}
		return str1.contains(str2.substring(0,firstLetterPointer));
	}
}