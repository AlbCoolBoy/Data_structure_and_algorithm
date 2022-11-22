package datastruct.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//图的宽度优先与二叉树不同的是。二叉树不会有环，而图可能出现环
public class BFS {
    public static void BFS(Node node){
        if (node == null) {
            return ;
        }
        Queue<Node> queue = new LinkedList<Node>(); //宽度优先肯定是要使用队列的
        HashSet<Node> set=new HashSet<Node>();  //使用set集合是为了防止图中出现回环，不至于将节点重复遍历,set是一个很好的检查去重的机制
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            System.out.println(cur.value);
            for (Node next : node.nexts) {
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
