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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        
        if(root.val < L){ //root is less than L, discard everything on right and return root of trimmed right subtree
            return trimBST(root.right, L, R);
        }
        
        if(root.val > R){ //root is greater than R, discard everything on left and return root of trimmed left subtree
            return trimBST(root.left, L, R);
        }
        
        //root doesn't need to be deleted
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}