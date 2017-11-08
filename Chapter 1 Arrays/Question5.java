public class Question5{
	public static void main(String[] args){
		//True Cases
		System.out.println(oneEditAway("ale","pale"));
		System.out.println(oneEditAway("a","b"));
		System.out.println(oneEditAway("pal","pale"));
		System.out.println(oneEditAway("pae","pale"));
		System.out.println(oneEditAway("pale","pale"));
		System.out.println(oneEditAway("pale","paxle"));
		System.out.println(oneEditAway("pale","palx"));
		//False
		System.out.println(oneEditAway("pa","pale"));
		System.out.println(oneEditAway("pall","pble"));
		System.out.println(oneEditAway("leap","pale"));
	}

	/**
	* O(n) time, O(n) space because String creation
	*/
	public static boolean oneEditAway(String str1, String str2){
		//Zero edits
		if(str1.equals(str2)){
			return true;
		}
		int diff = Math.abs(str1.length()-str2.length());
		if(diff>1){ // too much difference
			return false;
		}else if(diff == 1){ //potential insertion or deletion
			String shorter,longer;
			if(Math.max(str1.length(),str2.length())==str1.length()){
				longer=str1;
				shorter=str2;
			}else{
				longer=str2;
				shorter=str1;
			}
			int j=0;
			for(int i=0;i<longer.length()&&j<shorter.length();i++){
				if(Math.abs(i-j)>1){
					return false;
				}
				if(longer.charAt(i)==shorter.charAt(j)){
					j++;
				}
			}
			return true;
		}else{ //potential change
			int numDiffs =0;
			for(int i=0;i<str1.length();i++){
				if(str1.charAt(i)!=str2.charAt(i)){
					numDiffs++;
				}
				if(numDiffs>1){
					return false;
				}
			}
			return true;
		}
	}
}