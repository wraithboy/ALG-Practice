package array;

import java.util.ArrayList;
import java.util.Hashtable;

public class IntersectionOfTwoArrays2 {
    public int[] intersection(int[] nums1, int[] nums2) {

        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0)
        {
            int[] a={};
            return a;
        }

        if (nums1.length > nums1.length) {
            intersection(nums2, nums1);
        }

        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();

        ArrayList<Integer> list=new ArrayList<>();

        for (int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i]))
            {
                int count=map.get(nums1[i]);
                count++;
                map.put(nums1[i],count);
            }else
            {
                map.put(nums1[i],1);
            }

        }

        for(int i=0;i<nums2.length;i++)
        {

            if(map.containsKey(nums2[i]))
            {
                int count=map.get(nums2[i]);
                count--;
                list.add(nums2[i]);
                if(count==0) {
                    map.remove(nums2[i]);
                }
                else
                {
                    map.put(nums2[i],count);
                }
            }

        }

        int[] result=new int[list.size()];
        int j=0;
        for(int a: list)
        {
            result[j]=a;
            j++;
        }

        return result;

    }
}
