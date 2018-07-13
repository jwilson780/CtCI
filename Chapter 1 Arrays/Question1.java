import java.util.HashSet;
import java.util.Set;
import java.util.stream.*;
import java.util.function.Supplier;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.counting;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class Question1{
	public static void main(String[] args){
		System.out.println(isUniqueOne("asdbefrk"));
		System.out.println(isUniqueTwo("asdbefrk"));
		System.out.println(isUniqueFunctional("asdbefrk"));
		System.out.println(isUniqueOne("asdbefrka"));
		System.out.println(isUniqueTwo("asdbefrka"));
		System.out.println(isUniqueFunctional("asdbefrka"));
		System.out.println(isUniqueOne("adsdbefrk"));
		System.out.println(isUniqueTwo("adsdbefrk"));
		System.out.println(isUniqueFunctional("adsdbefrk"));
		System.out.println(isUniqueOne("adsbefrkk"));
		System.out.println(isUniqueTwo("adsbefrkk"));
		System.out.println(isUniqueFunctional("adsbefrkk"));
	}

	/**
	* O(n^2) time, O(1) extra space
	*/
	public static boolean isUniqueOne(String str){
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				if(str.charAt(i)==str.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}

	/**
	* O(n) time, O(n) extra space
	*/
	public static boolean isUniqueTwo(String str){
		HashSet<Character> hs = new HashSet<Character>();
		for(char c : str.toCharArray()){
			if(hs.add(c)){
				continue;
			}
			else{
				return false;
			}
		}
		return true;
	}

	/**
	* Need to use a Supplier because streams cannot be used after 
	* they've been used or operated on 
	*/
	public static boolean isUniqueFunctional(String str){
		Supplier<IntStream> letterStreamSupplier = () -> str.chars();
		return letterStreamSupplier.get()
					.distinct()
					.count()
					==
					letterStreamSupplier.get()
					.count();
	}
}