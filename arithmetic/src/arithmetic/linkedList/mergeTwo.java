package arithmetic.linkedList;

public class mergeTwo {

    public static void main(String[] args) {
        int[] nums1={1,2,4,5,7};
        int[] nums2={1,3,4,9};
        ListNode listNode1 = ListNode.getListNode(nums1);
        ListNode listNode2 = ListNode.getListNode(nums2);
        ListNode node = mergeTwoLists(listNode1, listNode2);
        ListNode.printNode(node);
    }

    public static ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode node = (l1!=null&&l2!=null)?l1.val <= l2.val ? l1 : l2:new ListNode(l1==null?l2.val:l1.val);
        if(l1!=null&&l2!=null){
            node.next = mergeTwo(l1.val <= l2.val ? l1.next : l1, l1.val <= l2.val ? l2 : l2.next);
        }else {
            node.next=mergeTwo(l1==null?l1:l1.next,l2==null?l2:l2.next);
        }
        return node;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

}
