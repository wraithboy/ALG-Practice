package datastructure;

public class Node<Key,Value>{
	
	private Key key;
	
	private Value value;
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Node<Key, Value> getRight() {
		return right;
	}

	public void setRight(Node<Key, Value> right) {
		this.right = right;
	}

	public Node<Key, Value> getLeft() {
		return left;
	}

	public void setLeft(Node<Key, Value> left) {
		this.left = left;
	}

	private Node<Key,Value> right;
	
	private Node<Key,Value> left;
	
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Node(Key key, Value value, int count)
	{
		this.key=key;
		this.value=value;
		this.count=count;
	}
	
	
	
}