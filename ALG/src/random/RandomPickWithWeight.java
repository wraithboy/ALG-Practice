package random;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    int[] w;
    Random random;
    int[] arr;
    int sum=0;

    public void Solution(int[] w) {
        this.w=w;
        random=new Random();

        arr=new int[w.length];
        int sum=0;
        for(int i=0;i<w.length;i++)
        {
            sum=sum+w[i];
            arr[i]=sum;
        }
    }

    public int pickIndex() {

        int r=random.nextInt(sum)+1;

        int ret=Arrays.binarySearch(arr,r);

        if(ret < 0) ret = -ret - 1;

        return ret;
    }
}
