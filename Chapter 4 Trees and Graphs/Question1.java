public class Question1{
	public static void main(String[] args){
		BasicNode a = new BasicNode("A");
		BasicNode b = new BasicNode("B");
		BasicNode c = new BasicNode("C");
		BasicNode d = new BasicNode("D");
		BasicNode e = new BasicNode("E");
		BasicNode f = new BasicNode("F");
		BasicNode g = new BasicNode("G");
		a.children=new BasicNode[]{b,c};
		b.children=new BasicNode[]{e};
		c.children=new BasicNode[]{g,d};
		e.children=new BasicNode[]{g};
		f.children=new BasicNode[]{d};
		BasicGraph graph = new BasicGraph();
		graph.nodes = new BasicNode[]{a,b,c,d,e,f,g};
		graph.depthFirstPrinter(0);
		graph.depthFirstPrinter(5);

		//all true
		System.out.println(graph.checkIfConnected(a,b));
		System.out.println(graph.checkIfConnected(a,e));
		System.out.println(graph.checkIfConnected(a,g));
		System.out.println(graph.checkIfConnected(a,c));
		System.out.println(graph.checkIfConnected(g,b));

		//all false
		System.out.println(graph.checkIfConnected(a,f));
		System.out.println(graph.checkIfConnected(c,f));
		System.out.println(graph.checkIfConnected(g,d));
		System.out.println(graph.checkIfConnected(e,c));
	}
}

class BasicGraph{
	public BasicNode[] nodes;
	void depthFirstPrinter(int root){
		System.out.println("Graph Contains:");
		DFHelper(nodes[root]);
		System.out.println();
		unvisitNodes();
	}
	/*
	* Worst case runtime: O(v) - graph is linked list 
	* O(v) extra space
	*/
	void DFHelper(BasicNode root){
		if(root==null){
			return;
		}
		if(root.visited){
			return;
		}
		System.out.print(root.data+" ");
		root.visited=true;
		if(root.children==null){
			return;
		}
		for(BasicNode e : root.children){
			DFHelper(e);
		}
	}
	void unvisitNodes(){
		for(BasicNode node : nodes){
			node.visited=false;
		}
	}
	/*
	* O(n * (v + e)) runtime 
	* n is the number of nodes in the graph
	* v is the number of vertices connected to the current root taken from n
	* e is the number of edges that connect all vertices to the current root/children
	* O(n) extra space because of queue in breadthFirstSearch
	* This works for directed & undirected graphs
	*/
	boolean checkIfConnected(BasicNode a, BasicNode b){
		BasicNode startNode;
		boolean areConnected=false;
		for(int i=0;i<nodes.length;i++){
			if(a==nodes[i]){
				areConnected = breadthFirstSearch(i,b);
				break;
			}
		}
		unvisitNodes();
		if(areConnected){
			return true;
		}
		for(int i=0;i<nodes.length;i++){
			if(b==nodes[i]){
				areConnected = breadthFirstSearch(i,a);
			}
		}
		unvisitNodes();
		return areConnected;
	}
	/*
	* O(v + e) runtime
	* v is the number of vertices connected to the root, which
	*   may eventually be in the queue
	* e is the number of edges
	* It is not O(v * e) because different vertices have different 
	* 	number of edges
	* O(v) extra space
	*/
	boolean breadthFirstSearch(int root_location, BasicNode destination){
		BasicQueue queue = new BasicQueue();
		BasicNode root = nodes[root_location];
		root.visited=true;
		queue.append(root);
		while(!queue.isEmpty()){
			BasicNode currNode = (BasicNode)queue.getHead().data;
			if(currNode.data==destination.data){
				return true;
			}
			for(BasicNode n:currNode.children){
				if(!n.visited){
					n.visited=true;
					queue.append(n);
				}
			}
		}
		return false;
	}
}

class BasicNode{
	Object data;
	boolean visited=false;
	BasicNode[] children;
	BasicNode(Object d){
		data=d;
		children=new BasicNode[]{};
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
	void append(Object element){
		if(head==null){
			head =tail = new BasicSLListNode(element,null);
			return;
		}
		tail=tail.next=new BasicSLListNode(element,null);
	}
	BasicSLListNode getHead(){
		if(head==null){
			return null;
		}
		BasicSLListNode temp = head;
		head = head.next;
		if(head==null){
			tail=null;
		}
		return temp;
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
	BasicSLListNode(Object data, BasicSLListNode next){
		this.data = data;
		this.next = next;
	}
}