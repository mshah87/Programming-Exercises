
#102 - medium 


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
//use bfs

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null) {
            return list;
        }
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < queue.size(); i++){
                TreeNode temp = queue.remove();            
                level.add(temp.val);
                
                if(temp.left != null){
                    queue.add  temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            
            list.add(level);
        }
        
        return list;
    }
}
