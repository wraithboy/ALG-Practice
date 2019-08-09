package array;

import java.util.ArrayList;
import java.util.List;

public class FindRectangle {



}


/*
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

The image you get is known to have potentially many distinct rectangles of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

image1 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 0, 1, 0, 0, 0, 1],
  [1, 0, 1, 1, 1, 1, 1],
  [1, 0, 1, 0, 0, 1, 1],
  [1, 1, 1, 0, 0, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

Sample output variations (only one is necessary):

findRectangles(image1) =>
  // (using top-left and bottom-right):
  [
    [[0,0],[0,0]],
    [[2,3],[3,5]],
    [[3,1],[5,1]],
    [[5,3],[6,4]],
    [[7,6],[7,6]],
  ]
  // (using top-left and width/height):
  [
    [[0,0],[1,1]],
    [[2,3],[3,2]],
    [[3,1],[1,3]],
    [[5,3],[2,2]],
    [[7,6],[1,1]],
  ]

Other test cases:

image2 = [
  [0],
]

findRectangles(image2) =>
  // (using top-left and bottom-right):
  [
    [[0,0],[0,0]],
  ]

  // (using top-left and width/height):
  [
    [[0,0],[1,1]],
  ]

image3 = [
  [1],
]

findRectangles(image3) => []

 */

class Solution {
    public static void main(String[] args) {
        int[][] image1 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int[][] image2 = {
                {0},
        };

        int[][] image3 = {
                {1},
        };



        Solution solution = new Solution();

        System.out.println(solution.findRectangle(image1));

    }

    public List<List<Integer>> findRectangle(int[][] image)
    {

        int[][] copy = new int[image.length][image[0].length];

        for(int i=0;i<copy.length;i++)
        {
            for(int j=0;j<copy[0].length;j++)
            {
                copy[i][j]=image[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();


        int prevX=0;
        int prevY=0;


        for(int i=0;i<copy.length;i++)
        {
            for(int j=0;j<copy[0].length;j++)
            {

                if(copy[i][j]!=0)
                    continue;

                ArrayList<Integer> topLeft=new ArrayList<>();
                ArrayList<Integer> botomRight=new ArrayList<>();

                prevX=i;
                prevY=j;

                topLeft.add(i);
                topLeft.add(j);

                copy[i][j]=1;

                while(i+1<copy.length && copy[i+1][j]==0)
                {
                    i++;
                    copy[i][j]=1;
                }

                botomRight.add(i);

                while(j+1<copy[0].length && copy[i][j+1]==0)
                {
                    j++;
                }

                botomRight.add(j);

                result.add(topLeft);
                result.add(botomRight);

                for(int m=prevX;m<=i;m++)
                {
                    for(int n=prevY;n<=j;n++)
                    {
                        copy[m][n]=1;
                    }
                }

                for(int row = 0; row<copy.length;row++)
                {
                    for(int col=0;col<copy[0].length;col++)
                    {
                        System.out.print(copy[row][col]);
                    }
                    System.out.println("");
                }

                System.out.println("---------------");

                i=prevX;
                j=prevY;

                System.out.println("X:"+prevX + "Y"+prevY);
            }
        }

        return result;
    }

}