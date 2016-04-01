package datastructure;

public class BST <Key extends Comparable<Key>, Value>{
	
	 private Node<Key,Value> root;
	 
	 public BST (Node root)
	 {
		 this.root=root;
	 }
	
	 public void put(Key key, Value value)
	 {

	 }
	 
	 public Value get(Key key)
	 {
		 Node<Key,Value> x= root;
		 
		 while(x!=null)
		 {
			 if(key.compareTo(x.getKey())<0)
			 {
				 x=x.left;
			 }
			 else if (key.compareTo(x.getKey())>0)
			 {
				 x=x.right;
			 }
			 else
			 {
				 return x.getValue();
			 }
		 }
		 
		 return null;
	 }
	 
	 public void delete(Key key)
	 {
		 
	 }
	 
	 
	
}


