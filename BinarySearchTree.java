
public class BinarySearchTree<T extends Comparable<T>> {
	
	Node<T> root;
	int count = 0;
	
	BinarySearchTree(){
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public T getMin() {
		if(isEmpty()) {
			return null;
		}
		Node<T> node = root;
		while(node.getLeftSide() != null) {
			node = node.getLeftSide();
		}
		return (T) node.getItem();
	}
	
	public T getMax() {
		if(isEmpty()) {
			return null;
		}
		Node<T> node = root;
		while(node.getRightSide() != null) {
			node = node.getRightSide();
		}
		return (T) node.getItem();
	}
	
	public T getMax(Node<T> node) {
		if(node.getRightSide() != null) {
			return (T) getMax(node.getRightSide());
		}
		return (T) node.getItem();
	}
	
	public int findHeight(Node<T> Node) {
	    if (Node == null) {
	        return -1;
	    }

	    int left = findHeight(Node.getLeftSide());
	    int right = findHeight(Node.getRightSide());

	    if (left > right) {
	        return left + 1;
	    } else {
	        return right + 1;
	    }
	}
	
	public BinarySearchTree<T> insert(T item){		
		if(isEmpty()) {
			root = new Node<>(item);
		}
		else {
			insert(item, root);
		}
		
		return this;
	}
	
	public void insert(T item, Node<T> node) {
		
		if(item.compareTo((T) node.getItem()) < 0) {
			if(node.getLeftSide() == null) {
				Node<T> temp = new Node<>(item);
				node.setLeftSide(temp);
			}
			else {
				insert(item, node.getLeftSide());
			}
		}
		else if(item.compareTo((T) node.getItem()) > 0) {
			if(node.getRightSide() == null) {
				Node<T> temp = new Node<>(item);
				node.setRightSide(temp);
			}
			else {
				insert(item, node.getRightSide());
			}
		}
		else {
			node.numOfTimes++;
		}
	}
	
	public void delete(T item) {
		root = delete(item, root);
	}
	
	public Node<T> delete(T item, Node<T> node){		
			if(node == null) {
				return null;
			}
			if(item.compareTo((T) node.getItem()) < 0) {
				node.setLeftSide(delete(item, node.getLeftSide()));
			}
			else if(item.compareTo((T) node.getItem()) > 0){
				node.setRightSide(delete(item, node.getRightSide()));
			}
			else {
				if(node.numOfTimes > 0) {
					node.numOfTimes--;
					return node;
				}
				else if(node.getLeftSide() == null) {
					return node.getRightSide();
				}
				else if(node.getRightSide() == null) {
					return node.getLeftSide();
				}
				node.setItem(getMax(node.getLeftSide()));
				node.setLeftSide(delete((T) node.getItem(), node.getLeftSide()));
			}	
		return node;
	}
	
	public void traverse() {
		System.out.println("In Order Traversal:");
		traverseInOrder(root);
		System.out.println();
		System.out.println();
		
		System.out.println("Pre Order Traversal:");
		traversePreOrder(root);
		System.out.println();
		System.out.println();
		
		System.out.println("Post Order Traversal:");
		traversePostOrder(root);
		System.out.println();
		System.out.println();
	}
	
	public void traverseInOrder(Node<T> node) {
		if (node != null)
		{
			traverseInOrder(node.getLeftSide());
			System.out.print(node.getItem() + "(" + node.numOfTimes + ") ");
			traverseInOrder(node.getRightSide());
		}
	}
	
	public void traversePreOrder(Node<T> node) {
		if (node != null)
		{
			System.out.print(node.getItem() + "(" + node.numOfTimes + ") ");
			traversePreOrder(node.getLeftSide());
			traversePreOrder(node.getRightSide());
		}
	}
	
	public void traversePostOrder(Node<T> node) {
		if (node != null)
		{
			traversePostOrder(node.getLeftSide());
			traversePostOrder(node.getRightSide());
			System.out.print(node.getItem() + "(" + node.numOfTimes + ") ");
		}
	}
	
	public boolean search(T item, Node<T> node) {
		while(node != null) {
			if(item.compareTo((T) node.getItem()) < 0){
				node = node.getLeftSide();
			}
			else if(item.compareTo((T) node.getItem()) > 0) {
				node = node.getRightSide();
			}
			else {
				return true;
			}
		}
		
		return false;
	}
	
	

}
