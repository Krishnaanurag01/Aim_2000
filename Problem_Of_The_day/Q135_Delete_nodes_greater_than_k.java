package Problem_Of_The_day;

public class Q135_Delete_nodes_greater_than_k {

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public Node deleteNode(Node root, int k) {

        return helper(root, k);
    }

    Node helper(Node root, int k) {
        if (root == null)
            return root;

        if (root.data >= k)
            return helper(root.left, k);

        root.left = helper(root.left, k);
        root.right = helper(root.right, k);

        return root;
    }
}
