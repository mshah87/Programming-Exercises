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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    public void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("null").append(",");
        } else {
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll((Arrays.asList(data.split(","))));
        return deserializeHelper(nodes);
    }
    
    public TreeNode deserializeHelper(Queue<String> nodes){
        String curr = nodes.poll();
        if(curr.equals("null")) return null;
        TreeNode newNode = new TreeNode(Integer.valueOf(curr));
        newNode.left = deserializeHelper(nodes);
        newNode.right = deserializeHelper(nodes);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
