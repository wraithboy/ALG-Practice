package datastructure;

public class Node<Key,Value> {
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

	private Key key;
	private Value value;
	
	public Node<Key,Value> right;
	public Node<Key,Value> left;
	
	public Node(Key key, Value value)
	{
		this.key=key;
		this.value=value;
	}
	
}
