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
    public List<Double> averageOfLevels(TreeNode root) {
        //BFS
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        
        if(root == null) return result;
     
        level.offer(root);
    
        while(!level.isEmpty()){
            double sum = 0;
            int size = level.size();
            for(int i = 0; i<size; i++){
                TreeNode node = level.poll();
                sum+=node.val;
                if(node.left != null){
                    level.offer(node.left);
                } 
                if(node.right != null){
                    level.offer(node.right);
                }
            }
            result.add(sum/size);
        }
        return result;
    }
}