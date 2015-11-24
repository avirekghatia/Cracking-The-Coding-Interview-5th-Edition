public void orderBy(int threshold){
		Node smallerFirst = null;
		Node biggerFirst = null;
		System.out.println(this.sizeOfLinkedList()+" is the size.");
		if(this.head == null){
			System.out.println("The linked list is empty");
			return;
		}

		Node node = this.head;
		

		while(node != null){
			Node next = node.next;
			//System.out.println("Adding node "+node.data);
			if((Integer) node.data >= (Integer) threshold){
				node.next = biggerFirst;
				biggerFirst = node;
			}
			else{
				node.next = smallerFirst;
				smallerFirst = node;
			}
			node = next;
		}
		
		if(smallerFirst == null)
			this.head = biggerFirst;
		else{
			this.head = smallerFirst;
			while(smallerFirst.next != null){
				smallerFirst = smallerFirst.next;
			}
			smallerFirst.next = biggerFirst;
		}
	}
