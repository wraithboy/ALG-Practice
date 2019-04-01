package tree;

import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

    private final String delimiter="|";

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val=x;
        }
    }

    public String serialize(TreeNode root) {

        StringBuilder sb =new StringBuilder();

        serializeHelper(root,sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb)
    {
        if(root==null)
        {
            sb.append("#").append(delimiter);
            return;
        }

        sb.append(root.val).append(delimiter);
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        LinkedList<String> list = new LinkedList<String>();

        for(String s: data.split(delimiter))
        {
            list.add(s);
        }

        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(LinkedList<String> list)
    {
        String c = list.removeFirst();

        if(c.equals("#"))
        {
            return null;
        }

        TreeNode n = new TreeNode(Integer.valueOf(c));
        n.left=deserializeHelper(list);
        n.right=deserializeHelper(list);
        return n;
    }
}
