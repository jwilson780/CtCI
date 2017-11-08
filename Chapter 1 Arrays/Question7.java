public class Question7{
	public static void main(String[] args){
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] b = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		print2dMatrix(a);
		print2dMatrix(rotate90DegreesOne(a));
		print2dMatrix(b);
		print2dMatrix(rotate90DegreesOne(b));
		a = bew int[][]{{1,2,3},{4,5,6},{7,8,9}};
		b = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		print2dMatrix(a);
		print2dMatrix(rotate90DegreesTwo(a));
		print2dMatrix(b);
		print2dMatrix(rotate90DegreesTwo(b));
	}

	/*
	* O(n^2) time, O(n^2) extra space
	*/
	public static int[][] rotate90DegreesOne(int[][] a){
		int[][] newArray = new int[a.length][a[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				int newRow=j;
				int newCol=a.length-1-i;
				newArray[newRow][newCol]=a[i][j];
			}
		}
		return newArray;
	}

	/*
	* O(n^2) time, O(1) extra space
	*/
	public static int[][] rotate90DegreesTwo(int[][] a){
		//special case
		if(a.length==1){
			return a;
		}
		//rotate inner arrays for each ring
		for(int i=0; i<a.length/2;i++){
			for(int j=i+1;j<a.length-1-i;++j){
				int temp = a[i][j];
				a[i][j] = a[a.length-1-j][i];
				a[a.length-1-j][i] = a[a.length-1-i][a.length-1-j];
				a[a.length-1-i][a.length-1-j] = a[j][a.length-1-i];
				a[j][a.length-1-i] = temp;
			}
		}
		//rotate 4 corners of each ring
		for(int i=0; i<a.length/2;i++){
			int temp = a[i][i];
			a[i][i] = a[a.length-1-i][i];
			a[a.length-1-i][i] = a[a.length-1-i][a.length-1-i];
			a[a.length-1-i][a.length-1-i] = a[i][a.length-1-i];
			a[i][a.length-1-i] = temp;
		}
		return a;
	}

	public static void print2dMatrix(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				System.out.printf("%3d",a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}