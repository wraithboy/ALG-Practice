package implementation;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiral {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if(matrix==null || matrix.length==0)
        {
            return result;
        }

        if(matrix.length==1)
        {
            for(int i: matrix[0])
            {
                result.add(i);
                return result;
            }
        }

        if(matrix[0].length==1)
        {
            for(int i=0;i<matrix.length;i++)
            {
                result.add(matrix[i][0]);
            }

            return result;
        }

        int row=matrix.length;
        int col=matrix[0].length;

        int left=0,right=col-1,top=0,bot=row-1;

        while(left<right&&top<bot)
        {

            for(int i=left;i<right;i++)
            {
                result.add(matrix[top][i]);
            }

            for(int i=top;i<bot;i++)
            {
                result.add(matrix[i][right]);
            }

            for(int i=right;i>left;i--)
            {
                result.add(matrix[bot][i]);
            }

            for(int i=bot;i>top;i--)
            {
                result.add(matrix[i][left]);
            }

            left++;
            top++;
            right--;
            bot--;
        }

        if(left==right)
        {
            for(int i=top;i<=bot;i++)
            {
                result.add(matrix[i][left]);
            }
        }
        else if(top==bot)
        {
            for(int i=left;i<=right;i++)
            {
                result.add(matrix[top][i]);
            }
        }

        return result;
    }
}
