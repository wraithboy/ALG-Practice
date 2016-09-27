package TMCQuestions;

import java.util.ArrayList;
import java.util.Stack;

public class TestSuperBalancedTree {
	
	public static void main(String args[])
	{
		BinaryTreeNode node1=new BinaryTreeNode(1);
		
		node1.insertLeft(2);
		
		node1.left.insertLeft(6);
		
		node1.insertRight(3);
		
		node1.right.insertLeft(4);
		
		node1.right.left.insertLeft(5);
		
		System.out.println(testSuperBalancedTree(node1));
	}
	
	public static boolean testSuperBalancedTree(BinaryTreeNode root)
	{
		boolean result=true;
		
		root.depth=0;
		
		BinaryTreeNode current=root;
		
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			current=stack.pop();
			
			if(current.right==null && current.left==null)
			{
				if(!list.contains(current.depth))
				{
					list.add(current.depth);
				}
				
				if(list.size()>2 || list.size()==2 && Math.abs(list.get(0)-list.get(1))>1)
					return false;
			}
			
			if(current.left!=null)
			{
				current.left.depth=current.depth+1;
				stack.push(current.left);
			}
			if(current.right!=null)
			{
				current.right.depth=current.depth+1;
				stack.push(current.right);
			}
		}
		
		return result;
	}
	
}
