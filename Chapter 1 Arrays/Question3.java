import java.util.stream.Collectors;
public class Question3{
	public static void main(String[] args){
		System.out.println(spaceReplaceOne(" This is a test "));
		System.out.println(spaceReplaceTwo(" This is a test "));
		System.out.println(spaceReplaceFunctional(" This is a test "));
		System.out.println(spaceReplaceOne("  "));
		System.out.println(spaceReplaceTwo("  "));
		System.out.println(spaceReplaceFunctional("  "));
	}

	/**
	* O(n) time, O(n) space
	* Assumption: Leading and trailing spaces removed
	*/
	public static String spaceReplaceOne(String str){
		char[] ca = str.trim().toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<ca.length;i++){
			if(ca[i]==' '){
				sb.append("%20");
				continue;
			}
			sb.append(""+ca[i]);
		}
		return sb.toString();
	}

	/**
	* O(?) time, O(1) space
	* Assumption: Leading and trailing spaces removed
	*/
	public static String spaceReplaceTwo(String str){
		return str.trim().replace(" ","%20");
	}

	public static String spaceReplaceFunctional(String str){
		return str.trim().codePoints()
					.mapToObj(c -> (char) c)
					.map(c -> c == ' ' ? "%20" : ""+c)
					.collect(Collectors.joining());
		}

	}

