package search;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        //corner case
        if(matrix==null || matrix.length==0 )
            return false;

        int start=0;
        int end=matrix.length*matrix[0].length-1;

        while(start<=end)
        {
            int mid = start+(end-start)/2;

            int mid_x=mid%matrix[0].length;
            int mid_y=mid/matrix[0].length;

            if(matrix[mid_y][mid_x]==target)
            {
                return true;
            }
            else if (matrix[mid_y][mid_x]>target)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }

        }

        return false;

    }
}
