package algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//并查集
public class UnionFindSets {
    public static class Node <V>{
        V value;

        public Node(V value) {
            value=value;
        }
    }

    public static class UnionFind<V>{
        public HashMap<V,Node<V>> nodes;
        public HashMap<Node<V>,Node<V>> parents;
        public HashMap<Node<V>,Integer> sizeMap;

        //接受给定的数据，并初始化所有的数据,最终结果就是每个节点都单独处于一个集合，每个节点的父节点都是自己
        public UnionFind(List<V> values){
            nodes=new HashMap<V,Node<V>>();
            parents=new HashMap<Node<V>,Node<V>>();
            sizeMap=new HashMap<Node<V>,Integer>();

            //这里的for循环实际上是创建了很多个集合，每个元素都处于一个单独的集合
            for (V cur : values) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur,node);
                parents.put(node,node);
                sizeMap.put(node,1);
            }
        }

        /**
         *
         * @param node 传递一个节点
         * @return     返回需要查找的node节点的代表性父节点，也就是一直向上回溯直到不能再回溯
         */
        public Node<V> findFather(Node<V> node){
            Stack<Node<V>> path=new Stack<>();
            while(node!=parents.get(node)){
                path.push(node);
                node=parents.get(node);
            }
            //结束上面之后能够对并查集进行一些优化，因为已经找到了代表性父节点
            //就将所有的属于该集合的元素都挂载在父节点下，防止出现链过长的情况乱搞
            while(!path.isEmpty()){
                parents.put(path.pop(),node);
            }
            return node;    //这时候已经回溯到代表性节点了
        }

        /**
         *
         * @param a
         * @param b
         * @return  判断上述两个元素是否属于同一个集合
         */
        public boolean isSameSet(V a,V b) {
            return findFather(nodes.get(a))==findFather(nodes.get(b));
        }

        public void union(V a,V b) {
            Node aHead=findFather(nodes.get(a));
            Node bHead=findFather(nodes.get(b));
            if (aHead!=bHead) {
                int aSetSize=sizeMap.get(aHead);
                int bSetSize=sizeMap.get(bHead);
                Node<V> big=aSetSize>bSetSize?aHead:bHead;
                Node<V> small = big==aHead?bHead:aHead;
                parents.put(small,big);
                sizeMap.put(big,aSetSize+bSetSize);
                sizeMap.remove(small);
            }
        }
    }



}
