package leetcode;
//岛问题
public class Island {
    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) return 0;
        int res = 0;
        int N = m.length;
        int M = m[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) { //只要发现了一个1，哪怕是单独的，也是一个岛了
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    //这个方法相当于一个阻塞方法，会一直是的上面的if语句不跳出，一旦跳出，就表示一个岛屿已经遍历结束
    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j]=0;  //必须对已经遍历过的1进行改值，否则会训话递归，直接栈溢出
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }

    public static void main(String[] args) {
        int[][] m={
                {0,1,0,0,0,0,0,0},
                {1,1,1,0,0,0,1,0},
                {0,1,0,0,0,0,1,0}
        };
        System.out.println(countIslands(m));
    }
}
