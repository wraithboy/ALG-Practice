package sort;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[]  A ={5,2,17,12,1,8,7,22,4,6,19};
		int[]  B ={6,5};
		MergeSort(A,0,A.length-1);
		
		for( int i : A)			
		{
			System.out.print(i);
		}
	}
	
	
	private static void MergeSort(int[] A, int p, int r)
	{
		if (p < r)
		{			
			int q = (int)((p+r)/2);
			MergeSort(A,p,q);
			MergeSort(A,q+1,r);
			System.out.print("p: "+p+" ");
			System.out.print("q: "+q+" ");
			System.out.print("r: "+r+" ");
			Merge(A,p,q,r);
		}
	
	}
	
	private static void Merge(int[] A, int p , int q, int r)
	{
		int L1= q-p +1;
		int L2= r-q;
		
		int[] A1=new int[L1+1];
		int[] A2=new int[L2+1];
				
		for( int i=0;i<L1;i++)
		{
			A1[i]=A[p+i];
		}
		
		for(int i=0;i<L2;i++)
		{
			A2[i]=A[q+i+1];
		}
		
		A1[L1]=Integer.MAX_VALUE;
		A2[L2]=Integer.MAX_VALUE;

		int k=0 ,j=0;
		for ( int i=p;i<=r;i++)
		{
			
			if(A1[k]<A2[j])
			{
				A[i]=A1[k];
				k++;
			}
			else
			{
				A[i]=A2[j];
				j++;
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
