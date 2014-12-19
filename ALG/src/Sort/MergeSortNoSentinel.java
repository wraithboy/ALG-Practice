package Sort;

public class MergeSortNoSentinel {
	
	public static void main(String[] args) {
		
		int[] A={2,4,6,11,9,1,3,5};
		
		MergeSort(A,0,7);	
		
		for( int i : A)			
		{
			System.out.print(i+"#");
		}
	}
	
	public static void MergeSort(int[] A,int p,int q)
	{
		int r= (p + q)/2;
		
		if ( r < q)
		{
			MergeSort(A,p,r);
			MergeSort(A,r+1,q);
			Merge1(A,p,r,q);
		}		
	}
	
	public static void Merge(int[] A,int p,int q,int r)
	{
		int L=q-p+1;
		int R=r-q;
		
		int[] A1= new int[L+1];
		int[] A2= new int[R+1];
		
		for(int i=0;i<L;i++)
		{
			A1[i]=A[p+i];
		}
		
		for(int i=0;i<R;i++)
		{
			A2[i]=A[q+1+i];
		}
		
		
		for( int i : A1)			
		{
			System.out.print(i+"#");
		}
		
		for( int i : A2)			
		{
			System.out.print(i+"#");
		}
		
		A1[L]=Integer.MAX_VALUE;
		A2[R]=Integer.MAX_VALUE;
		
		int j=0;
		int k=0;
		
		for(int n=p;n<=r;n++)
		{
			if(A1[j]<A2[k])
			{
				A[n]=A1[j];
				j++;
			}		
			else if(A1[j]>A2[k])
			{
				A[n]=A2[k];
				k++;
			}
		}
		
		System.out.println("");
		
		for( int i : A)			
		{
			System.out.print(i+"#");
		}
		
		System.out.println("");
		
	}
	
	
	public static void Merge1(int[] A, int p, int q, int r) 
	{
		int L = q - p +1 ;
		int R = r -q;
		
		int[] AL = new int[L+1];
		int[] AR = new int[R+1];
		
		for ( int i=0;i<L;i++)
		{
			AL[i] = A[p+i];
		}
		
		for ( int i=0;i<R;i++)
		{
			AR[i] = A[q+i+1];
		}
		
		AL[L]=Integer.MAX_VALUE;
		AR[R]=Integer.MAX_VALUE;
		
		int j=0,k=0;
		for(int i=p;i<=r;i++)
		{
			
			if(AL[j]<AR[k])
			{
				A[i]= AL[j];
				j++;
			}
			else if(AL[j]>AR[k])
			{
				A[i]=AR[k];
				k++;
			}
	
		}
		
		System.out.println("");
		
		for( int i : A)			
		{
			System.out.print(i+"#");
		}
		
		System.out.println("");
	}
		
}
