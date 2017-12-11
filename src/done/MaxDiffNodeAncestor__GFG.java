package done;

/**
 * Created by TAB on 9/7/17.
 */
public class MaxDiffNodeAncestor__GFG {

    static int maxDiff = Integer.MIN_VALUE;

    static int util3IntMin(int a, int b, int c) {
        return (a < b) ? Math.min(a, c) : Math.min(b, c);
    }

    //  function to find maximum difference between node and its ancestor
    static int findMinAndUpdateMaxDiff(Node root) {
        int min = Integer.MAX_VALUE;

        if (null == root)
            return min;
        else if (null != root.left && null != root.right)
            min = util3IntMin(root.getValue(), findMinAndUpdateMaxDiff(root.left), findMinAndUpdateMaxDiff(root.right));
        else if (null == root.left && null == root.right)
            return root.getValue();
        else if (null != root.left)
            min = util3IntMin(root.getValue(), findMinAndUpdateMaxDiff(root.left), Integer.MAX_VALUE);
        else if (null != root.right)
            min = util3IntMin(root.getValue(), findMinAndUpdateMaxDiff(root.right), Integer.MAX_VALUE);

        maxDiff = Math.max(maxDiff, root.getValue() - min);
        return min;
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Making above given diagram's binary tree
        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);

        tree.root.right = new Node(10);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);

        findMinAndUpdateMaxDiff(tree.root);

        System.out.println("Maximum difference between a node and its ancestor is : "
                + maxDiff);
    }
}

// A binary tree node has key, pointer to left
// and right child
class Node {
    private int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }

    public int getValue() {
        return this.value;
    }
}

class BinaryTree {
    Node root;
}
