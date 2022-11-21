package datastruct.Graph;

import java.util.HashMap;
import java.util.HashSet;
//图的数据结构定义的方式有很多种，将一种使用熟练，在遇到实际问题的时候将给定的数据结构转换到最常使用的数据结构上
public class Graph {
    public HashMap<Integer,Node> nodes; //图的点集
    public HashSet<Edge> edges;         //图的边集

    public Graph(){
        nodes=new HashMap<>();
        edges=new HashSet<>();
    }
    //给一个例子：
    //如果给定的图的结构是一个矩阵，每一行的三个元素分别代表 边的起始点、边指向的终端节点、边的权重
    //可以使用下面的方式将其转换为自己的数据结构
    public static Graph createGraph(Integer[][] matrix){
        Graph graph=new Graph();        //实例化一个图对象
        for(int i=0;i<matrix.length;i++){
            Integer from=matrix[i][0];
            Integer to=matrix[i][1];
            Integer weight=matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));   //添加节点
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));       //添加节点
            }
            Node fromNode=graph.nodes.get(from);
            Node toNode=graph.nodes.get(to);
            Edge newEdge=new Edge(weight,fromNode,toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
    //图数据结构中的元素很多，创建的收要按照一定的顺序
    //先创建节点
    //如果两个节点之间有关系，则创建连接两个节点之间的边
    //将边添加到边集中
    //对相应节点的出度和入度数值进行调整
    //将节点和边都添加到实例化的图对象中
}
