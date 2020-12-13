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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false; // reached end of path, doesn't equal to sum
        else if (root.left == null && root.right == null && sum - root.val == 0){
            return true; // found path that equals to sum if the sum - end of path equals 0
        } else{
            // recurse by subtracting left path and right path by sum 
            return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val); 
        }
    }
}
