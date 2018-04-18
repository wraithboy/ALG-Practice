package highfrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        
        if(numbers==null || numbers.length<3)
        {
            return null;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(numbers);
        int left,right;
        int sum;

        for(int i=0;i<numbers.length-2;i++)
        {

            if(i>0 && numbers[i]==numbers[i-1])
                continue;

            left=i+1;
            right=numbers.length-1;

            while(left<right)
            {
                sum=numbers[i]+numbers[left]+numbers[right];
                if(sum==0)
                {
                    ArrayList<Integer> tmp=new ArrayList<>();
                    tmp.add(numbers[i]);
                    tmp.add(numbers[left]);
                    tmp.add(numbers[right]);
                    result.add(tmp);
                    left++;
                    right--;

                    while(left<right && numbers[right]==numbers[right+1])
                        right--;
                    while(left<right && numbers[left]==numbers[left-1])
                        left++;
                }
                else if (sum>0)
                {
                    right--;
                }
                else
                {
                    left++;
                }
            }
        }

        return result;
    }
}
