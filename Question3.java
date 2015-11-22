package chapter2;

import java.util.HashMap;

public class LinkedList {
	
	Node head;
	
	public LinkedList(){
		this.head = null;
	}
	
	/*
	 * Adds an element to the end of the linked list.
	 */
	public Node add(Object data){
		Node node = new Node(data);
		if(head == null){
			head = node;
			return head;
		}
			
		else{
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
			return node;
		}
	}
	
	public void deleteNode(Object data){
		
		if(head == null){
			System.out.println("The list is empty");
		}
		
		else if(head.data == data){
			head = head.next;
			System.out.println("The element has been deleted");
		}
		
		else{
			Node temp = head;
			while(temp.next != null){
				if(temp.next.data == data){
					temp.next = temp.next.next;
				}
				temp = temp.next;
			}
		}
		
	}
	
	public void traverseList(){
		System.out.println("");
		System.out.println("Traversing the list");
		Node temp = head;
		while(temp.next != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
	
	public int sizeOfLinkedList(){
		int size = 0;
		Node temp = head;
		if(temp == null){
			return 0;
		}
		else{
			size = 1;
			while(temp.next != null){
				size += 1;
				temp = temp.next;
			}
			return size;
		}
	}
	
	public void removeDuplicateWithoutBuffer(){
		Node fastRunner = head;
		Node slowRunner = head;
		while(slowRunner != null){
			fastRunner = slowRunner;
			//System.out.println("I am on this right now: "+fastRunner.data);
			while(fastRunner.next != null){
				if(slowRunner.data == fastRunner.next.data){
					fastRunner.next = fastRunner.next.next;
				}
				else{
					fastRunner = fastRunner.next;
				}
				
			}
			slowRunner = slowRunner.next;
		}
	}
	
	public void removeDuplicatesHashTable(){
		Node temp = head;
		HashMap<Object, Boolean> hashMap = new HashMap<Object, Boolean>();
		while(temp.next != null){
			if(hashMap.containsKey(temp.data)){
				System.out.println("Contains duplicates");
				Node follower = head;
				while(follower.next != temp){
					follower = follower.next;
				}
				follower.next = temp.next;
			}
			else{
				hashMap.put(temp.data, true);
			}
			temp = temp.next;
		}
		if(hashMap.containsKey(temp.data)){
			System.out.println("Contains duplicates");
			Node follower = head;
			while(follower.next != temp){
				follower = follower.next;
			}
			follower.next = null;
		}
		else{
			hashMap.put(temp.data, true);
		}
		System.out.println("They are unique");
	}
	
	public void findKthElement(int k){
		//I will use two pointers, one slow and one fast pointer.
		Node rear, forward;
		rear = forward = head;
		
		for(int i = 0; i<k-1; i++){
			if(forward != null){
				forward = forward.next;
			}
			else{
				System.out.println("The linked list is not that long.");
				return;
			}
		}
		
		while(forward.next != null){
			forward = forward.next;
			rear = rear.next;
		}
		System.out.println("The "+k+"th element from the end is: "+(rear.data).toString());
		
	}
	
	public Node deleteNodeGivenAccess(Node node){
		if(node == null || node.next == null)
			return null;
		node.data = node.next.data;
		node.next = node.next.next;
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
		linkedList.add("F");
		linkedList.add("O");
		linkedList.add("L");
		linkedList.add("L");
		linkedList.add("O");
		Node n1 = linkedList.add("W");
		linkedList.add(" ");
		linkedList.add("U");
		linkedList.add("P");
		//linkedList.removeDuplicatesHashTable();
		//System.out.println("The size of list is "+linkedList.sizeOfLinkedList());
		linkedList.traverseList();
		System.out.println("");
		linkedList.deleteNodeGivenAccess(n1);
		linkedList.traverseList();
		//linkedList.findKthElement(13);
		/*System.out.println("Removing without bufffer");
		linkedList.removeDuplicateWithoutBuffer();
		linkedList.traverseList();
		//Using bubble sort to sort the array elements.
		
		System.out.println(linkedList.sizeOfLinkedList());
		
		
		linkedList.traverseList();
		linkedList.deleteNode("F");
		linkedList.traverseList();
		
		linkedList.deleteNode("X");
		linkedList.traverseList();*/
	}

}
