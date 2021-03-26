package arithmetic.linkedList;

public class swapPairs {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ListNode listNode = ListNode.getListNode(nums);
        ListNode listNode1 = swapPairs(listNode);
        ListNode.printNode(listNode1);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode head1 = head.next;
        if (head1 == null) {
            return head;
        }
        ListNode preNode = null;
        while (head != null) {
            if (head.next != null && head.next.next != null) {
                ListNode nextNode = head.next.next;
                if (preNode == null) {
                    preNode = head;
                } else {
                    preNode.next = head.next;
                }
                preNode = head;
                head.next.next = head;
                head.next = nextNode;
                head = nextNode;

            } else if (head.next != null && head.next.next == null) {
                if (preNode != null) {
                    preNode.next = head.next;
                }
                head.next.next = head;
                head.next = null;
                head = null;
            } else if (head.next == null) {
                preNode.next = head;
                head = null;
            }
        }
        return head1;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode rest = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(rest);
        return newHead;
    }
}
