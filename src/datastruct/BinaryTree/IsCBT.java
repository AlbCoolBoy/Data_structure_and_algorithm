package datastruct.BinaryTree;

import java.util.LinkedList;

/*判断给定的二叉树是否是完全二叉树*/
/*思路：
 * 进行层序遍历，遇到下面几种情况直接返回false
 * 1：遍历到的当前的节点只有右孩子没有左孩子
 * 2：在第一个条件满足的情况下，如果出现一个节点的左右孩子不双全，则后续出现的节点都必须是叶子节点，否则返回false*/
public class IsCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static boolean isCBT(Node head) {
        boolean trigger = false;  //该变量最为一个触发器，一旦遇到某个节点的左右孩子不双全，该触发器就会被触发
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(head);
        Node l = null;
        Node r = null;
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                    (l == null && r != null)    //命中情况1
                            || (trigger && (l != null && r != null))    //命中情况2
            ){
                return false;
            }
            if(l!=null){
                queue.add(l);
            }
            if(r!= null){
                queue.add(r);
            }
            if(l== null||r== null){ //触发触发器
                trigger=true;
            }
        }
        return true;
    }
}
