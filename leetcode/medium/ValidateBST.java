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
      Stack<TreeNode> stack = new Stack<>();
      TreeNode leftChild = null;
      while(!stack.isEmpty() || root != null){
          while(root!=null){
              stack.push(root); // every left node is pretty much a parent
              root = root.left;
          }
          root = stack.pop();
          if(leftChild != null && root.val <= leftChild.val ) return false; // if parent less than leftchild
          leftChild = root;
          root = root.right;
      }
      return true;
  }
}
