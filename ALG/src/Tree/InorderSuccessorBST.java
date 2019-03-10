package Tree;

public class InorderSuccessorBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(p.right!=null)
        {
            TreeNode n=p.right;
            while(n.left!=null)
            {
                n=n.left;
            }

            return n;
        }

        TreeNode prevMax=null;
        while(root!=null)
        {
            if(p.val<root.val)
            {
                prevMax=root;
                root=root.left;
            }
            else if(p.val>root.val)
                root=root.right;
            else
                break;
        }
        return prevMax;
    }



}
