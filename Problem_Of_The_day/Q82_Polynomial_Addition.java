package Problem_Of_The_day;

public class Q82_Polynomial_Addition {

    static class Node {
        int coeff;
        int pow;
        Node next;

        Node(int a, int b) {
            coeff = a;
            pow = b;
            next = null;
        }
    }

    // simple addition of linkedList based on decreasing order.
    public static Node addPolynomial(Node p1, Node p2) {
        Node root = new Node(-1, -1);
        Node pos = root;

        while (p1 != null && p2 != null) {
            if (p1.pow == p2.pow) {
                root.next = new Node(p1.coeff + p2.coeff, p1.pow);
                root = root.next;
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.pow > p2.pow) {
                root.next = new Node(p1.coeff, p1.pow);
                root = root.next;
                p1 = p1.next;
            } else {
                root.next = new Node(p2.coeff, p2.pow);
                root = root.next;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            root.next = new Node(p1.coeff, p1.pow);
            root = root.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            root.next = new Node(p2.coeff, p2.pow);
            root = root.next;
            p2 = p2.next;
        }

        return pos.next;
    }
}
