package arithmetic.linkedList;

public class addTwo {

    public static void main(String[] args) {
        int[] nums1 = {9, 9, 9, 9, 9, 9, 9};
        ListNode l1 = ListNode.getListNode(nums1);
        int[] nums2 = {9, 9, 9, 9};
        ListNode l2 = ListNode.getListNode(nums2);
        ListNode listNode = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remain = 0;
        int sum = 0;
        ListNode node = null;
        ListNode head = null;
        while (l1 != null || l2 != null || remain != 0) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if (node == null) {
                node = new ListNode(sum % 10);
                remain = sum >= 10 ? 1 : 0;
                head = node;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            } else {
                node.next = new ListNode((sum + remain) % 10);
                remain = (sum + remain) >= 10 ? 1 : 0;
                node = node.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
        }
        return head;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }

    ListNode dfs(ListNode l1, ListNode l2, int i) {
        if (l1 == null && l2 == null && i == 0) {
            return null;
        }
        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + i;
        ListNode node = new ListNode(sum % 10);
        node.next = dfs(l1 != null ? l1.next : null, l2 != null ? l2.next : null, sum / 10);
        return node;
    }

}
