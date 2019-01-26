package Tree;

import java.util.List;

public class ConvertSortedListtoBinarySearchTree {

    List<TreeNode> list;

    TreeNode sortedListToBST(int index, int start, int end)
    {
        if(start>end)
            return null;

        int mid = start+(end-start)/2;

        TreeNode left=sortedListToBST(index,start,mid-1);

        TreeNode root = new TreeNode(list.get(mid).val);

        root.left=left;
        index++;
        TreeNode right=sortedListToBST(index,mid+1,end);
        return root;
    }

}
