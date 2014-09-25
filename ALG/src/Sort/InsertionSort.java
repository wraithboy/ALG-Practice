package Sort;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={5,2,4,6,1,3};
		int i=1;
		
		for( int it : array)
		{
			System.out.println(it);
		}
		
		while (i< array.length)
		{
			int key=array[i];
			int j=i-1;
			
			while(j>=0 && array[j]< key)
			{
					array[j+1]=array[j];
					array[j]=key;
					j--;
			}
			i++;
		}
		
		for( int it : array)
		{
			System.out.println(it);
		}
		
	}

}
