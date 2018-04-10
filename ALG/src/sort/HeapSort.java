package sort;

public class HeapSort {

	
	public static void main(String args[])
	{	

			int[] heap= new int[10];

			heap[0]=2;
			heap[1]=1;			
			heap[2]=6;
			heap[3]=4;
			heap[4]=3;
			heap[5]=7;
			heap[6]=11;
			heap[7]=5;			
			heap[8]=8;
			heap[9]=14;

	        StringBuilder s = new StringBuilder();
	        
	        for(int i=0;i<heap.length;i++)
	        {
	        	s.append(heap[i]+",");
	        }
	        
	        System.out.println(s);
	        
	        construct(heap);
	        
	        s = new StringBuilder();
	        
	        for(int i=0;i<heap.length;i++)
	        {
	        	s.append(heap[i]+",");
	        }
	        
	        System.out.println(s);  
	}
	
	public void heapsort(int[] a)
	{
		
		
		
	}
	
	public static void construct(int[] a)
	{
		for(int k=a.length-1/2;k>=0;k--)
		{
			sink(a,k);
		}
	}
	
	public static void sink(int[] a,int k)
	{
		
		while(2*k<=a.length-1)
		{
			int i=2*k;
			
			if(i<a.length-1 && a[i]<a[i+1])
				i=i+1;

			if(a[k]>a[i])
				break;
			
			int tmp=a[k];
			a[k]=a[i];
			a[i]=tmp;
			
			k=i;
			
		}
		
		
		
	}
	
	
	
}
