import java.util.ArrayList;

public class Chapter1Problem8{

    /**
     * used to run and test the problem
     *
     */
    public static void main(String[] args){
      Chapter1Problem8 p8 = new Chapter1Problem8();
      int[][] test1 = {{1,2,3},{1,0,3},{1,2,3}};//single zero
      int[][] test2 = {{0,2,3},{1,0,3},{1,2,3}};//2 zeros
      int[][] test3 = {{0,0,3},{1,0,3},{1,0,0}};//many zeros
      System.out.println(p8.print2dArray(p8.problemEight(test1)));
      System.out.println(p8.print2dArray(p8.problemEight(test2)));
      System.out.println(p8.print2dArray(p8.problemEight(test3)));

    }

    /**
     * Problem 8: Write an algorithm such that if an element in a MxN matrix is 0,
     * its entire row and column is zero.
     */
     public int[][] problemEight(int[][] inputMatrix){
       //You must keep state in this problem (can't do it as you go)
       //loop over matrix and dump row and column values into 2 ArrayLists
       ArrayList<Integer> rowsToBeZeroed = new ArrayList<>();
       ArrayList<Integer> columnsToBeZeroed = new ArrayList<>();
       for(int i = 0; i < inputMatrix.length; ++i){
         for(int j = 0; j < inputMatrix[0].length; ++j){//if array row length differs this is wrong (it doesn't in this problem)
           if(inputMatrix[i][j] == 0){
             rowsToBeZeroed.add(i);
             columnsToBeZeroed.add(j);
           }
         }
       }

       //go through arraylists and zero out the columns/rows
       for(int i = 0; i < rowsToBeZeroed.size(); ++i){
         //loop across given row and zero out
         int rowZero = rowsToBeZeroed.get(i);
         for(int x = 0; i < inputMatrix[0].length; ++x){
           inputMatrix[rowZero][x] = 0;
         }
       }
       for(int i = 0; i < columnsToBeZeroed.size(); ++i){
         int colZero = columnsToBeZeroed.get(i);
         for(int x = 0; i < inputMatrix.length; ++x){
           inputMatrix[x][colZero] = 0;
         }
       }
       //return the modified array
       return inputMatrix;
     }

     public String print2dArray(int[][] arrayToPrint){
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < arrayToPrint.length; i++){
         for(int j = 0; j < arrayToPrint[0].length; ++j){
           sb.append(arrayToPrint[i][j]);
         }
         sb.append("\n");
       }
     }

}
