package arithmetic.linkedList;

import dataStruct.LinkedList;

import java.util.List;

public class plusOne {
    static int[]nums={1,2,3,4,5,6};
    static boolean allNine=true;
    public static void main(String[] args) {
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
        ListNode newHead=reverseByRecursion(head);
        while (newHead.next!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
//        backDate(head,false);
    }

    public static void backDate(LinkedList.listNode listNode, boolean added){
        if(listNode.data<9){
            allNine=false;
            if(added){
            backDate(listNode.next,true);
            backDate(listNode.next,false);
            }
        }
    }

    public static ListNode reverseByRecursion(ListNode node){
        if(node.next==null||node==null){
            return node;
        }
        ListNode nextNode=reverseByRecursion(node.next);
        node.next.next=node;
        node.next=null;
        return nextNode;
    }



     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
