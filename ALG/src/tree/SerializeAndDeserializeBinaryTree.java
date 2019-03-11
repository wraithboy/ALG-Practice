package tree;

public class SerializeAndDeserializeBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val=x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = new int[1];
        index[0] = 0;
        return deserializeHelper(data.split(","),index);
    }

    public TreeNode deserializeHelper(String[] strings,int[] index)
    {
        if(index[0]>=strings.length)
            return null;
        TreeNode node = null;
        String s= strings[index[0]];
        index[0]++;

        if(!s.equals("#"))
        {
            node = new TreeNode(Integer.valueOf(s));
            node.left=deserializeHelper(strings,index);
            node.right=deserializeHelper(strings,index);
        }

        return node;
    }

    public void serializeHelper(TreeNode root,StringBuilder sb)
    {

        if(root==null)
            sb.append("#").append(",");
        else {
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }
}
