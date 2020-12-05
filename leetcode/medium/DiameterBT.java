/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        // Diameter = Max ( leftHeight + rightHeight + 1, Max (leftDiameter, rightDiameter) )
        if(root == null) return 0;
        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);
        int ldiameter = diameterOfBinaryTree(root.left);
        int rdiameter = diameterOfBinaryTree(root.right);
        
        int max = Math.max(lHeight + rHeight, Math.max(ldiameter, rdiameter));
        return max;
    }
    
    public int maxDepth(TreeNode root){ //function to get the max height of tree
        if(root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
}