package Sort;
public class SelectionSort {
	public static void main(String[] args) {
		
		int[] array={5,45,2,4,6,1,3,12};
		int min,j;
		int position;
		for(int i=0;i<array.length;i++)
		{
			position=i;
			min=array[i];
			for (j=i;j<array.length-1;j++)
			{
				
				if (array[j+1]>min)
					continue;
				else{
						min=array[j+1];
						position=j+1;
				}
			}
			
			array[position]=array[i];
			array[i]=min;
			
		}
		
		for( int it : array)
		{
			System.out.println(it);
		}
		
	}
}