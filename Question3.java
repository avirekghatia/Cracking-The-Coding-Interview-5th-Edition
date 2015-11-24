/**
	 * This cannot work if the node given to the method is the last node in the Linked List. One solution to the problem is to always reserve the last node as the dummy node.
	 * Other approach could be to traverse to the node just before the given node and then perform the deletion function.
	 * 
	 * @param node - The reference to the Node which has to be deleted from the linked list.
	 * @return - Returns the node next to the deleted node if the node was not null.
	 */
	public Node deleteNodeGivenAccess(Node node){
		if(node == null || node.next == null)
			return null;
		Node next = node.next;
		node.data = next.data;
		node.next = next.next;
		return node;
	}
