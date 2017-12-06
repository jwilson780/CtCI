import java.util.ArrayList;
public class Question3{
	public static void main(String[] args){
		BasicBinaryTreeNode a = new BasicBinaryTreeNode("A",null,null);//leaf node
		BasicBinaryTreeNode b = new BasicBinaryTreeNode("B",null,null);//leaf node
		BasicBinaryTreeNode c = new BasicBinaryTreeNode("C",a,b);
		BasicBinaryTreeNode d = new BasicBinaryTreeNode("D",c,null);
		BasicBinaryTreeNode e = new BasicBinaryTreeNode("E",null,null);
		BasicBinaryTreeNode f = new BasicBinaryTreeNode("F",null,e);
		BasicBinaryTreeNode g = new BasicBinaryTreeNode("G",null,null);
		BasicBinaryTreeNode h = new BasicBinaryTreeNode("H",f,g);
		BasicBinaryTreeNode i = new BasicBinaryTreeNode("I",null,h);
		BasicBinaryTreeNode j = new BasicBinaryTreeNode("J",d,i);
		BasicBinaryTree tree = new BasicBinaryTree(j);
		tree.depthFirstPrinter();

		tree.DFListMaker(tree.root,0);

		ArrayList<ArrayList<BasicBinaryTreeNode>> listOfDepthLists=tree.listOfDepthLists;
		for(int index=0;index<listOfDepthLists.size();index++){
			System.out.println("Depth "+index+":");
			for(int ji=0;ji<listOfDepthLists.get(index).size();++ji){
				System.out.print(listOfDepthLists.get(index).get(ji).data+" ");
			}
			System.out.println();
		}
	}
}

class BasicBinaryTree{
	BasicBinaryTreeNode root;
	ArrayList<ArrayList<BasicBinaryTreeNode>> listOfDepthLists = new ArrayList<ArrayList<BasicBinaryTreeNode>>();

	BasicBinaryTree(BasicBinaryTreeNode root){
		this.root = root;
	}

	void DFListMaker(BasicBinaryTreeNode root, int depth){
		if(root==null){
			return;
		}
		if(listOfDepthLists.size()==depth){
			listOfDepthLists.add(new ArrayList<BasicBinaryTreeNode>());
		}
		DFListMaker(root.left,depth+1);
		listOfDepthLists.get(depth).add(root);
		DFListMaker(root.right,depth+1);
	}

	void depthFirstPrinter(){
		System.out.println("Tree Contains:");
		DFHelper(root);
		System.out.println();
	}
	void DFHelper(BasicBinaryTreeNode root){
		if(root==null){
			return;
		}
		DFHelper(root.left);
		System.out.print(root.data+" ");
		DFHelper(root.right);
	}
}

class BasicBinaryTreeNode{
	Object data;
	BasicBinaryTreeNode left;
	BasicBinaryTreeNode right;
	BasicBinaryTreeNode(Object data, BasicBinaryTreeNode left, BasicBinaryTreeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}