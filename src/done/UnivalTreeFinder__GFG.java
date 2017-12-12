package done;

public class UnivalTreeFinder__GFG {

    public static void main(String[] args) {

        // test case 1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println(counter(root, 0));

        // test case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.right.right = new TreeNode(5);

        System.out.println(counter(root2, 0));
    }

    private static int counter(TreeNode root, int count) {

        if (root == null) {
            return count;
        }

        if (root.left == null && root.right == null) {
            return count + 1;
        } else if (root.left == null && root.right.val == root.val) {
            return counter(root.right, count) + 1;
        } else if (root.right == null && root.left.val == root.val) {
            return counter(root.left, count) + 1;
        } else if (root.left != null && root.left.val == root.val && root.right.val == root.val) {
            return counter(root.left, count) + counter(root.right, count) + 1;
        } else {
            return counter(root.left, count) + counter(root.right, count);
        }

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
