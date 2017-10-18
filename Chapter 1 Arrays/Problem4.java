

public class Problem4{

  /**
   * used to run and test the problem
   *
   */
    public static void main(String[] args){

    }

    /**
     * Given string, write method to see if it is a permutation of a palendrome
     * Had trouble with this one, I have other solutions that are not perfect, but much faster
     */
     public boolean problemFour(String input){
       /*The strings are separated into words, but they ignore spaces and the
       chars in one word can be used in the next

       brute force says to make all the permutations, then check if they are
       palendromes, may be able to optimize that.*/

       input.replaceAll("\\s+",""); //replace all whitespace in input
       //create a permutation of the above and (check it as you go(optimize)).  If you find
       //a palendrome you stop it all.  Again there has to be a better way.

       //I found permutations recursivley, in interview, maybe don't do that
       //and check after each one.

       ArrayList<String> allPermutationsOfInput = permutations(input);
       //now go over permutations and check to see if palendrome
       for(int i = 0; i < allPermutationsOfInput.size(); ++i){
         if(isPalendrome(allPermutationsOfInput.get(i))){
           return true;
         }
       }
       return false;
     }

     public ArrayList<String> permutations(String s){
       return permutations("", s);
     }

     private ArrayList<String> permutations(String prefix, String wholeString, ArrayList<String> list){
       int size = wholeString.length;
       //base case (we are done)
       if(size == 0){
         list.add(prefix);
       }else{
         for(int i = 0; i < n; ++i){//create all permutations recur
           permutations(prefix + wholeString.charAt(i), wholeString.substring(0, i) + wholeString.substring(i + 1, n), list);
         }
       }

     }

     private boolean isPalendrome(String str){
       for(int i = 0; i < str.length/2; ++i){
         if(str.charAt(i) != str.charAt(str.length-1-i)){
           return false;
         }
       }
       return true;
     }



}
