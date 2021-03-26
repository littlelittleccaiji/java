package arithmetic.linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val,ListNode next) { this.val = val; this.next = next; }
    public static ListNode getListNode(int []nums){
        ListNode head=null;
        ListNode currentNode=null;
        for (int i=0;i<nums.length;i++){
            ListNode listNode=new ListNode(nums[i]);
            if(currentNode!=null){
                currentNode.next=listNode;
                currentNode=listNode;
            }else {
                currentNode=listNode;
                head=listNode;
            }
        }
        return head;
    }

    public static void printNode(ListNode listNode){
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
