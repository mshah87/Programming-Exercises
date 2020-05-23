/*

Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

    ae
   / \
  b   c
 /
d

*/

import java.util.LinkedList; 
import java.util.Queue; 

public class GoogleDeepestNode{

    public Node DeepestNode(Node root){

        if(root== null){
            return null;
        }

        if(root.left == null && root.right == null){
            return root;
        }

        Queue<Node> queue = new Queue<Node>();
        queue.add(root);

        Node temp = null;

        while(!queue.isEmpty){
            temp = queue.remove();

            if(temp.left!= null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        return temp;
    }
}