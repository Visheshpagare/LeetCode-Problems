/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static String delimeter = ",";
    private static String noNode = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeNode(sb , root);
        return sb.toString();
    }

    private void serializeNode(StringBuilder sb, TreeNode root) {
    if (root == null) {
        sb.append(noNode).append(delimeter);
    } else {
        sb.append(root.val).append(delimeter);
        serializeNode(sb, root.left);
        serializeNode(sb, root.right);
    }
}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> parts = Arrays.asList(data.split(delimeter));
        Deque<String> queue = new LinkedList<>(parts);
        return deserializeNode(queue);
    }

    private TreeNode deserializeNode(Deque<String> queue){
        String val = queue.remove();
        if(val.equals(noNode)){
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = deserializeNode(queue);
            root.right = deserializeNode(queue);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));