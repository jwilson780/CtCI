import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.*;
import java.util.stream.IntStream;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.Arrays;
public class Question5{
	public static void main(String[] args){
		BasicSLList list1 = new BasicSLList();
		list1.append(7);//617 reverse, 716 regular
		list1.append(1);
		list1.append(6);
		System.out.println("List 1: "+list1);
		BasicSLList list2 = new BasicSLList();
		list2.append(5);//295 reverse, 592 regular
		list2.append(9);
		list2.append(2);
		System.out.println("List 2: "+list2);
		System.out.println(addReverseOne(list1,list2));
		System.out.println(addReverseTwo(list1,list2));
		System.out.println(addRegularOne(list1,list2));

		LinkedList<Integer> l1=new LinkedList<>();
		l1.add(7);
		l1.add(1);
		l1.add(6);
		LinkedList<Integer> l2=new LinkedList<>();
		l2.add(5);
		l2.add(9);
		l2.add(2);
		System.out.println(addReverseFunctional(l1,l2));
		System.out.println(addRegularFunctional(l1,l2));
	}

	/**
	* O(n) time,O(n) space
	*/
	public static BasicSLList addReverseOne(BasicSLList list1, BasicSLList list2){
		BasicSLListNode p1 = list1.head;
		String s1="";
		BasicSLListNode p2 = list2.head;
		String s2="";
		while(p1!=null){
			s1+=p1.data;
			p1=p1.next;
		}
		while(p2!=null){
			s2+=p2.data;
			p2=p2.next;
		}
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);
		int i1 = Integer.parseInt(sb1.reverse().toString());
		int i2 = Integer.parseInt(sb2.reverse().toString());
		int sum = i1+i2;
		String sumString =sum+"";
		BasicSLList sumList = new BasicSLList();
		for(int i=0;i<sumString.length();++i){
			sumList.append(sumString.charAt(i));
		}
		return sumList;
	}

	/**
	* O(n) time,O(n) space
	*/
	public static BasicSLList addReverseTwo(BasicSLList list1, BasicSLList list2){
		BasicSLListNode p1 = list1.head;
		int num1=0;
		int num1Ctr=0;
		BasicSLListNode p2 = list2.head;
		int num2=0;
		int num2Ctr=0;
		while(p1!=null){
			int i = new Integer((int)p1.data);
			num1+= i*Math.pow(10,num1Ctr++);
			p1=p1.next;
		}
		while(p2!=null){
			int i = new Integer((int)p2.data);
			num2+=i*Math.pow(10,num2Ctr++);
			p2=p2.next;
		}
		int sum = num1+num2;
		int powerChecker =1;
		while(powerChecker*10<sum){
			powerChecker*=10;
		}
		BasicSLList sumList = new BasicSLList();
		while(powerChecker>0){
			sumList.append(sum/powerChecker);
			sum = sum % powerChecker;
			powerChecker/=10;
		}
		return sumList;
	}

	/**
	* This is a bit of cheating. I just reverse the Linked List before turning 
	* it into a stream. IN order to do that, I had to use a spliterator, which
	* I've read is a bad idea unless you're designing streamable data structures.
	* The only way I found in the LinkedList class to reverse it was to use
	* descendingIterator. 
	* A bit hacky&unreadable, but functional regardless.
	* There has to be a better functional way.
	*/
	public static LinkedList<Integer> addReverseFunctional(LinkedList<Integer> l1,
												LinkedList<Integer> l2){
		int num1 = Integer.parseInt(
			StreamSupport.stream(Spliterators.spliteratorUnknownSize(l1.descendingIterator(),
																	Spliterator.ORDERED),false)
					.map(val -> ""+val)
					.collect(Collectors.joining()));
		int num2 = Integer.parseInt(
			StreamSupport.stream(Spliterators.spliteratorUnknownSize(l2.descendingIterator(),
																	Spliterator.ORDERED),false)
					.map(val -> ""+val)
					.collect(Collectors.joining()));
		int sum = num1+num2;
		Integer[] digits = Integer.toString(sum).chars()
					.mapToObj(c->new Integer(Integer.parseInt(""+(c-'0'))))
					.toArray(Integer[]::new);
		return new LinkedList<Integer>(Arrays.asList(digits));
	}

	/**
	* O(n) time,O(n) space
	*/
	public static BasicSLList addRegularOne(BasicSLList list1, BasicSLList list2){
		BasicSLListNode p1 = list1.head;
		int num1=0;
		int num1Ctr=0;
		BasicSLListNode p2 = list2.head;
		int num2=0;
		int num2Ctr=0;
		while(p1!=null){
			num1 = num1*10 + new Integer((int)p1.data);
			p1=p1.next;
		}
		while(p2!=null){
			num2 = num2*10 + new Integer((int)p2.data);
			p2=p2.next;
		}
		int sum = num1+num2;
		System.out.println(num1 + " + "+num2 + " = "+ sum);
		int powerChecker =1;
		while(powerChecker*10<sum){
			powerChecker*=10;
		}
		BasicSLList sumList = new BasicSLList();
		while(powerChecker>0){
			sumList.append(sum/powerChecker);
			sum = sum % powerChecker;
			powerChecker/=10;
		}
		return sumList;
	}	

	/**
	* First have to convert lists to a stream of characters, 
	* then a string, then parse to int, then sum, then to
	* a stream, then an array, then finally back to a list
	* A bit hacky&unreadable, but functional regardless.
	* There has to be a better functional way.
	*/
	public static LinkedList<Integer> addRegularFunctional(LinkedList<Integer> l1,
												LinkedList<Integer> l2){
		int num1 = Integer.parseInt(l1.stream()
										.map(val -> ""+val)
										.collect(Collectors.joining()));
		int num2 = Integer.parseInt(l2.stream()
										.map(val -> ""+val)
										.collect(Collectors.joining()));
		int sum = num1+num2;
		Integer[] digits = Integer.toString(sum).chars()
					.mapToObj(c->new Integer(Integer.parseInt(""+(c-'0'))))
					.toArray(Integer[]::new);
		return new LinkedList<Integer>(Arrays.asList(digits));
	}
}

class BasicSLList{
	BasicSLListNode head;
	BasicSLListNode tail;
	public BasicSLList(){
		head = tail = null;
	}
	void append(Object element){
		if(head==null){
			head =tail = new BasicSLListNode(element,null);
			return;
		}
		tail=tail.next=new BasicSLListNode(element,null);
	}
	boolean remove(Object element){
		if(head==null){
			return false;
		}
		if(head.data.equals(element)){
			if(head==tail){
				head=tail=null;
				return true;
			}
			head = head.next;
			return true;
		}
		if(head==tail){
			return false;
		}
		BasicSLListNode pointer = head;
		while(pointer.next != null){
			if(pointer.next.data.equals(element)){
				pointer.next = pointer.next.next;
				return true;
			}
			pointer = pointer.next;
		}
		if(tail.data.equals(element)){
			tail = pointer;
			return true;
		}
		return false;
	}
	boolean removeIgnoreHeadAndTail(Object element){
		if(head==null){
			return false;
		}
		if(head.data.equals(element)){
			//Do Nothing
		}
		if(head==tail){
			return false;
		}
		BasicSLListNode pointer = head;
		while(pointer.next != null && pointer.next!=tail){
			if(pointer.next.data.equals(element)){
				pointer.next = pointer.next.next;
				return true;
			}
			pointer = pointer.next;
		}
		if(tail.data.equals(element)){
			//Do nothing
		}
		return false;
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