public class Question5 {
	
	LinkedList linkedList = new LinkedList();
	
	public Node addLinkedListDigits(Node nodeFirst, Node nodeSecond, int carry){
		if(nodeFirst == null && nodeSecond == null && carry == 0){
			return null;
		}
		Node result = new Node();
		int value = 0;
		if(nodeFirst != null){
			value += nodeFirst.data;
		}
		if(nodeSecond != null){
			value += nodeSecond.data;
		}
		carry = value/10;
		value = (value)%10;
		result.data = value;
		
		Node result1 = addLinkedListDigits(nodeFirst == null ? null : nodeFirst.next, nodeSecond == null ? null : nodeSecond.next, carry);
	}
	result.setNext(result1);      //setNext is a method to be implemented that puts the parameter node next to the result node.
}
