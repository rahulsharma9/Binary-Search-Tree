
public class Node<T extends Comparable<T>> {
	
	private Object item;
	private Node leftSide;
	private Node rightSide;
	int numOfTimes = 0;
	
	Node(){
	}
	
	Node(Object item){
		this.setItem(item);
		this.setLeftSide(null);
		this.setRightSide(null);
		numOfTimes = 1;
	}
	
	Node(Object item, Node leftSide, Node rightSide){
		this.setItem(item);
		this.setLeftSide(leftSide);
		this.setRightSide(rightSide);
		numOfTimes = 1;
	}

	public Object getItem() {
		return this.item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public Node getLeftSide() {
		return leftSide;
	}

	public void setLeftSide(Node leftSide) {
		this.leftSide = leftSide;
	}

	public Node getRightSide() {
		return rightSide;
	}

	public void setRightSide(Node rightSide) {
		this.rightSide = rightSide;
	}
	
	

}
