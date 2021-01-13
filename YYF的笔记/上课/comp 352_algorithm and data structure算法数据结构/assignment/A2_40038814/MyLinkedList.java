package comp352;
public class MyLinkedList<E> {

public class MyLinkedList <E> implements List<E> {
	
	private class Node {
		private E e;
		private Node next;
		private Node prev;
		
		public Node () {
			this.e=null;
			this.next=null;
			this.prev=null;
		}
		
		public Node (E e, Node next, Node prev) {
			this.e=e;
			this.next=next;
			this.prev=prev;
		}
	}
//--------------------------------------------------------------------------------------------------------------------------	
	private Node head;
	private Node tail;	
	private int size;
	
	public MyLinkedList () {
		head=null;
		tail=null;
		int size=0;
	}
	
//add new node as new tail
	public boolean add(E e) {	
		if (head==null) {
			head=tail=new Node(e, null, null);
		}
		else {
			Node temp=new Node (e, null, tail);
			tail.next=temp;
			tail=temp;
		}
		size++;
		return true;
	}
	
	//Method adds element at specified index
	public void add(int index, E e) {
        if (index>size||index<0) {
			System.out.println("index too big");
			return;
		}
		else if (index==0) {
			head=new Node(e, head, null);                                                                                      
		}
		else if (index <size){
			Node temp=head;//the temp to find index
			for (int i=0; i<index; i++) {
				temp=temp.next;
			}//temp is now index i node
			Node temp1=new Node (e, temp, temp.prev);  //the temp to add new node
			temp.prev= temp1;
			temp.prev.prev.next=temp1;
		}
		else if (index==size) {
			Node temp=new Node(e,null,tail);
			tail.next=new Node(e,null,tail);
			tail=temp;
		}
		size++;
	}
	
	public void clear() {
		head=null;
		tail=null;
		size=0;
	}
	

	public E remove (int index) {
		if (head==null) {
			System.out.println("empty");
			return null;
		} 
		else if (index>=size) {
			System.out.println("index too big");
			return null;
		} 
		else if (index==0) {
			E e=head.e;
			head=head.next;
			//head.prev.next=null;
			head.prev=null;
			size--;
			return e;
		}
		else if (index<size-1){
			Node temp=head;			
			for (int i=0; i<index; i++) {
				temp=temp.next;
			}
			E e=temp.e;			
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
			temp.prev=null;
			temp.next=null;		
			size--;
			return e;
			}
     else if (index==size-1) {			
		   	Node t = tail;
			tail=tail.prev;
			tail.next=null;
			return t.e;
		}
		return null;
	}

	//Removes first occurence of element
  public boolean remove (Object o) {	
		if (head==null) {
			return false;
		}
		else {
			if (o==null || head.e.getClass()!=o.getClass()) {
				return false;
			}
			else {
				E temp=(E)o;
				Node t=head;
				if (t.e==temp) {
					head.next.prev=null;
					head=head.next;
					size--;
					return true;
				}
				while (t.next!=null && t.e!=temp) {
					t=t.next;
				}
				if (t.e==temp) {
					if (t.next!=null) {
						t.prev.next=t.next;
						t.next.prev=t.prev;
						t.prev=null;
						t.next=null;
					} 
					else {
                       tail.prev.next=null;
                       tail=tail.prev;
					}
					size--;
					return true;
				}
				return false;
			}			
		}
	} 

	
	public String toString() {
		String s="";
		if (head==null) {
			return "List is empty.";
		}
		Node temp=head;
		while (temp.next!=null) {
			s=s+temp.e+"|";
			temp=temp.next;
		}
		s=s+temp.e+"-x";
		return s;
	}
	
	public int size() {
		return size; 
	}
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);//add at end checked
		list.add(3,5);
		list.add(0,1);
		System.out.println(list);
		list.remove(0);
		list.remove(list.size()-1);
		list.remove((Integer)3);
		System.out.println(list);//remove head checked
		System.out.println(list.size());
		


		

	}

}