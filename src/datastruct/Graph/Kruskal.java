package datastruct.Graph;

/*生成最小生成树的算法
 * 算法思想，从最小的边开始，如果加上该边不会出现环，就将该边加上
 * 这个算法的难点是如何在加上一个边的时候就能判断出是否会出现环*/
/*该算法只适用于无向图*/

/*算法思想描述：
 * 先假设图中所有的点都是独立的，一个点处于一个独立的集合
 * 从最小的边开始，如果这条边连接的两个节点不在一个集合，就将这两个点合并在一个集合，然后该边可采用
 * 以此类推，如果遍历到的某一条边的两个节点已经出现在同一个集合中，就不采用*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*P7 1:21:59*/
public class Kruskal {
    public static class MySets {
        public HashMap<Node, List<Node>> setMap;    //这个表的目的是存储每个节点所在集合的节点

        public MySets(List<Node> nodes) {
            for (Node node : nodes) {
                List<Node> set = new ArrayList<Node>();
                set.add(node);
                setMap.put(node, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {    //判断该边的from和to是否在一个集合中
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);

            for (Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);
            }
        }
    }
}
