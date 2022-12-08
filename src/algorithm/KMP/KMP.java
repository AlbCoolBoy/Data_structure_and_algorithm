package algorithm.KMP;

//子串的包含问题
public class KMP {
    /**
     *
     * @param s1
     * @param s2
     * @return  返回值为-1表示没有找到匹配的
     */
    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < 1 || s1.length() < s2.length()) return -1;
        char []str1=s1.toCharArray();
        char []str2=s2.toCharArray();
        int x=0;
        int y=0;
        int []next=getNextArray(str2);  //获取next数组
        while(x<str1.length &&y<str2.length){
            if(str1[x]==str2[y]){   //两个字符匹配成功，都向后移动
                x++;
                y++;
            }else if(next[y]==-1){
                x++;
            }else{
                y=next[y];
            }
        }
        return y==str2.length?x-y:-1;
    }

    private static int[] getNextArray(char []str) {
        if(str.length==0) return new int[]{-1};
        int []next=new int[str.length];
        next[0]=-1;
        next[1]=0;
        int i=2;    //目前在哪个位置上求Next数组
        int cn=0;     //当前是哪个位置在和 i-1 进行比较
        while(i<next.length){
            if(str[i-1]==str[cn]){
                next[i++]=++cn;
            }else if(cn>0){
                cn=next[cn];
            }else{
                next[i++]=0;
            }
        }
        return next;
    }
}
