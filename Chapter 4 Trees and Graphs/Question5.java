import java.util.ArrayList;
public class Question5{
	public static void main(String[] args){
		BasicBinaryTreeNode a1 = new BasicBinaryTreeNode(1,null,null);//leaf node
		BasicBinaryTreeNode b1 = new BasicBinaryTreeNode(2,null,null);//leaf node
		BasicBinaryTreeNode c1 = new BasicBinaryTreeNode(3,a1,b1);
		BasicBinaryTreeNode d1 = new BasicBinaryTreeNode(4,c1,null);
		BasicBinaryTreeNode e1 = new BasicBinaryTreeNode(5,null,null);
		BasicBinaryTreeNode f1 = new BasicBinaryTreeNode(6,null,e1);
		BasicBinaryTreeNode g1 = new BasicBinaryTreeNode(7,null,null);
		BasicBinaryTreeNode h1 = new BasicBinaryTreeNode(8,f1,g1);
		BasicBinaryTreeNode i1 = new BasicBinaryTreeNode(9,null,h1);
		BasicBinaryTreeNode j1 = new BasicBinaryTreeNode(10,d1,i1);
		BasicBinaryTree tree1 = new BasicBinaryTree(j1);
		tree1.depthFirstPrinter();
		System.out.println("Is tree 1 a binary search tree: "+tree1.isBinarySearchTree(tree1.root,null,true));
		BasicBinaryTreeNode a2 = new BasicBinaryTreeNode(1,null,null);//leaf node
		BasicBinaryTreeNode b2 = new BasicBinaryTreeNode(3,null,null);//leaf node
		BasicBinaryTreeNode c2 = new BasicBinaryTreeNode(2,a2,b2);
		BasicBinaryTreeNode d2 = new BasicBinaryTreeNode(4,c2,null);
		BasicBinaryTreeNode e2 = new BasicBinaryTreeNode(8,null,null);
		BasicBinaryTreeNode f2 = new BasicBinaryTreeNode(7,null,e2);
		BasicBinaryTreeNode g2 = new BasicBinaryTreeNode(10,null,null);
		BasicBinaryTreeNode h2 = new BasicBinaryTreeNode(9,f2,g2);
		BasicBinaryTreeNode i2 = new BasicBinaryTreeNode(6,null,h2);
		BasicBinaryTreeNode j2 = new BasicBinaryTreeNode(5,d2,i2);
		BasicBinaryTree tree2 = new BasicBinaryTree(j2);
		tree2.depthFirstPrinter();
		System.out.println("Is tree 2 a binary search tree: "+tree2.isBinarySearchTree(tree2.root,null,true));
	}
}

class BasicBinaryTree{
	BasicBinaryTreeNode root;
	ArrayList<ArrayList<BasicBinaryTreeNode>> listOfDepthLists = new ArrayList<ArrayList<BasicBinaryTreeNode>>();

	boolean isBinarySearchTree(BasicBinaryTreeNode root,Object previousValue, boolean inOrder){
		if(!inOrder){
			return false;
		}
		if(root==null){
			return true;
		}
		inOrder = isBinarySearchTree(root.left,previousValue,inOrder);
		if(root.left!=null){
			previousValue = root.left.data;
		}
		if(previousValue!=null){
			inOrder = (int)root.data>=(int)previousValue;
		}
		inOrder = isBinarySearchTree(root.right,root.data,inOrder);
		return inOrder;
	}

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