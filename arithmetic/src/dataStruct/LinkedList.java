package dataStruct;

public class LinkedList {
    public class listNode {
//        private Node pre;
        public listNode next;
        public int data;
        public listNode(int data, listNode next){
            this.next=next;
            this.data=data;
        }
    }
    public listNode getHead(){
        return head;
    }
    public LinkedList(int[] nums){
        if(nums.length>0){
            listNode data=head;
            for (int num : nums) {
                if(data==null){
                    listNode listNode =new listNode(num,null);
                    head= listNode;
                    data= listNode;
                }else {
                    listNode listNode =new listNode(num,null);
                    head.next= listNode;
                }
            }
        }
    }
    private listNode head=null;

    public listNode findByValue(int value){
        listNode listNode =head;
        while(listNode !=null&& listNode.data!=value){
             listNode = listNode.next;
        }
        return listNode;
    }
    public listNode findByIndex(int index){
        listNode listNode =head;
        int currentIndex=0;
        while (currentIndex!=index){
            listNode = listNode.next;
            currentIndex++;
        }
        return listNode;
    }

    public void insertAfter(listNode currentListNode, listNode newListNode){
        if(head==null){
            insertToHead(newListNode);
            return;
        }
        listNode nextListNode = currentListNode.next;
        if(nextListNode ==null){
            currentListNode.next= newListNode;
            return;
        }
        currentListNode.next= newListNode;
        newListNode.next= nextListNode;
    }

    public void insertBefore(listNode currentListNode, listNode newListNode){
        if(head==null){
            insertToHead(newListNode);
        }
        listNode listNode =head;
        while (listNode.next.data!= currentListNode.data&& listNode.next!=null){
            listNode = listNode.next;
        }
        listNode.next= newListNode;
        newListNode.next= currentListNode;
    }
    public void insertToHead(listNode listNode){
        head.data= listNode.data;
        head.next=null;
    }

    public listNode checkRing(){
        listNode listNodeOne =head;
        listNode listNodeTwo =head;
        while (listNodeOne !=null&& listNodeTwo.next!=null&& listNodeTwo.next.next!=null&& listNodeOne != listNodeTwo){
            listNodeOne = listNodeOne.next;
            listNodeTwo = listNodeTwo.next.next;
        }
        if(listNodeOne == listNodeTwo){
            return listNodeOne;
        }
        return listNodeOne;
    }

    public listNode getRingStart(){
        listNode meetListNode =checkRing();
        if(meetListNode ==null){
            return null;
        }
        listNode listNodeOne =head;
        listNode listNodeTwo = meetListNode;
        while (listNodeOne !=null&& listNodeTwo.next!=null&& listNodeTwo.next.next!=null){
            listNodeOne = listNodeOne.next;
            listNodeTwo = listNodeTwo.next;
        }
       return listNodeOne;
    }

    public listNode reverseByBackDate(listNode node){
        if(node.next==null||node==null){
            return node;
        }
        listNode pre=null;
        listNode cur=node;
        while (cur!=null){
            listNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
