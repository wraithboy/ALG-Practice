package sort;

public class Merge {
	
	public static void main (String args[])
	{
//		  int[] my_list= {3, 4, 6, 10, 11, 15};
//		  int[]	alices_list = {1, 5, 8, 12, 14, 19};
		
		  int[] my_list= {3};
		  int[]	alices_list = {1};
		  
		  for(int i:merge_lists(my_list,alices_list))
		  {
			  System.out.print(i+" ");
		  }

	}
	
	public static int[] merge_lists(int[] my_list, int [] alices_list)
	{
		
		if(my_list==null && alices_list==null)
		return null;
		else if(my_list==null && alices_list!=null)
		return alices_list;
		else if(alices_list==null && my_list!=null)
		return my_list;
		else
		{
			int[] aux=new int[my_list.length+alices_list.length];
			
			int i=0;
			int j=0;
			int k=0;
			while(i<my_list.length && j< alices_list.length)
			{
				if(my_list[i]<alices_list[j])
				{
					aux[k]=my_list[i];
					k++;
					i++;
				}
				else
				{
					aux[k]=alices_list[j];
					k++;
					j++;
				}
			}
			
			if(k==aux.length)
			{
				return aux;
			}
			else if(k<aux.length&&i==my_list.length)
			{
				while(k<aux.length)
				{
					aux[k]=alices_list[j];
					k++;
					j++;
				}
				
				return aux;
			}
			else if(k<aux.length&&j==alices_list.length)
			{
				{
					aux[k]=my_list[i];
					k++;
					i++;
				}
				
				return aux;
			}
		}
		
		return null;
	}
	
	
}
