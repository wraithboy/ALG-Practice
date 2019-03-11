package sort;

public class QuickSort {
	
	private int[] array;
	
	public static void main(String args[])
	{
		//int[] array={5,3,7,2,20,342,23,999,49,6};
		//int[] array={5,3,7,2,99,23};
		int[] array={1,2};
		Qsort(array,0,array.length-1);
		
		for (int i : array)
		{
			System.out.print(i+" ");
		}
		
	}
	
	public static void Qsort(int[] array,int low ,int high)
	{	
		

		
		if(low>=high)
			return;
		
		for (int i : array)
		{
			System.out.print(i+",");
		}
		System.out.print("||");
		
		
		int j=Partition(array,low,high);
		
		System.out.println(j);
		
		Qsort(array,low,j-1);
		
		Qsort(array,j +1,high);
		
	}
	
	public static int Partition(int[] array,int low, int high)
	{	
		
		System.out.println("High:"+high+" Low:"+low);
		
		int pivot=array[low];
		
		int i=low+1;
		int j=high;
		
		while(true)
		{
		
			while(array[i]>pivot)
			{
				if(i==high)
					break;
				i++;
			}
			
			while(array[j]<pivot)
			{
				if(j==low)
					break;
				j--;
			}
			
			if(i>=j) break;
			
			int tmp=array[i];
			array[i]=array[j];
			array[j]=tmp;
		}
		
		int tmp=array[low];
		
		array[low]=array[j];
		
		array[j]=tmp;
		
		return j;
	}

}