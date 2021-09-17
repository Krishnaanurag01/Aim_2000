package Binary_Search_Tree;

/**
 * Q19_Find_median_of_BST_in_n_time_and_1_space
 */
public class Q19_Find_median_of_BST_in_n_time_and_1_space {

    Node root;

    public static class Node {

        int data;
        Node left, right;

        public Node(int d) {
            this.data = d;
        }

    }

    public void insert_node(int data) {
        root = insert_node(root, data);
    }

    public static Node insert_node(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data > data) {
            root.left = insert_node(root.left, data);
        } else {
            root.right = insert_node(root.right, data);
        }

        return root;
    }

    // takes o(n) time and o(1) space for calculating the size.

    public static int getSize(Node root) {
        if (root == null)
            return 0;

        int size = 0;
        Node curr = root;

        while (curr != null) {
            Node left = curr.left;

            if (left == null) {
                size++;
                curr = curr.right;
            } else {
                Node rightMost = getRightMost(left, curr);
                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                } else {
                    rightMost.right = null;

                    size++;

                    curr = curr.right;
                }
            }
        }

        return size;
    }

    // takes o(n) time and o(1) space for finding the median.

    public static int getMedian(Node root) {

        if (root == null)
            return 0;

        int count = getSize(root);  // finding the size of bst

        Node current = root; // making dummy node.

        int index = 0; // for stopping at the specific index.

        int ans = 0;

        Node prev = null;  // this will store the previous visited node.

        while (current != null) {
            Node left = current.left;

            if (left == null) {
                index++;

                if (count % 2 != 0 && index == (count + 1) / 2)   // this will run when count is odd.
                    return current.data;

                if (count % 2 == 0 && index == ((count) / 2) + 1) {  // and this run when count is even. so it will return the previous and current data average.
                    return (prev.data + current.data) / 2;
                }

                prev = current;  // updating the previous data.

                current = current.right; // moving right
            } else {
                Node rightMost = getRightMost(left, current); // getting the rightmost node.

                if (rightMost.right == null) {  // when right most is first visited.
                    rightMost.right = current;
                    current = current.left;
                } else {  // when already visited before.
                    rightMost.right = null;

                    prev = rightMost ;

                    index++;

                    if (count % 2 != 0 && index == (count + 1) / 2)
                        return current.data;

                    if (count % 2 == 0 && index == ((count) / 2) + 1) {
                        return (prev.data + current.data) / 2;
                    }


                    prev = current ;

                    current = current.right;

                }
            }
        }

        return ans;
    }

    private static Node getRightMost(Node node, Node root) {
        while (node.right != null && node.right != root) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {

        Q19_Find_median_of_BST_in_n_time_and_1_space tree = new Q19_Find_median_of_BST_in_n_time_and_1_space();

        tree.insert_node(5);
        tree.insert_node(3);
        tree.insert_node(2);
        tree.insert_node(4);
        tree.insert_node(7);
        tree.insert_node(6);
        tree.insert_node(8);
        tree.insert_node(9);

    
        System.out.println(  getMedian(tree.root)  );
    }
}