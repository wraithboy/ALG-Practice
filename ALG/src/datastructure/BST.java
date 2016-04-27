package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BST <Key extends Comparable<Key>, Value>{
	
	 private Node<Key,Value> root;
	 
	 
	 public static void main(String args[])
	 {
		 BST<Integer,String> btree= new BST<Integer,String>(new Node<Integer,String>(5,"TOM"));
		 
		 btree.put(8, "MARY");
		 
		 btree.put(11, "JAMES");
		 
		 btree.put(1, "JACK");
		 
		 btree.put(3, "SIMON");
		 
		// btree.put(8, "RICHARD");
		 
		// System.out.print(btree.get(11));
		 
		// btree.inorder_traverse(btree.root);
		 btree.level_order_traverse(btree.root);
		 
		// System.out.println(btree.findSecondLargest(btree.root));
		 
		 System.out.println(btree.floor(btree.root, 13));
		 
		 System.out.println(btree.ceiling(btree.root, 9));
		 
		// btree.reverse_inorder_traverse(btree.root);
		 
	 }
	 
	 public Key floor(Node<Key,Value> root, Key key)
	 {
		 if(root==null)
			 return null;
		 
		 int cmp=root.getKey().compareTo(key);
		 
		 if(cmp==0) return root.getKey();
		 
		 if(cmp>0)
		 {
			 return floor(root.getLeft(),key);
		 }

			 Key t=floor(root.getRight(),key);
			 
			 if(t==null)
				 return root.getKey();
			 else 
				 return t;
	 }
	 
	 public Key ceiling(Node<Key,Value> root,Key key)
	 {
		 if(root==null)
			 return null;
		 
		 int cmp=root.getKey().compareTo(key);
		 
		 if(cmp==0) return key;
		 
		 if(cmp<0)
		 {
			 return ceiling(root.getRight(),key);
		 }
		 
		 Key t=ceiling(root.getLeft(),key);
		 
		 if(t==null)
			 return root.getKey();
		 else
			 return t;
	 }
	 
	 
	 
	 
	 public BST (Node<Key,Value> root)
	 {
		 this.root=root;
	 }
	 
	 public void inorder_traverse(Node<Key,Value> root)
	 {
		if(root==null)
			 return;
		else
		{
			 inorder_traverse(root.getLeft());
			 System.out.println(root.getValue());
			 inorder_traverse(root.getRight());
		}
		 
	 }
	 
	 public void reverse_inorder_traverse(Node<Key,Value> root)
	 {
		 if(root==null)
			 return;
		 {
			 reverse_inorder_traverse(root.getRight());
			 System.out.println(root.getValue());
			 reverse_inorder_traverse(root.getLeft());
		 }
	 }
	 
	 public Value findSecondLargest(Node<Key,Value> root)
	 {
		 
		 // empty BST or BST only have one node
		 if(root == null || root!=null && root.getRight()==null && root.getLeft()==null )
			 return null;
		
		 Node<Key,Value> t=root;
			 
		 while(t.getRight()!=null && t.getRight().getRight()!=null)
		 {
			t=t.getRight();
		 }
		 
		 // Right child have neigher right or left sub tree
		 if(t.getRight().getLeft()==null)
			 return t.getValue();
		 else if (t.getRight().getLeft()!=null)
		 {
			 return findLargest(t.getRight().getLeft());
		 }else
		 {
			 return null;
		 }

		 
	 }
	 
	 public Value findLargest(Node<Key,Value> root)
	 {
		 if(root==null)
			 return null;
		 
		 Node<Key,Value> n=root;
		 
		 while(n.getRight()!=null)
		 {
			 n=n.getRight();
		 }
		 
		 return n.getValue(); 
	 }
	 
	 public Value findMin()
	 {
		Node<Key,Value> t = root;
		 
		while(t!=null)
		{
			if(t.getLeft()==null)
				return t.getValue();
			else
				t=t.getLeft();
		}
		
		return null;
	 }
	 
	 public Value findMax()
	 {
		Node<Key,Value> t = root;
		 
		while(t!=null)
		{
			if(t.getRight()==null)
				return t.getValue();
			else
				t=t.getRight();
		}
		
		return null;
	 }
	 
	 public void level_order_traverse(Node<Key,Value> root)
	 {
		 Queue<Node<Key,Value>> q = new LinkedList<Node<Key,Value>>();
		 
		 q.add(root);
		 
		 while(!q.isEmpty()){
			 
			 Node<Key,Value> t = q.poll();
			 
			 System.out.println(t.getValue());
			 
			 if(t.getLeft()!=null)
			 q.add(t.getLeft());
			 
			 if(t.getRight()!=null)
			 q.add(t.getRight());
			 
		 }
		 
		 
	 }
	 
	 public void put(Key key, Value value)
	 {
		 
		 if(root==null)
		 {
			 root= new Node<Key,Value>(key,value);
		 }
		 else
		 {
			 Node<Key,Value> t=root;
			 
			 while(t!=null)
			 {
				 
				 int cmp=t.getKey().compareTo(key);
				 
				 if(cmp==0)
				 {
					  t.setValue(value);
				 }
				 else if(cmp>0)
				 {
					 if(t.getLeft()==null)
						 {
						 	t.setLeft(new Node<Key,Value>(key,value));
						 	return;
						 }
					 else
						 t=t.getLeft();
				 }
				 else
				 {
					 if(t.getRight()==null)
						 {
						 	t.setRight(new Node<Key,Value>(key,value));
						 	return;
						 }
					 else
						 t=t.getRight();
				 }
			 }

		 }
		 
	 }
	 
	 public Value get(Key key)
	 {
		 
		 Node<Key,Value> t=root;
		 
		 while(t!=null)
		 {
			 
			 int cmp=t.getKey().compareTo(key);
			 
			 if(cmp==0)
			 {
				 return t.getValue();
			 }
			 else if(cmp>0)
			 {
				  t=t.getLeft();
			 }
			 else
			 {
				 t=t.getRight();
			 }
		 }
		 
		 return null;
	 }
	 
	 public void delete(Key key)
	 {
		 
	 }
	 
}


