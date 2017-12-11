package done;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 * As the following.
 */
public class LinkedListCycle__141__Easy {

    public static void main(String[] args) {

        ListNode head = new ListNode();
        ListNode junc = new ListNode();
        head.next = new ListNode();
        head.next.next = new ListNode();
        head.next.next.next = new ListNode();
        head.next.next.next.next = junc;
        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next = new ListNode();
        /* Case introduce a cycle */
        head.next.next.next.next.next.next.next = junc;
        /* End case introduce a cycle */

        System.out.println(hasCycle(head));

    }

    private static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.equals(fast)) {
                return true;
            }
        }

        return false;
    }

}

/**
 * Dummy done.ListNode. Only has pointer to next node, stores nothing in itself.
 */
class ListNode {
    ListNode next;

    ListNode() {
        next = null;
    }
}
