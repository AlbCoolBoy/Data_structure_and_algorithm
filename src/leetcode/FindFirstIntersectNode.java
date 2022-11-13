package leetcode;


public class FindFirstIntersectNode {
    public static void main(String[] args) {    //主方法用于进行算法的测试
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        Node node10 = new Node(10);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node6;

        //这个例子用于进行两个链表相交节点位置的判断
        node10.next=node5;



       if(getLoopNode(node1).getValue()==6){
           System.out.println("Nice!");
       }
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        public int getValue() {
            return value;
        }
    }

    //P7 22min
    /*环形链表的题，判断链表中是否有环，如果有的话，返回第一个如入环的节点*/
    public static Node getLoopNode(Node head) {
        /*下面这三种特殊情况还是不好一次性都想出来的*/
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head.next; //慢指针
        Node fast = head.next.next; //快指针

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    /*上述的方法非常的魔幻：
    * 1.先设置一个快指针和一个慢指针，让他们俩开始不相同
    * 2.然后快指针每次走两步，慢指针每次走一步
    * 3.当某一时刻快慢指针相等的时候，设置快指针为头节点
    * 4.然后快慢指针都哦每次走一步，当两者相等的时候，快慢指针所在的节点就是入环的节点
    * 这个方法的优点是空间复杂度为O（1）*/

    //p7 24min 两个无环链表返回第一个相交的节点
    public static Node getIntersectNode(Node head1,Node head2){
        if(head1==null||head2==null){
            return null;
        }
        Node cur1=head1;
        Node cur2=head2;
        int n=0;
        while(cur1.next!=null){
            n++;
            cur1= cur1.next;
        }
        while(cur2.next!=null){
            n--;
            cur2= cur2.next;
        }
        if(cur1!=cur2){ //如果两个链表的最后一个节点不相同，一定不相交
            return null;
        }
        cur1=n>0?head1:head2;
        cur2=cur1==head1?head2:head1;
        n=Math.abs(n);
        while(n!=0){
            n--;
            cur1= cur1.next;
        }
        while(cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;

    }

    //两个有环链表，返回第一个相交的节点
    public static Node bothLoop(Node head1,Node head2,Node loop1,Node loop2){
        Node cur1=null;
        Node cur2= null;
        if(loop1==loop2){   //第一种情况，两个有环链表再同一个位置进入循环
            cur1=head1;
            cur2=head2;
            int n=0;
            while(cur1!=loop1){
                n++;
                cur1=cur1.next;
            }while(cur2!=loop2){
                n--;
                cur2=cur2.next;
            }
            cur1=n>0?head1:head2;
            cur2=cur1==head1?head2:head1;
            n=Math.abs(n);
            while(n!=0){
                n--;
                cur1=cur1.next;     //?
            }
            while(cur1!=cur2){
                cur1= cur1.next;
                cur2= cur2.next;
            }
            return cur1;
        }else{
            cur1=loop1.next;
            while(cur1!=loop1){
                if(cur1==cur2){
                    return loop1;
                }
                cur1=cur1.next;
            }
            return null;
        }
    }




}
