import java.util.HashMap;
import java.util.ArrayList;

public class Problem4{
  /**
   * used to run and test the problem
   *
   */
    public static void main(String[] args){
      Problem4 p4 = new Problem4();
      System.out.println(p4.problemFourBetter("aaa dsa"));
      System.out.println(p4.problemFourBetter("aadd sa"));
      System.out.println(p4.problemFourBetter("aa da"));
      System.out.println(p4.problemFourBetter("aaaababbba"));
      System.out.println(p4.problemFourBetter("aaa dsa"));
    }



    /**
     * Given string, write method to see if it is a permutation of a palendrome
     * Had trouble with this one, I have other solutions that are not perfect, but much faster
     */
     public boolean problemFourBruteForce(String input){
       /*The strings are separated into words, but they ignore spaces and the
       chars in one word can be used in the next

       brute force says to make all the permutations, then check if they are
       palendromes, may be able to optimize that.*/

       input = input.replaceAll("\\s+",""); //replace all whitespace in input
       //create a permutation of the above and (check it as you go(optimize)).  If you find
       //a palendrome you stop it all.  Again there has to be a better way.

       //I found permutations recursivley, in interview, maybe don't do that
       //and check after each one.

       ArrayList<String> perms = permutation("",input);
       printArrayList(perms);
       //now go over permutations and check to see if palendrome
       for(int i = 0; i < perms.size(); ++i){
         if(isPalendrome(perms.get(i))){
           return true;
         }
       }
       return false;
     }

      //generates all perm of string
      private static ArrayList<String> permutation(String prefix, String str){
        ArrayList<String> permutations = new ArrayList<>();
        int n = str.length();
        if (n == 0){
            permutations.add(prefix);
        }else{
            for (int i = 0; i < n; i++){
                permutations.addAll(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)));
            }
        }
        return permutations;
      }

     private boolean isPalendrome(String str){
       char[] strArray = str.toCharArray();
       for(int i = 0; i < strArray.length/2; ++i){
         if(strArray[i] != strArray[strArray.length - 1 - i]){
           return false;
         }
       }
       return true;
     }

     private void printArrayList(ArrayList<String> list){
       String[] array = list.toArray(new String[0]);
       for(int i = 0; i < array.length; ++i){
         System.out.print(array[i] + " : " );
       }
     }







     /**
      * More elgant solution
      */
      public boolean problemFourBetter(String input){
        input = input.replaceAll("\\s+","");
        //palendromes have 2 cases: odd and even
        //first check to see if input exists
        if(input.length() == 0){
          return false;
        }
        //first map all letters
        //get a letter count
        HashMap<Character, Integer> letterMap = new HashMap<>();
        char[] inputArray = input.toCharArray();
        for(int i = 0; i < inputArray.length; ++i){
          //check if key exists (letter)
          if(letterMap.containsKey(inputArray[i])){
            //we update its value
            letterMap.put(inputArray[i], letterMap.get(inputArray[i])+1);
          }else{
            //we add it since its new
            letterMap.put(inputArray[i], 1);
          }
        }
        Integer[] values = letterMap.values().toArray(new Integer[0]);
        //even case
        if(input.length() % 2 == 0){
          //now we need to check and see if there are any odd values in the map
          for(int i : values){
            if(i%2 != 0){
              return false;
            }
          }
          return true;
        }else{//its odd
          //there can be all evens and a single odd value (not multiple odds)
          int oddCount = 0;
          for(int i : values){
            if(i%2 != 0){
              oddCount+=1;
            }
          }
          if(oddCount == 1){
            return true;
          }else{
            return false;
          }
        }
      }

}
