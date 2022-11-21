package datastruct.BinaryTree;

import com.sun.xml.internal.ws.developer.Serialization;

import java.util.LinkedList;
import java.util.Queue;

/*二叉树的序列化和序列化*/
public class SerializationOfBinaryTrees {
    public static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            value=value;
        }
    }

    //对于给定的二叉树的头节点，根据先序递归的方式进行序列化
    public static Queue<String> preSerialize(Node head){
        Queue<String> queue = new LinkedList<>();
        pres(head, queue);
        return queue;
    }
    public static void pres(Node head,Queue<String> queue){
        if(head == null){
            queue.add(null);
        }else{
            queue.add(String.valueOf(head.value));
            pres(head.left,queue);
            pres(head.right,queue);
        }
    }

    /*将二叉树以字符串的形式序列化*/
    public static String serializeByPre(Node head){
        if(head == null){
            return "#_";
        }
        String result = head.value+"_";
        result+=serializeByPre(head.left);
        result+=serializeByPre(head.right);
        return result;
    }
    /*将字符串反序列 化为二叉树*/
    public static Node reconByPreString(String preStr){ //先进行字符串的处理
        String values[]= preStr.split("_");
        Queue<String> queue=new LinkedList<String>();
        for(int i=0;i<values.length;i++){
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }
    public static Node reconPreOrder(Queue<String> queue){
        String values=queue.poll();
        if(values.equals("#")){
            return null;
        }
        Node head=new Node(Integer.valueOf(values));
        head.left=reconPreOrder(queue);
        head.right=reconPreOrder(queue);
        return head;

    }
}
