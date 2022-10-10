package Linked_List;

public class Q9_Add_1_to_a_number_represented_as_linked_list {

    node head;

    public static class node {
        int data;
        node next;

        public node(int d) {
            data = d;
            next = null;
        }
    }

    public static node Add_one_to_LL(node head) {

        if (head == null) {
            return null;
        }

        // first reverse the list.

        node head2 = reverse(head);
        node temp = head2;

        while (temp != null) {
            // this condtion runs when for ex : 99999 comes.
            if (temp.data == 9 && temp.next == null) {
                temp.data = 10;
                break;
            } else if (temp.data == 9) { /// this runs when ex: 899 comes.
                temp.data = 0;
                temp = temp.next;
            } else {// this when element is less than 9 .
                temp.data = temp.data + 1;
                break;
            }

        }

        // again reverse the list and return it.

        node reverseNode = reverse(head2);

        return reverseNode;

    }

    public static node reverse(node head2) {

        node current = head2;
        node forward = null;
        node prev = null;
        while (current != null) {
            forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        return prev;
    }

}
