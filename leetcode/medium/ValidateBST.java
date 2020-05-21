/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) { // O(n) complexity, DFS inorder traversal (left, root, right)
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack();
        TreeNode previous = null;
        while (!stack.isEmpty() || root != null) {
          while (root != null) {
            stack.push(root);
            root = root.left;
          }
          root = stack.pop();
          if (previous != null && root.val <= previous.val) return false;
          previous = root;
          root = root.right;
        }
        return true;
  }
}