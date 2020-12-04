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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) { 
        // BFS since implementing queue using two stacks: O(V+E) time
        // https://www.youtube.com/watch?v=YsLko6sSKh8&ab_channel=VivekanandKhyade-AlgorithmEveryDay
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode curr = s1.pop();
                currLevel.add(curr.val);
                if(curr.left != null) s2.push(curr.left);
                if(curr.right != null) s2.push(curr.right);
            }
            result.add(currLevel);
            currLevel = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode curr = s2.pop();
                currLevel.add(curr.val);
                if(curr.right != null) s1.push(curr.right);
                if(curr.left != null) s1.push(curr.left);
            }
            if(!currLevel.isEmpty()) result.add(currLevel);
        }
        return result;
    }
}
