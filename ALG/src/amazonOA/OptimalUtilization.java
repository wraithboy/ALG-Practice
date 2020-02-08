package amazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalUtilization {

    private static List<List<Integer>> compute(int[][] a, int[][] b, int target) {

        Arrays.sort(a,(i, j)->(i[1]-j[1]));
        Arrays.sort(b,(i,j)->i[1]-j[1]);

        List<List<Integer>> result = new ArrayList<>();

        int i=0,j=b.length-1;

        int max=0;

        while(i<a.length&&j>=0)
        {
            int sum=a[i][1]+b[j][1];

            if(sum<=target)
            {
                if(max<sum)
                {
                    max=sum;
                    result.clear();
                }

                List<Integer> ids=new ArrayList<>();
                ids.add(a[i][0]);
                ids.add(b[j][0]);
                result.add(ids);

                int index = j-1;
                while(index >=0 && b[index][1] == b[index+1][1]) {
                    List<Integer> l = new ArrayList<>();
                    l.add(a[i][0]);
                    l.add(a[index--][0]);
                    result.add(l);
                }

                i++;
            }
            else {
                j--;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[][][] As = {
                {{1, 2}, {2, 4}, {3, 6}},
                {{1, 3}, {2, 5}, {3, 7}, {4, 10}},
                {{1, 8}, {2, 7}, {3, 14}},
                {{1, 8}, {2, 15}, {3, 9}}
        };
        int[][][] Bs = {
                {{1, 2}},
                {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
                {{1, 5}, {2, 10}, {3, 14}},
                {{1, 8}, {2, 11}, {3, 12}}
        };
        int[] targets = {7, 10, 20, 20};

        for (int i=0; i<4; i++) {
            System.out.println(compute(As[i], Bs[i], targets[i]).toString());
        }
    }

}
