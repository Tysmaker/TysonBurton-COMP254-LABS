public class Exercise2 extends Exercise1 {
    //The Exercise 1 class already contains a Tree Node so, I just inherited from that class instead of repeating code

    //Runtime O(n)

    public static class BinaryTreeHeight
    {

        // Function to compute and print the elements and height of each of the subtree

        //Recurs left in the subtree then right in the subtree till it reaches its base case
        public static int printElementAndHeight(TreeNode root)
        {
            // Base case: empty subtree has height -1
            if (root == null) return -1;

            // Compute height of left side of the subtree
            int leftHeight = printElementAndHeight(root.left);
            // Compute height of right side of the subtree
            int rightHeight = printElementAndHeight(root.right);

            // Current height of the subtree
            int height = Math.max(leftHeight, rightHeight) + 1;

            // Prints both the element and height
            System.out.println("Element: " + root.val + ", Height: " + height);

            // Returns the height of current subtree
            return height;
        }
    }

    // Main method to test BinaryTreeHeight class
    public static void main(String[] args)
    {
        // Sample values for the binary tree
        TreeNode root = new TreeNode(14);
        root.left = new TreeNode(12);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(9);

        // Outputs the element and height of subtrees
        System.out.println("Element and Height of Subtrees:" + BinaryTreeHeight.printElementAndHeight(root));

    }
}