package datastructure;

public class MyHeap {
	
	private int size=0;
	private int[] heap;
	
	public MyHeap(int heapSize)
	{
		heap = new int[heapSize];
	}
	
	public void insert(int n)
	{
		if(size>=heap.length)
		{
			System.out.println("Heap is full!");
			return;
		}
		
		heap[size]=n;
		promote(size); 
		size++;
	}
	
	public void promote(int n)
	{
		while(heap[n]>heap[n/2]&&n>0)
		{
			int i=heap[n];
			heap[n]=heap[n/2];
			heap[n/2]=i;
			n=n/2;
		}
	}
	
	public int pop()
	{
		int i=heap[0];
		
		heap[0]=heap[size];
		
		sink(0);
		
		size--;
		
		return i;
	}
	
	public void sink(int n)
	{
		while(n*2<=size)
		{
			int k=n*2;
			
			if(k<size && heap[k]<heap[k+1])
			{
				k=k+1;
			}
			
			int i = heap[k];
			
			heap[k]=heap[n];
			
			heap[n]=i;
			
			n=k;
			
		}
	}
	
	public String toString() { 
        StringBuilder s = new StringBuilder();
        
        for(int i=0;i<size;i++)
        {
        	s.append(heap[i]+",");
        }
        
        return s.toString();
     } 
	
	public static void main(String args[])
	{
		
		MyHeap heap = new MyHeap(10);
		
		heap.insert(5);
		heap.insert(3);
		heap.insert(9);
		heap.insert(0);
		heap.insert(8);
		heap.insert(11);
		System.out.println(heap.toString());
		System.out.println(heap.pop());
		System.out.println(heap.toString());
		System.out.println(heap.pop());
		System.out.println(heap.toString());
		
	}
	
}
