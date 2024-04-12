public class Exercise1 {

    //If the right node P is not null iteratate through the left side of the subtree rooted at the right of child P
    // to find the left most node

    public static class TreeNode
    {
        int val;
        TreeNode left, right;

        // Constructor initializing tree node value
        TreeNode(int val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static class BinaryTree
    {
        // The inOrderNext method to find the inorder successor of the given node p
        public TreeNode inorderNext(TreeNode root, TreeNode p)
        {
            if (p.right != null)
            {
                // If p has a right child return the leftmost node in the right subtree
                return findLeftmost(p.right);
            }
            else
            {
                // Traverses the tree to find the successor
                TreeNode successor = null;
                TreeNode current = root;
                while (current != null && current != p)
                {
                    if (p.val < current.val)
                    {
                        successor = current;
                        current = current.left;
                    }
                    else
                    {
                        current = current.right;
                    }
                }
                return successor;
            }
        }
        //=================================================================

        // Method to find the leftmost node in a subtree rooted at node
        private TreeNode findLeftmost(TreeNode node)
        {
            while (node.left != null)
            {
                node = node.left;
            }
            return node;
        }
        //=================================================================
    }


    // Main Method
    public static void main(String[] args)
    {

        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // Find the inorder successor of a given node
        TreeNode successor = tree.inorderNext(root, root.right.right);

        // Display the value of the inorder successor or "null" if there is no successor
        System.out.println("Inorder Successor of 6: " + (successor != null ? successor.val : "null"));
    }

}