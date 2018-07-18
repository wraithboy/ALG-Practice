package datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;


	
	class Number {
		
		int x;
		int y;
		int val;
		
		public Number(int x, int y, int val)
		{
			this.x=x;
			this.y=y;
			this.val=val;
		}
	}
	
	class NumberComparator implements Comparator<Number> {

		@Override
		public int compare(Number arg0, Number arg1) {
			// TODO Auto-generated method stub
			return arg0.val-arg1.val;
		}
		
	}
	
	public class KthSmallestNumberinSortedMatrix {
		
	private boolean isValid(int[][] matrix,int x, int y,boolean[][] isVisited)
	{
		if(x<matrix.length && y<matrix[0].length && !isVisited[x][y] )
		{
			return true;
		}
		
		return false;
	}
		
		
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
    	PriorityQueue<Number> botK = new PriorityQueue<>(k,new NumberComparator()); 
    	boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
    	
    	Number min = new Number(0,0,matrix[0][0]);
    	
    	botK.add(min);
    	
    	isVisited[0][0]=true;
    	
    	for(int i=0;i<k-1;i++)
    	{
    		
    		Number n=botK.poll();
    		
    		if(isValid(matrix,n.x+1,n.y,isVisited))
    		{
    			botK.add(new Number(n.x+1,n.y,matrix[n.x+1][n.y]));
    			isVisited[n.x+1][n.y]=true;
    		}
    		
    		if(isValid(matrix,n.x,n.y+1,isVisited))
    		{
    			botK.add(new Number(n.x,n.y+1,matrix[n.x][n.y+1]));
    			isVisited[n.x][n.y+1]=true;
    		}
    		
    	}
    	
    	return botK.peek().val;
    }
}
