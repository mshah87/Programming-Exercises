import com.sun.source.tree.BinaryTree;

/*
This problem was asked by LinkedIn.

Determine whether a tree is a valid binary search tree.

A binary search tree is a tree with two children, left and right, 
and satisfies the constraint that the key in the left child must be less than 
or equal to the root and the key in the right child must be greater than or equal to the root.
*/


//looks at each node once and narrows down max and min

public class LinkedinValidateBST {

    public static boolean isBST() {
        return ValidateBST(root, Integer.MIN_VALUE, INTEGER.MAX_VALUE);

    }

    public static boolean ValidateBST(Node node, int min, int max) {

        if (node == null) {
            return false;
        }

        if (node.val < min || node.val > max) {
            return false;
        }

        //traverses recursively 
        return (ValidateBST(node.left, min, node.val - 1) && ValidateBST(node, node.val + 1, max));
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(7);
        tree.root.left = new Node(3);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(12);

        if (tree.isBST()) {
            System.out.println("it is bst");
        } else {
            System.out.println("it's not a bst");
        }

    }
}