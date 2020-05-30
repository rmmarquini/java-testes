package br.com.rmmarquini;

public class DsLinkedList {
	
	/**
	 * Allocates the memory dynamically
	 * Nodes are non-contiguosly stored in the memory and linked together with the help of pointers
	 * Size is no longer a problem, so lists grows as per the program's demand and are limited by the available memory space
	 */
	protected Node start;
	protected Node end;
	public int size;
	
	public void LinkedList() {
		start = null;
		end = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return start == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtStart(int val) {
		Node nptr = new Node(val, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			nptr.setLink(start);
			start = nptr;
		}
	}
	
	public void insertAtEnd(int val) {
		Node nptr = new Node(val, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			end.setLink(nptr);
			end = nptr;
		}
	}
	
	public void insertAtPos(int val, int pos) {
		Node nptr = new Node(val, null);
		Node ptr = start;
		pos = pos - 1;
		for (int i=1; i<size; i++) {
			if (i == pos) {
				Node tmp = ptr.getLink();
				ptr.setLink(nptr);
				nptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
	}
	
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			start = start.getLink();
			size--;
			return;
		} 
		
		if (pos == size) {
			Node s = start;
			Node t = start;
			
			while (s != end) {
				t = s;
				s = s.getLink();
			}
			
			end = t;
			end.setLink(null);
			size--;
			return;
		}
		
		Node ptr = start;
		pos = pos - 1;
		for (int i = 1; i < size-1; i++) {
			if (i == pos) {
				Node tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}
	
	public void display() {
		System.out.println("\nLinked List = ");
		if (size == 0) {
			System.out.println("empty\n");
			return;
		}
		
		if (start.getLink() == null) {
			System.out.println(start.getData());
			return;
		}
		
		Node ptr = start;
		System.out.println(start.getData() + "->");
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			System.out.println(ptr.getData() + "->");
			ptr = ptr.getLink();
		}
		System.out.println(ptr.getData() + "\n");
	}
	
	public static void main(String[] args) {
        DsLinkedList list = new DsLinkedList();
        System.out.println("Linked List Operation");
        int[] arr = {12, 9, 100};
        System.out.println("Starting Insert Operation on Linked List\n");
        System.out.println("Inserting arr elements in Linked List\n");
        list.insertAtStart(arr[0]);
        list.insertAtEnd(arr[2]);
        System.out.println("Linked List after the Insert Operation");
        list.display();
        System.out.println("Deleting elements in Binary Search Tree\n");
        for (int i = 0; i < arr.length; i++) {
            list.deleteAtPos(i);
        }
        System.out.println("Linked List after the Delete Operation");
        list.display();
    }
	
}
