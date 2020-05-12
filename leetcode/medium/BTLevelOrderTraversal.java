/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { //BFS: O(V + E)
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        
        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        
        if(root == null) return list;
     
        curr.offer(root);
    
        while(!curr.isEmpty()){
            TreeNode temp = curr.poll();
            if(temp.left != null){
                next.offer(temp.left);
            } 
            if(temp.right != null){
                next.offer(temp.right);
            }
            
            level.add(temp.val);
            
            if(curr.isEmpty()){
                curr = next;
                next = new LinkedList<TreeNode>(); 
                list.add(level);
                level = new ArrayList<Integer>();
            } 
        }
        return list;
    }
}