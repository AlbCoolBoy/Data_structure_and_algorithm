package datastruct.Graph;

import java.util.*;

/*拓扑排序是解决图中的一种问题
* 具体的实际应用是在实际工程开发中，会出现很多包之间的依赖情况
* 这时候就要确定包或者是各个工程的启动顺序，只有各个依赖工程的启动顺序正确，才能成功启动工程*/
public class TopologySort {
    public static List<Node> sortedTopological(Graph graph){
        HashMap<Node,Integer> inMap=new HashMap<Node,Integer>();
        Queue<Node> zeroInQueue=new LinkedList<Node>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node,node.in);
            if(node.in==0){
                zeroInQueue.add(node);
            }
        }
        List<Node> result=new ArrayList<>();
        while(!zeroInQueue.isEmpty())
        {
            Node cur=zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next,inMap.get(next)-1);  //上一个处理的节点指向的节点的入度减一
                if(inMap.get(next)==0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
/*算法描述：
* 创建一个记录每个节点的入度的表
* 如果入度为零就将节点加入队列中，然后弹出队列并将其产生的影响消除
* 消除产生的影响的意思是：将该节点指向的节点的入度减一，再将入度为零的节点入队列
* 周而复始，直到队列为空*/
