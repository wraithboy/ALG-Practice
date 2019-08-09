package sort;

public class QuickSort {
	
	private int[] array;
	
	public static void main(String args[])
	{
		int[] array={5,3,7,2,20,342,23,999,49,6};
		//int[] array={5,3,7,2,99,23};
		//int[] array={1,2};
		qsort(array,0,array.length-1);
		
		for (int i : array)
		{
			System.out.print(i+" ");
		}
		
	}


	public static int partition(int[] arr,int start,int end)
	{
		int pivot = arr[end];

		int left=start;

		for(int i=start;i<end;i++)
		{
			if(arr[i]<pivot)
			{
				swap(arr,i,left);
				left++;
			}
		}

		swap(arr,left,end);

		return left;
	}

	public static void swap(int[] arr, int i,int j)
	{
		int tmp=arr[i];

		arr[i]=arr[j];
		arr[j]=tmp;
	}

	public static void qsort(int[] array,int low ,int high)
	{	
			if(low>=high)
				return;

			int i = partition(array,low,high);

			qsort(array,low,i-1);
			qsort(array,i+1,high);
	}
	


}