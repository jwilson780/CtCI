import java.util.ArrayList;
public class Question7{
	public static void main(String[] args){
		//Leaving out parsing of (x,y) where 
		//dependencyMatrix[x][y]=t


		//Create adjacency matrix where a 1 means
		//row node comes before column node
		int[][] dependencyMatrix = {
		//	 a b c d e f
			{0,0,0,1,0,0},//a
			{0,0,0,1,0,0},//b
			{0,0,0,0,0,0},//c
			{0,0,1,0,0,0},//d
			{0,0,0,0,0,0},//e
			{1,1,0,0,0,0}//f
		};


		//root: all values in a column are 0
		System.out.println(BFStraversal(dependencyMatrix));
	}

	public static ArrayList<Integer> BFStraversal(int[][] depMat){
		ArrayList<Integer> numList=new ArrayList<Integer>();
		String result="";
		BasicQueue queue = new BasicQueue();
		boolean[] rowHasBeenVisited = new boolean[depMat.length];
		
		ArrayList<Integer> potentialRoots = findRoots(depMat); 
		for(Integer root : potentialRoots){
			queue.enqueue(root);
			rowHasBeenVisited[(int)root] = true;
		}
		while(!queue.isEmpty()){
			int next = (Integer)queue.dequeue();
			result += next+" ";
			numList.add(next);
			for(int i=0;i<depMat[next].length;i++){
				if(depMat[next][i]==1 && !rowHasBeenVisited[i]){
					queue.enqueue(i);
					rowHasBeenVisited[i] = true;
				}
			}
		}
		return numList;
		
	}

	public static ArrayList<Integer> findRoots(int[][] matrix){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<matrix[0].length;i++){
			for(int j=0;j<matrix.length;j++){
				if(matrix[j][i]==1){
					break;
				}
				if(j==matrix[0].length-1){
					result.add(i);
				}

			}
		}
		return result;
	}
}

class BasicQueue{
	BasicSLListNode head;
	BasicSLListNode tail;
	public BasicQueue(){
		head = tail = null;
	}
	boolean isEmpty(){
		return head==null && tail==null;
	}
	void enqueue(Object element){
		if(head==null){
			head =tail = new BasicSLListNode(element,null);
			return;
		}
		tail=tail.next=new BasicSLListNode(element,null);
	}
	Object dequeue(){
		if(head==null){
			return null;
		}
		BasicSLListNode temp = head;
		head = head.next;
		if(head==null){
			tail=null;
		}
		return temp.data;
	}
	public String toString(){
        String out = "SLList contains: \n";
        BasicSLListNode ref = head;
        if(head==null)
            return out + "0 Nodes";
        else
            out+="head :" + ref.data +"\n";
        int j =1;
        while(ref.next!=null){
            
            out+=ref.data + "\t->\t";
            if(j%5 ==0)
                out+="\n";
            ref=ref.next;
            ++j;
        }
        out+=ref.data + "\t->\tnull";
        return out;
    }
}

class BasicSLListNode{
	Object data;
	BasicSLListNode next;
	boolean visited;
	BasicSLListNode(Object data, BasicSLListNode next){
		this.data = data;
		this.next = next;
	}
}