package datastruct.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*从指定出发点到后续每个出发点的最短路径
其中可以有权值路径为负数的边，但是不能有权值路径和为负数的有向环
* P9 2:01:10*/
public class Djkstra {
    public static HashMap<Node, Integer> dijkstra(Node from) {
        HashMap<Node, Integer> distanceMap = new HashMap<Node, Integer>();  //起始点到Node的距离
        distanceMap.put(from, 0);    //起始节点自己到自己的距离是0
        HashSet<Node> selectedNode = new HashSet<Node>();
        Node minNode = getMinDistanceUnselectedNode(distanceMap, selectedNode);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), edge.weight + distance));
                }
            }
            selectedNode.add(minNode);
            minNode = getMinDistanceUnselectedNode(distanceMap, selectedNode);
        }
        return distanceMap;
    }

    private static Node getMinDistanceUnselectedNode(
            HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNode
    ) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNode.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
