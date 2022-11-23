package algorithm.TrieTree;

/*前缀树，用于处理字符串问题
* P10 08:57*/
public class TrieTree {
    public static class TrieNode {   //前缀树的基本组成单元，前缀树的节点
        public int pass;            //再加前缀树的时候，当前节点到达过多少次,也就是节点被访问了多少次
        public int end;             //当前节点是否是一个字符串的结尾节点，如果是，是多少个字符串的结尾节点
        public TrieNode[] nexts;

        public TrieNode() {          //每次创建一个前缀树节点的时候都会将节点中的pass 和 end 初始化为0
            pass = 0;
            end = 0;
            //nexts[0]==null    表示没有走向a的路
            //nexts[0]!=null    表示有走向a的路
            //nexts[1]==null    表示没有走向b的路
            nexts = new TrieNode[26]; //假设只有26个小写字母
        }
    }


    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /*给定一个字符串，得出前缀树的创建*/
        public void insert(String word) {
            if (word == null) return;
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {           //没有指向某个字符的路
                    node.nexts[index] = new TrieNode();  //就创建一条
                }
                node = node.nexts[index];                //向后移动
                node.pass++;
            }
            node.end++; //for敲击循环结束代表
        }

        /*查询给定的字符串再之前加入过几次*/
        public int serach(String word){
            if(word==null){
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node=root;
            int index=0;
            for (int i = 0; i < chars.length; i++) {
                index=chars[i]-'a';
                if(node.nexts[index]==null){    //查询到某一步的时候，发现后面没有路了，说明根本就没有添加过这个单词，可以直接返回0
                    return 0;
                }
                node=node.nexts[index];
            }
            return node.end;
        }

        /*再前缀树中删除给定的字符串*/
        public void delete(String word){
            if(serach(word)!=0){        //只有前缀树中确实添加过word，才能删除
                char[] chars = word.toCharArray();
                TrieNode node=root;
                node.pass--;
                int index=0;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if(--node.nexts[index].pass==0){
                        node.nexts[index]=null;
                        return ;
                    }
                    node=node.nexts[index];
                }
                node.end--;
            }
        }
    }
}
