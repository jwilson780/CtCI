import java.util.stream.*;
import java.util.List;

public class Question9{
	public static void main(String[] args){
		System.out.println(isRotationOne("waterbottle","erbottlewat",0));
		System.out.println(isRotationOne("waterbottla","erbottlewat",0));
		System.out.println(isRotationOne("baterbottle","erbottlewat",0));
		
		System.out.println(isRotationFunctional("waterbottle","erbottlewat"));
		System.out.println(isRotationFunctional("abcabababab","ababababcab"));
		System.out.println(isRotationFunctional("baterbottle","erbottlewat"));
		System.out.println(isRotationFunctional("abacbababab","abcabababab"));
		
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

	public static boolean isRotationFunctional(String str1, String str2){
		List<String> strings = IntStream.range(0,str1.length())
				.mapToObj(p -> str1.substring(p,str1.length()) + str1.substring(0,p))
				.collect(Collectors.toList());
		return strings.stream()
				.anyMatch(s -> s.equals(str2));
	}
}